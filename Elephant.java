import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Rianna) 
 * @version (May 2026)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        
        //Remove apple if elephant eats it 
        eat();
    }
    
    /**
     * eat the apple and spawn new if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
        }
    }   
}

