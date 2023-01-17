package tracker;

public class CheckInput {

    private String firstName;
    private String lastName;
    private String email;

    private int lengthInput;

    public CheckInput(String input) {
        String[] in = input.split(" ");
        this.lengthInput = in.length;
        this.firstName = in[0];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < in.length - 1; i++) {
            stringBuilder.append(in[i]);
        }
        this.lastName = String.valueOf(stringBuilder);
        this.email = in[in.length - 1];
    }

    public boolean checkAll() {
        return checkCredentials() && checkFirstName() && checkLastName() && checkEmail();
    }

    public boolean checkCredentials() {
        if (this.lengthInput >= 3) {
            return true;
        }
        System.out.println("Incorrect credentials.");
        return false;
    }

    public boolean checkFirstName() {
        if (onlyASCII(this.firstName) && lengthMoreThanTwo(this.firstName)) {
            return true;
        }
        System.out.println("Incorrect first name.");
        return false;
    }

    public boolean checkLastName() {
        if (onlyASCII(this.lastName) && lengthMoreThanTwo(this.lastName)) {
            return true;
        }
        System.out.println("Incorrect last name.");
        return false;
    }

    public boolean checkEmail() {
        if (this.email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
            return true;
        }
        // ^[A-Z0-9+_.-]+@[A-Z0-9.-]+$ may be use this
        System.out.println("Incorrect email.");
        return false;
    }

    public boolean onlyASCII(String firstOrLastName) {
        if (firstOrLastName.matches("[a-zA-Z-']+")) {
            if (!firstOrLastName.startsWith("'") || !firstOrLastName.startsWith("-") || !firstOrLastName.endsWith("'") || !firstOrLastName.endsWith("-")) {
                if (!firstOrLastName.matches("'-") && !firstOrLastName.matches("-'")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean lengthMoreThanTwo(String firstOrLastName) {
        return firstOrLastName.length() >= 2;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }
}
