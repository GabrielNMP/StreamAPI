package pro.sky.java.course2.streamapi.service;
import pro.sky.java.course2.streamapi.book.Employee;

import java.util.Map;
import java.util.Set;

public interface EmployeeService {
    Employee passEmployee (String firstName, String lastName, int dept, int salary);
    Employee addEmployee (String firstName, String lastName, int dept, int salary);
    Employee deleteEmployee (String firstName, String lastName, int dept, int salary);

    Map<Integer, Set<Employee>> finedAll();

    Employee maxSalary(int dept);

    Employee minSalary(int dept);

    Map<Integer, Set<Employee>> deptList(int dept);
}
