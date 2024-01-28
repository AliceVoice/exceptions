public class Log {
    private static final String ALLOWED_CHARS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static void validateUser(String login, String password, String confirmPassword) {

        if (login.length() > 20 || containsInvalidChars(login, ALLOWED_CHARS)) {
            throw new WrongLoginException("Превышена максимальная длина или неправильный формат логина");
        }
        if (password.length() > 20 || containsInvalidChars(password, ALLOWED_CHARS)) {
            throw new WrongPasswordException("Превышена максимальная длина или неправильный формат пароля");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean containsInvalidChars(String str, String allowedChars) {
        for (int i = 0; i < str.length(); i++) {
            if (allowedChars.indexOf(str.charAt(i)) == -1) {
                return true;
            }
        }
        return false;
    }
}