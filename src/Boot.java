import javax.swing.ImageIcon;

public class Boot  extends range{
    
    public Boot() {
        super();
    }

    public Boot(int x, int y) {
        super(25, 3, new ImageIcon("boot.png"), x, y+200, 50, 50);
    }
    public String toString() {
        return "Boot";
    }
}