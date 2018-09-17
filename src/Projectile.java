import javax.swing.*; 
import java.awt.* ; 

public class Projectile{
  final static int SIZE=10;
protected Draw main;
 protected boolean alive=true;
  protected double x,y,speedx,speedy;
  
  public Projectile(Draw main,double x,double y){
    this.main = main;
    
    
    this.y = y;
    this.x  = x;
   // this.speedx =Math.random()*0-0.3;
   // this.speedy=Math.random()*1-0.5;
      this.speedx =0;
    this.speedy=0.125;
    
  }
  
  
  
  
  public void draw(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    
    
    g2d.setColor(Color.BLUE);
    if(alive)
      g2d.fillOval((int)(Math.round(x)),(int)(Math.round(y)),SIZE,SIZE); 
    
  }
  
  //x4 etc uses doubles
  public void move4(){
    if(x<0||x+SIZE>main.getWidth()){
    //  speedx=speedx*-1;
      
    }
    if(y<0||y+SIZE>main.getHeight()){
     // speedy=speedy*-1;
      
    }
    if(Math.abs(x)<10000){
      x=x+speedx;
      y=y+speedy;
      
    }
    
  }
  public void setSpeed(Planet plan){
    if(Math.abs(x)<10000){
      double dX = plan.getX()-x;
      double dY = plan.getY()-y;
      double distance = Math.sqrt(dX*dX+dY*dY);
      double acc = plan.getSt()/((distance*distance));
      double temp = acc*(Math.cos(dY/distance));
      if(distance >15){
      if(x<plan.getX())
        temp=-1*temp;
      
      speedx=speedx -temp;
      speedy=speedy + acc*(Math.sin(dY/distance));
      }
     // if(distance < 20)
      
        //reset();
    }
  }
  
  public void reset(){
    
    int temp = (int)(Math.random()*1000+50);
    if(1==(int)(Math.random()*2)){
      y=0;
      speedy=0.6;
    }
    else{
      y=640;
      speedy=-0.6;
    }
    x=temp;
    
    speedx=0.4;
    
  }
  
}