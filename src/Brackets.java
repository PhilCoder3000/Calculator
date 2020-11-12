import java.util.ArrayList;
import java.util.List;

public class Brackets {

    private static final MathOperation math = new MathOperation();

    public boolean haveBrackets(List<String> demo){
        for (String s : demo) {
            if (s.matches("[()]")){
                return true;
            }
        }
        return false;
    }

    public List<String> findBrackets(List<String> demo) {
        int openBracket = 0;
        int closeBracket = 0;
        for (int i = 0; i < demo.size(); i++) {
            if (demo.get(i).equals("(")){
                openBracket = i;
            }
            if (demo.get(i).equals(")")){
                closeBracket = i;
                break;
            }
        }
        if (openBracket == 0 && closeBracket == 0){
            return demo;
        } else {
            demo = deleteIntInBrackets(demo,openBracket,closeBracket);
            return findBrackets(demo);
        }
    }

    public List<String> deleteIntInBrackets(List<String> demo, int openBracket, int closeBracket) {
        List<String> listInBrackets = new ArrayList<>();
        for (int i = openBracket + 1; i < closeBracket; i++) {
            listInBrackets.add(demo.get(i));
        }
        for (int i = openBracket; i <= closeBracket; i++) {
            demo.remove(openBracket);
        }
        demo.add(openBracket, String.valueOf(math.goSwitch(listInBrackets)));
        return demo;
    }
}
