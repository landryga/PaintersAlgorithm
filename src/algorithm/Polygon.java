/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import com.jogamp.opengl.GL2;



import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Kuba
 */
public class Polygon {
    
    double[] vertice1;
    double[] vertice2;
    double[] vertice3;
    double[] vertice4;
    
    public double[] vertice1_postCoordinates;
	public double[] vertice2_postCoordinates;
    public double[] vertice3_postCoordinates;
    public double[] vertice4_postCoordinates;
    
    
    private String name;
    private int id;
    private boolean is_horizontal = false;
    private float first_color;
    private float second_color;
    private float third_color;
    
    
    
    public List<double[]> getPostVertList() {
    	List<double[]> vertList = new ArrayList();
    	
    	vertice1_postCoordinates = calculateCoords(vertice1, PaintersAlgorithm.modelMatrix);
    	vertice2_postCoordinates = calculateCoords(vertice2, PaintersAlgorithm.modelMatrix);
    	vertice3_postCoordinates = calculateCoords(vertice3, PaintersAlgorithm.modelMatrix);
    	vertice4_postCoordinates = calculateCoords(vertice4, PaintersAlgorithm.modelMatrix);
    	
    	vertList.add(vertice1_postCoordinates);
    	vertList.add(vertice2_postCoordinates);
    	vertList.add(vertice3_postCoordinates);
    	vertList.add(vertice4_postCoordinates);
    	
    	return vertList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setColors(float first, float second, float third) {
    	this.first_color=first;
    	this.second_color = second;
    	this.third_color = third;
    }
    
    public float getFirst_color() {
		return first_color;
	}

	public float getSecond_color() {
		return second_color;
	}

	public float getThird_color() {
		return third_color;
	}

	public void setCoordinates(List<double[]> listOfCoords) {
		
		this.vertice1 = new double[3];
		this.vertice2 = new double[3];
		this.vertice3 = new double[3];
		this.vertice4 = new double[3];
		
        this.vertice1 = listOfCoords.get(0);
        this.vertice2 = listOfCoords.get(1);
        this.vertice3 = listOfCoords.get(2);
        this.vertice4 = listOfCoords.get(3);
        
    }
	
	public double[] getVertice1_postCoordinates() {
		return calculateCoords(vertice1, PaintersAlgorithm.modelMatrix);
	}

	public void setVertice1_postCoordinates(double[] vertice1_postCoordinates) {
		this.vertice1_postCoordinates = vertice1_postCoordinates;
	}

	public double[] getVertice2_postCoordinates() {
		return calculateCoords(vertice2, PaintersAlgorithm.modelMatrix);
	}

	public void setVertice2_postCoordinates(double[] vertice2_postCoordinates) {
		this.vertice2_postCoordinates = vertice2_postCoordinates;
	}

	public double[] getVertice3_postCoordinates() {
		return calculateCoords(vertice3, PaintersAlgorithm.modelMatrix);
	}

	public void setVertice3_postCoordinates(double[] vertice3_postCoordinates) {
		this.vertice3_postCoordinates = vertice3_postCoordinates;
	}

	public double[] getVertice4_postCoordinates() {
		return calculateCoords(vertice4, PaintersAlgorithm.modelMatrix);
	}

	public void setVertice4_postCoordinates(double[] vertice4_postCoordinates) {
		this.vertice4_postCoordinates = vertice4_postCoordinates;
	}
	
	public double getXmin() {
		
		List<double[]> helper = this.getPostVertList();
		
		double xMin = helper.get(0)[0];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[0] < xMin)
				xMin = helper.get(i)[0];
		}
		
