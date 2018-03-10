/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import algorithm.PolygonComparator;

/**
 *
 * @author Kuba
 */
public class PolygonDrawer implements GLEventListener, ActionListener{

   
    @Override
    public void init(GLAutoDrawable drawable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable drawable) {
         final GL2 gl = drawable.getGL().getGL2();
        
        //unit vector
        float x = 1.0f;
        float y = 1.0f;
        float z = 1.0f;
        
        List<Polygon> squareList = new ArrayList<Polygon>();
      
        //-------------------First Cube start------------------------------------
        Polygon dr1 = new Polygon();
        
        dr1.setName("first_far");
        dr1.setCoordinates(-x, x, -y, y, -3*z, -3*z);
        dr1.setColors(1, 0, 0);
        System.out.println(dr1.getX_end());
        
        //draw second square
        Polygon dr2 = new Polygon();
        
        dr2.setName("first_near");
        dr2.setCoordinates(-x, x, -y, y, 3*z, 3*z);
        dr2.setColors(0, 1,0 );
        
        //draw left square
        Polygon dr3 = new Polygon();
        dr3.setName("first_left");
        dr3.setCoordinates(-x, -x, y, -y, -3*z, 3*z);
        dr3.setColors(0, 0, 1 );
        
        //draw upper square
        Polygon dr4 = new Polygon();
        
        dr4.setName("first_upper");
        dr4.setCoordinates(x, -x, y, y, -3*z, 3*z);
        dr4.setIs_horizontal(true);
        dr4.setColors(1,1,0);
        
        //draw right square
        Polygon dr5 = new Polygon();
        
        dr5.setName("first_right");
        dr5.setCoordinates(x, x, y, -y, 3*z, -3*z);
        dr5.setColors(0,1,1);
        
        //draw bottom square
        Polygon dr6 = new Polygon();
        
        dr6.setName("first_bottom");
        dr6.setCoordinates(x, -x, -y, -y, 3*z, -3*z);
        dr6.setIs_horizontal(true);
        dr6.setColors(1,1,1);
        
        //------------------------------Second Cube start--------------------------------
        Polygon dr7 = new Polygon();
        
        dr7.setName("second far");
        dr7.setCoordinates((float)1.5*x, (float)3.5*x, -y, y, z, z);
        dr7.setColors(0,(float) 0.5,0);
        
        //draw second square
        Polygon dr8 = new Polygon();
        
        dr8.setName("second near");
        dr8.setCoordinates((float)1.5*x, (float)3.5*x, -y, y, 4*z, 4*z);
        dr8.setColors((float) 0.5,0,0);
        
        //draw left square
        Polygon dr9 = new Polygon();
        
        dr9.setName("second left");
        dr9.setCoordinates((float)1.5*x, (float)1.5*x, -y, y, z, 4*z);
        dr9.setColors(0,0,(float) 0.5);
        
        //draw upper square
        Polygon dr10 = new Polygon();
        
        dr10.setName("second upper");
        dr10.setCoordinates((float)1.5*x, (float)3.5*x, y, y, z, 4*z);
        dr10.setIs_horizontal(true);
        dr10.setColors(0,(float) 0.5,0);
        
        //draw right square
        Polygon dr11 = new Polygon();
        
        dr11.setName("second right");
        dr11.setCoordinates((float)3.5*x, (float)3.5*x, -y, y, z, 4*z);
        dr11.setColors(1,(float) 0.5,1);
        
        //draw bottom square
        Polygon dr12 = new Polygon();
        
        dr12.setName("second bottom");
        dr12.setCoordinates((float)1.5*x, (float)3.5*x, -y, -y, z, 4*z);
        dr12.setIs_horizontal(true);
        dr12.setColors(0,(float) 0.5,1);
        
        //-----------------------------Cube 3 start--------------------------------
        Polygon dr13 = new Polygon();
        
        dr13.setName("third far");
        dr13.setCoordinates((float)2.5*x, (float)4*x, -y, (float)0.5*y, (float)(-2.5*z), (float)(-2.5*z));
        dr13.setColors(1,(float) 0.5,0);
        
        //draw second square
        Polygon dr14 = new Polygon();
        
        dr14.setName("third near");
        dr14.setCoordinates((float)2.5*x, (float)4*x, -y, (float)0.5*y, (float)(-1.5*z), (float)(-1.5*z));
        dr14.setColors((float)0.5,(float)0.5,(float)0.5);
        
        //draw left square
        Polygon dr15 = new Polygon();
        
        dr15.setName("third left");
        dr15.setCoordinates((float)2.5*x, (float)2.5*x, -y, (float)0.5*y, (float)(-1.5*z), (float)(-2.5*z));
        dr15.setColors(1,1,(float)0.5);
        
        //draw upper square
        Polygon dr16 = new Polygon();
        
        dr16.setName("third upper");
        dr16.setCoordinates((float)2.5*x, (float)4*x, (float)0.5*y, (float)0.5*y, (float)(-1.5*z), (float)(-2.5*z));
        dr16.setIs_horizontal(true);
        dr16.setColors((float)0.5,1,1);
        
        //draw right square
        Polygon dr17 = new Polygon();
        
        dr17.setName("third right");
        dr17.setCoordinates((float)4*x, (float)4*x, -y, (float)0.5*y, (float)(-1.5*z), (float)(-2.5*z));
        dr17.setColors((float)0.5,1,(float)0.5);
        
        //draw bottom square
        Polygon dr18 = new Polygon();
        
        dr18.setName("third bottom");
        dr18.setCoordinates((float)2.5*x, (float)4*x, -y, -y, (float)(-1.5*z), (float)(-2.5*z));
        dr18.setIs_horizontal(true);
        dr18.setColors(0,0,0);
        
        //add all Wall object to list for sorting purposes
        squareList.add(dr1);
        squareList.add(dr2);
        squareList.add(dr3);
        squareList.add(dr4);
        squareList.add(dr5);
        squareList.add(dr6);
        squareList.add(dr7);
        squareList.add(dr8);
        squareList.add(dr9);
        squareList.add(dr10);
        squareList.add(dr11);
        squareList.add(dr12);
        squareList.add(dr13);
        squareList.add(dr14);
        squareList.add(dr15);
        squareList.add(dr16);
        squareList.add(dr17);
        squareList.add(dr18);
        
        PolygonComparator comparator = new PolygonComparator();
        
        //Create list that stores indexes of walls. For sorting purposes
        PolygonMaintainter mntn = new PolygonMaintainter();
        List <Integer> finalSquaresList; 
        
        finalSquaresList = mntn.squaresCompare(squareList);
        
        for(int i = 0; i<finalSquaresList.size(); i++ ) {
            int k = finalSquaresList.get(i);
            Polygon dr = squareList.get(k);
            dr.draw(gl, true, dr.getFirst_color(), dr.getSecond_color(), dr.getThird_color());
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
