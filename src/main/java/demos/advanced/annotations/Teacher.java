package demos.advanced.annotations;

@Serializable
public class Teacher {
    @SerializableField
    private String firstName;

    @SerializableField
    private String lastName;

    @SerializableField(name="teacher-ID")
    private int teacherId;

    //not interested in serializing this field
    private String email;

    public Teacher(String firstName, String lastName, int teacherId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getEmail() {
        return email;
    }
}
