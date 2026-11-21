Q1. Generic BoxQuestion: Create a generic class Box<T> that stores one value. Create objects for Integer, String and Double and display all three values.   Javaclass Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Q1_GenericBox {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(100);
        Box<String> strBox = new Box<>("Java Generics");
        Box<Double> dblBox = new Box<>(99.5);

        System.out.println("Integer Box: " + intBox.getValue());
        System.out.println("String Box: " + strBox.getValue());
        System.out.println("Double Box: " + dblBox.getValue());
    }
}
Output:PlaintextInteger Box: 100
String Box: Java Generics
Double Box: 99.5
Q2. Generic ResultQuestion: Create a generic class Result<T> that stores marks. Create Result<Integer> and Result<Double> objects and display the marks.   Javaclass Result<T> {
    private T marks;

    public Result(T marks) {
        this.marks = marks;
    }

    public void displayMarks() {
        System.out.println("Marks: " + marks);
    }
}

public class Q2_GenericResult {
    public static void main(String[] args) {
        Result<Integer> intResult = new Result<>(88);
        Result<Double> dblResult = new Result<>(91.75);

        intResult.displayMarks();
        dblResult.displayMarks();
    }
}
Output:PlaintextMarks: 88
Marks: 91.75
Q3. Generic StudentQuestion: Create a generic class Student<T> where T represents the student ID. Create a Student<Integer> object and display the ID.   Javaclass Student<T> {
    private T studentId;

    public Student(T studentId) {
        this.studentId = studentId;
    }

    public void displayId() {
        System.out.println("Student ID: " + studentId);
    }
}

public class Q3_GenericStudent {
    public static void main(String[] args) {
        Student<Integer> s1 = new Student<>(1024);
        s1.displayId();
    }
}
Output:PlaintextStudent ID: 1024
Q4. Generic PairQuestion: Create Pair<T, U> to store Employee ID and Employee Name. Use Integer and String as the two types.   Javaclass Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void displayPair() {
        System.out.println("Employee ID: " + first + ", Employee Name: " + second);
    }
}

public class Q4_GenericPair {
    public static void main(String[] args) {
        Pair<Integer, String> empPair = new Pair<>(201, "Aarav Sharma");
        empPair.displayPair();
    }
}
Output:PlaintextEmployee ID: 201, Employee Name: Aarav Sharma
Q5. Product PairQuestion: Create a generic class with two type parameters to store Product ID and Product Price. Create at least three product objects.   Javaclass ProductPair<T, U> {
    private T productId;
    private U productPrice;

    public ProductPair(T productId, U productPrice) {
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId + " | Price: " + productPrice);
    }
}

