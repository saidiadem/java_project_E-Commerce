
# Shopify
## Java Application Overview
Welcome to Shopify, a Java-based e-commerce application . Shopify offers a comprehensive platform catering to both administrators and users, facilitating seamless product management, order processing, and more.
## Design Decisions 
Basic login and registration , a user token is genereated upon registration . 


Implemented a Users class that contains all the users registered , it is checked against before logging in and passes the token of the logged in user to the main application , the token makes sure that the cart showed is unique for each user .


Admins are not normal users , they are included in the Users Arraylist but they are shown a different menu from normal users . 



The abstract  Product class represents a single product ( laptop ,  computer etc) it has a quantity attribute so the product object will be included only once in later arraylists .
It is extended by many product categories classes like Electronic,Health,Fashion etc .



We have a Products class that includes all the products added by the admin to the application ( static arraylist) . These products are shown to the users , their quantities updated upon payment of the carts by the users . 



Admins can add and update the Products arraylist through the manage inventory option . When the admin adds a product that already exists in the arraylist , its quantity is added to the existing product instead .
The Cart contains an arraylist where all products that users put in their carts are stored along with their amounts .



Each User instance has a Cart object attached to it , where are stored his carts' contents .



Many checks are in place to ensure that the amount in the inventory is not negative (multiple users putting in their cart before paying , putting in the cart multiple times before paying ) if this happens , users are prompted to delete the product from their cart as the amount in the inventory is less than the amount in his cart (when he starts the payment process).



In the product discovery option , users can filter results by category , search for products by typing the first few letters of their names ,  filter by a price range or simply show all available products .
The application contains also a fairly simple payment system . I used strategy pattern in this section to check for the strategy of the payment , the user can choose between paying by credit card and paying in bitcoin  , credit card and bitcoin addresses  information are not checked against any databases it suffices they match a certain standard(specified below) .



Whenever a User pays , the product amount is updated and an order object is created , it contains the timestamp of the order and its details , the admins can check the orders that happened in the application and their amounts(including discounts) , who did it etc.



I have implemented two additionnal features , the first one being the user reviews : upon completing the payment , users are prompted if they want to rate or give feedback to the products they purchased , they can only rate or give feedback to products they purchased ( to ensure integrity no one can review bomb a product they haven't purchased ) . of course the ratings are displayed in the product discovery and users are prompted if they want to view feedback on a particular product .



The second feature relates to discounts, before paying users can apply discount codes that they obtained it is checked against a "database" of coupons . Admins can add coupons ( in a certain format) and set their discount rates .



The menu is fairly forgiving and user friendly ( as user friendly as a console application can be ).
I have tested a lot of different combinations of inputs , there should be no unexpected inputs that break the application .


## Testing Credentials and Information
These are added to ease the testing process as some requirements for input validation can be a little bit demanding .

### Admin Credentials

Username: admin

Password: admin


### User Credentials


Username: user

Password: user


Some products are added automatically to ease the testing process, if you want the virgin application you can simply comment out the code in the main function (except the last line that starts up the menu)


### Payment Information 

Credit Card: 16 digits

Date Format: MM/YY

CVV: 3 digits

### Bitcoin Address:
The address must start with either '1', '3', 'm', or 'n'.The rest of the address should consist of alphanumeric characters (excluding 'l', 'I', 'O', '0') and be between 26 and 33 characters in length.

### Coupon Format : 
ABCD1234
### Username format :
at least 3 characters and at most 20 characters 
### Password format :
at least 8 characters , at most 30 characters , contains one lowercase letter , one uppercase letter one digit and a special character .
### Note:
The provided credentials and payment information are intended for testing purposes within the application's main function
## Login Menu Options:
1. Trigger the login process through the LoginService class.
2. Register as a new user using the RegisterService class.
3.Exit the application.
## Admin Menu Options:
1. Manage Inventory through the ProductService class.
2. Handle Orders using the OrderService class.
3. Display information about users through the Users class.
4. Add Coupons via the CouponService class.
5. Log out, exiting the application.
## User Operations
1. Browse Products
Selecting this option allows users to explore the product catalog using the ProductService.
2. Manage Cart
Users can manage their shopping cart, including adding, updating, or removing items,or proceeding to payment through the CartService.
3. Log Out
Choosing this option logs the user out, gracefully exiting the application.

# Project Structure
Shopify's project structure is organized for clarity and scalability.

# Input Validation and Security Measures
Shopify ensures the integrity of data through robust input validation. User authentication is securely handled by verifying credentials against stored information in the Users class.
# Source Code 
Most of the code is readable and the method names should indicate what they do , if not , some comments are attached to specify the usage of the method .

# Installation
Clone the repository.
Build the project using JDK 20.
Run the application.
