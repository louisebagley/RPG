import javax.swing.ImageIcon;

public class Santa extends Characters {
    private ImageIcon idlePic = new ImageIcon("Santa.png");
private ImageIcon walkingPic = new ImageIcon("santaWalk.gif");

    public Santa(int x, int y, int w, int h) {
        super();
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(idlePic);
        setRange(30);
        setAttack(20);
        setHealth(100);
        setDefense(90);
        setSpeed(70);
        setWeapon(new Antler(getX(), getY()));

    }

    public void setWalking(boolean walking) {
        if (walking) {
            setPic(walkingPic);
        } else {
            setPic(idlePic);
        }
    }
}