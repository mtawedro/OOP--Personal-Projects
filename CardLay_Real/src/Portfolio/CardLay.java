package Portfolio;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
public class CardLay extends JFrame implements ActionListener{

	
	static JFrame Mainwindow;
	static JButton temp;
	static JPanel p5;
	static JPanel Contwindow;
	
	
	static JTextField type;
	static JTextField symbol;
	static JTextField compName;
	static JTextField numShares;
	static JTextField price;
	static JTextField gained;
	static JTextField highPrice;
	static JTextField lowPrice;
	static int flag = 0;
	static String typeIn;
	static int flagH = 0;
	static int flagL = 0;
	static int x = -1;
	static boolean symbolFlag = false;
	 JButton b5 ;
	 JButton b6 ;
	 JButton b7 ;
	 JButton b8 ;
	 JButton b9 ;
	 JButton b3;
	JButton b4;
	 static JButton b1;
	 static JButton b2;
	
	static JTextArea text;
	static JTextArea textBuy;
	static JTextArea textGain;
	JMenuItem buy;
	JMenuItem sell;
	JMenuItem update;
	JMenuItem getGain;
	JMenuItem search;
	
	JMenuItem exit;
	static JPanel p1;
	static JPanel p2;
	static JPanel panel2temp;
	static JPanel p3;
	static JPanel p4;
	static JPanel panel =  new JPanel();
	static JPanel panel1 = new JPanel();
	static JPanel panelTemp1;
	static JPanel panelTemp2;


	static JPanel Buywindow;
	static JPanel Sellwindow;
	static JPanel Gainwindow;
	static JPanel Searchwindow;
	static JPanel Welcomewindow;
	
	
	
	static CardLayout cl;
	
