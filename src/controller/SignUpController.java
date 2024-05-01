package controller;

import main.Employee;
import repo.EmployeeRepo;
import resourses.Tool;
import view.LoginView;
import view.SignUpView;

import javax.swing.*;

public class SignUpController extends JFrame {
    EmployeeRepo employeeRepo = new EmployeeRepo() ;
    LoginView loginView ;
    SignUpView signUpView ;
    Tool tool = new Tool();

    public SignUpController(LoginView loginView , SignUpView signUpView){
        this.loginView = loginView ;
        this.signUpView = signUpView;
    }

    public void signUp(String username , String password , int id){
        Employee employee = employeeRepo.getEmployee(id);
        if(employee.id != 0 ){
            employeeRepo.insertTOLoginInfo(username , password , id);
            tool.showSuccessMassage("Congratulations now you have an account");
        }else {
            tool.showErrorMassage("talk to your manager to add you");
        }
    }

    public void login(){
        signUpView.mainFrameVisibility(false);
        loginView.mainFrameVisibility(true);
    }

}
