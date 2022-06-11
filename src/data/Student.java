package data;

import manager.StudentList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student {
    private static int number = 0;

    private String code;
    private String surnameBuffer;
    private String name;
    private LocalDate birthday;
    private String gender;

    @Override
    public String toString() {
        String result = "";
        result += "Mã số sinh viên: " + code + "\n";
        result += "Họ tên:          " + surnameBuffer + " " + name + "\n";
        result += "Năm sinh:        " + birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        result += "Giới tính:       " + gender + "\n";
        return result;
    }

    public Student update(Scanner scanner) {
        int opt;
        do {
            System.out.println(this);
            System.out.println("1. Sửa họ đêm");
            System.out.println("2. Sửa tên");
            System.out.println("3. Sửa năm sinh");
            System.out.println("4. Sửa giới tính");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Họ đệm mới: ");
                    surnameBuffer = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Tên mới: ");
                    name = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Năm sinh mới (ngày/tháng/năm): ");
                    String birthday = scanner.nextLine();
                    if (!birthday.isEmpty()) {
                        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    }
                    break;
                case 4:
                    System.out.print("Giới tính mới: ");
                    gender = scanner.nextLine();
            }
        } while (opt != 0);
        return this;
    }

    public Student create(Scanner scanner, StudentList list) {
        for (Student s :
                list.getList()) {
            if (code.equalsIgnoreCase(s.getCode())) {
                if (number < 10) {
                    code += "SV000" + number;
                } else if (number < 100) {
                    code += "SV00" + number;
                } else if (number < 1000) {
                    code += "SV0" + number;
                } else {
                    code += "SV" + number;
                }
                number++;
            }
        }
        System.out.print("Họ đệm: ");
        surnameBuffer = scanner.nextLine();
        System.out.print("Tên: ");
        name = scanner.nextLine();
        System.out.print("Năm sinh (ngày/tháng/năm): ");
        birthday = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Giới tính: ");
        gender = scanner.nextLine();
        return this;
    }

    public Student() {
        code = "";
        if (number < 10) {
            code += "SV000" + number;
        } else if (number < 100) {
            code += "SV00" + number;
        } else if (number < 1000) {
            code += "SV0" + number;
        } else {
            code += "SV" + number;
        }
        number++;
    }

    public Student(String code, String surnameBuffer, String name, String birthday, String gender) {
        this.code = code;
        this.surnameBuffer = surnameBuffer;
        this.name = name;
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender = gender;
        number++;
    }

    public Student(String surnameBuffer, String name, String birthday, String gender) {
        this.surnameBuffer = surnameBuffer;
        this.name = name;
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender = gender;
        number++;
    }

    public String getCode() {
        return code;
    }

    public String getSurnameBuffer() {
        return surnameBuffer;
    }

    public void setSurnameBuffer(String surnameBuffer) {
        this.surnameBuffer = surnameBuffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
