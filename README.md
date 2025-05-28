# 🏦 Banking System – Java Console Application

This is a basic Java-based console application simulating a simple banking system. It supports creating and managing different types of bank accounts such as **Savings** and **Current** accounts. The application allows for operations like deposit, withdrawal, checking balance, and displaying account details.

## 📁 Features

- Object-Oriented Programming using:
  - Interfaces (`Accountable`)
  - Abstract classes (`Account`)
  - Inheritance and method overriding (`SavingsAccount`, `CurrentAccount`)
- Operations supported:
  - Deposit money
  - Withdraw money (with limits for savings accounts)
  - Display account details
  - Check current balance
- User input handled via `Scanner`
- Encapsulation of account details
- Simple command-line interface

## 📂 Project Structure

```
BankingSystem.java
```

## 🚀 How to Run

1. **Compile the program**:
   ```bash
   javac BankingSystem.java
   ```

2. **Run the program**:
   ```bash
   java BankingSystem
   ```

## 🛠 Technologies Used

- Java (JDK 8+)
- Java I/O and Scanner
- OOP Concepts: Interface, Inheritance, Abstract classes

## 🧠 Key Concepts Demonstrated

- Use of **interfaces** to define contracts for account operations.
- **Abstract classes** to share common structure and behavior.
- Subclass specialization for **Savings** and **Current** accounts.
- Input validation and business logic (e.g., withdrawal limits).
- **Encapsulation** and method overriding.

## 📌 Notes

- Savings account enforces a withdrawal limit.
- No persistent storage (data is stored in memory for runtime only).
- Intended for educational/demonstration purposes.

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
