
package clock;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
public class panel extends JPanel implements ActionListener{
    final int pan_x=650;
    final int pan_y=700;
    int x=300;//seconds hand
    int y=0;//seconds hand
    int xm=300;//Minute hand
    int ym=60;//Minute hand
    int xh=300;//Hour hand
    int yh=100;//Hour hand
    int h=0;//number of hours
    int dr=75;//number of seconds
    int ms=0;//number of minute
    int y1,x1,y2,x2,op=3;//lines
    double p=Math.PI/30;
    ActionListener   ac2;
    Timer timer;
    JComboBox select;
    Date currentd;
    JLabel digital;
    Font myfont=Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\digital-7.ttf"));
        //myfont=myfont.deriveFont(Font.BOLD,28);
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        //ge.registerFont(myfont);
        ImageIcon img=new ImageIcon("src\\imgs\\Style4.png");
        
    panel() throws FontFormatException, IOException{
        myfont=myfont.deriveFont(Font.BOLD,60);
        ge.registerFont(myfont);
       currentd =new Date();
       SimpleDateFormat hour=new SimpleDateFormat("hh");
       SimpleDateFormat minute=new SimpleDateFormat("mm");
       SimpleDateFormat second=new SimpleDateFormat("ss");
            
            ms=-Integer.parseInt(minute.format(currentd)); 
            h=-5*Integer.parseInt(hour.format(currentd)) ;
            if (ms%12==0) {
            h=h+(int)(ms/12)+1;
            }else {h=h+(int)(ms/12);}
            
            dr=Integer.parseInt(second.format(currentd));
            dr=75-dr;
            digital =new JLabel("00:00:00",SwingConstants.CENTER);
            digital.setBounds(180,630, 250, 60);
            digital.setForeground(new Color(0x4E9F3D));
            digital.setFont(myfont);
            digital.setBackground(new Color(0x1A374D));
            digital.setOpaque(true);
            
           yh=(int)((600-(Math.sin(p*(75+h)))*430)/2);
           xh=(int)((600+(Math.cos(p*(75+h)))*430)/2);
           ym=(int)((600-(Math.sin(p*(75+ms)))*490)/2);
           xm=(int)((600+(Math.cos(p*(75+ms)))*490)/2);
           
        this.setLayout(null);
          String[] style={"modern","klasic","unique"};
          select=new JComboBox(style);
          select.setBounds(10, 650, 100, 30);
          actionPerformed();
          select.addActionListener(ac2);
          
          this.add(digital);
        this.add(select);
        this.setPreferredSize(new Dimension(pan_x,pan_y));
        this.setBackground(new Color(0x2E0249));
    
        timer = new Timer(1000,this);
        timer.start();
    }
    public void paint(Graphics g){
        
 
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        update(g2d);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("",Font.PLAIN,50));
        if (op==1||op==3) {
        g2d.drawString("12", 275, 70);
        g2d.drawString("3", 540, 320);
        g2d.drawString("6", 285, 570);
        g2d.drawString("9", 30, 320);
        }
        
        g2d.setColor(Color.red);
        if (op==1) {
            g2d.setColor(Color.white);
        }else{
        g2d.setColor(Color.BLACK.brighter());}
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(300, 300, xm, ym);
        g2d.drawLine(300,300, xh, yh);
        g2d.setStroke(new BasicStroke(0));
        g2d.fillOval(280, 280, 40, 40);
        g2d.setColor(new Color(0x4700D8));
        g2d.drawLine(300, 300, x, y);
        g2d.fillOval(285, 285,30 , 30);
        
    }
    @Override
    public void update(Graphics g){
        int i=0;
        int st=0;
        double sin=Math.sin(p*i);
        double cos=Math.cos(p*i);
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.WHITE);
     if (op==1) {
           g2.setFont(new Font("",Font.PLAIN,20));
             this.setBackground(Color.BLACK);
             g2.drawString("60", 290, 20);g2.drawString("05", 435, 55);g2.drawString("10", 540, 165);g2.drawString("15", 580, 306);g2.drawString("20", 540, 450);
             g2.drawString("25", 435, 558);g2.drawString("30", 290, 600);g2.drawString("35", 145, 560);g2.drawString("40", 37, 453);g2.drawString("45", 0, 306);
             g2.drawString("50", 37, 163);g2.drawString("55", 145, 55);
             g2.setFont(new Font("",Font.PLAIN,50));
             g2.drawString("1", 420, 100); g2.drawString("2", 500, 190);g2.drawString("4", 505, 440);g2.drawString("5", 415, 530)
             ;g2.drawString("7", 160, 530);g2.drawString("8", 65, 440);g2.drawString("10", 65, 190);g2.drawString("11", 160, 100);
             
            // g2.setStroke(new BasicStroke(3));
            // g2.drawOval(1, 1, 600, 600);
            for ( i = 15; i < 75; i++) {
                
         sin=Math.sin(p*i);
         cos=Math.cos(p*i);
         y1=(int)((600-sin*600)/2);
         x1=(int)((600+cos*600)/2);
         
         if (i%5==0) {
            
              
            }else {
         y2=(int)((600-sin*570)/2);
         x2=(int)((600+cos*570)/2);
         g2.drawLine(x1,y1,x2,y2);
         }
         
            
        }
        }else if (op==2) {
            this.setBackground(new Color(0xa2813d));
            g2.drawImage(img.getImage(), 0, 0, null);
        }else {
            for (i = 15; i < 75; i+=5) {
                this.setBackground(new Color(0x112B3C));
                if (i==30||i==45||i==60||i==15) {
                i=i+5;
              
            }
         sin=Math.sin(p*i);
         cos=Math.cos(p*i);
         y1=(int)((600-sin*570)/2);
         x1=(int)((600+cos*570)/2);
         y2=(int)((600-sin*530)/2);
         x2=(int)((600+cos*530)/2);
         
         g2.drawLine(x1,y1,x2,y2);
            
        }}
     
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        double sin,cos;
 
         
        if (dr==16||dr<16) {
            dr=75;
            
            if (ms==-59) {
                ms=0;
                if (h==-59) {
                    h=0;
                    
                }else{h--;}
                
         sin=Math.sin(p*(75+h));
         cos=Math.cos(p*(75+h));
         yh=(int)((600-sin*430)/2);
         xh=(int)((600+cos*430)/2);
                
            }else if (ms%12==0&&ms!=0) {
                h--;
                ms--;
        
         yh=(int)((600-(Math.sin(p*(75+h)))*430)/2);
         xh=(int)((600+(Math.cos(p*(75+h)))*430)/2);
         
            }else
            {
            ms--;}
         sin=Math.sin(p*(75+ms));
         cos=Math.cos(p*(75+ms));
         ym=(int)((600-sin*490)/2);
         xm=(int)((600+cos*490)/2);
        }else dr--;
        
         sin=Math.sin(p*dr);
         cos=Math.cos(p*dr);
        y=(int)((600-sin*600)/2);
        x=(int)((600+cos*600)/2);
        //digital.setText(-(int)(h/5)+":"+-ms+":"+-(dr-75));
        digital.setText((100-(int)(h/5)+"").substring(1)+":"+(100-ms+"").substring(1)+":"+(100+(-(dr-75))+"").substring(1));
        
      repaint();
        
        }
    public void actionPerformed() {
        
        ac2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource()==select) {
                    if (select.getSelectedItem()=="klasic") {
                    op=1;
 
                    }else if (select.getSelectedItem()=="unique") {
                    op=2;
                    }else op=3;
                }
                }
        };repaint();
                
          }
}
