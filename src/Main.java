public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        try {
            logic.start();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
            logic.start();
        }

    }
}
