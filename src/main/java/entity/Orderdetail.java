/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mistr
 */
@Entity
@Table(name = "orderdetail")
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o"),
    @NamedQuery(name = "Orderdetail.findByOdId", query = "SELECT o FROM Orderdetail o WHERE o.odId = :odId"),
    @NamedQuery(name = "Orderdetail.findByProdPrice", query = "SELECT o FROM Orderdetail o WHERE o.prodPrice = :prodPrice"),
    @NamedQuery(name = "Orderdetail.findByProdName", query = "SELECT o FROM Orderdetail o WHERE o.prodName = :prodName"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odId")
    private Integer odId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdPrice")
    private int prodPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ProdName")
    private String prodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "uId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Usertable uId;
    @JoinColumn(name = "omId", referencedColumnName = "OrderId")
    @ManyToOne(optional = false)
    private Ordermaster omId;
    @JoinColumn(name = "prodId", referencedColumnName = "ProId")
    @ManyToOne(optional = false)
    private Products prodId;

    public Orderdetail() {
    }

    public Orderdetail(Integer odId) {
        this.odId = odId;
    }

    public Orderdetail(Integer odId, int prodPrice, String prodName, int quantity) {
        this.odId = odId;
        this.prodPrice = prodPrice;
        this.prodName = prodName;
        this.quantity = quantity;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Usertable getUId() {
        return uId;
    }

    public void setUId(Usertable uId) {
        this.uId = uId;
    }

    public Ordermaster getOmId() {
        return omId;
    }

    public void setOmId(Ordermaster omId) {
        this.omId = omId;
    }

    public Products getProdId() {
        return prodId;
    }

    public void setProdId(Products prodId) {
        this.prodId = prodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odId != null ? odId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.odId == null && other.odId != null) || (this.odId != null && !this.odId.equals(other.odId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderdetail[ odId=" + odId + " ]";
    }
    
}