	static JComboBox<String> combobox; 
      int count = 0; 
	    
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{//super("Investment Portfolio");
		
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		Mainwindow = new JFrame("Practice");
		Mainwindow.setSize(700,450); //buttons will adjust ?
		Mainwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// SetBuy();
		//SetGetGained();
		//temp = new JButton("BUTTON 1");
		 //p5 = new JPanel();
		//p5 .setPreferredSize(new Dimension(700, 450));           //Make PANEL there adding == BUYpanel
		//p5.add(temp);
		
		//Contwindow = new JPanel();                               //Then Declare
	
		//CardLayout cardL = new CardLayout();
		
		//Contwindow.setLayout( cardL);
		//Contwindow.setPreferredSize(new Dimension(700, 450));
		
		//Contwindow.add(p5, "1");
		//cardL.show(Contwindow, "1");
		
		//Mainwindow.add(Contwindow);
		
		SetBuy();
		 SetGetGained();
		 JPanel Contwindows = new JPanel();
			
			CardLayout cardLayo = new CardLayout();
			
			Contwindows.setLayout( cardLayo);
			Contwindows.setPreferredSize(new Dimension(700, 450));
			
			Contwindows.add(Buywindow, "1");
            // Mainwindow.add(Buywindow);
//cardLayo.show(Contwindows, "1");
//Mainwindow.add(Contwindows);


   
Contwindows.add(Gainwindow, "2");
//cardLayo.show(Contwindows, "2");
//Mainwindow.add(Contwindows);
		


System.out.println("Enter choice");
int hi = Integer.parseInt(myinput.readLine());
while(hi != 5)
{
if(hi == 1)
{
	
	cardLayo.show(Contwindows, "1");
	Mainwindow.add(Contwindows);
	textBuy.setText("");
	textBuy.append("BUY PANEL");
	Mainwindow.setVisible(true);
}
else
{ 
	cardLayo.show(Contwindows, "2");
	Mainwindow.add(Contwindows);
	//text.append("BUY PANEL");
	Mainwindow.setVisible(true);
}
		

System.out.println("Enter choice");
 hi = Integer.parseInt(myinput.readLine());
}


		
		//SetBuy();
	}

	
	
	
	public static void SetBuy()
	{
		
	System.out.println("In HERE");
	
	//TempMainwindow.setVisible(false);
    Buywindow = new JPanel();
    Buywindow.setPreferredSize(new Dimension(700, 450));
	
    
    //	window.setSize(700, 450);
    
    /////Buywindow.setVisible(true);
	
	//panel.setVisible(true);
	
	 b1 = new JButton("Buy");
	// b1.addActionListener(this);
	
	 b2 = new JButton("Reset");
	// b2.addActionListener(this);
	
	JPanel panelTemp1 = new JPanel();
	panelTemp1.setLayout( new GridLayout(1,2));
	JPanel p3 = new JPanel();
	p3.setLayout(new GridLayout(2,1));
	
	JPanel butt1 = new JPanel();
	JPanel butt2 = new JPanel();
	JPanel p2temp = new JPanel();
	JPanel p3temp = new JPanel();
	p3temp.setLayout(new BorderLayout());
	
	p2temp.setLayout(new BorderLayout());
	JPanel p2 = new JPanel();
	
	
	p2.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.anchor = GridBagConstraints.LINE_END;
	 
	gbc.anchor =  GridBagConstraints.LINE_START;
	
    p2.add(new JLabel("Type"), gbc);
    gbc.gridy++;

	p2.add(new JLabel("Symbol"), gbc);
	 gbc.gridy ++;
	 
	p2.add(new JLabel("Name"), gbc);
	
	gbc.gridy ++;
	 
	p2.add(new JLabel("Quantity"), gbc);
	
	gbc.gridy ++;
	 
	p2.add(new JLabel("Price"), gbc);
	
	String [] messageString = {"Stock","MutualFund"};
	combobox = new JComboBox<String>(messageString);
	//combobox.addItem("Stock");
	//combobox.addItem("MutualFund");
	combobox.setSelectedItem(0);
	
	
	 //type = new JTextField(12);
	combobox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			  
				typeIn = (String) combobox.getSelectedItem();
				
					System.out.println("IN stock!!" + typeIn);
			
				
			}
		});
	 
	
	
	
	 
	
	 symbol = new JTextField(8);
	 symbol.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (symbol.getText().isEmpty())
				 {
					System.out.println("ENTER SYMBOL");
					text.append("Invalid Choice, you must enter in a symbol\n");
					
			     } 
				 
				
			}
		});
	 
	 
	 
	 compName = new JTextField(16);
	 compName.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 if (compName.getText().isEmpty())
				 {
					 System.out.println("ENTER COMP");
					 text.append("Invalid Choice, you must enter in a company name\n");
					
			     } 
				 
				
			}
		});
	
	 numShares = new JTextField(5);
	 numShares .addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				flag = 1; 
				//validateFormatShares(numShares.getText(), numShares);
				flag = 0; 
				
			}
		});
		
		
	 
	 price = new JTextField(5);
	 price .addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					flag = 1;
				//	validateFormatPrice(price.getText(), price);
					flag = 0;
			}
		});
	
	
	gbc.gridx = 1;
	gbc.gridy = 0;
	//gbc.gridwidth = 1;                //reset to the default
   // gbc.gridheight = 2;

	gbc.anchor =  GridBagConstraints.LINE_START;
	p2.add(combobox, gbc);
	
	gbc.gridy ++;
	p2.add(symbol, gbc);
	gbc.gridy ++;
	p2.add(compName, gbc);
	gbc.gridy ++;
	p2.add(numShares, gbc);

	gbc.gridy ++;
	p2.add(price, gbc);

	
	//adding b1 to first panel
	butt1.add(b1, BorderLayout.SOUTH);
	//adding b2 second panel
	butt2.add(b2, BorderLayout.SOUTH);
	//adding both panels to big panel
	p3.add(butt1);
	p3.add(butt2);
	
	//p2temp.add(p2);
	//panelTemp1.add(p4);
	JLabel lab1 = new JLabel("Buying an Investment", SwingConstants.LEFT);
	lab1.setFont(new Font("Serif", Font.ITALIC, 16));
	p3temp.add(lab1, BorderLayout.WEST);
	
	//panelTemp1.setBorder(new EmptyBorder(new Insets(600, 500, 600, 500)));
	panelTemp1.add(p2);
	panelTemp1.add(p3);
	
	
	JLabel lab = new JLabel("Messages...", SwingConstants.LEFT);
	lab.setFont(new Font("Serif", Font.ITALIC, 16));
	//p2temp.setBorder(new Dimension(10, 10));

	p2temp.add(lab, BorderLayout.SOUTH);
	
	textBuy = new JTextArea(9,8);
	textBuy.setFont(new Font("Serif", Font.ITALIC, 14));

	textBuy.setEditable(false);

	//text.add(new JLabel("Messages"), BorderLayout.WEST);
	JScrollPane scroll = new JScrollPane(textBuy);
		
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
	JPanel panel =  new JPanel();
	
	BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	panel.setLayout(boxlayout);
	//panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
	panel.add(p3temp);
	panel.add(panelTemp1);
	panel.add(p2temp);
	panel.add(scroll);
	
	Buywindow.add(panel);
	
	 
   // JPanel Contwindows = new JPanel();
	
	//CardLayout cardLayo = new CardLayout();
	
	//Contwindows.setLayout( cardLayo);
	//Contwindows.setPreferredSize(new Dimension(700, 450));
	
    
    
	
