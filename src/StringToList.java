import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToList {
    public List<String> stringToList(String s){
      String s1 = s.replaceAll("(\\((\\-\\d+)\\))","$2");
        List<String> demo = Arrays.stream(s1.split("\\b"))
                .collect(Collectors.toList());

        if (demo.get(0).equals("-")) {
            demo.add(0, demo.get(0).concat(demo.get(1)));
            demo.remove(1);
            demo.remove(1);
        }

        for (int i = 0; i < demo.size(); i++) {
            if (demo.get(i).matches("[+\\-*/()]+")) {
                String [] strings = demo.get(i).split("");
                demo.remove(i);
                for (int j = 0; j < strings.length; j++) {
                    demo.add(i + j,strings[j]);
                }
            }
            if (demo.get(i).equals(".")){
                demo.add(i - 1, demo.get(i - 1).concat(demo.get(i)).concat(demo.get(i + 1)));
                demo.remove(i);
                demo.remove(i);
                demo.remove(i);
                i--;
            }
            if (demo.get(i).equals("-")
                    && demo.get(i - 1).matches("[+\\-*/(]")
                    && demo.get(i + 1).matches("\\d+")) {
                demo.add(i, demo.get(i).concat(demo.get(i + 1)));
                demo.remove(i + 1);
                demo.remove(i + 1);
            }
        }
        return demo;
    }
}
