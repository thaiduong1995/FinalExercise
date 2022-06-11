package data;

import manager.StudentList;
import manager.SubjectList;
import manager.TranscriptList;

import java.util.Scanner;

public class Transcript {
    private String studentCode;
    private String subjectCode;
    private float points;

    public Transcript update(Scanner scanner) {
        System.out.print("Nhập điểm mới: ");
        float points = Float.parseFloat(scanner.nextLine());
        if (points < 0 || points > 10) {
            return null;
        } else {
            this.points = points;
            return this;
        }
    }

    public Transcript create(Scanner scanner, StudentList studentList, SubjectList subjectList, TranscriptList transcriptList) {
        System.out.print("Mã sinh viên: ");
        String studentCode = scanner.nextLine();
        if( studentList.getIndex(studentCode) < 0) {
            System.out.println("Mã sinh viên không tồn tại");
            return null;
        }
        System.out.print("Mã môn học: ");
        String subjectCode = scanner.nextLine();
        if (subjectList.getIndex(subjectCode) < 0) {
            System.out.println("Mã môn học không tồn tại");
            return null;
        }
        if (transcriptList.getIndex(studentCode, subjectCode) >= 0) {
            System.out.println("Sinh viên đã có điểm");
            return null;
        } else {
            System.out.print("Nhập điểm: ");
            float points = Float.parseFloat(scanner.nextLine());
            if (points < 0 || points > 10) {
                return null;
            } else {
                this.studentCode = studentCode;
                this.subjectCode = subjectCode;
                this.points = points;
                return this;
            }
        }
    }

    public Transcript() {
    }

    public Transcript(String studentCode, String subjectCode, float points) {
        this.studentCode = studentCode;
        this.subjectCode = subjectCode;
        this.points = points;
    }

    public Transcript(float points) {
        this.points = points;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }
}
