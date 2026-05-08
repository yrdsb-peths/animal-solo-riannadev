import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant
 * 
 * @author (Rianna) 
 * @version (Mar 2026)
 */
public class Apple extends Actor
{
    public Apple() {
        GreenfootImage image = new GreenfootImage("images/apple.png");
        image.scale(40, 40);
        setImage(image);
    }
    int speed = 1;
    public void act()
    {
        // apple falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //remove apple and draw game over when apple hots bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        
    }
}
