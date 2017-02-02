/*
 * Support class to PodApp that acts like a container
 * for a list of Pod objects. Simplifies earlier version
 * of PodGame.
 */
package project6;

/**
 *
 * @author seanblucker
 */
import java.util.*;
import java.util.Random;

public class PodList 
{
   private ArrayList<Pod> Pods;                                                 //ArrayList that stores Pod objects
   private int width;                                                           //Variable that stores width of game board
   private int height;                                                          //Variable that stores height of game board

   //Constructor that creates a new ArrayList of Pod objects and records width and height
   public PodList(int width, int height)
   {
       Pods = new ArrayList();
       Pods.add(new Pod(1, 5, "NE", width, height));
       Pods.add(new Pod(2, 1, "SW", width, height));
       Pods.add(new Pod(12, 2, "NW", width, height));
       Pods.add(new Pod(13, 6, "SE", width, height));
       this.width = width;
       this.height = height;            
   }
   
   //Modifier method that moves Pods in ArrayList
   public void moveAll()
   {
       for(int i = 0; i < Pods.size(); ++i)
       {
           Pods.get(i).move();
       }
   }
   
   //Modifier method that generates new Pod objects 10% of time with random x,y-coordinates and direction
   public void generate()
   {
       String direction = "";
       Random rn1 = new Random();
       Random rn2 = new Random();
       Random rn3 = new Random();
       Random percent = new Random();
       int randX = rn1.nextInt(width-1) + 1;
       int randY = rn2.nextInt(height-1) + 1;
       int randDir = rn3.nextInt(4) + 1;
       
       if(randDir%4 == 0)
           direction = "NE";
       if(randDir%4 == 1)
           direction = "NW";
       if(randDir%4 == 2)
           direction = "SE";
       if(randDir%4 == 3)
           direction = "SW";
       
       if(percent.nextInt(10)==0)
           Pods.add(new Pod(randX, randY, direction, width, height));      
   }
   
   //Boolean method that returns true if there is Pod object at specified location and false otherwise
   public boolean isPod(int x, int y)
   {
       Pod p = new Pod(x, y, " ", width, height);

       if(Pods.contains(p))
           return true;
       else
           return false;
   }
   
   //Modifier method that removes Pod object if it is at specified x,y-coordinates
   public void playerAt(int x, int y)
   {
       Pod p = new Pod(x, y, " ", width, height);
       
       if(Pods.contains(p))
           Pods.remove(p);
   }
}
