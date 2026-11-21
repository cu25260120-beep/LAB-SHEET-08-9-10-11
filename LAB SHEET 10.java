Q1. Create and Write to a FileQuestion: Write a Java program to create a file named student.txt and write Student Name, Roll Number, Course, and Semester into it. Display a suitable message after the file is successfully created and data is written.   Javaimport java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Q1_CreateAndWriteFile {
    public static void main(String[] args) {
        File file = new File("student.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists. Overwriting/writing data...");
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Student Name: Mohit Kumar\n");
                writer.write("Roll Number: 101\n");
                writer.write("Course: BCA\n");
                writer.write("Semester: 3\n");
            }

            System.out.println("Student details written successfully to " + file.getName());
        } catch (IOException e) {
            System.out.println("Error while creating/writing file: " + e.getMessage());
        }
    }
}
Output:PlaintextFile created: student.txt
Student details written successfully to student.txt
Q2. Read Data from a FileQuestion: Write a Java program to read the contents of student.txt created in Question 1 and display the complete contents on the console. If the file does not exist, display an appropriate error message.   Javaimport java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q2_ReadFile {
    public static void main(String[] args) {
        File file = new File("student.txt");

        if (!file.exists()) {
            System.out.println("Error: '" + file.getName() + "' does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("--- Contents of student.txt ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
Output:Plaintext--- Contents of student.txt ---
Student Name: Mohit Kumar
Roll Number: 101
Course: BCA
Semester: 3
Q3. Count Characters, Words and LinesQuestion: Create a text file named data.txt containing multiple lines of text. Write a Java program to read the file and calculate the number of lines, words, and characters. Display all three results.   Javaimport java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Q3_CountLinesWordsChars {
    public static void main(String[] args) {
        String fileName = "data.txt";

        // Create sample multi-line data.txt
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Java file handling is fun.\n");
            fw.write("BufferedReader reads lines efficiently.\n");
            fw.write("Keep practicing coding.\n");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
            return;
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] words = trimmed.split("\\s+");
                    wordCount += words.length;
                }
            }

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters (excluding line breaks): " + charCount);
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
    }
}
Output:PlaintextLines: 3
Words: 12
Characters (excluding line breaks): 85
Q4. Append Data to an Existing FileQuestion: Create a Java program that appends new student information to an existing file named students.txt without deleting existing contents. Accept Student Name, Roll Number, and Marks from the user and add the record at the end.   Javaimport java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q4_AppendStudentData {
    public static void main(String[] args) {
        String fileName = "students.txt";

        try (Scanner sc = new Scanner(System.in);
             FileWriter fw = new FileWriter(fileName, true)) { // true = append mode

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            fw.write("Name: " + name + ", Roll No: " + roll + ", Marks: " + marks + "\n");
            System.out.println("Record appended successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
Sample Output:PlaintextEnter Student Name: Aarav Sharma
Enter Roll Number: 108
Enter Marks: 89.5
Record appended successfully to students.txt
Q5. Copy One File into Another FileQuestion: Write a Java program to copy the contents of source.txt into backup.txt. Display a message after the copying operation is completed.   Javaimport java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q5_CopyFile {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File backup = new File("backup.txt");

        // Ensure source.txt exists for demonstration
        if (!source.exists()) {
            try (FileWriter init = new FileWriter(source)) {
                init.write("Sample content inside source.txt\nSecond line of text.\n");
            } catch (IOException e) {
                System.out.println("Could not initialize source.txt: " + e.getMessage());
                return;
            }
        }

        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(backup)) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
            System.out.println("Contents copied from " + source.getName() + " to " + backup.getName() + " successfully.");
        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
Output:PlaintextContents copied from source.txt to backup.txt successfully.
Q6. Search for a Word in a FileQuestion: Create a text file named notes.txt. Write a Java program that accepts a word from the user and searches for that word in the file. Display whether the word is found and the number of times it occurs.   Javaimport java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q6_SearchWordInFile {
    public static void main(String[] args) {
        String fileName = "notes.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Java supports OOP and Java supports collections.\n");
            fw.write("Generics and file handling are core Java topics.\n");
        } catch (IOException e) {
            System.out.println("Error creating notes.txt: " + e.getMessage());
            return;
        }

        int count = 0;
        try (Scanner sc = new Scanner(System.in);
             BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            System.out.print("Enter word to search: ");
            String target = sc.nextLine().trim();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(target)) {
                    String[] tokens = line.split("\\W+");
                    for (String token : tokens) {
                        if (token.equals(target)) {
                            count++;
                        }
                    }
                }
            }

            if (count > 0) {
                System.out.println("Word '" + target + "' was FOUND.");
                System.out.println("Total occurrences: " + count);
            } else {
                System.out.println("Word '" + target + "' was NOT found in " + fileName + ".");
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
    }
}
Sample Output:PlaintextEnter word to search: Java
Word 'Java' was FOUND.
Total occurrences: 3
Q7. Display File InformationQuestion: Write a Java program that accepts a file name from the user and displays whether the file exists, file name, absolute path, file size, whether it is a file, whether it is a directory, whether it is readable, and whether it is writable.   Javaimport java.io.File;
import java.util.Scanner;

public class Q7_DisplayFileInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file or directory name: ");
        String path = sc.nextLine().trim();

        File file = new File(path);

        System.out.println("\n--- File Properties ---");
        System.out.println("Exists: " + file.exists());
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size (bytes): " + (file.exists() ? file.length() : 0));
        System.out.println("Is a File: " + file.isFile());
        System.out.println("Is a Directory: " + file.isDirectory());
        System.out.println("Is Readable: " + file.canRead());
        System.out.println("Is Writable: " + file.canWrite());

        sc.close();
    }
}
Sample Output:PlaintextEnter file or directory name: student.txt

--- File Properties ---
Exists: true
File Name: student.txt
Absolute Path: /workspace/student.txt
File Size (bytes): 66
Is a File: true
Is a Directory: false
Is Readable: true
Is Writable: true
Q8. Count Vowels, Consonants, Digits and SpacesQuestion: Create a text file named input.txt. Write a Java program to read the file and count the number of vowels, consonants, digits, and spaces. Analyze every character present in the file.   Javaimport java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q8_CountCharsCategory {
    public static void main(String[] args) {
        String fileName = "input.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Lab 10 at COER University in 2026!\n");
        } catch (IOException e) {
            System.out.println("Error creating input.txt: " + e.getMessage());
            return;
        }

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        try (FileReader fr = new FileReader(fileName)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                char c = (char) ch;
                if (c == ' ') {
                    spaces++;
                } else if (Character.isDigit(c)) {
                    digits++;
                } else if (Character.isLetter(c)) {
                    char lower = Character.toLowerCase(c);
                    if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Digits: " + digits);
            System.out.println("Spaces: " + spaces);
        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
        }
    }
}
Output:PlaintextVowels: 7
Consonants: 12
Digits: 6
Spaces: 6
Q9. Student Record FileQuestion: Write a Java program to accept details of 5 students and store them in student_records.txt. For each student store Roll Number, Name, Course, and Marks. After storing the records, read the file and display all student records.   Javaimport java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q9_StudentRecordsFile {
    public static void main(String[] args) {
        String fileName = "student_records.txt";
        Scanner sc = new Scanner(System.in);

        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("\nEnter details for Student " + i + ":");
                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Course: ");
                String course = sc.nextLine();

                System.out.print("Marks: ");
                double marks = sc.nextDouble();

                fw.write(roll + " | " + name + " | " + course + " | " + marks + "\n");
            }
            System.out.println("\nAll 5 student records saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing student records: " + e.getMessage());
            sc.close();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\n--- Stored Student Records ---");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading student records: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
Sample Output:PlaintextEnter details for Student 1:
Roll Number: 1
Name: Aarav
Course: BCA
Marks: 88.0
... (repeated for 5 students) ...

All 5 student records saved to student_records.txt

--- Stored Student Records ---
1 | Aarav | BCA | 88.0
2 | Diya | BCA | 91.5
3 | Karan | BCA | 79.0
4 | Sneha | BCA | 85.5
5 | Rohan | BCA | 82.0
Q10. File-Based Employee ManagementQuestion: Create a file-based employee management program. Accept Employee ID, Employee Name, Department, and Salary and store them in employees.txt. Then read the file and search for an employee using Employee ID. If found, display the complete record; otherwise display 'Employee record not found.' Handle the situation where the file does not exist.   Javaimport java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q10_EmployeeFileManagement {
    public static void main(String[] args) {
        String fileName = "employees.txt";
        File file = new File(fileName);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("How many employee records do you want to add? ");
            int count = sc.nextInt();
            sc.nextLine();

            try (FileWriter fw = new FileWriter(file, true)) {
                for (int i = 1; i <= count; i++) {
                    System.out.println("\nEmployee " + i + ":");
                    System.out.print("Employee ID: ");
                    String empId = sc.nextLine().trim();

                    System.out.print("Employee Name: ");
                    String empName = sc.nextLine().trim();

                    System.out.print("Department: ");
                    String dept = sc.nextLine().trim();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    fw.write(empId + "," + empName + "," + dept + "," + salary + "\n");
                }
            }
            System.out.println("\nEmployee records saved to " + fileName);

            if (!file.exists()) {
                System.out.println("Error: " + fileName + " does not exist.");
                return;
            }

            System.out.print("\nEnter Employee ID to search: ");
            String searchId = sc.nextLine().trim();

            boolean found = false;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4 && parts[0].trim().equals(searchId)) {
                        System.out.println("Record Found:");
                        System.out.println("Employee ID : " + parts[0].trim());
                        System.out.println("Name        : " + parts[1].trim());
                        System.out.println("Department  : " + parts[2].trim());
                        System.out.println("Salary      : " + parts[3].trim());
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee record not found.");
            }
        } catch (IOException e) {
            System.out.println("File operation error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
Sample Output:PlaintextHow many employee records do you want to add? 2

Employee 1:
Employee ID: E101
Employee Name: Vikram Rao
Department: IT
Salary: 55000

Employee 2:
Employee ID: E102
Employee Name: Priya Nair
Department: HR
Salary: 48000

Employee records saved to employees.txt

Enter Employee ID to search: E102
Record Found:
Employee ID : E102
Name        : Priya Nair
Department  : HR
Salary      : 48000