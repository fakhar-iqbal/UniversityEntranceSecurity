import java.io.*;
import java.util.ArrayList;

public class Student extends Person implements Serializable {

    Student(String name, String cnic, int mobile, String department, String post) {
        super(name, cnic, mobile, department, post);
    }

    Student() {

    }

    public static void RegisterStudenttoFile(Person p) throws Exception {
        // try {

        // FileOutputStream fileOut = new FileOutputStream("Students.ser", true);
        // BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);
        // ObjectOutputStream objectOut = new ObjectOutputStream(bufferedOut);
        // objectOut.writeObject(p);
        // objectOut.close();
        // bufferedOut.close();
        // fileOut.close();
        // } catch (IOException e) {
        // System.out.println("error writing to the file");
        // }
        FileOperations.writeToFile(p, "Students.ser");
    }

    // public static ArrayList<Person> ReadStudentFromFile() {
    // ArrayList<Person> students = new ArrayList<Person>();
    // // System.out.println("reading1");

    // try {
    // FileInputStream fileIn = new FileInputStream("Students.ser");
    // BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
    // ObjectInputStream objectIn = new ObjectInputStream(bufferedIn);
    // Person s;
    // while (true) {
    // // System.out.println("reading");
    // try {
    // s = (Person) objectIn.readObject();
    // students.add(s);
    // } catch (EOFException ef) {
    // break;
    // }
    // }
    // objectIn.close();
    // bufferedIn.close();
    // fileIn.close();

    // } catch (ClassNotFoundException c) {
    // System.out.println("Class not found!");

    // } catch (IOException i) {
    // System.out.println("IOError in reading!");

    // }
    // return students;

    // }

    public static ArrayList<Person> ReadStudentFromFile() throws Exception {
        ArrayList<Person> students = new ArrayList<>();
        students = FileOperations.readAllObject("Students.ser");

        return students;
    }

    public String toString() {
        return "name= " + this.getName() + " dept = " + this.getDept();
    }
}
