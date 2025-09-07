# SEAM - School Equipment Acquisition and Monitoring System

A comprehensive Java-based application for managing classroom equipment in educational institutions, developed as a final project for CSS123L - Object Oriented Programming Laboratory Course.

## 📋 Description

SEAM (School Equipment Acquisition and Monitoring) is a desktop application built with Java Swing that enables schools to efficiently register, remove, and monitor their classroom equipment inventory. The system features a graphical user interface built using JFrame and implements core Object-Oriented Programming principles including Inheritance, Abstraction, Aggregation, Polymorphism, and Encapsulation.

The application utilizes Gang of Four (GoF) design patterns, specifically the **Factory Method** and **Singleton** patterns from the Creational patterns category, ensuring maintainable and scalable code architecture.

## ✨ Key Features

- **Equipment Management**: Add, remove, and update equipment across multiple classrooms
- **Multi-Equipment Support**: Manages 5 types of classroom equipment:
  - Printers
  - Projectors
  - Speakers
  - Smartboards
  - Tablets
- **Multi-Room Support**: Tracks equipment across 3 classrooms (MKT500, MKT310, MKT602)
- **Status Monitoring**: 8 comprehensive equipment condition states:
  - Excellent
  - Great
  - Good
  - Decent
  - Poor
  - Needs Replacement
  - Missing
  - Disposed
- **Report Generation**: 
  - Equipment replacement reports
  - Overall inventory status reports
- **Data Import/Export**: CSV file support for data persistence

## 🎯 Purpose

SEAM addresses the critical need for efficient equipment management in educational settings by providing:

- **Centralized Management**: Single interface for all equipment tracking needs
- **Quick Decision Making**: Instant reports for administrative decisions
- **Cost Efficiency**: Prevents unnecessary purchases and equipment loss
- **Resource Planning**: Data-driven insights for future acquisitions
- **Operational Efficiency**: Reduces manual tracking burden on staff

## 🔧 Technical Architecture

### Object-Oriented Design Principles
- **Inheritance**: Equipment class hierarchy
- **Polymorphism**: Different equipment types with common interfaces
- **Encapsulation**: Protected data members with controlled access
- **Abstraction**: Abstract classes and interfaces for extensibility

### Design Patterns Implemented
- **Factory Method Pattern**: Equipment creation and instantiation
- **Singleton Pattern**: Ensures single instance of critical system components

### Technology Stack
- **Language**: Java
- **GUI Framework**: Java Swing (JFrame)
- **Data Storage**: CSV files
- **Architecture**: Object-Oriented Programming (OOP)

## 📊 Benefits

### For Administrators
- **Real-time Inventory Tracking**: Always know what equipment is available and where
- **Automated Reporting**: Generate comprehensive reports with a single click
- **Loss Prevention**: Systematic tracking reduces equipment misplacement
- **Budget Planning**: Clear visibility into replacement needs

### For Staff
- **Simplified Workflow**: User-friendly interface reduces training time
- **Reduced Manual Work**: Automated tracking eliminates paper-based systems
- **Quick Updates**: Easy status changes and equipment modifications

### For Institution
- **Cost Savings**: Prevent duplicate purchases and extend equipment lifespan
- **Improved Productivity**: Minimize downtime due to missing or broken equipment
- **Scalable Solution**: Easy to maintain and extend as needs grow

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Installation
1. Clone the repository
2. Compile the Java source files
3. Run the main application class
4. Use default credentials: `admin` / `pass`

## 📈 Future Enhancements

The modular design allows for easy extension with additional features such as:
- Database integration
- Multi-user support with role-based access
- Equipment maintenance scheduling
- Barcode/QR code scanning
- Mobile application companion

## 📚 Documentation

[**Link to the full project documentation (including UML diagrams and Application Screenshots)**](https://drive.google.com/file/d/18t-JOIn6AIIc7NQI58f8AF5Ky05FVi8t/view?usp=sharing)

*The complete documentation includes detailed UML diagrams, system architecture, and comprehensive application screenshots.*

## 👥 Development Team

**Group 6 Contributors:**
- Aliling, Ken
- De La Paz, Lance Gabriel  
- Jakilan, Aljann
- Leaño, Christian Danielle
- Timbol, Dino Alfred

**Course:** CSS123L - Object-Oriented Programming Laboratory  
**Institution:** Mapúa University, School of Information Technology  
**Instructor:** Prof. Antonette D. Gabriel  
**Completion Date:** November 5, 2024

## 📄 License

This project was developed as an academic assignment for educational purposes.

---

*SEAM provides an effective solution for efficiently managing school resources, reducing delays in resource acquisition, and increasing productivity for both staff and students.*
