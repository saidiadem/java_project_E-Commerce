There are two types of people in this application , admins and normal users(costumers) at first the admin will need to log in and add the products he wants to add to the "database" enter their price etc so they can be shown to the users .
Then the user can log in and browse the products available , potentially adding them to his cart and proceeding to the payment , he can of course edit his carts' contents beforehand and delete some if necessary .Each user has of course
his own cart totally independant from other users .
A product is linked to his user by his userReference , it's the user token generated when the user registers.
JDK 20
admin username and pass are : admin:admin
##Shopify Java Application
###Overview
Welcome to Shopify, a Java-based e-commerce application . Shopify offers a comprehensive platform catering to both administrators and users, facilitating seamless product management, order processing, and more.

Testing Credentials and Information
Admin Credentials
Username: admin
Password: admin
User Credentials
Username: user
Password: user
Some products are added automatically to ease the testing process, if you want the virgin application you can simply comment out the corresponding code in the main function 
-- u can of course add your own users
Payment Information 
Credit Card: 16 digits
Date Format: MM/YY
CVV: 3 digits
Coupon Format 
Format: ABCD1234
Note: The provided credentials and payment information are intended for testing purposes within the application's main function

User Interface
Login Menu
To interact with the application, users are presented with a login menu. This menu provides options for logging in, registering as a new user, or quitting the application. The user is prompted to make a selection by entering the corresponding option number.

Key Features
Shopify boasts a range of key features to enhance your e-commerce experience:

User Authentication and Access Management: Robust login/logout system with defined roles for customers and administrators.

Dynamic Product Management: Manage products with ease through the ProductService class, allowing CRUD operations on the inventory.

Shopping Cart Experience: A feature-rich shopping cart enables users to add, update, or remove items, ensuring a personalized and flexible shopping journey.

Streamlined Order Processing: Transition seamlessly from the cart to order completion, with comprehensive transaction records within the Order class.

Smart Inventory Management: Automated tracking and updates post-purchase.

Advanced Search and Filtering: Discover products effortlessly with dynamic search functionality and refined results through filtering options.

Secure Payment Processing: Simulate secure payment transactions through the PaymentService class, integrating coupon application and credit card validation.

User Reviews and Ratings: Foster user engagement with the ability to leave reviews and ratings on purchased products.

Exciting Discounts and Promotions: Implement engaging discounts and promotions using the Coupon class.
Usage
Admin Operations
Log in as an admin using the provided credentials.

Access the admin dashboard to manage products, inventory, and apply discounts.
Admin Menu Options:

Option 1: Manage Inventory through the ProductService.
Option 2: Handle Orders using the OrderService.
Option 3: Display information about users through the Users class.
Option 4: Add Coupons via the CouponService.
Option 5: Log out, exiting the application.
User Operations
Option 1: Browse Products
Selecting this option allows users to explore the product catalog using the ProductService.
Option 2: Manage Cart
Users can manage their shopping cart, including adding, updating, or removing items,or proceeding to payment through the CartService.
Option 3: Log Out
Choosing this option logs the user out, gracefully exiting the application.
Login Menu Options:
Option 1: Trigger the login process through the LoginService.
Option 2: Register as a new user using the RegisterService.
Option 3: Exit the application.
Project Structure
Shopify's project structure is organized for clarity and scalability, with key components such as CartService, OrderService, PaymentService, ProductService, and RegisterService.

Input Validation and Security Measures
Shopify ensures the integrity of data through robust input validation. User authentication is securely handled by verifying credentials against stored information in the Users class.

Installation
Clone the repository.
Build the project using JDK 20.
Run the application.
