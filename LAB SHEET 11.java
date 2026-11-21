Q1. Student Registration Form - AWTQuestion: Create a Java AWT application to design a Student Registration Form containing Label and TextField for Student Name, Roll Number and Course; Checkbox for Gender; Choice for Semester; Submit and Reset buttons. Submit should display entered information; Reset should clear all fields.   Javaimport java.awt.*;
import java.awt.event.*;

public class Q1_AWTStudentRegistration extends Frame implements ActionListener {
    private TextField tfName, tfRoll, tfCourse;
    private Checkbox cbMale, cbFemale, cbOther;
    private CheckboxGroup genderGroup;
    private Choice chSemester;
    private Button btnSubmit, btnReset;
    private Label lblOutput;

    public Q1_AWTStudentRegistration() {
        setTitle("Student Registration Form (AWT)");
        setSize(450, 380);
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

        add(new Label("Student Name:"));
        tfName = new TextField(25);
        add(tfName);

        add(new Label("Roll Number:"));
        tfRoll = new TextField(25);
        add(tfRoll);

        add(new Label("Course:"));
        tfCourse = new TextField(25);
        add(tfCourse);

        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        cbMale = new Checkbox("Male", genderGroup, true);
        cbFemale = new Checkbox("Female", genderGroup, false);
        cbOther = new Checkbox("Other", genderGroup, false);
        add(cbMale);
        add(cbFemale);
        add(cbOther);

        add(new Label("Semester:"));
        chSemester = new Choice();
        for (int i = 1; i <= 6; i++) {
            chSemester.add("Semester " + i);
        }
        add(chSemester);

        btnSubmit = new Button("Submit");
        btnReset = new Button("Reset");
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        add(btnSubmit);
        add(btnReset);

        lblOutput = new Label("Status: Ready");
        add(lblOutput);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            Checkbox selectedGender = genderGroup.getSelectedCheckbox();
            String gender = (selectedGender != null) ? selectedGender.getLabel() : "Not Selected";
            lblOutput.setText("Submitted: " + tfName.getText() + " | Roll: " + tfRoll.getText()
                    + " | " + tfCourse.getText() + " | " + gender + " | " + chSemester.getSelectedItem());
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            tfRoll.setText("");
            tfCourse.setText("");
            genderGroup.setSelectedCheckbox(cbMale);
            chSemester.select(0);
            lblOutput.setText("Status: Fields cleared.");
        }
    }

    public static void main(String[] args) {
        new Q1_AWTStudentRegistration();
    }
}
Sample Output (on Submit):PlaintextSubmitted: Mohit Kumar | Roll: 101 | BCA | Male | Semester 3
Q2. Simple Calculator - AWTQuestion: Create a Java AWT-based calculator with two TextFields, four Buttons for Addition, Subtraction, Multiplication and Division, and a result display. Perform the selected operation and handle division by zero.   Javaimport java.awt.*;
import java.awt.event.*;

public class Q2_AWTCalculator extends Frame implements ActionListener {
    private TextField tfNum1, tfNum2, tfResult;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    public Q2_AWTCalculator() {
        setTitle("Simple Calculator (AWT)");
        setSize(400, 240);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("First Number:"));
        tfNum1 = new TextField();
        add(tfNum1);

        add(new Label("Second Number:"));
        tfNum2 = new TextField();
        add(tfNum2);

