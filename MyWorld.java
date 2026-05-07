import greenfoot.*;

/**
 * The world our hero lives in 
 * 
 * @author Rianna
 * @version May 2026
 */

public class MyWorld extends World 
{
    public int score = 0;
    Label scoreLabel;
    /**
     * constructor for objects of class MyWorld. 
     */
    public MyWorld() 
    {
        //Create a new world with 600x400 cells with a cell size of 1x1 pixels
        super(600, 400, 1);
        
        //Create the elephnat object 
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
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
