package mvc.controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class OnTransformEvent extends AbstractAction
{	
	private int type_transform;
	
	public void actionPerformed(ActionEvent e)
		{
	
		}
	
	public OnTransformEvent(int type_transform)
		{
		this.type_transform = type_transform;
		}	
}
