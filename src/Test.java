import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regex = "[abc]";
        String str = "bad";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        int i = 0;
        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
    }
}
