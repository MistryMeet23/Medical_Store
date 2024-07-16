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
@Table(name = "brandtable")
@NamedQueries({
    @NamedQuery(name = "Brandtable.findAll", query = "SELECT b FROM Brandtable b"),
    @NamedQuery(name = "Brandtable.findByBrandId", query = "SELECT b FROM Brandtable b WHERE b.brandId = :brandId"),
    @NamedQuery(name = "Brandtable.findByBrandName", query = "SELECT b FROM Brandtable b WHERE b.brandName = :brandName"),
    @NamedQuery(name = "Brandtable.findByContactNo", query = "SELECT b FROM Brandtable b WHERE b.contactNo = :contactNo"),
    @NamedQuery(name = "Brandtable.findByWebsite", query = "SELECT b FROM Brandtable b WHERE b.website = :website"),
    @NamedQuery(name = "Brandtable.findByEmail", query = "SELECT b FROM Brandtable b WHERE b.email = :email"),
    @NamedQuery(name = "Brandtable.findByLogo", query = "SELECT b FROM Brandtable b WHERE b.logo = :logo")})
public class Brandtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BrandId")
    private Integer brandId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "BrandName")
    private String brandName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ContactNo")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Website")
    private String website;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Logo")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandId")
    private Collection<Products> productsCollection;

    public Brandtable() {
    }

    public Brandtable(Integer brandId) {
        this.brandId = brandId;
    }

    public Brandtable(Integer brandId, String brandName, String contactNo, String website, String email, String logo) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.contactNo = contactNo;
        this.website = website;
        this.email = email;
        this.logo = logo;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonbTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandId != null ? brandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brandtable)) {
            return false;
        }
        Brandtable other = (Brandtable) object;
        if ((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Brandtable[ brandId=" + brandId + " ]";
    }
    
}
