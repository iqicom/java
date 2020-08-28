package Stu_Mangement;

import java.util.ArrayList;
import java.util.Scanner;

public class StuMan {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("----欢迎来到学生管理系统----");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("再见~~");
                    System.exit(0);
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学号:");
            id = sc.nextLine();
            boolean flag = isUsed(array, id);
            if (flag) {
                System.out.println("学号重复请重新输入!");
            } else {
                break;
            }
        }
        System.out.println("请输入姓名:");
        String name = sc.nextLine();
        System.out.println("请输入年龄:");
        String age = sc.nextLine();
        System.out.println("请输入住址:");
        String address = sc.nextLine();
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加成功！");
    }

    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("没有学生信息！");
            return;
        }
        System.out.println("学号" + "\t" + "姓名" + "\t" + "年龄" + "\t" + "住址");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t" + s.getAge() + "岁" + "\t" + s.getAddress());
        }
    }

    public static void deleteStudent(ArrayList<Student> arry) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学号:");
        String id = sc.nextLine();
        int index = -1;
        for (int i = 0; i < arry.size(); i++) {
            Student s = arry.get(i);
            if (s.getId().equals(id))
                index = i;
        }
        if (index == -1) {
            System.out.println("您输入的学号不存在!");
        } else {
            arry.remove(index);
            System.out.println("删除成功!");
        }
    }

    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学号:");
        String id = sc.nextLine();
        System.out.println("请输入姓名:");
        String name = sc.nextLine();
        System.out.println("请输入要修改的年龄:");
        String age = sc.nextLine();
        System.out.println("请输入要修改的住址:");
        String address = sc.nextLine();
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getId().equals(id))
                array.set(i, s);
        }
    }

    public static boolean isUsed(ArrayList<Student> array, String id) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                flag = true;
            }
        }
        return flag;
    }
}
