/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mistr
 */
@Entity
@Table(name = "productreview")
@NamedQueries({
    @NamedQuery(name = "Productreview.findAll", query = "SELECT p FROM Productreview p"),
    @NamedQuery(name = "Productreview.findByReviewId", query = "SELECT p FROM Productreview p WHERE p.reviewId = :reviewId"),
    @NamedQuery(name = "Productreview.findByProRating", query = "SELECT p FROM Productreview p WHERE p.proRating = :proRating"),
    @NamedQuery(name = "Productreview.findByProReview", query = "SELECT p FROM Productreview p WHERE p.proReview = :proReview"),
    @NamedQuery(name = "Productreview.findByAddedDate", query = "SELECT p FROM Productreview p WHERE p.addedDate = :addedDate")})
public class Productreview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReviewId")
    private Integer reviewId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ProRating")
    private String proRating;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ProReview")
    private String proReview;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AddedDate")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @JoinColumn(name = "ProId", referencedColumnName = "ProId")
    @ManyToOne(optional = false)
    private Products proId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Usertable userId;

    public Productreview() {
    }

    public Productreview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Productreview(Integer reviewId, String proRating, String proReview, Date addedDate) {
        this.reviewId = reviewId;
        this.proRating = proRating;
        this.proReview = proReview;
        this.addedDate = addedDate;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Products getProId() {
        return proId;
    }

    public void setProId(Products proId) {
        this.proId = proId;
    }

    public Usertable getUserId() {
        return userId;
    }

    public void setUserId(Usertable userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productreview)) {
            return false;
        }
        Productreview other = (Productreview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productreview[ reviewId=" + reviewId + " ]";
    }
    
}
