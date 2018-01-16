package Portfolio;

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
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;


import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.*;

public class FirstWindow extends JFrame implements ActionListener {

	static JTextField symbolBuy;
	static JTextField compNameBuy;
	static JTextField numSharesBuy;
	static JTextField priceBuy;

	static JTextField symbolSell;
	static JTextField numSharesSell;
	static JTextField priceSell;

	static JTextField symbolUpdate;
	static JTextField compNameUpdate;
	static JTextField priceUpdate;

	static JTextField symbolSearch;
	static JTextField compNameSearch;

	static JTextField gained;
	static JTextField highPrice;
	static JTextField lowPrice;
	static int flag = 0;
	static String typeIn;
	static int flagH = 0;
	static int flagL = 0;
	static int x = -1;
	static boolean symbolFlag = false;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b3;
	JButton b4;
	JButton b1;
	JButton b2;

	static JTextArea textBuy;
	static JTextArea textSell;
	static JTextArea textUpdate;
	static JTextArea textGain;
	static JTextArea textSearch;

	JMenuItem buy;
	JMenuItem sell;
	JMenuItem update;
	JMenuItem getGain;
	JMenuItem search;

	JMenuItem exit;

	static JFrame Mainwindow;
	static JPanel Contwindow;
	static JPanel Buywindow;
	static JPanel Sellwindow;
	static JPanel Gainwindow;
	static JPanel Searchwindow;
	static JPanel Updatewindow;
	static JPanel Welcomewindow;

	static JComboBox<String> combobox;
	int count = 0;

