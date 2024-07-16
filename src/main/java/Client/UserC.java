/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:UserRest [UserRest]<br>
 * USAGE:
 * <pre>
 *        UserC client = new UserC();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author mistr
 */
public class UserC {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Medical_Store/resources";

    public UserC() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("UserRest");
    }

    public <T> T geOrdertableById(Class<T> responseType, String orderId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOrder/{0}", new Object[]{orderId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getHtml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public Response insertuser(Object requestEntity) throws ClientErrorException {
        return webTarget.path("addUser").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getProductsById(Class<T> responseType, String proid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getprodbyid/{0}", new Object[]{proid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response insertOrder(Object requestEntity, String uid, String proid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("add/{0}/{1}", new Object[]{uid, proid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getAllPro(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getProd");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response insertcart(Object requestEntity, String uid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertCart/{0}", new Object[]{uid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response placeOrder(String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("PlaceOrder/{0}", new Object[]{userId})).request().post(null, Response.class);
    }

    public Response updateUser(Object requestEntity, String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("update/{0}", new Object[]{userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response updateprorw(Object requestEntity, String reviewId, String proId, String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateProductReview/{0}/{1}/{2}", new Object[]{reviewId, proId, userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getProductreviewById(Class<T> responseType, String reviewId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductReview/{0}", new Object[]{reviewId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCategorys(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updatecart(Object requestEntity, String cartId, String uid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateCart/{0}/{1}", new Object[]{cartId, uid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getUsertableById(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUser/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response insertprorw(Object requestEntity, String proId, String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addProductReview/{0}/{1}", new Object[]{proId, userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response deleteprorw(String reviewId, String proId, String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteProductReview/{0}/{1}/{2}", new Object[]{reviewId, proId, userId})).request().delete(Response.class);
    }

    public <T> T geCategoryById(Class<T> responseType, String catId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategory/{0}", new Object[]{catId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response removeCart(String uid, String pId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCart/{0}/{1}", new Object[]{uid, pId})).request().delete(Response.class);
    }

    public Response addToCart(String uid, String pId, String qty) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}", new Object[]{uid, pId, qty})).request().post(null, Response.class);
    }

    public <T> T viewCart(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("viewCart/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteOrder(String orderId, String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("delete/{0}/{1}", new Object[]{orderId, userId})).request().delete(Response.class);
    }

    public <T> T getCartById(Class<T> responseType, String cartId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCart/{0}", new Object[]{cartId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deletecart(String cartId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCart/{0}", new Object[]{cartId})).request().delete(Response.class);
    }

    public void close() {
        client.close();
    }
    
}
