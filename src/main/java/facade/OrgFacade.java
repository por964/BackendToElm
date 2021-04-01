package facade;

import DTOs.DepartmentDTO;
import DTOs.DepartmentsDTO;
import DTOs.EmployeeDTO;
import DTOs.EmployeesDTO;
import DTOs.ProjectDTO;
import DTOs.ProjectsDTO;
import entities.Department;
import entities.Employee;
import entities.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author claes
 */
public class OrgFacade {

    private static EntityManagerFactory emf;
    private static OrgFacade instance;

    public OrgFacade() {

    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static OrgFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OrgFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EmployeesDTO getAllEmps() {
        EntityManager em = getEntityManager();
        try {
            List<Employee> res = em.createNamedQuery("Employee.getAllRows").getResultList();
            EmployeesDTO result = new EmployeesDTO(res);
            return result;
        } finally {
            em.close();
        }
    }

    public EmployeesDTO allEmployees() {

        EntityManager em = getEntityManager();

        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> allempl = query.getResultList();
            EmployeesDTO result = new EmployeesDTO(allempl);
            return result;
        } finally {
            em.close();
        }

    }

    public EmployeeDTO addEmpl(String fName, String lName, String mail) {

        EntityManager em = getEntityManager();

        Employee emp = new Employee(fName, lName, mail);

        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            Employee newEmpl = em.find(Employee.class, emp.getId());
            EmployeeDTO res = new EmployeeDTO(newEmpl);
            return res;
        } finally {
            em.close();
        }

    }

    public ProjectsDTO getAllProjects() {
        EntityManager em = getEntityManager();
        try {
            return new ProjectsDTO(em.createNamedQuery("Project.getAllRows").getResultList());
        } finally {
            em.close();
        }
    }

    public ProjectDTO addProject(String title, int duration) {

        EntityManager em = getEntityManager();

        Project proj = new Project(title, duration);

        try {
            em.getTransaction().begin();
            em.persist(proj);
            em.getTransaction().commit();
            Project newProject = em.find(Project.class, proj.getId());
            ProjectDTO res = new ProjectDTO(newProject);
            return res;
        } finally {
            em.close();
        }

    }

    public DepartmentsDTO getAllDepartments() {
        EntityManager em = getEntityManager();
        try {
            return new DepartmentsDTO(em.createNamedQuery("Department.getAllRows").getResultList());
        } finally {
            em.close();
        }
    }

    public DepartmentDTO addDepartment(String code, String name, String descr) {

        EntityManager em = getEntityManager();

        Department dp = new Department(code, name, descr);

        try {
            em.getTransaction().begin();
            em.persist(dp);
            em.getTransaction().commit();
            Department newDepartment = em.find(Department.class, dp.getId());
            DepartmentDTO res = new DepartmentDTO(newDepartment);
            return res;
        } finally {
            em.close();
        }
    }

    public String addEmplToDept(Long empId, Long deptId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Employee e1 = em.find(Employee.class, empId);
            Department d1 = em.find(Department.class, deptId);
            d1.addEmployee(e1);
            em.persist(e1);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return "Employee added to department";

    }

    public String addEmplToProject(Long empId, Long projId) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            Employee e1 = em.find(Employee.class, empId);
            Project p1 = em.find(Project.class, projId);
            p1.addEmployee(e1);
            em.persist(e1);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return "Employee added to project";

    }
    
     public Employee deleteEmployee(Long empid) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee emp = em.find(Employee.class, empid);
            em.remove(em.merge(emp));
            em.getTransaction().commit();
            return emp;
        } finally {
            em.close();
        }
    }

}
