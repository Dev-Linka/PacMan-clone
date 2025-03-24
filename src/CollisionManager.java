import java.awt.Graphics;

public class CollisionManager {
    Panel panel;
    Tile tile;

    public CollisionManager(Panel panel){
        this.panel = panel;
        tile = new Tile();

    }

    public boolean canMove(int x, int y, int width, int height){


        

        return true;
    }

    /*public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / panel.TILESIZE;
        int entityRightCol = entityRightWorldX / panel.TILESIZE;
        int entityTopRow = entityTopWorldY / panel.TILESIZE;
        int entityBottomRow = entityBottomWorldY / panel.TILESIZE;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / panel.TILESIZE;

                break;
            case "down":
                
                break;
            case "left":
                
                break;
            case "right":
                
                break;
            default:
                break;
        }
    }*/



}
