package DTOs;

import entities.Department;

/**
 *
 * @author claes
 */
public class DepartmentDTO {

    private Long id;
    private String code;
    private String name;
    private String description;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.code = department.getCode();
        this.name = department.getName();
        this.description = department.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
