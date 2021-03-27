package DTOs;

import entities.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class DepartmentsDTO {

    List<DepartmentDTO> all = new ArrayList();

    public DepartmentsDTO(List<Department> departmentEntities) {
        departmentEntities.forEach((d) -> {
            all.add(new DepartmentDTO(d));
        });
    }

    public List<DepartmentDTO> getAll() {
        return all;
    }

    public void setAll(List<DepartmentDTO> all) {
        this.all = all;
    }

}
