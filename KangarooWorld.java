import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KangarooWorld extends greenfoot.World
{
    int deathCount;
    boolean populated = false;
    boolean hasPlayer = false;
    /**
     * Create the kangaroo world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public KangarooWorld(int deathCount) 
    {
        super(560, 560, 1, true);
        this.deathCount = deathCount;
        setPaintOrder(Kangaroo.class, Balloon.class); // draw Kangaroo.class on top of Balloon.class
        setPaintOrder(Aligator.class, Kangaroo.class); // draw Aligator.class on top of Kangaroo.class
        setPaintOrder(Aligator.class, Balloon.class); // draw Aligator.class on top of Balloon.class
        Greenfoot.start();
    }
    /**
     * Alias for `KangarooWorld(0)`.
     */
    public KangarooWorld() {this(0);};
    
    /**
     * Populate the world with some aligators and balloons.
     * 
     * But only if not already populated.
     */    
    public void populate(int aligators, int balloons)
    {
        if (populated) return;
        populated = true;
        randomAligators(aligators);
        randomBalloons(balloons);
    }
    
    /**
     * When the world starts, attempt to populateFully()
     */
    public void started() {
        populateFully();
    }
    
    /**
     * Alias for `populateFully(1, 20)`.
     */
    public void populateFully() {populateFully(1, 20);}
    
    /**
     * Populates the world with aligators and balloons, but also a player.
     * 
     * Only if not populated.
     */
    public void populateFully(int aligators, int balloons) {
        populate(aligators, balloons);
        int kangarooX = Greenfoot.getRandomNumber(getWidth());
        int kangarooY = Greenfoot.getRandomNumber(getWidth());
        if (!hasPlayer) {
            addObject(new Kangaroo(), kangarooX, kangarooY);
            hasPlayer = true;
        } 
    }
    
    /**
     * Alias for `populate(1, 20)`.
     */
    public void populate() {
        populate(1, 20);
    }
    
    /**
     * Place a number of balloons into the world at random places.
     * The number of balloons can be specified.
     */
    public void randomBalloons(int ammount)
    {
        for (int i=0; i<ammount; i++) {
            Balloon balloon = new Balloon();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getWidth());
            addObject(balloon, x, y);
        }
    }
    
    /**
     * Place a number of aligators into the world at random places.
     * The number of aligators can be specified.
     */
    public void randomAligators(int ammount)
    {
        for (int i=0; i<ammount; i++) {
            Aligator aligator = new Aligator();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getWidth());
            addObject(aligator, x, y);
        }
    }
}
