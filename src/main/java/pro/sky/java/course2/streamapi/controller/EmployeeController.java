package pro.sky.java.course2.streamapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.streamapi.book.Employee;
import pro.sky.java.course2.streamapi.service.EmployeeService;


import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int dept,
                                @RequestParam int salary){
        return employeeService.addEmployee(firstName,lastName,dept,salary);
    }
    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int dept,
                                   @RequestParam int salary){
        return employeeService.deleteEmployee(firstName,lastName,dept,salary);
    }

    @GetMapping("/pass")
    public Employee passEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int dept,
                                 @RequestParam int salary){
        return employeeService.passEmployee(firstName,lastName,dept,salary);
    }
    @GetMapping("/all")
    public Map<Integer, Set<Employee>> finedAll(){
        return employeeService.finedAll();
    }

    @GetMapping("/department/max-salary")
    public Employee maxSalary (@RequestParam int dept) {
        return employeeService.maxSalary(dept);
    }

    @GetMapping("/department/min-salary")
    public Employee minSalary (@RequestParam int dept) {
        return employeeService.minSalary(dept);
    }

    @GetMapping("/department/all")
    public Map<Integer, Set<Employee>> deptList (@RequestParam int dept){
        return employeeService.deptList(dept);
    }
}
