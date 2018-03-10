/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;
import static com.jogamp.opengl.GL.GL_BLEND;
import static com.jogamp.opengl.GL.GL_ONE_MINUS_SRC_ALPHA;
import static com.jogamp.opengl.GL.GL_SRC_ALPHA;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.FloatBuffer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kuba
 */
public class PaintersAlgorithm  {
	public static double move_z = -50.0f;
    public static double move_x = 0.0f;
    public static double move_y = 0.0f;
    public static double move_y_rotate = 0.0f;
    public static double move_x_rotate = 0.0f;
    public static double move_z_rotate = 0.0f;
    public static double alpha = 0.0f;
    public static double theta = 0.0f;
    public static double phi = 0.0f;
    
    public static double alpha_saver = 0.0f;
    public static double theta_saver = 0.0f;
    public static double phi_saver = 0.0f;

    public static double phi_x = 0.0f;
    public static double phi_y = 0.0f;
    
    public static double theta_x = 0.0f;
    public static double theta_y = 0.0f;
    
    public static double xS = 1.0f;
    public static double yS = 1.0f;
    public static double zS = 1.0f;

    public static int phi_counter = 0;
    public static int theta_counter = 0;
    public static int alpha_counter = 0;
    
    public static double global_window_width = 0;
    public static double global_window_height = 0;
    public static double global_h = 0;
    public static int frame_width =1200;
    public static int frame_height = 800;
    
    public static String helperOutput; 
    
    public static JLabel valuesLabel = new JLabel();
    
    float width, height;
    float perspective = 10000.0f;
    float favy = 60.0f;
    
    JFrame f; 
    DrawingPanel p;
    JPanel psC; 
    JPanel ps;
    JButton fwd, bck, right, left, up, down; 
    JButton rot_up, rot_down, rot_left, rot_right, tilt_left, tilt_right, zoom_in, zoom_out;
   
    class DrawingPanel extends GLJPanel {
    	
    	GLU glu; 
    	
