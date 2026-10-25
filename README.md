# Personal Expense Tracker

A command-line application built with Java to record and manage personal expenses. The project demonstrates object-oriented programming, collections, file handling, and input validation.

## Features

- Add expenses with an amount, category, description, and date
- View all recorded expenses
- Calculate total spending
- Generate monthly expense reports
- Save expenses to a file and load them when the application restarts
- Validate user input, including amounts, dates, months, categories, and descriptions

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList and collections
- File handling
- Exception handling
- Date validation using Java's time API

## Project Structure

```text
java-personal-expense-tracker/
├── Expense.java
├── ExpenseTracker.java
└── README.md
```

The application also creates an `expenses.txt` file locally to store expense records.

## Requirements

- Java Development Kit (JDK) installed
- A terminal or an IDE such as Visual Studio Code

## How to Run

1. Clone or download this repository.
2. Open a terminal in the project directory.
3. Compile the Java files:

   ```bash
   javac Expense.java ExpenseTracker.java
   ```

4. Run the application:

   ```bash
   java ExpenseTracker
   ```

## Menu Options

| Option | Description |
|---|---|
| 1 | Add an expense |
| 2 | View all expenses |
| 3 | Show total spending |
| 4 | Generate a monthly expense report |
| 5 | Exit the application |

## Data Storage

Expenses are stored locally in `expenses.txt` and loaded when the application starts. The file is generated when expenses are saved.

## Purpose

This project was developed to practise Java programming concepts, including classes and objects, collections, file handling, exception handling, and input validation.