        btnAdd = new Button("Addition (+)");
        btnSub = new Button("Subtraction (-)");
        btnMul = new Button("Multiplication (*)");
        btnDiv = new Button("Division (/)");

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);

        add(new Label("Result:"));
        tfResult = new TextField();
        tfResult.setEditable(false);
        add(tfResult);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(tfNum1.getText().trim());
            double n2 = Double.parseDouble(tfNum2.getText().trim());
            double res = 0;

            if (e.getSource() == btnAdd) {
                res = n1 + n2;
            } else if (e.getSource() == btnSub) {
                res = n1 - n2;
            } else if (e.getSource() == btnMul) {
                res = n1 * n2;
            } else if (e.getSource() == btnDiv) {
                if (n2 == 0) {
                    tfResult.setText("Error: Division by zero");
                    return;
                }
                res = n1 / n2;
            }
            tfResult.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            tfResult.setText("Invalid numeric input");
        }
    }

    public static void main(String[] args) {
        new Q2_AWTCalculator();
    }
}
Sample Output:PlaintextInput 1: 24, Input 2: 6 -> Click Division (/) -> Result: 4.0
Input 1: 10, Input 2: 0 -> Click Division (/) -> Result: Error: Division by zero
Q3. Student Login Form - SwingQuestion: Create a Swing login form with JLabel/JTextField for username, JLabel/JPasswordField for password, Login and Reset buttons. On Login, compare with predefined credentials and display the result using JOptionPane.   Javaimport java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q3_SwingLoginForm extends JFrame implements ActionListener {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin, btnReset;

    private static final String VALID_USER = "student@coer";
    private static final String VALID_PASS = "java123";

    public Q3_SwingLoginForm() {
        setTitle("Student Login Form (Swing)");
        setSize(360, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("  Username:"));
        tfUsername = new JTextField();
        add(tfUsername);

        add(new JLabel("  Password:"));
        pfPassword = new JPasswordField();
        add(pfPassword);

        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");
        btnLogin.addActionListener(this);
        btnReset.addActionListener(this);

        add(btnLogin);
        add(btnReset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String user = tfUsername.getText().trim();
            String pass = new String(pfPassword.getPassword());

            if (user.equals(VALID_USER) && pass.equals(VALID_PASS)) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + user,
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password.",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReset) {
            tfUsername.setText("");
            pfPassword.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q3_SwingLoginForm::new);
    }
}
Sample Output:PlaintextDialog: "Login Successful! Welcome, student@coer" (or "Invalid Username or Password.")
Q4. Student Marksheet GUI - SwingQuestion: Create a Swing application accepting marks for English, Mathematics, Java, DBMS and Computer Networks. Add a Calculate Result button to display total, percentage, grade and pass/fail status.   Javaimport java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q4_SwingMarksheet extends JFrame implements ActionListener {
    private JTextField tfEnglish, tfMath, tfJava, tfDbms, tfCn;
    private JButton btnCalculate;
    private JLabel lblTotal, lblPercentage, lblGrade, lblStatus;

    public Q4_SwingMarksheet() {
        setTitle("Student Marksheet GUI (Swing)");
        setSize(400, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 8, 6));

        add(new JLabel("  English (out of 100):"));
        tfEnglish = new JTextField();
        add(tfEnglish);

        add(new JLabel("  Mathematics (out of 100):"));
        tfMath = new JTextField();
        add(tfMath);

        add(new JLabel("  Java (out of 100):"));
        tfJava = new JTextField();
        add(tfJava);

        add(new JLabel("  DBMS (out of 100):"));
        tfDbms = new JTextField();
        add(tfDbms);

        add(new JLabel("  Computer Networks (out of 100):"));
        tfCn = new JTextField();
        add(tfCn);

        add(new JLabel(""));
        btnCalculate = new JButton("Calculate Result");
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        lblTotal = new JLabel("  Total: -");
        lblPercentage = new JLabel("  Percentage: -");
        lblGrade = new JLabel("  Grade: -");
        lblStatus = new JLabel("  Status: -");

        add(lblTotal);
        add(lblPercentage);
        add(lblGrade);
        add(lblStatus);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double m1 = Double.parseDouble(tfEnglish.getText().trim());
            double m2 = Double.parseDouble(tfMath.getText().trim());
            double m3 = Double.parseDouble(tfJava.getText().trim());
            double m4 = Double.parseDouble(tfDbms.getText().trim());
            double m5 = Double.parseDouble(tfCn.getText().trim());

            double total = m1 + m2 + m3 + m4 + m5;
            double percentage = total / 5.0;
            boolean passed = m1 >= 35 && m2 >= 35 && m3 >= 35 && m4 >= 35 && m5 >= 35;

            String grade;
            if (!passed) {
                grade = "F";
            } else if (percentage >= 90) {
                grade = "A+";
            } else if (percentage >= 75) {
                grade = "A";
            } else if (percentage >= 60) {
                grade = "B";
            } else if (percentage >= 50) {
                grade = "C";
            } else {
                grade = "D";
            }

            lblTotal.setText("  Total: " + total + " / 500");
            lblPercentage.setText(String.format("  Percentage: %.2f%%", percentage));
            lblGrade.setText("  Grade: " + grade);
            lblStatus.setText("  Status: " + (passed ? "PASS" : "FAIL"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all subjects.",
                    "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q4_SwingMarksheet::new);
    }
}
Sample Output:PlaintextTotal: 430.0 / 500 | Percentage: 86.00% | Grade: A | Status: PASS
Q5. Course Selection Form - SwingQuestion: Create a Swing GUI with Student Name (JTextField), Course (JComboBox), Gender (JRadioButton), Subjects (multiple JCheckBox), Submit and Reset buttons. Submit should display all selected information using JOptionPane.   Javaimport java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Q5_SwingCourseSelection extends JFrame implements ActionListener {
    private JTextField tfName;
    private JComboBox<String> cbCourse;
    private JRadioButton rbMale, rbFemale;
    private ButtonGroup bgGender;
    private JCheckBox chkJava, chkPython, chkSql, chkOs;
    private JButton btnSubmit, btnReset;

    public Q5_SwingCourseSelection() {
        setTitle("Course Selection Form (Swing)");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

        add(new JLabel("Student Name:"));
        tfName = new JTextField(22);
        add(tfName);

        add(new JLabel("Course:"));
        cbCourse = new JComboBox<>(new String[]{"BCA", "B.Sc IT", "MCA", "B.Tech CSE"});
        add(cbCourse);

        add(new JLabel("Gender:"));
        rbMale = new JRadioButton("Male", true);
        rbFemale = new JRadioButton("Female");
        bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);
        add(rbMale);
        add(rbFemale);

        add(new JLabel("Subjects:"));
        chkJava = new JCheckBox("Java");
        chkPython = new JCheckBox("Python");
        chkSql = new JCheckBox("SQL/DBMS");
        chkOs = new JCheckBox("Operating Systems");
        add(chkJava);
        add(chkPython);
        add(chkSql);
        add(chkOs);

        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        add(btnSubmit);
        add(btnReset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            ArrayList<String> selectedSubs = new ArrayList<>();
            if (chkJava.isSelected()) selectedSubs.add("Java");
            if (chkPython.isSelected()) selectedSubs.add("Python");
            if (chkSql.isSelected()) selectedSubs.add("SQL/DBMS");
            if (chkOs.isSelected()) selectedSubs.add("Operating Systems");

            String gender = rbMale.isSelected() ? "Male" : "Female";
            String summary = "Student: " + tfName.getText().trim()
                    + "\nCourse: " + cbCourse.getSelectedItem()
                    + "\nGender: " + gender
                    + "\nSubjects: " + (selectedSubs.isEmpty() ? "None" : String.join(", ", selectedSubs));

            JOptionPane.showMessageDialog(this, summary, "Selection Summary", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            cbCourse.setSelectedIndex(0);
            rbMale.setSelected(true);
            chkJava.setSelected(false);
            chkPython.setSelected(false);
            chkSql.setSelected(false);
            chkOs.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q5_SwingCourseSelection::new);
    }
}
Sample Output (JOptionPane):PlaintextStudent: Aarav
Course: BCA
Gender: Male
Subjects: Java, SQL/DBMS
Q6. Employee Registration Form - AWTQuestion: Create an AWT Employee Registration Form with Employee ID, Name, Department, Designation, Salary, Gender, Department selection, Submit and Clear buttons. Display submitted information in a TextArea and clear fields using Clear.   Javaimport java.awt.*;
import java.awt.event.*;

public class Q6_AWTEmployeeRegistration extends Frame implements ActionListener {
    private TextField tfId, tfName, tfDesignation, tfSalary;
    private Choice chDept;
    private CheckboxGroup genderGroup;
    private Checkbox cbMale, cbFemale;
    private Button btnSubmit, btnClear;
    private TextArea taOutput;

    public Q6_AWTEmployeeRegistration() {
        setTitle("Employee Registration Form (AWT)");
        setSize(480, 480);
        setLayout(new FlowLayout(FlowLayout.LEFT, 12, 8));

        add(new Label("Employee ID:"));
        tfId = new TextField(24);
        add(tfId);

        add(new Label("Name:"));
        tfName = new TextField(24);
        add(tfName);

        add(new Label("Department:"));
        chDept = new Choice();
        chDept.add("IT");
        chDept.add("HR");
        chDept.add("Finance");
        chDept.add("Operations");
        add(chDept);

        add(new Label("Designation:"));
        tfDesignation = new TextField(24);
        add(tfDesignation);

        add(new Label("Salary:"));
        tfSalary = new TextField(24);
        add(tfSalary);

        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        cbMale = new Checkbox("Male", genderGroup, true);
        cbFemale = new Checkbox("Female", genderGroup, false);
        add(cbMale);
        add(cbFemale);

        btnSubmit = new Button("Submit");
        btnClear = new Button("Clear");
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        add(btnSubmit);
        add(btnClear);

        taOutput = new TextArea(7, 50);
        taOutput.setEditable(false);
        add(taOutput);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String gender = genderGroup.getSelectedCheckbox().getLabel();
            taOutput.setText("ID: " + tfId.getText()
                    + "\nName: " + tfName.getText()
                    + "\nDepartment: " + chDept.getSelectedItem()
                    + "\nDesignation: " + tfDesignation.getText()
                    + "\nSalary: " + tfSalary.getText()
                    + "\nGender: " + gender);
        } else if (e.getSource() == btnClear) {
            tfId.setText("");
            tfName.setText("");
            chDept.select(0);
            tfDesignation.setText("");
            tfSalary.setText("");
            genderGroup.setSelectedCheckbox(cbMale);
            taOutput.setText("");
        }
    }

    public static void main(String[] args) {
        new Q6_AWTEmployeeRegistration();
    }
}
Sample Output (in TextArea):PlaintextID: E105
Name: Neha Verma
Department: IT
Designation: Software Developer
Salary: 52000
Gender: Female
Q7. Temperature Converter - SwingQuestion: Create a Swing temperature converter with a temperature TextField, Celsius-to-Fahrenheit and Fahrenheit-to-Celsius radio buttons, Convert and Clear buttons, and result display. Use $F = (C \times 9/5) + 32$ and $C = (F - 32) \times 5/9$. Handle invalid input.   Javaimport java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q7_SwingTemperatureConverter extends JFrame implements ActionListener {
    private JTextField tfTemp;
    private JRadioButton rbCtoF, rbFtoC;
    private ButtonGroup bgMode;
    private JButton btnConvert, btnClear;
    private JLabel lblResult;

    public Q7_SwingTemperatureConverter() {
        setTitle("Temperature Converter (Swing)");
        setSize(380, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

        add(new JLabel("Enter Temperature:"));
        tfTemp = new JTextField(16);
        add(tfTemp);

        rbCtoF = new JRadioButton("Celsius to Fahrenheit", true);
        rbFtoC = new JRadioButton("Fahrenheit to Celsius");
        bgMode = new ButtonGroup();
        bgMode.add(rbCtoF);
        bgMode.add(rbFtoC);
        add(rbCtoF);
        add(rbFtoC);

        btnConvert = new JButton("Convert");
        btnClear = new JButton("Clear");
        btnConvert.addActionListener(this);
        btnClear.addActionListener(this);
        add(btnConvert);
        add(btnClear);

        lblResult = new JLabel("Result: -");
        add(lblResult);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvert) {
            try {
                double val = Double.parseDouble(tfTemp.getText().trim());
                if (rbCtoF.isSelected()) {
                    double f = (val * 9.0 / 5.0) + 32.0;
                    lblResult.setText(String.format("Result: %.2f °F", f));
                } else {
                    double c = (val - 32.0) * 5.0 / 9.0;
                    lblResult.setText(String.format("Result: %.2f °C", c));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a numeric temperature.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            tfTemp.setText("");
            lblResult.setText("Result: -");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q7_SwingTemperatureConverter::new);
    }
}
Sample Output:PlaintextInput: 25 -> Celsius to Fahrenheit -> Result: 77.00 °F
Input: 98.6 -> Fahrenheit to Celsius -> Result: 37.00 °C
Q8. Simple Notepad - SwingQuestion: Create a basic Swing Notepad with JTextArea and a menu bar containing File → New, Open, Save and Exit. New clears the text area; Open selects a text file; Save writes the contents to a file; Exit closes the application.   Javaimport java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Q8_SwingNotepad extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JMenuItem miNew, miOpen, miSave, miExit;

    public Q8_SwingNotepad() {
        setTitle("Simple Notepad (Swing)");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        miNew = new JMenuItem("New");
        miOpen = new JMenuItem("Open");
        miSave = new JMenuItem("Save");
        miExit = new JMenuItem("Exit");

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miExit.addActionListener(this);

        fileMenu.add(miNew);
        fileMenu.add(miOpen);
        fileMenu.add(miSave);
        fileMenu.addSeparator();
        fileMenu.add(miExit);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miNew) {
            textArea.setText("");
        } else if (e.getSource() == miOpen) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == miSave) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(textArea.getText());
                    JOptionPane.showMessageDialog(this, "Saved to " + file.getName());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == miExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q8_SwingNotepad::new);
    }
}
Sample Output:PlaintextMenu File -> New clears JTextArea; Open loads selected .txt file; Save writes text to file; Exit terminates app.
Q9. Student Feedback Form - SwingQuestion: Create a Swing Student Feedback Form with Student Name, Roll Number, Course, rating radio buttons (Excellent, Very Good, Good, Average, Poor), feedback checkboxes (Teaching, Laboratory, Course Material, Assignments), Comments JTextArea, Submit and Reset. Submit should display all feedback using JOptionPane.   Javaimport java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Q9_SwingFeedbackForm extends JFrame implements ActionListener {
    private JTextField tfName, tfRoll, tfCourse;
    private JRadioButton rbExc, rbVg, rbGood, rbAvg, rbPoor;
    private ButtonGroup bgRating;
    private JCheckBox cbTeaching, cbLab, cbMaterial, cbAssignments;
    private JTextArea taComments;
    private JButton btnSubmit, btnReset;

    public Q9_SwingFeedbackForm() {
        setTitle("Student Feedback Form (Swing)");
        setSize(460, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT, 12, 8));

        add(new JLabel("Name:"));
        tfName = new JTextField(14);
        add(tfName);

        add(new JLabel("Roll No:"));
        tfRoll = new JTextField(10);
        add(tfRoll);

        add(new JLabel("Course:"));
        tfCourse = new JTextField(12);
        add(tfCourse);

        add(new JLabel("Overall Rating:"));
        rbExc = new JRadioButton("Excellent", true);
        rbVg = new JRadioButton("Very Good");
        rbGood = new JRadioButton("Good");
        rbAvg = new JRadioButton("Average");
        rbPoor = new JRadioButton("Poor");
        bgRating = new ButtonGroup();
        for (JRadioButton rb : new JRadioButton[]{rbExc, rbVg, rbGood, rbAvg, rbPoor}) {
            bgRating.add(rb);
            add(rb);
        }

        add(new JLabel("Feedback Areas:"));
        cbTeaching = new JCheckBox("Teaching");
        cbLab = new JCheckBox("Laboratory");
        cbMaterial = new JCheckBox("Course Material");
        cbAssignments = new JCheckBox("Assignments");
        add(cbTeaching);
        add(cbLab);
        add(cbMaterial);
        add(cbAssignments);

        add(new JLabel("Comments:"));
        taComments = new JTextArea(4, 35);
        add(new JScrollPane(taComments));

        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        add(btnSubmit);
        add(btnReset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String rating = rbExc.isSelected() ? "Excellent"
                    : rbVg.isSelected() ? "Very Good"
                    : rbGood.isSelected() ? "Good"
                    : rbAvg.isSelected() ? "Average" : "Poor";

            ArrayList<String> areas = new ArrayList<>();
            if (cbTeaching.isSelected()) areas.add("Teaching");
            if (cbLab.isSelected()) areas.add("Laboratory");
            if (cbMaterial.isSelected()) areas.add("Course Material");
            if (cbAssignments.isSelected()) areas.add("Assignments");

            String msg = "Student: " + tfName.getText().trim() + " (" + tfRoll.getText().trim() + ")"
                    + "\nCourse: " + tfCourse.getText().trim()
                    + "\nRating: " + rating
                    + "\nAreas: " + (areas.isEmpty() ? "None" : String.join(", ", areas))
                    + "\nComments: " + taComments.getText().trim();

            JOptionPane.showMessageDialog(this, msg, "Feedback Submitted", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnReset) {
            tfName.setText("");
            tfRoll.setText("");
            tfCourse.setText("");
            rbExc.setSelected(true);
            cbTeaching.setSelected(false);
            cbLab.setSelected(false);
            cbMaterial.setSelected(false);
            cbAssignments.setSelected(false);
            taComments.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q9_SwingFeedbackForm::new);
    }
}
Sample Output (JOptionPane):PlaintextStudent: Diya (104)
Course: BCA
Rating: Very Good
Areas: Teaching, Laboratory
Comments: Helpful lab sessions.
Q10. Mini Banking GUI Application - SwingQuestion: Create a Swing Mini Banking Application with Account Number, Customer Name, Current Balance, Amount and buttons Deposit, Withdraw, Check Balance and Clear. Deposit adds amount; Withdraw subtracts it only when sufficient balance exists; Check Balance displays balance; Clear clears inputs. Use JOptionPane for messages.   Javaimport java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q10_SwingMiniBanking extends JFrame implements ActionListener {
    private JTextField tfAccNo, tfCustomer, tfBalance, tfAmount;
    private JButton btnDeposit, btnWithdraw, btnCheckBalance, btnClear;

    public Q10_SwingMiniBanking() {
        setTitle("Mini Banking GUI Application (Swing)");
        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 8));

        add(new JLabel("  Account Number:"));
        tfAccNo = new JTextField("ACC1001");
        add(tfAccNo);

        add(new JLabel("  Customer Name:"));
        tfCustomer = new JTextField("Customer");
        add(tfCustomer);

        add(new JLabel("  Current Balance:"));
        tfBalance = new JTextField("5000.0");
        add(tfBalance);

        add(new JLabel("  Amount:"));
        tfAmount = new JTextField();
        add(tfAmount);

        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnCheckBalance = new JButton("Check Balance");
        btnClear = new JButton("Clear");

        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnCheckBalance.addActionListener(this);
        btnClear.addActionListener(this);

        add(btnDeposit);
        add(btnWithdraw);
        add(btnCheckBalance);
        add(btnClear);

        setVisible(true);
    }

    private double parseBalance() {
        return Double.parseDouble(tfBalance.getText().trim());
    }

    private double parseAmount() {
        double amt = Double.parseDouble(tfAmount.getText().trim());
        if (amt <= 0) {
            throw new NumberFormatException("Amount must be positive.");
        }
        return amt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheckBalance) {
            try {
                double bal = parseBalance();
                JOptionPane.showMessageDialog(this,
                        "Account: " + tfAccNo.getText().trim()
                                + "\nHolder: " + tfCustomer.getText().trim()
                                + String.format("\nCurrent Balance: %.2f", bal),
                        "Balance Inquiry", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid current balance value.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnDeposit) {
            try {
                double bal = parseBalance();
                double amt = parseAmount();
                bal += amt;
                tfBalance.setText(String.format("%.2f", bal));
                tfAmount.setText("");
                JOptionPane.showMessageDialog(this, String.format("Deposited %.2f. New Balance: %.2f", amt, bal),
                        "Deposit Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid positive amount and balance.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnWithdraw) {
            try {
                double bal = parseBalance();
                double amt = parseAmount();
                if (amt > bal) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance! Withdrawal declined.",
                            "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                } else {
                    bal -= amt;
                    tfBalance.setText(String.format("%.2f", bal));
                    tfAmount.setText("");
                    JOptionPane.showMessageDialog(this, String.format("Withdrawn %.2f. Remaining Balance: %.2f", amt, bal),
                            "Withdraw Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid positive amount and balance.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            tfAccNo.setText("");
            tfCustomer.setText("");
            tfBalance.setText("");
            tfAmount.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q10_SwingMiniBanking::new);
    }
}
Sample Output (JOptionPane):PlaintextCurrent Balance: 5000.0 -> Amount: 1500 -> Deposit -> "Deposited 1500.00. New Balance: 6500.00"
Amount: 9000 -> Withdraw -> "Insufficient balance! Withdrawal declined."