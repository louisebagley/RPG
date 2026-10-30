import javax.swing.ImageIcon;

public class Enemy extends Characters{
    public Enemy(int x, int y,ImageIcon pic, int range, int attack, int health, int defense, int speed, Weapons weapon) {
        super(x,y,pic,range, attack, health, defense ,speed, weapon);
    }
}