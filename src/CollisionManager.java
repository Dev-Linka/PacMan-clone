import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CollisionManager {
    private BufferedImage tileset;
    private BufferedImage[][] tiles;
    private int tileWidth;
    private int tileHeight;
    
    public CollisionManager(String imagePath, int tileWidth, int tileHeight) {
        try {
            this.tileset = ImageIO.read(getClass().getResourceAsStream(imagePath));
            this.tileWidth = tileWidth;
            this.tileHeight = tileHeight;
            extractTiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void extractTiles() {
        int rows = tileset.getHeight() / tileHeight;
        int cols = tileset.getWidth() / tileWidth;
        tiles = new BufferedImage[rows][cols];
        
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                tiles[y][x] = tileset.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
            }
        }
    }
    
    public BufferedImage getTile(int row, int col) {
        if (row >= 0 && row < tiles.length && col >= 0 && col < tiles[0].length) {
            return tiles[row][col];
        }
        return null;
    }
    
    public static void main(String[] args) {
        CollisionManager extractor = new CollisionManager("Pacman-Tiles.png", 8, 8);
        
        // Salva una tile di esempio
        try {
            BufferedImage tile = extractor.getTile(0, 0);
            if (tile != null) {
                ImageIO.write(tile, "png", new File("tile_output.png"));
                System.out.println("Tile estratta con successo!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
