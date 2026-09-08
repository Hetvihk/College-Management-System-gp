import java.util.Scanner;

// ================= MAIN CLASS CMS =================
class CollegeManagementSystem {
    static Admin admin = new Admin();

    static {
        System.out.println("===== WELCOME TO COLLEGE MANAGEMENT SYSTEM =====");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        Faculty faculty = new Faculty();

        while (true) {

            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Faculty");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = sc.nextLine();

            if (input.length() != 1 || input.charAt(0) < '1' || input.charAt(0) > '4') {
                System.out.println("Invalid choice!");
                continue;
            }

            int choice = input.charAt(0) - '0';


            switch (choice) {
                case 1 -> admin.adminLogin();
                case 2 -> student.studentLogin();
                case 3 -> faculty.facultyLogin();
                case 4 -> {
                    System.out.println("System Closed.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

}


// ================= ADMIN CLASS =================

class Admin {

    Scanner sc = new Scanner(System.in);
    static final String ADMIN_USER = "admin";
    static final String ADMIN_PASS = "admin123";

    static int studentCount, facultyCount, branchCount;
    static int attendanceCount, resultCount, bookCount, issuedCount;


    Student[] students = new Student[100];

    {
        students[studentCount++] = new Student(1, "Rahul", "CE", "R@gmail.com");
        students[studentCount++] = new Student(2, "Rashi", "AIML", "Ra@gmail.com");
        students[studentCount++] = new Student(3, "Taksh", "CST", "T@gmail.com");
        students[studentCount++] = new Student(4, "Aryan", "CSE", "A@gmail.com");
        students[studentCount++] = new Student(5, "Manoj", "ME", "M@gmail.com");

    }

    Faculty[] faculty = new Faculty[50];

    {
        faculty[facultyCount++] = new Faculty(1, "VSA", "MATHS");
        faculty[facultyCount++] = new Faculty(2, "RRR", "JAVA");
        faculty[facultyCount++] = new Faculty(3, "ASR", "PHYSICS");
        faculty[facultyCount++] = new Faculty(4, "ANR", "SE");
        faculty[facultyCount++] = new Faculty(5, "DAM", "ES");


    }

    Branch[] branches = new Branch[20];

    {
        branches[branchCount++] = new Branch("CE", 45000);
        branches[branchCount++] = new Branch("AIML", 55000);
        branches[branchCount++] = new Branch("CST", 35000);
        branches[branchCount++] = new Branch("CSE", 75000);
        branches[branchCount++] = new Branch("ME", 20000);

    }

    Attendance[] attendance = new Attendance[200];

    {
        attendance[attendanceCount++] = new Attendance(1, "MATHS", 85);
        attendance[attendanceCount++] = new Attendance(2, "JAVA", 72);
        attendance[attendanceCount++] = new Attendance(3, "PHYSICS", 90);
        attendance[attendanceCount++] = new Attendance(4, "SE", 65);
        attendance[attendanceCount++] = new Attendance(5, "ES", 88);
    }

    Result[] results = new Result[200];

    {
        results[resultCount++] = new Result(1, "MATHS", 78);
        results[resultCount++] = new Result(2, "JAVA", 92);
        results[resultCount++] = new Result(3, "PHYSICS", 66);
        results[resultCount++] = new Result(4, "SE", 34);   // fail case
        results[resultCount++] = new Result(5, "ES", 95);   // scholarship case
    }

    Library[] library = new Library[50];

    {
        library[bookCount++] = new Library(101, "Java Programming", "Herbert Schildt", 5);
        library[bookCount++] = new Library(102, "Data Structures", "Seymour Lipschutz", 4);
        library[bookCount++] = new Library(103, "Operating System", "Galvin", 3);
        library[bookCount++] = new Library(104, "DBMS", "Korth", 6);
        library[bookCount++] = new Library(105, "Software Engineering", "Pressman", 2);
    }

    IssuedBook[] issuedBooks = new IssuedBook[200];

    {
        issuedBooks[issuedCount++] = new IssuedBook(1, "Rahul", "Java Programming");
        issuedBooks[issuedCount++] = new IssuedBook(2, "Rashi", "Data Structures");
        issuedBooks[issuedCount++] = new IssuedBook(3, "Taksh", "DBMS");
    }

    {
        for (int i = 0; i < issuedCount; i++) {
            for (int j = 0; j < bookCount; j++) {

                if (issuedBooks[i].bookTitle.equals(library[j].title)) {
                    library[j].qty--;
                    break;
                }
            }
        }
    }

    Person person = new Person();


    void adminLogin() {
        while (true) {
            System.out.print("Admin Username: ");
            String user = sc.nextLine();
            System.out.print("Admin Password: ");
            String pass = sc.nextLine();

            if (user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)) {
                adminMenu();
                return;
            }
            System.out.println("Invalid Admin Credentials!");
        }
    }

    void adminMenu() {
        while (true) {
            System.out.println("------ ADMIN MENU ------");
            System.out.println("1. Student Management");
            System.out.println("2. Faculty Management");
            System.out.println("3. Branch Management");
            System.out.println("4. Library Management");
            System.out.println("5. Logout");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> studentManagementMenu();
                case "2" -> facultyManagementMenu();
                case "3" -> branchManagementMenu();
                case "4" -> libraryManagementMenu();
                case "5" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    void studentManagementMenu() {
        while (true) {
            System.out.println("--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Students by Name");
            System.out.println("6. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> addStudent();
                case "2" -> viewStudents();
                case "3" -> updateStudent();
                case "4" -> deleteStudent();
                case "5" -> {
                    sortStudentsByName();
                    viewStudents();
                }
                case "6" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    void facultyManagementMenu() {
        while (true) {
            System.out.println("--- FACULTY MANAGEMENT ---");
            System.out.println("1. Add Faculty");
            System.out.println("2. View Faculty");
            System.out.println("3. Update Faculty");
            System.out.println("4. Delete Faculty");
            System.out.println("5. Sort Faculty by Name");
            System.out.println("6. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> addFaculty();
                case "2" -> viewFaculty();
                case "3" -> updateFaculty();
                case "4" -> deleteFaculty();
                case "5" -> {
                    sortFacultyByName();
                    viewFaculty();
                }
                case "6" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }


    void branchManagementMenu() {
        while (true) {
            System.out.println("--- BRANCH MANAGEMENT ---");
            System.out.println("1. Add Branch");
            System.out.println("2. View Branches");
            System.out.println("3. Sort Fees (Low to High)");
            System.out.println("4. Sort Fees (High to Low)");
            System.out.println("5. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> addBranch();
                case "2" -> viewBranches();
                case "3" -> {
                    sortBranchesByFees();
                    viewBranches();
                }
                case "4" -> {
                    sortBranchesByFeesDesc();
                    viewBranches();
                }
                case "5" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }


    void libraryManagementMenu() {
        while (true) {
            System.out.println("--- LIBRARY MANAGEMENT ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Library");
            System.out.println("3. Issue Book");
            System.out.println("4. View Issued Books");
            System.out.println("5. Return Book");
            System.out.println("6. Back");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> addBook();
                case "2" -> viewLibrary();
                case "3" -> issueBook();
                case "4" -> viewIssuedBooks();
                case "5" -> returnBook();
                case "6" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    void returnBook() {

        if (issuedCount == 0) {
            System.out.println("No issued books to return!");
            return;
        }

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book ID: ");
        int bid = sc.nextInt();
        sc.nextLine();

        String bookTitle = getBookTitleById(bid);

        if (bookTitle == null) {
            System.out.println("Invalid Book ID!");
            return;
        }

        for (int i = 0; i < issuedCount; i++) {

            if (issuedBooks[i].studentId == sid &&
                    issuedBooks[i].bookTitle.equalsIgnoreCase(bookTitle)) {

                // restore quantity
                for (int j = 0; j < bookCount; j++) {
                    if (library[j].id == bid) {
                        library[j].qty++;
                        break;
                    }
                }

                // remove issued book record (shift logic)
                issuedBooks[i] = issuedBooks[issuedCount - 1];
                issuedBooks[issuedCount - 1] = null;
                issuedCount--;

                System.out.println("Book Returned Successfully!");
                return;
            }
        }

        System.out.println("Issued record not found!");
    }


    void updateStudent() {

        if (studentCount == 0) {
            System.out.println("No student available to update!");
            return;
        }

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id) {

                System.out.println("Current Name: " + students[i].name);
                System.out.print("Enter New Name: ");
                students[i].name = sc.nextLine();

                System.out.println("Current Branch: " + students[i].branch);

                System.out.println("Available Branches:");
                for (int b = 0; b < branchCount; b++) {
                    System.out.println((b + 1) + ". " + branches[b].name);
                }

                int branchChoice;
                while (true) {
                    System.out.print("Select New Branch Number: ");
                    String input = sc.nextLine();

                    if (input.length() == 1 &&
                            input.charAt(0) >= '1' &&
                            input.charAt(0) <= (char) ('0' + branchCount)) {

                        branchChoice = input.charAt(0) - '0';
                        break;
                    }
                    System.out.println("Invalid Branch Selection!");
                }

                students[i].branch = branches[branchChoice - 1].name;


                System.out.println("Current email: " + students[i].email);

                String newEmail;
                while (true) {
                    System.out.print("Enter New Email: ");
                    newEmail = sc.nextLine();

                    if (person.isValidEmail(newEmail)) {
                        break;
                    }
                    System.out.println("Invalid Email! Must be a valid @gmail.com");
                }

                students[i].email = newEmail;


                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student ID not found!");
    }

    void updateFaculty() {

        if (facultyCount == 0) {
            System.out.println("No faculty available to update!");
            return;
        }

        System.out.print("Enter Faculty ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < facultyCount; i++) {
            if (faculty[i].id == id) {

                System.out.println("Current Name: " + faculty[i].name);
                System.out.print("Enter New Name: ");
                faculty[i].name = sc.nextLine();

                System.out.println("Current Subject: " + faculty[i].subject);
                System.out.print("Enter New Subject: ");
                faculty[i].subject = sc.nextLine();


                System.out.println("Faculty Updated Successfully!");
                return;
            }
        }

        System.out.println("Faculty ID not found!");
    }

    void deleteStudent() {

        if (studentCount == 0) {
            System.out.println("No students available to delete!");
            return;
        }

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < studentCount; i++) {

            if (students[i].id == id) {

                // Shift elements left
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[studentCount - 1] = null;
                studentCount--;

                // Remove attendance
                for (int a = 0; a < attendanceCount; a++) {
                    if (attendance[a].studentId == id) {
                        attendance[a] = attendance[--attendanceCount];
                        a--;
                    }
                }

                // Remove results
                for (int r = 0; r < resultCount; r++) {
                    if (results[r].studentId == id) {
                        results[r] = results[--resultCount];
                        r--;
                    }
                }

                // Remove issued books
                for (int b = 0; b < issuedCount; b++) {
                    if (issuedBooks[b].studentId == id) {

                        // restore book quantity
                        for (int k = 0; k < bookCount; k++) {
                            if (library[k].title.equalsIgnoreCase(issuedBooks[b].bookTitle)) {
                                library[k].qty++;
                                break;
                            }
                        }

                        issuedBooks[b] = issuedBooks[--issuedCount];
                        b--;
                    }

                }


                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student ID not found!");
    }

    void deleteFaculty() {

        if (facultyCount == 0) {
            System.out.println("No faculty available to delete!");
            return;
        }

        System.out.print("Enter Faculty ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < facultyCount; i++) {

            if (faculty[i].id == id) {

                // Shift elements left
                for (int j = i; j < facultyCount - 1; j++) {
                    faculty[j] = faculty[j + 1];
                }

                faculty[facultyCount - 1] = null;
                facultyCount--;

                System.out.println("Faculty Deleted Successfully!");
                return;
            }
        }

        System.out.println("Faculty ID not found!");
    }

    void sortBranchesByFees() {

        if (branchCount == 0) {
            System.out.println("No Branches to sort!");
            return;
        }

        for (int i = 0; i < branchCount - 1; i++) {
            for (int j = 0; j < branchCount - i - 1; j++) {

                if (branches[j].fees > branches[j + 1].fees) {

                    Branch temp = branches[j];
                    branches[j] = branches[j + 1];
                    branches[j + 1] = temp;
                }
            }
        }

        System.out.println("Branches sorted by fees (Low to High)!");
    }

    void sortBranchesByFeesDesc() {

        if (branchCount == 0) {
            System.out.println("No Branches to sort!");
            return;
        }

        for (int i = 0; i < branchCount - 1; i++) {
            for (int j = 0; j < branchCount - i - 1; j++) {

                if (branches[j].fees < branches[j + 1].fees) {

                    Branch temp = branches[j];
                    branches[j] = branches[j + 1];
                    branches[j + 1] = temp;
                }
            }
        }

        System.out.println("Branches sorted by fees (High to Low)!");
    }


    void sortStudentsByName() {

        if (studentCount == 0) {
            System.out.println("No students to sort!");
            return;
        }

        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {

                if (students[j].name.compareToIgnoreCase(students[j + 1].name) > 0) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Students sorted alphabetically by name!");
    }


    void sortFacultyByName() {

        if (facultyCount == 0) {
            System.out.println("No faculty to sort!");
            return;
        }

        for (int i = 0; i < facultyCount - 1; i++) {
            for (int j = 0; j < facultyCount - i - 1; j++) {

                if (faculty[j].name.compareToIgnoreCase(faculty[j + 1].name) > 0) {

                    Faculty temp = faculty[j];
                    faculty[j] = faculty[j + 1];
                    faculty[j + 1] = temp;
                }
            }
        }

        System.out.println("Faculty sorted alphabetically by name!");
    }


    void addStudent() {

        if (studentCount == students.length) {
            System.out.println("Students limit reached!");
            return;
        }

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.println("Available Branches:");
        for (int i = 0; i < branchCount; i++) {
            System.out.println((i + 1) + ". " + branches[i].name);
        }

        System.out.print("Select Branch number: ");
        String input = sc.nextLine();

        int branchChoice = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch < '0' || ch > '9') {
                System.out.println("Invalid Branch Selection!");
                return;
            }

            branchChoice = branchChoice * 10 + (ch - '0');

            if (branchChoice > branchCount) {
                System.out.println("Invalid Branch Selection!");
                return;
            }
        }

        if (branchChoice < 1) {
            System.out.println("Invalid Branch Selection!");
            return;
        }


        if (branchChoice < 1 || branchChoice > branchCount) {
            System.out.println("Invalid Branch Selection!");
            return;
        }

        String branch = branches[branchChoice - 1].name;

        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (person.isValidEmail(email)) break;
            System.out.println("Invalid Email!");
        }

        students[studentCount++] = new Student(id, name, branch, email);
        System.out.println("Student Added Successfully!");
    }

    Faculty findFacultyById(int id) {
        for (int i = 0; i < facultyCount; i++) {
            if (faculty[i].id == id) {
                return faculty[i];
            }
        }
        return null;
    }

    void addFaculty() {
        if (facultyCount == faculty.length) {
            System.out.println("Faculty limit reached!");
            return;
        }

        System.out.print("Faculty ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findFacultyById(id) != null) {
            System.out.println("Faculty ID already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Subject: ");
        String subject = sc.nextLine();

        faculty[facultyCount++] = new Faculty(id, name, subject);
        System.out.println("Faculty Added Successfully!");
    }

    void addBranch() {
        if (branchCount == branches.length) {
            System.out.println("Branch limit reached!");
            return;
        }

        System.out.print("Branch Name: ");
        String name = sc.nextLine();

        for (int i = 0; i < branchCount; i++) {
            if (branches[i].name.equalsIgnoreCase(name)) {
                System.out.println("Branch already exists!");
                return;
            }
        }


        System.out.print("Fees: ");
        double fees = sc.nextDouble();
        sc.nextLine();

        branches[branchCount++] = new Branch(name, fees);
        System.out.println("Branch Added!");
    }

    void addBook() {
        if (bookCount == library.length) {
            System.out.println("Book limit reached!");
            return;
        }

        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        library[bookCount++] = new Library(id, title, author, qty);
        System.out.println("Book Added!");
    }

    void issueBook() {
        if (issuedCount == issuedBooks.length) {
            System.out.println("Issued books limit reached!");
            return;
        }

        System.out.print("Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(sid);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Book ID: ");
        int bid = sc.nextInt();
        sc.nextLine();

        String bookTitle = getBookTitleById(bid);
        if (bookTitle == null) {
            System.out.println("Invalid Book ID!");
            return;
        }


        for (int i = 0; i < issuedCount; i++) {
            if (issuedBooks[i].studentId == sid && issuedBooks[i].bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book already issued to this student!");
                return;
            }
        }

        for (int i = 0; i < bookCount; i++) {
            if (library[i].id == bid && library[i].qty > 0) {
                library[i].qty--;
                issuedBooks[issuedCount++] = new IssuedBook(sid, s.name, library[i].title);
                System.out.println("Book Issued Successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    String getBookTitleById(int bid) {
        for (int i = 0; i < bookCount; i++) {
            if (library[i].id == bid) {
                return library[i].title;
            }
        }
        return null;
    }


    void viewIssuedBooks() {

        if (issuedCount == 0) {
            System.out.println("No issued books found!");
            return;
        }

        System.out.println("STUDENT ID | STUDENT NAME | BOOK TITLE");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < issuedCount; i++) {
            issuedBooks[i].display();
        }
    }


    void viewStudents() {

        if (studentCount == 0) {
            System.out.println("No students to display!");
            return;
        }

        System.out.println("ID | NAME | Branch | EMAIL");
        System.out.println("--------------------------------");

        for (int i = 0; i < studentCount; i++) {
            students[i].display();
        }
    }


    void viewFaculty() {

        if (facultyCount == 0) {
            System.out.println("No faculty to display!");
            return;
        }

        System.out.println("ID | NAME | SUBJECT");
        System.out.println("-----------------------");

        for (int i = 0; i < facultyCount; i++) {
            faculty[i].display();
        }
    }


    void viewBranches() {

        if (branchCount == 0) {
            System.out.println("No Branches to display!");
            return;
        }

        System.out.println("Branch | FEES");
        System.out.println("----------------");

        for (int i = 0; i < branchCount; i++) {
            branches[i].display();
        }
    }


    Student findStudent(int id) {
        for (int i = 0; i < studentCount; i++)
            if (students[i].id == id) return students[i];
        return null;
    }

    void viewLibrary() {

        if (bookCount == 0) {
            System.out.println("No books in library!");
            return;
        }

        System.out.println("ID | TITLE | AUTHOR | QTY");
        System.out.println("--------------------------------");

        for (int i = 0; i < bookCount; i++) {
            library[i].display();
        }
    }


}

// ================= SUPER CLASS PERSON =================
class Person {
    int id;
    String name;

    Person(int i, String n) {
        id = i;
        name = n;
    }

    Person() {

    }


    boolean isValidEmail(String email) {

        if (!email.endsWith("@gmail.com")) {
            return false;
        }


        if (email.length() <= 10) {
            return false;
        }


        for (int i = 0; i < email.indexOf("@"); i++) {
            char c = email.charAt(i);

            if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }

        return true;
    }

}

// ================= SUB CLASS STUDENT =================
class Student extends Person {
    Scanner sc = new Scanner(System.in);
    String branch, email;
    String password = "1234";
    Attendance attendance = new Attendance();
    Result result = new Result();
    Branch branchobj = new Branch();
    IssuedBook ib = new IssuedBook();

    Student(int id, String name, String c, String e) {
        super(id, name);
        branch = c;
        email = e;
    }

    Student() {

    }

    void display() {
        System.out.println(id + " | " + name + " | " + branch + " | " + email);
    }

    void studentLogin() {
        if (CollegeManagementSystem.admin.studentCount == 0) {
            System.out.println("No students added by admin.");
            return;
        }

        System.out.println("--- STUDENT LIST ---");
        for (int i = 0; i < CollegeManagementSystem.admin.studentCount; i++) {
            System.out.println(CollegeManagementSystem.admin.students[i].id + " | " + CollegeManagementSystem.admin.students[i].name + " | " + CollegeManagementSystem.admin.students[i].branch);
        }

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        Student s = CollegeManagementSystem.admin.findStudent(id);

        if (s != null && s.password.equals(pass)) {
            studentMenu(s);
        } else {
            System.out.println("Invalid Student ID or Password!");
        }
    }

    void studentMenu(Student s) {
        while (true) {
            System.out.println("\n------ STUDENT MENU ------");
            System.out.println("1. View Profile");
            System.out.println("2. View Attendance");
            System.out.println("3. View Result");
            System.out.println("4. View My Branch");
            System.out.println("5. View Library");
            System.out.println("6. View My Issued Books");
            System.out.println("7. Change Password");
            System.out.println("8. Logout");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            if (input.length() != 1 || input.charAt(0) < '1' || input.charAt(0) > '8') {
                System.out.println("Invalid choice!");
                continue;
            }

            int ch = input.charAt(0) - '0';

            switch (ch) {
                case 1 -> {
                    System.out.println("ID | NAME | Branch | EMAIL");
                    System.out.println("--------------------------------");
                    s.display();
                }

                case 2 -> attendance.viewAttendanceByStudent(s.id);
                case 3 -> result.viewResult(s.id);
                case 4 -> branchobj.viewBranchesByStudent(s.branch);
                case 5 -> CollegeManagementSystem.admin.viewLibrary();
                case 6 -> ib.viewBooksByStudent(s.id);
                case 7 -> changePassword(s);
                case 8 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }

        }
    }

    void changePassword(Student s) {
        System.out.print("Enter Old Password: ");
        String oldPass = sc.nextLine();

        if (!s.password.equals(oldPass)) {
            System.out.println("Incorrect old password!");
            return;
        }

        System.out.print("Enter New Password: ");
        String newPass = sc.nextLine();

        System.out.print("Confirm New Password: ");
        String confirmPass = sc.nextLine();

        if (!newPass.equals(confirmPass)) {
            System.out.println("Passwords do not match!");
            return;
        }

        s.password = newPass;
        System.out.println("Password changed successfully!");
    }

}

// ================= SUB CLASS FACULTY =================

class Faculty extends Person {
    String subject;
    String password = "1234";
    Scanner sc = new Scanner(System.in);
    Attendance attendance = new Attendance();
    Result result = new Result();

    Faculty(int id, String name, String s) {
        super(id, name);
        subject = s;
    }

    Faculty() {

    }

    void display() {
        System.out.println(id + " | " + name + " | " + subject);
    }

    void facultyLogin() {
        if (CollegeManagementSystem.admin.facultyCount == 0) {
            System.out.println("No faculty added by admin.");
            return;
        }

        System.out.println("\n--- FACULTY LIST ---");
        for (int i = 0; i < CollegeManagementSystem.admin.facultyCount; i++) {
            System.out.println("ID: " + CollegeManagementSystem.admin.faculty[i].id + " | Name: " + CollegeManagementSystem.admin.faculty[i].name + " | Subject: " + CollegeManagementSystem.admin.faculty[i].subject);
        }

        System.out.print("\nEnter Faculty ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (int i = 0; i < CollegeManagementSystem.admin.facultyCount; i++) {
            if (CollegeManagementSystem.admin.faculty[i].id == id && CollegeManagementSystem.admin.faculty[i].password.equals(pass)) {
                facultyMenu(CollegeManagementSystem.admin.faculty[i]);
                return;
            }
        }

        System.out.println("Invalid Faculty ID or Password!");
    }

    void facultyMenu(Faculty f) {
        while (true) {
            System.out.println("------ FACULTY MENU ------");
            System.out.println("1. View Profile");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance (Subject)");
            System.out.println("4. Enter Marks");
            System.out.println("5. View Marks");
            System.out.println("6. Change Password");
            System.out.println("7. Logout");
            System.out.print("Choice: ");

            String input = sc.nextLine();

            if (input.length() != 1 || input.charAt(0) < '1' || input.charAt(0) > '7') {
                System.out.println("Invalid choice!");
                continue;
            }

            int ch = input.charAt(0) - '0';

            switch (ch) {
                case 1 -> {
                    System.out.println("ID | NAME | SUBJECT");
                    System.out.println("-----------------------");
                    f.display();
                }

                case 2 -> attendance.markAttendance(f);
                case 3 -> attendance.viewAttendanceBySubject(f.subject);
                case 4 -> result.markMarksBySubject(f);
                case 5 -> result.viewMarksBySubject(f.subject);
                case 6 -> changePassword(f);
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }

    }

    void changePassword(Faculty f) {
        System.out.print("Enter Old Password: ");
        String oldPass = sc.nextLine();

        if (!f.password.equals(oldPass)) {
            System.out.println("Incorrect old password!");
            return;
        }

        System.out.print("Enter New Password: ");
        String newPass = sc.nextLine();

        System.out.print("Confirm New Password: ");
        String confirmPass = sc.nextLine();

        if (!newPass.equals(confirmPass)) {
            System.out.println("Passwords do not match!");
            return;
        }

        f.password = newPass;
        System.out.println("Password changed successfully!");
    }

}

// ================= CLASS Branch =================

class Branch {
    String name;
    double fees;

    Branch(String n, double f) {
        name = n;
        fees = f;
    }

    Branch() {

    }

    void display() {
        System.out.println(name + " |  " + fees);
    }

    void viewBranchesByStudent(String branch) {
        for (int i = 0; i < CollegeManagementSystem.admin.branchCount; i++)
            if (CollegeManagementSystem.admin.branches[i].name.equalsIgnoreCase(branch))
                CollegeManagementSystem.admin.branches[i].display();
    }
}


// ================= CLASS ATTENDANCE =================

class Attendance {
    int studentId, percent;
    String subject;
    Scanner sc = new Scanner(System.in);

    Attendance(int id, String sub, int p) {
        studentId = id;
        subject = sub;
        percent = p;
    }

    Attendance() {

    }

    void display() {
        System.out.println(studentId + " | " + subject + " | " + percent + "%");
    }

    void markAttendance(Faculty f) {

        System.out.print("Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        if (CollegeManagementSystem.admin.findStudent(sid) == null) {
            System.out.println("Student not found!");
            return;
        }

        int percent;

        // ATTENDANCE VALIDATION LOOP
        while (true) {
            System.out.print("Enter Attendance % (0 - 100): ");
            percent = sc.nextInt();
            sc.nextLine();

            if (percent >= 0 && percent <= 100) {
                break;
            }

            System.out.println(" Invalid Attendance! Percentage must be between 0 and 100.");
        }

        CollegeManagementSystem.admin.attendance[CollegeManagementSystem.admin.attendanceCount++] = new Attendance(sid, f.subject, percent);

        System.out.println("Attendance Recorded Successfully!");

        // OPTIONAL INFO FOR FACULTY
        if (percent < 70) {
            System.out.println("Attendance below 70%");
        }

        if (percent < 50) {
            System.out.println("Very low attendance! Serious action required.");
        }
    }


    void viewAttendanceBySubject(String subject) {

        System.out.println("STUDENT ID | SUBJECT | ATTENDANCE %");
        System.out.println("-------------------------------------");

        for (int i = 0; i < CollegeManagementSystem.admin.attendanceCount; i++) {
            Attendance a = CollegeManagementSystem.admin.attendance[i];

            if (a.subject.equalsIgnoreCase(subject)) {
                a.display();
            }
        }
    }

    void viewAttendanceByStudent(int sid) {
        boolean found = false;

        System.out.println("STUDENT ID | SUBJECT | ATTENDANCE %");
        System.out.println("-------------------------------------");

        for (int i = 0; i < CollegeManagementSystem.admin.attendanceCount; i++) {
            Attendance a = CollegeManagementSystem.admin.attendance[i];

            if (a.studentId == sid) {
                a.display();
                found = true;

                if (a.percent < 70) {
                    System.out.println("WARNING: Your attendance is below 70%");
                    System.out.println("Faculty will call your parents!");

                }
            }
        }

        if (!found) {
            System.out.println("No attendance records found.");
        }
    }
}


// ================= CLASS RESULT =================

class Result {
    int studentId, marks;
    String subject;
    Scanner sc = new Scanner(System.in);


    Result(int id, String sub, int m) {
        studentId = id;
        subject = sub;
        marks = m;
    }

    Result() {

    }

    void display() {
        System.out.println(studentId + " | " + subject + " | " + marks);
    }

    void markMarksBySubject(Faculty f) {
        System.out.print("Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        if (CollegeManagementSystem.admin.findStudent(sid) == null) {
            System.out.println("Student not found!");
            return;
        }


        int marks;

        // MARKS VALIDATION LOOP
        while (true) {
            System.out.print("Enter Marks (0 - 100): ");
            marks = sc.nextInt();
            sc.nextLine();

            if (marks >= 0 && marks <= 100) {
                break;
            }

            System.out.println(" Invalid Marks! Marks must be between 0 and 100.");
        }

        CollegeManagementSystem.admin.results[CollegeManagementSystem.admin.resultCount++] = new Result(sid, f.subject, marks);

        System.out.println("Marks Entered Successfully!");
    }

    void viewMarksBySubject(String subject) {

        boolean found = false;

        System.out.println("\nSTUDENT ID | STUDENT NAME | SUBJECT | MARKS");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < CollegeManagementSystem.admin.resultCount; i++) {

            Result r = CollegeManagementSystem.admin.results[i];

            if (r.subject.equalsIgnoreCase(subject)) {

                Student s = CollegeManagementSystem.admin.findStudent(r.studentId);

                String name = (s != null) ? s.name : "Unknown";

                System.out.println(r.studentId + " | " + name + " | " + r.subject + " | " + r.marks);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No marks records found for this subject.");
        }
    }


    void viewResult(int sid) {
        boolean found = false;

        System.out.println("STUDENT ID | SUBJECT | MARKS");
        System.out.println("-------------------------------");

        for (int i = 0; i < CollegeManagementSystem.admin.resultCount; i++) {
            Result r = CollegeManagementSystem.admin.results[i];

            if (r.studentId == sid) {
                r.display();
                found = true;

                // STUDENT WARNING
                if (r.marks < 35) {
                    System.out.println(" FAIL: Marks below passing criteria");
                    System.out.println("Faculty will call your parents!");
                }
                //SCHOLARSHIP
                if (r.marks >= 90) {
                    System.out.println(" Excellent Performance! You are eligible for scholarship.");
                }
            }
        }

        if (!found) {
            System.out.println("No result records found.");
        }
    }
}


// ================= CLASS LIBRARY =================

class Library {
    int id, qty;
    String title, author;

    Library(int i, String t, String a, int q) {
        id = i;
        title = t;
        author = a;
        qty = q;
    }

    void display() {
        System.out.println(id + " | " + title + " | " + author + " | " + qty);
    }
}

// ================= CLASS ISSUE BOOK =================


class IssuedBook {
    int studentId;
    String studentName, bookTitle;

    IssuedBook(int sid, String sname, String btitle) {
        studentId = sid;
        studentName = sname;
        bookTitle = btitle;
    }

    IssuedBook() {

    }

    void display() {
        System.out.println(studentId + " | " + studentName + " | " + bookTitle);
    }

    void viewBooksByStudent(int sid) {

        boolean found = false;

        System.out.println("STUDENT ID | STUDENT NAME | BOOK TITLE");
        System.out.println("----------------------------------------");

        for (int i = 0; i < CollegeManagementSystem.admin.issuedCount; i++) {
            if (CollegeManagementSystem.admin.issuedBooks[i].studentId == sid) {
                CollegeManagementSystem.admin.issuedBooks[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No issued books found.");
        }
    }

}
