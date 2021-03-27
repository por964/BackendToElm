package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class Employees {

    List<Employee> all = new ArrayList();

    public Employees() {
    }

    public Employees(List<Employee> emps) {
        emps.forEach((e) -> {
            all.add(e);
        });
    }

    public List<Employee> getAll() {
        return all;
    }

    public void setAll(List<Employee> all) {
        this.all = all;
    }

}
