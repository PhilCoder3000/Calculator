import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return scanner.nextLine().trim().replaceAll(" ","");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void print(double s) {
        System.out.format("%.3f",s);
        System.out.println("");
    }
}
