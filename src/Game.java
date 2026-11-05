import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;   
import java.util.Iterator;                                                   


public class Game extends JPanel  implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	
	private BufferedImage back;
	private ArrayList<Characters> displayChars;
	private String level;
	private Characters mainChar;
    private int key;
    private Background bg;
private ImageIcon background;

private ImageIcon ogbg;
private double zoom = 2.0;
	private int selected = 0;
	private ArrayList <Weapons> rangeAttack;
		private Queue<Enemy> enemies;
		private ArrayList<Weapons> enemyAttacks;
private long lastEnemyShot = 0;
		
		


	
	public Game() {
		rangeAttack = new ArrayList<Weapons>();
		ogbg = new ImageIcon("ogbg.png");
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
        this.setFocusable(true);
this.requestFocusInWindow();
		new Thread(this).start();
		enemies = setEs();
		rangeAttack = new ArrayList<Weapons>();
enemyAttacks = new ArrayList<Weapons>();
		
		
		displayChars = setupChars();
		for(Characters c: displayChars) {
			System.out.println(c.toString());
		}
		level="start";
		//only if you want to have one selected init
		mainChar = displayChars.get(0);
	}
	public ArrayList<Characters> setupChars(){
		ArrayList<Characters> temp = new ArrayList<Characters>();
		temp.add(new Santa(25,450,400,400));
		temp.add(new MrsClaus(450,450,400,400));
        temp.add(new Elf(850,450,400,400));
		temp.add(new Kid(1250,450,400,400));



    return temp; 

	}

private Queue<Enemy> setEs() {
		// TODO Auto-generated method stub
		Queue<Enemy> temp = new LinkedList<Enemy>();
		// Add some enemies to the queue
		temp.add(new Scrooge(1000, 500));
		temp.add(new Grinch(1200, 500));
temp.add(new Scrooge(1300, 500));

temp.add(new Grinch(1500, 500));
		return temp;
	}

	private void checkProjectileHits() {
    if (enemies == null || enemies.isEmpty()) {
        return;
    }

    Enemy enemy = enemies.peek();

    Iterator<Weapons> iterator = rangeAttack.iterator();

    while (iterator.hasNext()) {
        Weapons projectile = iterator.next();

        Rectangle projectileRect = new Rectangle(
            projectile.getX(),
            projectile.getY(),
            projectile.getW(),
            projectile.getH()
        );

        Rectangle enemyRect = new Rectangle(
            enemy.getX(),
            enemy.getY(),
            enemy.getW(),
            enemy.getH()
        );

        if (projectileRect.intersects(enemyRect)) {

         
            enemy.takeDamage(projectile.getDamage());

            iterator.remove();

            if (enemy.getHealth() <= 0) {
                enemies.remove();
            }

            return;
        }
    }
}
	
	  public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}
	
	  
	  public  void paint(Graphics g){
	  
		  Graphics2D  twoDgraph= (Graphics2D)g;
		
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));


		Graphics g2d = back.createGraphics();
	
		
		g2d.clearRect(0,0,getSize().width, getSize().height);
		//start coding here
		
		switch(level) {
			case "start":
				drawStart(g2d);
                drawStats(g2d);
				g2d.setFont(new Font("Broadway", Font.BOLD, 120));
				g2d.setColor(Color.RED);
				g2d.drawString("Christmas RPG!", 20, 200);
			break;
			case "explore":

    if (ogbg != null && mainChar != null) {

        Graphics2D exploreG = (Graphics2D) g2d.create();

        double cameraX =
            getWidth() / 2.0
            - (mainChar.getX() + mainChar.getW() / 2.0) * zoom;

        double cameraY =
            getHeight() / 2.0
            - (mainChar.getY() + mainChar.getH() / 2.0) * zoom;

        exploreG.translate(cameraX, cameraY);
        exploreG.scale(zoom, zoom);

        exploreG.drawImage(
            ogbg.getImage(),
            0,
            0,
            this
        );

        mainChar.drawChar(exploreG);

        exploreG.dispose();
    }

    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font("Arial", Font.BOLD, 24));
    g2d.drawString("Explore the Christmas Village!", 20, 35);
    g2d.drawString("WASD: Move    B: Battle", 20, 70);

    break;
			case "game":
	g2d.drawImage(background.getImage(),bg.getX(),0,getWidth(),getHeight(),this);
