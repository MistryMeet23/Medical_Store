/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import entity.Cart;
import entity.Category;
import entity.Orderdetail;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Rolemaster;
import entity.Usertable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author mistr
 */
@Stateless
public class UserB implements UserBLocal {

    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare pbc;

    @PersistenceContext(unitName = "pharmacy_P")
    EntityManager em;

    @Override
    public boolean insertcart(Integer userId, Integer cartTotal) {
        try {
            Cart cart = new Cart();
            Usertable user = em.find(Usertable.class, userId);

            cart.setCarttotal(cartTotal);
            cart.setUserId(user);

            user.getCartCollection().add(cart);

            em.persist(cart);
            em.merge(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatecart(Integer cartId, Integer userId, Integer cartTotal) {
        try {
            Cart cart = em.find(Cart.class, cartId);
            if (cart != null) {
                cart.setCarttotal(cartTotal);
                em.merge(cart);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletecart(Integer cartId) {
        try {
            Cart cart = em.find(Cart.class, cartId);
            if (cart != null) {
                em.remove(cart);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Cart getCartById(Integer cartId) {

        Cart cr = em.find(Cart.class, cartId);
        return cr;

    }

    @Override
    public Collection<Category> getAllCategorys() {

        Collection<Category> ct = em.createNamedQuery("Category.findAll").getResultList();
        return ct;

    }

    @Override
    public Category geCategoryById(Integer catId) {

        Category cat = em.find(Category.class, catId);
        return cat;
    }

    @Override
    public boolean insertprorw(String proRating, String proReview, Date addedDate, Integer proId, Integer userId) {
        try {
            Productreview prw = new Productreview();
            Usertable ustb = em.find(Usertable.class, userId);
            Products pro = em.find(Products.class, proId);
            Collection<Productreview> pr = pro.getProductreviewCollection();
            Collection<Productreview> us = ustb.getProductreviewCollection();

            prw.setProRating(proRating);
            prw.setProReview(proReview);
            prw.setAddedDate(new java.util.Date()); // Assuming addedDate is a date
            prw.setProId(pro);
            prw.setUserId(ustb);

            pr.add(prw);
            us.add(prw);
            ustb.setProductreviewCollection(pr);
            em.persist(prw);
            em.merge(ustb);
            em.merge(pro);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateprorw(Integer reviewId, String proRating, String proReview, Date addedDate, Integer proId, Integer userId) {
        try {
            Productreview prw = em.find(Productreview.class, reviewId);
            Usertable ustb = em.find(Usertable.class, userId);
            Products pro = em.find(Products.class, proId);
            Collection<Productreview> pr = pro.getProductreviewCollection();
            Collection<Productreview> us = ustb.getProductreviewCollection();

            if (pr.contains(prw) || us.contains(prw)) {

                prw.setReviewId(reviewId);
                prw.setProRating(proRating);
                prw.setProReview(proReview);
                prw.setProId(pro);
                prw.setUserId(ustb);

                Productreview mergeprrw = em.merge(prw);
                if (mergeprrw != null) {
                    System.out.println("Successfully merged");
                    return true;
                } else {
                    System.out.println("failure");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteprorw(Integer reviewId, Integer proId, Integer userId) {
        Productreview prw = em.find(Productreview.class, reviewId);
        Usertable ustb = em.find(Usertable.class, userId);
        Products pro = em.find(Products.class, proId);
        Collection<Productreview> pr = pro.getProductreviewCollection();
        Collection<Productreview> us = ustb.getProductreviewCollection();

        if (pr.contains(prw) || us.contains(prw)) {
            em.remove(prw);
            return true;
        }
        return false;
    }

    @Override
    public Productreview getProductreviewById(Integer reviewId) {
        Productreview prw = em.find(Productreview.class, reviewId);
        return prw;
    }

    @Override
    public Collection<Products> getAllPro() {
        Collection<Products> prod = em.createNamedQuery("Products.findAll").getResultList();
        return prod;
    }

    @Override
    public Products getProductsById(Integer productId) {

        Products prod = em.find(Products.class, productId);
        return prod;
    }

//    @Override
//    public boolean insertuser(String userEmail, String name, String userNumber, String userPassword) {
//        try {
//            if (userEmail == null || name == null || userPassword == null || userNumber == null) {
//                throw new IllegalArgumentException("Please Enter all fields");
//            } else {
//                Rolemaster role = em.find(Rolemaster.class, 1);
//                Collection<Usertable> um = role.getUsertableCollection();
//
//                // Hashing Password
//                pb = new Pbkdf2PasswordHashImpl();
//                pbc = new PasswordHashCompare();
//
//                String enc = pb.generate(userPassword.toCharArray());
//
//                Usertable user = new Usertable();
//                user.setUserEmail(userEmail);
//                user.setName(name);
//                user.setUserPassword(enc);
//                user.setUserNumber(userNumber);
//                user.setRoleid(role);
//                System.out.println(role);
//                System.out.println(user.getName());
//                System.out.println(user.getUserEmail());
//                System.out.println(enc);
//                System.out.println(user.getUserNumber());
//                um.add(user);
//                role.setUsertableCollection(um);
//                em.persist(user);
//                em.merge(role);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    @Override
    public boolean insertuser(String userEmail, String name, String userNumber, String userPassword) {
        try {
            if (userEmail == null || name == null || userPassword == null || userNumber == null) {
                throw new IllegalArgumentException("Please provide all required fields.");
            }

            Rolemaster role = em.find(Rolemaster.class, 1);
            Collection<Usertable> um = role.getUsertableCollection();

            // Hashing Password
            pb = new Pbkdf2PasswordHashImpl();
            pbc = new PasswordHashCompare();
            String enc = pb.generate(userPassword.toCharArray());

            Usertable user = new Usertable();
            user.setUserEmail(userEmail);
            user.setName(name);
            user.setUserPassword(enc);
            user.setUserNumber(userNumber);
            user.setRoleid(role);

            um.add(user);
            role.setUsertableCollection(um);
            em.persist(user);
            em.merge(role);

            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateuser(Integer userId, String userEmail, String name, String userNumber, String userPassword) {
        try {
            Usertable ut = em.find(Usertable.class, userId);
            if (ut != null) {
                Rolemaster rm = em.find(Rolemaster.class, 1);
                ut.setName(name);
                ut.setUserEmail(userEmail);
                ut.setUserNumber(userNumber);
                ut.setUserPassword(userPassword);
                em.merge(ut);
                return true;
            } else {
                System.out.println("User not found");
                return false;
            }
        } catch (Exception e) {
            // Handle specific exceptions and log them
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usertable getUsertableById(Integer userId) {
        Usertable ut = em.find(Usertable.class, userId);
        return ut;
    }

    @Override
    public Integer getIdByusername(String Username) {

        try {
            Query query = em.createQuery("SELECT u.userId FROM Usertable u WHERE u.name = :name");
            query.setParameter("name", Username);

            Object result = query.getSingleResult();

            if (result != null) {
                return (Integer) result;
            }
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log or rethrow)
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertorder(Integer userId, Integer productId, Integer quantity, String orderStatus, Integer orderTotal) {
        try {
            Ordermaster orms = new Ordermaster();

            Products pro = em.find(Products.class, productId);
            Usertable ut = em.find(Usertable.class, userId);

            Collection<Ordermaster> userm = ut.getOrdermasterCollection();
            orms.setUserId(ut);
            Date od = new Date();
            orms.setQuantity(quantity);
            orms.setOrderDate(od);
            orms.setOrderStatus(orderStatus);
            orms.setOrderTotal(orderTotal);

            ut.setOrdermasterCollection(userm);
            em.persist(orms);
            em.merge(pro);
            em.merge(ut);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//    @Override
//    public boolean updateorder(Integer userId, Integer productId, Integer orderId, Integer quantity, String orderStatus, Integer orderTotal) {
//        try {
//
//            Ordermaster orms = em.find(Ordermaster.class, orderId);
//            Usertable ustb = em.find(Usertable.class, userId);
//            Products pro = em.find(Products.class, productId);
//
//            if (ustb.getOrdermasterCollection().contains(orms)) {
//
//                orms.setProid(pro);
//                orms.setUserId(ustb);
//                orms.setQuantity(quantity);
//                
//                Date od = new Date();
//                orms.setOrderDate(od);
//                orms.setOrderStatus(orderStatus);
//                orms.setOrderTotal(orderTotal);
//
//                // Merge the Ordermaster entity
//                Ordermaster mergeord = em.merge(orms);
//
//                // Check if the merge was successful
//                if (mergeord != null) {
//                    System.out.println("Order successfully updated");
//                    return true;
//                } else {
//                    System.out.println("Failed to update order");
//                    return false;
//                }
//            } else {
//                System.out.println("Order not found in user's collection");
//                return false;
//            }
//        } catch (Exception e) {
//            // Log the exception for debugging purposes
//            e.printStackTrace();
//            System.out.println("Exception occurred during order update");
//            return false;
//        }
//    }

    @Override
    public boolean deleteorder(Integer orderId, Integer userId, Integer productId) {

        try {
            Ordermaster ord = em.find(Ordermaster.class, orderId);
            Usertable ustb = em.find(Usertable.class, userId);
            Collection<Ordermaster> od = ustb.getOrdermasterCollection();

            if (od.contains(ord)) {
                em.remove(ord);
                return true;
            } else {

                System.out.println("Order not found in user's collection");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public Ordermaster geOrdertableById(Integer orderId) {

        Ordermaster om = em.find(Ordermaster.class, orderId);
        return om;
    }

    @Override
    public boolean addProductToCart(Integer userId, Integer prodId, Integer quantity) {
        try {
            Products product = em.find(Products.class, prodId);
            Usertable user = em.find(Usertable.class, userId);

            if (product != null && product.getProstock() >= quantity && user != null) {
                Cart cart = new Cart();

                cart.setUserId(user);
                cart.setProdId(product);
                cart.setQuantity(quantity);
                cart.setCarttotal((int) (quantity * product.getProPrice()));
                em.persist(cart);

            } else {
                System.err.println("Eather Email,Productid or Quantity is null");
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeProductFromCart(Integer userId, Integer prodId) {
        try {
            Products product = em.find(Products.class, prodId);
            Usertable user = em.find(Usertable.class, userId);

            if (user == null) {
                throw new IllegalArgumentException("User Not Found!!!");
            } else {
                TypedQuery<Cart> query = em.createQuery(
                        "SELECT c FROM Cart c WHERE c.userId = :user AND c.prodId = :prodId", Cart.class);
                query.setParameter("user", user);
                query.setParameter("prodId", product);

                List<Cart> carts = query.getResultList();

                if (!carts.isEmpty()) {
                    Cart productInCart = carts.get(0);
                    em.remove(productInCart);
                    System.out.println("Product removed from the user's cart.");
                } else {
                    System.out.println("Product not found in the user's cart.");
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Collection<Cart> viewCart(Integer userId) {
        try {
            if (userId == null) {
                throw new IllegalArgumentException("Invalid Id!!!");
            }
            Usertable user = (Usertable) em.find(Usertable.class, userId);
            if (user == null) {
                throw new IllegalArgumentException("Usermaster with Id " + userId + " not found!");
            }

            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.userId = :user", Cart.class);
            query.setParameter("user", user);
            Collection<Cart> result = query.getResultList();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean placeOrder(Integer userId) {
        try {

            Usertable user = em.find(Usertable.class, userId);
            System.out.println(userId);
            TypedQuery<Cart> cq = em.createQuery("SELECT c FROM Cart c WHERE c.userId = :user", Cart.class);

            cq.setParameter("user", user);
            Collection<Cart> cart = cq.getResultList();
            int totalAmount = 0;
            System.out.println("after get carts");

            if (!cart.isEmpty()) {

                Ordermaster om = new Ordermaster();
                om.setUserId(user);
                om.setOrderDate(new Date());
                om.setOrderStatus("Pending");

                for (Cart crt : cart) {
                    Products pro = em.find(Products.class,crt.getProdId().getProId());
                    System.out.println(crt.getCarttotal());
                    if (pro != null) {

                        int prototal = crt.getCarttotal() * crt.getQuantity();
                        int stock = pro.getProstock() - crt.getQuantity();

                        pro.setProstock(stock);
                        totalAmount += prototal;
                        Orderdetail od = new Orderdetail();

                        od.setUId(user);
                        od.setProdId(pro);
                        od.setProdName(crt.getProdId().getProName());
                        od.setQuantity(crt.getQuantity());
                        od.setProdPrice(prototal);

                        //remove from cart
                        od.setOmId(om);
//                        removeProductFromCart(user.getUserId(), pro.getProId());

                        em.persist(od);
                        em.merge(pro);
                    } else {
                        System.out.println("Product Null");
                    }
                }
                om.setOrderTotal(totalAmount);
                em.persist(om);
            } else {
                System.out.println("Cart Is getting null");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
