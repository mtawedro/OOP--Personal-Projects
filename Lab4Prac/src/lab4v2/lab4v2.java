package lab4v2;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/***********************************************
 *Simple demonstration of putting buttons in a JFrame.
 ***********************************************/
public class lab4v2 extends JFrame implements ActionListener
{
  public static final int WIDTH = 300;
  public static final int HEIGHT = 200;

  /*************************************************
   *Creates and displays a window of the class ButtonDemo.
   *************************************************/
  public static void main(String[] args)
  {
	  lab4v2 buttonGui = new lab4v2();
    buttonGui.setVisible(true);
    TextField text = new TextField(20);
    ActionEvent e = null;
    if (e.getActionCommand().equals("1. Add a unique Textbook or Workbook to the inventory")) 
    {
    	 text.setText("Button Clicked ");


    }
   
  }

  public lab4v2()
  {
    setSize(WIDTH, HEIGHT);

   // addWindowListener(new WindowDestroyer()); 
    setTitle("Button Demo"); 
    Container contentPane = getContentPane();
    contentPane.setBackground(Color.blue);
 
    contentPane.setLayout(new FlowLayout());

    
    System.out.println("1. Add a unique Textbook or Workbook to the inventory");
    System.out.println("2. Print out information on each Book");
    System.out.println("3. Print out all unique authors");
    System.out.println("4. Print out the average book price, along with the total number of Books");
    System.out.println("5. Print out all Textbook-Workbook pairs in the inventory");
    System.out.println("6. Save the state of the inventory to a file");
    System.out.println("7. Load the state of the inventory from a file");
    System.out.println("8. Quit");
   
    
    
    
    
    JButton stopButton = new JButton("1. Add a unique Textbook or Workbook to the inventory");
    stopButton.addActionListener(this);
    contentPane.add(stopButton);

    JButton goButton = new JButton("2. Print out information on each Book");
    goButton.addActionListener(this); 
    contentPane.add(goButton);
    
    JButton stopButton5 = new JButton("3. Print out all unique authors");
    stopButton.addActionListener(this);
    contentPane.add(stopButton5);

    JButton go1Button = new JButton("4. Print out the average book price, along with the total number of Books");
    goButton.addActionListener(this); 
    contentPane.add(go1Button);
    
    JButton stopButton1 = new JButton("5. Print out all Textbook-Workbook pairs in the inventory");
    stopButton.addActionListener(this);
    contentPane.add(stopButton1);

    JButton goButton2 = new JButton("6. Save the state of the inventory to a file");
    goButton.addActionListener(this); 
    contentPane.add(goButton2);
    
    JButton stopButton6 = new JButton("7. Load the state of the inventory from a file");
    stopButton.addActionListener(this);
    contentPane.add(stopButton6);


    JButton stopButton7 = new JButton("8. Quit");
    stopButton.addActionListener(this);
    contentPane.add(stopButton7);
    
    
  }
//It will take several subsections to fully explain this program. 
//The explanation does not end until the end of the subsection 
//entitled Action Listeners and Action Events
  public void actionPerformed(ActionEvent e) 
  {
    Container contentPane = getContentPane();

    if (e.getActionCommand().equals("1. Add a unique Textbook or Workbook to the inventory")) 
    {
    	

    }
    else if (e.getActionCommand().equals("Green"))
    {
      contentPane.setBackground(Color.green);
    }
    else
    {
      System.out.println("Error in button interface.");
    }

    
    
    
    
    
    
    }
}