g2d.drawImage(background.getImage(),bg.getX()+getWidth(),0,getWidth(),getHeight(),this);
bg.move();

		if(!enemies.isEmpty()){
			enemies.peek().drawCharAndWeap(g2d);
	}
		else{
			g2d.setColor(Color.WHITE);
			g2d.drawString("You win!!!!", 100, 100);
		}	

if (mainChar != null) {
        mainChar.drawChar(g2d);
    }
	Iterator<Weapons> iterator = rangeAttack.iterator();

while (iterator.hasNext()) {
    Weapons w = iterator.next();

    w.drawMove(g2d);
    w.move();
}

checkProjectileHits();

fireEnemyWeapons();

Iterator<Weapons> enemyIterator = enemyAttacks.iterator();

while (enemyIterator.hasNext()) {

    Weapons projectile = enemyIterator.next();

    projectile.drawMove(g2d);
    projectile.move();

    if (projectile.getX() + projectile.getW() < 0) {
        enemyIterator.remove();
        continue;
    }

    if (mainChar != null) {

        Rectangle projectileRect = new Rectangle(
            projectile.getX(),
            projectile.getY(),
            projectile.getW(),
            projectile.getH()
        );

        Rectangle playerRect = new Rectangle(
            mainChar.getX(),
            mainChar.getY(),
            mainChar.getW(),
            mainChar.getH()
        );

        if (projectileRect.intersects(playerRect)) {

            mainChar.takeDamage(projectile.getDamage());

            enemyIterator.remove();
        }
    }
	if (mainChar != null) {
    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font("Arial", Font.BOLD, 24));

    g2d.drawString(
        "Health: " + mainChar.getHealth(),
        20,
        40
    );
}
if (mainChar != null && mainChar.getHealth() <= 0) {
    g2d.setColor(Color.RED);
    g2d.setFont(new Font("Arial", Font.BOLD, 60));
    g2d.drawString("GAME OVER!", 300, 250);
}
}
	
				break;
		}





		//do not delte this line of code, it draws everything above
		twoDgraph.drawImage(back, null, 0, 0);
	
	}
	private void drawStart(Graphics g2d) {
	//	System.out.println("drawing start");
		 g2d.setColor(Color.WHITE);

    for(int i = 0; i < displayChars.size(); i++) {
        Characters c = displayChars.get(i);

        c.drawChar(g2d);

        // Draw a box around the selected character
        if(i == selected) {
            g2d.setColor(Color.YELLOW);
            g2d.drawRect(
                c.getX() - 5,
                c.getY() - 5,
                c.getW() + 10,
                c.getH() + 10
            );
           
            g2d.setColor(Color.WHITE);
        }

	}
}

public void initializeBackground() {
    bg= new Background(getWidth());
    background = new ImageIcon(bg.getBackground());
}

private void fireEnemyWeapons() {

    if (enemies == null || enemies.isEmpty()) {
        return;
    }

    Enemy enemy = enemies.peek();

    if (enemy.getWeapon() == null) {
        return;
    }

    long currentTime = System.currentTimeMillis();

    if (currentTime - lastEnemyShot >= 1500) {

        Weapons enemyWeapon = enemy.getWeapon();

        Weapons projectile = new Weapons(
            enemyWeapon.getDamage(),
            enemyWeapon.getAttackSpeed(),
            enemyWeapon.getPic(),
            enemy.getX() - enemyWeapon.getW(),
            enemy.getY(),
            enemyWeapon.getW(),
            enemyWeapon.getH()
        );

        projectile.setDx(-6);

        enemyAttacks.add(projectile);

        lastEnemyShot = currentTime;
    }
}



