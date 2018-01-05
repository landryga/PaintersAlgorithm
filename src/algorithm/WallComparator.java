/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import static algorithm.PaintersAlgorithm.move_x;
import static algorithm.PaintersAlgorithm.move_y;
import static algorithm.PaintersAlgorithm.move_z;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 *
 * @author Kuba
 */
public class WallComparator  {

    public int compare(Wall o1, Wall o2) {
       float viewer_x = -move_x;
       float viewer_y = -move_y;
       float viewer_z = move_z;
       
       /*possible orientation of walls:
        1 - horizontal
        2 - vertical
        3 - parallel to viewport
       */
       
       int position_o1 = o1.getPosition();
       int position_o2 = o2.getPosition();
       
       if(position_o1==1) {
           if(position_o2==1) {
                   if(o1.getY_start()>o2.getY_start()&&viewer_y>o1.getY_start())
                       return 1;
                   else if(o1.getY_start()>o2.getY_start()&&viewer_y<o2.getY_start())
                       return -1;
                   else if(o1.getY_start()<o2.getY_start()&&viewer_y>o2.getY_start())
                       return -1;
                   else if(o1.getY_start()<o2.getY_start()&&viewer_y<o1.getY_start())
                       return 1;
                   else return 0;
               }
               else if(position_o2==2) {
                   if(o1.getY_start()>=max(o2.getY_start(), o2.getY_end())&&viewer_y>o1.getY_start())
                       return 1;
                   else if(o1.getY_start()>=max(o2.getY_start(), o2.getY_end())&&viewer_y<o1.getY_start()) 
                       return -1;
                   else if(o1.getY_start()<=min(o2.getY_start(), o2.getY_end())&&viewer_y>o1.getY_start()) 
                       return -1;
                   else if(o1.getY_start()<=min(o2.getY_start(), o2.getY_end())&&viewer_y<o1.getY_start())
                       return 1;
                   else if(min(o1.getX_start(), o1.getX_end())>=o2.getX_start()&&viewer_x<o2.getX_start())
                       return -1;
                   else if(min(o1.getX_start(), o1.getX_end())>=o2.getX_start()&&viewer_x>o2.getX_start())
                       return 1;
                   else if(max(o1.getX_start(), o1.getX_end())<=o2.getX_start()&&viewer_x<o2.getX_start())
                       return 1;
                   else if(max(o1.getX_start(), o1.getX_end())<=o2.getX_start()&&viewer_x>o2.getX_start())
                       return -1;
                   
                   else return 0;
               }
               else {
                   if(o2.getZ_start()>=max(o1.getZ_end(), o1.getZ_start()))
                       return -1;
                   else if (o1.getY_start()>=max(o2.getY_start(), o2.getY_end())&&viewer_y >o1.getY_start())
                       return 1;
                   else if (o1.getY_start()>=max(o2.getY_start(), o2.getY_end())&&viewer_y <o1.getY_start())
                       return -1;
                   else if (o1.getY_start()<=min(o2.getY_start(), o2.getY_end())&&viewer_y >o1.getY_start())
                       return -1;
                   else if (o1.getY_start()<=min(o2.getY_start(), o2.getY_end())&&viewer_y <o1.getY_start())
                       return 1;
                   
                   else return 0;
               }
       }
       
       else if (position_o1==2) {
           if(position_o2==1) { 
                   
                   if(min(o1.getY_start(), o1.getY_end())>=o2.getY_end()&&viewer_y<o1.getY_start()) 
                       return -1;
                   else if(min(o1.getY_start(), o1.getY_end())>=o2.getY_end()&&viewer_y>o1.getY_start())
                       return 1;
                   if(max(o1.getY_start(), o1.getY_end())<=o2.getY_end()&&viewer_y<o1.getY_start()) 
                       return 1;
                   else if(max(o1.getY_start(), o1.getY_end())<=o2.getY_end()&&viewer_y>o1.getY_start())
                       return -1;
                   
                   else if(o1.getX_end()<min(o2.getX_start(), o2.getX_end())&&viewer_x <o1.getX_end())
                       return 1;
                   else if(o1.getX_end()<min(o2.getX_start(), o2.getX_end())&&viewer_x >o1.getX_end())
                       return 0;
                   else if(o1.getX_end()>max(o2.getX_start(), o2.getX_end())&&viewer_x <o1.getX_end())
                       return 0;
                   else if(o1.getX_end()>max(o2.getX_start(), o2.getX_end())&&viewer_x >o1.getX_end())
                       return 1;
                   else return 0;
               }
               else if (position_o2==2) {
                   if(o1.getX_start()>o2.getX_start()&&viewer_x>o1.getX_start())
                       return 1;
                   else if(o1.getX_start()>o2.getX_start()&&viewer_x<o2.getX_start())
                       return -1;
                   else if(o1.getX_start()<o2.getX_start()&&viewer_x<o1.getX_start())
                       return 1;
                   else if(o1.getX_start()<o2.getX_start()&&viewer_x>o2.getX_start())
                       return -1;
                   
                   else return 0;
               }
               else {
                   if(o2.getZ_start()>=max(o1.getZ_end(), o1.getZ_start()))
                       return -1;
                   else if (o1.getX_start()>=max(o2.getX_start(), o2.getX_end())&&viewer_x >o1.getX_start())
                       return 1;
                   else if (o1.getX_start()>=max(o2.getX_start(), o2.getX_end())&&viewer_x <o1.getX_start())
                       return -1;
                   else if (o1.getX_start()<=min(o2.getX_start(), o2.getX_end())&&viewer_x >o1.getX_start())
                       return -1;
                   else if (o1.getX_start()<=min(o2.getX_start(), o2.getX_end())&&viewer_x <o1.getX_start())
                       return 1;
                   
                   else return 0;
               }
       }
               
       else {
           if(position_o2==1) {
                   if(o1.getZ_start()>=max(o2.getZ_end(), o2.getZ_start()))
                       return 1;
                   else if (o2.getY_start()>max(o1.getY_start(), o1.getY_end())&&viewer_y >o2.getY_start())
                       return -1;
                   else if (o2.getY_start()>max(o1.getY_start(), o1.getY_end())&&viewer_y <o2.getY_start())
                       return 1;
                   else if (o2.getY_start()<=min(o1.getY_start(), o1.getY_end())&&viewer_y <o2.getY_start())
                       return -1;
                   else if (o2.getY_start()<=min(o1.getY_start(), o1.getY_end())&&viewer_y >o2.getY_start())
                       return 1;
                   else return 0;
               }
               else if(position_o2==2) {
                   if(o1.getZ_start()>=max(o2.getZ_end(), o2.getZ_start()))
                       return 1;
                   else if (o2.getX_start()>=max(o1.getX_start(), o1.getX_end())&&viewer_x >o2.getX_start())
                       return -1;
                   else if (o2.getX_start()>=max(o1.getX_start(), o1.getX_end())&&viewer_x <o2.getX_start())
                       return -1;
                   else if (o2.getX_start()<=min(o1.getX_start(), o1.getX_end())&&viewer_x <o2.getX_start())
                       return -1;
                   else if (o2.getX_start()<=min(o1.getX_start(), o1.getX_end())&&viewer_x >o2.getX_start())
                       return 1;
                   else return 0;
               }
               else {
                   if(o1.getZ_start()>o2.getZ_start())
                       return 1;
                   else return -1;
               }
       }
    } 
}

