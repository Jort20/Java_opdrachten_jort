package section3_apis.part2_collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * YOUR CHALLENGE:
 * This class only contains a so-called public API. There is no underlying code that supports the API.
 * It is your task to implement this logic. Using the right collection type(s).
 */
public class StudentAdmin {
    /**
     * Returns the students that are present in the database.
     * If the searchString is * (a wildcard), all students will be returned. Else,
     * a simple case insensitive substring match to both first name and family name will be performed.
     * @param searchString the substring string to look for
     * @return students
     */
    private Map<Integer, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    // Add a student to the system
    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    // Add a grade for a student in a course
    public void addGrade(String courseId, int studentId, double grade) {
        // Fetch the course, or create it if it doesn't exist
        Course course = courses.getOrDefault(courseId, new Course(courseId));
        courses.putIfAbsent(courseId, course);

        // Get the student
        Student student = students.get(studentId);
        if (student != null) {
            // Add the grade to the course
            course.addStudentGrade(student, grade);
        }
    }

    // Retrieve students based on the search string (supports wildcard "*")
    public List<Student> getStudents(String searchString) {
        if (searchString.equals("*")) {
            return new ArrayList<>(students.values());
        }
        return students.values().stream()
                .filter(s -> s.getFirstName().toLowerCase().contains(searchString.toLowerCase())
                        || s.getLastName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }
    /**
     * Returns the grade of a student for the given course
     * @param student the student
     * @param course the course
     * @return grade
     */
    // Retrieve a student's grade for a specific course
    public double getGrade(Student student, Course course) {
        // Lookup the course by its courseId
        Course existingCourse = courses.get(course.getCourseId());

        if (existingCourse == null) {
            // No such course found
            return 0.0;
        }

        // Lookup the student by its studentId
        Student existingStudent = students.get(student.getStudentId());

        if (existingStudent == null) {
            // No such student found
            return 0.0;
        }

        // Get the student's grade from the course
        return existingCourse.getGrade(existingStudent);
    }
    /**
     * returns all grades for a student, as [key=CourseID]:[value=Grade] Map
     * @param student the student to fetch grades for
     * @return grades
     */
    // Retrieve all grades for a student as a Map<CourseID, Grade>
    public Map<String, Double> getGradesForStudent(Student student) {
        Map<String, Double> studentGrades = new HashMap<>();
        for (Course course : courses.values()) {
            if (course.hasStudent(student)) {
                studentGrades.put(course.getCourseId(), course.getGrade(student));
            }
        }
        return studentGrades;
    }
    /**
     * Returns all grades for a course, as [key=Student]:[value=Grade] Map
     * @param course the course
     * @return grades
     */
    // Retrieve all grades for a course as a Map<Student, Grade>
    public Map<Student, Double> getGradesForCourse(Course course) {
        // Find the course by its ID instead of comparing object references
        Course existingCourse = courses.get(course.getCourseId());

        if (existingCourse == null) {
            // If the course doesn't exist, return an empty map
            return Collections.emptyMap();

        }

        // Return the grades from the existing course
        return existingCourse.getAllGrades();
    }

}

