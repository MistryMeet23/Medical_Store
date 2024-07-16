/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDI;

import Client.AdminC;
import Client.UserC;
import entity.Brandtable;
import entity.Category;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Rolemaster;
import entity.Usertable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mistr
 */
@Named(value = "adminCDI")
@RequestScoped
public class AdminCDI {

    Response rs;
    AdminC ac;
    private String Brandname, Website, Email, Logo, ContactNo;
    private Part brdLogo;

    //Brand
    Collection<Brandtable> brand;
    GenericType<Collection<Brandtable>> gbrand;
    Brandtable brtb = new Brandtable();

    //Category
    Collection<Category> category;
    GenericType<Collection<Category>> gcategory;
    Category cat = new Category();
    private String CatName;
    private Integer CatId;

    //Product
    Collection<Products> products;
    GenericType<Collection<Products>> gproducts;
    Products prd = new Products();
    private Part file;
    private String proName, proDescription, proImg;
    private Date expDate, manDate;
    private Integer proPrice,  brandId, stock;
    private int proid;

    //Review
    Collection<Productreview> pr;
    GenericType<Collection<Productreview>> gpr;
    Productreview prdpr = new Productreview();

    //User
    Collection<Usertable> usertables;
    GenericType<Collection<Usertable>> gUS;
    Usertable ut = new Usertable();
    private String userEmail, name, userPassword, userNumber;
    private Integer roleid;

    //Role
    Collection<Rolemaster> rolem;
    GenericType<Collection<Rolemaster>> grm;
    Rolemaster rm = new Rolemaster();

    //Order
    Collection<Ordermaster> orm;
    GenericType<Collection<Ordermaster>> gorm;
    Ordermaster om = new Ordermaster();

    public AdminCDI() {

        ac = new AdminC();

        //order
        orm = new ArrayList<>();
        gorm = new GenericType<Collection<Ordermaster>>() {
        };

        //Brand
        brand = new ArrayList<>();
        gbrand = new GenericType<Collection<Brandtable>>() {
        };

        //Category
        category = new ArrayList<>();
        gcategory = new GenericType<Collection<Category>>() {
        };

        //Product
        products = new ArrayList<>();
        gproducts = new GenericType<Collection<Products>>() {
        };

        //Review
        pr = new ArrayList<>();
        gpr = new GenericType<Collection<Productreview>>() {
        };

        //User
        usertables = new ArrayList<>();
        gUS = new GenericType<Collection<Usertable>>() {
        };

        rolem = new ArrayList<>();
        grm = new GenericType<Collection<Rolemaster>>() {
        };
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }
    
    
    
    public String getLogo() {
        return Logo;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }

    public String getBrandname() {
        return Brandname;
    }

