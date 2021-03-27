package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class Departments {

    List<Department> all = new ArrayList();

    public Departments() {
    }

    public Departments(List<Department> deps) {
        deps.forEach((d) -> {
            all.add(d);
        });
    }

    public List<Department> getAll() {
        return all;
    }

    public void setAll(List<Department> all) {
        this.all = all;
    }

}
