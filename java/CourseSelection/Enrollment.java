/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSelection;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patel
 */
@Entity
@Table(name = "ENROLLMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e")
    , @NamedQuery(name = "Enrollment.findByEnrollmentid", query = "SELECT e FROM Enrollment e WHERE e.enrollmentid = :enrollmentid")
    , @NamedQuery(name = "Enrollment.findByEnrollmentyear", query = "SELECT e FROM Enrollment e WHERE e.enrollmentyear = :enrollmentyear")
    , @NamedQuery(name = "Enrollment.findByEnrollmentsemester", query = "SELECT e FROM Enrollment e WHERE e.enrollmentsemester = :enrollmentsemester")
    , @NamedQuery(name = "Enrollment.findByStudentgrade", query = "SELECT e FROM Enrollment e WHERE e.studentgrade = :studentgrade")})
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENROLLMENTID")
    private Integer enrollmentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENROLLMENTYEAR")
    private int enrollmentyear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ENROLLMENTSEMESTER")
    private String enrollmentsemester;
    @Size(max = 2)
    @Column(name = "STUDENTGRADE")
    private String studentgrade;
    @JoinColumn(name = "COURSEID", referencedColumnName = "COURSEID")
    @ManyToOne(optional = false)
    private Course courseid;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne(optional = false)
    private Student studentid;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public Enrollment(Integer enrollmentid, int enrollmentyear, String enrollmentsemester) {
        this.enrollmentid = enrollmentid;
        this.enrollmentyear = enrollmentyear;
        this.enrollmentsemester = enrollmentsemester;
    }

    public Integer getEnrollmentid() {
        return enrollmentid;
    }

    public void setEnrollmentid(Integer enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public int getEnrollmentyear() {
        return enrollmentyear;
    }

    public void setEnrollmentyear(int enrollmentyear) {
        this.enrollmentyear = enrollmentyear;
    }

    public String getEnrollmentsemester() {
        return enrollmentsemester;
    }

    public void setEnrollmentsemester(String enrollmentsemester) {
        this.enrollmentsemester = enrollmentsemester;
    }

    public String getStudentgrade() {
        return studentgrade;
    }

    public void setStudentgrade(String studentgrade) {
        this.studentgrade = studentgrade;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentid != null ? enrollmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrollment)) {
            return false;
        }
        Enrollment other = (Enrollment) object;
        if ((this.enrollmentid == null && other.enrollmentid != null) || (this.enrollmentid != null && !this.enrollmentid.equals(other.enrollmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSelection.Enrollment[ enrollmentid=" + enrollmentid + " ]";
    }
    
}
