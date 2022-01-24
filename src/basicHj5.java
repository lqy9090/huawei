import java.util.Scanner;

public class basicHj5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String num = str.substring(2);
            int power = 1;
            int result = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                if (c >= '0' && c <= '9') {
                    result += (c-'0') * power;
                } else if (c >= 'A' && c <= 'F') {
                    result += (c - 'A' + 10) * power;
                }
                power *= 16;
            }
            System.out.println(result);
        }
        in.close();
    }

}
