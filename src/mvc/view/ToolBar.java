package mvc.view;

import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import mvc.controller.OnFileEvent;

public final class ToolBar extends JToolBar
{
	private final String PATH = "images/gui/";
	private JButton button[] = new JButton[16];
	
	public ToolBar ()
		{
		super("Tools");
		button[0]  = new JButton(new ImageIcon(PATH+"FolderOpen32.gif"));
		button[1]  = new JButton(new ImageIcon(PATH+"FileSave32.gif"));
		button[2]  = new JButton(new ImageIcon(PATH+"ColorAdjust.gif"));
		button[3]  = new JButton(new ImageIcon(PATH+"BrightnessAdjust.gif"));
		button[4]  = new JButton(new ImageIcon(PATH+"ContrastAdjust.gif"));
		button[5]  = new JButton(new ImageIcon(PATH+"gamma.png"));
		button[6]  = new JButton(new ImageIcon(PATH+"Comic.gif"));
		button[7]  = new JButton(new ImageIcon(PATH+"ScaleAdjust.gif"));
		button[8]  = new JButton(new ImageIcon(PATH+"Rotate.gif"));
		button[9]  = new JButton(new ImageIcon(PATH+"ImageBasicOp.png"));		
		button[10] = new JButton(new ImageIcon(PATH+"Convolution.gif"));
		button[11] = new JButton(new ImageIcon(PATH+"Histogram.gif"));
		button[12] = new JButton(new ImageIcon(PATH+"ImageEraser.gif"));
		button[13] = new JButton(new ImageIcon(PATH+"Camera.gif"));		
		button[14] = new JButton(new ImageIcon(PATH+"Help.gif"));
		button[15] = new JButton(new ImageIcon(PATH+"ucv.png"));
		
		button[0].addActionListener(new OnFileEvent(OnFileEvent.OPEN));
		button[1].addActionListener(new OnFileEvent(OnFileEvent.SAVE));
		
		add(button[0]);
		add(button[1]);
		addSeparator(new Dimension(64,32));
		for (int i=2; i<14; i++)
			add(button[i]);
		addSeparator(new Dimension(64,32));
		add(button[14]);
		add(button[15]);
		}
}
