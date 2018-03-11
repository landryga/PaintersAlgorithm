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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kuba
 */
public class PolygonComparator  {

    public int compare(Polygon p1, Polygon p2) {
    	
    	List<double[]> p1CoordsContainer = new ArrayList();
    	List<double[]> p2CoordsContainer = new ArrayList();
    	
    	p1CoordsContainer = p1.getPostVertList();
    	p2CoordsContainer = p2.getPostVertList();
       
	    //TEST 1 - depth overlap
    	double z_min;
    	double z_max;
    	
    	double[] t_reference1 = p1CoordsContainer.get(0);
    	z_min = t_reference1[2];
    	
    	double[] t_reference2 = p1CoordsContainer.get(0);
    	z_max = t_reference2[2];
    	
    	for(int i = 1; i < p1CoordsContainer.size(); i++) {
    		double[] t = p1CoordsContainer.get(i);
    		if (t[2]<z_min) 
    			z_min = t[2];
    	}
    	
    	for(int i = 1; i < p2CoordsContainer.size(); i++) {
    		double[] t = p2CoordsContainer.get(i);
    		if (t[2]>z_max) 
    			z_max = t[2];
    	}
    	
    	if (z_min<=z_max) {
    		return 0;
    	}
    	else return 1;
    
	    	
		
       
    } 
}

