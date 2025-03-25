import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionManager {
    Panel panel;
    ArrayList<Rectangle> wallBounds = new ArrayList<>();

    public CollisionManager(Panel panel){
        this.panel = panel;
        defineWalls();
    }

    private void defineWalls() {
        wallBounds.add(new Rectangle(60, 60, 72, 48));
    }

    public boolean checkCollision(Entity entity) {
        for (Rectangle wall : wallBounds) {
            if (entity.solidArea.intersects(wall)) {
                return true;
            }
        }
        return false;
    }

}
