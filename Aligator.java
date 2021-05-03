import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aligator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aligator extends Actor
{
int turnDirection;
    /**
     * Act. Called when 'Act' or 'Run' button is pressed.
     */
    public void act()
    {
        turnDirection = (Greenfoot. getRandomNumber(2) == 1) ?  -1 : 1;
        turnIfAtEdge();
        turnOnChance();
        move(1);
        eatKangarooIfAble();
    }
    
    /**
     * Checks for a kangaroo, if there is one it will be eaten.
     */
    public void eatKangarooIfAble() {
        if (isTouching(Kangaroo.class)) {
            removeTouching(Kangaroo.class);
            if (getWorldOfType(KangarooWorld.class) == null) {
                // wtf
                return;
            }
            EndWorld world = 
                new EndWorld(
                    getWorldOfType(KangarooWorld.class).deathCount + 1,
                    false
                );
            Greenfoot.setWorld(world);
        }
    }
    /**
     * Turns if at edge.
     */
    public void turnIfAtEdge() {
        if (isAtEdge())
        {
            turn(7 * turnDirection * (Greenfoot . getRandomNumber(10) + 1));
        }
    }
    /**
     * Turns at random.
     */
    public void turnOnChance() {
        if (Greenfoot . getRandomNumber(100) < 7) 
        {
            turn((Greenfoot . getRandomNumber(45)) * (turnDirection));
        }
    }  
}
