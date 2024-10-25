package org.example.backend.entities.ejb;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import org.example.backend.entities.CD;
import org.example.backend.entities.User;

import java.util.List;

@Remote
public interface CdService {
    List<CD> getCds();
    void addCd(CD cd);
    void update(CD cd);
    void delete(Long id);
    boolean book(CD cd, User user);
    CD findCdById(Long id);

}