    public void setBrandname(String Brandname) {
        this.Brandname = Brandname;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public Brandtable getBrtb() {
        return brtb;
    }

    public void setBrtb(Brandtable brtb) {
        this.brtb = brtb;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    public Integer getCatId() {
        return CatId;
    }

    public void setCatId(Integer CatId) {
        this.CatId = CatId;
    }

    public Products getPrd() {
        return prd;
    }

    public void setPrd(Products prd) {
        this.prd = prd;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Productreview getPrdpr() {
        return prdpr;
    }

    public void setPrdpr(Productreview prdpr) {
        this.prdpr = prdpr;
    }

    public Ordermaster getOm() {
        return om;
    }

    public void setOm(Ordermaster om) {
        this.om = om;
    }

    public Usertable getUt() {
        return ut;
    }

    public void setUt(Usertable ut) {
        this.ut = ut;
    }

    public Rolemaster getRm() {
        return rm;
    }

    public void setRm(Rolemaster rm) {
        this.rm = rm;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Part getBrdLogo() {
        return brdLogo;
    }

    public void setBrdLogo(Part brdLogo) {
        this.brdLogo = brdLogo;
    }

    //Brand
    public Collection<Brandtable> getAllBrand() {
        rs = ac.getAllBrand(Response.class);
        brand = rs.readEntity(gbrand);
        return brand;
    }

    public String getBrandById(String id) {
        rs = ac.getBrandtableById(Response.class, id);
        GenericType<Brandtable> brands = new GenericType<Brandtable>() {
        };
        Brandtable b = rs.readEntity(brands);
        this.setBrandId(b.getBrandId());
        this.setBrandname(b.getBrandName());
        this.setContactNo(b.getContactNo());
        this.setEmail(b.getEmail());
        this.setWebsite(b.getWebsite());

        return "updatebrand.jsf";
    }

    public String insertbrand() {
        if (brdLogo != null) {
            try {
                String fileName = brdLogo.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "C:\\Users\\mistr\\Downloads\\Medical_Store\\Medical_Store\\src\\main\\webapp\\brandimg";
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = brdLogo.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                brtb.setBrandName(Brandname);
                brtb.setContactNo(ContactNo);
                brtb.setEmail(Email);
                brtb.setLogo(fileName);
                brtb.setWebsite(Website);

                System.out.println(brtb.getBrandName());
                System.out.println(brtb.getContactNo());
                System.out.println(brtb.getLogo());
                System.out.println(brtb.getEmail());
                System.out.println(brtb.getWebsite());

                rs = ac.insertbrand(brtb);

                if (rs != null) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }
        return "brand.jsf?faces-redirect=true";

    }

    public String updatebrand(String id) {
        this.brtb.setBrandName(Brandname);
        this.brtb.setContactNo(ContactNo);
        this.brtb.setWebsite(Website);
        this.brtb.setEmail(Email);

        rs = ac.updatebrand(brtb, id);
        if (rs != null) {
            System.out.println("success");
            return "brand.jsf?faces-redirect=true";
        } else {
            return "../index.jsf";
        }

    }

    public String deletebrand(Integer brandId) {
        String brd = brandId.toString();
        ac.deletebrand(brd);
        return "brand.jsf";
    }

    //order
    public Collection<Ordermaster> getAllOrdmst() {

        rs = ac.getAllOrder(Response.class);
        orm = rs.readEntity(gorm);
        return orm;

    }

    //Category
    public Collection<Category> getAllCat() {

        rs = ac.getAllCat(Response.class);
        category = rs.readEntity(gcategory);
        return category;
    }

    public String insertcat() {

        cat.setCatName(CatName);
        ac.insertcat(cat);
        return "category.xhtml?faces-redirect=true";
    }

    public String deletecat(Integer catId) {
        String catIds = catId.toString();
        ac.deleteccat(catIds);
        return "category.xhtml";
    }

    public String getCategoryById(Category catId) {

        this.cat = catId;
        return "updateCat.xhtml";

    }

    public String updatecat(String name, String catId) {

        this.cat.setCatName(name);

        System.out.println(cat.getCatName());
        System.out.println(catId);

        rs = ac.updatecat(cat, catId);

        if (rs != null) {
            return "category.xhtml";
        } else {
            System.out.println("something wrong");
            return "../index.html";

        }
    }

    //Product
    public Collection<Products> getAllPro() {
        rs = ac.getAllPro(Response.class);
        products = rs.readEntity(gproducts);
        return products;
    }

    public String insertpro(String catid, String brandid) {
        if (file != null) {
            try {
                String fileName = file.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "C:\\Users\\mistr\\Downloads\\Medical_Store\\Medical_Store\\src\\main\\webapp\\proimg";
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = file.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                prd.setProName(proName);
                prd.setProDescription(proDescription);
                prd.setExpDate(expDate);
                prd.setManDate(manDate);
                prd.setProstock(stock);
                prd.setProImg(fileName);
                prd.setProPrice(proPrice);

                String catids = catid.toString();
                String brandids = brandid.toString();

                System.out.println(prd.getProName());
                System.out.println(prd.getProDescription());
                System.out.println(prd.getManDate());
                System.out.println(prd.getExpDate());
                System.out.println(prd.getProImg());
                System.out.println(prd.getProPrice());

                System.out.println(catids);
                System.out.println(brandids);

                rs = ac.insertpro(prd, catids, brandids);
                if (rs != null) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }
        return "product.jsf?faces-redirect=true";
    }

    public String deletepro(Integer productID, Integer brandid, Integer catId) {
        String brdids = brandid.toString();
        String proids = productID.toString();
        String catids = catId.toString();
        ac.deletepro(proids, catids, brdids);
        return "product.jsf";
    }

    public String getProductsById(String id) {
        rs = ac.getProductsById(Response.class, id);
        GenericType<Products> pro = new GenericType<Products>() {
        };
        Products p = rs.readEntity(pro);
        this.setProid(p.getProId());
        this.setProName(p.getProName());
        this.setCatId(p.getCatId().getCatId());
        this.setProDescription(p.getProDescription());
        this.setExpDate(p.getExpDate());
        this.setManDate(p.getManDate());
        this.setStock(p.getProstock());
        this.setBrandId(p.getBrandId().getBrandId());
        this.setProPrice(p.getProPrice());
        return "updatePro.jsf";
    }

    public String updatepro(String proid,String catid, String brandid) {

        this.prd.setProName(proName);
        this.prd.setProDescription(proDescription);
        this.prd.setExpDate(expDate);
        this.prd.setManDate(manDate);
        this.prd.setProstock(stock);
       
        this.prd.setProPrice(proPrice);

        System.out.println(prd.getProName());
        System.out.println(prd.getProDescription());
        System.out.println(prd.getExpDate());
        System.out.println(prd.getManDate());
        System.out.println(prd.getProstock());
        System.out.println(prd.getProPrice());

        //rs = ac.updatepro(prd, proid, catid, brandid);
        rs = ac.updatepro(prd, proid, catid, brandid);

        if (rs != null) {
            return "product.jsf";
        } else {
            System.out.println("somthing Wrong");
            return "../index.html";
        }
    }

    //Review
    public Collection<Productreview> getAllProductReviews() {

        rs = ac.getAllProductReviews(Response.class);
        pr = rs.readEntity(gpr);
        return pr;
    }

    //User
    public Collection<Usertable> getAllUsertables() {
        rs = ac.getAllUsertables(Response.class);
        usertables = rs.readEntity(gUS);
        return usertables;
    }
}
