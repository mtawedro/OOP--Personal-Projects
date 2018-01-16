/***************************************
Name: Martina Tawedrous
Date: Oct 16 2017
Email: mtawedro@uoguelph.ca
Student Number: 0977473
***************************************/
Program Discription:

An individual has the ability to have a portfolio that holds different kinds of investments and allows you to buy or sell investments, 
search for some investments, update prices, and compute the total gain of the portfolio. There is a limit to two kinds of investments: 
Stock and MutualFund.  Each investment should have a symbol, a name, a quantity, a price, and a bookValue.  For each stock, there is a need to 
pay commissons when buying or selling shares of the stock and MutualFund, which will affect the values for “quantity” and “bookValue”, and the calculation of the gain of 
the investments.
Command Line is prompted: 
 
(1) buy: own a new investment or add more quantity to an existing investment.    
 
(2) sell: reduce some quantity of an existing investment. 
 
(3) update: refresh the prices of all existing investments. 
 
(4) getGain: compute the total gain of the portfolio by accumulating the gains of all its investments.    
 
(5) search:

(6) Quit:

Test Cases:

Testing with neg Number for adding stocks or selling stocks
Expexted output: Error Check saying it is invalid and letting the user enter in their input again

Testing Command Prompt Symbol, Name, must be entered if not expexted output Error trap will prompt user to enter
until there is its not blank

Testing when user enters in blank for MF OR S, user must enter valid input or Error Trap will prompt user to enter until valid coreectness is mathced

Testing when number of stocks that user wants to sell is greater then user has in stocks, Expexted error tarp will dislay saing limit exceeded 

Testing if user wants to add stock that already exits in list , Expexted user must enter number of shares to exiting stock

Testing is user wants to add same symbol to MutualFund or stock list when it already exits in either or list, Error message will display saying that they cantt 
add it to the list.
