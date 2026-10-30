import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.ArrayList;

public class Characters {
    
    private int x,y,w,h;
    private ImageIcon pic;
    private int range, attack, health, defense, speed;
    private Weapons weapon;
    private ArrayList <Weapons> weapons = new ArrayList<Weapons>();

    
    public Characters() {

        x=0;
        y=0;
        w=0;
        h=0;
        pic= new ImageIcon("pic.jpg");
        range=10;
        attack=12;
        health=20;
        defense=75;
        speed=100;
    }

    public Characters( ImageIcon pic, int range, int attack, int health, int defense, int speed, Weapons weapon) {
    
        this.pic = pic;
        this.range = range;
        this.attack = attack;
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.weapon = weapon;
          x=0;
        y=200;
        w=200;
        h=200;
    }
    public Characters(int x, int y,ImageIcon pic, int range, int attack, int health, int defense, int speed, Weapons weapon) {
        this.x = x;
        this.y = y;
        this.w = 200;
        this.h = 200;
        this.pic = pic;
        this.range = range;
        this.attack = attack;
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.weapon = weapon;
    }

    public void drawChar(Graphics g2d){
        g2d.drawImage(pic.getImage(), x, y, w, h, null);
        g2d.drawImage(weapon.getPic().getImage(), weapon.getX(), weapon.getY(), weapon.getW(), weapon.getH(), null);
        //System.out.println("drawing weapon at " + weapon.getX() + " " + weapon.getY() + "weapon name: " + weapon.toString());
    }
    public void setArrayList(Weapons w) {
        weapons.add(w);
    }
      public void drawCharAndWeap(Graphics g2d){
        g2d.drawImage(pic.getImage(), x, y, w, h, null);
        g2d.drawImage(weapon.getPic().getImage(), weapon.getX(), weapon.getY(), weapon.getW(), weapon.getH(), null);
        System.out.println("drawing weapon at " + weapon.getX() + " " + weapon.getY() + "weapon name: " + weapon.toString());
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void takeDamage(int damage) {
    health -= damage;

    if (health < 0) {
        health = 0;
    }

    System.out.println("Player health: " + health);
}

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    

	public Weapons getWeapon() {
		// TODO Auto-generated method stub
return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void drawWeapon(Graphics g2d) {
        g2d.drawImage(weapon.getPic().getImage(), weapon.getX(), weapon.getY(), weapon.getW(), weapon.getH(), null);

    }





}