public class Q5_ProductPair {
    public static void main(String[] args) {
        ProductPair<Integer, Double> p1 = new ProductPair<>(101, 499.99);
        ProductPair<String, Integer> p2 = new ProductPair<>("P102", 1250);
        ProductPair<Integer, Double> p3 = new ProductPair<>(103, 79.50);

        p1.displayProduct();
        p2.displayProduct();
        p3.displayProduct();
    }
}
Output:PlaintextProduct ID: 101 | Price: 499.99
Product ID: P102 | Price: 1250
Product ID: 103 | Price: 79.5
Q6. Generic EmployeeQuestion: Create Employee<T, U> where T represents Employee ID and U represents Employee Name. Add a display() method.   Javaclass Employee<T, U> {
    private T empId;
    private U empName;

    public Employee(T empId, U empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public void display() {
        System.out.println("Employee ID: " + empId + ", Name: " + empName);
    }
}

public class Q6_GenericEmployee {
    public static void main(String[] args) {
        Employee<Integer, String> e1 = new Employee<>(501, "Neha Verma");
        Employee<String, String> e2 = new Employee<>("EMP502", "Rohan Gupta");

        e1.display();
        e2.display();
    }
}
Output:PlaintextEmployee ID: 501, Name: Neha Verma
Employee ID: EMP502, Name: Rohan Gupta
Q7. Generic MethodQuestion: Create a generic method display() that can display Integer, Double, String and Character values.   Javapublic class Q7_GenericMethod {
    public static <T> void display(T value) {
        System.out.println("Value (" + value.getClass().getSimpleName() + "): " + value);
    }

    public static void main(String[] args) {
        display(42);
        display(3.14159);
        display("Hello Java");
        display('A');
    }
}
Output:PlaintextValue (Integer): 42
Value (Double): 3.14159
Value (String): Hello Java
Value (Character): A
Q8. Generic Method for Three ValuesQuestion: Create a generic method that accepts three values of the same type and displays them. Test it using Integers, Strings and Doubles.   Javapublic class Q8_ThreeValuesMethod {
    public static <T> void displayThree(T first, T second, T third) {
        System.out.println(first + ", " + second + ", " + third);
    }

    public static void main(String[] args) {
        System.out.print("Integers: ");
        displayThree(10, 20, 30);

        System.out.print("Strings: ");
        displayThree("Apple", "Banana", "Cherry");

        System.out.print("Doubles: ");
        displayThree(1.5, 2.5, 3.5);
    }
}
Output:PlaintextIntegers: 10, 20, 30
Strings: Apple, Banana, Cherry
Doubles: 1.5, 2.5, 3.5
Q9. Generic ArrayListQuestion: Create an ArrayList<Integer>. Add 10 numbers and display them using a loop.   Javaimport java.util.ArrayList;

public class Q9_GenericArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 10);
        }

        System.out.println("Elements in ArrayList<Integer>:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
Output:PlaintextElements in ArrayList<Integer>:
10 20 30 40 50 60 70 80 90 100 
Q10. Generic String ListQuestion: Create an ArrayList<String> containing five student names. Perform add(), get(), set(), remove() and size(), and display the results.   Javaimport java.util.ArrayList;

public class Q10_GenericStringList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Ananya");
        students.add("Vikram");
        students.add("Pooja");
        students.add("Kabir");
        students.add("Meera");
        System.out.println("Initial list: " + students);

        System.out.println("Element at index 2 (get): " + students.get(2));

        students.set(1, "Vikramaditya");
        System.out.println("After set() at index 1: " + students);

        students.remove("Meera");
        System.out.println("After remove('Meera'): " + students);

        System.out.println("Current size: " + students.size());
    }
}
Output:PlaintextInitial list: [Ananya, Vikram, Pooja, Kabir, Meera]
Element at index 2 (get): Pooja
After set() at index 1: [Ananya, Vikramaditya, Pooja, Kabir, Meera]
After remove('Meera'): [Ananya, Vikramaditya, Pooja, Kabir]
Current size: 4
Q11. Search in Generic ListQuestion: Create ArrayList<Integer> containing ten numbers. Ask the user for a number and use contains() to determine whether the number exists.   Javaimport java.util.ArrayList;
import java.util.Scanner;

public class Q11_SearchInList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] preset = {12, 25, 38, 47, 53, 64, 71, 82, 90, 99};
        for (int n : preset) {
            list.add(n);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int target = sc.nextInt();

        if (list.contains(target)) {
            System.out.println(target + " exists in the list.");
        } else {
            System.out.println(target + " does not exist in the list.");
        }
        sc.close();
    }
}
Sample Output:PlaintextEnter a number to search: 47
47 exists in the list.
Q12. Generic ContainerQuestion: Create Container<T> with add() and get() methods. Test it using Integer, String and Double.   Javaclass Container<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

public class Q12_GenericContainer {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.add(500);
        System.out.println("Integer Container: " + intContainer.get());

        Container<String> strContainer = new Container<>();
        strContainer.add("Container Item");
        System.out.println("String Container: " + strContainer.get());

