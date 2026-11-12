import javax.swing.ImageIcon;

public class MrsClaus extends Characters {
    private ImageIcon idlePic = new ImageIcon("mrsclaus.png");
private ImageIcon walkingPic = new ImageIcon("mrsclausWalk.gif");

    public MrsClaus(int x, int y, int w, int h) {
        super();
setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(idlePic);
        setRange(10);
        setAttack(20);
        setHealth(100);
        setDefense(200);
        setSpeed(40);
        setWeapon(new Cookiecutter(getX(), getY()));
        
    }

   public void setWalking(boolean walking) {
        if (walking) {
            setPic(walkingPic);
        } else {
            setPic(idlePic);
        }
    }
}