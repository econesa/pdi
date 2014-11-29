/**
 * @(#)ProImaging.java
 *
 * ProImaging Applet application
 *
 * @author 
 * @version 1.00 2009/7/12
 */
 
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JApplet;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import mvc.view.ToolBar;

public class ProImaging extends JApplet 
{
	private JDesktopPane panel;
	
	public void init() 
		{
		panel = new JDesktopPane();
		JToolBar toolbar = new ToolBar();		
		Container contentPane = getContentPane();
        contentPane.add(toolbar, BorderLayout.PAGE_START);
        contentPane.add(panel, BorderLayout.CENTER);	
		}
	
}