package examinformation;

public class ExamResult {

    private String name;
    private int theory;
    private int practice;

    public ExamResult(String name) {
        this.name = name;
    }

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public int getPractice() {
        return practice;
    }

    public int getTheory() {
        return theory;
    }

    public String getName() {
        return name;
    }
}
