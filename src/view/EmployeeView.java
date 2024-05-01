package view;

import controller.EmployeeController;
import main.Employee;
import resourses.Tool;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
    Tool myTool = new Tool();
    JFrame frame = new JFrame();
    JPanel leftPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            // Draw a horizontal line across the panel at y-coordinate 200
            g2d.drawLine(50, 320, 250, 320);
        }
    };
    JLabel welcomeLabel = new JLabel("welcome back,");
    JLabel userIcon = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel detailLabel1 = new JLabel();

    JPanel rightPanel = new JPanel();
    JLabel firstNameLabel = new JLabel("First Name : ");
    JLabel realFirstNameLabel = new JLabel();
    JLabel lastNameLabel = new JLabel("Last Name :");
    JLabel realLastNameLabel = new JLabel();
    JLabel idLabel = new JLabel("My ID : ");
    JLabel realsIdLabel = new JLabel();
    JLabel positionLabel = new JLabel("My position : ");
    JLabel realPositionLabel = new JLabel();
    JLabel phoneLabel = new JLabel("My number : ");
    JLabel realPhoneLabel = new JLabel();
    JLabel salaryLabel = new JLabel("My salary : ");
    JLabel realSalaryLabel = new JLabel();
    JButton onlineButton = new JButton("online");
    JButton offlineButton = new JButton("offline");

    public void view (EmployeeController employeeController , int id){
        Employee employee = employeeController.getEmployee(id);
        frame.setSize(1000 , 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        //init the panels
        leftPanel.setBounds(0 , 0 , 300 , 500);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(120 , 190 , 255));
        frame.add(leftPanel);
        rightPanel.setBounds(300 , 0 , 800 , 500);
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(50 , 50 , 50 ));
        frame.add(rightPanel);

        //exit button
        myTool.addExitButton(leftPanel);

        //add userIcon
        userIcon.setBounds( 50 , 50 , 200 , 200 );
        myTool.addImageToLabel(userIcon,
                "/user.png",
                50 , 50 , 200 , 200);
        leftPanel.add(userIcon);

        //add welcomeLabel
        welcomeLabel.setBounds(50 , 250 , 200 , 30);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName() , Font.ITALIC , 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(welcomeLabel);

        //add usernameLabel
        usernameLabel.setText(employee.firstname);
        usernameLabel.setBounds(50 , 280 , 200 , 30);
        usernameLabel.setFont(new Font(usernameLabel.getFont().getName() , Font.BOLD , 20));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(usernameLabel);

        //add detailLabel
        detailLabel1.setText("don't forget to press 'online'");
        detailLabel1.setBounds(10 , 350 , 280 , 30);
        detailLabel1.setFont(new Font(detailLabel1.getFont().getName() , Font.ITALIC , 16));
        detailLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(detailLabel1);

        //add firstNameLabel
        firstNameLabel.setBounds(20 , 50 , 150 , 40);
        firstNameLabel.setFont(new Font(firstNameLabel.getFont().getName() , Font.ITALIC , 20));
        firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        firstNameLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(firstNameLabel);

        //add realFirstNameLabel
        realFirstNameLabel.setText(employee.firstname);
        realFirstNameLabel.setBounds(170 , 50 , 150 , 40);
        realFirstNameLabel.setFont(new Font(realFirstNameLabel.getFont().getName() , Font.ITALIC , 20));
        realFirstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realFirstNameLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realFirstNameLabel);

        //add lastNameLabel
        lastNameLabel.setBounds(20 , 120 , 150 , 40);
        lastNameLabel.setFont(new Font(lastNameLabel.getFont().getName() , Font.ITALIC , 20));
        lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lastNameLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(lastNameLabel);

        //add realLastNameLabel
        realLastNameLabel.setText(employee.lastname);
        realLastNameLabel.setBounds(170 , 120 , 150 , 40);
        realLastNameLabel.setFont(new Font(realLastNameLabel.getFont().getName() , Font.ITALIC , 20));
        realLastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realLastNameLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realLastNameLabel);

        //add phoneLabel
        phoneLabel.setBounds(20 , 190 , 150 , 40);
        phoneLabel.setFont(new Font(phoneLabel.getFont().getName() , Font.ITALIC , 20));
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(phoneLabel);

        //add realPhoneLabel
        System.out.println(employee.phone);
        realPhoneLabel.setText(employee.phone);
        realPhoneLabel.setBounds(170 , 190 , 150 , 40);
        realPhoneLabel.setFont(new Font(realPhoneLabel.getFont().getName() , Font.ITALIC , 20));
        realPhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realPhoneLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realPhoneLabel);

        //add positionLabel
        positionLabel.setBounds(20 , 260 , 150 , 40);
        positionLabel.setFont(new Font(positionLabel.getFont().getName() , Font.ITALIC , 20));
        positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        positionLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(positionLabel);

        //add realPositionLabel
        realPositionLabel.setText(employee.position);
        realPositionLabel.setBounds(170 , 260 , 150 , 40);
        realPositionLabel.setFont(new Font(realPositionLabel.getFont().getName() , Font.ITALIC , 20));
        realPositionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realPositionLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realPositionLabel);

        //add salaryLabel
        salaryLabel.setBounds(20 , 330 , 150 , 40);
        salaryLabel.setFont(new Font(salaryLabel.getFont().getName() , Font.ITALIC , 20));
        salaryLabel.setHorizontalAlignment(SwingConstants.LEFT);
        salaryLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(salaryLabel);

        //add realSalaryLabel
        realSalaryLabel.setText(String.valueOf(employee.salary));
        realSalaryLabel.setBounds(170 , 330 , 150 , 40);
        realSalaryLabel.setFont(new Font(realSalaryLabel.getFont().getName() , Font.ITALIC , 20));
        realSalaryLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realSalaryLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realSalaryLabel);

        //add idLabel
        idLabel.setBounds(20 , 400 , 150 , 40);
        idLabel.setFont(new Font(idLabel.getFont().getName() , Font.ITALIC , 20));
        idLabel.setHorizontalAlignment(SwingConstants.LEFT);
        idLabel.setForeground(new Color(130 , 100 , 250));
        rightPanel.add(idLabel);

        //add reaIdLabel
        realsIdLabel.setText(String.valueOf(employee.id));
        realsIdLabel.setBounds(170 , 400 , 150 , 40);
        realsIdLabel.setFont(new Font(realsIdLabel.getFont().getName() , Font.ITALIC , 20));
        realsIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
        realsIdLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(realsIdLabel);

        //add onlineButton
        onlineButton.setBounds(450 , 150 , 200 , 50);
        onlineButton.setOpaque(true);
        onlineButton.setBorderPainted(false);
        onlineButton.setBackground(new Color(120 , 255 , 190));
        onlineButton.addActionListener(e -> employeeController.setOnline(employee.id));
        rightPanel.add(onlineButton);

        //add offlineButton
        offlineButton.setBounds(450 , 250 , 200 , 50);
        offlineButton.setOpaque(true);
        offlineButton.setBorderPainted(false);
        offlineButton.setBackground(new Color(130 , 100 , 250));
        offlineButton.addActionListener(e -> employeeController.setOffline(employee.id));
        rightPanel.add(offlineButton);

        frame.setVisible(true);
    }
}
