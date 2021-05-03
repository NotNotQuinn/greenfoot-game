import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    boolean success = false;
    int deathCount = 0;
    public void act() {
        if (success) {
            deathCount = 0;
            success = false;
        }
        
        if (Greenfoot.isKeyDown("r") || (Greenfoot.isKeyDown("space") && deathCount == 0)) {
            KangarooWorld wrld = new KangarooWorld(deathCount);
            wrld.populateFully();
            Greenfoot.setWorld(wrld);
        }
    }
    /**
     * Alias for `EndWorld(0, false)`;
     */
    public EndWorld()
    {    
        this(0, false);
    }
    
    /**
     * Creates a new EndWorld, with deathcount and success that
     * are passed to EndScreen.
     */
    public EndWorld(int deathCount, boolean success)
    {    
        super(600, 400, 1);
        this.deathCount = deathCount;
        this.success = success;
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        addObject(new EndScreen(deathCount, success), getWidth()/2, getHeight()/2);
    }
}
