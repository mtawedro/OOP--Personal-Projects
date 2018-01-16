/***************************************
Name: Martina Tawedrous
Date: November 16 2017
Email: mtawedro@uoguelph.ca
Student Number: 0977473
***************************************/
Program Discription:

A simplified version of assignment 1 code with added improvements. In particular, a super class is created for all stocks and mutual funds, and reduce 
the two ArrayLists into one in order to minimize the code redundancy.  Additionally, the existing investments are loaded from a file and save all investments 
(existing plus new) back to the file every time the run your program is ran.  Finally, a HashMap for the name keywords so that the search performance can be greatly
improved. **Discription of program functionality**: An individual has the ability to have a portfolio that holds different kinds of investments and allows you to buy or sell 
investments, search for some investments, update prices, and compute the total gain of the portfolio. There is a limit to two kinds of investments: 
Stock and MutualFund.  Each investment should have a symbol, a name, a quantity, a price, and a bookValue.  For each stock, there is a need to 
pay commissons when buying or selling shares of the stock and MutualFund, which will affect the values for “quantity” and “bookValue”, and the calculation of the 
gain of the investments.
Command Line is prompted: 
 
(1) buy: own a new investment or add more quantity to an existing investment.    
 
(2) sell: reduce some quantity of an existing investment. 
 
(3) update: refresh the prices of all existing investments. 
 
(4) getGain: compute the total gain of the portfolio by accumulating the gains of all its investments.    
 
(5) search:

(6) Quit

**** Everything is saved and written to the file when user quits the program!!****
Assumptions:
IMPORTANT -> (Test: 16) Testing for searches-> if ex. BANK OF CANADA & BANK OF TORONTO already exisit in investments list, when user wants to search for 
BANK OF TORONTO, BANK OF CANADA & BANK OF TORONTO are returned because of the key word 'OF' it is both present in the company names "BANK OF CANADA" and
"BANK OF TORONTO", therefore it will return both occurances
 
Test Cases:

(Test: 1) 
Testing a neg number or 0 for price and quantity or invalid symbols/asci characters for adding investments and/or selling stocks
Expexted output: Error Check saying it is invalid and letting the user enter in their input again
(Test: 2) 
Testing Command Prompt Symbol, Name, must be entered if not expexted output Error trap will prompt user to enter
until there is its not blank
(Test: 3) 
Testing when user enters in blank for MF OR S, user must enter valid input or Error Trap will prompt user to enter until valid correctness is mathced
(Test: 4)
Testing when user enters in blank for A OR B,(for option 1) user must enter valid input or Error Trap will prompt user to enter until valid correctness is mathced
(Test: 5)
Testing when number of stocks that user wants to sell is greater then user has in stocks, Expexted error tarp will dislay saing limit exceeded 
(Test: 6)
Testing if user wants to add stock that already exits in list , Expexted user must enter number of shares to exiting stock
(Test: 7)
Testing is user wants to add same symbol to MutualFund or stock list when it already exits in either or list, Error message will display saying that they cantt 
add it to the list.
(Test: 8)
Testing if user wants to add more quantity to an existing investment if no investments exits,  Error message will display saying that no investments exits and user
will be returned back to the command prompt 
(Test: 9)
Testing if user wants to add more quantity to an existing investment if no investments exits,  Error message will display saying that no investments exits and user
will be returned back to the command prompt 
(Test: 11)
Testing if user enters in invalid symbols or strings/asci characters for price and or shares, Error Trap will prompt user to enter until valid correctness is mathced
(Test: 12)
Testing if user enters in invalid symbols or strings/asci characters in command prompt or enters in a number that's not in menu, Error Trap will prompt user to enter 
until valid correctness is mathced
(Test: 13)
Testing if user wants to add more quantity to an existing investment (the same investment they just deleted)  Error message will display saying that no investment exits and user
will be returned back to the command prompt
(Test: 14)
Testing for search if ex. user types in Bank all occurances of bank, BANK etc. should all be returned 
(Test: 15)
Testing for case insenstiviy -> if symbol APPL exits in investment then when user types in appl for the search **APPL should be returned
(Test: 16)
Testing for mixed searches-> if BANK OF CANADA & BANK OF TORONTO already exisit in investments list, when user wants to search for BANK OF TORONTO,
BANK OF CANADA & BANK OF TORONTO are returned because of the key word 'OF' it is both present in the company names "BANK OF CANADA" and "BANK OF TORONTO"
(Test: 17) 
Testing for mixed searches -> if user enters in a space between the '-' and a number, program should be able to still return the correct investmnest within
that ranges specfied
(Test: 18) 
Testing when user sells all their shares from an investment, investment should be removed from entire list, as well as indexs from hashTable
