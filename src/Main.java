import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Doan", "CodeGym",
                            "doan@gmail.com", 94387));
        students.add(new Student(2, "Huy", "CodeGym",
                            "huy@gmail.com", 65702));
        students.add(new Student(3, "Luc", "CodeGym",
                            "luc@gmail.com", 32635));

        writeFile(students, "demo.dat");

        List<Student> studentList;
        studentList = readFile("demo.dat");
        System.out.println(studentList);
    }
    public static void writeFile(List<Student> students, String fileName) {
        File file = new File(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFile(String fileName) {
        File file = new File(fileName);
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<Student> students = (List<Student>) objectInputStream.readObject();
            return students;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}