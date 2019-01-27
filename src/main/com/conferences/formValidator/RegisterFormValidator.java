package conferences.formValidator;

public class RegisterFormValidator {

    private String nickName;
    private String email;
    private String password;
    private String messageError;

    private interface CheckField {
        boolean isCorrect(String field);
    }

    public RegisterFormValidator() {
    }

    public RegisterFormValidator(String nickName, String email, String password) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getNickName() { return nickName; }

    public void setNickName(String nickName) { this.nickName = nickName; }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageError() {
        return messageError;
    }

    public boolean isFormValid() {

        // check userName min 4 letters
        CheckField checkFieldMin4 = new CheckField() {
            @Override
            public boolean isCorrect(String field) {
                if (field.length() < 4) {
                    messageError = "Minimum 4 leters in password!";
                    return false;
                }
                return true;
            }
        };
        if ( ! checkFieldMin4.isCorrect(nickName)) {
            return false;
        }

        //check email if correct
        CheckField checkFieldEmail = new CheckField() {
            @Override
            public boolean isCorrect(String field) {
                boolean res = field.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                if (!res) {
                    messageError = "Invalid Email!";
                }
                return res;
            }
        };

        if ( ! checkFieldEmail.isCorrect(email)) {
            return false;
        }

        //check password minimun 4
        if ( ! checkFieldMin4.isCorrect(password)) {
            return false;
        }

        // check password has min 1 number
        CheckField checkFieldMin1Number = new CheckField() {
            @Override
            public boolean isCorrect(String field) {
                boolean res = field.matches("");
                if (!res) {
                    messageError = "Password should contains a number!";
                }
                return true;
            }
        };
        if ( ! checkFieldMin1Number.isCorrect(password)) {
            return false;
        }

        return true;
    }

}
