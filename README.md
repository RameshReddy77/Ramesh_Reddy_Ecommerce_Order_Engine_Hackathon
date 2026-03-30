# Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon
 Key Features



Product & Inventory Management
CRUD Operations: Add and view products with unique ID enforcement.
Atomic Stock Updates: Stock is automatically reduced upon order placement and restored if a transaction fails.
Validation: Prevents orders if insufficient stock is available.


Cart & Order System
User-Specific Carts: Isolated cart management for individual users.
Order Conversion: Seamlessly transforms cart items into processed orders with real-time total calculation.
Status Tracking: Monitor orders through states: PENDING_PAYMENT, PAID, and FAILED.


Payment & Rollback Mechanism
Simulation: Randomized payment success/failure to test system resilience.
Automatic Rollback: If payment fails, the system triggers a rollback:
Restores previously deducted stock.
Marks order as FAILED.
Removes failed entries from active processing.


Design Approach
The architecture follows a Service-Oriented pattern to ensure clean separation of concerns:
Product Service: Manages catalog and stock levels.
Cart Service: Handles user-specific item selections.
Order Service: Orchestrates the transition from cart to final sale.
Payment Service: Simulates transaction gateways. 
Technical Highlights:
Thread Safety: Basic synchronization ensures stock updates remain consistent.
In-Memory Storage: Fast execution using Java collections (no external DB required).


Requirements & Setup
Requirements
Java 8 or higher.
An IDE (IntelliJ IDEA, Eclipse, or VS Code) or Terminal.
Installation
Clone the repository:
bash
git clone https://github.com/your-username/Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon.git
Use code with caution.

Navigate to the directory:
bash
cd Ramesh_Reddy_Ecommerce_Order_Engine_Hackathon
Use code with caution.

Compile and Run:
bash
javac main/Main.java
java main.Main
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



