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
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProId", query = "SELECT p FROM Products p WHERE p.proId = :proId"),
    @NamedQuery(name = "Products.findByProName", query = "SELECT p FROM Products p WHERE p.proName = :proName"),
    @NamedQuery(name = "Products.findByProDescription", query = "SELECT p FROM Products p WHERE p.proDescription = :proDescription"),
    @NamedQuery(name = "Products.findByExpDate", query = "SELECT p FROM Products p WHERE p.expDate = :expDate"),
    @NamedQuery(name = "Products.findByManDate", query = "SELECT p FROM Products p WHERE p.manDate = :manDate"),
    @NamedQuery(name = "Products.findByProstock", query = "SELECT p FROM Products p WHERE p.prostock = :prostock"),
    @NamedQuery(name = "Products.findByProImg", query = "SELECT p FROM Products p WHERE p.proImg = :proImg"),
    @NamedQuery(name = "Products.findByProPrice", query = "SELECT p FROM Products p WHERE p.proPrice = :proPrice")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProId")
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ProName")
    private String proName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ProDescription")
    private String proDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpDate")
    @Temporal(TemporalType.DATE)
    private Date expDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ManDate")
    @Temporal(TemporalType.DATE)
    private Date manDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prostock")
    private int prostock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ProImg")
    private String proImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProPrice")
    private int proPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Productreview> productreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private Collection<Cart> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private Collection<Orderdetail> orderdetailCollection;
    @JoinColumn(name = "CatId", referencedColumnName = "CatId")
    @ManyToOne(optional = false)
    private Category catId;
    @JoinColumn(name = "BrandId", referencedColumnName = "BrandId")
    @ManyToOne(optional = false)
    private Brandtable brandId;

    public Products() {
    }

    public Products(Integer proId) {
        this.proId = proId;
    }

    public Products(Integer proId, String proName, String proDescription, Date expDate, Date manDate, int prostock, String proImg, int proPrice) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.expDate = expDate;
        this.manDate = manDate;
        this.prostock = prostock;
        this.proImg = proImg;
        this.proPrice = proPrice;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public int getProstock() {
        return prostock;
    }

    public void setProstock(int prostock) {
        this.prostock = prostock;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    @JsonbTransient
    public Collection<Productreview> getProductreviewCollection() {
        return productreviewCollection;
    }

    public void setProductreviewCollection(Collection<Productreview> productreviewCollection) {
        this.productreviewCollection = productreviewCollection;
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

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    public Brandtable getBrandId() {
        return brandId;
    }

    public void setBrandId(Brandtable brandId) {
        this.brandId = brandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Products[ proId=" + proId + " ]";
    }
    
}
