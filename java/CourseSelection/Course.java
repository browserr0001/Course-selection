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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCourseid", query = "SELECT c FROM Course c WHERE c.courseid = :courseid")
    , @NamedQuery(name = "Course.findByCoursename", query = "SELECT c FROM Course c WHERE c.coursename = :coursename")
    , @NamedQuery(name = "Course.findByCoursecredits", query = "SELECT c FROM Course c WHERE c.coursecredits = :coursecredits")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEID")
    private Integer courseid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COURSENAME")
    private String coursename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSECREDITS")
    private int coursecredits;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseid")
    private Collection<Enrollment> enrollmentCollection;
    @JoinColumn(name = "TEACHERID", referencedColumnName = "TEACHERID")
    @ManyToOne(optional = false)
    private Teacher teacherid;

    public Course() {
    }

    public Course(Integer courseid) {
        this.courseid = courseid;
    }

    public Course(Integer courseid, String coursename, int coursecredits) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursecredits = coursecredits;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCoursecredits() {
        return coursecredits;
    }

    public void setCoursecredits(int coursecredits) {
        this.coursecredits = coursecredits;
    }

    @XmlTransient
    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    public Teacher getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Teacher teacherid) {
        this.teacherid = teacherid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSelection.Course[ courseid=" + courseid + " ]";
    }
    
}
