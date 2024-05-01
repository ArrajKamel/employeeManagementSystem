package view;

import controller.SignUpController;
import resourses.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

public class SignUpView extends JFrame {
    String path = "/Users/kamelarraj/Desktop/EMS/src/resourses/";
    JFrame frame = new JFrame();
    JPanel leftPanel = new JPanel();
    JLabel welcomeLabel = new JLabel("Welcome to our company");
    JLabel welcomeIcon = new JLabel();
    JLabel detailsLabel = new JLabel("Pleas make sure you have talked to the HR");
    JLabel restLabel = new JLabel("to add you to the database");
    JLabel explainLabel = new JLabel();
    JPanel rightPanel = new JPanel();
    JLabel instructionLabel = new JLabel("Create your own username and password");
    JLabel usernameLabel = new JLabel("Username");
    JTextField usernameField = new JTextField();
    JLabel passwordLabel = new JLabel("Password");
    JTextField passwordField = new JTextField();
    JLabel idLabel = new JLabel("your ID");
    JTextField idField = new JTextField();
    JButton signUpButton = new JButton("Sign Up");

    JButton loginButton = new JButton("login");

    public void view (SignUpController signUpController){
        Tool myTool = new Tool();
        //init the frame
        frame.setSize(800 ,  600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setUndecorated(true);
        frame.setLayout(new GridLayout(1 , 2));
        //inti the panels
        leftPanel.setBounds(0 , 0 , 400 , 600);
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(120 , 190 , 255));
        frame.add(leftPanel);
        rightPanel.setBounds(400 , 0 , 400 , 600);
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(40 , 40 , 40));
        frame.add(rightPanel);



        myTool.addImageToLabel(welcomeIcon ,
                path+"welcome.png",
                100 , 50 , 200 , 200);
        leftPanel.add(welcomeIcon);

        //add welcomeLabel
        welcomeLabel.setBounds(50 , 270 , 300 , 30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName() , Font.BOLD , 18));
        leftPanel.add(welcomeLabel);

        //add detailsLabel
        detailsLabel.setBounds(10 , 350 , 380 , 30);
        detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        detailsLabel.setFont(new Font(detailsLabel.getFont().getName() , Font.BOLD , 14));
        leftPanel.add(detailsLabel);

        //add restLabel
        //add detailsLabel
        restLabel.setBounds(10 , 380 , 380 , 30);
        restLabel.setHorizontalAlignment(SwingConstants.CENTER);
        restLabel.setFont(new Font(restLabel.getFont().getName() , Font.BOLD , 14));
        leftPanel.add(restLabel);


        //add instructionLabel
        instructionLabel.setBounds(10 , 50 , 380 , 30);
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionLabel.setFont(new Font(instructionLabel.getFont().getName() , Font.ITALIC , 18));
        instructionLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(instructionLabel);

        //add idLabel
        idLabel.setBounds(255 , 180 , 100 , 30);
        idLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(idLabel);

        //add idField
        idField.setBounds(250 , 210 , 100 , 40);
        idField.setForeground(new Color(50 , 50 , 50));
        idField.setBackground(new Color(120 , 190 , 255));
        rightPanel.add(idField);

        //add usernameLabel
        usernameLabel.setBounds(55 , 250 , 100 , 30);
        usernameLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(usernameLabel);

        //add usernameField
        usernameField.setBounds(50 , 280 , 300 , 40);
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK); // Reset the text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Username");
                    usernameField.setForeground(Color.GRAY); // Set the hint text color
                }
            }
        });
        usernameField.setForeground(new Color(50 , 50 , 50));
        usernameField.setBackground(new Color(120 , 190 , 255));
        rightPanel.add(usernameField);

        //add passwordLabel
        passwordLabel.setBounds(55 , 330 , 100 , 30);
        passwordLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(passwordLabel);


        //add passwordField
        passwordField.setBounds(50 , 360 , 300 , 40);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Username")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK); // Reset the text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setForeground(Color.GRAY); // Set the hint text color
                }
            }
        });
        passwordField.setForeground(new Color(50 , 50 , 50));
        passwordField.setOpaque(false);
        passwordField.setBackground(new Color(120 , 190 , 255));
        rightPanel.add(passwordField);

        //add signUpButton
        signUpButton.setBounds(150 , 450 , 100 , 50 );
        signUpButton.setBackground(new Color(120 , 190 , 255));
        signUpButton.setBorderPainted(false);
        signUpButton.setOpaque(true);
        signUpButton.getModel().setPressed(false);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty() && !idField.getText().trim().isEmpty())
                    signUpController.signUp(usernameField.getText() , passwordField.getText() , Integer.parseInt(idField.getText()));
                else {
                    myTool.showErrorMassage("you must fill all fields!");
                    return;
                }
            }
        });
        rightPanel.add(signUpButton , "w 40% , h 40");

        //add loginButton
        loginButton.setBounds(150 , 530 , 100 , 20);
        loginButton.setOpaque(false);
        loginButton.setBorderPainted(false);
        loginButton.setForeground(new Color(200 , 200 , 200));
        loginButton.addActionListener(e->signUpController.login());
        rightPanel.add(loginButton);


        frame.setVisible(true);
    }

    public void mainFrameVisibility(boolean e){
        this.frame.setVisible(e);
    }

}
