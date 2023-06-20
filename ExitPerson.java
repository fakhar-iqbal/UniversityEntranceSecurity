import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.TypeParameterElement;

import java.io.*;

public class ExitPerson {
    private String specialID;
    private String name;
    private String department;

    ExitPerson(String specialID) {
        this.specialID = specialID;
    }

    public String getPost() {
        EnterStudent es = new EnterStudent(this.specialID);
        EnterTeacher et = new EnterTeacher(this.specialID);

        if (es.isRegistered()) {
            this.name = es.getName();
            this.department = es.depart();
            return "Student";
        } else if (et.isRegistered()) {
            this.name = es.getName();
            this.department = es.depart();
            return "Teacher";
        } else {
            return null;
        }
    }

    public int exitingPerson() throws Exception {
        int check = 0;
        if (getPost().equalsIgnoreCase("Teacher")) {
            check = EnterTeacher.exitTeacher(specialID);

        } else if (getPost().equalsIgnoreCase("Student")) {
            check = EnterStudent.exitStudent(specialID);

        }
        return check;
        // return 0 if not registered
        // return 2 if not entered uni
        // return 3 if deleted
    }

    public String getName() {
        return this.name;
    }

}
