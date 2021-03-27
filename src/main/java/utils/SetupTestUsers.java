package utils;

import entities.Employee;
import entities.Employees;
import errorhandling.AlreadyExistsException;
import errorhandling.MissingInputException;
import facade.OrgFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) throws MissingInputException, AlreadyExistsException {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

    }

}
