import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Rianna
 * @version May 2026
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantSound.mp3");

    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];

    // Direction elephant is facing
    String facing = "right";

    // Timer for animation
    SimpleTimer animationTimer = new SimpleTimer();

    // Animation frame index
    int imageIndex = 0;

    /**
     * Constructor
     */
    public Elephant()
    {
        // Load right-facing images
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }

        // Load left-facing images
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();

        // Starting image
        setImage(idleRight[0]);
    }

    
    public class SimpleTimer
    {
        private long lastMark;
    
        public SimpleTimer()
        {
            mark();
        }
    
        public void mark()
        {
            lastMark = System.currentTimeMillis();
        }
    
        public int millisElapsed()
        {
            return (int)(System.currentTimeMillis() - lastMark);
        }
    }
    /**
     * Animate the elephant
     */
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();

        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }

    /**
     * Main act method
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 4, getY());
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 4, getY());
            facing = "right";
        }

        // Eat apples
        eat();

        // Animate elephant
        animateElephant();
    }

    /**
     * Eat the apple and create a new one
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