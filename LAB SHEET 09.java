Q1. Student ListQuestion: Create an ArrayList<String> containing ten student names. Display all names and the total size.   Javaimport java.util.ArrayList;

public class Q1_StudentList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Aarav");
        students.add("Ananya");
        students.add("Rohan");
        students.add("Diya");
        students.add("Kabir");
        students.add("Sneha");
        students.add("Vikram");
        students.add("Pooja");
        students.add("Karan");
        students.add("Meera");

        System.out.println("Student Names:");
        for (String name : students) {
            System.out.println("- " + name);
        }
        System.out.println("Total size: " + students.size());
    }
}
Output:PlaintextStudent Names:
- Aarav
- Ananya
- Rohan
- Diya
- Kabir
- Sneha
- Vikram
- Pooja
- Karan
- Meera
Total size: 10
Q2. Marks ListQuestion: Create an ArrayList<Integer> containing five marks. Display the first, last and middle elements using get().   Javaimport java.util.ArrayList;

public class Q2_MarksList {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(78);
        marks.add(85);
        marks.add(91);
        marks.add(67);
        marks.add(88);

        int first = marks.get(0);
        int middle = marks.get(marks.size() / 2);
        int last = marks.get(marks.size() - 1);

        System.out.println("First mark: " + first);
        System.out.println("Middle mark: " + middle);
        System.out.println("Last mark: " + last);
    }
}
Output:PlaintextFirst mark: 78
Middle mark: 91
Last mark: 88
Q3. Update Student NameQuestion: Create an ArrayList<String>. Replace the second student name using set() and remove the fourth student.   Javaimport java.util.ArrayList;

public class Q3_UpdateStudentName {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Aarav");
        students.add("Rohan");
        students.add("Diya");
        students.add("Kabir");
        students.add("Sneha");

        System.out.println("Original list: " + students);

        // Second student is at index 1
        students.set(1, "Rahul");
        System.out.println("After replacing 2nd student: " + students);

        // Fourth student is at index 3
        students.remove(3);
        System.out.println("After removing 4th student: " + students);
    }
}
Output:PlaintextOriginal list: [Aarav, Rohan, Diya, Kabir, Sneha]
After replacing 2nd student: [Aarav, Rahul, Diya, Kabir, Sneha]
After removing 4th student: [Aarav, Rahul, Diya, Sneha]
Q4. Unique DepartmentsQuestion: Create a HashSet<String> containing department names with duplicates. Display the resulting unique departments.   Javaimport java.util.HashSet;

public class Q4_UniqueDepartments {
    public static void main(String[] args) {
        HashSet<String> departments = new HashSet<>();
        departments.add("Computer Applications");
        departments.add("Mechanical Engineering");
        departments.add("Computer Applications");
        departments.add("Electronics");
        departments.add("Mechanical Engineering");
        departments.add("Civil Engineering");

        System.out.println("Unique Departments:");
        for (String dept : departments) {
            System.out.println("- " + dept);
        }
    }
}
Output:PlaintextUnique Departments:
- Computer Applications
- Civil Engineering
- Mechanical Engineering
- Electronics
Q5. Sorted Roll NumbersQuestion: Create a TreeSet<Integer> containing ten roll numbers in random order. Display them in sorted order.   Javaimport java.util.TreeSet;

public class Q5_SortedRollNumbers {
    public static void main(String[] args) {
        TreeSet<Integer> rollNumbers = new TreeSet<>();
        int[] rawRolls = {45, 12, 89, 23, 67, 5, 34, 78, 19, 56};

        for (int r : rawRolls) {
            rollNumbers.add(r);
        }

        System.out.println("Sorted Roll Numbers: " + rollNumbers);
    }
}
Output:PlaintextSorted Roll Numbers: [5, 12, 19, 23, 34, 45, 56, 67, 78, 89]
Q6. ArrayList SearchingQuestion: Create an ArrayList<String> of course names. Ask the user for a course and use contains() to check whether it exists.   Javaimport java.util.ArrayList;
import java.util.Scanner;

public class Q6_ArrayListSearching {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Python");
        courses.add("DBMS");
        courses.add("Operating Systems");
        courses.add("Computer Networks");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course name to search: ");
        String query = sc.nextLine();

