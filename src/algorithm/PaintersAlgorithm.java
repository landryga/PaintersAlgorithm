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
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kuba
 */
public class PaintersAlgorithm implements GLEventListener, ActionListener {
    private final GLU glu = new GLU();
    public static float move_z = -10.0f;
    public static float move_x = -5.5f;
    public static float move_y = -2.0f;
    public static float move_y_rotate = 0.0f;
    public static float move_x_rotate = 0.0f;
    public static float move_z_rotate = 0.0f;
    public static float alpha = 0.0f;
    public static float theta = 0.0f;
    public static float phi = 0.0f;
    public static int x1 = -10;
    public static int oldX; 
    public static int y1 = -10;
    public static int oldY; 
    
    public static float xS = 1.0f;
    public static float yS = 1.0f;
    public static float zS = 1.0f;
    //public static int oldY; 
    
    public static float x = 1.0f;
    public static  float y = 1.0f;
    public static  float z = 1.0f;
    

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        gl.glEnable(GL_BLEND);
        gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       final GL2 gl = drawable.getGL().getGL2();
       
       gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
       gl.glLoadIdentity(); // Reset The View
       gl.glTranslatef( move_x, move_y,   move_z ); // Move the shape
       move_y_rotate = move_y;
       move_x_rotate = move_x;
       move_z_rotate = move_z;
       gl.glTranslatef( -move_x_rotate, -move_y_rotate,   -move_z_rotate ); // Move the shape
       gl.glRotatef(-theta, 0, 1.0f, 0);
       gl.glRotatef(-phi, 1.0f, 0, 0);
       gl.glRotatef(-alpha, 0, 0, 1.0f);
       gl.glTranslatef( move_x_rotate, move_y_rotate,   move_z_rotate ); // Move the shape
       
       
       
       //gl.glTranslatef(0, 0, theta*15);
       //glu.gluLookAt(eyeX, eyeY, eyeZ, cos(theta), sin(phi), pickObjZ, 0,1,0);
       gl.glScalef(xS, yS, zS);
       WallDrawer sp = new WallDrawer();
       
       sp.display(drawable);
       
       
       gl.glEnd();
       gl.glFlush();
       
       //rtt += 0.01f;
       
            
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
       GL2 gl = drawable.getGL().getGL2();
       
       if(height <=0)
           height = 1;
       final float h = ( float ) width/ ( float ) height;
       gl.glViewport(0, 0, width, height );
       gl.glMatrixMode( GL2.GL_PROJECTION );
       gl.glLoadIdentity();
		
       glu.gluPerspective( 45.0f, h, 1.0f, 300.0f );
       gl.glMatrixMode( GL2.GL_MODELVIEW );
       float[] anarrayp;
       anarrayp = new float[1000];
       //gl.glGetFloatv(GL2.GL_MODELVIEW, anarrayp);
       gl.glLoadIdentity();
       
    }
    
    public static void main(String[] args) {
         //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities(profile);
          
      // The canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      PaintersAlgorithm lines3d = new PaintersAlgorithm();
      glcanvas.addGLEventListener( lines3d );
      glcanvas.setSize( 1000, 750  );
      
      
      
      //creating fram
      final JFrame frame = new JFrame("3d graphics)");
      frame.setSize(1200,800);
      final JPanel mainpanel = new JPanel (new BorderLayout());
      final JPanel buttonpanel = new JPanel();
      final JPanel canvaspanel = new JPanel();
      
      JButton FWDbutton = new JButton("Move forward");
      JButton BCKbutton = new JButton("Move backward");
      JButton LEFTbutton = new JButton("Move right");
      JButton RIGHTbutton = new JButton("Move left");
      JButton UPbutton = new JButton("Move Down");
      JButton Downbutton = new JButton("Move up");
      

      FWDbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              move_z+= 2.0f;
          }
      });
      
      BCKbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              move_z-= 2.0f;
          }
      });
      
      LEFTbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              move_x-= 0.5f;
          }
      });
      
      RIGHTbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              move_x+= 0.5f;
          }
      });
      
      UPbutton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              move_y+= 0.5f;
          }
      });
      
      Downbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              move_y-= 0.5f;
          }
      });
      
      
      
      
      buttonpanel.add(FWDbutton);
      buttonpanel.add(BCKbutton);
      buttonpanel.add(LEFTbutton);
      buttonpanel.add(RIGHTbutton);
      buttonpanel.add(UPbutton);
      buttonpanel.add(Downbutton);
      
      mainpanel.add(buttonpanel, BorderLayout.NORTH);
              
              
      canvaspanel.add(glcanvas);
      mainpanel.add(canvaspanel, BorderLayout.SOUTH);
      
      frame.getContentPane().add(mainpanel);

      frame.setVisible( true );
      
      final FPSAnimator animator = new FPSAnimator(glcanvas,1,false);
      animator.setFPS(1);
      animator.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
