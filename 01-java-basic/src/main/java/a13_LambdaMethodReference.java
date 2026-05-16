import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class a13_LambdaMethodReference {
    public static void main(String[] args) {
        // LambdaTest1.main();
        // LambdaTest2.main();
        // LambdaTest3.main();
        LambdaTest4.main();
    }
}

class LambdaTest1 {
    static void main() {
        Student[] arr = new Student[3];
        arr[0] = new Student("kwin", 18);
        arr[1] = new Student("huyo", 38);
        arr[2] = new Student("lili", 28);

        System.out.println(Arrays.toString(arr));

        // Arrays.sort(arr, ((o1, o2) -> o1.getAge() - o2.getAge()));
        // Arrays.sort(arr, ((o1, o2) -> Student.compareAge(o1, o2)));
        Arrays.sort(arr, Student::compareAge);
        System.out.println(Arrays.toString(arr));
    }
}

class LambdaTest2 {
    static void main() {
        Student[] arr = new Student[3];
        arr[0] = new Student("kwin", 18, 180);
        arr[1] = new Student("huyo", 38, 170);
        arr[2] = new Student("lili", 28, 190);

        System.out.println(Arrays.toString(arr));

        // Arrays.sort(arr, ((o1, o2) -> o1.getAge() - o2.getAge()));
        // Arrays.sort(arr, ((o1, o2) -> Student.compareAge(o1, o2)));
        Arrays.sort(arr, arr[0]::compareHeight);
        System.out.println(Arrays.toString(arr));
    }
}

class LambdaTest3 {
    static void main() {
        String[] names = {"Tom", "Jerry", "Bobi", "曹操", "Mike", "angela", "Dlei", "Jack", "Rose", "Andy", "caocao"};

        // Arrays.sort(names, ((o1, o2) -> o1.compareToIgnoreCase(o2)));
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}

class LambdaTest4 {
    static void main() {

        // StudentFactory sf = name -> new Student(name);
        StudentFactory sf = Student::new;

        Student s1 = sf.getStu("kk");
        Student s2 = sf.getStu("ww");
        System.out.println(s1);
        System.out.println(s2);
    }
}

@FunctionalInterface
interface StudentFactory {
    Student getStu(String name);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
    private int age;
    private int height;


    public Student(String name, int age) {
        this(name, age, 0);
    }

    public Student(String name) {
        this(name, 0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    static int compareAge(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }

    int compareHeight(Student o1, Student o2) {
        return o1.getHeight() - o2.getHeight();
    }
}