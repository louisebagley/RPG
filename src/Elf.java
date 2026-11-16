import javax.swing.ImageIcon;

public class Elf extends Characters {
    private ImageIcon idlePic = new ImageIcon("elf.png");
private ImageIcon walkingPic = new ImageIcon("elf.gif");
    

    public Elf(int x, int y, int w, int h) {
        super();
setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPic(idlePic);
        setRange(100);
        setAttack(40);
        setHealth(30);
        setDefense(80);
        setSpeed(60);
        setWeapon(new Candycane(getX(), getY()));
        
    }

    public void setWalking(boolean walking) {
          if (walking) {
                setPic(walkingPic);
          } else {
                setPic(idlePic);
          }
     }

}