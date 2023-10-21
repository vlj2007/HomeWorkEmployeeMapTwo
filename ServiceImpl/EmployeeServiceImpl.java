package pro.sky.HomeWorkEmployeeMapTwo.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMapTwo.Exception.EmployeeStorageIsFullException;
import pro.sky.HomeWorkEmployeeMapTwo.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMapTwo.Model.Employee;

import java.util.Map;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {

    public final int NUMBER_OF_EMPLOYEES = 10;

    private final Map<String, Employee> employeesMap;

    public EmployeeServiceImpl() {
        this.employeesMap = new HashMap();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String name = firstName + lastName;

        if (employeesMap.size() > NUMBER_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }

        if (employeesMap.containsKey(name)) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }

        employeesMap.put(name, employee);
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String name = firstName + lastName;
        if (employeesMap.containsKey(name)) {
            return employeesMap.remove(name);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return Optional.ofNullable(employeesMap.get(firstName + lastName)).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<String, Employee> findAll() {
        return employeesMap;
    }
}
