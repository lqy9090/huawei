import java.util.HashMap;
import java.util.Scanner;

public class movePoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int x =0, y=0;
            String[] sArray = s.split(";");
            String reg = "[ADWS]\\d{1}\\d?";
            for (int i = 0; i < sArray.length; i++) {
                //校验是否符合规范
                //并且将对应字母走的格数放入到map中
                if (sArray[i].matches(reg)){
                    Character chKey = sArray[i].charAt(0);
                    Integer num = Integer.valueOf(sArray[i].substring(1));
                    map.put(chKey, map.getOrDefault(chKey, 0) + num);
                }
            }
            if (map.size() > 0) {
                x = x - map.get('A') + map.get('D');
                y = y - map.get('S') + map.get('W');
            }
            System.out.println(x + "," + y);
            map.clear();
        }
        scanner.close();
    }
}
