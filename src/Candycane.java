import javax.swing.ImageIcon;

public class Candycane  extends range{
    
    public Candycane() {
        super();
    }

    public Candycane(int x, int y) {
        super(25, 3, new ImageIcon("candycane.png"), x, y+200, 50, 50);
    }
    public String toString() {
        return "Candycane";
    }
}