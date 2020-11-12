import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MathOperation {

    private final Brackets brackets = new Brackets();

    public Double letsCalculate(List<String> list) {
        if (brackets.haveBrackets(list)) {
            goSwitch(brackets.findBrackets(list));
        }
        return goSwitch(list);
    }

    public Double goSwitch(List<String> list) {
        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                switch (list.get(i)) {
                    case "*":
                        multiply(i,list);
                        i = 0;
                        break;
                    case "/":
                        share(i,list);
                        i = 0;
                        break;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                switch (list.get(i)) {
                    case "+":
                        plus(i,list);
                        i = 0;
                        break;
                    case "-":
                        minus(i,list);
                        i = 0;
                        break;
                }
            }
        }
        return Double.parseDouble(list.get(0));
    }

    private void multiply(int index,List<String> list) {
        double resOperation = Double.parseDouble(list.get(index - 1)) * Double.parseDouble(list.get(index + 1));
        addAndRemove(index,resOperation,list);
    }

    private void share(int index,List<String> list) {
        double resOperation = Double.parseDouble(list.get(index - 1)) / Double.parseDouble(list.get(index + 1));
        addAndRemove(index,resOperation,list);
    }

    private void plus(int index,List<String> list) {
        double resOperation = Double.parseDouble(list.get(index - 1)) + Double.parseDouble(list.get(index + 1));
        addAndRemove(index,resOperation,list);
    }

    private void minus(int index,List<String> list) {
        double resOperation = Double.parseDouble(list.get(index - 1)) - Double.parseDouble(list.get(index + 1));
        addAndRemove(index,resOperation,list);
    }

    private void addAndRemove(int index, double resOperation,List<String> list) {
        list.add(index - 1, String.valueOf(resOperation));
        list.remove(index);
        list.remove(index);
        list.remove(index);
        goSwitch(list);
    }
}
