/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSelection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author patel
 */
@Stateless
public class EnrollmentFacade extends AbstractFacade<Enrollment> {

    @PersistenceContext(unitName = "CourseSelectionWebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnrollmentFacade() {
        super(Enrollment.class);
    }
    
}
