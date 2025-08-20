# Pahana Edu - Online Billing System

A robust, secure, and menu-driven Java EE web application designed to streamline the billing and account management operations for Pahana Edu, a leading bookshop. This system replaces a manual process with a computerized solution, enhancing efficiency, accuracy, and data security.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Java EE](https://img.shields.io/badge/Java%20EE-6C2C11?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-6C2C11?style=for-the-badge&logo=java&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

## 📖 Table of Contents

- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [System Architecture](#-system-architecture)
- [Database Schema](#-database-schema)
- [License](#-license)

## ✨ Features

- **🔐 Secure User Authentication:** Role-based login system
- **👥 Customer Management:** Full CRUD operations for customer accounts
- **📦 Inventory Management:** Add, update, delete, and view items
- **🧾 Bill Generation & Printing:** Dynamic bill calculation with printable invoices
- **📊 Dashboard:** Overview of key metrics and system statistics
- **❌ Input Validation:** Comprehensive server-side and client-side validation
- **💡 Help Section:** Integrated user guidance and documentation

## Technology Stack

- **Backend:** Java EE (Servlets, JSP)
- **Frontend:** JSP, HTML5, CSS3, DaisyUI, JavaScript
- **Database:** MySQL 8.0
- **Build Tool:** Apache Maven
- **Application Server:** Apache Tomcat 9+
- **Testing:** JUnit 5
- **Version Control:** Git / GitHub
- **IDE:** IntelliJ IDEA Ultimate

## System Architecture

The application follows a classic **3-Tier Architecture**:

1. **Presentation Layer (Web Tier):** JSP pages and Servlets handle HTTP requests/responses
2. **Business Logic Layer (Application Tier):** Service classes contain core business rules
3. **Data Access Layer (Persistence Tier):** DAO classes abstract database operations using JDBC

**Design Patterns Implemented:**
- Data Access Object (DAO)
- Data Transfer Object (DTO)
- Singleton (Database Connection)
- Service Layer
- MVC (Model-View-Controller)

## Database Schema

The system uses a relational MySQL database with the following key entities:
- `customers` - Customer account details
- `items` - Inventory details
- `bills` - Transaction headers
- `bill_items` - Junction table for bill line items

## License
This project is developed for academic purposes as part of the CIS6003 Advanced Programming module. All rights reserved.