import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @author (Rianna) 
 * @version (May 2026)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    /**
     * the main world act loop
     */
    public void act()
    {
        // start the game if the user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,532,94);
        elephant.setLocation(528,95);
        elephant.setLocation(525,88);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,364,279);
        label.setLocation(289,297);
        elephant.setLocation(84,98);
        Apple apple = new Apple();
        addObject(apple,510,69);
        apple.setLocation(547,181);
        apple.setLocation(532,108);
        Label label2 = new Label("Use <-- and --> to Move", 40);
        addObject(label2,309,263);
        label2.setLocation(302,244);
        label.setLocation(319,322);
        label2.setLocation(297,254);
        elephant.setLocation(69,69);
        apple.setLocation(542,74);
        label.setLocation(292,317);
    }
}