        if (courses.contains(query)) {
            System.out.println(query + " is available in the course list.");
        } else {
            System.out.println(query + " is not found in the course list.");
        }
        sc.close();
    }
}
Sample Output:PlaintextEnter course name to search: DBMS
DBMS is available in the course list.
Q7. Collections Utility MethodsQuestion: Create an ArrayList<Integer> and demonstrate Collections.sort(), reverse(), max(), min() and frequency().   Javaimport java.util.ArrayList;
import java.util.Collections;

public class Q7_CollectionsUtility {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(40);
        nums.add(10);
        nums.add(30);
        nums.add(20);
        nums.add(30);
        nums.add(50);

        System.out.println("Original list: " + nums);

        Collections.sort(nums);
        System.out.println("After sort(): " + nums);

        Collections.reverse(nums);
        System.out.println("After reverse(): " + nums);

        System.out.println("Maximum element (max): " + Collections.max(nums));
        System.out.println("Minimum element (min): " + Collections.min(nums));
        System.out.println("Frequency of 30: " + Collections.frequency(nums, 30));
    }
}
Output:PlaintextOriginal list: [40, 10, 30, 20, 30, 50]
After sort(): [10, 20, 30, 30, 40, 50]
After reverse(): [50, 40, 30, 30, 20, 10]
Maximum element (max): 50
Minimum element (min): 10
Frequency of 30: 2
Q8. LinkedList Student QueueQuestion: Create a LinkedList<String> representing students waiting for a lab. Use addFirst(), addLast(), removeFirst() and removeLast().   Javaimport java.util.LinkedList;

public class Q8_LinkedListLabQueue {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Student_2");
        queue.add("Student_3");
        System.out.println("Initial queue: " + queue);

        queue.addFirst("Student_1");
        queue.addLast("Student_4");
        System.out.println("After addFirst() and addLast(): " + queue);

        String firstOut = queue.removeFirst();
        String lastOut = queue.removeLast();
        System.out.println("Removed first: " + firstOut + ", Removed last: " + lastOut);
        System.out.println("Remaining queue: " + queue);
    }
}
Output:PlaintextInitial queue: [Student_2, Student_3]
After addFirst() and addLast(): [Student_1, Student_2, Student_3, Student_4]
Removed first: Student_1, Removed last: Student_4
Remaining queue: [Student_2, Student_3]
Q9. ListIterator ModificationQuestion: Create a List<String> and use ListIterator to traverse it. Use set() to replace one element and add() to insert an element during iteration.   Javaimport java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Q9_ListIteratorModification {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("One");
        items.add("Two");
        items.add("Three");

        ListIterator<String> it = items.listIterator();
        while (it.hasNext()) {
            String current = it.next();
            if (current.equals("Two")) {
                it.set("TWO_UPDATED");
                it.add("TwoPointFive");
            }
        }

        System.out.println("Modified list: " + items);
    }
}
Output:PlaintextModified list: [One, TWO_UPDATED, TwoPointFive, Three]
Q10. List vs Set ExperimentQuestion: Create an ArrayList<Integer> and HashSet<Integer> using the same input values. Display both and explain the difference in duplicates and ordering.   Javaimport java.util.ArrayList;
import java.util.HashSet;

public class Q10_ListVsSetExperiment {
    public static void main(String[] args) {
        int[] input = {15, 30, 15, 45, 30, 60};

        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : input) {
            arrayList.add(value);
            hashSet.add(value);
        }

        System.out.println("ArrayList<Integer>: " + arrayList);
        System.out.println("HashSet<Integer>:   " + hashSet);
        System.out.println("\nExplanation:");
        System.out.println("1. Duplicates: ArrayList allows duplicate elements, whereas HashSet automatically discards duplicates.");
        System.out.println("2. Ordering: ArrayList preserves insertion order, whereas HashSet uses hashing and does not guarantee insertion or sorted order.");
    }
}
Output:PlaintextArrayList<Integer>: [15, 30, 15, 45, 30, 60]
HashSet<Integer>:   [45, 15, 60, 30]

