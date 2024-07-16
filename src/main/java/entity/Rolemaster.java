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
@Table(name = "rolemaster")
@NamedQueries({
    @NamedQuery(name = "Rolemaster.findAll", query = "SELECT r FROM Rolemaster r"),
    @NamedQuery(name = "Rolemaster.findByRoleid", query = "SELECT r FROM Rolemaster r WHERE r.roleid = :roleid"),
    @NamedQuery(name = "Rolemaster.findByRole", query = "SELECT r FROM Rolemaster r WHERE r.role = :role")})
public class Rolemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleid")
    private Integer roleid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<Usertable> usertableCollection;

    public Rolemaster() {
    }

    public Rolemaster(Integer roleid) {
        this.roleid = roleid;
    }

    public Rolemaster(Integer roleid, String role) {
        this.roleid = roleid;
        this.role = role;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonbTransient
    public Collection<Usertable> getUsertableCollection() {
        return usertableCollection;
    }

    public void setUsertableCollection(Collection<Usertable> usertableCollection) {
        this.usertableCollection = usertableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolemaster)) {
            return false;
        }
        Rolemaster other = (Rolemaster) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rolemaster[ roleid=" + roleid + " ]";
    }
    
}
