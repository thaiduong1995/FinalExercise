package data;

import manager.SubjectList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Subject {
    private static int number = 0;

    private String code;
    private String name;
    private int credits;

    @Override
    public String toString() {
        String result = "";
        result += "Mã môn học : " + code + "\n";
        result += "Tên môn học: " + name + "\n";
        result += "Số tín chỉ : " + credits + "\n";
        return result;
    }

    public Subject update(Scanner scanner) {
        int opt;
        do {
            System.out.println(this);
            System.out.println("1. Sửa tên môn");
            System.out.println("2. Sửa số tín chỉ của môn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Tên môn mới: ");
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Số tín chỉ mới của môn: ");
                    credits = Integer.parseInt(scanner.nextLine());
                    break;
            }
        } while (opt != 0);
        return this;
    }

    public Subject create(Scanner scanner, SubjectList list) {
        for (Subject s :
                list.getList()) {
            if (code.equalsIgnoreCase(s.getCode())) {
                if (number < 10) {
                    code += "MH000" + number;
                } else if (number < 100) {
                    code += "MH00" + number;
                } else if (number < 1000) {
                    code += "MH0" + number;
                } else {
                    code += "MH" + number;
                }
                number++;
            }
        }
        System.out.print("Tên môn: ");
        name = scanner.nextLine();
        System.out.print("Số tín chỉ: ");
        credits = Integer.parseInt(scanner.nextLine());
        return this;
    }

    public Subject() {
        code = "";
        if (number < 10) {
            code += "MH000" + number;
        } else if (number < 100) {
            code += "MH00" + number;
        } else if (number < 1000) {
            code += "MH0" + number;
        } else {
            code += "MH" + number;
        }
        number++;
    }

    public Subject(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        number++;
    }

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
        number++;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
