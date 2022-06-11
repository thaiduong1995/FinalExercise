import data.Transcript;
import manager.StudentList;
import manager.SubjectList;
import manager.TranscriptList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        QuoteList quotes = new QuoteList().init();
        StudentList studentList = new StudentList().init();
        SubjectList subjectList = new SubjectList().init();
        TranscriptList transcriptList = new TranscriptList().init();
        int optMain;

        do {
            System.out.println("==========================CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN==========================");
            System.out.println("\t1_________QUẢN LÝ SINH VIÊN_________");
            System.out.println("\t2_________QUẢN LÝ MÔN HỌC_________");
            System.out.println("\t3_________QUẢN LÝ BẢNG ĐIỂM_________");
            System.out.println("\t4_________TÌM KIẾM_________");
            System.out.println("\t0. THOÁT");
            System.out.print("\tNhập lựa chọn: ");
            optMain = Integer.parseInt(scanner.nextLine());
            int optSub;
            switch (optMain) {
                case 1:
                    do {
                        System.out.println("_________QUẢN LÝ SINH VIÊN_________");
                        System.out.println("\t1_________Thêm_________");
                        System.out.println("\t2_________Cập nhật_________");
                        System.out.println("\t3_________Xóa_________");
                        System.out.println("\t4_________Hiển thị danh sách_________");
                        System.out.println("\t0. Thoát");
                        System.out.print("\tNhập lựa chọn: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                System.out.println("_________THÊM MỚI MỘT SINH VIÊN_________");
                                studentList.add();
                                break;
                            case 2:
                                System.out.println("_________CẬP NHẬT THÔNG TIN SINH VIÊN_________");
                                if (studentList.update(scanner)) {
                                    System.out.println("Cập nhật thông tin cho sinh viên thành công");
                                } else {
                                    System.out.println("Không cập nhật được thông tin cho sinh viên");
                                }
                                break;
                            case 3:
                                System.out.println("_________XÓA MỘT SINH VIÊN KHỎI DANH SÁCH_________\"");
                                if (studentList.remove(scanner, transcriptList)) {
                                    System.out.println("Xóa sinh viên khỏi danh sách thành công");
                                } else {
                                    System.out.println("Không xóa được sinh viên khỏi danh sách");
                                }
                                break;
                            case 4:
                                System.out.println(studentList);
                                break;
                        }
                    } while ((optSub != 0));
                    break;
                case 2:
                    do {
                        System.out.println("_________QUẢN LÝ MÔN HỌC_________");
                        System.out.println("\t1_________Thêm_________");
                        System.out.println("\t2_________Cập nhật_________");
                        System.out.println("\t3_________Xóa_________");
                        System.out.println("\t4_________Hiển thị danh sách_________");
                        System.out.println("\t0. Thoát");
                        System.out.print("\tNhập lựa chọn: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                System.out.println("_________THÊM MỚI MỘT MÔN HỌC_________");
                                subjectList.add();
                                break;
                            case 2:
                                System.out.println("_________CẬP NHẬT THÔNG TIN MÔN HỌC_________");
                                if (subjectList.update(scanner)) {
                                    System.out.println("Cập nhật thông tin cho môn học thành công");
                                } else {
                                    System.out.println("Không cập nhật được thông tin cho môn học");
                                }
                                break;
                            case 3:
                                System.out.println("_________XÓA MỘT MÔN HỌC KHỎI DANH SÁCH_________\"");
                                if (subjectList.remove(scanner, transcriptList)) {
                                    System.out.println("Xóa môn học khỏi danh sách thành công");
                                } else {
                                    System.out.println("Không xóa được môn học khỏi danh sách");
                                }
                                break;
                            case 4:
                                System.out.println(subjectList);
                                break;
                        }
                    } while ((optSub != 0));
                    break;
                case 3:
                    do {
                        System.out.println("_________QUẢN LÝ BẢNG ĐIỂM_________");
                        System.out.println("\t1_________Thêm_________");
                        System.out.println("\t2_________Cập nhật_________");
                        System.out.println("\t3_________Xóa_________");
                        System.out.println("\t4_________Hiển thị bảng điểm theo danh sách sinh viên_________");
                        System.out.println("\t5_________Hiển thị bảng điểm theo danh sách môn học_________");
                        System.out.println("\t0. Thoát");
                        System.out.print("\tNhập lựa chọn: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                System.out.println("_________THÊM ĐIỂM_________");
                                Transcript transcript = new Transcript().create(scanner, studentList, subjectList, transcriptList);
                                if (transcriptList.add(transcript)) {
                                    System.out.println("Thêm điểm thành công");
                                } else {
                                    System.out.println("Không thêm được điểm");
                                }
                                break;
                            case 2:
                                System.out.println("_________CẬP NHẬT ĐIỂM_________");
                                if (transcriptList.update(scanner, studentList, subjectList)) {
                                    System.out.println("Cập nhật điểm thành công");
                                } else {
                                    System.out.println("Không cập nhật được điểm cho môn học");
                                }
                                break;
                            case 3:
                                System.out.println("_________XÓA ĐIỂM_________\"");
                                if (transcriptList.remove(scanner, studentList, subjectList)) {
                                    System.out.println("Xóa điểm thành công");
                                } else {
                                    System.out.println("Không xóa được điểm danh sách");
                                }
                                break;
                            case 4:
                                transcriptList.studentDisplay(studentList, subjectList);
                                break;
                            case 5:
                                transcriptList.subjectDisplay(studentList, subjectList);
                                break;
                        }
                    } while ((optSub != 0));
                    break;
                case 4:
                    do {
                        System.out.println("_________TÌM KIẾM_________");
                        System.out.println("\t1_________Theo mã sinh viên_________");
                        System.out.println("\t2_________Theo mã môn học_________");
                        System.out.println("\t0. Thoát");
                        System.out.print("\tNhập lựa chọn: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                transcriptList.searchStudent(scanner, studentList, subjectList);
                                break;
                            case 2:
                                transcriptList.searchSubject(scanner, studentList, subjectList);
                                break;
                        }
                    } while (optSub != 0);
                    break;
            }
        } while (optMain != 0);
    }
}
