/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
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
import javax.ejb.Local;

@Local
public interface AdminBLocal {

    //Brand
    boolean insertbrand(String brandName, String contactNo, String website, String email, String logo);

    boolean deletebrand(Integer brandId);

    boolean updatebrand(Integer brandId, String brandName, String contactNo, String website, String email);

    Collection<Brandtable> getAllBrand();

    Brandtable getBrandtableById(Integer brandId);

    //Cart
    Collection<Cart> getAllCart();

    Cart getCartById(Integer cartId);

    //category
    boolean insertcat(String catName);

    boolean deleteccat(Integer catId);

    boolean updatecat(Integer catId, String catName);

    Collection<Category> getAllCat();

    Category geCategoryById(Integer catId);

    //Order
    Collection<Ordermaster> getAllOrder();

    Ordermaster geOrdertableById(Integer orderId);

    //ProductReview
    Collection<Productreview> getAllProductReviews();

    Productreview getProductreviewById(Integer reviewId);

    //Product
    boolean insertpro(String proName, String proDescription, Date expDate, Date manDate, Integer prostock, String proImg, Integer proPrice, Integer catId, Integer brandId);

    boolean updatepro(Integer productId, String proName, String proDescription, Date expDate, Date manDate, Integer prostock,  Integer proPrice, Integer catId, Integer brandId);

    boolean deletepro(Integer proId, Integer catId, Integer brandId);

    Collection<Products> getAllPro();

    Products getProductsById(Integer productId);

    //Role Master
    boolean insertrole(String role);

    Collection<Rolemaster> getAllrole();

    Rolemaster getroleById(Integer roleid);

    //UserTable
    Collection<Usertable> getAllUsertables();

    Usertable getUsertableById(Integer userId);
}
