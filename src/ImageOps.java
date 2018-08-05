import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ImageOps {
	
	//This function returns a 25x25 image with a filled rectangle  at co-ordinates (5,5) of length 7 and width 5 pixels.  
	public static int[][] CreateImage1(){
		int width=25;
		int height=25;
		int pixels[][]=new int[width][height];
		BufferedImage buffimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=buffimg.createGraphics();
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(5,5,7,5);
		g2d.dispose();
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				pixels[i][j]=buffimg.getRGB(i,j);
			}
		}
		return pixels;
	}

	//This function returns a 25x25 image with a filled ellipse at co-ordinates (5,5) of length 10 and width 5 pixels.
	public static int[][] CreateImage2(){
		int width=25;
		int height=25;
		int pixels[][]=new int[width][height];
		BufferedImage buffimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=buffimg.createGraphics();
		g2d.setColor(Color.RED);
		g2d.fill(new Ellipse2D.Double(5,5,10,5));
		g2d.dispose();
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				pixels[i][j]=buffimg.getRGB(i,j);
			}
		}
		return pixels;
	}

	//This function returns a 25x25 image with an arc  at co-ordinates (5,5).	
	public static int[][] CreateImage3(){
		int width=25;
		int height=25;
		int pixels[][]=new int[width][height];
		BufferedImage buffimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=buffimg.createGraphics();
		g2d.setColor(Color.BLUE);
		g2d.fill(new Arc2D.Double(5, 5,10,5,90, 135,Arc2D.OPEN));
		g2d.dispose();
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				pixels[i][j]=buffimg.getRGB(i,j);
			}
		}
		return pixels;
	}
	
	//This function takes each 2D image array as an input and performs operations
	//such as display, translation,rotation and scaling. 
	public static int Operations(int[][] image){
		//Display
		JFrame frame=new JFrame();
		BufferedImage img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}
		ImageIcon icon=new ImageIcon(img);
		JLabel label=new JLabel(icon);
		frame.setTitle("original image");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}
		frame.dispose();
		
		//Translation -5 in x-direction
		frame=new JFrame();
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}		
		
		AffineTransform trans = new AffineTransform();
    		trans.translate(-5, 0);
    		AffineTransformOp op = new AffineTransformOp(trans,AffineTransformOp.TYPE_BILINEAR);
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("tanslate -5 in x direction");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();

		//Translation +7 in y direction
		frame=new JFrame();
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}

		trans = new AffineTransform();
		trans.translate(0,7);
    		op = new AffineTransformOp(trans,AffineTransformOp.TYPE_BILINEAR);
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("tanslate +7 in y direction");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();

		//Rotation -45 deg counter-clockwise
		frame=new JFrame();	
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}
        	trans = AffineTransform.getRotateInstance(-0.785398,img.getWidth()/2,img.getHeight()/2);
        	op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR); 
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("rotate 45 degress/0.785398 radians counter-clockwise");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();

		//Rotation 90 deg clockwise
		frame=new JFrame();	
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}
        	trans = AffineTransform.getRotateInstance(1.5708,img.getWidth()/2,img.getHeight()/2);
        	op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR); 
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("rotate 90 degress/1.5708 radians counter-clockwise");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();

		//Scaling by 2 in x direction
		frame=new JFrame();	
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}
        	trans = new AffineTransform();
		trans.scale(2,1);
        	op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR); 
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("scale twice in x direction");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();

		//Scaling by 0.5 in y-direction
		frame=new JFrame();	
		img= new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				img.setRGB(i,j,image[i][j]);
			}
		}
        	trans = new AffineTransform();
		trans.scale(1,0.5);
        	op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR); 
    		img = op.filter(img, null);
		icon=new ImageIcon(img);
		label=new JLabel(icon);
		frame.setTitle("scale 0.5 times in y direction");
		frame.add(label);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		try        
		{
    			Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}		
		frame.dispose();
		
		return 1;
	}
	
	public static void main(String[] args){
		//Images are stored in separate 2D arrays and passed to Operations() 
		//for display and other operations
		int[][] image1=CreateImage1();
		int[][] image2=CreateImage2();
		int[][] image3=CreateImage3();
		Operations(image1);
		Operations(image2);
		Operations(image3);
				
	}
}
