package demos.advanced.annotations;

import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Student s = new Student("John", "Doe", 12345);
        //Teacher t = new Teacher("Jane", "Smith", 6666);
        try {
            serialize(s);
            //serialize(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();
        if (clazz.isAnnotationPresent(Serializable.class)) {
            System.out.println("Class: " + clazz.getName());
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(SerializableField.class)) {
                    //make private fields accessible
                    field.setAccessible(true);
                    System.out.println("Serializable field! name= '" + field.getName() +
                            "' annotation name='" + field.getAnnotation(SerializableField.class).name() +
                            "' value='" + field.get(o) + "'");
                }
            }
        } else {
            System.out.println("Class: " + clazz.getName() + " is not serializable");
        }
    }
}
