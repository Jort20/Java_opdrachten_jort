package demos.advanced.annotations;

@Serializable
public class Student {
    @SerializableField
    private String firstName;

    @SerializableField
    private String lastName;

    @SerializableField(name="student-ID")
    private int studentId;

    //not interested in serializing this field
    private String email;

    public Student(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }
}
