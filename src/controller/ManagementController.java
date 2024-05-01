package controller;

import main.Employee;
import repo.EmployeeRepo;
import view.LoginView;
import view.ManagementView;
import view.SignUpView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ManagementController {
    private final EmployeeRepo employeeRepo = new EmployeeRepo();
    private final ManagementView managementView ;

    public ManagementController(ManagementView managementView){
        this.managementView = managementView;
    }

    public int  addEmployee(Employee employee){
        return employeeRepo.insertEmployee(employee);

    }

    public Employee getEmployee(int id){
        return employeeRepo.getEmployee(id);
    }

    public int updateEmployee(Employee employee){
        return employeeRepo.updateEmployee(employee);
    }

    public int updateEmployeeSalary(Employee employee){
        return employeeRepo.updateEmployeeSalary(employee);
    }

    public int  deleteEmployee(int id){
        return employeeRepo.deleteEmployee(id);
    }

    public int deleteLoginInfo(int id){
        return employeeRepo.deleteLoginInfo(id);
    }

    public void logout(){
        JFrame asking = new JFrame("woaning");
        JLabel warning = new JLabel("Are you sure you want to exit the program!");

        JButton no = new JButton("No");
        JButton yes = new JButton("Yes");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        asking.setSize(500 , 200);
        asking.setLayout(null);
        asking.setLocationRelativeTo(null);
        asking.setUndecorated(true);


        panel.setBounds(0 , 0 , 500 , 200);
        asking.add(panel);
        warning.setBounds(50 , 60 , 400 , 40 );
        warning.setHorizontalAlignment(SwingConstants.CENTER);
        warning.setFont(new Font(warning.getFont().getName() , Font.ITALIC , 18));
        panel.add(warning);
        asking.setVisible(true);

        yes.setBounds(310 , 140 , 70 , 30);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managementView.mainFrameVisibility(false);
                asking.setVisible(false);
                System.exit(0);
//                System.exit(0);

            }
        });
        no.setBounds(400 , 140 , 70 , 30);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asking.setVisible(false);
                return;
            }
        });
        panel.add(no);
        panel.add(yes);
    }

    public Object[][] getData(){
        return employeeRepo.getData();
    }

    public Object[][] getSalaryData(){
        return  employeeRepo.getSalaryData();
    }

    public Object[][] getHomeData(){
        return  employeeRepo.getHomeData();
    }

    public Object[][] getLoginInfo(){
        return  employeeRepo.getLoginInfo();
    }

    public int getLoginInfo(int id){
        return employeeRepo.getLoginInfo(id);
    }
}
