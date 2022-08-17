package BRICK;

 
import java.awt.BasicStroke; 
import java.awt.Color ; 
import java.awt.Graphics2D ;  
 
 
public class Map { 
    public int map [][]; // اراي 
    public int brickW; // العرض 
    public int brickH ; // الطول 
    public Map (int row , int col){ 
        map = new int[row][col]; 
           for (int i = 0 ; i<map.length ; i++){ 
               for(int j = 0; j<map[0].length; j++){ 
     map[i][j] = 1 ; // عشان طباعة المربعات  
           } 
           } 
     
    brickW = 540/col; // العرض 
    brickH = 150/row; // الطول 
    } 
    public void draw(Graphics2D g){ // اللي ترسم لي البريكز 
        for(int i = 0 ; i<map.length ; i++){ 
            for(int j=0; j<map[0].length;j++){ 
                if(map[i][j] > 0){ 
                    g.setColor(new Color(179,208,255)); 
        
                    g.fillRect(j*brickW + 80,i*brickH + 50 , brickW , brickH); //القياسات للبريكز 
                    g.setStroke(new BasicStroke(3));// حجم الخطوط حقت التقسيم يخليها بولد 
                    g.setColor(Color.white); // اللي يقسم المربعات 
                     g.drawRect(j*brickW + 80,i*brickH + 50 , brickW , brickH); 
                } 
            } 
        } 
    } 
    public void setBrickValue(int val , int row , int col){ 
        map[row][col] = val ;  
    } 
} 