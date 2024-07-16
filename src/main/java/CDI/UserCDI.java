/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDI;

import Beans.UserBLocal;
import Client.UserC;
import entity.Brandtable;
import entity.Cart;
import entity.Category;
import entity.Productreview;
import entity.Products;
import entity.Rolemaster;
import entity.Usertable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mistr
 */
@Named(value = "userCDI")
//@SessionScoped
@RequestScoped
public class UserCDI implements Serializable {

    @Inject
    private UserBLocal abl;

    Response rs;
    UserC uc;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(false);

    Integer usersession = (Integer) session.getAttribute("User");

    @PersistenceContext(unitName = "pharmacy_P")
    EntityManager em;

    //User
    Collection<Usertable> usertables;
    GenericType<Collection<Usertable>> gUS;
    Usertable ut = new Usertable();
    private String userEmail, name, userPassword, userNumber;

    //Role
    Collection<Rolemaster> rolem;
    GenericType<Collection<Rolemaster>> grm;
    Rolemaster rm = new Rolemaster();
    private Integer roleid;

    //Product
    Collection<Products> products;
    GenericType<Collection<Products>> gproducts;
    Products prd = new Products();
    private Part file;
    private String proName, proDescription, proImg;
    private Date expDate, manDate;
    private Integer proPrice, catId, brandId, proid;

    //Brand
    Collection<Brandtable> brandtables;
    GenericType<Collection<Brandtable>> gbrd;
    Brandtable brdtb = new Brandtable();
    private String BrandName;

    //Category
    Collection<Category> category;
    GenericType<Collection<Category>> gcategory;
    Category cat = new Category();
    private String CatName;

    //Review
    Collection<Productreview> pr;
    GenericType<Collection<Productreview>> gpr;
    Productreview prdpr = new Productreview();
    private Date addedDate;
    private Integer reviewId, proId, userId;
    private String proRating, proReview;

    //cart
    Cart ct = new Cart();
    Integer totalqty;
    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;
//    private String sprodId;

    public UserCDI() {

        roleid = 1;
        uc = new UserC();

        //User
        usertables = new ArrayList<>();
        gUS = new GenericType<Collection<Usertable>>() {
        };

        //role
        rolem = new ArrayList<>();
        grm = new GenericType<Collection<Rolemaster>>() {
        };

        //Product
        products = new ArrayList<>();
        gproducts = new GenericType<Collection<Products>>() {
        };

        //Category
        category = new ArrayList<>();
        gcategory = new GenericType<Collection<Category>>() {
        };

        //Brand
        brandtables = new ArrayList<>();
        gbrd = new GenericType<Collection<Brandtable>>() {
        };

        //Review
        pr = new ArrayList<>();
        gpr = new GenericType<Collection<Productreview>>() {
        };

        cart = new ArrayList<>();
        gcart = new GenericType<Collection<Cart>>() {
        };
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public UserC getUc() {
        return uc;
    }

    public void setUc(UserC uc) {
        this.uc = uc;
    }

    public Usertable getUt() {
        return ut;
    }

    public void setUt(Usertable ut) {
        this.ut = ut;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Rolemaster getRm() {
        return rm;
    }

    public void setRm(Rolemaster rm) {
        this.rm = rm;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Products getPrd() {
        return prd;
    }

    public void setPrd(Products prd) {
        this.prd = prd;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getManDate() {
        return manDate;
    }

    public void setManDate(Date manDate) {
        this.manDate = manDate;
    }

    public Integer getProPrice() {
        return proPrice;
    }

    public void setProPrice(Integer proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public Brandtable getBrdtb() {
        return brdtb;
    }

    public void setBrdtb(Brandtable brdtb) {
        this.brdtb = brdtb;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public Productreview getPrdpr() {
        return prdpr;
    }

    public void setPrdpr(Productreview prdpr) {
        this.prdpr = prdpr;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProRating() {
        return proRating;
    }

    public void setProRating(String proRating) {
        this.proRating = proRating;
    }

    public String getProReview() {
        return proReview;
    }

    public void setProReview(String proReview) {
        this.proReview = proReview;
    }

    public Integer getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Integer totalqty) {
        this.totalqty = totalqty;
    }

    //User
    public String insertuser() {

        this.ut.setName(name);
        this.ut.setUserEmail(userEmail);
        this.ut.setUserNumber(userNumber);

        this.ut.setUserPassword(userPassword);

        System.out.println(name);
        System.out.println(userEmail);
        System.out.println(userPassword);
        System.out.println(userNumber);
        uc.insertuser(ut);

        return "Login.jsf?faces-redirect=true";
    }

    //Product
    public Collection<Products> getAllPro() {
        rs = uc.getAllPro(Response.class);
        products = rs.readEntity(gproducts);
        return products;
    }

    public String getProductsById(Products products) {
        this.prd = products;
        return "singleshop.jsf";
    }

    //Order master
    public String getombyid(String proId, Integer qty) {

        rs = uc.getProductsById(Response.class, proId);
        GenericType<Products> pro = new GenericType<Products>() {
        };

        Products p = rs.readEntity(pro);
        this.setProId(p.getProId());
        this.setProDescription(p.getProDescription());
        this.setProName(p.getProName());
        this.setProPrice(p.getProPrice());
        this.setProImg(p.getProImg());
        this.setExpDate(p.getExpDate());
        this.setManDate(p.getManDate());
        this.setBrandName(p.getBrandId().getBrandName());
        this.setCatName(p.getCatId().getCatName());

        System.out.println(p.getProName());

        return "cart.jsf";
    }

    //Review
    public String insertprorw(String proId, String userId) {

        prdpr.setProRating(proRating);
        prdpr.setProReview(proReview);
        prdpr.setAddedDate(addedDate);

        String pro = proId.toString();
        String user = userId.toString();

        uc.insertprorw(prdpr, proId, userId);
        return "proreview.jsf?faces-redirect=true";
    }

    //Cart
    public Collection<Cart> getAllCart() {
        String uids = usersession.toString();
        System.out.println("USer:" + usersession);
        rs = uc.viewCart(Response.class, uids);
        cart = rs.readEntity(gcart);
        return cart;
    }

    public String addToCart(String proId) {
        String totalqtys = totalqty.toString();
        String uids = usersession.toString();
        System.out.println("uid " + uids);
        System.out.println("proid " + proId);
        System.out.println("totolqty " + totalqtys);
        rs = uc.addToCart(uids, proId, totalqtys);
        if (rs != null) {
            System.out.println("Success");
            return "shop.jsf?faces-redirect=true";
        } else {
            System.out.println("fail");
            return "singleshop.jsf?faces-redirect=true";
        }
    }

    public String checkout() {
//        System.out.println(proid);
//        String uid = userId.toString();
//        rs = uc.placeOrder(uid);
//        abl.placeOrder(uid, proid);
        abl.placeOrder(usersession);

//        if (rs != null) {
//            System.out.println("Success");
//        } else {
//            System.out.println("fail");
//        }
        return "payment.jsf?faces-redirect=true";
    }

    //Review
    
    
}
