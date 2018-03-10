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
import java.util.Random;

/**
 *
 * @author Kuba
 */
public class Polygon {
    
    private float x_start;
    private float x_end;
    private float y_start;
    private float y_end;
    private float z_start;
    private float z_end;
    private String name;
    private int id;
    private boolean is_horizontal = false;
    private float first_color;
    private float second_color;
    private float third_color;
    
    
    /*possible walls orientation:
        1 - horizontal
        2 - vertical
        3 - parallel to viewport
    */
    
    private int position;
    
    public int getPosition() {
        if(x_start==x_end) {
            this.position = 2;
            return this.position;
        }
        else if (z_start==z_end) {
            this.position = 3;
            return this.position;
        }
        else this.position = 1;
        return this.position;
    }
    
    public float getX_start() {
        return x_start;
    }

    public void setX_start(float x_start) {
        this.x_start = x_start;
    }

    public float getX_end() {
        return x_end;
    }

    public void setX_end(float x_end) {
        this.x_end = x_end;
    }

    public float getY_start() {
        return y_start;
    }

    public void setY_start(float y_start) {
        this.y_start = y_start;
    }

    public float getY_end() {
        return y_end;
    }

    public void setY_end(float y_end) {
        this.y_end = y_end;
    }

    public float getZ_start() {
        return z_start;
    }

    public void setZ_start(float z_start) {
        this.z_start = z_start;
    }

    public float getZ_end() {
        return z_end;
    }

    public void setZ_end(float z_end) {
        this.z_end = z_end;
    }

    public boolean isIs_horizontal() {
        return is_horizontal;
    }

    public void setIs_horizontal(boolean is_horizontal) {
        this.is_horizontal = is_horizontal;
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

	public void setCoordinates(float x_start, float x_end, float y_start, float y_end, float z_start, float z_end) {
        this.x_start = x_start;
        this.x_end = x_end;
        this.y_start = y_start;
        this.y_end = y_end;
        this.z_start = z_start;
        this.z_end = z_end;
    }
    
    public void draw (GL2 gl, boolean is_final, float first_color, float second_color, float third_color) {
       
        gl.glBegin(GL2.GL_QUADS);
        
        gl.glColor3f(first_color, second_color, third_color ); 
        
        //Horizontal walls are being drawn in different way
        if(is_horizontal) {
            gl.glVertex3f( x_start,y_start,z_start );
            gl.glVertex3f( x_end,y_start,z_start );
            gl.glVertex3f( x_end,y_end,z_end );
            gl.glVertex3f( x_start,y_end,z_end ); 
        }
        else {
            gl.glVertex3f( x_start,y_start,z_start );
            gl.glVertex3f( x_end,y_start,z_end );
            gl.glVertex3f( x_end,y_end,z_end );
            gl.glVertex3f( x_start,y_end,z_start );
        }
        
        gl.glEnd();
    }
}
