import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Logic {

    private static final Console console = new Console();
    private static final Check check = new Check();
    private static final MathOperation math = new MathOperation();
    private static final StringToList stringToList = new StringToList();

    public void start(){
        while (true) {
            String string = console.read();

            if (string.equals("end")) {
                console.closeScanner();
                break;
            }

            List<String> list = stringToList.stringToList(string);

            if (check.checkNumberAndSymbols(list)){
                System.out.println("Вводите только цифры, математические знаки и скобки");
                continue;
            }

            if (check.checkLastLetter(list)){
                System.out.println("На конце выражения должна быть цифра");
                continue;
            }

            if (check.checkDoubleSymbols(list)){
                System.out.println("Знаки не могут идти подряд");
                continue;
            }
            if (check.checkShareOnNull(list)) {
                System.out.println("На нуль делить нельзя");
                continue;
            }

            console.print(math.letsCalculate(list));
        }
    }
}