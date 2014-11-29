package mvc.view;

import java.io.File;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Dimension;
//import mvc.controlador.OnImageUIEvent;

public class ImageUI extends JInternalFrame
{
	private static final int xOffset = 30, yOffset = 30;
	private BufferedImage image;
	private File file;
	private ImageManager manager;
	static int openFrameCount = 0;
	
	public ImageUI(BufferedImage image) 
		{
		super("New Image" + (++openFrameCount), 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        manager = ImageManager.getInstance();
		this.image = image;
				
		int width = image.getWidth();
		int height =image.getHeight();
		if (width>500) width=300;
		if (height>500) height=300;
		setSize(width+15,height+35);
        setLocation(xOffset*openFrameCount, yOffset);
        
        JScrollPane panel = new JScrollPane(new ImagePanel(this.image));
			panel.setPreferredSize(new Dimension(width,height));			
        setContentPane(panel);
				
		//addInternalFrameListener(new OnImageUIEvent());
        setVisible(true);
		}
		
	public ImageUI (File file) 
		{
		super(file.getName(), 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        this.file = file;
        manager = ImageManager.getInstance();
		image = manager.loadImage(file);
		int width = image.getWidth();
		int height =image.getHeight();
		if (width>500) width=300;
		if (height>450) height=300;
		setSize(width+15,height+35);
        setLocation(xOffset*openFrameCount, yOffset);
        
        JScrollPane panel = new JScrollPane(new ImagePanel(this.image));
			panel.setPreferredSize(new Dimension(width,height));			
        setContentPane(panel);
        //addInternalFrameListener(new OnImageUIEvent());
        setVisible(true);
		}	
		
	public void activated ()
		{
			manager.select(image);
		}
	
	public BufferedImage getImage()
		{
		return image;
		}		
}

class ImagePanel extends JLabel
{
	BufferedImage image;
	
	public ImagePanel (BufferedImage image)
		{
			super("");
			this.image = image;
			setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
			setAutoscrolls(true);
		}
	
	public void paintComponent (Graphics g)
		{
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);			
		}
}
