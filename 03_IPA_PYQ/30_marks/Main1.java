import java.util.*;

class Student {

    int id;
    String name;
    int marks;
    int age;

    // parameterised constructor
    public Student(int id, String name, int marks, int age) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Student st[] = new Student[n];
        for (int i = 0; i < st.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int marks = sc.nextInt();
            sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();

            st[i] = new Student(id, name, marks, age);
        }

        int param = sc.nextInt();
        sc.nextLine();

        Student Maxobj = stud(st);
        if (Maxobj != null) {
            int getId = Maxobj.getId();
            String getName = Maxobj.getName();
            int getmarks = Maxobj.getMarks();
            int getAge = Maxobj.getAge();
            System.out.println("Id-" + getId);
            System.out.println("name-" + getName);
            System.out.println("marks-" + getmarks);
            System.out.println("age-" + getAge);

        }

        Student ar[] = searchStudentById(st, param);

        if (ar != null || ar.length!=0) {
            for (int i = 0; i < ar.length; i++) {
                int getId = ar[i].getId();
                String getName = ar[i].getName();
                int getmarks = ar[i].getMarks();
                int getAge = ar[i].getAge();
                System.out.println("Id-" + getId);
                System.out.println("name-" + getName);
                System.out.println("marks-" + getmarks);
                System.out.println("age-" + getAge);
            }
        } else {
            System.out.println("No student found with mentioned attribute");
        }
    }

    public static Student stud(Student arr[]) {

        int max = arr[0].age;  //int max=arr[0].getAge() we used here age because it does not have acces specifier
        Student obj = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getAge() > max) {
                max = arr[i].getAge();
                obj = arr[i];
            }
        }
        return obj;
    }

    public static Student[] searchStudentById(Student arr[], int id) {
        Student sp[] = new Student[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == id) {
                count++;
                sp = Arrays.copyOf(sp, count);
                sp[sp.length - 1] = arr[i];
            }
        }
        if (sp.length > 0) {
            return sp;
        }
        return null;
    }

}
