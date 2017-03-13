package org.jogl;

import java.net.URL;

import javax.swing.JFrame;

import org.jogl.config.AppContext;
import org.jogl.dem.draw.FrameWindow;
import org.jogl.dem.file.FileReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

public class Application{
	
	public static void main(String[] args) {
		 
		// init Spring Application Context
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		// getting the capabilities object of GL2 profile
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The GLJpanel class
		GLJPanel gljpanel = new GLJPanel(capabilities);
		FrameWindow frameWindow = (FrameWindow) context.getBean("beanFrameWindow");
		gljpanel.addGLEventListener(frameWindow);
		gljpanel.setSize(400, 400);
		
		// File Bean 
		URL url = URL.class.getResource("/data/Ecrins2.xyz");
		FileReader file = (FileReader) context.getBean("beanFile");
		file.readFile(url.getPath());
		
		// creating frame
		final JFrame frame = new JFrame();

		// adding canvas to it
		frame.getContentPane().add(gljpanel);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setSize(500, 500);
		frame.setVisible(true);
		final FPSAnimator animator = new FPSAnimator(gljpanel, 300, true);
	    animator.start();
	}
}