package permute;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SnazzyMenuBar extends JMenuBar
{

	JMenuItem save;
	JMenuItem load;
	JMenuItem exit;
	public SnazzyMenuBar() 
	{
		
		
		JMenu first = new JMenu("File");
		 save = new JMenuItem("Save As...");
		 load = new JMenuItem("Load File...");
		exit = new JMenuItem("Exit");
		first.add(save);
		first.add(load);
		first.add(exit);
		
		add(first);
		
		/*
		JMenu first = new JMenu("Menu 1");
		JMenu second = new JMenu("Menu 2");
		JMenu sub = new JMenu("Sub");
		JMenuItem test = new JMenuItem("test");
		sub.add(test);
		
		JMenuItem bacon = new JMenuItem("Bacon");
		JMenuItem cheese = new JMenuItem("Cheese");
		first.add(bacon);
		first.add(cheese);
		first.add(sub);
		
		add(first);
		add(second);
		*/
		
	}
	
	
}
