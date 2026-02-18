# 🎓 Student Management System

A robust, console-based Java application for managing student records with local file persistence. This project demonstrates **Object-Oriented Programming (OOP)**, **File I/O**, and **Collection Framework** usage.



---

## 🚀 Features

* **Full CRUD Operations**: Create, Read, Update, and Delete student records.
* **Search Engine**: Case-insensitive search to find students by name.
* **Persistent Storage**: Automatically loads from and saves to `students.txt`.
* **Input Validation**: Gracefully handles non-numeric inputs for menu selection.

---

## 📂 Project Structure

| File | Description |
| :--- | :--- |
| `StudentManagement.java` | The main driver class containing the logic and UI menu. |
| `Student` | Internal data model class for student objects. |
| `students.txt` | The flat-file database used for data persistence. |

---

## 💾 Data Format (`students.txt`)

The application stores data using a comma-separated format. Each line represents a unique student:

```text
101,John Doe,A
102,Jane Smith,B+
103,Alex Rivera,A-