	// constructor
	public FirstWindow() {
		// creates Main Frame
		Mainwindow = new JFrame("Investment Portfolio");
		Mainwindow.setSize(700, 450); // buttons will adjust ?
		Mainwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Welcomewindow = new JPanel();
		Welcomewindow.setLayout(new BorderLayout());

		// creates Welcome Window
		JPanel panel = new JPanel();

		JLabel message = new JLabel(
				"<html> <br> <br> <br> Welcome to Investment Portfolio<br> <br> <br> <br> <br>"
						+ "Choose a command from the \"Commands\" menu to buy or sell an <br> investment, update prices "
						+ "for all investments, get gain for the portfolio, <br> search for relevant investments, or quit the program. </html>",
				SwingConstants.LEFT);
		message.setFont(new Font("Serif", Font.ITALIC, 16));
		panel.add(message);

		Welcomewindow.add(panel, BorderLayout.WEST);

		SetBuy();
		SetGetGained();
		SetSell();
		SetUpdate();
		setSearch();

		JPanel Contwindows = new JPanel();

		CardLayout cardLayo = new CardLayout();

		Contwindows.setLayout(cardLayo);
		Contwindows.setPreferredSize(new Dimension(700, 450));

		Contwindows.add(Welcomewindow, "0");
		Contwindows.add(Buywindow, "1");
		Contwindows.add(Gainwindow, "2");
		Contwindows.add(Sellwindow, "3");
		Contwindows.add(Updatewindow, "4");
		Contwindows.add(Searchwindow, "5");

		cardLayo.show(Contwindows, "0");
		Mainwindow.add(Contwindows);
		Mainwindow.setVisible(true);

		JMenu first = new JMenu("Commands");
		JMenuBar bar = new JMenuBar();

		buy = new JMenuItem("Buy");
		buy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayo.show(Contwindows, "1");
				Mainwindow.add(Contwindows);
				ClearTextAreas();
				Mainwindow.setVisible(true);

			}

		});

		sell = new JMenuItem("Sell");
		sell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayo.show(Contwindows, "3");
				Mainwindow.add(Contwindows);
				ClearTextAreas();
				Mainwindow.setVisible(true);

			}

		});

		update = new JMenuItem("Update");
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayo.show(Contwindows, "4");
				Mainwindow.add(Contwindows);
				ClearTextAreas();
				Mainwindow.setVisible(true);

			}

		});

		getGain = new JMenuItem("GetGain");
		getGain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayo.show(Contwindows, "2");
				Mainwindow.add(Contwindows);
				ClearTextAreas();
				Mainwindow.setVisible(true);

				try {
					Portfolio.CommandGainedFunds();
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		search = new JMenuItem("Search...");
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayo.show(Contwindows, "5");
				Mainwindow.add(Contwindows);
				ClearTextAreas();
				Mainwindow.setVisible(true);

			}

		});
		exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Portfolio.FileIO(Portfolio.investAdd, Portfolio.fileName);
				System.exit(0);

			}

		});

		first.add(buy);
		first.add(sell);
		first.add(update);
		first.add(getGain);
		first.add(search);
		first.add(exit);

		bar.add(first);

		Mainwindow.setJMenuBar(bar);

		Mainwindow.setVisible(true);

	}// end of constructor

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1)// buy
		{

			if (typeIn == null) {
				typeIn = "Stock";
			}

			textBuy.setText("");

			CheckBuy();

			if (symbolBuy.getText().isEmpty() || compNameBuy.getText().isEmpty() || numSharesBuy.getText().isEmpty()
					|| priceBuy.getText().isEmpty()) {

			}

			else {

				try {
					Portfolio.CommandCalculateFunds(typeIn);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		else if (e.getSource() == b2)// resets
		{

			clear();
		}

		else if (e.getSource() == b3) // sell
		{
			textSell.setText("");

			boolean checkPoint = CheckSell();

			if (symbolSell.getText().isEmpty() || numSharesSell.getText().isEmpty() || priceSell.getText().isEmpty()
					|| checkPoint == true) // if exceeded content
			{

			}

			else {

				try {
					Portfolio.CommandSellFunds();
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		else if (e.getSource() == b4) // Resets
		{
			clearSell();
		}

		else if (e.getSource() == b6)// Next Button
		{
			textUpdate.setText("");

			x++;

			Adjust(x, b5, b6, b7);

		}

		else if (e.getSource() == b5)// Previous Button
		{
			textUpdate.setText("");

			x--;

			Adjust(x, b5, b6, b7);

		}

		else if (e.getSource() == b7) // Save button
		{
			textUpdate.setText("");

			CheckUpdate();

			if (priceUpdate.getText().isEmpty()) {

			}

			else {
				try {
					Portfolio.CommandUpdateFunds(x);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		else if (e.getSource() == b8) // Search button
		{
			SearchElements();

		}

		else if (e.getSource() == b9) // reset search button
		{
			clearUpdate();

		}

	}

	/***** Creating the different panels of the 5 interfaces *******/
	public void SetBuy() {

		Buywindow = new JPanel();
		Buywindow.setPreferredSize(new Dimension(700, 450));

		b1 = new JButton("Buy");
		b1.addActionListener(this);

		b2 = new JButton("Reset");
		b2.addActionListener(this);

		JPanel panelTemp1 = new JPanel();
		panelTemp1.setLayout(new GridLayout(1, 2));

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));

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

		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(new JLabel("Type"), gbc);
		gbc.gridy++;

		p2.add(new JLabel("Symbol"), gbc);
		gbc.gridy++;

		p2.add(new JLabel("Name"), gbc);

		gbc.gridy++;

		p2.add(new JLabel("Quantity"), gbc);

		gbc.gridy++;

		p2.add(new JLabel("Price"), gbc);

		String[] messageString = { "Stock", "MutualFund" };
		combobox = new JComboBox<String>(messageString);

		combobox.setSelectedItem(0);

		combobox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				typeIn = (String) combobox.getSelectedItem();

			}
		});

		symbolBuy = new JTextField(8);
		symbolBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (symbolBuy.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid Input!, you must enter in a symbol");

				}

			}
		});

		compNameBuy = new JTextField(16);
		compNameBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (compNameBuy.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid Input!, you must enter in a company name");

				}

			}
		});

		numSharesBuy = new JTextField(6);
		numSharesBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				
				try{
					validateFormatShares(numSharesBuy.getText(), numSharesBuy);
					
				}
				catch (QuantityFormatException e1)
				{
				       
				}
				
				flag = 0;

			}
		});

		priceBuy = new JTextField(6);
		priceBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				try{
					validateFormatPrice(priceBuy.getText(), priceBuy);
					
				}
				catch (PriceFormatException e1)
				{
				       
				}
				
				flag = 0;
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 0;

		gbc.anchor = GridBagConstraints.LINE_START;
		p2.add(combobox, gbc);

		gbc.gridy++;
		p2.add(symbolBuy, gbc);
		gbc.gridy++;
		p2.add(compNameBuy, gbc);
		gbc.gridy++;
		p2.add(numSharesBuy, gbc);

		gbc.gridy++;
		p2.add(priceBuy, gbc);

		// adding b1 to first panel
		butt1.add(b1, BorderLayout.SOUTH);
		// adding b2 second panel
		butt2.add(b2, BorderLayout.SOUTH);

		// adding both panels to big panel
		p3.add(butt1);
		p3.add(butt2);

		JLabel lab1 = new JLabel("Buying an Investment", SwingConstants.LEFT);
		lab1.setFont(new Font("Serif", Font.ITALIC, 16));
		p3temp.add(lab1, BorderLayout.WEST);

		panelTemp1.add(p2);
		panelTemp1.add(p3);

		JLabel lab = new JLabel("Messages...", SwingConstants.LEFT);
		lab.setFont(new Font("Serif", Font.ITALIC, 16));

		p2temp.add(lab, BorderLayout.SOUTH);

		textBuy = new JTextArea(12, 40);
		textBuy.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textBuy.setEditable(false);

		JScrollPane scroll = new JScrollPane(textBuy);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		panel.add(p3temp);
		panel.add(panelTemp1);
		panel.add(p2temp);
		panel.add(scroll);

		Buywindow.add(panel);

	}

	
	public void SetGetGained() {

		Gainwindow = new JPanel();
		Gainwindow.setPreferredSize(new Dimension(700, 450));

		JPanel panelTemp1 = new JPanel();
		panelTemp1.setLayout(new BorderLayout());

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

		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(new JLabel("Total gain"), gbc);

		gained = new JTextField(8);
		gained.setEditable(false);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(gained, gbc);

		JLabel lab1 = new JLabel("Getting total gain", SwingConstants.LEFT);
		lab1.setFont(new Font("Serif", Font.ITALIC, 16));
		p3temp.add(lab1, BorderLayout.WEST);

		panelTemp1.add(p2, BorderLayout.WEST);

		JLabel lab = new JLabel("Individual Gains", SwingConstants.LEFT);
		lab.setFont(new Font("Serif", Font.ITALIC, 16));

		p2temp.add(lab, BorderLayout.SOUTH);

		textGain = new JTextArea(12, 7);
		textGain.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textGain.setEditable(false);

		JScrollPane scroll = new JScrollPane(textGain);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 350));

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		panel.add(p3temp);
		panel.add(panelTemp1);
		panel.add(p2temp);
		panel.add(scroll);

		Gainwindow.add(panel);

	}

	
	public void setSearch() {

		Searchwindow = new JPanel();
		Searchwindow.setPreferredSize(new Dimension(700, 450));

		b8 = new JButton("Search");
		b8.addActionListener(this);

		b9 = new JButton("Reset");
		b9.addActionListener(this);

		JPanel panelTemp1 = new JPanel();
		panelTemp1.setLayout(new GridLayout(1, 2));

		JPanel butt1 = new JPanel();
		JPanel butt2 = new JPanel();

		JPanel p2temp = new JPanel();
		JPanel p3temp = new JPanel();

		p3temp.setLayout(new BorderLayout());
		p2temp.setLayout(new BorderLayout());

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p2.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;

		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(new JLabel("Symbol"), gbc);
		gbc.gridy++;

		p2.add(new JLabel("<html>Name <br> keywords</html>"), gbc);

		gbc.gridy++;

		p2.add(new JLabel("Low price"), gbc);

		gbc.gridy++;

		p2.add(new JLabel("High price"), gbc);

		symbolSearch = new JTextField(8);
		symbolSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Invalid Input!, you must enter in a symbol");

			}
		});

		compNameSearch = new JTextField(16);
		compNameSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Invalid Input!, you must enter in a company name");

			}
		});

		highPrice = new JTextField(6);
		highPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (highPrice.getText().length() != 0) {
					flag = 1;
					try{
						validateFormatPrice(highPrice.getText(), highPrice);
						
					}
					catch (PriceFormatException e1)
					{
					       
					}
					flag = 0;
				}

			}
		});

		lowPrice = new JTextField(6);
		lowPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lowPrice.getText().length() != 0) {

					flag = 1;
					try{
						validateFormatPrice(lowPrice.getText(), lowPrice);
						
					}
					catch (PriceFormatException e1)
					{
					       
					}
					flag = 0;

				}
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(symbolSearch, gbc);
		gbc.gridy++;
		p2.add(compNameSearch, gbc);
		gbc.gridy++;
		p2.add(lowPrice, gbc);

		gbc.gridy++;
		p2.add(highPrice, gbc);

		// adding b1 to first panel
		butt1.add(b9);
		// adding b2 second panel
		butt2.add(b8);

		// adding both panels to big panel
		p3.add(butt1, BorderLayout.NORTH);
		p3.add(butt2, BorderLayout.SOUTH);

		panelTemp1.add(p2);
		panelTemp1.add(p3);

		JLabel lab1 = new JLabel("Searching Investments", SwingConstants.LEFT);
		lab1.setFont(new Font("Serif", Font.ITALIC, 16));
		p3temp.add(lab1, BorderLayout.WEST);

		JLabel lab = new JLabel("Search results...", SwingConstants.LEFT);
		lab.setFont(new Font("Serif", Font.ITALIC, 16));

		p2temp.add(lab, BorderLayout.SOUTH);

		textSearch = new JTextArea(12, 8);
		textSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textSearch.setEditable(false);

		JScrollPane scroll = new JScrollPane(textSearch);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		panel.add(p3temp);
		panel.add(panelTemp1);
		panel.add(p2temp);
		panel.add(scroll);

		Searchwindow.add(panel);

	}

	
	public void SetUpdate() {

		Updatewindow = new JPanel();
		Updatewindow.setPreferredSize(new Dimension(700, 450));

		b5 = new JButton("Prev");
		b5.addActionListener(this);

		b6 = new JButton("Next");
		b6.addActionListener(this);

		b7 = new JButton("Save");
		b7.addActionListener(this);

		JPanel panelTemp1 = new JPanel();
		panelTemp1.setLayout(new GridLayout(1, 2));

		JPanel butt1 = new JPanel();
		JPanel butt2 = new JPanel();
		JPanel butt3 = new JPanel();

		JPanel p2temp = new JPanel();
		JPanel p3temp = new JPanel();

		p3temp.setLayout(new BorderLayout());
		p2temp.setLayout(new BorderLayout());

		JPanel p3 = new JPanel();
		JPanel p2 = new JPanel();

		p3.setLayout(new BorderLayout());

		p2.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;

		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(new JLabel("Symbol"), gbc);
		gbc.gridy++;

		p2.add(new JLabel("Name"), gbc);

		gbc.gridy++;

		p2.add(new JLabel("Price"), gbc);

		symbolUpdate = new JTextField(8);
		symbolUpdate.setEditable(false);

		compNameUpdate = new JTextField(16);
		compNameUpdate.setEditable(false);

		priceUpdate = new JTextField(6);
		priceUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				try{
					validateFormatPrice(priceUpdate.getText(), priceUpdate);
					
				}
				catch (PriceFormatException e1)
				{
				       
				}
				flag = 0;
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 0;

		gbc.anchor = GridBagConstraints.LINE_START;
		p2.add(symbolUpdate, gbc);
		gbc.gridy++;

		p2.add(compNameUpdate, gbc);
		gbc.gridy++;

		p2.add(priceUpdate, gbc);

		// adding b1 to first panel
		butt1.add(b5);
		// adding b2 second panel
		butt2.add(b6);

		butt3.add(b7);

		// adding both panels to big panel
		p3.add(butt1, BorderLayout.NORTH);
		p3.add(butt2, BorderLayout.CENTER);
		p3.add(butt3, BorderLayout.SOUTH);

		JLabel lab1 = new JLabel("Updating Investments", SwingConstants.LEFT);
		lab1.setFont(new Font("Serif", Font.ITALIC, 16));
		p3temp.add(lab1, BorderLayout.WEST);

		panelTemp1.add(p2);
		panelTemp1.add(p3);

		JLabel lab = new JLabel("Messages...", SwingConstants.LEFT);
		lab.setFont(new Font("Serif", Font.ITALIC, 16));

		p2temp.add(lab, BorderLayout.SOUTH);

		textUpdate = new JTextArea(9, 8);
		textUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textUpdate.setEditable(false);

		JScrollPane scroll = new JScrollPane(textUpdate);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		panel.add(p3temp);
		panel.add(panelTemp1);
		panel.add(p2temp);
		panel.add(scroll);

		Updatewindow.add(panel);

	}

	
	public void SetSell() {

		Sellwindow = new JPanel();
		Sellwindow.setPreferredSize(new Dimension(700, 450));

		b3 = new JButton("Sell");
		b3.addActionListener(this);

		b4 = new JButton("Reset");
		b4.addActionListener(this);

		JPanel panelTemp1 = new JPanel();
		panelTemp1.setLayout(new GridLayout(1, 2));

		JPanel butt1 = new JPanel();
		JPanel butt2 = new JPanel();

		JPanel p2temp = new JPanel();
		JPanel p3temp = new JPanel();

		p3temp.setLayout(new BorderLayout());
		p2temp.setLayout(new BorderLayout());

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));

		p2.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;

		gbc.anchor = GridBagConstraints.LINE_START;

		p2.add(new JLabel("Symbol"), gbc);
		gbc.gridy = gbc.gridy + 2;

		p2.add(new JLabel("Quantity"), gbc);

		gbc.gridy = gbc.gridy + 2;

		p2.add(new JLabel("Price"), gbc);

		symbolSell = new JTextField(8);
		symbolSell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (symbolSell.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid Input!, you must enter in a symbol");

				}

			}
		});

		numSharesSell = new JTextField(6);
		numSharesSell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				flag = 1;
				
				try{
					validateFormatShares(numSharesSell.getText(), numSharesSell);
					
				}
				catch (QuantityFormatException e1)
				{
				       
				}
				
				flag = 0;

			}
		});

		priceSell = new JTextField(6);
		priceSell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				try{
					validateFormatPrice(priceSell.getText(), priceSell);
					
				}
				catch (PriceFormatException e1)
				{
				       
				}
				flag = 0;
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 0;

		gbc.anchor = GridBagConstraints.LINE_START;
		p2.add(symbolSell, gbc);
		gbc.gridy = gbc.gridy + 2;

		p2.add(numSharesSell, gbc);

		gbc.gridy = gbc.gridy + 2;
		p2.add(priceSell, gbc);

		// adding b1 to first panel
		butt1.add(b3, BorderLayout.SOUTH);
		// adding b2 second panel
		butt2.add(b4, BorderLayout.SOUTH);

		// adding both panels to big panel
		p3.add(butt1);
		p3.add(butt2);

		JLabel lab1 = new JLabel("Selling an Investment", SwingConstants.LEFT);
		lab1.setFont(new Font("Serif", Font.ITALIC, 16));
		p3temp.add(lab1, BorderLayout.WEST);

		panelTemp1.add(p2);
		panelTemp1.add(p3);

		JLabel lab = new JLabel("Messages...", SwingConstants.LEFT);
		lab.setFont(new Font("Serif", Font.ITALIC, 16));

		p2temp.add(lab, BorderLayout.SOUTH);

		textSell = new JTextArea(13, 40);
		textSell.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textSell.setEditable(false);

		JScrollPane scroll = new JScrollPane(textSell);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		panel.add(p3temp);
		panel.add(panelTemp1);
		panel.add(p2temp);
		panel.add(scroll);

		Sellwindow.add(panel);

	}

	public static void validateFormatShares(String message, JTextField textField) throws QuantityFormatException {

		boolean done = false;
		int sharesNum;
		try {
			sharesNum = Integer.parseInt(message);

			done = true;

		} catch (NumberFormatException e) {
			if (flag == 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
				//throw new QuantityFormatException("Invalid Input");
				
			} else {
				
				//throw new QuantityFormatException("Invalid Input for Quantity\n");
				textBuy.append("Invalid Input for Quantity\n");
				textSell.append("Invalid Input for Quantity\n");
			}
			textField.setText("");

		}

		if (done == true) {

			sharesNum = Integer.parseInt(message);
			if (sharesNum <= 0) {

				try {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input, you must enter in at least one share:");
					} else {
						textBuy.append("Invalid Input for Quantity,  you must enter in at least one share\n");
						textSell.append("Invalid Input for Quantity,  you must enter in at least one share\n");
						//throw new QuantityFormatException("Invalid Input for Quantity,  you must enter in at least one share\n");
						
					}
					textField.setText("");

				} catch (NumberFormatException e) {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					} else {
						textBuy.append("Invalid Input for Quantity\n");
						textSell.append("Invalid Input for Quantity\n");
						
						//throw new QuantityFormatException("Invalid Input for Quantity\n");
						

					}

				}
			}

		}

	}

	public static boolean validateFormatSharesLoss(String message, JTextField textField) {

		boolean done = false;
		boolean warning = false;
		int sharesLoss = 0;
		try {
			sharesLoss = Integer.parseInt(message);

			done = true;

		} catch (NumberFormatException e) {

			if (flag == 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
			} else {
				textSell.append("Invalid Input for Quantity you want to sell\n");
			}
			textField.setText("");

		}

		if (done == true) // if its an int
		{

			sharesLoss = Integer.parseInt(message);
			if (sharesLoss <= 0) {

				warning = true;

				try {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input, you must enter in at least one share:");
					} else {
						textSell.append(
								"Invalid Input for Quantity you want to sell,  you must enter in at least one share\n");
					}
					textField.setText("");

				} catch (NumberFormatException e) {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					} else {
						textSell.append("Invalid Input for Quantity you want to sell\n");

					}

				}
			}

		}

		if (warning == false && symbolFlag == true) // if nothing is wrong with
													// number and something in
													// symbol
		{

			for (int x = 0; x < Portfolio.investAdd.size(); x++) {
				if (symbolSell.getText().equals(Portfolio.investAdd.get(x).symbol)) {

					if (sharesLoss > Portfolio.investAdd.get(x).sharesNum) {
						warning = true;
						textSell.append("Invalid Input, shares entered exceeded limit amount\n");
						numSharesSell.setText("");

					}

				}

			}

		}

		return warning;
	}

	public static boolean validateFormatPrice(String message, JTextField textField) throws PriceFormatException {
		boolean done = false;
		double tempPrice;
		int validate = 0;
		try {
			tempPrice = Double.parseDouble(message);

			done = true;

		} catch (NumberFormatException e) {
			if (flag == 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
			} else {
				textBuy.append("Invalid Input for price\n");
				textSell.append("Invalid Input for price\n");
				textUpdate.append("Invalid Input for price\n");
				//throw new PriceFormatException("Invalid Input for price\n");
			}
			
			System.out.println("AFTER");
			textField.setText("");
			validate = 1;
		}

		if (done == true) {

			tempPrice = Double.parseDouble(message);
			if (tempPrice <= 0.0) {

				try {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input, can't have a neg price or 0 value");
					} else {
						textBuy.append("Invalid Input for price, can't have a neg price or 0 value\n");
						textSell.append("Invalid Input for price, can't have a neg price or 0 value\n");
						textUpdate.append("Invalid Input for price, can't have a neg price or 0 value\n");
						
						//throw new PriceFormatException("Invalid Input for price, can't have a neg price or 0 value\n");
					}
					textField.setText("");
					validate = 1;

				} catch (NumberFormatException e) {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					} else {
						//text.append("Invalid input for price\n");
						textBuy.append("Invalid Input for price\n");
						textSell.append("Invalid Input for price\n");
						textUpdate.append("Invalid Input for price\n");
						
						//throw new PriceFormatException("Invalid Input for price\n");
					}

					validate = 1;
				}
			}

		}

		if (validate == 1) {
			return false;
		}

		else {
			return true;
		}
	}

	public static boolean validateFormatRangePrice(String message, JTextField textField) {
		boolean done = false;
		double tempPrice;
		int validate = 0;
		try {
			tempPrice = Double.parseDouble(message);

			done = true;

		} catch (NumberFormatException e) {
			if (flag == 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
			}

			else if (flagH == 1) {
				textSearch.append("Invalid Input for High Price\n");

			}

			else if (flagL == 1) {
				textSearch.append("Invalid Input for Low Price\n");

			}

			else {
				textBuy.append("Invalid Input for price\n");
				textSell.append("Invalid Input for price\n");
				textUpdate.append("Invalid Input for price\n");
				textField.setText("");
			}

			validate = 1;
		}

		if (done == true) {

			tempPrice = Double.parseDouble(message);
			if (tempPrice <= 0.0) {

				try {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input, can't have a neg price or 0 value");
					}

					else if (flagH == 1) {
						textSearch.append("Invalid Input for High Range, can't have a neg price or 0 value\n");
					}

					else if (flagL == 1) {
						textSearch.append("Invalid Input for Low Range, can't have a neg price or 0 value\n");
					}

					else {
						textBuy.append("Invalid Input for price, can't have a neg price or 0 value\n");
						textSell.append("Invalid Input for price, can't have a neg price or 0 value\n");
						textUpdate.append("Invalid Input for price, can't have a neg price or 0 value\n");
						textField.setText("");
					}

					validate = 1;

				} catch (NumberFormatException e) {
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}

					else if (flagH == 1) {
						textSearch.append("Invalid Input for High Price\n");

					}

					else if (flagL == 1) {
						textSearch.append("Invalid Input for Low Price\n");

					}

					else {
						textBuy.append("Invalid Input for price\n");
						textSell.append("Invalid Input for price\n");
						textUpdate.append("Invalid Input for price\n");

					}

					validate = 1;
				}
			}

		}

		if (validate == 1) {
			return false;
		}

		else {
			return true;
		}
	}

	public static void clear() {
		symbolBuy.setText("");
		compNameBuy.setText("");
		numSharesBuy.setText("");
		priceBuy.setText("");

	}

	public static void clearSell() {
		symbolSell.setText("");
		numSharesSell.setText("");
		priceSell.setText("");

	}

	public static void clearUpdate() {
		symbolUpdate.setText("");
		compNameUpdate.setText("");
		lowPrice.setText("");
		highPrice.setText("");

	}

	public static void ClearTextAreas() {
		textBuy.setText("");
		textSell.setText("");
		textUpdate.setText("");
		textGain.setText("");
		textSearch.setText("");

	}

	public static void CheckBuy() {
		if (symbolBuy.getText().isEmpty()) {

			textBuy.append("Invalid Choice, you must enter in a symbol\n");

		}
		if (compNameBuy.getText().isEmpty()) {
			textBuy.append("Invalid Choice, you must enter in a company name\n");

		}

		try {
			validateFormatShares(numSharesBuy.getText(), numSharesBuy);
		} catch (QuantityFormatException e) {

			textBuy.append(e.getMessage());
			textSell.append(e.getMessage()); // print message that's passed in
												// super
		}

		
		try {
			validateFormatPrice(priceBuy.getText(), priceBuy);

		} catch (PriceFormatException e) {
			textBuy.append(e.getMessage());
			textSell.append(e.getMessage());
			textUpdate.append(e.getMessage());
		}
		
	}

	public static boolean CheckSell() {

		boolean warn = true;
		symbolFlag = true;

		if (symbolSell.getText().isEmpty()) {

			textSell.append("Invalid Choice, you must enter in a symbol\n");
			symbolFlag = false;

		}
	
		warn = validateFormatSharesLoss(numSharesSell.getText(), numSharesSell);
		
		try {
			validateFormatPrice(priceSell.getText(), priceSell);

		} catch (PriceFormatException e) {
			textBuy.append(e.getMessage());
			textSell.append(e.getMessage());
			textUpdate.append(e.getMessage());
		}

		return warn;

	}

	public static void CheckUpdate() {

		try {
			validateFormatPrice(priceUpdate.getText(), priceUpdate);

		} catch (PriceFormatException e) {
			textBuy.append(e.getMessage());
			textSell.append(e.getMessage());
			textUpdate.append(e.getMessage());
		}

	}

	public static int CheckSearchPart1() {
		int check = 3;
		flagH = 1;

		if (highPrice.getText().length() != 0) // if something was written in price field
		{

			boolean mark = validateFormatRangePrice(highPrice.getText(), highPrice);

			if (mark == false) // error!
			{
				check = 0;
			} else // no error for High Price
			{
				check = 1;

			}

		}

		flagH = 0;
		return check;
	}

	public static int CheckSearchPart2() {
		int check = 3;
		flagL = 1;

		if (lowPrice.getText().length() != 0) {

			boolean mark = validateFormatRangePrice(lowPrice.getText(), lowPrice);

			if (mark == false) {
				check = 0;
			} else // no error for Low price
			{
				check = 2;

			}

		}
		flagL = 0;
		return check;

	}

	public static void Adjust(int x, JButton b5, JButton b6, JButton b7) {

		try {

			if (x < 0) {
				x = 0;
			}

			else if (x >= Portfolio.investAdd.size()) {
				x = Portfolio.investAdd.size() - 1;
			}

			if (Portfolio.investAdd.size() == 0) {
				textUpdate.append("No current Investments");
				b6.setVisible(false); // next button
				b5.setVisible(false);
				b7.setVisible(false);

			}

			else if (x == Portfolio.investAdd.size() - 1) // if x reached max next button will turn invisible
			{
				if (Portfolio.investAdd.size() == 1) {
					b6.setVisible(false); // next button
					b5.setVisible(false);
				} else {
					b6.setVisible(false); // next button
					b5.setVisible(true);
				}
			}

			else if (x == 0) // if x reached lowest prev button will turn invisible
			{
				b5.setVisible(false);// prev is false
				b6.setVisible(true); // next is true
			}

			else// normal
			{
				b6.setVisible(true);
				b5.setVisible(true);
			}

			Investment.Increment(Portfolio.investAdd, x);

		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void SearchElements() {

		ArrayList<Double> array = new ArrayList<Double>();
		int below = 0;
		int above = 0;
		int between = 0;
		int exact = 0;
		int set = 0;
		textSearch.setText("");
		
		int excuteHigh = CheckSearchPart1(); // only runs if length != 0 to find price
												
		int excuteLow = CheckSearchPart2();// only runs if length != 0 to find price
											

		if (excuteHigh == 1 && excuteLow == 2) {
			double low = Double.parseDouble(lowPrice.getText());
			double high = Double.parseDouble(highPrice.getText());

			if (low > high) {
				textSearch.append("Invalid Input, 'Lower Range' cannot be greater than 'Higher Range'");
			}

			else if (low == high) // exactness
			{
				array.add(0, low);

				set = 1;

				exact = 1;
			}

			else // between
			{

				array.add(0, low);
				array.add(1, high);

				between = 1;

				set = 1;

			}

		}

		else if (excuteHigh == 1 && lowPrice.getText().length() == 0)
		{
			double high = Double.parseDouble(highPrice.getText());

			array.add(0, high);

			below = 1; // change this to above

			set = 1;

		}

		else if (excuteLow == 2 && highPrice.getText().length() == 0)
		{
			double low = Double.parseDouble(lowPrice.getText());
			array.add(0, low);

			above = 1; // change this to below

			set = 1;
		}

		if (set == 1 || (lowPrice.getText().length() == 0 && highPrice.getText().length() == 0))
		{

			try {
				Portfolio.CommandSearch(array, above, below, between, exact); 

			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}


class QuantityFormatException extends Exception
{
	
	public QuantityFormatException(String string)
	{
		super(string);
	}
	
}

class PriceFormatException extends Exception
{
	
	public PriceFormatException(String string)
	{
		super(string);
	}
	
}




