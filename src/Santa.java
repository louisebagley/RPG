import javax.swing.ImageIcon;

public class Santa extends Characters {

    public Santa(int x, int y, int w, int h) {
        super();
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(new ImageIcon("santa.png"));
        setRange(30);
        setAttack(20);
        setHealth(100);
        setDefense(90);
        setSpeed(70);
        setWeapon(new Antler(getX(), getY()));

    }
}