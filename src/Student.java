import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

class Student {
    private String fname;
    private String lname;
    private String indexNumber;
    private String email;
    private String address;
    private Set<Double> grades;
    private Set<StudentGroup> studentGroups;

    public Student(String fname, String lname, String indexNumber, String email, String address) {
        this.fname = fname;
        this.lname = lname;
        this.indexNumber = indexNumber;
        this.email = email;
        this.address = address;
        this.grades = new HashSet<>();
        this.studentGroups = new HashSet<>();
    }

    public void addGrade(double grade) {
        if (grades.size() >= 20) {
            throw new IllegalArgumentException("Student nie może mieć więcej niż 20  ocen .");
        }
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Nie ma ocen potrzebnych do kalkulacji.");
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        return roundToNearestGrade(average);
    }

    private double roundToNearestGrade(double average) {
        List<Double> possibleGrades = Arrays.asList(2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0);
        double closest = possibleGrades.get(0);
        for (double grade : possibleGrades) {
            if (Math.abs(grade - average) < Math.abs(closest - average)) {
                closest = grade;
            }
        }
        return closest;
    }

    public void addStudentGroup(StudentGroup group) {
        if (!studentGroups.contains(group)) {
            studentGroups.add(group);
            group.addStudent(this);
        }
    }

    public void removeStudentGroup(StudentGroup group) {
        studentGroups.remove(group);
        group.getStudents().remove(this);
    }

    public Set<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}

class StudentGroup {
    private String nazwa;
    private Set<Student> students;

    public StudentGroup(String nazwa) {
        this.nazwa = nazwa;
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= 15) {
            throw new IllegalArgumentException("Grupa nie może mieć więcej niż 15 osób ");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException("Student jest już w grupie.");
        }
        students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public String getNazwa() {
        return nazwa;
    }


}
