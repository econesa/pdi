package mvc.controller;

import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import mvc.view.ImageManager;
import mvc.view.ImageUI;

public class OnFileEvent extends AbstractAction
{
	public static final int OPEN = 0;
	public static final int SAVE = 0;
	private int type_event;
	
	public void actionPerformed(ActionEvent e)
		{
		if (type_event==OPEN)
			{
			ImageManager manager = ImageManager.getInstance();
			ImageUI iframe;
			File file = manager.open ();
			if(file!=null)
				{
				iframe = new ImageUI (file);	    
		    	//frame.addInternalFrame(iframe);	
				}	
			}
		else
			{
			}
		}
	
	public OnFileEvent(int type_event)
		{
		this.type_event = type_event;
		}	
}
