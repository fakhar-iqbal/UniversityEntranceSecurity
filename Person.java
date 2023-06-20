import java.io.*;
import java.util.Random;

public class Person implements Serializable {
    private String name;
    private String cnic;
    private int mobile;
    private String department;
    private String post;
    private String SpecialID;

    Person() {
    }

    Person(String name, String cnic, int mobile, String department, String post) {

        this.name = name;
        this.cnic = cnic;
        this.mobile = mobile;
        this.department = department;
        this.post = post;

    }

    public String generateID() {

        int length = 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#!$%^&*(+)";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(characters.length());
            char RandomChar = characters.charAt(rand);
            sb.append(RandomChar);
        }
        String ranStr = sb.toString();

        this.SpecialID = ranStr;
        // System.out.println("your id is: " + ranStr);

        return ranStr;
    }

    public String getName() {
        return this.name;
    }

    public String getDept() {
        return this.department;
    }

    public String getPost() {
        return this.post;
    }

    public String getID() {
        return this.SpecialID;
    }

    public String toString() {
        return "---------\n" + "Name : " + this.name + "\nDepartment : " + this.department + "\nCNIC: " + this.cnic
                + "\n-------------------";
    }

}
