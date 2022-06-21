package pro.sky.java.course2.streamapi.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.streamapi.book.Employee;
import pro.sky.java.course2.streamapi.exception.EmployeeAlredyInnExceptions;
import pro.sky.java.course2.streamapi.exception.EmployeeNotFoudExceptions;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String,Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    private String getKey(Employee employee){
        return employee.getFirstName() + employee.getLastName();
    }

    //поиск сотрудника
    @Override
    public Employee passEmployee(String firstName, String lastName, int dept, int salary) {
        Employee employee = new Employee(firstName,lastName, dept, salary);
        if (employeeMap.containsKey(getKey(employee))){
            return employee;
        }
        throw new EmployeeNotFoudExceptions();
    }

    // добавление сотрудника
    @Override
    public Employee addEmployee(String firstName, String lastName, int dept, int salary) {
        Employee employee = new Employee(firstName,lastName, dept, salary);
        if (employeeMap.containsKey(getKey(employee))){
            throw new EmployeeAlredyInnExceptions();
        }
        employeeMap.put(getKey(employee),employee);
        return employee;
    }

    // удаление сотрудника
    @Override
    public Employee deleteEmployee(String firstName, String lastName, int dept, int salary) {
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employeeMap.containsKey(getKey(employee))){
            employeeMap.remove(getKey(employee),employee);
            return employee;
        }
        throw new EmployeeNotFoudExceptions();
    }

    //весь список отсортированный по отделам
    @Override
    public Map<Integer, Set<Employee>> finedAll() {
        return employeeMap.keySet().stream()
                .map(d ->employeeMap.get(d))
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.toSet()));
    }

    // сотрудник в отделе с максимальной зп
    @Override
    public Employee maxSalary(int dept) {
        return employeeMap.entrySet().stream()
                .map(e -> e.getValue())
                .filter(p -> p.getDept() == dept)
                .max(Comparator.comparingInt(c -> c.getSalary())).get();
    }

    //сотрудник в отделе с минимальной зп
    @Override
    public Employee minSalary(int dept) {
        return employeeMap.entrySet().stream()
                .map(e -> e.getValue())
                .filter(p -> p.getDept() == dept)
                .min(Comparator.comparingInt(c -> c.getSalary())).get();
    }

    // список сотрудников определённого отдела
    @Override
    public Map<Integer, Set<Employee>> deptList (int dept) {
        return employeeMap.keySet().stream()
                .filter(n -> employeeMap.get(n).getDept() ==dept)
                .map(n -> employeeMap.get(n))
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.toSet()));
    }


}
