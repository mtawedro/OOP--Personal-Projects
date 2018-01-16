package permute;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.*;

public class FirstWindow extends JFrame  implements ActionListener
{

	// Book type constants
    public static final int BT_BOOK = 1;
    public static final int BT_TEXTBOOK = 2;
    public static final int BT_WORKBOOK = 3;
    public static final int BT_FLOOR = 1;
    public static final int BT_CEILING = 3;
    
    // String formatting properties
    public static final int SF_NONEMPTY = 0;
    public static final int SF_ISBN = 1;
    
    // Integer format properties
    public static final int IF_BT = 0;
    public static final int IF_YEAR = 1;
    public static final int IF_NUMPROBS = 2;
    
    // Prompt constants
    public static final String P_BTMSG = "What kind of book would you like to add?\n1.Book\n2.Textbook\n3.Workbook";
    public static final String P_BTERR = "Input must be an integer between 1 and 3, inclusive.";
    public static final String P_TITLEMSG = "Enter the book's title.";
    public static final String P_TITLEERR = "Title must be a nonempty string.";
    public static final String P_AUTHMSG = "Enter the book's author.";
    public static final String P_AUTHERR = "Author must be a nonempty string.";
    public static final String P_YEARMSG = "Enter the book's year of publication.";
    public static final String P_YEARERR = "Year must be in the range -2600..2017, inclusive.";
    public static final String P_ISBNMSG = "Enter the book's ISBN.";
    public static final String P_ISBNERR = "An ISBN is a length 10 or 13 numerical sequence.";
    public static final String P_PRCMSG = "Enter the book's price.";
    public static final String P_PRCERR = "Price must be a positive real number, which gets rounded to 2 decimal places after being entered.";
    public static final String P_SUBJMSG = "Enter the book's subject.";
    public static final String P_SUBJERR = "Subject must be a nonempty string.";
    public static final String P_WBISBNMSG = "Enter the textbook's workbookISBN.";
    public static final String P_WBISBNERR = "An ISBN is a length 10 or 13 numerical sequence.";
    public static final String P_NPROBSMSG = "Enter the workbook's number of problems.";
    public static final String P_NPROBSERR = "The number of problems must be a positive integer.";

    // Other constants
    public static final int ISBN_LEN1 = 10;
    public static final int ISBN_LEN2 = 13;
    public static final int YEAR_FLOOR = -2600;
    public static final int YEAR_CIELING = 2017;
    public static final String FILE = "output.txt";
	
	
	
	
	
	JCheckBox cb,cb2;
	JTextField textField;
	JLabel label;
	JTextArea textArea;
	JTextArea tb;
	
	static JTextField textField1;
	static JTextField textField2;
	static JTextField textField3;
	static JTextField textField4;
	static JTextField textField5;
	static JTextField textField6;
	static JTextField textField7;
	static JTextField textField8;
	static int flag = 0;
	JButton b5 ;
	JButton b6 ;
	JButton b7 ;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	SnazzyMenuBar j ;
	static JTextArea text;
	JMenuItem save;
	JMenuItem load;
	JMenuItem exit;
	