Explanation:
1. Duplicates: ArrayList allows duplicate elements, whereas HashSet automatically discards duplicates.
2. Ordering: ArrayList preserves insertion order, whereas HashSet uses hashing and does not guarantee insertion or sorted order.
Q11. Sorted Student IDsQuestion: Create a TreeSet<Integer> for student IDs. Add duplicate IDs and display the unique sorted IDs. Also demonstrate first(), last(), higher() and lower().   Javaimport java.util.TreeSet;

public class Q11_SortedStudentIDs {
    public static void main(String[] args) {
        TreeSet<Integer> ids = new TreeSet<>();
        ids.add(105);
        ids.add(101);
        ids.add(109);
        ids.add(103);
        ids.add(105); // duplicate
        ids.add(101); // duplicate
        ids.add(107);

        System.out.println("Unique Sorted Student IDs: " + ids);
        System.out.println("Lowest ID (first): " + ids.first());
        System.out.println("Highest ID (last): " + ids.last());
        System.out.println("Strictly higher than 105: " + ids.higher(105));
        System.out.println("Strictly lower than 105: " + ids.lower(105));
    }
}
Output:PlaintextUnique Sorted Student IDs: [101, 103, 105, 107, 109]
Lowest ID (first): 101
Highest ID (last): 109
Strictly higher than 105: 107
Strictly lower than 105: 103
Q12. Hospital Patient ListQuestion: Create an ArrayList<String> of patient names and a HashSet<String> of unique patient IDs. Add, remove, search and display the records.   Javaimport java.util.ArrayList;
import java.util.HashSet;

public class Q12_HospitalPatientList {
    public static void main(String[] args) {
        ArrayList<String> patientNames = new ArrayList<>();
        HashSet<String> patientIds = new HashSet<>();

        // Add records
        patientNames.add("Rajesh Kumar");
        patientIds.add("PAT101");

        patientNames.add("Sunita Devi");
        patientIds.add("PAT102");

        patientNames.add("Amit Sharma");
        patientIds.add("PAT103");

        System.out.println("Patients: " + patientNames);
        System.out.println("Patient IDs: " + patientIds);

        // Search
        System.out.println("Is 'Sunita Devi' admitted? " + patientNames.contains("Sunita Devi"));
        System.out.println("Is ID 'PAT103' registered? " + patientIds.contains("PAT103"));

        // Remove
        patientNames.remove("Rajesh Kumar");
        patientIds.remove("PAT101");

        System.out.println("\nAfter discharge/removal:");
        System.out.println("Patients: " + patientNames);
        System.out.println("Patient IDs: " + patientIds);
    }
}
Output:PlaintextPatients: [Rajesh Kumar, Sunita Devi, Amit Sharma]
Patient IDs: [PAT101, PAT102, PAT103]
Is 'Sunita Devi' admitted? true
Is ID 'PAT103' registered? true

After discharge/removal:
Patients: [Sunita Devi, Amit Sharma]
Patient IDs: [PAT102, PAT103]
Q13. ListIterator ReportQuestion: Create an ArrayList<String> of five course names. Use ListIterator to display the list forward and backward, and demonstrate nextIndex() and previousIndex().   Javaimport java.util.ArrayList;
import java.util.ListIterator;

public class Q13_ListIteratorReport {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Data Structures");
        courses.add("Java Programming");
        courses.add("Database Systems");
        courses.add("Software Engineering");
        courses.add("Web Technologies");

        ListIterator<String> it = courses.listIterator();

        System.out.println("--- Forward Traversal ---");
        while (it.hasNext()) {
            int idxBefore = it.nextIndex();
            String item = it.next();
            System.out.println("nextIndex() before step: " + idxBefore + " -> " + item + " (previousIndex() now: " + it.previousIndex() + ")");
        }

        System.out.println("\n--- Backward Traversal ---");
        while (it.hasPrevious()) {
            int idxBefore = it.previousIndex();
            String item = it.previous();
            System.out.println("previousIndex() before step: " + idxBefore + " -> " + item + " (nextIndex() now: " + it.nextIndex() + ")");
        }
    }
}
Output:Plaintext--- Forward Traversal ---
nextIndex() before step: 0 -> Data Structures (previousIndex() now: 0)
nextIndex() before step: 1 -> Java Programming (previousIndex() now: 1)
nextIndex() before step: 2 -> Database Systems (previousIndex() now: 2)
nextIndex() before step: 3 -> Software Engineering (previousIndex() now: 3)
nextIndex() before step: 4 -> Web Technologies (previousIndex() now: 4)

