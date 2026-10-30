import javax.swing.ImageIcon;

public class Cookiecutter  extends range{
    
    public Cookiecutter() {
        super();
    }

    public Cookiecutter(int x, int y) {
        super(25, 3, new ImageIcon("cookiecutter.png"), x, y+200, 50, 50);
    }
    public String toString() {
        return "Cookiecutter";
    }
}