private void drawStats(Graphics g2d) { 
	
	Characters selectedChar = displayChars.get(selected); 
	g2d.setFont(new Font("Broadway", Font.BOLD, 50));
    g2d.setColor(Color.WHITE); 
    g2d.drawString("Range: " + selectedChar.getRange(), 1150, 100); 
    g2d.drawString("Attack: " + selectedChar.getAttack(), 1150, 150); 
    g2d.drawString("Health: " + selectedChar.getHealth(), 1150, 200);
 g2d.drawString("Defense: " + selectedChar.getDefense(), 1150, 250);
  g2d.drawString("Speed: " + selectedChar.getSpeed(), 1150, 300);
g2d.drawString("Weapon: " + selectedChar.getWeapon().toString(), 1150, 350); 
}


	  @Override
	  public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	//	throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
	  }

	  @Override
	  public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
	  }

	  @Override
public void mouseClicked(MouseEvent e) {

    }


	  @Override
	  public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
	  }

	  @Override
	  public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
	  }

	  @Override
	  public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		////throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
	  }

	  @Override
	  public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
	  }

	  @Override
	  public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
	  }

	@Override
public void keyPressed(KeyEvent e) {

    key = e.getKeyCode();

    System.out.println(key);

    if (level.equals("start")) {

        if (key == KeyEvent.VK_RIGHT) {
            selected = (selected + 1) % displayChars.size();
        }

        if (key == KeyEvent.VK_LEFT) {
            selected = (selected - 1 + displayChars.size()) % displayChars.size();
        }

        if (key == KeyEvent.VK_SPACE) {

            mainChar = displayChars.get(selected);

	    mainChar.setW(100);
    mainChar.setH(100);

    mainChar.setX(500);
    mainChar.setY(300);

 
    level = "explore";

    requestFocusInWindow();
        }
	}

if (level.equals("explore") && key == KeyEvent.VK_B) {
    level = "game";
    initializeBackground();
    lastEnemyShot = 0;
    requestFocusInWindow();
}
	if (level.equals("game") && mainChar != null
        && key == KeyEvent.VK_R) {

    if (mainChar.getWeapon() instanceof range) {

        rangeAttack.add(new Weapons(
            mainChar.getWeapon().getDamage(),
            mainChar.getWeapon().getAttackSpeed(),
            mainChar.getWeapon().getPic(),
            mainChar.getX() + mainChar.getW(),
            mainChar.getY(),
            mainChar.getWeapon().getW(),
            mainChar.getWeapon().getH()
        ));

        System.out.println("Added projectile");
    }
}
	
if ((level.equals("explore") || level.equals("game"))
        && mainChar != null) {

    int moveSpeed = 10;

    if (key == KeyEvent.VK_W) {
        mainChar.setY(mainChar.getY() - moveSpeed);
    }

    if (key == KeyEvent.VK_S) {
        mainChar.setY(mainChar.getY() + moveSpeed);
    }

    if (key == KeyEvent.VK_A) {
        mainChar.setX(mainChar.getX() - moveSpeed);
    }

    if (key == KeyEvent.VK_D) {
        mainChar.setX(mainChar.getX() + moveSpeed);
    }

     if (key == KeyEvent.VK_T) {
          level = "start";
    initializeBackground();
    lastEnemyShot = 0;
    requestFocusInWindow();
   mainChar = displayChars.get(0);
   rangeAttack = new ArrayList<Weapons>();
		ogbg = new ImageIcon("ogbg.png");
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
        this.setFocusable(true);
this.requestFocusInWindow();
		new Thread(this).start();
		enemies = setEs();
		rangeAttack = new ArrayList<Weapons>();
enemyAttacks = new ArrayList<Weapons>();
		
		
		displayChars = setupChars();
		for(Characters c: displayChars) {
			System.out.println(c.toString());
    }
}
        }
}

	  @Override
	  public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
	  }
}