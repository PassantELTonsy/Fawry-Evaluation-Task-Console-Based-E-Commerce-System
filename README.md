# Fawry-Evaluation-Task-Console-Based-E-Commerce-System
<div align="center">
  <img src= "fawry-logo-png_seeklogo-326467.png" width="400"/>
</div>

# Overview
- This project is a console-based Java application that simulates an e-commerce system with:

- Product management (with or without expiry dates)

- Customer cart and balance

- Checkout process and invoice calculation with shipping details.

- Built using OOP principles and tested with edge-case scenarios.


# Key Features

- Product Abstraction: Abstract Product class extended by ExpirableProducts and NonExpirableProducts

- Interface : Shipping interface applied only to products that require shipping

- Decorator Pattern: ShippableProductWrapper wraps products to make them shippable

- Cart Management: Cart holds product-to-quantity mappings

- Checkout System: Handles product expiry, stock validation, balance, and shipping


# Run Instructions

1. Clone or download the repo.

2. Open in Eclipse IDE

3. Set the Main.java class as your main class

4. Run the program and follow the console prompts


# UML Diagram

- The project design follows a modular class structure.

- UML Diagram File: See attached file E-Commerce mini project.drawio

- Diagram includes classes: Product, ExpirableProducts, NonExpirableProducts, ShippableProductWrapper, Cart, Customer, ShippingService, Main, and interface Shipping

# Files

- Main.java – Entry point with interactive menu

- Product.java – Abstract base class

- ExpirableProducts.java, NonExpirableProducts.java

- ShippableProductWrapper.java

- Cart.java, Customer.java

- Shipping.java – Interface

- ShippingService.java

- ECommerce_UML.drawio – UML Class Diagram

- Documentation.pdf  -   Conatins test cases and solved issues

