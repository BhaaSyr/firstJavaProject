package clock;

import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class Clock extends JApplet{


    public static void main(String[] args) throws FontFormatException, IOException {
        ImageIcon icon=new ImageIcon("src\\imgs\\wall-clock.png");
        Clock my = new Clock();
         panel pan=new panel();
        JFrame frm = new JFrame();
        frm.setSize(630, 700);
        frm.setTitle("Clock");
        frm.setIconImage(icon.getImage());
        pan.setBounds(0,0, 600,600);
         frm.add(pan);
//         frm.setUndecorated(true);
         frm.setResizable(true);
         frm.setBounds(50, 50, 630, 750);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frm.setVisible(true);
      

    }



}
