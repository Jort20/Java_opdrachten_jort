package section3_apis.part2_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * YOUR CHALLENGE:
 * Class Course models a teaching course. How are you going to store the students grades in here?
 */
public class Course {
    private String courseId;
    private Map<Student, Double> studentGrades = new HashMap<>();

    public Course(final String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    // Add a grade for a student
    public void addStudentGrade(Student student, double grade) {
        studentGrades.put(student, grade);
    }

    // Get a student's grade
    public double getGrade(Student student) {
        return studentGrades.getOrDefault(student, 0.0);
    }

    // Check if a student is in the course
    public boolean hasStudent(Student student) {
        return studentGrades.containsKey(student);
    }

    // Get all student grades for the course
    public Map<Student, Double> getAllGrades() {
        return Collections.unmodifiableMap(studentGrades);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Course course = (Course) o;
        return this.courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.courseId);
    }
}

