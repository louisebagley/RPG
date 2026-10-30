import javax.swing.ImageIcon;

public class MrsClaus extends Characters {

    public MrsClaus(int x, int y, int w, int h) {
        super();
setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(new ImageIcon("mrsclaus.png"));
        setRange(10);
        setAttack(20);
        setHealth(100);
        setDefense(200);
        setSpeed(40);
        setWeapon(new Cookiecutter(getX(), getY()));
        
    }

   
}