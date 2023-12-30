There are two types of people in this application , admins and normal users(costumers) at first the admin will need to log in and add the products he wants to add to the "database" enter their price etc so they can be shown to the users .
Then the user can log in and browse the products available , potentially adding them to his cart and proceeding to the payment , he can of course edit his carts' contents beforehand and delete some if necessary .Each user has of course
his own cart totally independant from other users .
A product is linked to his user by his userReference , it's the user token generated when the user registers.
JDK 20
admin username and pass are : admin:admin
# Shopify
## Java Application Overview
Welcome to Shopify, a Java-based e-commerce application . Shopify offers a comprehensive platform catering to both administrators and users, facilitating seamless product management, order processing, and more.
## Design Decisions 
Basic login and registration , a user token is genereated upon registration . 
Implemented a Users class that contains all the users registered , it is checked against before logging in and passes the token of the logged in user to the main application , the token makes sure that the cart showed is unique for each user .
Admins are not normal users , they are included in the Users Arraylist but they are shown a different menu from normal users . 
The abstract  Product class represents a single product ( laptop ,  computer etc) it has a quantity attribute so the product object will be included only once in later arraylists .
It is extended by many product categories classes like Electronic,Health,Fashion etc . 
Products can be linked to a user through the userReference attribute ,  this is for example how each user gets his unique cart despite it being a static arraylist 
We have a Products class that includes all the products added by the admin to the application ( static arraylist) . These products are shown to the users , their quantities updated upon payment of the carts by the users . 
Admins can add and update the Products arraylist through the manage inventory option . When the admin adds a product that already exists in the arraylist , its quantity is added to the existing product instead .
The Cart contains an arraylist where all products that users put in their carts are stored along with their amounts .
In the product discovery option , users can filter results by category , search for products by typing the first few letters of their names ,  filter by a price range or simply show all available products .
The application contains also a fairly simple payment system through the PaymentService class , credit card information are not checked against any databases it suffices that the credit card information matches a certain standard .
Whenever a User pays , the product amount is updated and an order object is created , it contains the timestamp of the order and its details , the admins can check the orders that happened in the application .
I have implemented two additionnal features , the first one being the user reviews : upon completing the payment , users are prompted if they want to rate or give feedback to the products they purchased , they can only rate or give feedback to products they purchased ( to ensure integrity no one can review bomb a product they haven't purchased ) . of course the ratings are displayed in the product discovery and users are prompted if they want to view feedback on a particular product .
The second feature relates to discounts, before paying users can apply discount codes that they obtained it is checked against a "database" of coupons . Admins can add coupons ( in a certain format) and set their discount rates .
The menu is fairly forgiving and user friendly ( as user friendly as a console application can be ).
I have tested a lot of different combinations of inputs , there should be no unexpected inputs that break the application .


## Testing Credentials and Information
Admin Credentials
Username: admin
Password: admin
User Credentials
Username: user
Password: user
Some products are added automatically to ease the testing process, if you want the virgin application you can simply comment out the code in the main function (except the last line that starts up the menu)
Payment Information 
Credit Card: 16 digits
Date Format: MM/YY
CVV: 3 digits
Coupon Format 
Format: ABCD1234
Username format : at least 3 characters and at most 20 characters 
Password format : at least 8 characters , at most 30 characters , contains one lowercase letter , one uppercase letter one digit and a special character .
### Note:
The provided credentials and payment information are intended for testing purposes within the application's main function
### Login Menu Options:
1. Trigger the login process through the LoginService class.
2. Register as a new user using the RegisterService class.
3.Exit the application.
### Admin Menu Options:
1. Manage Inventory through the ProductService class.
2. Handle Orders using the OrderService class.
3. Display information about users through the Users class.
4. Add Coupons via the CouponService class.
5. Log out, exiting the application.
### User Operations
1. Browse Products
Selecting this option allows users to explore the product catalog using the ProductService.
2. Manage Cart
Users can manage their shopping cart, including adding, updating, or removing items,or proceeding to payment through the CartService.
3. Log Out
Choosing this option logs the user out, gracefully exiting the application.

# Project Structure
Shopify's project structure is organized for clarity and scalability, with key components such as CartService, OrderService, PaymentService, ProductService, and RegisterService.

# Input Validation and Security Measures
Shopify ensures the integrity of data through robust input validation. User authentication is securely handled by verifying credentials against stored information in the Users class.

# Installation
Clone the repository.
Build the project using JDK 20.
Run the application.