	  ArrayList<Book> books = new ArrayList<Book>();
	  String user;
	    
	  
      int count = 0; 
	    
	
	//constructor
	public FirstWindow()
	{
		
		
		
		super("A Nice Bookstore");
		setSize(800,550); //buttons will adjust ?
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		j = new SnazzyMenuBar();
		JMenu first = new JMenu("File");
		JMenuBar bar = new JMenuBar();
		 save = new JMenuItem("Save As...");
		 load = new JMenuItem("Load File...");
		exit = new JMenuItem("Exit");
		first.add(save);
		first.add(load);
		first.add(exit);
		
		bar.add(first);
		
		
		
	 save.addActionListener(this);
	 load.addActionListener(this);
	 exit.addActionListener(this);
		setJMenuBar(bar);
	
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	
	p1.setLayout(new GridLayout(2,2,5,5));
	
	p2.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	
	gbc.gridx = 0;
	 gbc.gridy = 0;
	 gbc.anchor = GridBagConstraints.LINE_END;
	 
	 p3.setLayout(new GridLayout(3,0));
	
    b1 = new JButton("List books");
	b1.setActionCommand("This is Button 1");
	b1.addActionListener(this);
    b2 = new JButton("Unique authors");
	b2.setActionCommand("This is Button 2");
	b2.addActionListener(this);
	b3 = new JButton("Average price");
	b3.setActionCommand("This is Button 3");
	b3.addActionListener(this);
    b4 = new JButton("Textbook-Workbook pairs");
    b4.addActionListener(this);
	
	 b5 = new JButton("Add Book");
	b5.addActionListener(this);
	 b6 = new JButton("Add Textbook");
	b6.addActionListener(this);
	 b7 = new JButton("Add Workbook");
	b7.addActionListener(this);
	
	
	
	
	//b2.addActionListener(this);
	//b3.addActionListener(this);
	
	/*
	b1.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			JOptionPane.showMessageDialog(null, "Good Job Kid you harvested our corn!");
			
		}
	});
	*/
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	
	 //cb = new JCheckBox("DO YOU LOVE CHEESE?");
	 //cb2 = new JCheckBox("DO YOU LOVE BACON?");
	 
		gbc.anchor =  GridBagConstraints.LINE_START;
		
	    p2.add(new JLabel("Title"), gbc);
	    gbc.gridy++;
	
		p2.add(new JLabel("Author"), gbc);
		 gbc.gridy ++;
		 
		p2.add(new JLabel("Year Published"), gbc);
		
		gbc.gridy ++;
		 
		p2.add(new JLabel("ISBN"), gbc);
		
		gbc.gridy ++;
		 
		p2.add(new JLabel("Price"), gbc);
		
		gbc.gridy ++;
		 
		p2.add(new JLabel("Subject(Textbook only)"), gbc);
		
		gbc.gridy ++;
		 
		p2.add(new JLabel("WorkbookISBN(Textbook only)"), gbc);
		
		gbc.gridy ++;
		 
		p2.add(new JLabel("NumProblems (Workbook only)"), gbc);
		
	    textField1 = new JTextField(15);
		textField1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				 if (textField1.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Invalid Input!");
	             } 
				
			}
		});
		
		textField2 = new JTextField(15);
		textField2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				 if (textField2.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Invalid Input!");
	             } 
				
			}
		});
		textField3 = new JTextField(15);
		textField3.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				flag = 1;
				//System.out.println("IN HERE");
				//System.out.println(textField3.getText());
				validateFormat1(textField3.getText(), textField3);
				
				flag = 0;
			
			}
		});
		textField4 = new JTextField(15);
		textField4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				String tempIsbn =textField4.getText();
			    
			     if(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
			     {
			    	 JOptionPane.showMessageDialog(null,"Invalid Input ( Must be 10 or 13 characters wrong");
			    	 textField4.setText("");
			     }
				
			}
		});
		textField5 = new JTextField(15);
		textField5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				flag = 1;
				validateFormat2(textField5.getText(), textField5);
				flag = 0;
				
			}

			
		});
		textField6 = new JTextField(15);
		textField6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				 if (textField6.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Invalid Input!");
	             } 
				
			}
		});
		textField7 = new JTextField(15);
		textField7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				String tempIsbn =textField7.getText();
			    
			     if(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
			     {
			    	 JOptionPane.showMessageDialog(null,"Invalid Input ( Must be 10 or 13 characters wrong");
			    	 textField7.setText("");
			     }
			}
		});
		textField8 = new JTextField(15);
		textField8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				flag = 1;
				validateFormat3(textField8.getText(), textField8);
				flag = 0;
				
			}

			
		});
		
	
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor =  GridBagConstraints.LINE_START;
		p2.add(textField1, gbc);
		
		gbc.gridy ++;
		p2.add(textField2, gbc);
		gbc.gridy ++;
		p2.add(textField3, gbc);
		gbc.gridy ++;
		p2.add(textField4, gbc);
	
		gbc.gridy ++;
		p2.add(textField5, gbc);
	
		gbc.gridy ++;
		p2.add(textField6, gbc);
	
		gbc.gridy ++;
		p2.add(textField7, gbc);
	
		gbc.gridy ++;
		p2.add(textField8, gbc);
	
		
	
	
	JLabel label = new JLabel("This is a lable");
	JTextField textField = new JTextField("This is a textField");
	 textArea = new JTextArea("This is a textArea", 5, 50);
	tb = new JTextArea("New",2,20);
	 text = new JTextArea(15,20);
	JScrollPane scroll = new JScrollPane(text);
	
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	
//	p3.add(textArea);
	p3.add(b5);
	p3.add(b6);
	p3.add(b7);
	
	add(p1);
	add(p3);
	add(scroll);
	add(p2);
	
	
	
	}
	//.setText(e.getActionCommand())
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b5) //add Books
		{
			text.setText("");
			Check();
			
			
			if(textField1.getText().isEmpty() || textField2.getText().isEmpty()  || textField3.getText(). isEmpty()  || textField4.getText().isEmpty()  || 
					textField5.getText().isEmpty() )
			{
				//text.append("TextBox is left Blank!\n");
				 
			}
			
			else if(textField6.getText().length() !=0 || textField7.getText().length() !=0 || textField8.getText().length() !=0)
			{
				text.append("Additional Wrong TextBoxs for 'Adding Book'\n");
			}
			
			else
			{
           try {
			Bookstore.BookC( Bookstore.books, Bookstore.count, textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           clear();   
			}
	      
		//	text.setText("");
		
		}
		
		else if(e.getSource() == b6) //Add textbook
		{
			text.setText("");
			Check2();
			
			if(textField6.getText().isEmpty() || textField7.getText().isEmpty()  || textField1.getText().isEmpty() || textField2.getText().isEmpty()  || textField3.getText(). isEmpty()  || textField4.getText().isEmpty()  || 
					textField5.getText().isEmpty() )
			{
				//text.append("TextBox is left Blank!\n");
			}
			
			else if(textField8.getText().length() !=0 )
			{
				text.append("Additional Wrong TextBoxs for 'Adding Textbook'\n");
			}
			
					
			else
			{ 
			
			
			try {
					Bookstore.TextbookC( Bookstore.books, Bookstore.count, textField6.getText(),textField7.getText(), textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  clear();
			  
			}
		
		//	text.setText("");
		}
		
		else if(e.getSource() == b7)//Add Workbook
		{
			text.setText("");
			Check3();
			
			if(textField8.getText().isEmpty()  || textField1.getText().isEmpty() || textField2.getText().isEmpty()  || textField3.getText(). isEmpty()  || textField4.getText().isEmpty()  || 
					textField5.getText().isEmpty() )
			{
				//text.append("TextBox is left Blank!\n");
			}
			
			else if(textField6.getText().length() !=0 || textField7.getText().length() !=0)
			{
				text.append("Additonal Wrong TextBoxs for 'Adding Workbook'\n");
			}
			
			else //add a condition if function != false execute this and get rid of the isEmpty function before
			{ 
			
			try {
					Bookstore.WorkbookC( Bookstore.books, Bookstore.count,textField8.getText(), textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			 clear();
			}
	
		//	text.setText("");
		}
	
		else if(e.getSource() == b1)//prints books
		{
			
			Bookstore.printBooks(Bookstore.books);
			
			
		}
		
		else if(e.getSource() == b2)//prints unique authors
		{
			
			Bookstore.printAuthors(Bookstore.books);
			
			
		}
		
		else if(e.getSource() == b3)//prints average price
		{
			
			Bookstore.averagePrice(Bookstore.books);
			
			
		}
	
		else if(e.getSource() == b4)//prints workbook-textbook pairs
		{
			
			Bookstore.compareWork(Bookstore.books);
			
			
		}
	
		
		else if(e.getSource() == save)
		{
			String inputValue = JOptionPane.showInputDialog("Please input a File name to save to"); 

			Bookstore.FileIO(Bookstore.books, inputValue);
			
		}
	
		else if(e.getSource() == load)
		{
			String inputValue = JOptionPane.showInputDialog("Please input a File name to load from"); 

			Bookstore.LoadFileIO(Bookstore.books,inputValue);
		
		}
		
		else if(e.getSource() == exit)
		{
			System.exit(0);
		}
	
		
	
	}
	public static void validateFormat1(String message, JTextField textField) 
	{
		
		boolean done = false;
		int  tempYear;
		try
		{
			tempYear = Integer.parseInt(message);
			
		    done = true;
		
	
		}
		catch(NumberFormatException e)
		{
			if(flag == 1)
			{
			   JOptionPane.showMessageDialog(null, "Invalid Input");
			}
			else
			{
				text.append("Invalid Input for Year\n");
			}
			
			textField.setText("");
			//text.setText(""); //flag == 1 
		
		}
		
		
	   if(done == true)
	   {
		  System.out.println("TRUE");
		   
		   tempYear = Integer.parseInt(message);
		   if(tempYear < -2600 || tempYear > 2017 )	
		   {
	    	
			   try
			   {
				  if(flag == 1)
				  {
				   JOptionPane.showMessageDialog(null, "Invalid Input ( Must be between yrs -2600 and 2017)");
				  }
				  
				  else
				  {
					  text.append("Invalid Input for Year( Must be between yrs -2600 and 2017)\n");
					  
				  }
				  
				   textField.setText("");
				//	text.setText(""); flag == 1
		
			   }
			   catch(NumberFormatException e)
			   {
				  if(flag == 1)
				  {
				   JOptionPane.showMessageDialog(null, "Invalid Input");
				  }
				  else
				  {
					  text.append("Invalid Input for year\n");
				  }
			
				  //flag ==1
			   }
		   }
	
		}
	
	   /*if flag == 1 return false else return true
	    * 
	    * 
	    * 
	    */
	   
	}
	
	
	public static void validateFormat2(String message, JTextField textField) 
	{
		boolean done = false;
		double tempPrice;
		try
		{
			tempPrice = Double.parseDouble(message);
			
		    done = true;
		
	
		}
		catch(NumberFormatException e)
		{
			if(flag ==1)
			{
			JOptionPane.showMessageDialog(null, "Invalid Input");
			}
			else
			{
				text.append("Invalid Input for price\n");
			}
			textField.setText("");
		
		}
		
		
	   if(done == true)
	   {
		  System.out.println("TRUE");
		   
		   tempPrice = Double.parseDouble(message);
		   if( tempPrice < 0.0  )	
		   {
	    	
			   try
			   {
				   if(flag ==1)
				   {
				     JOptionPane.showMessageDialog(null, "Invalid input, can't have a neg price");
				   }
				   else
				   {
					   text.append("Invalid input for price, can't have a neg price\n");
				   }
				   textField.setText("");
		
			   }
			   catch(NumberFormatException e)
			   {
				  if(flag == 1)
				  {
				   JOptionPane.showMessageDialog(null, "Invalid Input in TRUE");
				  }
				  else
				  {
					  text.append("Invalid input for price\n");
				  }
			
			   }
		   }
	
		}
	
		
		
	}
	
	public static void validateFormat3(String message, JTextField textField) 
	{
		
		
		boolean done = false;
		int tempNum;
		try
		{
			tempNum = Integer.parseInt(message);
			
		    done = true;
		
	
		}
		catch(NumberFormatException e)
		{
			 if(flag == 1)
			 {
				 JOptionPane.showMessageDialog(null, "Invalid Input");
			 }
			 else
			 {
				 text.append("Invalid input for Num of Problems\n");
			 }
			textField.setText("");
		
		}
		
		
	   if(done == true)
	   {
		  System.out.println("TRUE");
		   
		   tempNum = Integer.parseInt(message);
		   if( tempNum < 0  )	
		   {
	    	
			   try
			   {
				   if(flag == 1)
					 {
				   JOptionPane.showMessageDialog(null, "Invalid input, can't have a neg num");
					 }
				   else
				   {
					   text.append("Invalid input for Num of Problems, can't have a neg num\n");
				   }
				   textField.setText("");
		
			   }
			   catch(NumberFormatException e)
			   {
				   if(flag ==1)
				   {
					   JOptionPane.showMessageDialog(null, "Invalid Input in TRUE");
				   }
				   else
				   {
					   text.append("Invalid inout for neg number\n");
					   
				   }
			
			   }
		   }
	
		}
	
		
		
		
		
	}
	
	public static void clear()
	{
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
	}
	
	public static void Check()
	{
	 if (textField1.getText().isEmpty())
	 {
		 text.append("Invalid Input for Title!\n");
		
     } 
	 
	 if (textField2.getText().isEmpty())
	 {
		 text.append("Invalid Input for Author!\n");
		 
     } 
	
	 validateFormat1(textField3.getText(), textField3);
		
	 String tempIsbn =textField4.getText();
	    
     if(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
     {
    	 text.append("Invalid Input of ISBN ( Must be 10 or 13 characters long)\n");
    	 textField4.setText("");
     }
	 
     validateFormat2(textField5.getText(), textField5);//books
     
	}
     public static void Check2()
     {
     
    	 Check();
    	 
    	 if (textField6.getText().isEmpty())
    	 {
    		 text.append("Invalid Input for Subject!\n");
		 
    	 } 
	
     
    	 String tempIsbn =textField7.getText();
	    
    	 if(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
    	 {
    		 text.append("Invalid Input for WorkbookISBN ( Must be 10 or 13 characters long)\n"); //textbooks
    		 textField7.setText("");
    	 }
     
     }
     
     
     public static void Check3()
     {
     
    	 Check();
    	 
         validateFormat3(textField8.getText(), textField8); // Workbooks
	
	}
	
	
	
	
	
	
	
	
	
	
	
}



