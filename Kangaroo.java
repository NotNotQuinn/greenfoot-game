import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * My two special features are: Instructions, Death, and Success.
 * Meaning when you die, there is a seperate screen, and when you win there is annother.
 * 
 * @author Quinn
 * @version April 2021
 */
public class Kangaroo extends Actor
{
    /**
     * Act - do whatever the Kangaroo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAccordingToUserInput(1, 10);
        eatBalloonIfAble();
    }
    /**
     * Checks for a balloon, if there is one it will be eaten.
     */
    public void eatBalloonIfAble() {
        if (isTouching(Balloon.class)) {
            removeTouching(Balloon.class);
            //Greenfoot.playSound("slurp.wav");
            if (this.getWorldOfType(KangarooWorld.class).getObjects(Balloon.class).size() < 1) {
            if (getWorldOfType(KangarooWorld.class) == null) {
                // wtf
                return;
            }
            EndWorld world = 
                new EndWorld(
                    getWorldOfType(KangarooWorld.class).deathCount + 1,
                    true
                );
            Greenfoot.setWorld(world);
            }
        }
    }
    /**
     * Moves according to user input.
     */
    public void moveAccordingToUserInput(int moveSpeed, int turnSpeed) {
        move(moveSpeed);
        String key = Greenfoot.getKey();
        if (key == null) return;
        switch (key) {
            case "w":
            case "up":
                move(moveSpeed);
                break;
            case "a":
            case "left":
                turn(-turnSpeed);
                break;
            case "s":
            case "down":
                move(-moveSpeed);
                break;
            case "d":
            case "right":
                turn(turnSpeed);
                break;
        }
    }
}
