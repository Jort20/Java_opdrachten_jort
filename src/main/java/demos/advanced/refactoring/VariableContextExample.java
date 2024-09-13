package demos.advanced.refactoring;

public class VariableContextExample {

    public class UserManagement {
        private User user;
        private Address address;
        private DataSource dataSource;
        //much code
    }

    public class User {
        private long id;
        private String name;
        private int numberOfLogins;
    }

    public class Address {
        private String street;
        private int number;
        private String numberPostfix;
        private String zipCode;
    }

    public class DataSource {
        private String dataSourceUrl;
        private int port;
    }


    /**
     * uses a long  method where much
     *
     * @param character
     * @param count
     */
    void printCharacterStatistics(char character, int count) {
        String number;
        String verb;
        String pluralModifier;


        if (count == 0) {
            number = "no";
            verb = " are ";
            pluralModifier = "s";

        } else if (count == 1) {
            number = " 1 ";
            verb = "is";
            pluralModifier = " ";

        } else {

            number = Integer.toString(count);
            verb = " are ";
            pluralModifier = "s";

        }

        String guessMessage = String.format("There %s %s %s%s", verb, number, character, pluralModifier);

        System.out.print(guessMessage);

    }

}
