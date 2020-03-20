import java.util.ArrayList;

public class GameObjectManager {

    private boolean rightKeyPressed;
    private boolean leftKeyPressed;
    private boolean spacePressed;

    private WaveManager waveManager;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private ArrayList<GameObject> addedObjects = new ArrayList<>();
    private ArrayList<GameObject> deletedObjects = new ArrayList<>();

    private Player player;

    public GameObjectManager() {
         waveManager = new WaveManager(this);

        player = new Player(Board.BOARD_WIDTH/2, Board.BOARD_HEIGHT-60, 5, 5,this);
        gameObjects.add(player);
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void updateObjects(){
        gameObjects.addAll(addedObjects);
        gameObjects.removeAll(deletedObjects);

        addedObjects = new ArrayList<>();
        deletedObjects = new ArrayList<>();

        if (gameObjects.size() == 1){
            gameObjects.addAll(waveManager.getNextWave());
        }
    }

    public void levelPassed(){}

    public boolean isIntersecting(GameObject gameObjectA, GameObject gameObjectB){

        int topA = gameObjectA.y;
        int bottomA = gameObjectA.y + gameObjectA.height;
        int leftA = gameObjectA.x;
        int rightA = gameObjectA.x + gameObjectA.width;

        int topB = gameObjectB.y;
        int bottomB = gameObjectB.y + gameObjectB.height;
        int leftB = gameObjectB.x;
        int rightB = gameObjectB.x + gameObjectB.width;

        return ((topA <= bottomB && bottomA >= bottomB) || (bottomA >= topB && bottomA <= bottomB)) && ((rightA >= leftB && leftA <= leftB) || (leftA <= rightB && leftA >= leftB));
    }

    public void addToQue(GameObject gameObject){
        addedObjects.add(gameObject);
    }

    public void addToRemovalQue(GameObject gameObject){
        deletedObjects.add(gameObject);
    }

    public void spacePressed(){
        this.spacePressed = true;
    }
    public void spaceReleased(){
        this.spacePressed = false;
    }

    public void rightKeyPressed(){
        this.rightKeyPressed = true;
    }
    public void rightKeyReleased(){
        this.rightKeyPressed = false;
    }

    public void leftKeyPressed(){
        this.leftKeyPressed = true;
    }
    public void leftKeyReleased(){
        this.leftKeyPressed = false;
    }

    public boolean isRightKeyPressed() {
        return rightKeyPressed;
    }
    public boolean isLeftKeyPressed() {
        return leftKeyPressed;
    }
    public boolean isSpacePressed() {
        return spacePressed;
    }
}

