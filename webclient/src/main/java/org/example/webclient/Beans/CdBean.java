package org.example.webclient.Beans;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.SessionScoped;
import org.example.backend.entities.CD;
import org.example.backend.entities.ejb.CdService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

@ManagedBean("cdBean")
@SessionScoped
public class CdBean {

    CdService cdService;

    @PostConstruct
    public void init() {
        try {
            Properties jndiProperties = new Properties();
            jndiProperties.put("java.naming.factory.initial",
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("java.naming.provider.url", "http-remoting://localhost:9990");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            InitialContext context = new InitialContext(jndiProperties);
            cdService = (CdService) context.lookup(
                    "ejb:/backend-1.0-SNAPSHOT/CdServiceImpl!org.example.backend.entities.ejb.CdServiceImpl");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public List<CD> getCds(){
        return cdService.getCds();
    }
}
