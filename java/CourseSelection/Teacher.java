/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSelection;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author patel
 */
@Entity
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByTeacherid", query = "SELECT t FROM Teacher t WHERE t.teacherid = :teacherid")
    , @NamedQuery(name = "Teacher.findByTeacherfirstname", query = "SELECT t FROM Teacher t WHERE t.teacherfirstname = :teacherfirstname")
    , @NamedQuery(name = "Teacher.findByTeacherlastname", query = "SELECT t FROM Teacher t WHERE t.teacherlastname = :teacherlastname")
    , @NamedQuery(name = "Teacher.findByTeacherdepartmentname", query = "SELECT t FROM Teacher t WHERE t.teacherdepartmentname = :teacherdepartmentname")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEACHERID")
    private Integer teacherid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TEACHERFIRSTNAME")
    private String teacherfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TEACHERLASTNAME")
    private String teacherlastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TEACHERDEPARTMENTNAME")
    private String teacherdepartmentname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherid")
    private Collection<Course> courseCollection;

    public Teacher() {
    }

    public Teacher(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Teacher(Integer teacherid, String teacherfirstname, String teacherlastname, String teacherdepartmentname) {
        this.teacherid = teacherid;
        this.teacherfirstname = teacherfirstname;
        this.teacherlastname = teacherlastname;
        this.teacherdepartmentname = teacherdepartmentname;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherfirstname() {
        return teacherfirstname;
    }

    public void setTeacherfirstname(String teacherfirstname) {
        this.teacherfirstname = teacherfirstname;
    }

    public String getTeacherlastname() {
        return teacherlastname;
    }

    public void setTeacherlastname(String teacherlastname) {
        this.teacherlastname = teacherlastname;
    }

    public String getTeacherdepartmentname() {
        return teacherdepartmentname;
    }

    public void setTeacherdepartmentname(String teacherdepartmentname) {
        this.teacherdepartmentname = teacherdepartmentname;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSelection.Teacher[ teacherid=" + teacherid + " ]";
    }
    
}
