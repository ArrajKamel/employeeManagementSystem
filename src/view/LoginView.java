package view;

import controller.LoginController;
import resourses.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

public class LoginView extends JFrame {
    JFrame frame = new JFrame();
    JPanel leftPanel = new JPanel();
    JLabel usersIcon = new JLabel();
    JLabel titleLabel = new JLabel();

    JPanel rightPanel = new JPanel();
    JLabel welcomingLabel = new JLabel("welcome back!");
    JTextField usernameField = new JTextField("Username");
    JPasswordField passwordField  = new JPasswordField("Password");
    JToggleButton passwordHiderButton = new JToggleButton();
    JButton loginButton = new JButton("Login");
    JLabel emailLabel = new JLabel("E_mail");
    JLabel passwordLabel = new JLabel("Password");

    JLabel accountLabel = new JLabel("I do not have an account!");
    JButton signUpButton = new JButton("sign up");

    public void view (LoginController loginController){
        Tool myTool = new Tool();
        //init the frame
        frame.setSize(800 ,  600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
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

        //exit button
        myTool.addExitButton(leftPanel);

        //add users icon
        usersIcon.setText(null);
        usersIcon.setBounds(100 , 100 , 200 , 200);
        myTool.addImageToLabel(usersIcon ,
                "/users.png" ,
                100 , 100 , 200 , 200);
        leftPanel.add(usersIcon);

        //add the title label
        titleLabel.setText("Employee Management System");
        titleLabel.setBounds(0 , 320 , 400 , 30 );
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName() ,  Font.BOLD , 20));
        leftPanel.add(titleLabel);

        //add welcoming label
        welcomingLabel.setText("Welcome Back sir!");
        welcomingLabel.setBounds(0 , 75 , 400 , 30);
        welcomingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomingLabel.setFont(new Font(welcomingLabel.getFont().getName() , Font.BOLD , 24));
        welcomingLabel.setForeground(new Color(120 , 190 , 255));
        rightPanel.add(welcomingLabel);

        //add username text field
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

        //add password text field
        passwordField.setBounds(50 , 360 , 300 , 40);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Password")) {
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

        //add passwordHider button
        passwordHiderButton.setBounds(325 , 370 , 20 , 20);
        myTool.addIconToButton(passwordHiderButton ,
                "/hiden.png" ,
                325 , 370 ,15,15);
        passwordHiderButton.setText(null);
        passwordHiderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordHiderButton.isSelected())
                    passwordField.setEchoChar((char) 0);
                else
                    passwordField.setEchoChar('•');
            }
        });
        rightPanel.add(passwordHiderButton);
        rightPanel.add(passwordField);

        //add login button
        loginButton.setBounds(150 , 450 , 100 , 50 );
        loginButton.setText("Login");
        loginButton.setBackground(new Color(120 , 190 , 255));
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);
        loginButton.getModel().setPressed(false);
        loginButton.addActionListener(e -> {
            try {
                loginController.check(usernameField.getText() , String.valueOf(passwordField.getPassword()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        rightPanel.add(loginButton , "w 40% , h 40");

        //add email label
        emailLabel.setForeground(new Color(120 , 190 , 255));
        emailLabel.setText("E_mail");
        emailLabel.setBounds(57 , 265 , 50 , 15);
        rightPanel.add(emailLabel);

        //add password label
        passwordLabel.setForeground(new Color(120 , 190 , 255));
        passwordLabel.setText("Password");
        passwordLabel.setBounds(57 , 345 , 70, 15);
        rightPanel.add(passwordLabel);

        //add accountLabel
        accountLabel.setBounds(120 , 510 , 160 , 20);
        accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accountLabel.setFont(new Font(accountLabel.getFont().getName() , Font.ITALIC , 12));
        accountLabel.setForeground(new Color(200 , 200 , 200));
        rightPanel.add(accountLabel);

        //add signUpButton
        signUpButton.setBounds(150 , 530 , 100 , 20);
        signUpButton.setOpaque(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setForeground(new Color(200 , 200 , 200));
        signUpButton.addActionListener(e ->loginController.signUpPage());
        rightPanel.add(signUpButton);

        frame.setVisible(true);

    }

    public void mainFrameVisibility(boolean e){
            this.frame.setVisible(e);
    }

}
