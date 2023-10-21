package pro.sky.HomeWorkEmployeeMapTwo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.HomeWorkEmployeeMapTwo.Model.Employee;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeesList = List.of(
                new Employee("Влад", "Волков"),
                new Employee("Артем", "Верблюдов"),
                new Employee("Людмила", "Иванова"),
                new Employee("Игорь", "Криштоп"),
                new Employee("Павел", "Носков"),
                new Employee("Иван", "Могиш"),
                new Employee("Роберт", "Блинов"),
                new Employee("Сергей", "Арбузов"),
                new Employee("Павел", "Аленчев")
        );
    }
}
