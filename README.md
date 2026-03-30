# Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon
Key Features

Product & Inventory Management  
CRUD Operations: Add and view products with a unique ID for each.  
Atomic Stock Updates: Stock is automatically reduced when an order is placed and restored if a transaction fails.  
Validation: Prevents orders if there is not enough stock available.  

Cart & Order System  
User-Specific Carts: Manages carts separately for each user.  
Order Conversion: Easily changes cart items into processed orders while calculating the total in real time.  
Status Tracking: Monitor orders through the states: PENDING_PAYMENT, PAID, and FAILED.  

Payment & Rollback Mechanism  
Simulation: Randomized payment success or failure to test how well the system holds up.  
Automatic Rollback: If payment fails, the system triggers a rollback:  
Restores previously deducted stock.  
Marks the order as FAILED.  
Removes failed entries from active processing.  

Design Approach  
The architecture follows a Service-Oriented pattern to keep things organized:  
Product Service: Manages the catalog and stock levels.  
Cart Service: Handles the user's item selections.  
Order Service: Oversees the shift from cart to final sale.  
Payment Service: Simulates transaction gateways.  

Technical Highlights:  
Thread Safety: Basic synchronization ensures stock updates stay consistent.  
In-Memory Storage: Fast execution using Java collections means no external database is needed.  

Requirements & Setup  
Requirements  
Java 8 or higher.  
An IDE (IntelliJ IDEA, Eclipse, or VS Code) or Terminal.  

Installation  
Clone the repository:  
```bash  
git clone https://github.com/RameshReddy77/Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon.git  
```  
Use code with caution.  

Navigate to the directory:  
```bash  
cd Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon  
```  
Use code with caution.  

Compile and Run:  
```bash  
javac main/Main.java  
java main.Main  
```  
Use code with caution.  

Menu Options  
Once running, use the following keys to navigate:  
1 – Add Product  
2 – View All Products  
3 – Add Item to Cart  
4 – View Current Cart  
5 – Place Order (Triggers Payment Simulation)  
6 – View Order History  
0 – Exit Application  



