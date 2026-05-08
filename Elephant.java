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
    GreenfootSound elephantSound = new GreenfootSound("elephantSound.mp3");
    GreenfootImage[] idle = new GreenfootImage[5];
    
    //constructor  - the code that gets run one time when object is created
    public Elephant() 
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    /**
     * animate the elephant 
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = imageIndex + 1 % idle.length;
    }
    
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
        
        //animate the Elephant
        animateElephant();
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
            elephantSound.play();
        }
    }   
}

