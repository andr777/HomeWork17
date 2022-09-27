package pro.sky.HomeWork17.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork17.Service.Employee;
import pro.sky.HomeWork17.Service.EmployeeServiceIInterface;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/emp")
public class EmpController {

    private final EmployeeServiceIInterface employeeServiceIInterface;


    @GetMapping(path = "add")
    public String Plus(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName) {
      String aaa =  employeeServiceIInterface.add(firstName, lastName);
         return " + " + firstName + " " + lastName + " " + aaa;
    }

    @GetMapping(path = "list")
    public String List(){
        return " список: " +  employeeServiceIInterface.employeeList();
    }

    @GetMapping(path = "find")
    public String Find(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName) {
        Employee fff = new Employee(firstName, lastName);
        if(employeeServiceIInterface.find(fff)){
            System.out.println("ArrayList find ");
            return " + " + firstName + " " + lastName + " найден в списке";
        } else {
            System.out.println("ArrayList NOT find ");
            return " + " + firstName + " " + lastName + " НЕ найден в списке";
        }
        //return " + " + firstName + " " + lastName + " найден в списке";
    }

    @GetMapping(path = "remove")
    public String remove(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName) {
        Employee fff = new Employee(firstName, lastName);
        if(employeeServiceIInterface.remove(fff)){
            System.out.println("ArrayList remove ");
            return " - " + firstName + " " + lastName + " remove в списке";
        } else {
            System.out.println("ArrayList NOT find ");
            return " + " + firstName + " " + lastName + " НЕ remove в списке";
        }
        //return " + " + firstName + " " + lastName + " найден в списке";
    }


}
/*
http://localhost:8080/emp/add?firstName=Vasia&lastName=Vasichkin

http://localhost:8080/emp/list

http://localhost:8080/emp/find?firstName=Vasia&lastName=Vasichkin

http://localhost:8080/emp/remove?firstName=Vasia&lastName=Vasichkin

 */