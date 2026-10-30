import javax.swing.ImageIcon;

public class Scrooge extends Enemy  {    
    public Scrooge(int x, int y) {
        super(x, y, new ImageIcon("scrooge.png"), 50, 50, 50, 50, 50, new Cookiecutter(x, y));
    }
}