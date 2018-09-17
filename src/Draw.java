
import javax.swing.*; 
import java.awt.* ; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Draw extends JPanel{
 ///private Projectile a = new Projectile(this,4);


  private Projectile[] list = new Projectile[10]; 
private Planet[] plan = new Planet[1]; 
private Player player;
  public Draw(){ 
    player = new Player(this,500,500);
   for(int i =0;i<plan.length;i++)
                               //plan[i] = new Planet(this,(int)(Math.random()*1000)+20,(int)(Math.random()*600)+20,30);
    plan[i] = new Planet(this,500,300,8);
      for(int i =0;i<list.length;i++)
        list[i] =new Projectile(this,200+i*1.2,300);
                                 //list[i] =new Projectile(this,(int)(Math.random()*1000+50),(int)(Math.random()*400+50));
        addKeyListener(new KeyListener() { 
      @Override  
      public void keyTyped(KeyEvent e) {  
      }  
      @Override  
      public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
      }  
      @Override  
      public void keyPressed(KeyEvent e) { 
       player.keyPressed(e);   
      }   }); 
    setFocusable(true);
  }
    
  

  private void move(){

       for(int r =0;r<list.length;r++)
list[r].move4();
player.move4();
    for(int r =0;r<list.length;r++){
     for(int i =0;i<plan.length;i++){
   list[r].setSpeed(plan[i]);
     }
   }
     for(int i =0;i<plan.length;i++)
  player.setSpeed(plan[i]);
     
  }
  
  @Override  public void paint(Graphics g) {
     Graphics2D g2d = (Graphics2D) g;
  
 super.paint(g);   
   g.setColor(Color.LIGHT_GRAY);  
   
  // g.fillRect(0,0,1350,710);
    for(int i =0;i<plan.length;i++)
plan[i].draw(g);
   for(int i =0;i<list.length;i++)
list[i].draw(g);

    player.draw(g);

  }
  

  
 
  
  
  public static void main(String[] args)throws InterruptedException {     
    JFrame frame = new JFrame("COLLISIONS");   //Add our JPanel to the frame 
    Draw d = new Draw();     
    frame.add(d); 
    frame.setSize(1350, 700);     
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    while (true) {  
      d.move(); 
     d.repaint();  
      Thread.sleep(1);  
    }
  }} 
  
