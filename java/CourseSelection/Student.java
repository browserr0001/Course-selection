/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSelection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author patel
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Student.findByStudentfirstname", query = "SELECT s FROM Student s WHERE s.studentfirstname = :studentfirstname")
    , @NamedQuery(name = "Student.findByStudentlastname", query = "SELECT s FROM Student s WHERE s.studentlastname = :studentlastname")
    , @NamedQuery(name = "Student.findByStudentbday", query = "SELECT s FROM Student s WHERE s.studentbday = :studentbday")
    , @NamedQuery(name = "Student.findByStudentmajor", query = "SELECT s FROM Student s WHERE s.studentmajor = :studentmajor")
    , @NamedQuery(name = "Student.findByStudentgender", query = "SELECT s FROM Student s WHERE s.studentgender = :studentgender")
    , @NamedQuery(name = "Student.findByStudentgpa", query = "SELECT s FROM Student s WHERE s.studentgpa = :studentgpa")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STUDENTFIRSTNAME")
    private String studentfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STUDENTLASTNAME")
    private String studentlastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTBDAY")
    @Temporal(TemporalType.DATE)
    private Date studentbday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STUDENTMAJOR")
    private String studentmajor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STUDENTGENDER")
    private String studentgender;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STUDENTGPA")
    private Double studentgpa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentid")
    private Collection<Enrollment> enrollmentCollection;

    public Student() {
    }

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Student(Integer studentid, String studentfirstname, String studentlastname, Date studentbday, String studentmajor, String studentgender) {
        this.studentid = studentid;
        this.studentfirstname = studentfirstname;
        this.studentlastname = studentlastname;
        this.studentbday = studentbday;
        this.studentmajor = studentmajor;
        this.studentgender = studentgender;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentfirstname() {
        return studentfirstname;
    }

    public void setStudentfirstname(String studentfirstname) {
        this.studentfirstname = studentfirstname;
    }

    public String getStudentlastname() {
        return studentlastname;
    }

    public void setStudentlastname(String studentlastname) {
        this.studentlastname = studentlastname;
    }

    public Date getStudentbday() {
        return studentbday;
    }

    public void setStudentbday(Date studentbday) {
        this.studentbday = studentbday;
    }

    public String getStudentmajor() {
        return studentmajor;
    }

    public void setStudentmajor(String studentmajor) {
        this.studentmajor = studentmajor;
    }

    public String getStudentgender() {
        return studentgender;
    }

    public void setStudentgender(String studentgender) {
        this.studentgender = studentgender;
    }

    public Double getStudentgpa() {
        return studentgpa;
    }

    public void setStudentgpa(Double studentgpa) {
        this.studentgpa = studentgpa;
    }

    @XmlTransient
    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSelection.Student[ studentid=" + studentid + " ]";
    }
    
}
