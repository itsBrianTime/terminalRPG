  
/*
 * Sprite.java is a class that takes .txt files (using https://www.ascii-art-generator.org/ 
 * to generate ansi files) of sprites and stores them, line by line, in a List (String). 
 * That list can be printed to the terminal thus "drawing" the sprite.
 * 
 * @author Brian Bessler
 * @version 1.2
 * @since 05-22-2022
 * 
 */

package terminalrpg.magicterminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MagicSprite {

    private String spritePath = "";
    private List<String> sprite;

    /**
     * Sprite Constructor. It takes a relative path to the desired sprite and
     * creates it.
     * @param paramSpritePath relative path to sprite
     */
    public MagicSprite(String paramSpritePath) {
        spritePath = paramSpritePath;
        createSprite();
    }

    
    /** 
     * Sets the relative path of the sprite image.
     * @param paramSpritePath String parameter of the path to desired image
     */
    public void setPath(String paramSpritePath) {
        spritePath = paramSpritePath;
    }

    
    /** 
     * Gets relative path of the sprite image. 
     * @return String parameter of the image path
     */
    public String getPath() {
        return spritePath;
    }
    
    /** 
     * Sets the sprite array. This array is a line by line representation of
     * the sprite image.
     * @param paramSprite Array is a line by line representation of the sprite.
     */
    public void setSprite(List<String> paramSprite) {
        sprite = paramSprite;
    }
    
    /** 
     * Gets the sprite array. This array is a line by line representation of
     * the sprite image.
     * @return List (String) is a line by line representation of the sprite.
     */
    public List<String> getSprite() {
        return sprite;
    }
    
    /**
     * Runs in the constructor. Reads the sprite character txt and saves it
     * as a List that is a line by line representation of the sprite.
     */
    public void createSprite() {
        Path filePath = Paths.get(getPath());
        try {
            setSprite(Files.readAllLines(filePath));
        } catch (IOException ex) {
            System.out.format("I/O error in sprite.java: %s%n", ex);
        }
    }

    /**
     * Draws the sprite in the terminal by printing each line.
     */
    public boolean drawSprite() {
        for (String line: getSprite()) {
            System.out.println(line);
        }
        return true;
    }
}

