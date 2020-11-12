import java.util.List;

public class Check {

    private final String regex1 = "[+*\\-/]";
    private final String regex2 = "[^+*\\-/\\d()]";
    private final String regex3 = "([+*\\-/]){2,}";

    public boolean checkNumberAndSymbols(List<String> list) {
        for (String s : list) {
            if (s.matches(regex2))
            return true;
        }
        return false;
    }

    public boolean checkLastLetter(List<String> list){
        return list.get(list.size()-1).matches(regex1);
    }

    public boolean checkDoubleSymbols(List<String> list) {
        for (String s : list) {
            if (s.matches(regex3)) return true;
        }
        return false;
    }
    public boolean checkShareOnNull(List<String> list){
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).equals("/") && Double.parseDouble(list.get(i + 1)) == 0) return true;
        }
        return false;
    }
}
