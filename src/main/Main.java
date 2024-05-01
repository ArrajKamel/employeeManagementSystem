//initially you can login as an HR with username "bogdan24" and password "0000"
//                        as an employee username "kamel24" and password "1111"
package main;

import com.mysql.cj.log.Log;
import controller.EmployeeController;
import controller.LoginController;
import controller.ManagementController;
import controller.SignUpController;
import repo.EmployeeRepo;
import view.EmployeeView;
import view.LoginView;
import view.ManagementView;
import view.SignUpView;

import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView() ;
        SignUpView signUpView = new SignUpView();
        LoginController loginController = new LoginController(loginView , signUpView) ;
        loginView.view(loginController);

    }
}