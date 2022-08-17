package BRICK;

import javax.swing.JPanel; 
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Rectangle; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
import javax.swing.Timer; 
 
public class Game extends JPanel implements KeyListener, ActionListener{ 
private boolean play = false; 
private int score = 0; 
 
private int totalBricks = 21; // عدد البريكز 
 
private Timer timer; 
private int delay= 8 ;// سرعة الكورة 
 
private int playerx = 310; 
 
private int ballposx = 120; 
private int ballposy = 350; 
private int ballxdir = -1; 
private int ballydir = -2; 
 
        private Map map ; 
public Game() { 
            map = new Map(3,7); // أعداد المربعات 
addKeyListener(this); 
setFocusable(true); 
setFocusTraversalKeysEnabled(false); 
timer = new Timer(delay, this); 
timer.start();	 
} 
public void paint(Graphics g) { 
//الخلفية 
g.setColor(Color.white); 
g.fillRect(1,1, 692, 592); 
//borders 
g.setColor(Color.pink); 
g.fillRect(0, 0, 3, 592); 
g.fillRect(0, 0, 692, 3); 
g.fillRect(691, 0, 3, 592); 
                  //عدد مرات الفوز 
                g.setColor(new Color(78,145,79)); 
                g.setFont(new Font ("serif" , Font.PLAIN , 25)); 
                g.drawString("*" +score, 590, 30); 
                //draw  
                map.draw((Graphics2D)g); 
// المربع اللي يشوت 
g.setColor(new Color(179,208,255)); 
g.fillRect(playerx, 550, 100, 8); 
// the ball 
g.setColor(Color.pink); 
g.fillOval(ballposx, ballposy, 20, 20); 
                if(ballposy > 570 && score != 105){ 
                    play = false ; 
                    ballxdir =0 ; 
                     ballydir =0 ; 
                     g.setColor(Color.red); 
                       g.setFont(new Font ("serif" , Font.PLAIN , 35)); 
                g.drawString("GAME OVER!", 215, 300); 
                 
                 
                 g.setFont(new Font ("serif" , Font.PLAIN , 20)); 
                g.drawString("press enter to start again or press esc to exit", 160, 350);//الارقام اللي على جنب أبعاد الكتابة  
                } 
                     if(score == 105){ 
                     g.setColor(Color.pink); 
                       g.setFont(new Font ("serif" , Font.PLAIN , 50)); 
                g.drawString("you win!", 230, 300); 
                 g.setFont(new Font ("serif" , Font.PLAIN , 20)); 
                g.drawString("press enter to play again or press esc to exit", 160, 350);//الارقام اللي على جنب أبعاد الكتابة  
                 
 
                } 
g.dispose(); 
               
} 
@Override 
public void actionPerformed(ActionEvent e) { 
timer.start(); 
if(play) { 
if(new Rectangle(ballposx, ballposy, 20, 20).intersects(new Rectangle(playerx, 550, 100,8))) { 
ballydir = -ballydir; 
} 
                        for (int i =0; i<map.map.length ; i++){ 
                            for (int j =0; j<map.map[0].length ; j++){ 
                            if (map.map[i][j] > 0){ 
                                int brickX = j* map.brickW + 80 ;  
                                int brickY = i* map.brickW + 50 ; 
                                int brickW = map.brickW ;  
                                 int brickH = map.brickH ;  
                                  
                                 Rectangle rect = new Rectangle(brickX ,brickY,brickW,brickH); 
                                 Rectangle ballRect = new Rectangle (ballposx , ballposy , 20 , 20); 
                                 Rectangle brickRect = rect ;  
                                 if(ballRect.intersects(brickRect)){ 
                                     map.setBrickValue(0, i, j); 
                                     totalBricks--; 
                                     score+= 5; // البريك الوحدة لها خمس نقاط 
                                      
                                      
                                      
                    if(ballposx + 19 <= brickRect.x || ballposx + 1 >= brickRect.x +brickRect.width){ 
                        ballxdir = -ballxdir ; 
                    } else { 
                         ballydir = -ballydir ; 
                    } 
                                 } 
                            } 
                        }  
                        } 
ballposx += ballxdir; 
ballposy +=ballydir; 
if(ballposx < 0 ) { 
ballxdir = -ballxdir; 
} 
if(ballposy < 0 ) { 
ballydir = -ballydir; 
} 
if(ballposx > 670 ) { 
ballxdir = -ballxdir; 
} 
} 
repaint(); 
} 
@Override 
public void keyTyped(KeyEvent e) {} 
@Override 
public void keyReleased(KeyEvent e) {} 
 
@Override 
public void keyPressed(KeyEvent e) { 
if(e.getKeyCode() == KeyEvent.VK_RIGHT) {	 
if(playerx >= 600) { 
playerx = 600; 
} 
else { 
moveRight(); 
} 
} 
if(e.getKeyCode() == KeyEvent.VK_LEFT) { 
if(playerx < 10) { 
playerx = 10; 
} 
else { 
moveLeft(); 
}	 
} 
                 
                if (e.getKeyCode() == KeyEvent.VK_ENTER){ //فنكشن تسوي اشياء لما يضغط انتر 
                    if(!play){ 
                        play = true ; 
                        ballposx = 120; 
                        ballposy = 350; 
                        ballxdir = -1; 
                        ballydir=-2; 
                        playerx= 310 ; 
                        score = 0; 
                        totalBricks = 21; 
                        map = new Map(3,7); 
                        repaint(); 
                         
                    } 
                } 
                    if (e.getKeyCode() == KeyEvent.VK_ENTER){ //فنكشن تسوي اشياء لما يضغط انتر عند الفوز 
                    if(score == 105){ 
                   
                        play = true ; 
                        ballposx = 120; 
                        ballposy = 350; 
                        ballxdir = -1; 
                        ballydir=-2; 
                        playerx= 310 ; 
                        score = 0; 
                        totalBricks = 21; 
                        map = new Map(3,7); 
                        repaint(); 
                    }} 
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE){ // فنكشن تطلعك من القيم 
                 
                              System.exit(0); 
                          
                    } 
                 
} 
       // للتحريك يمين ويسار  
    public void moveRight() { 
    	play = true; 
    	playerx += 20; // بمسافة عشرين 
    } 
    public void moveLeft() { 
    	play = true; 
    	playerx -= 20; 
    } 
} 
 
 
 
 
 