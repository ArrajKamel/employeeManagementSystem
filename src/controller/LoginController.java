package controller;

import main.Employee;
import repo.EmployeeRepo;
import resourses.Tool;
import view.EmployeeView;
import view.LoginView;
import view.ManagementView;
import view.SignUpView;

import java.sql.SQLException;

public class LoginController {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    LoginView loginView;
    ManagementView managementView = new ManagementView() ;
    ManagementController managementController = new ManagementController(managementView);
    SignUpView signUpView;

    SignUpController signUpController ;

    EmployeeView employeeView = new EmployeeView() ;

    EmployeeController employeeController = new EmployeeController();
    Tool myTool = new Tool();

    public LoginController(LoginView loginView , SignUpView signUpView) {
        this.loginView = loginView;
        this.signUpView = signUpView;
        this.signUpController = new SignUpController(loginView , signUpView);
    }

    public void check(String username , String password) throws SQLException {
        int id = this.employeeRepo.checking(username , password);
        if(id != 0){
            Employee employee = this.employeeRepo.getEmployee(id);
            if(employee != null) {
                myTool.showSuccessMassage("login successfully!");
                this.loginView.mainFrameVisibility(false);
                if(employee.isEmployee == 0)
                    managementView.view(managementController);
                else
                    employeeView.view(employeeController , employee.id);
            }else {
                myTool.showErrorMassage("this account is not existed");
            }
        }
        else
            myTool.showErrorMassage("password or username is wrong");
    }

    public void signUpPage(){
        this.loginView.mainFrameVisibility(false);
        this.signUpView.view(this.signUpController);
    }
}
