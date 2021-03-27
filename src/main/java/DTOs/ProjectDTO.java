package DTOs;

import entities.Project;

/**
 *
 * @author claes
 */
public class ProjectDTO {

    private Long id;
    private String title;
    private int duration;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.duration = project.getDuration();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
