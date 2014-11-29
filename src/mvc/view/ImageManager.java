package mvc.view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageManager 
{
	private static ImageManager instance;
	private BufferedImage image; // imagen seleccionada
	
	protected ImageManager ()
		{
		
		}
	
	public static ImageManager getInstance()
		{
		if (instance==null) instance = new ImageManager ();
		return instance;
		}
	
	public void select (BufferedImage image)
		{
		this.image = image;
		}
	
	public BufferedImage get ()
		{
		return image;
		}
	
	public File open ()
	{
		//Como subir una imagen al servidor
		File file = new File("images/lena250x250.jpg");        
        return file;
	}
	
	public File[] multiOpen ()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		chooser.setCurrentDirectory(new File("images/pdi"));
		File file[] = null;
		
		int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) 
        {
            file = chooser.getSelectedFiles();
        }
        return file;
	}
	
	public void save (BufferedImage image)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("images/pdi"));
		File file = null;
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) 
        	{
            file = chooser.getSelectedFile();
            if (file==null) file = new File("images/myimage.png");
            try
				{
				ImageIO.write(image, "png", file);	
				}
     		catch (Exception e)
	     		{
	     		}
        	}	
	}
	
	public BufferedImage loadImage (File file)
		{
		File f = file;
		
		// Verificar si el archivo es una imagen
		// mostrar vista previa
		// http://java.sun.com/docs/books/tutorial/uiswing/examples/components/index.html#FileChooserDemo2
		
		try 
		{
			return ImageIO.read(f);
		}
		catch (IIOException exc) 
        {
        	JOptionPane.showMessageDialog(null,
				"No se encuentra el archivo "+f.getName(), "Error de Carga", 
				JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }       
        return null;
		}
		
	public BufferedImage[] loadImages (File file[])
		{
		File f[] = file;
		int i;
		if (file==null) return null;
		BufferedImage images[] = new BufferedImage[file.length];
		i=0;
		try 
		{			
			for (i=0; i<images.length; i++) images[i] = ImageIO.read(f[i]);
		}
		catch (IIOException exc) 
        {
        	JOptionPane.showMessageDialog(null,
				"No se encuentra el archivo "+f[i].getName(), "Error de Carga", 
				JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return images;
		}
}
