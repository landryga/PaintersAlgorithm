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
        
        
        //draw second square
        Polygon dr1 = new Polygon();
        
        dr1.setName("first_near");
        
        List CCords1 = new ArrayList();
        CCords1.add(new double[] {-x, y, 3*z});
        CCords1.add(new double[] {x, y, 3*z});
        CCords1.add(new double[] {x, -y, 3*z});
        CCords1.add(new double[] {-x, -y, 3*z});
        
        dr1.setCoordinates(CCords1);
        
        dr1.setColors(0, 1,0 );
        
        Polygon dr2 = new Polygon();
        
        dr2.setName("first_far");
        
        List CCords2 = new ArrayList();
        CCords2.add(new double[] {-x, y, -3*z});
        CCords2.add(new double[] {x, y, -3*z});
        CCords2.add(new double[] {x, -y, -3*z});
        CCords2.add(new double[] {-x, -y, -3*z});
        
        dr2.setCoordinates(CCords2);
        
        dr2.setColors(1, 0, 0);
        
        //draw left square
        Polygon dr3 = new Polygon();
        dr3.setName("first_left");
        
        List CCords3 = new ArrayList();
        CCords3.add(new double[] {-x, y, -3*z});
        CCords3.add(new double[] {-x, y, 3*z});
        CCords3.add(new double[] {-x, -y, 3*z});
        CCords3.add(new double[] {-x, -y, -3*z});
        
        dr3.setCoordinates(CCords3);
        
        dr3.setColors(0, 0, 1 );
        
        //draw upper square
        Polygon dr4 = new Polygon();
        
        dr4.setName("first_upper");
        List CCords4 = new ArrayList();
        CCords4.add(new double[] {-x, y, -3*z});
        CCords4.add(new double[] {x, y, -3*z});
        CCords4.add(new double[] {x, y, 3*z});
        CCords4.add(new double[] {-x, y, 3*z});
        
        dr4.setCoordinates(CCords4);
        
        dr4.setColors(1,1,0);
        
        //draw right square
        Polygon dr5 = new Polygon();
        
        dr5.setName("first_right");
        List CCords5 = new ArrayList();
        CCords5.add(new double[] {x, y, -3*z});
        CCords5.add(new double[] {x, -y, -3*z});
        CCords5.add(new double[] {x, -y, 3*z});
        CCords5.add(new double[] {x, y, 3*z});
        
        dr5.setCoordinates(CCords5);
        dr5.setColors(0,1,1);
        
        //draw bottom square
        Polygon dr6 = new Polygon();
        
        dr6.setName("first_bottom");
        List CCords6 = new ArrayList();
        CCords6.add(new double[] {-x, -y, -3*z});
        CCords6.add(new double[] {x, -y, -3*z});
        CCords6.add(new double[] {x, -y, 3*z});
        CCords6.add(new double[] {-x, -y, 3*z});
        
        dr6.setCoordinates(CCords6);
        dr6.setColors(1,1,1);
        
        //------------------------------Second Cube start--------------------------------
        Polygon dr7 = new Polygon();
        
        dr7.setName("second near");
        
        List CCords7 = new ArrayList();
        CCords7.add(new double[] {(double) (1.5*x), y, 4*z});
        CCords7.add(new double[] {(double) (3.5*x), y, 4*z});
        CCords7.add(new double[] {(double) (3.5*x), -y, 4*z});
        CCords7.add(new double[] {(double) (1.5*x), -y, 4*z});
        
        dr7.setCoordinates(CCords7);
        
        dr7.setColors(0,(float) 0.5,0);
        
        //draw second square
        Polygon dr8 = new Polygon();
        
        dr8.setName("second far");
        
        List CCords8 = new ArrayList();
        CCords8.add(new double[] {(double) (1.5*x), y, 1.5*z});
        CCords8.add(new double[] {(double) (3.5*x), y, 1.5*z});
        CCords8.add(new double[] {(double) (3.5*x), -y, 1.5*z});
        CCords8.add(new double[] {(double) (1.5*x), -y, 1.5*z});
        
        dr8.setCoordinates(CCords8);
        
        dr8.setColors((float) 0.5,0,0);
        
        //draw left square
        Polygon dr9 = new Polygon();
        
        dr9.setName("second left");
        
        List CCords9 = new ArrayList();
        CCords9.add(new double[] {(double) (1.5*x), y, 1.5*z});
        CCords9.add(new double[] {(double) (1.5*x), y, 4*z});
        CCords9.add(new double[] {(double) (1.5*x), -y, 4*z});
        CCords9.add(new double[] {(double) (1.5*x), -y, 1.5*z});
        
        dr9.setCoordinates(CCords9);
        
        dr9.setColors(0,0,(float) 0.5);
        
        //draw upper square
        Polygon dr10 = new Polygon();
        
        dr10.setName("second upper");

        List CCords10 = new ArrayList();
        CCords10.add(new double[] {(double) (1.5*x), y, 1.5*z});
        CCords10.add(new double[] {(double) (1.5*x), y, 4*z});
        CCords10.add(new double[] {(double) (3.5*x), y, 4*z});
        CCords10.add(new double[] {(double) (3.5*x), y, 1.5*z});
        
        dr10.setCoordinates(CCords10);

        dr10.setColors(0,(float) 0.5,0);
        
        //draw right square
        Polygon dr11 = new Polygon();
        
        dr11.setName("second right");

        List CCords11 = new ArrayList();
        CCords11.add(new double[] {(double) (3.5*x), y, 1.5*z});
        CCords11.add(new double[] {(double) (3.5*x), y, 4*z});
        CCords11.add(new double[] {(double) (3.5*x), -y, 4*z});
        CCords11.add(new double[] {(double) (3.5*x), -y, 1.5*z});
        
        dr11.setCoordinates(CCords11);

        dr11.setColors(1,(float) 0.5,1);
        
        //draw bottom square
        Polygon dr12 = new Polygon();
        
        dr12.setName("second bottom");

        List CCords12 = new ArrayList();
        CCords12.add(new double[] {(double) (1.5*x), -y, 1.5*z});
        CCords12.add(new double[] {(double) (1.5*x), -y, 4*z});
        CCords12.add(new double[] {(double) (3.5*x), -y, 4*z});
        CCords12.add(new double[] {(double) (3.5*x), -y, 1.5*z});
        
        dr12.setCoordinates(CCords12);

        dr12.setColors(0,(float) 0.5,1);
        
        //-----------------------------Cube 3 start--------------------------------
        Polygon dr13 = new Polygon();
        
        dr13.setName("third far");
        
        List CCords13 = new ArrayList();
        CCords13.add(new double[] {(double) (2.5*x), y, -1.5*z});
        CCords13.add(new double[] {(double) (4*x), y, -1.5*z});
        CCords13.add(new double[] {(double) (4*x), -y, -1.5*z});
        CCords13.add(new double[] {(double) (2.5*x), -y, -1.5*z});
        
        dr13.setCoordinates(CCords13);
        
        dr13.setColors(1,(float) 0.5,0);
        
        //draw second square
        Polygon dr14 = new Polygon();
        
        dr14.setName("third near");
        
        List CCords14 = new ArrayList();
        CCords14.add(new double[] {(double) (2.5*x), y, -2.5*z});
        CCords14.add(new double[] {(double) (4*x), y, -2.5*z});
        CCords14.add(new double[] {(double) (4*x), -y, -2.5*z});
        CCords14.add(new double[] {(double) (2.5*x), -y, -2.5*z});
        
        dr14.setCoordinates(CCords14);
        
        dr14.setColors((float)0.5,(float)0.5,(float)0.5);
        
        //draw left square
        Polygon dr15 = new Polygon();
        
        dr15.setName("third left");
        
        List CCords15 = new ArrayList();
        CCords15.add(new double[] {(double) (2.5*x), y, -2.5*z});
        CCords15.add(new double[] {(double) (2.5*x), -y, -2.5*z});
        CCords15.add(new double[] {(double) (2.5*x), -y, -1.5*z});
        CCords15.add(new double[] {(double) (2.5*x), y, -1.5*z});
        
        dr15.setCoordinates(CCords15);
        
        dr15.setColors(1,1,(float)0.5);
        
        //draw upper square
        Polygon dr16 = new Polygon();
        
        dr16.setName("third upper");
        
        List CCords16 = new ArrayList();
        CCords16.add(new double[] {(double) (2.5*x), y, -1.5*z});
        CCords16.add(new double[] {(double) (4*x), y, -1.5*z});
        CCords16.add(new double[] {(double) (4*x), y, -2.5*z});
        CCords16.add(new double[] {(double) (2.5*x), y, -2.5*z});
        
        dr16.setCoordinates(CCords16);
        dr16.setColors((float)0.5,1,1);
        
        //draw right square
        Polygon dr17 = new Polygon();
        
        dr17.setName("third right");
        
        List CCords17 = new ArrayList();
        CCords17.add(new double[] {(double) (4*x), y, -2.5*z});
        CCords17.add(new double[] {(double) (4*x), y, -1.5*z});
        CCords17.add(new double[] {(double) (4*x), -y, -1.5*z});
        CCords17.add(new double[] {(double) (4*x), -y, -2.5*z});
        
        dr17.setCoordinates(CCords17);
        
        dr17.setColors((float)0.5,1,(float)0.5);
        
        //draw bottom square
        Polygon dr18 = new Polygon();
        
        dr18.setName("third bottom");
        
        List CCords18 = new ArrayList();
        CCords18.add(new double[] {(double) (2.5*x), -y, -1.5*z});
        CCords18.add(new double[] {(double) (4*x), -y, -1.5*z});
        CCords18.add(new double[] {(double) (4*x), -y, -2.5*z});
        CCords18.add(new double[] {(double) (2.5*x), -y, -2.5*z});
        
        dr18.setCoordinates(CCords18);
        
        dr18.setColors(0,1,0);
        
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
        List <Polygon> finalSquaresList; 
        
        finalSquaresList = mntn.squaresCompare(squareList);
        
        for(int i = 0; i<finalSquaresList.size(); i++ ) {
            Polygon dr = finalSquaresList.get(i);
            
            System.out.println("Polygon " + dr.getName() + ", zMax = " + dr.getZmax() + ", zMin = " + dr.getZmin() );
            
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
