package manager;

import data.Student;
import data.Subject;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentList {
    private LinkedList<Student> list = new LinkedList<>();

    @Override
    public String toString() {
        sortName();
        String result = "\n===============DANH SÁCH SINH VIÊN===============\n";
        result += String.format("%-3s %-30s %-15s %-10s %-9s\n", "STT", "Họ tên", "Mã số sinh viên", "Năm sinh", "Giới tính");
        for (int i = 0; i < list.size(); i++) {
            result += String.format("%3d %-30s %-15s %-10s %-9s\n", i + 1, list.get(i).getSurnameBuffer() + " " + list.get(i).getName(),
                    list.get(i).getCode(), list.get(i).getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    list.get(i).getGender());
        }
        result += "\n----------------------------------------------------------------------\n";
        return result;
    }

    public void sortCode() {
        Collections.sort(list, (o1, o2) -> {
            return o1.getCode().compareToIgnoreCase(o2.getCode());
        });
    }

    public void sortName() {
        Collections.sort(list, (o1, o2) -> {
            return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
        });
    }

    public boolean remove(Scanner scanner, TranscriptList list) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String code = scanner.nextLine();
        int index = getIndex(code);
        if (index < 0) {
            System.out.println("Mã sinh viên không tồn tại");
            return false;
        } else {
            if (list.isExit(code)) {
                System.out.println("Sinh viên đã có điểm thi");
                return false;
            } else {
                this.list.remove(index);
                return true;
            }
        }
    }

    public boolean update(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String code = scanner.nextLine();
        int index = getIndex(code);
        if (index < 0) {
            System.out.println("Mã sinh viên không tồn tại");
            return false;
        } else {
            Student student = list.get(index).update(scanner);
            list.set(index, student);
            return true;
        }
    }

    public void add() {
        list.add(new Student().create(new Scanner(System.in), this));
    }

    public int getIndex(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public StudentList init() {
        list.add(new Student("SV0000", "Nguyễn Văn", "Sơn", "12/12/2002", "Nam"));
        list.add(new Student("SV0001", "Trần Văn", "Hải", "12/02/1992", "Nam"));
        list.add(new Student("SV0002", "Nguyễn Trường", "Chinh", "02/11/2001", "Nam"));
        list.add(new Student("SV0003", "Lê Mạnh", "Hòa", "10/12/2000", "Nam"));
        list.add(new Student("SV0004", "Nguyễn Thu", "Thủy", "09/12/1999", "Nữ"));
        list.add(new Student("SV0005", "Lê Trọng", "Tấn", "09/10/2002", "Nam"));
        return this;
    }

    public StudentList() {
    }

    public LinkedList<Student> getList() {
        return list;
    }

    public void setList(LinkedList<Student> list) {
        this.list = list;
    }
}
