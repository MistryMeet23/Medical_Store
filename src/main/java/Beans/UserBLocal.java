/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import entity.Cart;
import entity.Category;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Usertable;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface UserBLocal {

    //Cart
    boolean insertcart(Integer userId, Integer cartTotal);

    boolean updatecart(Integer cartId, Integer userId, Integer cartTotal);

    boolean deletecart(Integer cartId);

    Cart getCartById(Integer cartId);

    //category
    Collection<Category> getAllCategorys();

    Category geCategoryById(Integer catId);

    //Order
    boolean insertorder(Integer userId, Integer productId, Integer quantity, String orderStatus, Integer orderTotal);

    //boolean updateorder(Integer userId,Integer productId ,Integer orderId, Integer quantity, String orderStatus, Integer orderTotal);
    boolean deleteorder(Integer orderId, Integer userId, Integer productId);

    Ordermaster geOrdertableById(Integer orderId);

    //Product Review
    boolean insertprorw(String proRating, String proReview, Date addedDate, Integer proId, Integer userId);

    boolean updateprorw(Integer reviewId, String proRating, String proReview, Date addedDate, Integer proId, Integer userId);

    boolean deleteprorw(Integer reviewId, Integer proId, Integer userId);

    Productreview getProductreviewById(Integer reviewId);

    //Product
    Collection<Products> getAllPro();

    Products getProductsById(Integer productId);

    //User
    boolean insertuser(String userEmail, String name, String userNumber, String userPassword);

    boolean updateuser(Integer userId, String userEmail, String name, String userNumber, String userPassword);

    Usertable getUsertableById(Integer userId);

    Integer getIdByusername(String Username);

    //Cart
    boolean addProductToCart(Integer userId, Integer prodId, Integer quantity);

    boolean removeProductFromCart(Integer userId, Integer prodId);

    Collection<Cart> viewCart(Integer userId);

    boolean placeOrder(Integer userId);
}
