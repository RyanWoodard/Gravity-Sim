import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.* ; 
import javax.swing.*; 
import javax.imageio.*;
import java.io.*;

public class Player{
  final static int SIZE=10;
  protected Draw main;
  protected boolean alive=true;
  protected double x,y,speedx,speedy,speedy1,speedx1;
  
  
  public Player(Draw main,double x,double y){
    this.main = main;
    
    
    this.y = y;
    this.x  = x;
    
    
    
    
  }
  
  
  public void keyPressed(KeyEvent e)  { 
    
    
    if (e.getKeyCode() == KeyEvent.VK_A) 
      speedx1 = -1; 
    if (e.getKeyCode() == KeyEvent.VK_D) 
      speedx1= 1; 
    if (e.getKeyCode() == KeyEvent.VK_W)  
      speedy1 = -1;  
    if (e.getKeyCode() == KeyEvent.VK_S)   
      speedy1= 1;
    
    
  }
  public void keyReleased(KeyEvent e) { 
    if (e.getKeyCode() == KeyEvent.VK_D && speedx > 0|| e.getKeyCode() == KeyEvent.VK_A && speedx < 0) 
      speedx1 = 0; 
    
    if (e.getKeyCode() == KeyEvent.VK_W && speedy < 0|| e.getKeyCode() == KeyEvent.VK_S && speedy > 0) 
      speedy1 = 0; }
  
  
  public void draw(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    
    
    g2d.setColor(Color.GREEN);
    if(alive)
      g2d.fillOval((int)(x),(int)y,SIZE,SIZE); 
    
  }
  public void move4(){
    if(x<0){
      x=1;   
    speedx=0;
    }
    
    if(x+SIZE>main.getWidth()){
      x=main.getWidth()-SIZE-3;
      speedx=0;
    }
    
    if(y<0){
      y=0;
     speedy=0; 

    }
    if(y+SIZE>main.getHeight()){
      speedy=0;
      y=main.getHeight()-SIZE-3;
      
    }
    if(alive){
      x=x+speedx;
      y=y+speedy;
      
    }
    
  }
  public void setSpeed(Planet plan){
    if(alive){
      double dX = plan.getX()-x;
      double dY = plan.getY()-y;
      double distance = Math.sqrt(dX*dX+dY*dY);
      double acc = plan.getSt()/((distance*distance));
      double temp = acc*(Math.cos(dY/distance));
      if(x<plan.getX())
        temp=-1*temp;
      
      speedx=speedx -temp;
      speedy=speedy + acc*(Math.sin(dY/distance));
      if(speedx1==1)
        speedx= 0.1;//speedx + 0.01;
      if(speedx1==-1)
        speedx=-0.1;//speedx - 0.01;
      if(speedy1==1)
        speedy=0.1;//speedy + 0.01;
      if(speedy1==-1)
        speedy=-0.1;//speedy - 0.01;
    }
  }
  
  
  
}