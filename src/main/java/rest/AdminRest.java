package rest;

import Beans.AdminBLocal;
import entity.Brandtable;
import entity.Cart;
import entity.Category;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Rolemaster;
import entity.Usertable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("AdminRest")
@RequestScoped
public class AdminRest {

    @EJB
    AdminBLocal obj;
    @Context
    private UriInfo context;

    public AdminRest() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<h1>Admin Side</h1>";
    }

    //----------------- Brand -----------------
    @GET
    @Path("getBrand")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brandtable> getAllBrand() {
        return obj.getAllBrand();
    }

    @GET
    @Path("getBrandById/{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brandtable getBrandtableById(@PathParam("brandId") Integer brandId) {

        return obj.getBrandtableById(brandId);
    }

    @POST
    @Path("insertBrand")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertbrand(Brandtable brand) {
        if (obj.insertbrand(
                brand.getBrandName(),
                brand.getContactNo(),
                brand.getWebsite(),
                brand.getEmail(),
                brand.getLogo())) {

            String msg = "Brand added";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("updateBrand/{brandId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatebrand(@PathParam("brandId") Integer brandId, Brandtable brand) {
        if (obj.updatebrand(
                brandId,
                brand.getBrandName(),
                brand.getContactNo(),
                brand.getWebsite(),
                brand.getEmail())) {

            String msg = "Brand updated";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("deleteBrand/{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletebrand(@PathParam("brandId") Integer brandId) {
        if (obj.deletebrand(brandId)) {
            String msg = "Brand deleted";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    //----------------- Cart -----------------
    @GET
    @Path("getCart")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> getAllCart() {

        return obj.getAllCart();
    }

    @GET
    @Path("getCart/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCartById(@PathParam("cartId") Integer cartId) {
        return obj.getCartById(cartId);
    }

    //----------------- Category -----------------
    @GET
    @Path("getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCat() {
        return obj.getAllCat();
    }

    @GET
    @Path("getCategory/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category geCategoryById(@PathParam("catId") Integer catId) {
        return obj.geCategoryById(catId);
    }

    @POST
    @Path("addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertcat(Category category) {
        if (obj.insertcat(
                category.getCatName())) {
            String msg = "Category added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("updateCategory/{catId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatecat(
            @PathParam("catId") Integer catId,
            Category category) {
        if (obj.updatecat(
                catId,
                category.getCatName()
        )) {
            String msg = "Category updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("deleteCategory/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteccat(@PathParam("catId") Integer catId) {
        if (obj.deleteccat(catId)) {
            String msg = "Category deleted successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //----------------- Order -----------------
    @GET
    @Path("getAllOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Ordermaster> getAllOrder() {
        return obj.getAllOrder();
    }

    @GET
    @Path("getOrder/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ordermaster geOrdertableById(@PathParam("orderId") Integer orderId) {
        return obj.geOrdertableById(orderId);
    }

    //----------------- Product Review -----------------
    @GET
    @Path("getProductReview/{reviewId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productreview getProductreviewById(@PathParam("reviewId") Integer reviewId) {
        return obj.getProductreviewById(reviewId);
    }

    @GET
    @Path("getAllProductReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productreview> getAllProductReviews() {
        return obj.getAllProductReviews();
    }

    //----------------- Product -----------------
    @GET
    @Path("getProd")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Products> getAllPro() {

        return obj.getAllPro();
    }

    @GET
    @Path("/getprodbyid/{proid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Products getProductsById(@PathParam("proid") Integer proid) {
        return obj.getProductsById(proid);
    }

    @POST
    @Path("insertProd/{catid}/{brandId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertpro(@PathParam("catid") Integer catid, @PathParam("brandId") Integer brandId, Products prod) {
        if (obj.insertpro(
                prod.getProName(),
                prod.getProDescription(),
                prod.getExpDate(),
                prod.getManDate(),
                prod.getProstock(),
                prod.getProImg(),
                prod.getProPrice(),
                catid, brandId)) {

            String msg = "Product Added";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {

            return Response.notModified().build();
        }
    }

    @PUT
    @Path("updateProduct/{proid}/{catid}/{brandid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatepro(@PathParam("proid") Integer productId, @PathParam("catid") Integer catid, @PathParam("brandId") Integer brandId, Products prod) {
        if (obj.updatepro(
                productId,
                prod.getProName(),
                prod.getProDescription(),
                prod.getExpDate(),
                prod.getManDate(),
                prod.getProstock(),                
                prod.getProPrice(),
               catid,
                brandId)) {

            String msg = "Product updated";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("deleteProduct/{productId}/{catId}/{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletepro(@PathParam("productId") Integer productId,
            @PathParam("catId") Integer catId,
            @PathParam("brandId") Integer brandId) {
        if (obj.deletepro(productId, catId, brandId)) {
            String msg = "Product deleted";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    //----------------- User Master -----------------
    @GET
    @Path("getAllrole")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Rolemaster> getAllrole() {
        return obj.getAllrole();
    }

    @POST
    @Path("addrole")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertuserm(Rolemaster role) {
        if (obj.insertrole(role.getRole())) {
            String msg = "Rolemaster added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //----------------- User Table ----------------- 
    @GET
    @Path("/getUser/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsertableById(@PathParam("userId") Integer userId) {
        Usertable user = obj.getUsertableById(userId);
        if (user != null) {
            return Response.status(Response.Status.OK).entity(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usertable> getAllUsertables() {
        return obj.getAllUsertables();
    }
}