    	DrawingPanel() {
    		
    		super(new GLCapabilities(GLProfile.getDefault()));
    		
    		this.addGLEventListener(new GLEventListener() {
    			
    			public void init(GLAutoDrawable drawable)  {
    				GL2 gl = drawable.getGL().getGL2();
					glu = new GLU(); 
					
					gl.glClearColor(0.0f , 0.0f , 0.0f , 0.0f);
				}
    			
    			public void reshape(GLAutoDrawable drawable , int x , int y , int w , int h) {
					GL2 gl = drawable.getGL().getGL2();
					gl.glViewport(0 , 0 , w , h);
					gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
					gl.glLoadIdentity(); 
					width = w;
					height = h;
					
					//glu.gluPerspective(60.0f , (float) w / h , 1.0f , perspective);
				}

				public void display(GLAutoDrawable drawable) {
					GL2 gl = drawable.getGL().getGL2();
					
					
				       
					gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
					gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW); 
					gl.glLoadIdentity(); // Reset The View
					
					float[] mv;
					
					mv = new float[16];
					
					FloatBuffer buffer = null;
					
					gl.glGetFloatv(GLMatrixFunc.GL_MODELVIEW_MATRIX, buffer);
					
					mv = buffer.array();
					
					for (int i=0; i<mv.length; i ++) {
						System.out.println(mv[i]);
					}
					
					
					glu.gluPerspective(favy, (float) width / height, 1.0f, perspective);
					
			       move_x_rotate = move_x;
			       move_y_rotate = move_y;
			       move_z_rotate = move_z;
			       
			       if(alpha_counter==1) {
			    	   alpha_saver = alpha;
			    	   theta_counter = 0;
			    	   phi_counter = 0;
			       }
			       
			       gl.glTranslated( move_x, move_y,   move_z ); // Move the shape
			       
					/////////////////X AXIS ROTATION/////////////////////
					       
					gl.glTranslated( -move_x_rotate, -move_y_rotate,   -move_z_rotate ); // Move the shape
					
					gl.glRotated(-phi_x, 1.0f, 0, 0);
					
					gl.glRotated(-phi_y, 0, 1.0f, 0);
					
					gl.glRotated(-phi, 1.0f, 0, 0);
					
					gl.glRotated(phi_y, 0, 1.0f, 0);
					
					gl.glRotated(phi_x, 1.0f, 0, 0);
					
					gl.glTranslated( move_x_rotate, move_y_rotate,   move_z_rotate ); // Move the shape
			       
					/////////////Y AXIS ROTATION/////////////////////
					       
					 gl.glTranslated( -move_x_rotate, -move_y_rotate,   -move_z_rotate ); // Move the shape
					 
					 gl.glRotated(-theta_x, 1.0f, 0, 0);
					 
					 gl.glRotated(-theta_y, 0, 1.0f, 0);
					 
					 gl.glRotated(-theta, 1.0f, 0, 0);
					 
					 gl.glRotated(theta_y, 0, 1.0f, 0);
					 
					 gl.glRotated(theta_x, 1.0f, 0, 0);
					 
					 gl.glTranslated( move_x_rotate, move_y_rotate,   move_z_rotate ); // Move the shape
			       
			       ///////////Z AXIS ROTATION/////////////////////
			       
			       gl.glTranslated( -move_x_rotate, -move_y_rotate,   -move_z_rotate ); // Move the shape
			       
			       gl.glRotated(-alpha, 0, 0, 1.0f);
			       
			       gl.glTranslated( move_x_rotate, move_y_rotate,   move_z_rotate );
			       
			       
			       gl.glScaled(xS, yS, zS);
			       PolygonDrawer sp = new PolygonDrawer();
			       
			       //gl.glPopMatrix();
			       
			       sp.display(drawable);
			       
			       
			       
			       
			       gl.glFlush();
					
				}

				public void dispose(GLAutoDrawable drawable) {
					
				}
    			
    		});
    		
    	}
    	
    }
    
    PaintersAlgorithm() {
	           //getting the capabilities object of GL2 profile
	    	f = new JFrame(); f.setFocusable(true); f.setVisible(true);
			p = new DrawingPanel(); f.getContentPane().add(p , BorderLayout.CENTER);
			////------------------------ CAMERA
			psC = new JPanel(); psC.setLayout(new GridLayout(0 , 1));
			f.getContentPane().add(psC , BorderLayout.EAST);
	    	
	    	
			fwd = new JButton("Forward");
			bck = new JButton("Back");
			left = new JButton("Left");
			right = new JButton("Right");
			up = new JButton("Up");
			down = new JButton("Down");
			
			psC.add(fwd);
			psC.add(bck);
			psC.add(left);
			psC.add(right);
			psC.add(up);
			psC.add(down);
    	
      fwd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				float change = 2.0f;
	        	  double helper = 0;
	        	  
	        	  helper = Math.cos(Math.toRadians(phi))*change;
	        	  
	        	  move_z += Math.cos(Math.toRadians(theta))*helper;
	        	  
	        	  move_y -= Math.sin(Math.toRadians(phi))*change;

	        	  move_x += Math.sin(Math.toRadians(theta))*helper;
	        	  
	        	  f.repaint();
			}
    	  
      });
      
      bck.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				float change = 2.0f;
	        	  double helper = 0;
	        	  
	        	  helper = Math.cos(Math.toRadians(phi))*change;
	        	  
	        	  move_z -= Math.cos(Math.toRadians(theta))*helper;
	        	  
	        	  move_y += Math.sin(Math.toRadians(phi))*change;

	        	  move_x -= Math.sin(Math.toRadians(theta))*helper;
	        	  
	        	  f.repaint();
				
			}
  	  
    });
      
      right.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				float change = 2.0f;
	        	  
	        	  move_x -=(Math.cos(Math.toRadians(theta))*change);
	        	  move_z += (Math.sin(Math.toRadians(theta))*change);
	        	  //move_y+= (Math.sin(Math.toRadians(phi))*change);
	        	  
	        	  f.repaint();
				
			}
      	  
      });
      
      left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float change = 2.0f;
	        	  
	        	  move_x +=(Math.cos(Math.toRadians(theta))*change);
	        	  move_z -= (Math.sin(Math.toRadians(theta))*change);
	        	  //move_y+= (Math.sin(Math.toRadians(phi))*change);
	        	  
	        	  f.repaint();
			}
    	  
    });
      
      up.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				float change = 2.0f;
	          	  double helper = 0;
	
	          	  if(phi==0.0) {
	          		  move_y-= change;
	          	  }
	          	  else if (theta==0 && phi!=0.0) {
	          		  move_y-= (Math.cos(Math.toRadians(phi))*change);
	          		  move_z-= (Math.sin(Math.toRadians(phi))*change);
	          	  }
	          	  
	          	  else if(theta!=0 && phi != 0)  {
	          		  
	          		  helper = change*Math.cos(Math.toRadians(90-phi));
	          		  move_y += change*Math.sin(Math.toRadians(90-phi));
	
	              	  move_x += helper*Math.sin(Math.toRadians(theta));
	              	  
	              	  move_z += Math.cos(Math.toRadians(theta))*helper;
	          	  }
	          	  
	          	f.repaint();
				
			}
        	  
      });
      
      down.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			float change = 2.0f;
        	  double helper = 0;

        	  if(phi==0.0) {
        		  move_y+= change;
        	  }
        	  else if (theta==0 && phi!=0.0) {
        		  move_y+= (Math.cos(Math.toRadians(phi))*change);
        		  move_z+= (Math.sin(Math.toRadians(phi))*change);
        	  }
        	  
        	  else if(theta!=0 && phi != 0)  {
        		  
        		  helper = change*Math.cos(Math.toRadians(90-phi));
        		  move_y -= change*Math.sin(Math.toRadians(90-phi));

            	  move_x -= helper*Math.sin(Math.toRadians(theta));
            	  
            	  move_z -= Math.cos(Math.toRadians(theta))*helper;
        	  }
        	  
        	f.repaint();
			
		}
      	  
    });
      
      rot_up = new JButton("Rotate up");
      rot_down = new JButton("Rotate down");
      rot_left = new JButton("Rotate left");
      rot_right = new JButton("Rotate right");
      zoom_in = new JButton("Zoom in");
      zoom_out = new JButton("Zoom out");
      
      ps = new JPanel(); ps.setLayout(new GridLayout(0 , 1));
		f.getContentPane().add(ps , BorderLayout.WEST);
      
      ps.add(rot_up);
		ps.add(rot_down);
		ps.add(rot_left);
		ps.add(rot_right);
		ps.add(zoom_in);
		ps.add(zoom_out);
		
	  rot_up.addActionListener( new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			phi -= 2;
            phi_counter++;
            
            
            if(phi_counter==1) {
	           	   theta_saver=theta;
	           	   theta_counter = 0;
	           	   alpha_counter = 0;
            }

            f.repaint();
            //phi_x = attan(ccos(90-phi_saver)/ssin(90-phi_saver));
            //phi_y = attan(ssin(theta_saver)/ccos(theta_saver));
            
		}
		
	  });
	  
	  rot_down.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				phi += 2;
	              phi_counter++;
	              
	              
	              if(phi_counter==1) {
		           	   theta_saver=theta;
		           	   theta_counter = 0;
		           	   alpha_counter = 0;
	              }

	            f.repaint();
	            //phi_x = attan(ccos(90-phi_saver)/ssin(90-phi_saver));
	            //phi_y = attan(ssin(theta_saver)/ccos(theta_saver));
	            
			}
			
		  });
	  
	  rot_left.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theta+=2;
	        	  theta_counter++;
	        	  
	        	  if(theta_counter==1) {
		           	   phi_saver=phi;
		           	   phi_counter = 0;
		           	   alpha_counter = 0;
	              }
	        	  
	        	  theta_x = 90;
	              theta_y = 90;

	            f.repaint();
	            //phi_x = attan(ccos(90-phi_saver)/ssin(90-phi_saver));
	            //phi_y = attan(ssin(theta_saver)/ccos(theta_saver));
	            
			}
			
		  });
	  
	  rot_right.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theta-=2;
	        	  theta_counter++;
	        	  
	        	  if(theta_counter==1) {
		           	   phi_saver=phi;
		           	   phi_counter = 0;
		           	   alpha_counter = 0;
	              }
	        	  
	        	  theta_x = 90;
	        	  
	        	  //version with x rotation around current origins (but not working properly at the end)
	        	  //theta_x = 90-phi;
	        	  
	        	  
	              theta_y = 90;

	            f.repaint();
	            //phi_x = attan(ccos(90-phi_saver)/ssin(90-phi_saver));
	            //phi_y = attan(ssin(theta_saver)/ccos(theta_saver));
	            
			}
			
		  });
	  
	  zoom_in.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("TEST");
			favy+=5.0f;
			f.repaint();
		}
		  
	  });
	  
	  zoom_out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("TEST");
				favy-=5.0f;
				f.repaint();
			}
			  
		  });
		
		
      
      f.setSize(new Dimension(800 + 16 , 400 + 38));
      
    }

    public static double ssin(double degree) {
  	  return Math.sin(Math.toRadians(degree));
    }
    
    public static double ccos(double degree) {
    	  return Math.cos(Math.toRadians(degree));
      }
    
    public static double ttan(double degree) {
    	  return Math.tan(Math.toRadians(degree));
      }
    
    public static double attan(double value) {
  	  return Math.toDegrees(Math.atan(value));
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public static void refresh_label() {
    	String text = "<html>&nbsp&nbsp   theta_saver: " + round(theta_saver, 2) + "<br>&nbsp&nbsp    theta: " + theta 
           		+ "<br>&nbsp&nbsp&nbsp    phi_saver: " + round(phi_saver, 2) + "<br>&nbsp&nbsp phi: " + phi
           		+ "<br>&nbsp&nbsp alpha_saver: " + round(alpha_saver, 2) + "<br>&nbsp&nbsp alpha: " + alpha
           		+ "<br>&nbsp&nbsp phi_x: " + round(phi_x, 2) + "<br>&nbsp&nbsp phi_y: " + round(phi_y, 2)
           		+ "<br>&nbsp&nbsp theta_x: " + round(theta_x, 2) + "<br>&nbsp&nbsp theta_y: " + round(theta_y, 2);
    	valuesLabel.setText(text);
    }

}
