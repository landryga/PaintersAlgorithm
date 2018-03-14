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

	//returns 1 if p1 is before p2 
    public int compare(Polygon p1, Polygon p2) {
    	
    	List<double[]> p1CoordsContainer = new ArrayList();
    	List<double[]> p2CoordsContainer = new ArrayList();
    	
    	p1CoordsContainer = p1.getPostVertList();
    	p2CoordsContainer = p2.getPostVertList();
    	
    	double z1_min = p1.getZmin();
    	double z2_max = p2.getZmax();
    	
    	double x1_max = p1.getXmax();
    	double x2_min = p2.getXmin();
    	
    	double y1_max = p1.getYmax();
    	double y2_min = p2.getYmin();
    	
    	//Calculate 4 inequalities for TEST 3
    	double[] eq = p1.getPlaneEquation();
    	
    	//Vertice 1
    	double v1_eq = p2.getPostVertList().get(0)[0] *eq[0] + p2.getPostVertList().get(0)[1] *eq[1] + p2.getPostVertList().get(0)[2] *eq[2] + eq[3];
    	//Vertice 2
    	double v2_eq = p2.getPostVertList().get(1)[0] *eq[0] + p2.getPostVertList().get(1)[1] *eq[1] + p2.getPostVertList().get(1)[2] *eq[2] + eq[3];
    	//Vertice 3
    	double v3_eq = p2.getPostVertList().get(2)[0] *eq[0] + p2.getPostVertList().get(2)[1] *eq[1] + p2.getPostVertList().get(2)[2] *eq[2] + eq[3];
    	//Vertice 4
    	double v4_eq = p2.getPostVertList().get(3)[0] *eq[0] + p2.getPostVertList().get(3)[1] *eq[1] + p2.getPostVertList().get(3)[2] *eq[2] + eq[3];
    	
    	double observer = eq[3];
    	
       
	    //TEST 1 - depth overlap
    	if (z1_min>z2_max) {
    		return 1;
    	}
    	/*
    	//TEST 2 - XY overlap
    	else if (x1_max < x2_min || y1_max < y2_min) {
    		return 0;
    	}
    	*/
    	
    	//TEST 3 - check where polygon is in reference to the plane defined by other polygon
    	else if ((observer > 0 && (v1_eq>0 && v2_eq>0 && v3_eq>0 && v4_eq>0)) || (observer < 0 && (v1_eq<0 && v2_eq<0 && v3_eq<0 && v4_eq<0))){
    		return 0;
    	}
    	
    	//TEST 3 - check where polygon is in reference to the plane defined by other polygon
    	else if ((observer < 0 && (v1_eq>0 || v2_eq>0 || v3_eq>0 || v4_eq>0)) || (observer > 0 && (v1_eq<0 || v2_eq<0 || v3_eq<0 || v4_eq<0))){
    		return 1;
    	}
    	
    	
    	return 0;
    
    } 
}

