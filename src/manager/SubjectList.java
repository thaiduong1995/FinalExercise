package manager;

import data.Student;
import data.Subject;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SubjectList {
    private LinkedList<Subject> list = new LinkedList<>();

    @Override
    public String toString() {
        sortName();
        String result = "\n===============DANH SÁCH MÔN HỌC===============\n";
        result += String.format("%-3s %-30s %-10s %-10s\n", "STT", "Tên môn học", "Mã môn học", "Số tín chỉ");
        for (int i = 0; i < list.size(); i++) {
            result += String.format("%3d %-30s %-10s %10d\n", i + 1, list.get(i).getName(), list.get(i).getCode(),
                    list.get(i).getCredits());
        }
        result += "\n----------------------------------------------------------------------\n";
        return result;
    }

    public void sortName() {
        Collections.sort(list, (o1, o2) -> {
            return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
        });
    }

    public boolean remove(Scanner scanner, TranscriptList list) {
        System.out.print("Nhập mã môn cần xóa: ");
        String code = scanner.nextLine();
        int index = getIndex(code);
        if (index < 0) {
            System.out.println("Mã môn học không tồn tại");
            return false;
        } else {
            if (list.isExit(code)) {
                System.out.println("Môn học đã có sinh viên theo học");
                return false;
            } else {
                this.list.remove(index);
                return true;
            }
        }
    }

    public boolean update(Scanner scanner) {
        System.out.print("Nhập mã môn cần sửa: ");
        String code = scanner.nextLine();
        int index = getIndex(code);
        if (index < 0) {
            System.out.println("Mã môn học không tồn tại");
            return false;
        } else {
            Subject subject = list.get(index).update(scanner);
            list.set(index, subject);
            return true;
        }
    }

    public void add() {
        list.add(new Subject().create(new Scanner(System.in), this));
    }

    public int getIndex(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public SubjectList init() {
        list.add(new Subject("MH0000", "Toán", 2));
        list.add(new Subject("MH0001", "Văn", 2));
        list.add(new Subject("MH0002", "Anh", 1));
        list.add(new Subject("MH0003", "Lý", 1));
        list.add(new Subject("MH0004", "Hóa", 1));
        list.add(new Subject("MH0005", "Lập trình Java", 3));
        return this;
    }

    public SubjectList() {
    }

    public LinkedList<Subject> getList() {
        return list;
    }

    public void setList(LinkedList<Subject> list) {
        this.list = list;
    }
}
