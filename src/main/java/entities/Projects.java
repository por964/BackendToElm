package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class Projects {

    List<Project> all = new ArrayList();

    public Projects() {
    }

    public Projects(List<Project> projs) {
        projs.forEach((p) -> {
            all.add(p);
        });
    }

    public List<Project> getAll() {
        return all;
    }

    public void setAll(List<Project> all) {
        this.all = all;
    }

}
