import java.util.ArrayList;

//import javax.lang.model.element.TypeParameterElement;

import java.io.*;

public class EnterTeacher implements Serializable {
    private String specialID;
    private String name;
    private String department;

    EnterTeacher(String specialID) {
        this.specialID = specialID;
    }

    public boolean isRegistered() {
        ArrayList<Person> s = new ArrayList<Person>();
        boolean check = false;
        try {
            s = Teacher.ReadTeacherFromFile();
        } catch (Exception f) {
            System.out.println("exception occured");
        }
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getID().equals(this.specialID)) {
                System.out.println("Teacher is allowed to pass!");
                this.name = s.get(i).getName();
                this.department = s.get(i).getDept();
                return true;

            }
        }
        return check;
    }

    public static void EnterTeacherToFile(EnterTeacher e) throws Exception {
        // try {
        // File f = new File("TodayzTeachers.ser");
        // ObjectOutputStream out;
        // if (f.exists()) {
        // out = new ObjectOutputStream(new FileOutputStream(f, true));
        // } else {
        // out = new ObjectOutputStream(new FileOutputStream(f));
        // }

        // out.writeObject(e);
        // out.close();
        // } catch (IOException g) {
        // System.out.println("error writing to the file");
        // }
        FileOperations.writeToFile(e, "TodayzTeachers.ser");
    }

    public static ArrayList<EnterTeacher> ReadTeachersFromToday() throws Exception {
        ArrayList<EnterTeacher> teachers = new ArrayList<EnterTeacher>();

        // try {
        // ObjectInputStream in = new ObjectInputStream(new
        // FileInputStream("TodayzTeachers.ser"));
        // while (true) {
        // EnterTeacher s = (EnterTeacher) in.readObject();
        // teachers.add(s);
        // }

        // } catch (ClassNotFoundException c) {
        // System.out.println("Class not found!");
        // } catch (EOFException x) {
        // return teachers;
        // } catch (IOException i) {
        // System.out.println("12Error in reading!");

        // }

        teachers = FileOperations.readAllObject("TodayzTeachers.ser");
        System.out.println("checking teachers");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(teachers.get(i).toString());
        }
        return teachers;

    }

    public String toString() {
        return "-------------\n" + "Teacher Name : " + this.name + " \nDepartment: " + this.department;
    }

    public static int exitTeacher(String special) throws Exception {
        ArrayList<EnterTeacher> today = new ArrayList<EnterTeacher>();
        int check = 2;
        try {
            today = EnterTeacher.ReadTeachersFromToday();
        } catch (Exception g) {
            System.out.println("exception occured");
        }
        File file = new File("TodayzTeachers.ser");
        if (file.exists()) {
            boolean isDeleted = file.delete();

            if (isDeleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        for (int i = 0; i < today.size(); i++) {
            if (today.get(i).specialID.equals(special)) {
                check = 3;
                today.remove(i);
                break;
            }
        }
        FileOperations.writeToFile(today, "TodayzTeachers.ser");

        return check;

    }

    public boolean hasEntered() throws Exception {
        boolean check = false;
        ArrayList<EnterTeacher> teachers = new ArrayList<EnterTeacher>();

        teachers = FileOperations.readAllObject("TodayzTeachers.ser");
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).specialID.equals(this.specialID)) {
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
