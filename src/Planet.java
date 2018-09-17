import javax.swing.*; 
import java.awt.* ; 

public class Planet{
  final static int SIZE=20;
  private Draw main;

  private double x,speed,y,strength;
  
  public Planet(Draw main,double x,double y,double strength){
  this.main = main;
 this.strength = strength;
  this.speed = speed;
  
  this.y = y;
  this.x  = x;



  }
  
  
  
   
  public void draw(Graphics g){
     Graphics2D g2d = (Graphics2D) g;
 
    
  g2d.setColor(Color.RED);
   g2d.fillOval((int)(x),(int)y,SIZE,SIZE); 
     
  }
  
  //x4 etc uses doubles
  public void move4(){
  



  
  }
  public double getX(){
  return x;
  }
  public double getY(){
  return y;
  }
    public double getSt(){
  return strength;
    }}