//	Contwindows.add(Buywindow, "1");
	                                               // Mainwindow.add(Buywindow);
	//cardLayo.show(Contwindows, "1");
	//Mainwindow.add(Contwindows);
	//Mainwindow.setVisible(true);

	                                                 //window.setVisible(true);
	                                                //Mainwindow.setVisible(true);
	
	
	}
	
	
	
	
	public static void SetGetGained()
	{
	
	//Mainwindow.remove(Buywindow);
	
		//Mainwindow.getContentPane().remove(Buywindow);
		//Mainwindow.getContentPane().remove(TempMainwindow);
		//Mainwindow.add(new JPanel());
		//Mainwindow.getContentPane().invalidate();
		//Mainwindow.getContentPane().validate();
	
	//Mainwindow.invalidate();
	//Mainwindow.validate();

	//Mainwindow.setVisible(true);
	
	//Buywindow.setVisible(false);
		//TempMainwindow.setVisible(false);
	Gainwindow = new JPanel();
	Gainwindow.setPreferredSize(new Dimension(700, 450));
		
//		window.setSize(700, 450);
	//Gainwindow.setVisible(true);
		
		
		//panel.remove(panelTemp1);
		//panel.remove(p3temp);
		
		
		//window.remove(panel);
	
	
	JPanel panelTemp1 = new JPanel();
	panelTemp1.setLayout( new BorderLayout());
	
	JPanel p2temp = new JPanel();
	JPanel p3temp = new JPanel();
	p3temp.setLayout(new BorderLayout());
	
	p2temp.setLayout(new BorderLayout());
	
	JPanel p2 = new JPanel();
	
	
	p2.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.anchor = GridBagConstraints.LINE_END;
	 
	gbc.anchor =  GridBagConstraints.LINE_START;
	
  
	p2.add(new JLabel("Total gain"), gbc);
	
	 gained = new JTextField(8);
	 gained.setEditable(false);
	 
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.anchor =  GridBagConstraints.LINE_START;
	
	p2.add(gained, gbc);
	
	
	JLabel lab1 = new JLabel("Getting total gain", SwingConstants.LEFT);
	lab1.setFont(new Font("Serif", Font.ITALIC, 16));
	p3temp.add(lab1, BorderLayout.WEST);
	
	//panelTemp1.setBorder(new EmptyBorder(new Insets(600, 500, 600, 500)));
	panelTemp1.add(p2, BorderLayout.WEST);
	
	JLabel lab = new JLabel("Individual Gains", SwingConstants.LEFT);
	lab.setFont(new Font("Serif", Font.ITALIC, 16));
	//p2temp.setBorder(new Dimension(10, 10));

	p2temp.add(lab, BorderLayout.SOUTH);
	
	textGain = new JTextArea(14,8);
	textGain.setFont(new Font("Serif", Font.ITALIC, 14));

	textGain.setEditable(false);

	//text.add(new JLabel("Messages"), BorderLayout.WEST);
	JScrollPane scroll = new JScrollPane(textGain);
		
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	//window.add(p4);
	//window.add(panelTemp1,BorderLayout.NORTH);
	//window.add(p2temp, BorderLayout.CENTER);
	
	//window.add(scroll, BorderLayout.SOUTH);
	JPanel panel = new JPanel();
	//panel.setPreferredSize(new Dimension(700, 450));
	
	
	BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	panel.setLayout(boxlayout);
	//panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
	panel.add(p3temp);
	panel.add(panelTemp1);
	panel.add(p2temp);
	panel.add(scroll);
	
	Gainwindow.add(panel);
	
	
	//window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
	
	//p3temp.setAlignmentY(1);
    
	
	//window.getContentPane().add(p3temp);
	//window.getContentPane().add(panelTemp1);
	//window.getContentPane().add(p2temp);//lable
	//window.getContentPane().add(scroll);
	
	
	                                       //Mainwindow.add(Gainwindow);
	//Mainwindow.setVisible(true);
//	Mainwindow.getContentPane().invalidate();
	//Mainwindow.getContentPane().validate();

	//Gainwindow.setVisible(true);
	
	
	
	}
	




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
