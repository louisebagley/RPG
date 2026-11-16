import javax.swing.ImageIcon;

public class Kid extends Characters {
        private ImageIcon idlePic = new ImageIcon("kid.png");
private ImageIcon walkingPic = new ImageIcon("kid.gif");

    public Kid(int x, int y, int w, int h) {
        super();



    setX(x);
        setY(y);
        setW(w);
        setH(h);

        setPic(idlePic);
        setRange(10);
        setAttack(70);
        setHealth(30);
        setDefense(20);
        setSpeed(100);
        setWeapon(new Boot(getX(), getY()));
        
    }

    public void setWalking(boolean walking) {
          if (walking) {
                setPic(walkingPic);
          } else {
                setPic(idlePic);
          }
     }
    
}