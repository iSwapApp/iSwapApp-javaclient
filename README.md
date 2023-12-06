# iSwap App Demo
This is about Exchanging cards
<br/><br/>

# Problem
The issue is that customers who buy gift cards from gift card shops occasionally get into circumstances where they would like to get a cash refund rather than keep the gift card. They may ask for a new gift because they have changed their mind about the intended recipient, are in need of money, or are just looking for a different option. Customers are inconvenienced and dissatisfied by the gift card shop's current procedure or policy since it is unable to satisfactorily handle these refund requests.
<br/><br/>

# Suggested Solution
We must have a unified application called (**iSwap**) that creates a gift card store to address the problem of customers wanting to recover cash or exchange it for purchased gift cards, the gift card store can return the amount paid to the digital wallet in case the card is not used. Also, in case you want to exchange the card you have with another card, the store provides you with this service by exchanging cards between customers.
<br/><br/>

# Classes
We have 8 classes:
- **App**: This is the main class.
- **Card**: This class  will know the details of the card and contain the following methods:
  - toString: To print card information
  - updateCard: To read the card information in an up-to-date form the database
  - refund: To get a refund from active cards
- **Customer**: This class will contain users' information and contain the following methods:
  - newAccount: To register a new user
  - check: To make sure that the user is in the database
  - printInfo: To print user information
- **DBConnection**: The database will be accessed from here
- **ExchangingCard**: This class will create orders and the method of exchanging cards between customers will be created. Contain the following methods:
  - createOrder: Orders will be made here if the customer wishes to exchange the card
  - showOrderList: Orders will be displayed here and the exchange process will be completed
- **CardState**: This class will be interface
- **ActiveCardState**: This class will implements form **CardState**
- **NotActiveCardState**: This class will implements form **CardState**
<br/><br/>

# Desgin Pattern
In This project, we use two design patterns:<br/>
1 - **Creational Design Patterns (Singleton)**: In this design pattern we implement a database class as a **Singleton** to avoid duplicating of database.<br/><br/>
2 - **Behavioral Design Patterns (State)**: In this design pattern we implement an StateCard class as a **State** to change the card state(Active/Not Active).<br/><br/>

# Code output
- Login Page<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/dfad89ea-9a3a-4125-a190-ae3de0bdf1ac)

- Home Page<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/f3a95875-d206-488c-9cdd-5e56fed99cf1)

- User Information<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/91ac1ffb-fc8e-4e68-9e2f-88717455f00a)

- Card Information<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/a428f886-fc85-4f0b-a63b-b18e2a5c6b90)

- Create Order<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/e83a6c2c-80ff-41c5-adec-c58d55ccc272)

- Exchange card<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/3347ad7c-692b-4764-a18c-0c6234207fba)

- Refund From the Card<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/d04ee07e-b6b8-4fb9-bf6e-936e2e5e4877)

- Log out<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/eb845f02-b614-4d15-a78e-43157683d2d1)


# Data From Database
- Customer Table<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/ca73ad41-5863-4147-967b-56663ef7821d)

- Card Table<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/acf9159b-fea6-4fe4-b1d1-d7ae46f35958)

- Order Table<br/><br/>
![image](https://github.com/iSwapApp/iSwapApp-javaclient/assets/77943208/74e89162-4bc0-4eab-b7dc-cf2cb3346b19)
