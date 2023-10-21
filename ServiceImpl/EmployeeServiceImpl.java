package pro.sky.HomeWorkEmployeeMapTwo.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeStorageIsFullException;
import pro.sky.HomeWorkEmployeeMapTwo.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMapTwo.Model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {

    public final int NUMBER_OF_EMPLOYEES = 10;

    private final List<Employee> employeesList;

    public EmployeeServiceImpl() {
        this.employeesList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeesList.size() > NUMBER_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }

        if (employeesList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }
        employeesList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesList.contains(employee)) {
            employeesList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeesList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeesList);
    }
}
