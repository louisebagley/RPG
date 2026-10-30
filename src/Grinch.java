import javax.swing.ImageIcon;

public class Grinch extends Enemy  {    
    public Grinch(int x, int y) {
        super(x, y, new ImageIcon("grinch.png"), 50, 50, 50, 50, 50, new Cookiecutter(x, y));
    }
}