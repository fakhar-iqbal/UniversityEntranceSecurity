import java.io.*;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable {

    Teacher(String name, String cnic, int mobile, String department, String post) {
        super(name, cnic, mobile, department, post);
    }

    public static void RegisterTeachertoFile(Person p) throws Exception {
        // try {
        // File f = new File("Teacher.ser");
        // ObjectOutputStream out;
        // if (f.exists()) {
        // out = new ObjectOutputStream(new FileOutputStream(f, true));
        // } else {
        // out = new ObjectOutputStream(new FileOutputStream(f));
        // }

        // out.writeObject(p);
        // out.close();
        // } catch (IOException e) {
        // System.out.println("error writing to the file");
        // }

        FileOperations.writeToFile(p, "Teacher.ser");

    }

    public static ArrayList<Person> ReadTeacherFromFile() throws Exception {
        ArrayList<Person> teachers = new ArrayList<Person>();

        // try {
        // // ObjectInputStream in = new ObjectInputStream(new
        // // FileInputStream("Teacher.ser"));
        // // while(true){
        // // Teacher s = (Teacher)in.readObject();
        // // teachers.add(s);
        // // System.out.println("read");
        // // }
        // // return teachers;
        // File f = new File("Teacher.ser");
        // ObjectInputStream in;
        // if (f.exists()) {
        // in = new ObjectInputStream(new FileInputStream(f));

        // while (true) {
        // Teacher s = (Teacher) in.readObject();
        // teachers.add(s);
        // }
        // }

        // } catch (ClassNotFoundException c) {
        // System.out.println("Class not found!");
        // } catch (FileNotFoundException c) {
        // System.out.println("file not found!");
        // } catch (EOFException x) {
        // System.out.println("check2");
        // return teachers;
        // } catch (IOException i) {
        // System.out.println("Error3 in reading!");

        // }
        teachers = FileOperations.readAllObject("Teacher.ser");
        return teachers;

    }
}
