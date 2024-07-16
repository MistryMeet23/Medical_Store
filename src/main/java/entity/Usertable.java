/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mistr
 */
@Entity
@Table(name = "usertable")
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u"),
    @NamedQuery(name = "Usertable.findByUserId", query = "SELECT u FROM Usertable u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usertable.findByUserEmail", query = "SELECT u FROM Usertable u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Usertable.findByName", query = "SELECT u FROM Usertable u WHERE u.name = :name"),
    @NamedQuery(name = "Usertable.findByUserNumber", query = "SELECT u FROM Usertable u WHERE u.userNumber = :userNumber"),
    @NamedQuery(name = "Usertable.findByUserPassword", query = "SELECT u FROM Usertable u WHERE u.userPassword = :userPassword")})
public class Usertable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "UserEmail")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UserNumber")
    private String userNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UserPassword")
    private String userPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Productreview> productreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Address> addressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Ordermaster> ordermasterCollection;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Rolemaster roleid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uid")
    private Collection<Getintouch> getintouchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Cart> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uId")
    private Collection<Orderdetail> orderdetailCollection;

    public Usertable() {
    }

    public Usertable(Integer userId) {
        this.userId = userId;
    }

    public Usertable(Integer userId, String userEmail, String name, String userNumber, String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.name = name;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @JsonbTransient
    public Collection<Productreview> getProductreviewCollection() {
        return productreviewCollection;
    }

    public void setProductreviewCollection(Collection<Productreview> productreviewCollection) {
        this.productreviewCollection = productreviewCollection;
    }

    @JsonbTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @JsonbTransient
    public Collection<Ordermaster> getOrdermasterCollection() {
        return ordermasterCollection;
    }

    public void setOrdermasterCollection(Collection<Ordermaster> ordermasterCollection) {
        this.ordermasterCollection = ordermasterCollection;
    }

    public Rolemaster getRoleid() {
        return roleid;
    }

    public void setRoleid(Rolemaster roleid) {
        this.roleid = roleid;
    }

    @JsonbTransient
    public Collection<Getintouch> getGetintouchCollection() {
        return getintouchCollection;
    }

    public void setGetintouchCollection(Collection<Getintouch> getintouchCollection) {
        this.getintouchCollection = getintouchCollection;
    }

    @JsonbTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @JsonbTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usertable[ userId=" + userId + " ]";
    }
    
}
