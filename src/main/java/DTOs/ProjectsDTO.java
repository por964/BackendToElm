package DTOs;

import entities.Project;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class ProjectsDTO {

    List<ProjectDTO> all = new ArrayList();

    public ProjectsDTO(List<Project> projectEntities) {
        projectEntities.forEach((p) -> {
            all.add(new ProjectDTO(p));
        });
    }

    public List<ProjectDTO> getAll() {
        return all;
    }

    public void setAll(List<ProjectDTO> all) {
        this.all = all;
    }

}
