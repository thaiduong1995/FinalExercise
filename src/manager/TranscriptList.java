package manager;

import data.Student;
import data.Subject;
import data.Transcript;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class TranscriptList {
    LinkedList<Transcript> list = new LinkedList<>();

    public void searchStudent(Scanner scanner, StudentList studentList, SubjectList subjectList) {
        System.out.print("Nhập mã sinh viên cần tìm kiếm: ");
        String code = scanner.nextLine();
        Student s = getStudent(code, studentList);
        if (s == null) {
            System.out.println("Mã sinh viên không tồn tại");
        } else {
            System.out.println("\n===============THÔNG TIN SINH VIÊN===============");
            System.out.println(s);
            System.out.printf("%-3s %-30s %-4s\n", "STT", "Tên môn học", "Điểm");
            boolean b = false;
            float totalScore = 0;
            int totalCredits = 0;
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (code.equalsIgnoreCase(list.get(i).getStudentCode())) {
                    Subject subject = getSubject(list.get(i).getSubjectCode(), subjectList);
                    b = true;
                    totalScore += list.get(i).getPoints();
                    totalCredits += subject.getCredits();
                    count++;
                    System.out.printf("%3d %-30s %4.2f\n", count, subject.getName(), list.get(i).getPoints());
                }
            }
            if (!b) {
                System.out.println("Sinh viên chưa học nào cả");
            } else {
                System.out.printf("Tổng số tín chỉ: %d\n", totalCredits);
                System.out.printf("Điểm trung bình: %.2f\n", totalScore / totalCredits);
            }
            System.out.println("\n----------------------------------------------------------------------");
        }
    }

    public void searchSubject(Scanner scanner, StudentList studentList, SubjectList subjectList) {
        System.out.print("Nhập mã môn học cần tìm kiếm: ");
        String code = scanner.nextLine();
        Subject s = getSubject(code, subjectList);
        if (s == null) {
            System.out.println("Mã môn học không tồn taị");
        } else {
            System.out.println(s);
            System.out.printf("%-3s %-30s %-15s %-10s %-9s %-4s\n", "STT", "Tên sinh viên", "Mã số sinh viên",
                    "Năm sinh", "Giới tính", "Điểm");
            boolean b = false;
            float totalScore = 0;
            int number = 0;
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (code.equalsIgnoreCase(list.get(i).getSubjectCode())) {
                    Student student = getStudent(list.get(i).getStudentCode(), studentList);
                    b = true;
                    totalScore += list.get(i).getPoints();
                    number++;
                    count++;
                    System.out.printf("%3d %-30s %-15s %-10s %-9s %4.2f\n", count,
                            student.getSurnameBuffer() + " " + student.getName(), student.getCode(),
                            student.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), student.getGender(),
                            list.get(i).getPoints());
                }
            }
            if (!b) {
                System.out.println("Môn học này chưa có điểm");
            } else {
                System.out.println("Sĩ số: " + number);
                System.out.printf("Điểm trung bình môn: %.2f\n", totalScore / number);
            }
            System.out.println("\n----------------------------------------------------------------------");
        }
    }

    public void subjectDisplay(StudentList studentList, SubjectList subjectList) {
        System.out.println("\n===================THỐNG KÊ BẢNG ĐIỂM CỦA TỪNG MÔN HỌC==================");
        for (int i = 0; i < subjectList.getList().size(); i++) {
            System.out.println(subjectList.getList().get(i));
            System.out.println("\tDAMH SÁCH SINH VIÊN");
            System.out.printf("%-3s %-30s %-15s %-10s %-9s %-4s\n", "STT", "Tên sinh viên", "Mã số sinh viên",
                    "Năm sinh", "Giới tính", "Điểm");
            boolean b = false;
            float totalScore = 0;
            int number = 0;
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (subjectList.getList().get(i).getCode().equalsIgnoreCase(list.get(j).getSubjectCode())) {
                    Student student = getStudent(list.get(j).getStudentCode(), studentList);
                    b = true;
                    totalScore += list.get(j).getPoints();
                    number++;
                    count++;
                    System.out.printf("%3d %-30s %-15s %-8s %-9s %4.2f\n", count,
                            student.getSurnameBuffer() + " " + student.getName(), student.getCode(),
                            student.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), student.getGender(),
                            list.get(j).getPoints());
                }
            }
            if (!b) {
                System.out.println("Không có sinh viên học môn học này");
            } else {
                System.out.printf("Điểm trung bình môn: %.2f", totalScore / number);
            }
            System.out.println("\n----------------------------------------------------------------------");
        }
    }

    public void studentDisplay(StudentList studentList, SubjectList subjectList) {
        studentList.sortCode();
        System.out.println("\n===================THỐNG KÊ BẢNG ĐIỂM CỦA TỪNG SINH VIÊN==================");
        for (int i = 0; i < studentList.getList().size(); i++) {
            System.out.println(studentList.getList().get(i));
            System.out.println("\tBẢNG ĐIỂM");
            System.out.printf("%-3s %-30s %-4s\n", "STT", "Tên môn học", "Điểm");
            boolean b = false;
            float totalScore = 0;
            int totalCredits = 0;
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (studentList.getList().get(i).getCode().equalsIgnoreCase(list.get(j).getStudentCode())) {
                    Subject subject = getSubject(list.get(j).getSubjectCode(), subjectList);
                    b = true;
                    totalScore += list.get(j).getPoints();
                    totalCredits += subject.getCredits();
                    count++;
                    System.out.printf("%3d %-30s %4.2f\n", count, subject.getName(), list.get(j).getPoints());
                }
            }
            if (!b) {
                System.out.println("Sinh viên chưa học môn nào cả");
            } else {
                System.out.printf("Điểm trung bình: %.2f", totalScore / totalCredits);
            }
            System.out.println("\n----------------------------------------------------------------------");
        }
    }

    public Subject getSubject(String code, SubjectList list) {
        for (Transcript t :
                this.list) {
            if (t.getSubjectCode().equalsIgnoreCase(code)) {
                int index = list.getIndex(code);
                return list.getList().get(index);
            }
        }
        return null;
    }

    public Student getStudent(String code, StudentList list) {
        for (Transcript t :
                this.list) {
            if (t.getStudentCode().equalsIgnoreCase(code)) {
                int index = list.getIndex(code);
                return list.getList().get(index);
            }
        }
        return null;
    }

    public boolean remove(Scanner scanner, StudentList studentList, SubjectList subjectList) {
        System.out.print("Mã sinh viên: ");
        String studentCode = scanner.nextLine();
        if( studentList.getIndex(studentCode) < 0) {
            System.out.println("Mã sinh viên không tồn tại");
            return false;
        }
        System.out.print("Mã môn học: ");
        String subjectCode = scanner.nextLine();
        if (subjectList.getIndex(subjectCode) < 0) {
            System.out.println("Mã môn học không tồn tại");
            return false;
        }
        int index = getIndex(studentCode, subjectCode);
        if (index >=0 ) {
            list.remove(index);
            return true;
        } else {
            System.out.println("Sinh viên chưa có điểm của môn học này");
            return false;
        }
    }

    public boolean update(Scanner scanner, StudentList studentList, SubjectList subjectList) {
        System.out.print("Mã sinh viên: ");
        String studentCode = scanner.nextLine();
        if( studentList.getIndex(studentCode) < 0) {
            System.out.println("Mã sinh viên không tồn tại");
            return false;
        }
        System.out.print("Mã môn học: ");
        String subjectCode = scanner.nextLine();
        if (subjectList.getIndex(subjectCode) < 0) {
            System.out.println("Mã môn học không tồn tại");
            return false;
        }
        int index = getIndex(studentCode, subjectCode);
        if (index >= 0) {
            list.set(index, new Transcript().update(scanner));
            return true;
        } else {
            System.out.println("Sinh viên chưa có điểm");
            return false;
        }
    }

    public boolean add(Transcript transcript) {
        if (transcript == null) {
            return false;
        }
        return list.add(transcript);
    }

    public int getIndex(String studentCode, String subjectCode) {
        for (int i = 0; i < list.size(); i++) {
            if (studentCode.equalsIgnoreCase(list.get(i).getStudentCode()) && subjectCode.equalsIgnoreCase(list.get(i).getSubjectCode())) {
                return i;
            }
        }
        return -1;
    }

    public boolean isExit(String code) {
        for (Transcript t :
                list) {
            if (code.equalsIgnoreCase(t.getStudentCode()) || code.equalsIgnoreCase(t.getSubjectCode())) {
                return true;
            }
        }
        return false;
    }

    public TranscriptList init() {
        list.add(new Transcript("SV0001", "MH0000", 8F));
        list.add(new Transcript("SV0003", "MH0001", 6.98F));
        list.add(new Transcript("SV0004", "MH0002", 8.5F));
        list.add(new Transcript("SV0005", "MH0003", 5.98F));
        list.add(new Transcript("SV0002", "MH0004", 6.54F));
        list.add(new Transcript("SV0001", "MH0005", 9.8F));
        return this;
    }

    public TranscriptList() {
    }

    public LinkedList<Transcript> getList() {
        return list;
    }

    public void setList(LinkedList<Transcript> list) {
        this.list = list;
    }
}
