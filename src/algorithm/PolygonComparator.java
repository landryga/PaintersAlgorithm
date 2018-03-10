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
public class PolygonComparator  {

    public int compare(Polygon o1, Polygon o2) {
       /*
    	float viewer_x = -move_x;
       float viewer_y = -move_y;
       float viewer_z = move_z;
       
       possible orientation of walls:
        1 - horizontal
        2 - vertical
        3 - parallel to viewport
       */
       
       int position_o1 = o1.getPosition();
       int position_o2 = o2.getPosition();
	
       return 0;
       
    } 
}

