/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import entity.Brandtable;
import entity.Cart;
import entity.Category;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Rolemaster;
import entity.Usertable;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminB implements AdminBLocal {

    @PersistenceContext(unitName = "pharmacy_P")
    EntityManager em;

    @Override
    public boolean insertbrand(String brandName, String contactNo, String website, String email, String logo) {

        try {
            Brandtable brand = new Brandtable();
            brand.setBrandName(brandName);
            brand.setContactNo(contactNo);
            brand.setWebsite(website);
            brand.setEmail(email);
            brand.setLogo(logo);

            em.persist(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deletebrand(Integer brandId) {

        try {
            Brandtable brand = em.find(Brandtable.class, brandId);
            if (brand != null) {
                em.remove(brand);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updatebrand(Integer brandId, String brandName, String contactNo, String website, String email) {

        try {
            Brandtable brand = em.find(Brandtable.class, brandId);
            if (brand != null) {
                brand.setBrandName(brandName);
                brand.setContactNo(contactNo);
                brand.setWebsite(website);
                brand.setEmail(email);

                em.merge(brand);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Collection<Brandtable> getAllBrand() {

        Collection<Brandtable> brnd = em.createNamedQuery("Brandtable.findAll").getResultList();
        return brnd;

    }

    @Override
    public Brandtable getBrandtableById(Integer brandId) {

        Brandtable brd = em.find(Brandtable.class, brandId);
        return brd;

    }

    @Override
    public Collection<Cart> getAllCart() {

        Collection<Cart> ct = em.createNamedQuery("Cart.findAll").getResultList();
        return ct;

    }

    @Override
    public Cart getCartById(Integer cartId) {

        Cart crt = em.find(Cart.class, cartId);
        return crt;

    }

    @Override
    public boolean insertcat(String catName) {

        try {
            Category cat = new Category();
            cat.setCatName(catName);
            em.persist(cat);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteccat(Integer catId) {

        try {
            Category cat = em.find(Category.class, catId);
            if (cat != null) {
                em.remove(cat);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updatecat(Integer catId, String catName) {

        try {
            Category cat = em.find(Category.class, catId);
            if (cat != null) {
                cat.setCatName(catName);
                em.merge(cat);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Collection<Category> getAllCat() {

        Collection<Category> cat = em.createNamedQuery("Category.findAll").getResultList();
        return cat;

    }

    @Override
    public Category geCategoryById(Integer catId) {

        Category ct = em.find(Category.class, catId);
        return ct;

    }

    @Override
    public Collection<Ordermaster> getAllOrder() {

        Collection<Ordermaster> ord = em.createNamedQuery("Ordermaster.findAll").getResultList();
        return ord;

    }

    @Override
    public Ordermaster geOrdertableById(Integer orderId) {

        Ordermaster ot = em.find(Ordermaster.class, orderId);
        return ot;

    }

    @Override
    public Collection<Productreview> getAllProductReviews() {

        Collection<Productreview> prdrw = em.createNamedQuery("Productreview.findAll").getResultList();
        return prdrw;

    }

    @Override
    public Productreview getProductreviewById(Integer reviewId) {

        Productreview pr = em.find(Productreview.class, reviewId);
        return pr;
    }

    @Override
    public boolean insertpro(String proName, String proDescription, Date expDate, Date manDate, Integer prostock, String proImg, Integer proPrice, Integer catId, Integer brandId) {

        try {
            Products prod = new Products();
            Category cat = em.find(Category.class, catId);
            Brandtable brd = em.find(Brandtable.class, brandId);
            Collection<Products> pc = cat.getProductsCollection();
            Collection<Products> pb = brd.getProductsCollection();

            prod.setProName(proName);
            prod.setProDescription(proDescription);
            prod.setExpDate(expDate);
            prod.setManDate(manDate);
            prod.setProstock(prostock);
            prod.setProImg(proImg);
            prod.setProPrice(proPrice);
            prod.setCatId(cat);
            prod.setBrandId(brd);
            pc.add(prod);
            pb.add(prod);

            cat.setProductsCollection(pc);
            brd.setProductsCollection(pb);

            em.persist(prod);
            em.merge(cat);
            em.merge(brd);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updatepro(Integer productId, String proName, String proDescription, Date expDate, Date manDate, Integer prostock,Integer proPrice, Integer catId, Integer brandId) {

        try {
            Products prod = em.find(Products.class, productId);
            prod.setProName(proName);
            prod.setProDescription(proDescription);
            prod.setExpDate(expDate);
            prod.setManDate(manDate);
            prod.setProstock(prostock);
           
            prod.setProPrice(proPrice);
            prod.setCatId(em.find(Category.class, catId));
            prod.setBrandId(em.find(Brandtable.class, brandId));

            Products mergep = em.merge(prod);
            if (mergep != null) {
                System.out.println("Updation Successfully!!");
                return true;
            } else {
                System.out.println("Updation fail!!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletepro(Integer proId, Integer catId, Integer brandId) {

        Products prod = em.find(Products.class, proId);
        Category cat = em.find(Category.class, catId);
        Brandtable brd = em.find(Brandtable.class, brandId);
        Collection<Products> pc = cat.getProductsCollection();
        Collection<Products> pb = brd.getProductsCollection();

        if (pc.contains(prod) || pb.contains(prod)) {
            em.remove(prod);
        }
        return true;
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

    @Override
    public Collection<Usertable> getAllUsertables() {

        Collection<Usertable> ut = em.createNamedQuery("Usertable.findAll").getResultList();
        return ut;
    }

    @Override
    public Usertable getUsertableById(Integer userId) {

        Usertable ut = em.find(Usertable.class, userId);
        return ut;

    }

    @Override
    public boolean insertrole(String role) {
        if (role == null) {
            throw new IllegalArgumentException("Please Enter all feild");
        } else {
            Rolemaster rolem = new Rolemaster();
            rolem.setRole(role);
            em.persist(rolem);
        }
        return true;
    }

    @Override
    public Collection<Rolemaster> getAllrole() {
        Collection<Rolemaster> rolem = em.createNamedQuery("Rolemaster.findAll").getResultList();
        return rolem;
    }

    @Override
    public Rolemaster getroleById(Integer roleid) {
        Rolemaster role = em.find(Rolemaster.class, roleid);
        return role;
    }
}
