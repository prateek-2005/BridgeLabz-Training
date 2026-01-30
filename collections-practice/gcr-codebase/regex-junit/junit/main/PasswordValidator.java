public class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
