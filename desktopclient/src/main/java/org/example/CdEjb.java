package org.example;

import org.example.backend.entities.ejb.CdService;
import org.example.backend.entities.ejb.UserService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class CdEjb {

    CdService cdService;
    UserService userService;
    public CdEjb(){
        try {
            Properties jndiProperties = new Properties();
            jndiProperties.put("java.naming.factory.initial",
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("java.naming.provider.url", "http-remoting://localhost:9990");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            InitialContext context = new InitialContext(jndiProperties);
            cdService = (CdService) context.lookup(
                    "ejb:/backend-1.0-SNAPSHOT/CdServiceImpl!org.example.backend.entities.ejb.CdServiceImpl?stateful");

            userService = (UserService) context.lookup(
                    "ejb:/backend-1.0-SNAPSHOT/UserServiceImpl!org.example.backend.entities.ejb.UserServiceImpl?stateful");

            System.out.println("Connected to EJB!");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    }

