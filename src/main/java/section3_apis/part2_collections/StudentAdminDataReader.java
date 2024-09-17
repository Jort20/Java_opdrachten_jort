    package section3_apis.part2_collections;

    import java.io.BufferedReader;
    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Arrays;

    /**
     * This class has all basic file reader functionality.
     * There are two methods you need to implement:
     * The processLine() method of both LineHandlers.
     */
    public class StudentAdminDataReader {

        private StudentAdmin studentAdmin;

        public StudentAdmin importAll(String studentsFile, String courseResultsFile) {
            this.studentAdmin = new StudentAdmin();
            readStudents(studentsFile);
            readCourseResults(courseResultsFile);

            return studentAdmin;
        }

        private void readStudents(String studentsFile) {
            Path filePath = initFile(studentsFile);
            readFile(filePath, new StudentLineHandler());

        }

        private void readCourseResults(String courseResultsFile) {
            Path filePath = initFile(courseResultsFile);
            readFile(filePath, new CoursesLineHandler());
        }

        private void readFile(Path filePath, LineHandler lineHandler) {
            int lineCount = 0;
            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    if (lineCount == 1) continue;
                    lineHandler.processLine(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private Path initFile(String fileName) {
            Path path = Paths.get(fileName);
            File file = path.toFile();
            if (! (file.exists() && file.canRead())) {
                throw new IllegalArgumentException("file " + file + " does not exist or is not readable.");
            }
            return path;
        }

        private interface LineHandler {
            void processLine(String line);
        }

        /**
         * processes each line of the file students.txt
         */
        private class StudentLineHandler implements LineHandler {
            @Override
            public void processLine(String line) {
                String[] elements = line.split("\t");
                int studentId = Integer.parseInt(elements[0]);
                String firstName = elements[1];
                String lastName = elements[2];

                // Create a new Student object and pass it to StudentAdmin to store
                Student student = new Student(studentId, firstName, lastName);
                studentAdmin.addStudent(student);  // Assume we have this method in StudentAdmin
            }
        }


        /**
         * processes each line of the file courses.csv
         */
        private class CoursesLineHandler implements LineHandler {
            @Override
            public void processLine(String line) {
                String[] elements = line.split(";");
                String courseId = elements[0];
                int studentId = Integer.parseInt(elements[1]);
                double grade = Double.parseDouble(elements[2]);

                // Pass the data to StudentAdmin to store grades
                studentAdmin.addGrade(courseId, studentId, grade);  // Assume we have this method in StudentAdmin
            }
        }



        public static void main(String[] args) {
            StudentAdminDataReader dataReader = new StudentAdminDataReader();
            dataReader.importAll("data/students.txt", "data/courses.csv");
        }
    }
