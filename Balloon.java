import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor
{
/**
     * Act - do whatever the Worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        int range = 30 + Greenfoot.getRandomNumber(5) * 10;
        int speed = Greenfoot.getRandomNumber(range/10);
        //moveAwayFromKangarooInRange(range, speed);
    }
    /**
     * Gets the closes kangaroo
     */
    public Kangaroo getClosestKangaroo(int range) {
        Kangaroo closestKangaroo;
        java.util.List<Kangaroo> nearKangaroos = getObjectsInRange(range, Kangaroo.class);
        if (nearKangaroos.size() < 1) return null;
        closestKangaroo = nearKangaroos.get(0);
        return closestKangaroo;
    }
    
    /**
     * Moves away from the closest kangaroo in a certain range.
     * 
     * (Not used, because I think it makes it too hard.)
     */
    public void moveAwayFromKangarooInRange(int range, int speed) {
        Kangaroo clstest = getClosestKangaroo(range);
        if (clstest == null) return;
        // https://www.greenfoot.org/topics/183
        int x = clstest.getX() - getX();      
        int y = clstest.getY() - getY();      
        double r = Math.toDegrees(Math.atan2(x, y)) - 270;
        setRotation(-(int) r);
        move(speed);
    }   
}