		return xMin;
		
	}
	
	public double getXmax() {
		List<double[]> helper = this.getPostVertList();
		
		double xMax = helper.get(0)[0];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[0] > xMax)
				xMax = helper.get(i)[0];
		}
		
		return xMax;
	}
	
	public double getYmin() {
		
		List<double[]> helper = this.getPostVertList();
		
		double yMin = helper.get(0)[1];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[1] < yMin)
				yMin = helper.get(i)[1];
		}
		
		return yMin;
		
	}
	
	public double getYmax() {
		List<double[]> helper = this.getPostVertList();
		
		double yMax = helper.get(0)[1];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[1] > yMax)
				yMax = helper.get(i)[1];
		}
		
		return yMax;
	}
	
	public double getZmin() {
		
		List<double[]> helper = this.getPostVertList();
		
		double zMin = helper.get(0)[2];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[2] < zMin)
				zMin = helper.get(i)[2];
		}
		
		return zMin;
		
	}
	
	public double getZmax() {
		List<double[]> helper = this.getPostVertList();
		
		double zMax = helper.get(0)[2];
		
		for(int i = 0; i < helper.size(); i++) {
			if(helper.get(i)[2] > zMax)
				zMax = helper.get(i)[2];
		}
		
		return zMax;
	}
	
	public double[] getPlaneEquation() {
		
		//get 3 verices coordinates
		double v1_x = this.getVertice1_postCoordinates()[0] ;
		double v1_y = this.getVertice1_postCoordinates()[1] ;
		double v1_z = this.getVertice1_postCoordinates()[2] ;
		
		double v2_x = this.getVertice2_postCoordinates()[0] ;
		double v2_y = this.getVertice2_postCoordinates()[1] ;
		double v2_z = this.getVertice2_postCoordinates()[2] ;
		
		double v3_x = this.getVertice2_postCoordinates()[0] ;
		double v3_y = this.getVertice2_postCoordinates()[1] ;
		double v3_z = this.getVertice2_postCoordinates()[2] ;
		
		
		double A = v1_y*v2_z + v2_y*v3_z + v3_y*v1_z - (v2_z*v3_y + v3_z*v1_y + v1_z*v2_y);
		double B = v1_x*v2_z + v2_x*v3_z + v3_x*v1_z - (v2_z*v3_x + v3_z*v1_x + v1_z*v2_x);
		double C = v1_x*v2_y + v2_x*v3_y + v3_x*v1_y - (v2_y*v3_x + v3_y*v1_x + v1_y*v2_x);
		double D = v1_x*v2_y*v3_z + v2_x*v3_y*v1_z + v3_x*v1_y*v2_z - (v1_z*v2_y*v3_x + v2_z*v3_y*v1_x+v3_z*v1_y*v2_x);
		
		double[] eq = {A, B, C, D};
		
		return eq;
		
	}
	
	
	
	

	private static double[] calculateCoords(double[] original_coord, double[] modelMatrix1) {
		double out_coord[];
		out_coord = new double[3];
		
		
		double xp = modelMatrix1[0] * original_coord[0] + modelMatrix1[4] * original_coord[1] + modelMatrix1[8] * original_coord[2] + modelMatrix1[12];
		double yp = modelMatrix1[1] * original_coord[0] + modelMatrix1[5] * original_coord[1] + modelMatrix1[9] * original_coord[2] + modelMatrix1[13];
		double zp = modelMatrix1[2] * original_coord[0] + modelMatrix1[6] * original_coord[1] + modelMatrix1[10] * original_coord[2] + modelMatrix1[14];
		double wp = modelMatrix1[3] * original_coord[0] + modelMatrix1[7] * original_coord[1] + modelMatrix1[11] * original_coord[2] + modelMatrix1[15];
		
		xp/=wp;
		yp/=wp;
		zp/=wp;
		
		out_coord[0] = xp;
		out_coord[1] = yp;
		out_coord[2] = zp;
		
		return out_coord;
		
	}
    
    public void draw (GL2 gl, boolean is_final, float first_color, float second_color, float third_color) {
       
        gl.glBegin(GL2.GL_QUADS);
        
        gl.glColor3d(first_color, second_color, third_color ); 
        
        gl.glVertex3d( this.vertice1[0], this.vertice1[1], this.vertice1[2] );
        gl.glVertex3d( this.vertice2[0], this.vertice2[1], this.vertice2[2] );
        gl.glVertex3d( this.vertice3[0], this.vertice3[1], this.vertice3[2] );
        gl.glVertex3d( this.vertice4[0], this.vertice4[1], this.vertice4[2] );
        
        gl.glEnd();
    }
}
