public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe", "123456", "john.doe@example.com", "123 Main St");
        Student student2 = new Student("Jane", "Doe", "654321", "jane.doe@example.com", "456 Elm St");

        StudentGroup group1 = new StudentGroup("Group A");
        StudentGroup group2 = new StudentGroup("Group B");

        student1.addStudentGroup(group1);
        student1.addStudentGroup(group2);

        student2.addStudentGroup(group1);

        // Print the student groups for student1
        System.out.println("Student1 is in groups:");
        for (StudentGroup group : student1.getStudentGroups()) {
            System.out.println(group.getNazwa());
        }

        // Print the students in group1
        System.out.println("Group1 has students:");
        for (Student student : group1.getStudents()) {
            System.out.println(student.getFname() + " " + student.getLname());
        }
    }
}