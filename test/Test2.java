package test;

import java.util.*;

class Test2 {

    static int ssu;
    static Student[] data;
    static Scanner sc = new Scanner(System.in);

    static int maxYear(){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Student s: data){
            hm.put(s.getYear(), hm.getOrDefault(s.getYear(), 0)+1);
        }

        int output = 0;

        for(Integer key: hm.keySet()){
            if(hm.get(key) > output){
                output = key;
            }
        }
        return output;
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
        int answer = maxYear();
        System.out.println("가장 많은 학생의 수는 " + answer + "학년입니다");
    }
}