package Portfolio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Portfolio {
	
	int input = 0;
	
	public static HashMap<String, HashSet<Integer>> hm = new HashMap<String, HashSet<Integer>>();
	
	public static ArrayList<Double> amountGained = new ArrayList<Double>();
	public static ArrayList<Investment> investAdd = new ArrayList<Investment>();
	static File fileName = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
			
		@SuppressWarnings("unused")
		FirstWindow fw = new FirstWindow();

		if (args.length > 0) {

			fileName = new File(args[0]);

		} 

		else {
			fileName = new File("myFile.txt");
		}

		
		// pass in argument
		LoadFileIO(investAdd, fileName);

		if (investAdd.size() != 0) {
			// updates HashMap
			HashMap(hm, investAdd);

		}

	}// end of main

	
	public static void CommandCalculateFunds(String typeStock) throws NumberFormatException, IOException {

		// Since Abstract classes are classes which can't be instantiated, the
		// class is extended with it's  methods (if public or protected) and 
	    //	can be called using the objects of derived class.

		// Creating objects of derived classes (MutualFund)(Stock)
		Investment originalMutualFund = new MutualFund(FirstWindow.symbolBuy.getText(),
				FirstWindow.compNameBuy.getText(), Integer.parseInt(FirstWindow.numSharesBuy.getText()),
				Double.parseDouble(FirstWindow.priceBuy.getText()), 0.0);

		Investment originalStock = new Stock(FirstWindow.symbolBuy.getText(), FirstWindow.compNameBuy.getText(),
				Integer.parseInt(FirstWindow.numSharesBuy.getText()),
				Double.parseDouble(FirstWindow.priceBuy.getText()), 0.0);

		// creating cloned Objects of derived classes
		Investment clonedMutualFund = new MutualFund(originalMutualFund);
		Investment clonedStock = new Stock(originalStock);

		if (typeStock.equalsIgnoreCase("MutualFund")) {
			clonedMutualFund.CalculateFunds(investAdd, clonedMutualFund.symbol, clonedMutualFund.Name,
					clonedMutualFund.sharesNum, clonedMutualFund.price);

			// updates
			HashMap(hm, investAdd);

		}

		else if (typeStock.equalsIgnoreCase("Stock")) {
			clonedStock.CalculateFunds(investAdd, clonedStock.symbol, clonedStock.Name, clonedStock.sharesNum,
					clonedStock.price);

			// updates
			HashMap(hm, investAdd);
		}

	}

	public static void CommandSellFunds() throws NumberFormatException, IOException {

		Investment.SellInvestments(hm, investAdd, FirstWindow.symbolSell.getText(),
				Integer.parseInt(FirstWindow.numSharesSell.getText()),
				Double.parseDouble(FirstWindow.priceSell.getText()));
	
		// prints
		for (int x = 0; x < investAdd.size(); x++) {
			FirstWindow.textSell.append(investAdd.get(x).toString() + "\n");
		}

	}

	public static void CommandUpdateFunds(int y) throws NumberFormatException, IOException {

		Investment.updateInvestmentPrice(investAdd, Double.parseDouble(FirstWindow.priceUpdate.getText()), y);

		// prints
		FirstWindow.textUpdate.append(investAdd.get(y).toString() + "\n");

	}

	public static void CommandGainedFunds() throws NumberFormatException, IOException {

		Investment.InvestmentGained(investAdd, amountGained);

	}

	public static void CommandSearch(ArrayList<Double> array, int above, int below, int between, int exact)
			throws NumberFormatException, IOException

	{
		Search(hm, investAdd, FirstWindow.symbolSearch.getText(), FirstWindow.compNameSearch.getText(),
				FirstWindow.lowPrice.getText(), FirstWindow.highPrice.getText(), array, above, below, between, exact);

	}

	// writes to the file once user quits
	public static void CommandSave(String typeStock) throws NumberFormatException, IOException {
		FileIO(investAdd, fileName);

	}

	/**
	 * User-defined function to generic data by taking a search word from user
	 * depending on what fields user will enter (HashMap) is used when user
	 * enters in company name. Range/Symbol also took into consideration .
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashMap<String, HashSet <Integer>> (HashMap)
	 * 
	 * @return void
	 */

	public static void Search(HashMap<String, HashSet<Integer>> hm, ArrayList<Investment> investAdd,
			String choiceSymbol, String compName, String lowPrice, String highPrice, ArrayList<Double> array, int above,
			int below, int between, int exact) {
		FirstWindow.textSearch.setText("");

		int flag = 0;

		FirstWindow.textSearch.append("Search-------------------------\n");

		HashSet<Integer> determine;

		// if nothing is entered                                    ..range
		if (choiceSymbol.length() == 0 && compName.length() == 0 && lowPrice.length() == 0 && highPrice.length() == 0) {

			for (int x = 0; x < investAdd.size(); x++) {

				FirstWindow.textSearch.append(investAdd.get(x).toString() + "\n");
			}

			flag = 1;

		}

		// if symbol is only entered
		else if (choiceSymbol.length() != 0 && compName.length() == 0 && lowPrice.length() == 0
				&& highPrice.length() == 0) {

			for (int j = 0; j < investAdd.size(); j++) {
				if (choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol)) {
					FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
				}

			}

			flag = 1;

		}

		// if company name is only entered
		else if (choiceSymbol.length() == 0 && compName.length() != 0 && lowPrice.length() == 0
				&& highPrice.length() == 0) {

			determine = IntersectionCheck(hm, investAdd, compName);

			// prints
			for (int x = 0; x < determine.size(); x++) {

				ArrayList<Integer> arr = new ArrayList<Integer>(determine);

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");
			}

			flag = 1;
		}

		// if company name and symbol name is entered
		else if (choiceSymbol.length() != 0 && compName.length() != 0 && lowPrice.length() == 0
				&& highPrice.length() == 0) {
			determine = IntersectionCheck(hm, investAdd, compName);

			symbol(determine, investAdd, choiceSymbol);

			flag = 1;

		}

		
		
		if (flag != 1) {

			for (int j = 0; j < investAdd.size(); j++) {
				/**
				 * company and range is entered , will call IntersectionCheck
				 * (uses HashMap to find comp key indexes that are common)
				 * returns HashSet of common indexes and passes that to Below(),
				 * Above(), Between(), or Exact() which evaluate range dependent
				 * on user input and checks if both company and range matches
				 * the conditions user inputed
				 ***********************/

				if (choiceSymbol.length() == 0 && compName.length() != 0 && below == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					below(determine, investAdd, array, j);
					break;

				}

				else if (choiceSymbol.length() == 0 && compName.length() != 0 && above == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					above(determine, investAdd, array, j);
					break;

				}

				else if (choiceSymbol.length() == 0 && compName.length() != 0 && between == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					between(determine, investAdd, array, j);
					break;

				}

				else if (choiceSymbol.length() == 0 && compName.length() != 0 && exact == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					exact(determine, investAdd, array, j);
					break;

				}

				/**
				 * symbol and range is entered, will compare symbol name and
				 * price range user entered with current symbol name and price
				 * in Investment array and iterates until symbols are equal and
				 * range conditions are matched
				 ***********************/
				else if (choiceSymbol.length() != 0 && compName.length() == 0 && below == 1) {

					if (choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol)
							&& (investAdd.get(j).price <= array.get(0))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");

					}

				}

				else if (choiceSymbol.length() != 0 && compName.length() == 0 && above == 1) {

					if (choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol)
							&& (investAdd.get(j).price >= array.get(0))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				else if (choiceSymbol.length() != 0 && compName.length() == 0 && between == 1) {

					if (choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol)
							&& ((array.get(0) <= investAdd.get(j).price)
									&& (investAdd.get(j).price <= array.get(0 + 1)))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				else if (choiceSymbol.length() != 0 && compName.length() == 0 && exact == 1) {

					if (choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol)
							&& ((array.get(0) == investAdd.get(j).price))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				/**
				 * range is entered, will compare price range user entered with
				 * price in Investment array and iterates until range conditions
				 * are satisfied
				 ***********************/

				else if (choiceSymbol.length() == 0 && compName.length() == 0 && below == 1) {

					if ((investAdd.get(j).price <= array.get(0))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				else if (choiceSymbol.length() == 0 && compName.length() == 0 && above == 1) {

					if ((investAdd.get(j).price >= array.get(0))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				else if (choiceSymbol.length() == 0 && compName.length() == 0 && between == 1) {

					if (((array.get(0) <= investAdd.get(j).price) && (investAdd.get(j).price <= array.get(0 + 1)))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				else if (choiceSymbol.length() == 0 && compName.length() == 0 && exact == 1) {

					if (((array.get(0) == investAdd.get(j).price))) {

						FirstWindow.textSearch.append(investAdd.get(j).toString() + "\n");
					}

				}

				/**
				 * company, symbol, range is entered , will call
				 * IntersectionCheck (uses HashMap to find comp key indexes that
				 * are common) returns HashSet of common indexes and passes that
				 * to symbolRangeBelow(), symbolRangeAbove(),
				 * symbolRangeBetween(), or symbolRangeExact() which evaluate
				 * ranges dependent if Below, Above, Between, or Exact ranges
				 * along with compare symbol name and checks if both company,
				 * symbol and range matches the conditions user inputed
				 ***********************/

				else if (choiceSymbol.length() != 0 && compName.length() != 0 && below == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					symbolRangeBelow(determine, investAdd, choiceSymbol, array, j);
					break;

				}

				else if (choiceSymbol.length() != 0 && compName.length() != 0 && above == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					symbolRangeAbove(determine, investAdd, choiceSymbol, array, j);
					break;

				}

				else if (choiceSymbol.length() != 0 && compName.length() != 0 && between == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					symbolRangeBetw(determine, investAdd, choiceSymbol, array, j);
					break;

				}

				else if (choiceSymbol.length() != 0 && compName.length() != 0 && exact == 1) {

					determine = IntersectionCheck(hm, investAdd, compName);

					symbolRangeExact(determine, investAdd, choiceSymbol, array, j);
					break;

				}

			} // end of Investment loop

		}

	}

	/**
	 * User-defined function to write data(all investments) from Investment
	 * array list to a .txt file
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment arrayList.
	 * 
	 * @return void
	 */

	public static void FileIO(ArrayList<Investment> investAdd, File fileName) {
		String tempVar = null;

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			for (int x = 0; x < investAdd.size(); x++) {

				if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock")) {
					tempVar = "stock,";
				}

				else if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund")) {
					tempVar = "mutualfund,";
				}

				writer.write(tempVar);

				writer.write(investAdd.get(x).toString1() + "\r\n");

			}

			JOptionPane.showMessageDialog(null, "      Sucessfully Saved");

			writer.close();
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Failed to write to " + fileName + ".");

		}

	}

	/**
	 * User-defined function to load data(all investments) from .txt file back
	 * into Investment array list
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment arrayList.
	 * 
	 * @return void
	 */

	public static void LoadFileIO(ArrayList<Investment> investAdd, File fileName) {
		
		int countTok = 0;
		int i = 0;
		ArrayList<String> tempInvest = new ArrayList<String>();

		investAdd.clear();

		// Read the file
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			/*
			 * by parsing each word separated by comma's in line and checks
			 * whether it's stocks or mutual funds, calls corresponding
			 * constructor and stores investment into Investment array list
			 **/
			while (line != null) {

				String del = ",";

				StringTokenizer split = new StringTokenizer(line, del);

				while (split.hasMoreTokens()) {

					String tok = split.nextToken();
					tempInvest.add(countTok, tok);

					countTok++;

				}

				if (tempInvest.get(0).equals("stock")) // Stock
				{

					Stock temp = new Stock(tempInvest.get(1), tempInvest.get(2), Integer.parseInt(tempInvest.get(3)),
							Double.parseDouble(tempInvest.get(4)), Double.parseDouble(tempInvest.get(5)));

					investAdd.add(i, temp);

					i++;
					countTok = 0;

				}

				else if (tempInvest.get(0).equals("mutualfund"))// MutualFund
				{

					MutualFund temp = new MutualFund(tempInvest.get(1), tempInvest.get(2),
							Integer.parseInt(tempInvest.get(3)), Double.parseDouble(tempInvest.get(4)),
							Double.parseDouble(tempInvest.get(5)));

					investAdd.add(i, temp);
					i++;

					countTok = 0;

				}

				line = reader.readLine();
			}

			System.out.println("Succesfully Loaded");

			reader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to read " + fileName + ".");

		}

	}

	/**
	 * User-defined function to generic data by parsing each company name,
	 * places each company key in Hashmap and maps to its corresponding indexes
	 * that occur in array list
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashMap<String, HashSet <Integer>> (HashMap)
	 * 
	 * @return void
	 */

	public static void HashMap(HashMap<String, HashSet<Integer>> hm, ArrayList<Investment> investAdd)
			throws NumberFormatException, IOException {

		int count = 0;

		ArrayList<String> tempArray = new ArrayList<String>();

		HashSet<Integer> array = new HashSet<Integer>();

		String del = ", .;:!-?";
		String key;

		// parses each company name into array, places them in HashMap first
		for (int x = 0; x < investAdd.size(); x++) {

			StringTokenizer split = new StringTokenizer(investAdd.get(x).Name, del);

			while (split.hasMoreTokens()) {
				String tok = split.nextToken();
				String upper = tok.toUpperCase();
				tempArray.add(count, upper);
				hm.put(upper, array); // indexArray (nothing)

				count++;

			}

		}

		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();

		tempArray.clear();

		while (it.hasNext()) {

			HashSet<Integer> array1 = new HashSet<Integer>();
			key = it.next();
			count = 0;

			for (int x = 0; x < investAdd.size(); x++) {
				/**********
				 * splits each company name into tokens investment by investment
				 *************/

				StringTokenizer split = new StringTokenizer(investAdd.get(x).Name, del);

				while (split.hasMoreTokens()) {
					String tok = split.nextToken();
					String upper = tok.toUpperCase();
					tempArray.add(count, upper);

					count++;

				}

				for (int i = 0; i < tempArray.size(); i++) {
					/**
					 * if key word equals the parsed company name add index it
					 * found it at to HashSet (with no repeated elements)
					 */

					if (key.equalsIgnoreCase(tempArray.get(i))) {
						array1.add(x);

						break;

					}

				}

				count = 0;
				tempArray.clear();

			} // end of inner for

			hm.put(key, array1);

		} // end of outer while

	} // end of void

	/**
	 * User-defined function (used for search purposes) that uses HashMap to
	 * match the companyName (user entered for search) (parsed company name )
	 * with each key and if keys matched in Hashmap -> get content in set-> find
	 * indexes that are common to both key words mapped (in set))
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashMap<String, HashSet <Integer>> (HashMap)
	 * 
	 * @param String CompName (user entered for search)
	 * 
	 * @return HashSet<Integer> HashSet of common indexes with (respect to company name user entered )
	 */

	public static HashSet<Integer> IntersectionCheck(HashMap<String, HashSet<Integer>> hm,
			ArrayList<Investment> investAdd, String compName) {

		int counter = 0;
		int intersectionFlag = 0;
		ArrayList<String> tempArray1 = new ArrayList<String>();

		ArrayList<Integer> newArray = new ArrayList<Integer>();

		HashSet<Integer> intersection = new HashSet<Integer>();
		String del = ", .;:!-?";

		String choice = compName.toUpperCase();

		// splits company name tok into temp array
		StringTokenizer split = new StringTokenizer(choice, del);

		while (split.hasMoreTokens()) {

			String tok = split.nextToken();
			tempArray1.add(counter, tok);

			counter++;

		}

		for (int x = 0; x < tempArray1.size(); x++) {

			if (hm.containsKey(tempArray1.get(x)) == false) {
				intersectionFlag = 1;
				continue;
			}

			HashSet<Integer> content = hm.get(tempArray1.get(x));

			ArrayList<Integer> arr = new ArrayList<Integer>(content);

			for (int j = 0; j < arr.size(); j++) {
				newArray.add(arr.get(j));
			}

		}

		/*
		 * Nested loop: gets index in array Inner Loop: compares index with
		 * every index after in array (i + 1) , if index matches grabs index in
		 * set and puts in into intersection set (prevents repeated indexes)
		 **/

		for (int i = 0; i < newArray.size(); i++) {

			// A key word was found that didn't exist in HashTable
			if (intersectionFlag == 1) 
			{
				break;
			}

			if (newArray.size() == 1 || tempArray1.size() == 1) {
				for (int x = 0; x < newArray.size(); x++) {

					intersection.add(newArray.get(x));
				}

				break;
			}

			for (int l = i + 1; l < newArray.size(); l++) {
				if (newArray.get(i) == newArray.get(l)) {
					intersection.add(newArray.get(l));

				}
			}

		}

		return intersection;

	}

	/**
	 * User-defined function to delete specific investment array along with
	 * deleting the corresponding index in HashMap with subtracting one -->
	 * indexes that are higher
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashMap<String,HashSet <Integer>> (HashMap)
	 * 
	 * @param int index
	 * 
	 * @return void
	 */

	public static void DeleteIndex(HashMap<String, HashSet<Integer>> hm, ArrayList<Investment> investAdd, int index)
			throws NumberFormatException, IOException {

		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();

		it = keys.iterator();

		while (it.hasNext()) {

			String key = it.next();
			HashSet<Integer> content = hm.get(key);

			ArrayList<Integer> arr = new ArrayList<Integer>(content);

			for (int i = 0; i < arr.size(); i++) {

				if (arr.get(i) == index) {

					// remove inside set
					content.remove(arr.get(i));

					if (content.size() == 0) {
						// removes whole key -> set
						it.remove();
					}

				}
			}

		} // end of while

		it = keys.iterator();

		while (it.hasNext()) {

			String key = it.next();
			HashSet<Integer> content = hm.get(key);

			ArrayList<Integer> arr = new ArrayList<Integer>(content);

			for (int i = 0; i < arr.size(); i++) {

				if (arr.get(i) > index) {
					arr.set(i, arr.get(i) - 1);
					HashSet<Integer> arr1 = new HashSet<Integer>(arr);
					hm.put(key, arr1);

				}

			}

		} // end of while

	}// end of function

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares price below range ex. '-80'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */

	public static void below(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array,
			int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (investAdd.get(arr.get(x)).price <= array.get(0)) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");
			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares price above range ex. '80-'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */

	public static void above(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array,
			int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (investAdd.get(arr.get(x)).price >= array.get(0)) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");
			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares price between range ex. '80-90'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */

	public static void between(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array,
			int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (((array.get(0) <= investAdd.get(arr.get(x)).price)
					&& (investAdd.get(arr.get(x)).price <= array.get(0 + 1)))) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");
			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares price within exact range ex. '80'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */
	public static void exact(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array,
			int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (((array.get(0) == investAdd.get(arr.get(x)).price))) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");
			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares symbols for exactness
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param String choiceSymbol
	 * 
	 * @return void
	 */

	public static void symbol(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol)) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");

			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares symbols for exactness and and compares price
	 * below range ex. '-80'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param String choiceSymbol
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */

	public static void symbolRangeBelow(HashSet<Integer> intersection, ArrayList<Investment> investAdd,
			String choiceSymbol, ArrayList<Double> array, int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol)
					&& investAdd.get(arr.get(x)).price <= array.get(0)) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");

			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares symbols for exactness and and compares price
	 * above range ex. '80-'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param String choiceSymbol
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */
	public static void symbolRangeAbove(HashSet<Integer> intersection, ArrayList<Investment> investAdd,
			String choiceSymbol, ArrayList<Double> array, int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol)
					&& investAdd.get(arr.get(x)).price >= array.get(0)) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");

			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares symbols for exactness and and compares price
	 * between ranges ex. '80-90'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param String choiceSymbol
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */

	public static void symbolRangeBetw(HashSet<Integer> intersection, ArrayList<Investment> investAdd,
			String choiceSymbol, ArrayList<Double> array, int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol)
					&& ((array.get(0) <= investAdd.get(arr.get(x)).price)
							&& (investAdd.get(arr.get(x)).price <= array.get(0 + 1)))) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");

			}

		}

	}

	/**
	 * User-defined function(called from search()) that iterates through
	 * intersection set (set that has the common indexes from searching for
	 * company name) and compares symbols for exactness and and compares price
	 * within exact range ex. '80'
	 * 
	 * @pre user defined arrayList for type Investment and updated HashMap
	 * 
	 * @param Investment arrayList.
	 * 
	 * @param HashSet<Integer> intersection
	 * 
	 * @param String choiceSymbol
	 * 
	 * @param int j -> current position in investment array
	 * 
	 * @param ArrayList<Double> array -> have parsed ranges #
	 * 
	 * @return void
	 */
	
	public static void symbolRangeExact(HashSet<Integer> intersection, ArrayList<Investment> investAdd,
			String choiceSymbol, ArrayList<Double> array, int j) {

		for (int x = 0; x < intersection.size(); x++) {

			ArrayList<Integer> arr = new ArrayList<Integer>(intersection);

			if (choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol)
					&& ((array.get(0) == investAdd.get(arr.get(x)).price))) {

				FirstWindow.textSearch.append(investAdd.get(arr.get(x)).toString() + "\n");

			}

		}

	}

}
