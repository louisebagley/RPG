import javax.swing.ImageIcon;

public class Antler  extends range{
    
    public Antler() {
        super();
    }

    public Antler(int x, int y) {
        super(25, 3, new ImageIcon("antler.png"), x, y+200, 50, 50);
    }
    public String toString() {
        return "Antler";
    }
}