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
@Table(name = "getintouch")
@NamedQueries({
    @NamedQuery(name = "Getintouch.findAll", query = "SELECT g FROM Getintouch g"),
    @NamedQuery(name = "Getintouch.findByGid", query = "SELECT g FROM Getintouch g WHERE g.gid = :gid"),
    @NamedQuery(name = "Getintouch.findByName", query = "SELECT g FROM Getintouch g WHERE g.name = :name"),
    @NamedQuery(name = "Getintouch.findByMessage", query = "SELECT g FROM Getintouch g WHERE g.message = :message")})
public class Getintouch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "uid", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Usertable uid;

    public Getintouch() {
    }

    public Getintouch(Integer gid) {
        this.gid = gid;
    }

    public Getintouch(Integer gid, String name, String message) {
        this.gid = gid;
        this.name = name;
        this.message = message;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usertable getUid() {
        return uid;
    }

    public void setUid(Usertable uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Getintouch)) {
            return false;
        }
        Getintouch other = (Getintouch) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Getintouch[ gid=" + gid + " ]";
    }
    
}
