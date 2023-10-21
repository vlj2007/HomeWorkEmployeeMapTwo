package pro.sky.HomeWorkEmployeeMapTwo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeMapTwo.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMapTwo.Model.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeInterface service;

    public EmployeeController(EmployeeInterface service) {
        this.service = service;

    }

    @GetMapping(path = "/add")
    public Employee employeeAdd(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee employeeRemove(@RequestParam(required = true) String firstName,
                                   @RequestParam(required = true) String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee employeeFind(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll().values();
    }

}
