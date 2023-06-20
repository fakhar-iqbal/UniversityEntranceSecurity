import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.TypeParameterElement;

import java.io.*;

public class EnterStudent implements Serializable {
    private String specialID;
    private String name;
    private String department;

    EnterStudent(String specialID) {
        this.specialID = specialID;
    }

    public boolean isRegistered() {
        ArrayList<Person> s = new ArrayList<Person>();
        boolean check = false;
        try {
            s = Student.ReadStudentFromFile();
        } catch (Exception v) {
            System.out.println("exception here");
        }
        System.out.println(s);
        // System.out.println("f1f");
        for (int i = 0; i < s.size(); i++) {

            if (s.get(i).getID().equals(this.specialID)) {
                System.out.println("Student is allowed to pass!");
                this.name = s.get(i).getName();
                this.department = s.get(i).getDept();
                return true;

            }
        }
        return check;
    }

    public static void EnterStudentToFile(EnterStudent e) throws Exception {
        // try {
        // // File f = new File("TodayzStudents.ser");
        // // ObjectOutputStream out;
        // // if (f.exists()) {
        // // out = new ObjectOutputStream(new FileOutputStream(f, true));
        // // } else {
        // // out = new ObjectOutputStream(new FileOutputStream(f));
        // // }

        // // out.writeObject(e);
        // // out.close();
        // FileOutputStream fileOut = new FileOutputStream("TodayzStudents.ser", true);
        // BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);
        // ObjectOutputStream objectOut = new ObjectOutputStream(bufferedOut);
        // objectOut.writeObject(e);
        // objectOut.close();
        // bufferedOut.close();
        // fileOut.close();

        // } catch (IOException g) {
        // System.out.println("error writing to the file");
        // }

        FileOperations.writeToFile(e, "TodayzStudents.ser");
    }

    public static ArrayList<EnterStudent> ReadStudentFromToday() throws Exception {
        ArrayList<EnterStudent> students = new ArrayList<EnterStudent>();

        students = FileOperations.readAllObject("TodayzStudents.ser");
        // System.out.println("checking student");
        // for (int i = 0; i < students.size(); i++) {
        // System.out.println(students.get(i).toString());
        // }
        // try {
        // FileInputStream fileIn = new FileInputStream("TodayzStudents.ser");
        // BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
        // ObjectInputStream objectIn = new ObjectInputStream(bufferedIn);
        // EnterStudent st;

        // while (true) {
        // try {
        // st = (EnterStudent) objectIn.readObject();
        // students.add(st);
        // st.toString();

        // } catch (ClassNotFoundException c) {
        // System.out.println("Class not found!");
        // objectIn.close();
        // bufferedIn.close();
        // fileIn.close();
        // } catch (EOFException x) {
        // objectIn.close();
        // bufferedIn.close();
        // fileIn.close();
        // return students;

        // } catch (IOException i) {
        // System.out.println("1eError in reading!");
        // objectIn.close();
        // bufferedIn.close();
        // fileIn.close();

        // }

        // }

        // } catch (IOException e) {
        // System.out.println("Error reading from the file.");
        // e.printStackTrace();
        // }
        return students;
    }

    public String toString() {
        return "-------------\n" + "Name : " + this.name + "\nDepartment: " + this.department;
    }

    public static int exitStudent(String special) throws Exception {
        ArrayList<EnterStudent> today = new ArrayList<EnterStudent>();
        int check = 2;
        try {
            today = EnterStudent.ReadStudentFromToday();
        } catch (Exception g) {
            System.out.println("exception occured");
        }
        File file = new File("TodayzStudents.ser");
        if (file.exists()) {
            boolean isDeleted = file.delete();

            // if (isDeleted) {
            // System.out.println("File deleted successfully.");
            // } else {
            // System.out.println("Failed to delete the file.");
            // }
        } else {
            // System.out.println("File does not exist.");
        }

        for (int i = 0; i < today.size(); i++) {
            if (today.get(i).specialID.equals(special)) {
                check = 3;
                today.remove(i);
                break;
            }
        }
        FileOperations.writeToFile(today, "TodayzStudents.ser");

        return check;

    }

    public boolean hasEntered() throws Exception {
        boolean check = false;
        ArrayList<EnterStudent> students = new ArrayList<EnterStudent>();

        students = FileOperations.readAllObject("TodayzStudents.ser");
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).specialID.equals(this.specialID)) {
                check = true;

            }
        }
        return check;
    }

    public String depart() {
        return this.department;
    }

    public String getName() {
        return this.name;
    }

}
