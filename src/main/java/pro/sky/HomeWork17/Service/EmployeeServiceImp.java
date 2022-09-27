package pro.sky.HomeWork17.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork17.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.HomeWork17.Exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImp implements EmployeeServiceIInterface {

    List<Employee> employeesList = new ArrayList<>();
    Map<String, Employee> employeesListMap = new HashMap<>();

    @Override
    public String add(String firstName, String lastName) {

        Employee employees = new Employee(firstName, lastName);


        boolean f = false;

        if (find(employees)) {
            System.out.println(employees + " этот уже есть в списке.");
            f = true;
            throw new EmployeeAlreadyAddedException();
        } else {
            employeesListMap.put(firstName + ' ' + lastName, employees);
            System.out.println('\n' + " Добавлен: Фамилия='" + firstName + '\'' +
                    ", Имя='" + lastName + '\'');
        }

        return "ok";
    }

    @Override
    public String employeeList() {
        System.out.println(" список: " + employeesListMap);
        return employeesListMap.toString();
    }

    @Override
    public boolean find(Employee fff) {
        boolean f = false;

        f = employeesListMap.containsValue(fff);

        return f;
    }

    @Override
    public boolean remove(Employee fff) {
        boolean f = false;

        if (find(fff)) {
            employeesListMap.remove(fff.getFirstName() + " " + fff.getLastName());
            System.out.println(fff + " удалён  ");
            f = true;

        } else {
            System.out.println(fff + " не найден");
            f = false;
            throw new EmployeeNotFoundException();

        }


        return f;
    }


}
