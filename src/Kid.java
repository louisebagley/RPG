import javax.swing.ImageIcon;

public class Kid extends Characters {

    public Kid(int x, int y, int w, int h) {
        super();

        ImageIcon kidPic = new ImageIcon("kid.png");

    setX(x);
        setY(y);
        setW(w);
        setH(h);

        setPic(kidPic);
        setRange(10);
        setAttack(70);
        setHealth(30);
        setDefense(20);
        setSpeed(100);
        setWeapon(new Boot(getX(), getY()));
        
    }

    
}