        Container<Double> dblContainer = new Container<>();
        dblContainer.add(19.99);
        System.out.println("Double Container: " + dblContainer.get());
    }
}
Output:PlaintextInteger Container: 500
String Container: Container Item
Double Container: 19.99
Q13. Generic Class with Three ParametersQuestion: Create Student<T, U, V> where T = ID, U = Name and V = Marks. Create at least three student objects with suitable types.   Javaclass StudentRecord<T, U, V> {
    private T id;
    private U name;
    private V marks;

    public StudentRecord(T id, U name, V marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class Q13_ThreeParamsStudent {
    public static void main(String[] args) {
        StudentRecord<Integer, String, Double> s1 = new StudentRecord<>(1, "Aditi", 89.5);
        StudentRecord<String, String, Integer> s2 = new StudentRecord<>("S02", "Dev", 92);
        StudentRecord<Integer, String, Double> s3 = new StudentRecord<>(3, "Sneha", 84.0);

        s1.display();
        s2.display();
        s3.display();
    }
}
Output:PlaintextID: 1 | Name: Aditi | Marks: 89.5
ID: S02 | Name: Dev | Marks: 92
ID: 3 | Name: Sneha | Marks: 84.0
Q14. Generic Method and ArrayListQuestion: Create an ArrayList<T> and a generic method that displays all elements of the list. Test it with ArrayList<Integer> and ArrayList<String>.   Javaimport java.util.ArrayList;

public class Q14_GenericListMethod {
    public static <T> void displayList(ArrayList<T> list) {
        for (T element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("Java");
        strList.add("Python");
        strList.add("C++");

        System.out.print("Integer List: ");
        displayList(intList);

        System.out.print("String List: ");
        displayList(strList);
    }
}
Output:PlaintextInteger List: 10 20 30 
String List: Java Python C++ 
Q15. Mini Generic Student Management ProgramQuestion: Create a small student management program using Student<T, U, V>, where T = Student ID, U = Student Name and V = Marks. Create at least five students, store them using an appropriate collection, display all students, search for a student, display the total number of students, and demonstrate type safety. Use Generic Class, Multiple Type Parameters, ArrayList, add(), get(), size(), contains(), loops, methods, constructors and type safety.   Javaimport java.util.ArrayList;

class ManagedStudent<T, U, V> {
    private T id;
    private U name;
    private V marks;

    public ManagedStudent(T id, U name, V marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public T getId() {
        return id;
    }

    public U getName() {
        return name;
    }

    public V getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Marks=" + marks + "]";
    }
}

public class Q15_StudentManagement {
    public static <T, U, V> void displayAll(ArrayList<ManagedStudent<T, U, V>> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public static <T, U, V> void searchById(ArrayList<ManagedStudent<T, U, V>> students, T searchId) {
        boolean found = false;
        for (ManagedStudent<T, U, V> s : students) {
            if (s.getId().equals(searchId)) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }

    public static void main(String[] args) {
        ArrayList<ManagedStudent<Integer, String, Double>> roster = new ArrayList<>();

        roster.add(new ManagedStudent<>(101, "Aarav", 88.5));
        roster.add(new ManagedStudent<>(102, "Diya", 94.0));
        roster.add(new ManagedStudent<>(103, "Karan", 79.5));
        roster.add(new ManagedStudent<>(104, "Riya", 91.0));
        roster.add(new ManagedStudent<>(105, "Siddharth", 85.0));

        

        System.out.println("--- All Students ---");
        displayAll(roster);

        System.out.println("\nTotal number of students: " + roster.size());

        System.out.println("\n--- Searching for Student ID 103 ---");
        searchById(roster, 103);

        ManagedStudent<Integer, String, Double> target = roster.get(1);
        System.out.println("\nChecking if Diya's record is in roster using contains(): " + roster.contains(target));
    }
}
Output:Plaintext--- All Students ---
1. Student [ID=101, Name=Aarav, Marks=88.5]
2. Student [ID=102, Name=Diya, Marks=94.0]
3. Student [ID=103, Name=Karan, Marks=79.5]
4. Student [ID=104, Name=Riya, Marks=91.0]
5. Student [ID=105, Name=Siddharth, Marks=85.0]

Total number of students: 5

--- Searching for Student ID 103 ---
Found: Student [ID=103, Name=Karan, Marks=79.5]

Checking if Diya's record is in roster using contains(): true