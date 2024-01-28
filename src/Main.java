public class Main {

    public static void main(String[] args) {
        try {
            Log.validateUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
