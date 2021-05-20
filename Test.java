import java.util.*;
import java.util.stream.Collectors;

class Student{
    private String name;
    private int year;
    private String dept;
    Student(){}

    public Student(String name, int year, String dept) {
        this.name = name;
        this.year = year;
        this.dept = dept;
    }

    public String getDept() {
        return this.dept;
    }
    public int getYear() {
        return this.year;
    }

}

class StudentMidExam {

    static int ssu;
    static Student[] data;
    static Scanner sc = new Scanner(System.in);
    static char max;

    static void maxYear(String years, Long min, int current){
        if(current == years.length()) return;
        Long count = Arrays.stream(years.replaceAll("[" + years.charAt(current) + "]", "").split("")).count();
        if(min > count){
            min = count;
            max = years.charAt(current);
        }
        maxYear(years, min, current+1);
    }

    public static int findStudentSu(String deptName) {
        int i, su=0;

        for(Student temp : data) {
            if(temp.getDept().equals(deptName)) 
            su++;
        }
        return su;
    }

    public static void main(String[] args) {
        int year, su;
        String name, dept;

        System.out.print("학생수:");
        ssu = Integer.parseInt(sc.nextLine());
        data = new Student[ssu];
        for(int i=0; i<ssu; i++) {
            System.out.print("학생이름:");
            name = sc.nextLine();
            System.out.print("학과:");
            dept = sc.nextLine();
            System.out.print("학년:");
            year = Integer.parseInt(sc.nextLine());
            data[i] = new Student(name, year, dept);
        }

        System.out.println("찾고 싶은 학과 이름");
        name = sc.nextLine();
        su = findStudentSu(name);
        System.out.println(name + "과 소속의 학생은 " + su +"명 입니다.");
        maxYear(Arrays.stream(data).map(data->data.getYear()).map(Object::toString).collect(Collectors.joining()), 9999L, 0);
        System.out.println("가장 많은 학생의 수는 " + max + "학년입니다");
    }
}