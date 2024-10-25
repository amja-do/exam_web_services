package org.example.backend.entities.ejb;

import jakarta.ejb.Remote;
import org.example.backend.entities.CD;

import java.util.List;

@Remote
public interface UserService {

    List<CD> bookedCds();
}
