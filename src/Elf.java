import javax.swing.ImageIcon;

public class Elf extends Characters {

    public Elf(int x, int y, int w, int h) {
        super();
setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(new ImageIcon("elf.png"));
        setRange(100);
        setAttack(40);
        setHealth(30);
        setDefense(80);
        setSpeed(60);
        setWeapon(new Candycane(getX(), getY()));
        
    }


}