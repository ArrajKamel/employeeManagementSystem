package resourses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Tool {
    private String path = "/Users/kamelarraj/Desktop/ArrajKamel1/src/resourses";
    public void addIconToButton(JButton button, String iconName , int x , int y , int width , int hight , Font... font) {
        BufferedImage Img = null;
        //JButton button = new JButton();
        String iconPath = path+iconName;

        try {
            Img = ImageIO.read(new File(iconPath ));
            ImageIcon imageIcon = new ImageIcon(Img);
            Image originalImg = imageIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(30,30 , Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            button.setIcon(imageIcon);
        }catch (Exception e){
            e.printStackTrace();
        }
        button.setBounds(x , y , width , hight );
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font(button.getFont().getName() , Font.ITALIC , 16));
    }

    public void addIconToButton(JToggleButton button,  String iconName , int x , int y , int width , int hight , Font... font) {
        BufferedImage Img = null;
        String iconPath = path+iconName;

        try {
            Img = ImageIO.read(new File(iconPath ));
            ImageIcon imageIcon = new ImageIcon(Img);
            Image originalImg = imageIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(30,30 , Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            button.setIcon(imageIcon);
        }catch (Exception e){
            e.printStackTrace();
        }
        button.setBounds(x , y , width , hight );
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font(button.getFont().getName() , Font.ITALIC , 16));
    }

    public void addImageToLabel(JLabel label , String imageName , int x , int y , int width , int hight){
        BufferedImage img = null;
        String imagePath = path+imageName;
        try {
            img = ImageIO.read(new File(imagePath));
            ImageIcon imageIcon = new ImageIcon(img);
            Image originalImg = imageIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(width , hight , Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            label.setIcon(imageIcon);
            label.setBounds(x , y ,width , hight);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addExitButton(JPanel panel){
        JButton exitButton = new JButton();
        exitButton.setBounds(5 , 5, 10 , 10);
        exitButton.setText(null);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.addIconToButton(exitButton ,
                "/exit.png" ,
                5 , 5 , 10 , 10);
        panel.add(exitButton);

    }

    public void showSuccessMassage(String message){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path+"/success.png" ));
            ImageIcon imageIcon = new ImageIcon(img);
            Image originalImg = imageIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(40,40 , Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            JOptionPane.showMessageDialog(null , message , "Success" , JOptionPane.INFORMATION_MESSAGE,imageIcon);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void showErrorMassage(String message){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path+"/failed.png" ));
            ImageIcon imageIcon = new ImageIcon(img);
            Image originalImg = imageIcon.getImage();
            Image resizedImg = originalImg.getScaledInstance(40,40 , Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            JOptionPane.showMessageDialog(null , message , "failed" , JOptionPane.INFORMATION_MESSAGE,imageIcon);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
