package BRICK;
import javax.swing.JFrame; 
 
public class main { 
public static void main(String[] args) { 
JFrame obj = new JFrame(); 
Game gamePlay = new Game(); 
obj.setBounds(10,10,700,600);// طريقة الرن 
obj.setTitle("Breakout Ball"); //  الاسم 
                 
obj.setResizable(false);  
obj.setVisible(true); 
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
obj.add(gamePlay); 
 
} 
 
} 

