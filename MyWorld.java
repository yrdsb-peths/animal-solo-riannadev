import greenfoot.*;

/**
 * The world our hero lives in 
 * 
 * @author Rianna
 * @version April 2026
 */

public class MyWorld extends World {
    /**
     * constructor for objects of class MyWorld. 
     */
    public MyWorld() 
    {
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        createApple();
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
