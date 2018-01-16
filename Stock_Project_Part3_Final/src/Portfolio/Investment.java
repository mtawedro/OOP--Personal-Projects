package Portfolio;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Investment {
	
	String symbol;
	String Name;
	int sharesNum;
	double price;
	double bookValue;

	/**
	 * Original Constructor
	 * 
	 * @param String compSymbol
	 * @param String compName
	 * @param Integer shares
	 * @param double stockPrice
	 * @param double book
	 */
	
	public Investment(String compSymbol, String compName, int shares, double stockPrice, double book) {

		this.symbol = compSymbol;
		this.Name = compName;
		this.sharesNum = shares;
		this.price = stockPrice;
		this.bookValue = book;

	}

	/**
	 * Copy Constructor
	 * 
	 * @param Investment oldInvestment
	 */
	
	public Investment(Investment oldInvestment) {
		this.symbol = oldInvestment.symbol;
		this.Name = oldInvestment.Name;
		this.sharesNum = oldInvestment.sharesNum;
		this.price = oldInvestment.price;
		this.bookValue = oldInvestment.bookValue;
	}
	
	
	/**
	 * Abstract User-defined **Abstract function to generic data by editing updated
	 * Investments with their respected calculations.
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 * 
	 * @param String choiceSymbol.
	 * 
	 * @param String compName.
	 * 
	 * @param int numShares.
	 * 
	 * @param double newPrice.
	 * 
	 * @return void
	 */
	
	public abstract void CalculateFunds(ArrayList<Investment> investAdd, String choiceSymbol, String compName,
			int numShares, double newPrice) throws NumberFormatException, IOException;
	
	/**
	 * Abstract User defined function which is a continuation of CalculateFunds()
	 * only responsible for adding new investments (not updating them)
	 * 
	 * @param ArrayList<Investment> investAdd
	 * @param String choiceSymbol
	 * @param String compName
	 * @param Integer numShares
	 * @param Double newPrice
	 */
	
	public abstract void AddingNew(ArrayList<Investment> investAdd, String choiceSymbol, String compName, int numShares,
			double newPrice);
		
	/**
	 * Abstract user-defined function that calculates Revenue (Payment) when user sells an
	 * Investment.
	 * 
	 * @param ArrayList<Investment> investAdd
	 * @param String choiceSymbol
	 * @param  int shareLoss
	 */
	
	public abstract void Payment(ArrayList<Investment> investAdd, String choiceSymbol, int shareLoss);


	/**
	 * User-defined function to enable user to sell investments editing updated
	 * prices with their respected calculations and receiving total revenue.
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 * 
	 * @param HashMap<String, HashSet<Integer>> (HashMap).
	 * 
	 * @param String choiceSymbol.
	 * 
	 * @param int shareLoss.
	 * 
	 * @param double newPrice.
	 * 
	 * @return void
	 */

	public static void SellInvestments(HashMap<String, HashSet<Integer>> hm, ArrayList<Investment> investAdd,
			String choiceSymbol, int shareLoss, double newPrice) throws NumberFormatException, IOException {
		FirstWindow.textSell.setText("");

		int flag = 0;
		double comm = 0.00;
		double revenueGained = 0.0;

		for (int x = 0; x < investAdd.size(); x++) {
			
			if (choiceSymbol.equals(investAdd.get(x).symbol)) {
				
				flag = 1;

				if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock")) {

					comm = 9.99;
				}

				else if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund")) {
					comm = 45.00;
				}

				if (shareLoss <= investAdd.get(x).sharesNum) {
					
					investAdd.get(x).price = newPrice; // add new price

					investAdd.get(x).bookValue = (investAdd.get(x).bookValue * (investAdd.get(x).sharesNum - shareLoss))
							/ investAdd.get(x).sharesNum;

					investAdd.get(x).sharesNum = investAdd.get(x).sharesNum - shareLoss;

					revenueGained = ((shareLoss * investAdd.get(x).price) - comm);

					FirstWindow.textSell.append("Revenue Received: $" + revenueGained + "\n");
					FirstWindow.textSell.append("\n");

					if (investAdd.get(x).sharesNum <= 0) {
						investAdd.remove(x);

						// to delete from HashMap
						Portfolio.DeleteIndex(hm, investAdd, x);

					}

				}

			}

		}

		if (flag != 1) {
			FirstWindow.textSell.append("Sorry, investment doesn't exit\n");
			FirstWindow.textSell.append("\n");

		}

	}

	/**
	 * User-defined function to print Investment data dependent on (current
	 * index position) 'Previous' or 'Next' Button user clicked
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 *
	 * @param int x (current index position).
	 * 
	 * @return void
	 */

	public static void updateIncrement(ArrayList<Investment> investAdd, int x)
			throws NumberFormatException, IOException {

		// Just prints each part of investment dependent on x incremention
		if (x >= 0 && x < investAdd.size()) {

			FirstWindow.textUpdate.append(investAdd.get(x).symbol + "\n" + investAdd.get(x).Name + "\n"
					+ "Current Price: $" + investAdd.get(x).price + "\n");

		}

	}

	/**
	 * User-defined function to generic data updated all Investment price with
	 * their respected calculations.
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 * 
	 * @param int x (current index position).
	 * 
	 * @param double updated price.
	 * 
	 * @return void
	 */

	public static void updateInvestmentPrice(ArrayList<Investment> investAdd, double updated, int x)
			throws NumberFormatException, IOException {
		investAdd.get(x).price = updated;

	}

	/**
	 * User-defined function to generic data by adding all gained fees from all
	 * the investments in list.
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 * 
	 * @param amountGained ArrayList.
	 * 
	 * @return void
	 */

	public static void InvestmentGained(ArrayList<Investment> investAdd, ArrayList<Double> amountGained) 
	{

		double totalGained = 0.0;
		int G = 0;
		double amountGain = 0.0;
		double comm = 0.00;

		for (int x = 0; x < investAdd.size(); x++) {

			if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock")) {
				comm = 9.99;

			}

			else if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund")) {
				comm = 45.00;
			}

			amountGain = ((investAdd.get(x).sharesNum * investAdd.get(x).price) - comm) - investAdd.get(x).bookValue;

			amountGained.add(G, amountGain);

			totalGained = totalGained + amountGained.get(G);

			FirstWindow.textGain.append("\n");
			FirstWindow.textGain.append(
					"Symbol: " + investAdd.get(x).symbol + "\nIndividual Gains: $" + amountGained.get(G) + "\n");

			G++;

		}

		FirstWindow.textGain.append("\nTotal Amount Gained: $" + totalGained + "\n");

	}

	/**
	 * User-defined function to represent object MutualFund in a textualized
	 * format.
	 * 
	 * @pre user defined object Investment
	 * 
	 * @return type object
	 */
	public String toString()

	{

		String Data1 = "Symbol:" + this.symbol + "\n" + "Name:" + this.Name + "\n";
		String Data3 = "Number of Shares:" + this.sharesNum + "\n";
		String Data8 = "Price:" + this.price + "\n";
		String Data9 = "Book Value:" + this.bookValue;

		String Data = Data1 + Data3 + Data8 + Data9 + "\n";

		return Data;

	}

	/**
	 * User-defined function to represent object MutualFund in a textualized
	 * format **used for only writing to .txt file.
	 * 
	 * @pre user defined object Investment
	 * 
	 * @return type object
	 */
	public String toString1()

	{
		String Data1 = this.symbol + "," + this.Name + "," + this.sharesNum + "," + this.price + "," + this.bookValue;

		String Data = Data1;

		return Data;

	}

	/**
	 * User-defined function to compare 2 objects and check if they are equal.
	 * 
	 * @pre user defined object Investment
	 * 
	 * @return type boolean
	 */

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Investment other = (Investment) obj;

		if (Double.compare(this.bookValue, other.bookValue) == 0 && Double.compare(this.price, other.price) == 0
				&& Integer.compare(this.sharesNum, other.sharesNum) == 0 && this.symbol.equalsIgnoreCase(other.symbol)
				&& this.Name.equalsIgnoreCase(other.Name)) {
			return true;
		}
		return false;
	}

}
