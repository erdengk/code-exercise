package daily.exercise.model;

import java.util.*;

/**
 * @ClassName: Compare
 * @Description:
 * @author: dk
 * @date: 2021/12/3 11:24 上午
 */
class Student{
    int age;
    String name;
    int grade;
    Student(int a, String b,int g){
        this.age = a;
        this.name = b;
        this.grade=g;
    }
}
public class Compare {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2.compareTo(o1);
            }
        });

        //创建学生对象数组
        Student s[] = new Student[4];
        s[0] = new Student(10, "1",10);
        s[1] = new Student(7, "2",9);
        s[2] = new Student(8, "3",6);
        s[3] = new Student(7, "4",10);

        Arrays.sort(s, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if(a.age==b.age){
                    return b.grade-a.grade;
                }else {
                    return a.age - b.age;
                }
            }
        });
        for(Student p : s){
            System.out.println(p.age+" "+p.grade + "\n");
        }

    }

}
