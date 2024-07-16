/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mistr
 */
@Entity
@Table(name = "ordermaster")
@NamedQueries({
    @NamedQuery(name = "Ordermaster.findAll", query = "SELECT o FROM Ordermaster o"),
    @NamedQuery(name = "Ordermaster.findByOrderId", query = "SELECT o FROM Ordermaster o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Ordermaster.findByQuantity", query = "SELECT o FROM Ordermaster o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Ordermaster.findByOrderDate", query = "SELECT o FROM Ordermaster o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Ordermaster.findByOrderStatus", query = "SELECT o FROM Ordermaster o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "Ordermaster.findByOrderTotal", query = "SELECT o FROM Ordermaster o WHERE o.orderTotal = :orderTotal")})
public class Ordermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderId")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderTotal")
    private int orderTotal;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Usertable userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "omId")
    private Collection<Orderdetail> orderdetailCollection;

    public Ordermaster() {
    }

    public Ordermaster(Integer orderId) {
        this.orderId = orderId;
    }

    public Ordermaster(Integer orderId, int quantity, Date orderDate, String orderStatus, int orderTotal) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Usertable getUserId() {
        return userId;
    }

    public void setUserId(Usertable userId) {
        this.userId = userId;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordermaster)) {
            return false;
        }
        Ordermaster other = (Ordermaster) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ordermaster[ orderId=" + orderId + " ]";
    }
    
}
