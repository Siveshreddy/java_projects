import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}

// Main Management Class
public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadFromFile(); // Load existing data on startup

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search by Name");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine()); 

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: viewStudents(); break;
                    case 3: updateStudent(); break;
                    case 4: deleteStudent(); break;
                    case 5: searchByName(); break;
                    case 6: 
                        saveToFile();
                        System.out.println("Exiting... Goodbye!");
                        return;
                    default: System.out.println("Invalid choice! Try 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        studentList.add(new Student(id, name, grade));
        System.out.println("Student added!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            studentList.forEach(System.out::println);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("New Name: ");
                s.setName(scanner.nextLine());
                System.out.print("New Grade: ");
                s.setGrade(scanner.nextLine());
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("ID not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentList.removeIf(s -> s.getId() == id)) {
            System.out.println("Deleted.");
        } else {
            System.out.println("ID not found.");
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(query)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("No matches.");
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : studentList) {
                writer.println(s.getId() + "," + s.getName() + "," + s.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                studentList.add(new Student(Integer.parseInt(p[0]), p[1], p[2]));
            }
        } catch (Exception e) {
            System.out.println("Load error: Data file might be corrupted.");
        }
    }
}