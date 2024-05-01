package view;

import controller.ManagementController;
import main.Employee;
import repo.EmployeeRepo;
import resourses.Tool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Objects;

public class ManagementView extends JFrame {
    JFrame frame = new JFrame();
    Tool myTool = new Tool();
    JPanel leftPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            // Draw a horizontal line across the panel at y-coordinate 200
            g2d.drawLine(70, 400, 330, 400);
        }
    };
    JLabel userLabel = new JLabel();
    JLabel welcomingLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JButton homeButton = new JButton();
    JButton addEmployeeButton = new JButton();
    JButton salaryButton = new JButton();
    JButton logoutButton = new JButton();
    JPanel homePanel = new JPanel();
    JPanel totalEmployeePanel = new JPanel();
    JLabel totalEmployeeIcon = new JLabel();
    JLabel totalEmployeeLabel = new JLabel();
    JPanel totalPresentPanel = new JPanel();
    JLabel totalPresentIcon = new JLabel();
    JLabel totalPresentLabel = new JLabel();
    JPanel totalInactiveEmployeePanel = new JPanel();
    JLabel totalInactiveEmployeeIcon = new JLabel();
    JLabel totalInactiveEmployeeLabel = new JLabel();
    JTable homeTable ;
    JScrollPane homeTablePanel = new JScrollPane();
    JButton refreshButton = new JButton("refresh");


    JPanel addEmployeePanel = new JPanel();
    JScrollPane tablePanel = new JScrollPane();
    JTable employeesTable = null;
    JButton refreshButton1 = new JButton();
    JLabel descriptionLabel = new JLabel("Modifying  Page");
    JLabel firstNameLabel = new JLabel("First Name :");
    JTextField firstNameField  = new JTextField();
    JLabel lastNameLabel = new JLabel("Last Name :");
    JTextField lastNameField = new JTextField();
    JLabel genderLabel = new JLabel("Gender :");
    String[]  genders = {"mael" , "female"};
    JComboBox<String> genderField = new JComboBox<>(genders);
    JLabel genderPlaceHolderLabel = new JLabel("choose");
    JLabel phoneLabel = new JLabel("Phone # : ");
    JTextField phoneField = new JTextField();
    JLabel positionLabel = new JLabel("position :");
    String[] positionsList = {"software Eng" , "cyberSecurity Eng" , "FrontEnd Developer" , "BackEnd Developer" , "Data Scientist"
            ,"Network Administrator" , "Database Administrator" ,"Systems Analyst" , "UI/UX Designer" , "Machine Learning Engineer" ,
            "IT Project Manager"};
    JComboBox<String> positionField = new JComboBox<>(positionsList);
    JLabel employeeIdLabel = new JLabel("Employee ID : ");
    JTextField idField = new JTextField();
    JLabel positionPlaceHolderLabel = new JLabel("choose");
    JButton clearButton = new JButton();
    JButton updateButton = new JButton();
    JButton addButton = new JButton();
    JButton deleteButton = new JButton();
    Employee employee = new Employee();


    JPanel salaryPanel = new JPanel();
    JLabel modifySalaryLabel = new JLabel("Modify your employees");
    JLabel modifySalaryLabel2 = new JLabel("salary");
    JLabel salaryLabel = new JLabel("Salary ($) :");
    JTextField salaryField = new JTextField();
    JLabel employeeIdLabelSalaryPanel = new JLabel("Employee ID : ");
    JTextField employeeIdFieldSalaryPanel = new JTextField();
    JScrollPane tablePanelSalaryPanel = new JScrollPane();
    JTable salaryTable = null;
    JButton updateButtonSalaryPanel = new JButton();
    JButton clearButtonSalaryPanel = new JButton();
    JButton refreshButton2 = new JButton();

    JPanel deleteAccountPanel = new JPanel();
    JButton deleteAccountButton = new JButton("Delete Account");
    JLabel idLabelDelete = new JLabel("Employee ID : ");
    JTextField idTextFieldDelete = new JTextField();
    JButton deleteButtonDelete = new JButton("Delete");
    JLabel detailsLabel = new JLabel("enter an employee ID to be deleted");
    JScrollPane loginInfoTablePanel = new JScrollPane();
    JTable loginInfoTable = null;
    JButton refreshButton3 = new JButton();


    public void view(ManagementController managementController){

        //init the frame
        frame.setSize(1600 , 1000);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        //inti the panels
        leftPanel.setBounds(0 , 0 ,400 , 1000 );
        leftPanel.setBackground(new Color(120 , 190 , 255));
        leftPanel.setLayout(null);
        homePanel.setBounds(400 , 0 , 1200 , 1000);
        homePanel.setBackground(new Color(50,50,50));
        homePanel.setLayout(null);
        frame.add(leftPanel);
        frame.add(homePanel);
        homePanel.setVisible(true);

        //add exit button
        myTool.addExitButton(leftPanel);

        //add userLabel
        userLabel.setBounds( 100 , 100 , 200 , 200 );
        myTool.addImageToLabel(userLabel,
                "/user.png",
                100 , 100 , 200 , 200);
        leftPanel.add(userLabel);

        //add welcoming label
        welcomingLabel.setText("Welcome Back");
        welcomingLabel.setBounds(0 , 340 , 400 , 20);
        welcomingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomingLabel.setFont(new Font(welcomingLabel.getFont().getName() , Font.ITALIC , 20));
        leftPanel.add(welcomingLabel);

        //add username label
        usernameLabel.setText("Sir");
        usernameLabel.setBounds(0 , 365 , 400 , 20);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font(userLabel.getFont().getName() , Font.BOLD , 20));
        leftPanel.add(usernameLabel);

        //add homeButton
        myTool.addIconToButton(homeButton ,
                "/home.png" ,
                70 , 450 , 260 , 40);
        homeButton.setText("  Home");
        homeButton.setHorizontalAlignment(SwingConstants.LEFT);
        homeButton.setFont(new Font(homeButton.getFont().getName() , Font.ITALIC , 20 ));
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployeePanel.setVisible(false);
                salaryPanel.setVisible(false);
                deleteAccountPanel.setVisible(false);
                homePanel.setVisible(true);
            }
        });
        leftPanel.add(homeButton);

        //add addEmployeeButton
        myTool.addIconToButton(addEmployeeButton ,
                "/adduser.png" ,
                70 , 500 , 260 , 40);
        addEmployeeButton.setText("  Add Employee");
        addEmployeeButton.setHorizontalAlignment(SwingConstants.LEFT);
        addEmployeeButton.setFont(new Font(addEmployeeButton.getFont().getName() , Font.ITALIC , 20 ));
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                salaryPanel.setVisible(false);
                deleteAccountPanel.setVisible(false);
                addEmployeePanel.setVisible(true);

            }
        });
        leftPanel.add(addEmployeeButton);


        //add salaryButton
        myTool.addIconToButton(salaryButton ,
                "/salary.png" ,
                70 , 550 , 260 , 40);
        salaryButton.setText("  Salary");
        salaryButton.setHorizontalAlignment(SwingConstants.LEFT);
        salaryButton.setFont(new Font(salaryButton.getFont().getName() , Font.ITALIC , 20 ));
        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteAccountPanel.setVisible(false);
                salaryPanel.setVisible(true);
            }
        });
        leftPanel.add(salaryButton);

        //add logout button
        myTool.addIconToButton(logoutButton,
                "/logout.png" ,
                100 , 900 , 200 , 40);
        logoutButton.setText("   Logout");
        logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
        logoutButton.setFont(new Font(logoutButton.getFont().getName() , Font.BOLD , 20));
        logoutButton.addActionListener(e -> managementController.logout());
        leftPanel.add(logoutButton);


        //add totalEmployee panel
        totalEmployeePanel.setBounds(30 , 50 , 360 , 200);
        totalEmployeePanel.setBackground(new Color(120 , 190 , 255));
        totalEmployeePanel.setLayout(null);
        homePanel.add(totalEmployeePanel);

        //add totalEmployeeLabel
        totalEmployeeLabel.setText("Total Employees");
        totalEmployeeLabel.setBounds(120 , 140 , 260 , 40);
        totalEmployeeLabel.setOpaque(false);
        totalEmployeeLabel.setFont(new Font(totalEmployeeLabel.getFont().getName() , Font.BOLD , 24));
        totalEmployeePanel.add(totalEmployeeLabel);

        //add totalEmployeeIcon
        totalEmployeeIcon.setBounds(40 , 40 , 80 , 80 );
        myTool.addImageToLabel(totalEmployeeIcon ,
                "/users.png" ,
                40 , 40 , 80 , 80 );
        totalEmployeePanel.add(totalEmployeeIcon);


        //add totalPresent panel
        totalPresentPanel.setBounds(420 , 50 ,360 , 200 );
        totalPresentPanel.setBackground(new Color(120 , 190 , 255));
        totalPresentPanel.setLayout(null);
        homePanel.add(totalPresentPanel);

        //add totalPresentLabel
        totalPresentLabel.setText("Total Presents");
        totalPresentLabel.setBounds(120 , 140 , 260 , 40);
        totalPresentLabel.setOpaque(false);
        totalPresentLabel.setFont(new Font(totalPresentLabel.getFont().getName() , Font.BOLD , 24));
        totalPresentPanel.add(totalPresentLabel);

        //add totalEmployeeIcon
        totalPresentIcon.setBounds(40 , 40 , 80 , 80 );
        myTool.addImageToLabel(totalPresentIcon ,
                "/check-mark.png" ,
                40 , 40 , 80 , 80 );
        totalPresentPanel.add(totalPresentIcon);


        //add totalInactiveEmployee panel
        totalInactiveEmployeePanel.setBounds(810 , 50 ,360 , 200 );
        totalInactiveEmployeePanel.setBackground(new Color(120 , 190 , 255));
        totalInactiveEmployeePanel.setLayout(null);
        homePanel.add(totalInactiveEmployeePanel);

        //add totalPresentLabel
        totalInactiveEmployeeLabel.setText("Total Inactive Employees");
        totalInactiveEmployeeLabel.setBounds(70 , 140 , 280 , 40);
        totalInactiveEmployeeLabel.setOpaque(false);
        totalInactiveEmployeeLabel.setFont(new Font(totalInactiveEmployeeLabel.getFont().getName() , Font.BOLD , 21));
        totalInactiveEmployeePanel.add(totalInactiveEmployeeLabel);

        //add totalEmployeeIcon
        totalInactiveEmployeeIcon.setBounds(30 , 40 , 80 , 80 );
        myTool.addImageToLabel(totalInactiveEmployeeIcon ,
                "/minus.png" ,
                30 , 40 , 80 , 80 );
        totalInactiveEmployeePanel.add(totalInactiveEmployeeIcon);


        //add homeTable
        homeTablePanel.setBounds(50 , 300 , 1100 , 650);
        homePanel.add(homeTablePanel);
        String[] col1 = new String[]{"ID" , "First Name" , "Last Name" , "Gender" , "Phone" , "Position" , "Salary" , "Online"};
        final Object[][][] data1 = {managementController.getHomeData()};
        DefaultTableModel model1 = new DefaultTableModel(data1[0], col1);
        homeTable = new JTable(model1);
        homeTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        homeTable.getTableHeader().setBackground(new Color(120 , 190 , 255));
        homeTable.setShowGrid(true);
        homeTable.setGridColor(new Color(192, 219, 245));
        homeTable.setRowHeight(20);
        homeTablePanel.setViewportView(homeTable);

        //add refreshButton
        refreshButton.setText("");
        myTool.addIconToButton(refreshButton ,
                "/refresh.png",
                100 , 260 , 30 , 30);
        refreshButton.setBackground(new Color(120 , 190 , 255));
        refreshButton.setOpaque(true);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model1.setDataVector(managementController.getHomeData() , col1);
            }
        });
        homePanel.add(refreshButton);

        ////////////////////////////
        //add addEmployeePanel
        addEmployeePanel.setBounds(400 , 0 , 1200 , 1000);
        addEmployeePanel.setBackground(new Color(50,50,50));
        addEmployeePanel.setLayout(null);
        frame.add(addEmployeePanel);
        addEmployeePanel.setVisible(false);


        //add tablePanel
        tablePanel.setBounds(50 , 150  , 1100 , 400);
        addEmployeePanel.add(tablePanel);
        //add employeesTable
        String[] col = new String[]{"ID" , "First Name" , "Last Name" , "Gender" , "Phone" , "Position" };
        Object[][] data = managementController.getData();
        DefaultTableModel model = new DefaultTableModel();
        model.setDataVector(data , col);
        employeesTable = new JTable(model);
        employeesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        employeesTable.getTableHeader().setBackground(new Color(120 , 190 , 255));
        employeesTable.setShowGrid(true);
        employeesTable.setGridColor(new Color(192, 219, 245));
        employeesTable.setRowHeight(20);
        tablePanel.setViewportView(employeesTable);

        //add refreshButton1
        myTool.addIconToButton(refreshButton1 ,
                "/refresh.png",
                70 , 100 , 40 , 40);
        refreshButton1.setBackground(new Color(120 , 190 , 255));
        refreshButton1.setOpaque(true);
        refreshButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDataVector(managementController.getData() , col);
                model1.setDataVector(managementController.getHomeData() , col1);
            }
        });
        addEmployeePanel.add(refreshButton1);


        //add descriptionLabel
        descriptionLabel.setBounds(900 , 50 , 200 , 40);
        descriptionLabel.setFont(new Font(descriptionLabel.getFont().getFontName() , Font.BOLD , 24));
        descriptionLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(descriptionLabel);

        //add firstNameLabel
        firstNameLabel.setBounds(70 , 660 , 150 , 30 );
        firstNameLabel.setFont(new Font(firstNameLabel.getFont().getName() , Font.BOLD , 18));
        firstNameLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(firstNameLabel);
        //add firstNameField
        firstNameField.setBounds(220, 650 , 200 , 40);
        addEmployeePanel.add(firstNameField);

        //add lastNameLabel
        lastNameLabel.setBounds(70 , 720 , 150 , 30 );
        lastNameLabel.setFont(new Font(lastNameLabel.getFont().getName() , Font.BOLD , 18));
        lastNameLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(lastNameLabel);
        //add employeeIdField
        lastNameField.setBounds(220, 710 , 200 , 40);
        addEmployeePanel.add(lastNameField);


        //add genderLabel
        genderLabel.setBounds(70 , 780 , 150 , 30 );
        genderLabel.setFont(new Font(genderLabel.getFont().getName() , Font.BOLD , 18));
        genderLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(genderLabel);
        //add choose label to gender field
        genderPlaceHolderLabel.setBounds(230 , 785 , 60 , 20);
        genderPlaceHolderLabel.setForeground(Color.GRAY);
        addEmployeePanel.add(genderPlaceHolderLabel);
        //add genderField
        genderField.setBounds(220 , 780 , 130 , 30 );
        genderField.setSelectedIndex(-1);
        genderField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                genderPlaceHolderLabel.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(genderField.getSelectedItem() == null)
                    genderPlaceHolderLabel.setVisible(true);
            }
        });
        addEmployeePanel.add(genderField);

        //add phoneLabel
        phoneLabel.setBounds(600 , 600 , 150 , 30 );
        phoneLabel.setFont(new Font(phoneLabel.getFont().getName() , Font.BOLD , 18));
        phoneLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(phoneLabel);
        //add phoneField
        phoneField.setBounds(750, 595 , 200 , 40);

        addEmployeePanel.add(phoneField);

        //add positionLabel
        positionLabel.setBounds(600 , 655 , 150 , 30 );
        positionLabel.setFont(new Font(positionLabel.getFont().getName() , Font.BOLD , 18));
        positionLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(positionLabel);
        //add choose label to position field
        positionPlaceHolderLabel.setBounds(760 , 662 , 60 , 20);
        positionPlaceHolderLabel.setForeground(Color.GRAY);
        addEmployeePanel.add(positionPlaceHolderLabel);
        //add positionField
        positionField.setBounds(750 , 660 , 250 , 30 );
        positionField.setSelectedIndex(-1);
        positionField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                positionPlaceHolderLabel.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(genderField.getSelectedItem() == null)
                    positionPlaceHolderLabel.setVisible(true);
            }
        });
        addEmployeePanel.add(positionField);

        //add employeeIdLabel
        employeeIdLabel.setBounds(70 , 600 , 150 , 30 );
        employeeIdLabel.setFont(new Font(employeeIdLabel.getFont().getName() , Font.BOLD , 18));
        employeeIdLabel.setForeground(new Color(120 , 190 , 255));
        addEmployeePanel.add(employeeIdLabel);

        //add idField
        idField.setBounds(220, 595 , 200 , 40);
        addEmployeePanel.add(idField);

        //add addButton
        addButton.setBounds(970 , 850 , 100 , 50 );
        addButton.setBackground( new Color(0, 102, 204));
        addButton.setText("Add");
        addButton.setBorderPainted(false);
        addButton.setOpaque(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(genderField.getSelectedIndex() >= 0 )
                    employee.gender = genderField.getSelectedItem().toString();
                else {
                    myTool.showErrorMassage("Pleas enter the gender");
                    return;
                }

                if(!firstNameField.getText().trim().isEmpty() )
                    employee.firstname = firstNameField.getText();
                else
                    employee.firstname = "-";

                if(!lastNameField.getText().trim().isEmpty())
                    employee.lastname = lastNameField.getText();
                else{
                    myTool.showErrorMassage("Pleas enter the last name");
                    return;
                }

                if(!phoneField.getText().trim().isEmpty())
                    employee.phone = phoneField.getText();

                if(positionField.getSelectedIndex() >= 0 )
                    employee.position = positionField.getSelectedItem().toString();
                else{
                    myTool.showErrorMassage("pleas enter the position");
                    return;
                }
                int h = managementController.addEmployee(employee);
                if(h == 0) {
                    myTool.showErrorMassage("something went wrong");
                    return;
                }
                else
                    myTool.showSuccessMassage("adding a new employee has done successfully");

                //model.addRow(new Object[]{employee.firstname , employee.lastname , employee.gender , employee.phone , employee.position});
                model.fireTableDataChanged();

            }
        });
        addEmployeePanel.add(addButton);


        //add updateButton
        updateButton.setBounds(850 , 850 , 100 , 50 );
        updateButton.setText("Update");
        updateButton.setBackground(new Color(255, 165, 0));
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!idField.getText().trim().isEmpty()) {
                    if (idField.getText().matches("\\d+"))
                        employee = managementController.getEmployee(Integer.parseInt(idField.getText()));
                    else {
                        myTool.showErrorMassage("Pleas enter a valid ID");
                        return;
                    }
                }else {
                    myTool.showErrorMassage("You have to enter an ID");
                    return;
                }

                if(genderField.getSelectedIndex() != -1) {
                    if (Objects.requireNonNull(genderField.getSelectedItem()).toString() != null)
                        employee.gender = genderField.getSelectedItem().toString();
                }
                if(!firstNameField.getText().trim().isEmpty())
                    employee.firstname = firstNameField.getText();

                if(!lastNameField.getText().trim().isEmpty())
                    employee.lastname = lastNameField.getText();

                if(!phoneField.getText().trim().isEmpty())
                    employee.phone = phoneField.getText();

                if(positionField.getSelectedIndex() != -1) {
                    if (Objects.requireNonNull(positionField.getSelectedItem()).toString() != null)
                        employee.position = positionField.getSelectedItem().toString();
                }
                int c = managementController.updateEmployee(employee);

                if(c != 0){
                    myTool.showSuccessMassage("updating has done");
                }else
                    myTool.showErrorMassage("This ID is not existed");
            }
        });
        updateButton.setOpaque(true);

        addEmployeePanel.add(updateButton);

        //add deleteButton
        deleteButton.setBounds(650 , 850 , 100 , 50 );
        deleteButton.setText("Delete");
        deleteButton.setBackground(new Color(220, 20, 60));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!idField.getText().trim().isEmpty()){
                    if(idField.getText().matches("\\d+")) {
                        employee = managementController.getEmployee(Integer.parseInt(idField.getText()));
                    }else{
                        myTool.showErrorMassage("Pleas enter a valid id");
                        return;
                    }
                }else {
                    myTool.showErrorMassage("Pleas enter an ID");
                    return;
                }

                int c2  ;
                int i = managementController.getLoginInfo(employee.id);
                if(i != 0){
                    myTool.showErrorMassage("First delete the employee account");
                }else {
                    c2 = managementController.deleteEmployee(employee.id);
                    if(c2 == 0 )
                        myTool.showErrorMassage("This ID is not existed");
                    else
                        myTool.showSuccessMassage("Deletion has done successfully");
                }



            }
        });
        addEmployeePanel.add(deleteButton);

        //add clearButton
        clearButton.setBounds(520 , 850 , 100 , 50 );
        clearButton.setText("Clear");
        clearButton.setBackground(new Color(192, 192, 192));
        clearButton.setBorderPainted(false);
        clearButton.setOpaque(true);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                genderField.setSelectedIndex(-1);
                phoneField.setText("");
                positionField.setSelectedIndex(-1);
            }
        });
        addEmployeePanel.add(clearButton);


        /////////////////////////////
        //add salaryPanel
        salaryPanel.setBounds(400 , 0 , 1200 , 1000);
        salaryPanel.setBackground(new Color(50,50,50));
        salaryPanel.setLayout(null);
        frame.add(salaryPanel);
        salaryPanel.setVisible(false);

        //add clearification
        modifySalaryLabel.setBounds(50 , 250 , 300 , 40);
        modifySalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modifySalaryLabel.setForeground(new Color(120 , 190 , 255));
        modifySalaryLabel.setFont(new Font(modifySalaryLabel.getFont().getName() , Font.BOLD , 20));

        modifySalaryLabel2.setBounds(50 , 300 , 300 , 30 );
        modifySalaryLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        modifySalaryLabel2.setForeground(new Color(120 , 190 , 255));
        modifySalaryLabel2.setFont(new Font(modifySalaryLabel2.getFont().getName() , Font.BOLD , 20));
        salaryPanel.add(modifySalaryLabel2);
        salaryPanel.add(modifySalaryLabel);

        //add employeeIdLabelSalaryPanel
        employeeIdLabelSalaryPanel.setBounds(50 , 400 , 150 , 30);
        employeeIdLabelSalaryPanel.setForeground(new Color(120 , 190 , 255));
        employeeIdLabelSalaryPanel.setFont(new Font(employeeIdLabelSalaryPanel.getFont().getName() , Font.ITALIC , 18));
        salaryPanel.add(employeeIdLabelSalaryPanel);

        //add employeeIdFieldSalaryPanel
        employeeIdFieldSalaryPanel.setBounds(180 , 395 , 200 , 40);
        salaryPanel.add(employeeIdFieldSalaryPanel);

        //add salaryLabel
        salaryLabel.setBounds(50 , 460 , 100 , 30);
        salaryLabel.setForeground(new Color(120 , 190 , 255));
        salaryLabel.setFont(new Font(salaryLabel.getFont().getName() , Font.ITALIC , 18));
        salaryPanel.add(salaryLabel);

        //add salaryField
        salaryField.setBounds(180 , 455 , 200 , 40);
        salaryPanel.add(salaryField);

        //add tablePanel
        tablePanelSalaryPanel.setBounds(430 , 100  , 720 , 800);
        salaryPanel.add(tablePanelSalaryPanel);

        //add employeesTable
        String[] colSalaryTable = new String[]{"ID" , "First Name" , "Last Name" , "Position" , "Salary" };
        final Object[][][] dataSalaryTable = {managementController.getSalaryData()};
        DefaultTableModel modelSalaryTable = new DefaultTableModel(dataSalaryTable[0], colSalaryTable);
        salaryTable = new JTable(modelSalaryTable);
        salaryTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        salaryTable.getTableHeader().setBackground(new Color(120 , 190 , 255));
        salaryTable.setShowGrid(true);
        salaryTable.setGridColor(new Color(192, 219, 245));
        salaryTable.setRowHeight(20);
        tablePanelSalaryPanel.setViewportView(salaryTable);

        //add refreshButton2

        myTool.addIconToButton(refreshButton2 ,
                "/refresh.png",
                450 , 55 , 40 , 40);
        refreshButton2.setBackground(new Color(120 , 190 , 255));
        refreshButton2.setOpaque(true);
        refreshButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelSalaryTable.setDataVector(managementController.getSalaryData() , colSalaryTable);
            }
        });
        salaryPanel.add(refreshButton2);


        //add clearButtonSalaryPanel
        clearButtonSalaryPanel.setBounds(100 , 540 , 100 , 40 );
        clearButtonSalaryPanel.setText("Clear");
        clearButtonSalaryPanel.setBackground(new Color(192, 192, 192));
        clearButtonSalaryPanel.setBorderPainted(false);
        clearButtonSalaryPanel.setOpaque(true);
        clearButtonSalaryPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeIdFieldSalaryPanel.setText("");
                salaryField.setText("");
            }
        });
        salaryPanel.add(clearButtonSalaryPanel);


        //add updateButtonSalaryPanel
        updateButtonSalaryPanel.setBounds(230 , 540 , 100 , 40 );
        updateButtonSalaryPanel.setText("Update");
        updateButtonSalaryPanel.setBackground( new Color(0, 102, 204));
        updateButtonSalaryPanel.setBorderPainted(false);
        updateButtonSalaryPanel.setOpaque(true);
        updateButtonSalaryPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!employeeIdFieldSalaryPanel.getText().trim().isEmpty()){
                    if(employeeIdFieldSalaryPanel.getText().matches("\\d+"))
                        employee = managementController.getEmployee(Integer.parseInt(employeeIdFieldSalaryPanel.getText()));
                    else {
                        myTool.showErrorMassage("Pleas enter a valid ID");
                        return;
                    }
                }else {
                    myTool.showErrorMassage("Pleas enter an ID");
                    return;
                }
                if(employee.id != 0) {
                    if (!salaryField.getText().trim().isEmpty()) {
                        if (salaryField.getText().matches("\\d+"))
                            employee.salary = Integer.parseInt(salaryField.getText());
                        else {
                            myTool.showErrorMassage("Pleas enter a valid salary");
                            return;
                        }
                    } else {
                        myTool.showErrorMassage("Pleas enter a salary");
                        return;
                    }

                    int c = managementController.updateEmployeeSalary(employee);
                    if(c != 0)
                        myTool.showSuccessMassage("Updating has done successfully");
                    else {
                        myTool.showErrorMassage("No updating has been done");
                    }
                }else{
                    myTool.showErrorMassage("This ID is not existed");
                }
            }

        });
        salaryPanel.add(updateButtonSalaryPanel);

        ////////////////////////////
        //add DeleteAccountPanel
        deleteAccountPanel.setBounds(400 , 0 , 1200 , 1000);
        deleteAccountPanel.setBackground(new Color(50,50,50));
        deleteAccountPanel.setLayout(null);
        frame.add(deleteAccountPanel);
        deleteAccountPanel.setVisible(false);

        //add deleteAccountButton
        myTool.addIconToButton(deleteAccountButton ,
                "/delete.png" ,
                70 , 610 , 260 , 40);
        deleteAccountButton.setText("  Delete Account");
        deleteAccountButton.setHorizontalAlignment(SwingConstants.LEFT);
        deleteAccountButton.setFont(new Font(deleteAccountButton.getFont().getName() , Font.ITALIC , 20 ));
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                salaryPanel.setVisible(false);
                deleteAccountPanel.setVisible(true);
            }
        });
        leftPanel.add(deleteAccountButton);

        //add idLabelDelete
        idLabelDelete.setBounds(100 , 200 , 150 , 40);
        idLabelDelete.setForeground(new Color(120 , 190 , 255));
        idLabelDelete.setFont(new Font(idLabelDelete.getFont().getName() , Font.ITALIC , 20));
        idLabelDelete.setHorizontalAlignment(SwingConstants.LEFT);
        deleteAccountPanel.add(idLabelDelete);

        //add idTextFieldDelete
        idTextFieldDelete.setBounds(250 , 200 , 100 , 40);
        deleteAccountPanel.add(idTextFieldDelete);

        //add deleteButtonDelete
        deleteButtonDelete.setBounds(90 , 320 , 150 , 50 );
        deleteButtonDelete.setBackground(Color.red);
        deleteButtonDelete.setOpaque(true);
        deleteButtonDelete.setBorderPainted(false);
        deleteButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!idTextFieldDelete.getText().trim().isEmpty()){
                    int r ;
                    if(idTextFieldDelete.getText().matches("\\d+")) {
                        r = managementController.deleteLoginInfo(Integer.parseInt(idTextFieldDelete.getText()));
                    }else {
                        myTool.showErrorMassage("Enter a valid ID");
                        return;
                    }
                    if(r != 0){
                        myTool.showSuccessMassage("Deletion has done successfully");
                        return;
                    }else {
                        myTool.showErrorMassage("This id is not existed");
                    }
                }else
                    myTool.showErrorMassage("Enter an ID");
            }
        });
        deleteAccountPanel.add(deleteButtonDelete);

        //add loginInfoTablePanel
        loginInfoTablePanel.setBounds(400 , 110 , 750 , 790);
        deleteAccountPanel.add(loginInfoTablePanel);

        //add loginInfoTable
        String[] col2 = new String[]{"ID" ,"username"};
        final Object[][][] data2 = {managementController.getLoginInfo()};
        DefaultTableModel model2 = new DefaultTableModel(data2[0], col2);
        loginInfoTable = new JTable(model2);
        loginInfoTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        loginInfoTable.getTableHeader().setBackground(new Color(120 , 190 , 255));
        loginInfoTable.setShowGrid(true);
        loginInfoTable.setGridColor(new Color(192, 219, 245));
        loginInfoTable.setRowHeight(30);
        loginInfoTablePanel.setViewportView(loginInfoTable);

        //add refreshButton3
        myTool.addIconToButton(refreshButton3 ,
                "/refresh.png" ,
                420 , 60 , 40 , 40);
        refreshButton3.setBackground(new Color(120 , 190, 255));
        refreshButton3.setOpaque(true);
        refreshButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model2.setDataVector(managementController.getLoginInfo() , col2);
            }
        });
        deleteAccountPanel.add(refreshButton3);

        frame.setVisible(true);
    }

    public void mainFrameVisibility (boolean e){
        frame.setVisible(e);
    }
}