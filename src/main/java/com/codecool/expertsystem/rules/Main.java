import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Value single = new SingleValue("param1", true);
        List<String> params = new ArrayList<>();
        params.add("param1");
        params.add("param2");
        Value multiple = new MultipleValue(params, false);
        for (String param : multiple.getInputPattern()) {
            System.out.println(param);
        }
    }
}