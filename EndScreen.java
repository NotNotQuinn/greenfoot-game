import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor
{
    boolean success;
    int deathCount = 0;
    /**
     * Act - do whatever the EndScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Do nothing.
    }
    
    /**
     * Get text that will be displayed upon success.
     */
    public String getSuccessText () {
        return "Congrats!\nYou only died " + deathCount + " times.\n\n\n" + restartMsg();
    }
    
    /**
     * constructor, creates a new EndScreen
     */
    public EndScreen()
    {
        // assume loss.
        this(0, false);
    }
    
    /**
     * Creates a new EndScreen, but with data.
     */
    public EndScreen(int deathCount, boolean success)
    {
        this.deathCount = deathCount;
        this.success = success;
    }
    
    /**
     * Get the text that should be displayed at this moment.
     */
    public String getText() {
        if (success) {
            return this.getSuccessText();
        } else {
            return this.getDeathText();
        }
    }
    
    /**
     * Gets the restart message that should be displayed.
     */
    public String restartMsg() {
        String restartMsg = "\nPress \"R\" to restart.";
        if (deathCount == 0) {
            restartMsg = "Press space to start.";
        }
        return restartMsg;
    }
    
    /**
     * Get text that will be displayed when the user dies.
     */
    public String getDeathText() {
        String msg = "You lose! Oh no.";
        String restartMsg = "\nPress \"R\" to restart.";
        if (deathCount == 0) {
            msg = "This is awkward, 0 deaths.\nWell good luck.\nAlso, Use A and D keys to turn.";
            restartMsg = "Press space to start.";
        }
        if (deathCount > 3) msg = "Wow, you really suck.";
        if (deathCount > 5) msg = "You're really still playing? hm.";
        if (deathCount > 10) msg = "You kinda suck, - but a lot.";
        if (deathCount > 20) msg = "You suck, - a lot.";
        return msg + "\n\nDeaths: " + deathCount + "\n\n\n" + restartMsg();
    }
    
    /**
     * Called when added to any world.
     * 
     * Set the image to the text that should be displayed.
     */
    public void addedToWorld(World world) {
        setImage(new GreenfootImage(
        getText(), 
        (world.getHeight() < world.getWidth() ? world.getHeight() : 
        world.getWidth()) / 10,
        Color.WHITE,
        Color.BLACK));
    }
}
