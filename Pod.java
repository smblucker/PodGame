/*
 * Support class to PodApp and PodList classes that
 * specifies Pod object movement and that determines
 * position equality between Player and Pods.
 */
package project6;

/**
 *
 * @author seanblucker
 */
public class Pod 
{
   private int pod_x;           //instance variable for x-coordinate of pod 
   private int pod_y;           //instance variable for y-coordinate of pod
   private String pod_dir;      //instance variable for pod direction
   private int board_w;         //instance variable for width of game board
   private int board_h;         //instance variable for height of game board

   //Pod constructor that receives five parameters
   public Pod(int x, int y, String direction, int width, int height)
   {
       this.pod_x = x;
       this.pod_y = y;
       this.pod_dir = direction;
       this.board_w = width;
       this.board_h = height;
   }
   
   
   //Method that overrides .equals method
   public boolean equals(Object obj)
   {
       if(!(obj instanceof Pod))
           return false;
       else
       {
           Pod p = (Pod)obj;
           return (pod_x == p.pod_x && pod_y == p.pod_y);
       }
   }
   
   //Method that defines movement of pods
   public void move()
   {
       int left_wall = 0;       //sets left board wall coordinates x=0
       int lower_wall = 0;      //sets lower board wall coordinates y=0
       
       if(pod_dir=="NE")        //defines northeast pod movement
       {
           pod_x++;
           pod_y++;
       }
       
       if(pod_dir=="NW")        //defines northwest pod movement
       {
           pod_x--;
           pod_y++;
       }
       
       if(pod_dir=="SE")        //defines southeast pod movement
       {
           pod_x++;
           pod_y--;
       }
       
       if(pod_dir=="SW")        //defines southwest pod movement
       {
           pod_x--;
           pod_y--;
       }
       
       if(pod_dir=="NE" && pod_x==board_w - 1 && pod_y==board_h - 1)      //pod hits upper right corner: redirect pod from NE to SW
       {
           pod_dir = "SW";
       }
       
       if(pod_dir=="NE" && pod_x==board_w - 1)      //pod hits right wall: redirect pod from NE to NW
       {
           pod_dir = "NW";
       }
       
       if(pod_dir=="NE" && pod_y==board_h - 1)      //pod hits upper wall: redirect pod from NE to SE
       {
           pod_dir = "SE";
       }
       
       if(pod_dir=="NW" && pod_x==left_wall && pod_y==board_h - 1)        //pod hits upper left corner: redirect pod from NW to SE
       {
           pod_dir = "SE";
       }
       
       if(pod_dir=="NW" && pod_x==left_wall)        //pod hits left wall: redirect pod from NW to NE
       {
           pod_dir = "NE";
       }
       
       if(pod_dir=="NW" && pod_y==board_h - 1)      //pod hits upper wall: redirect pod from NW to SW
       {
           pod_dir = "SW";
       }
       
       if(pod_dir=="SE" && pod_x==board_w - 1 && pod_y==lower_wall)      //pod hits lower right corner: redirect pod from SE to NW
       {
           pod_dir = "NW";
       }
       
       if(pod_dir=="SE" && pod_x==board_w - 1)      //pod hits right wall: redirect pod from SE to SW
       {
           pod_dir = "SW";
       }
       
       if(pod_dir=="SE" && pod_y==lower_wall)       //pod hits lower wall: redirect pod from SE to NE
       {
           pod_dir = "NE";
       }
       
       if(pod_dir=="SW" && pod_x==left_wall && pod_y==lower_wall)    //pod hits lower left corner: redirect pod from SW to NE
       {
           pod_dir = "NE";
       }
       
       if(pod_dir=="SW" && pod_x==left_wall)    //pod hits left wall: redirect pod from SW to SE
       {
           pod_dir = "SE";
       }
       
       if(pod_dir=="SW" && pod_y==lower_wall)   //pod hits lower wall: redirect pod from SW to NW
       {
           pod_dir = "NW";
       }

   }
}
