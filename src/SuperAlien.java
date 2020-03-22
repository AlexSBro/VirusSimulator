import java.awt.*;

public class SuperAlien extends Alien {

    public SuperAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.health = health;
        this.speed = speed;

        this.width = 40;
        this.height = 40;

        this.initialX = x;
        this.initialY = y;

        moveLeft = false;
        moveRight = true;

        this.gameObjectManager = gameObjectManager;
    }

    public void tick(){
        super.tick();

        alienMovementAlgorithm();
        registerHits();
    }

    public void paint(Graphics graphics){
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

}
