import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Weapons{

    private int damage, x,y,w,h,dx;
    private int attackSpeed;
    private ImageIcon pic, movePic;


    public Weapons(){
        damage = 0;
        attackSpeed = 0;
        pic= new ImageIcon("pic.jpg");
        x=0;
        y=0;
        w=50;
        h=50;
        dx=2;


    }

    public Weapons(int damage, int attackSpeed, ImageIcon pic) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.pic = pic;
        x=0;
        y=0;
        w=50;
        h=50;
        dx=2;
    }
    
    public Weapons(int damage, int attackSpeed, ImageIcon pic, int xv, int yv) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.pic = pic;
        x=xv;
        y=yv;
        w=50;
        h=50;
        dx=2;
    }
        
    public Weapons(int damage, int attackSpeed, ImageIcon pic, int xv, int yv, int wv, int hv) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.pic = pic;
        x=xv;
        y=yv;
        w=wv;
        h=hv;
        dx=6;
        System.out.println("weapon created at " + x + " " + y + " weapon name: " + this.toString());
    }

    public void drawMove(Graphics g2d) {
        g2d.drawImage(pic.getImage(), x, y, w, h, null);
    }

    public String toString(){
        return "Damage: " + damage + " Attack Speed: " + attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }   

    public void move(){
        x += dx;
    }

    public void setDx(int dx) {
    this.dx = dx;
}
    
}