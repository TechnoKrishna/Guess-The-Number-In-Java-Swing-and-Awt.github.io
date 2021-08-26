package guessnumber;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{
    
    ImageIcon image;
    JLabel label;
    JLabel label1,label2,label3,label4;
    JTextField field;
    JButton btn1,btn2;
    Random random;
    int rand;
    int CurrentNo;
        
    int chance = 5;
    
    MyFrame()
    {
        image = new ImageIcon(new ImageIcon("question.jpg").getImage().getScaledInstance(380,340,Image.SCALE_DEFAULT));
        
        label = new JLabel(image);
        label.setBounds(10,90,250,400);
        
        label1 = new JLabel("Guess My Number Game");
        label1.setFont(new Font("DEFAULT",Font.PLAIN,25)); 
        label1.setForeground(Color.red);
        label1.setBounds(250,25,300,100);
        
        label2 = new JLabel("Enter Number B/W 1-10");
        label2.setFont(new Font("DEFAULT",Font.PLAIN,15)); 
        label2.setBounds(250,50,300,100);
        
        field = new JTextField();
        field.setBounds(250,150,300,50);
        field.setHorizontalAlignment(JTextField.CENTER);
        
        label3 = new JLabel("Chance : " + chance);
        label3.setBounds(450,400,300,50);
        label3.setFont(new Font("DEFAULT",Font.PLAIN,15)); 
        label3.setForeground(Color.red);           
        
        label4 = new JLabel("");
        label4.setBounds(280,225,300,50);
        label4.setFont(new Font("DEFAULT",Font.PLAIN,15)); 
        label4.setForeground(Color.red);       
        
        
        btn1 = new JButton("GUESS");
        btn1.setBounds(350,300,100,50); 
        btn1.setFocusable(false); 
        btn1.setBackground(Color.blue);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        
        btn2 = new JButton("PLAY AGAIN");
        btn2.setBounds(300,300,200,50); 
        btn2.setFocusable(false); 
        btn2.setBackground(Color.blue);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        
        btn1.setVisible(true); 
        btn2.setVisible(false);   
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500); 
        this.setTitle("GUESS THE NUMBER"); 
        this.setLayout(null);  
        this.getContentPane().setBackground(Color.white); 
        
        this.add(label);        
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(field);
        this.add(btn1);
        this.add(btn2);        
        
        this.setVisible(true);
        
        RandomNumber();
    }
    
    public void RandomNumber()
    {
        random = new Random();
        
        rand = random.nextInt(9)+1;
        
        System.out.println(rand);
        
    }
    
    public void ExtractNumber()
    {
        
        CurrentNo = Integer.parseInt(field.getText());
        
        check();
    
    }
    
    public void check()
    {
        if(chance <= 5 && chance > 0)
        {
            if(CurrentNo == rand)
        {
            System.out.println("WIN");
            label4.setText("WINNER WINNER"); 
            btn1.setVisible(false); 
            btn2.setVisible(true);            
        }
        else if(CurrentNo > rand)
        {
            System.out.println("GREATER");
            label4.setText("Number Is Greater"); 
                    chance--;
        }
        else if(CurrentNo < rand)
        {
            System.out.println("SMALLER");
            label4.setText("Number Is Smaller");
                    chance--;
        }
        else
        {
            
        }
        label3.setText("Chance : " + chance);
        }
        else
        {

        }
        
        if(chance == 0)
        {
            label4.setText("LOSER!!! You Don't Have More Chance");
            field.setText("NUMBER WAS : " + rand); 
            btn1.setVisible(false); 
            btn2.setVisible(true);
        }
        
    }
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btn1)
        {
            ExtractNumber();
        }
        else if(e.getSource() == btn2)
        {
            chance = 5;
            btn1.setVisible(true); 
            btn2.setVisible(false);    
            label3.setText("Chance : " + chance);
            field.setText("");
            label4.setText("");
            RandomNumber();
            
        }
    }
}

public class GuessNumber {
    public static void main(String[] args) {
        
        MyFrame frame = new MyFrame();
      
    }    
}
