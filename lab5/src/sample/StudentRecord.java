package sample;

public class StudentRecord {
    private  String studentID;
    private Float assignments;
    private Float midterm;
    private Float finalExam;
    private Float finalMark;
    private String letterGrade;
    public StudentRecord (String studentID,Float assignments,Float midterm, Float finalExam){
        this.studentID=studentID;
        this.assignments=assignments;
        this.midterm=midterm;
        this.finalExam=finalExam;
        this.finalMark=FinalMark();
        this.letterGrade=LetterGrade();
    }
    private Float FinalMark(){
        return ((assignments * 0.2f)+(midterm*0.3f)+(finalExam * 0.5f));
    }


    public String getStudentID(){
        return studentID;
    }
    public Float getMidterm(){
        return midterm;
    }
    public Float getAssignments(){
        return assignments;
    }
    public Float getFinalExam(){
        return finalExam;
    }
    public Float getFinalMark(){
        return finalMark;
    }

    private String LetterGrade(){
        if (finalMark >= 80.0f) {
            return "A";
        }
        else if (finalMark >= 70.0f) {
            return "B";
        }
        else if (finalMark >= 60.0f) {
            return "C";
        }
        else if (finalMark >= 50.0f) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getLetterGrade(){
        return letterGrade;
    }



}