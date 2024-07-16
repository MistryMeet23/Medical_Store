
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import Beans.UserBLocal;
import entity.Cart;
import entity.Category;
import entity.Ordermaster;
import entity.Productreview;
import entity.Products;
import entity.Usertable;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("UserRest")
@RequestScoped
public class UserRest {

    @EJB
    UserBLocal obj;
    @Context
    private UriInfo context;

    public UserRest() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<h1>User Side</h1>";
    }

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertuser(Usertable u) {
        try {
            if (obj.insertuser(u.getUserEmail(), u.getName(), u.getUserNumber(), u.getUserPassword())) {
                String msg = "User Inserted successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @PUT
    @Path("/update/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") Integer userId, Usertable u) {
        try {
            if (obj.updateuser(userId, u.getUserEmail(), u.getName(), u.getUserNumber(), u.getUserPassword())) {
                String msg = "User Updated successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

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

    //----------------- PRODUCT -----------------
    @GET
    @Path("/getprodbyid/{proid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Products getProductsById(@PathParam("proid") Integer proid) {
        return obj.getProductsById(proid);
    }

    @GET
    @Path("getProd")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Products> getAllPro() {
        return obj.getAllPro();
    }

    //----------------- PRODUCT REVIEW -----------------
    @GET
    @Path("getProductReview/{reviewId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productreview getProductreviewById(@PathParam("reviewId") Integer reviewId) {
        return obj.getProductreviewById(reviewId);
    }

    @POST
    @Path("addProductReview/{proId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertprorw(@PathParam("proId") Integer proId,
            @PathParam("userId") Integer userId, Productreview productreview) {
        if (obj.insertprorw(
                productreview.getProRating(),
                productreview.getProReview(),
                productreview.getAddedDate(),
                proId,
                userId)) {
            String msg = "ProductReview added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("updateProductReview/{reviewId}/{proId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateprorw(
            @PathParam("reviewId") Integer reviewId,
            @PathParam("proId") Integer proId,
            @PathParam("userId") Integer userId,
            Productreview productreview) {
        if (obj.updateprorw(
                reviewId,
                productreview.getProRating(),
                productreview.getProReview(),
                productreview.getAddedDate(),
                proId,
                userId)) {
            String msg = "ProductReview updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("deleteProductReview/{reviewId}/{proId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteprorw(
            @PathParam("reviewId") Integer reviewId,
            @PathParam("proId") Integer proId,
            @PathParam("userId") Integer userId) {
        if (obj.deleteprorw(reviewId, proId, userId)) {
            String msg = "ProductReview deleted successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //----------------- ORDER -----------------
    @GET
    @Path("getOrder/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ordermaster geOrdertableById(@PathParam("orderId") Integer orderId) {
        return obj.geOrdertableById(orderId);
    }

    @POST
    @Path("add/{uid}/{proid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertOrder(
            @PathParam("uid") Integer userId,
            @PathParam("proid") Integer proid,
            Ordermaster ordertable) {

        if (obj.insertorder(userId, proid, ordertable.getQuantity(), ordertable.getOrderStatus(), ordertable.getOrderTotal())) {
            String msg = "Order added successfully";
            return Response.status(Response.Status.CREATED).entity(msg).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @PUT
//    @Path("update/{orderId}/{uid}/{proid}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateOrder(
//            @PathParam("orderId") Integer orderId,
//            @PathParam("uid") Integer userId,
//            @PathParam("proid") Integer proid,
//            Ordermaster ordertable) {
//
//        if (obj.updateorder(orderId, userId, proid, ordertable.getQuantity(),  ordertable.getOrderStatus(), ordertable.getOrderTotal())) {
//            String msg = "Order updated successfully";
//            return Response.status(Response.Status.OK).entity(msg).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build(); // Use 404 Not Found for unsuccessful update
//        }
//    }
    @DELETE
    @Path("delete/{orderId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrder(
            @PathParam("orderId") Integer orderId,
            @PathParam("userId") Integer userId,
            @PathParam("proid") Integer proid) {

        if (obj.deleteorder(orderId, userId, proid)) {
            String msg = "Order deleted successfully";
            return Response.status(Response.Status.NO_CONTENT).entity(msg).build(); // Use 204 No Content for successful delete
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //----------------- CATEGORY -----------------
    @GET
    @Path("getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategorys() {
        return obj.getAllCategorys();
    }

    @GET
    @Path("getCategory/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category geCategoryById(@PathParam("catId") Integer catId) {
        return obj.geCategoryById(catId);
    }

    //----------------- CART -----------------
    @GET
    @Path("getCart/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCartById(@PathParam("cartId") Integer cartId) {
        return obj.getCartById(cartId);
    }

    @POST
    @Path("insertCart/{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertcart(@PathParam("uid") Integer userId, Cart cart) {
        if (obj.insertcart(userId, cart.getCarttotal())) {
            String msg = "Cart added successfully";
            return Response.status(Response.Status.CREATED).entity(msg).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("updateCart/{cartId}/{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatecart(@PathParam("uid") Integer userId, @PathParam("cartId") Integer cartId, Cart cart) {
        if (obj.updatecart(cartId, userId, cart.getCarttotal())) {
            String msg = "Cart updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("deleteCart/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletecart(@PathParam("cartId") Integer cartId) {
        if (obj.deletecart(cartId)) {
            String msg = "Cart deleted successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("addToCart/{uid}/{pId}/{qty}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("uid") Integer uid, @PathParam("pId") Integer pId, @PathParam("qty") Integer qty) {
        boolean result = obj.addProductToCart(uid, pId, qty);
        if (result) {
            String msg = "Cart Added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("deleteCart/{uid}/{pId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCart(@PathParam("uid") Integer uid, @PathParam("pId") Integer pId) {
        boolean result = obj.removeProductFromCart(uid, pId);
        if (result) {
            String msg = "product Remove successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("viewCart/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> viewCart(@PathParam("uid") Integer uid) {
        return obj.viewCart(uid);
    }

    @POST
    @Path("PlaceOrder/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(@PathParam("userId") Integer userId, @PathParam("proId") Integer proId) {
        boolean result = obj.placeOrder(userId);
        if (result) {
            String msg = "Order Place successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }
}
