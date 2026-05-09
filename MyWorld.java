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
    int level = 1;
    
    /**
     * constructor for objects of class MyWorld. 
     */
    public MyWorld() 
    {
        //Create a new world with 600x400 cells with a cell size of 1x1 pixels
        super(600, 400, 1, false);
        
        GreenfootImage bg = new GreenfootImage("background.png");
        bg.scale(600, 400);
        setBackground(bg);

        
        //Create the elephnat object 
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * end the game and draw "game over"
     */
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        //Add a you win label once player reaches 10 apples touched/eaten
        if (score >= 10)
        {
            Label winLabel = new Label ("YOU WIN!!", 100);
            addObject(winLabel, 300, 200);
            Greenfoot.stop();
        }
        if (score % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
