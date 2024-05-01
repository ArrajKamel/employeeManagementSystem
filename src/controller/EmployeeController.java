package controller;

import main.Employee;
import repo.EmployeeRepo;
import resourses.Tool;

public class EmployeeController {
    Tool tool = new Tool();
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public Employee getEmployee(int id){
        return this.employeeRepo.getEmployee(id);
    }

    public void  setOnline(int id ){
        int r = employeeRepo.setOnline(id);
        if (r != 0 )
            tool.showSuccessMassage("your online now");
        else
            tool.showErrorMassage("be careful something went wrong");
    }

    public void setOffline(int id){
        int r = employeeRepo.setOffline(id);
        if (r != 0 )
            tool.showSuccessMassage("your Offline now");
        else
            tool.showErrorMassage("be careful something went wrong");

    }
}