--- Backward Traversal ---
previousIndex() before step: 4 -> Web Technologies (nextIndex() now: 4)
previousIndex() before step: 3 -> Software Engineering (nextIndex() now: 3)
previousIndex() before step: 2 -> Database Systems (nextIndex() now: 2)
previousIndex() before step: 1 -> Java Programming (nextIndex() now: 1)
previousIndex() before step: 0 -> Data Structures (nextIndex() now: 0)
Q14. ArrayList vs LinkedList LabQuestion: Create equivalent ArrayList and LinkedList programs. Perform insertion, deletion, get(), size() and iteration operations. Record your observations in a comparison table.   Javaimport java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q14_ArrayListVsLinkedList {
    private static void testList(String label, List<String> list) {
        System.out.println("=== Testing " + label + " ===");

        // Insertion
        list.add("Alpha");
        list.add("Beta");
        list.add("Gamma");
        list.add(1, "InsertedAt1");
        System.out.println("After insertions: " + list);

        // Size & Get
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2 (get): " + list.get(2));

        // Deletion
        list.remove("Gamma");
        list.remove(0);
        System.out.println("After deletions: " + list);

        // Iteration
        System.out.print("Iteration: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        testList("ArrayList", new ArrayList<>());
        testList("LinkedList", new LinkedList<>());
    }
}
Output:Plaintext=== Testing ArrayList ===
After insertions: [Alpha, InsertedAt1, Beta, Gamma]
Size: 4
Element at index 2 (get): Beta
After deletions: [InsertedAt1, Beta]
Iteration: InsertedAt1 Beta 

=== Testing LinkedList ===
After insertions: [Alpha, InsertedAt1, Beta, Gamma]
Size: 4
Element at index 2 (get): Beta
After deletions: [InsertedAt1, Beta]
Iteration: InsertedAt1 Beta 
Comparison Table: ArrayList vs LinkedListOperation / FeatureArrayListLinkedListObservationInternal StructureResizable dynamic arrayDoubly-linked list nodesArrayList stores contiguous references; LinkedList links prev/next nodes.   Random Access (get(index))$O(1)$ direct index lookup$O(n)$ traversal from endsArrayList is much faster for positional get().   Insertion (add)Amortized $O(1)$ at end; $O(n)$ shifting in middle/start$O(1)$ at ends (with reference); $O(n)$ to reach middle indexLinkedList avoids shifting elements when inserting at ends.   Deletion (remove)$O(n)$ shifting of subsequent elements$O(1)$ pointer unlink once node is locatedLinkedList removes without shifting arrays, though finding index takes $O(n)$.   size()$O(1)$ returns stored size field$O(1)$ returns stored size fieldBoth return element count in constant time.   IterationFast sequential cache-friendly scanSequential pointer traversalBoth support enhanced for loops, iterators, and ListIterator.   Q15. Mini Student Collection Management SystemQuestion: Create a student collection management program. Use ArrayList for maintaining student records in insertion order, HashSet for unique student IDs, and TreeSet for sorted student IDs. Provide options to add, remove, search, display, count, and iterate students. Use ListIterator for forward/backward traversal where appropriate. Demonstrate the difference between List, Set and SortedSet.   Javaimport java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class StudentEntry {
    private int id;
    private String name;

    public StudentEntry(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}

public class Q15_StudentCollectionSystem {
    private static final ArrayList<StudentEntry> studentList = new ArrayList<>();
    private static final Set<Integer> uniqueIds = new HashSet<>();
    private static final SortedSet<Integer> sortedIds = new TreeSet<>();

    public static void addStudent(int id, String name) {
        if (uniqueIds.contains(id)) {
            System.out.println("Duplicate ID " + id + " rejected by Set/SortedSet rule.");
            return;
        }
        studentList.add(new StudentEntry(id, name));
        uniqueIds.add(id);
        sortedIds.add(id);
        System.out.println("Added student -> ID: " + id + ", Name: " + name);
    }

    public static void removeStudentById(int id) {
        boolean removed = studentList.removeIf(s -> s.getId() == id);
        uniqueIds.remove(id);
        sortedIds.remove(id);
        System.out.println(removed ? "Removed student ID " + id : "Student ID " + id + " not found.");
    }

    public static void searchStudentById(int id) {
        if (!uniqueIds.contains(id)) {
            System.out.println("Student ID " + id + " does not exist.");
            return;
        }
        for (StudentEntry s : studentList) {
            if (s.getId() == id) {
                System.out.println("Found -> " + s);
                return;
            }
        }
    }

    public static void displayAll() {
        System.out.println("\n--- Students (Insertion Order via ArrayList) ---");
        if (studentList.isEmpty()) {
            System.out.println("No students in record.");
        } else {
            for (StudentEntry s : studentList) {
                System.out.println(s);
            }
        }
        System.out.println("Unique IDs (HashSet - unordered, no duplicates): " + uniqueIds);
        System.out.println("Sorted IDs (TreeSet/SortedSet - ascending order): " + sortedIds);
    }

    public static void traverseWithListIterator() {
        ListIterator<StudentEntry> it = studentList.listIterator();
        System.out.println("\n--- Forward Traversal (ListIterator) ---");
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
        System.out.println("--- Backward Traversal (ListIterator) ---");
        while (it.hasPrevious()) {
            System.out.println("  " + it.previous());
        }
    }

    public static void showCountAndDifferences() {
        System.out.println("\nTotal Students Count: " + studentList.size());
        System.out.println("List (ArrayList): Ordered by index, allows duplicates.");
        System.out.println("Set (HashSet): No duplicates, no guaranteed element order.");
        System.out.println("SortedSet (TreeSet): No duplicates, maintains natural ascending order.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Seed initial sample records
        addStudent(104, "Aarav");
        addStudent(101, "Diya");
        addStudent(107, "Rohan");
        addStudent(101, "DuplicateDiya"); // demonstrates duplicate rejection

        while (running) {
            System.out.println("\n1. Add Student  2. Remove by ID  3. Search by ID  4. Display All");
            System.out.println("5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    addStudent(id, name);
                }
                case 2 -> {
                    System.out.print("Enter Student ID to remove: ");
                    removeStudentById(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter Student ID to search: ");
                    searchStudentById(sc.nextInt());
                }
                case 4 -> displayAll();
                case 5 -> showCountAndDifferences();
                case 6 -> traverseWithListIterator();
                case 7 -> {
                    running = false;
                    System.out.println("Exiting program.");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
Sample Output:PlaintextAdded student -> ID: 104, Name: Aarav
Added student -> ID: 101, Name: Diya
Added student -> ID: 107, Name: Rohan
Duplicate ID 101 rejected by Set/SortedSet rule.

1. Add Student  2. Remove by ID  3. Search by ID  4. Display All
5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit
Choose an option: 4

--- Students (Insertion Order via ArrayList) ---
ID: 104 | Name: Aarav
ID: 101 | Name: Diya
ID: 107 | Name: Rohan
Unique IDs (HashSet - unordered, no duplicates): [101, 104, 107]
Sorted IDs (TreeSet/SortedSet - ascending order): [101, 104, 107]

1. Add Student  2. Remove by ID  3. Search by ID  4. Display All
5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit
Choose an option: 3
Enter Student ID to search: 101
Found -> ID: 101 | Name: Diya

1. Add Student  2. Remove by ID  3. Search by ID  4. Display All
5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit
Choose an option: 6

--- Forward Traversal (ListIterator) ---
  ID: 104 | Name: Aarav
  ID: 101 | Name: Diya
  ID: 107 | Name: Rohan
--- Backward Traversal (ListIterator) ---
  ID: 107 | Name: Rohan
  ID: 101 | Name: Diya
  ID: 104 | Name: Aarav

1. Add Student  2. Remove by ID  3. Search by ID  4. Display All
5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit
Choose an option: 5

Total Students Count: 3
List (ArrayList): Ordered by index, allows duplicates.
Set (HashSet): No duplicates, no guaranteed element order.
SortedSet (TreeSet): No duplicates, maintains natural ascending order.

1. Add Student  2. Remove by ID  3. Search by ID  4. Display All
5. Count & List/Set/SortedSet Info  6. ListIterator Forward/Backward  7. Exit
Choose an option: 7
Exiting program.