import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {

    public Projectile(int centerx, int y, int speed, GameObjectManager gameObjectManager) {
        super(centerx - 5/2, y, 5, 16, speed, 1, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.spriteDrawing = new char[][]{
                {' ', ' ', 'o', ' ', ' '},
                {' ', 'o', 'o', 'o', ' '},
                {'o', 'X', 'X', 'X', 'o'},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '}};

    }

    @Override
    public void tick() {
        super.tick();

        y -= speed;
    }

    @Override
    protected Color getColor() {
        return Color.gray;
    }

    @Override
    protected Color getSecondaryColor(){

        return Color.cyan;

    }
}
