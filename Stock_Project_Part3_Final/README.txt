/***************************************
Name: Martina Tawedrous
Date: November 26 2017
Email: mtawedro@uoguelph.ca
Student Number: 0977473
***************************************/
Program Discription:

A simplified version of assignment 1 and assignment 2 code with added improvements. In particular, a GUI interface and exception handling is added
so that the system will be more robust and userfriendly. There will be 6 interfaces: 

Welcome Window --> displays a welcome message

Buy Window --> (Fields) Type, Symbol, Name, Quantity, Price

Sell Window -->(Fields) Symbol, Quantity, Price

Update Window --> (Fields) Symbol (Non-Editable), Name (Non-Editable), Price(Editable)

getGain Window -->(Fields) getGain(Non-Editable)

search Window --> (Fields) Symbol, Name (keywords), Low-Range, High-Range

**Quit -> (No Window) User's updates will be saved -> A pop-up message will be prompted: "Succesfully Saved"

**Discription of program functionality**: An individual has the ability to have a portfolio that holds different kinds of investments and allows you to buy or sell 
investments, search for some investments, update prices, and compute the total gain of the portfolio. There is a limit to two kinds of investments: 
Stock and MutualFund.  Each investment should have a symbol, a name, a quantity, a price, and a bookValue.  For each stock, there is a need to 
pay commissons when buying or selling shares of the stock and MutualFund, which will affect the values for “quantity” and “bookValue”, and the calculation of the 
gain of the investments.

**** Everything is saved and written to the file once user quits the program on the Menu Bar!!****

Assumptions:
**IMPORTANT -> (Test: 14) Testing for searches-> if ex. BANK OF CANADA & BANK OF TORONTO already exisit in investments list, when user wants to search for 
BANK OF TORONTO,-> BANK OF CANADA & BANK OF TORONTO are returned because of the key word 'OF' it is both present in the company names "BANK OF CANADA" and
"BANK OF TORONTO", therefore it will return both occurances
 
**Search: When user types in ex.
High Range: 30
Low Range: 30
***MEANS EXACT PRICE **According to online discussion board

**Notes**: 
*Special Features
Update interafce (with prev and next buttons) will show current data from where the user left off from before (when user presses buttons of course)

*** PLEASE READ *** 
ABSTRACT METHODS implemented are ONLY the CalculateFunds()(BookValue) and Payment functions(both in Mutual Fund and Stock classes) however NOT the getGain 
function because GetGain just calculates gain of  *each object(Investment) in array list**.... It's not specific to Stock Or Mutual Fund calculations 
(NO COMMSSION NEEDED FOR THIS) so therefore i left it as a concrete function in the investment super class. Cuz it's a general calculation? and it has nothing
 to do with how you calculate it with respect to stock or mutualFund. I feel its not necessary to make it defined as an abstract method defined in Investment class.
(I understand if i'll lose marks for this portion)


Test Cases:

(Test: 1) 
Testing a neg number or 0 for price and quantity or invalid symbols/asci characters for buying investments and/or selling Investments/Updating (fields)
Expexted output: Error Check saying it is invalid and letting the user enter in their input again
(Test: 2) 
Testing Symbol, Name, Price, Quantity, must be entered for Buy or Sell, or Update if not expexted output Error trap will prompt user to enter
until there is its not blank
(Test: 3) 
Testing when user enters in all textfields blank for Buy, Sell, or Update user must enter valid input or Error Trap will prompt user to enter until valid 
correctness is mathced
(Test: 4)
Testing when user sells all their shares from an investment, investment should be removed from entire list, as well as indexs from hashTable
(Test: 5)
Testing when number of shares that user wants to sell is greater then user has in current investment, Expexted error tarp will dislay saying limit exceeded 
(Test: 6)
Testing if user wants to add Investment that already exits in list (with same type) , will be updated automatically with new price and quantity
(Test: 7)
Testing is user wants to add same Investment (dependent on symbol) to MutualFund that already exsits in stock list (or visa versa), Error message will display 
saying that they cant add it to the list.
(Test: 8)
Testing if user wants to buy/add more quantity to an existing investment if no investments of type Stock exits, new Investment will be added (since it doesn;t exsit)
(Test: 9)
Testing if user wants to buy/add more quantity to an existing investment if no investments of Type MutualFund exits, new Investment will be added (since it doesn;t exsit)
(Test: 10)
Testing if user enters in invalid symbols or strings/asci characters for price and or shares in any field, Error Trap will prompt user to enter until valid correctness is mathced
(Test: 11)
Testing if user wants to buy/add more quantity to an existing investment (the same investment they just deleted) Investment will be added again (since it doesnt exsit)
(Test: 12)
Testing for search if ex. user types in Bank all occurances of bank, BANK etc. should all be returned 
(Test: 13)
Testing for case insenstiviy -> if symbol APPL exits in investment then when user types in appl for the search **APPL should be returned
(Test: 14)
Testing for mixed searches-> if BANK OF CANADA & BANK OF TORONTO already exisit in investments list, when user wants to search for BANK OF TORONTO,
BANK OF CANADA & BANK OF TORONTO are returned because of the key word 'OF' it is both present in the company names "BANK OF CANADA" and "BANK OF TORONTO"
(Test: 15) 
Testing for mixed searches -> if BANK OF CANADA & BANK OF TORONTO already exisit in investments list, when user wants to search for CANADA TORONTO,
nothing is returned because both keywords have to appear in the name of an investment in order to be matched.
(Test: 16) 
Testing for mixed searches -> if DISNEY(comp name) already exsits in investments list, when user wants to search for "SOMETHING (which doesn't exsit in Investment list)
TORONTO",nothing is returned because since "SOMETHING" doesn't exsit in Investment list, both keywords have to appear in the name of an investment in order 
to be matched.
(Test: 17) 
Testing for mixed searches -> if GOOGLE(comp name) lready exsits in investments list along with its coorosponding symbol(GOGL), when user wants to search: 
Symbol: GOGL
Name: BANK OF TORONTO
**Nothing is returned because symbol does not match with its coorosponding Company Name
(Test: 18)
Testing for search validity if ex. user types in invalid symbols/asci characters for the high or lower ranges fields, Error Trap will prompt user to enter  
input until valid correctness is matched
(Test: 19)
Testing for search validity if ex. user types in a negetive number and/or 0 for the high or lower ranges fields, Error Trap will prompt user to enter  
input until valid correctness is matched
(Test: 20)
Testing for search validity if ex. user types in a GREATER number for 'Lower Range' than 'Higer Range' Error Trap will prompt user to enter  
input until valid correctness is matched
