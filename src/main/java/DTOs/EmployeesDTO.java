package DTOs;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class EmployeesDTO {

    List<EmployeeDTO> all = new ArrayList();

    public EmployeesDTO(List<Employee> employeeEntities) {
        employeeEntities.forEach((s) -> {
            all.add(new EmployeeDTO(s));
        });
    }

    public List<EmployeeDTO> getAll() {
        return all;
    }

    public void setAll(List<EmployeeDTO> all) {
        this.all = all;
    }

}
