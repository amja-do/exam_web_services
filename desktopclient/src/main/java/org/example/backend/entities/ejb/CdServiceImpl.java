package org.example.backend.entities.ejb;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.backend.entities.CD;
import org.example.backend.entities.User;

import java.util.List;

@Stateful
public class CdServiceImpl implements CdService {
    @PersistenceContext(unitName = "mysql-eclipselink")
    private EntityManager em;

    @Override
    public List<CD> getCds() {
        return em.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }

    @Override
    public void addCd(CD cd) {
        em.persist(cd);
    }

    @Override
    public void update(CD cd) {
        em.persist(cd);
    }

    @Override
    public void delete(Long id) {
        CD cd =findCdById(id);
        em.remove(cd);
    }

    @Override
    public boolean book(CD cd, User user) {
        if(cd.getBookedBy() != null)
            return false;
        cd.setBookedBy(user);
        user.getBookedBy().add(cd);
        return false;
    }

    @Override
    public CD findCdById(Long id) {
        return em.find(CD.class, id);
    }
}
