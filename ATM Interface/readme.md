# 🏧 ATM Interface (Java Console Project)

## 📄 Description
This is a console-based **ATM (Automated Teller Machine)** system developed in **Java**. It simulates basic banking operations, allowing users to authenticate with a PIN, check their account balance, deposit funds, and withdraw cash. This project focuses on core Java concepts like **Object-Oriented Programming (OOP)**, **Control Flow**, and **Input Validation**.

## 🚀 Features
* **Secure Authentication:** Users must enter a valid 4-digit PIN to access the system.
* **Account Balance Check:** Displays the current available balance.
* **Deposit Functionality:** Allows users to add funds (validates against negative input).
* **Withdrawal System:** Checks for sufficient funds before processing withdrawals.
* **User-Friendly Menu:** Interactive loop until the user chooses to exit.
* **Error Handling:** Prevents crashing on invalid inputs (e.g., entering text instead of numbers).

## 🛠️ Tech Stack
* **Language:** Java (JDK 8+)
* **IDE:** VS Code / Eclipse / IntelliJ IDEA
* **Concepts Used:**
    * Classes & Objects
    * `Scanner` Class (Input Handling)
    * Switch-Case Statements
    * While Loops & Conditionals

## 💻 How to Run
1.  **Clone the repository** (or download the files):
    ```bash
    git clone [https://github.com/YourUsername/ATM-Interface.git](https://github.com/YourUsername/ATM-Interface.git)
    ```
2.  **Navigate to the project directory**:
    ```bash
    cd ATM-Interface
    ```
3.  **Compile the Java file**:
    ```bash
    javac ATM_Interface.java
    ```
4.  **Run the application**:
    ```bash
    java ATM_Interface
    ```

## 📸 Usage Example
```text
Please enter your 4-digit PIN: 1234

Access Granted. Welcome!

----------- MAIN MENU -----------
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
---------------------------------
Select an option: 1
