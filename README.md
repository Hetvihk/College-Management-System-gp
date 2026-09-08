# College Management System

A console-based College Management System developed in Core Java as a Semester 1 Computer Engineering group project.

## 📌 About the Project

This project was developed as a team project during Semester 1 to apply fundamental Java programming and Object-Oriented Programming concepts to a college management scenario.

The system provides separate functionalities for **Admin, Student, and Faculty** users and manages areas such as student records, faculty records, branches, attendance, results, and library operations.

The application runs through a command-line interface and stores data in memory during program execution.

## ✨ Features

### 👨‍💼 Admin
- Student management
  - Add students
  - View students
  - Update student information
  - Delete students
  - Sort students by name
- Faculty management
  - Add faculty
  - View faculty
  - Update faculty information
  - Delete faculty
  - Sort faculty by name
- Branch management
  - Add branches
  - View branches
  - Sort branches by fees
- Library management
  - Add books
  - View books
  - Issue books
  - View issued books
  - Return books

### 🎓 Student
- View profile
- View attendance
- View results
- View branch information
- View library information
- View issued books
- Change password

### 👨‍🏫 Faculty
- View profile
- Mark student attendance
- View attendance by subject
- Enter student marks
- View marks
- Change password

### 🔎 Additional Functionality
- Input validation
- Student and faculty lookup by ID
- Sorting using Bubble Sort
- Attendance validation
- Marks validation
- Low-attendance warnings
- Result status checking
- Scholarship eligibility indication
- Library stock management
- Duplicate book-issue validation

## 🛠️ Technologies Used

- **Java**
- **Core Java**
- **Object-Oriented Programming**
- **Arrays**
- **Methods**
- **Inheritance**
- **Console-based input/output**
- **Scanner**
- **Searching and Sorting**
- **Bubble Sort**

## 🧠 OOP Concepts Used

The project applies several fundamental Object-Oriented Programming concepts:

- **Classes and Objects**
- **Inheritance**
- **Constructors**
- **Methods**
- **Hierarchical relationships between entities**

The project includes classes such as:

- `CollegeManagementSystem`
- `Person`
- `Student`
- `Faculty`
- `Admin`
- `Branch`
- `Attendance`
- `Result`
- `Library`
- `IssuedBook`

## 📂 Project Structure

```text
College-Management-System-gp/
├── src/
│   └── Main.java
├── .gitignore
└── README.md
```

All Java classes are currently contained within `Main.java`.

## ▶️ How to Run

### 1. Compile the program

From the repository's root directory:

```bash
javac src/Main.java
```

### 2. Run the application

```bash
java -cp src CollegeManagementSystem
```

The application will start in the console and display the main menu.

## 🔐 Demo Credentials

The project contains default credentials for demonstration purposes.

### Admin

```text
Username: admin
Password: admin123
```

### Student

Student accounts use their student ID with the default password:

```text
Password: 1234
```

### Faculty

Faculty accounts use their faculty ID with the default password:

```text
Password: 1234
```

## 💾 Data Storage

The current version stores data in memory using arrays.

Data is available only while the application is running and is not permanently stored after the program terminates.

## 🚀 Future Improvements

Possible improvements for future versions include:

- Database integration using MySQL
- File-based data persistence
- GUI or web-based interface
- Use of Java Collections instead of fixed-size arrays
- Improved authentication and password security
- More advanced search and filtering
- Better separation of classes into individual Java files
- Improved user interface and error handling

## 🎯 Learning Outcomes

Through this project, we gained practical experience with:

- Core Java programming
- Object-Oriented Programming
- Inheritance and class design
- Arrays and data management
- Searching and sorting algorithms
- Input validation
- Building a menu-driven console application
- Working on a software project as a team

## 📚 Project Information

**Project Type:** Academic Group Project  
**Semester:** 1  
**Course:** Computer Engineering  
**Technology:** Core Java  
**Interface:** Console-based

## 📌 Project Status

This project was created as a Semester 1 academic project to practice fundamental programming and Object-Oriented Programming concepts.
