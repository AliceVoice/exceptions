public class Log {
    public static void validateUser(String login, String password, String confirmPassword) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

        try {
            if (login.length() > 20 || containsInvalidChars(login, allowedChars)) {
                throw new WrongLoginException("Превышена максимальная длина или неправильный формат логина");
            }
            if (password.length() > 20 || containsInvalidChars(password, allowedChars)) {
                throw new WrongPasswordException("Превышена максимальная длина или неправильный формат пароля");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            System.out.println("Исключение: " + e.getMessage());
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