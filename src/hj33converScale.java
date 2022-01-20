
import java.util.Scanner;

public class hj33converScale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            hj33converScale main = new hj33converScale();
            String convert = main.convert(str);
            System.out.println(convert);
//            if(str.contains(".")) ipToNum(str);
//            else numToIp(str);
        }

    }

    public static void ipToNum(String ip) {
        String[] numStrs = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String numStr : numStrs) {
            int num = Integer.parseInt(numStr);
            String s = Integer.toBinaryString(num);
//            System.out.println(s);

            if (s.length() != 8) {
                for(int i = 0; i<8 - s.length(); i++) builder.append("0");
            }

            builder.append(s);
        }
        System.out.println(builder);
        System.out.println(String.valueOf(builder));
        System.out.println(Integer.parseInt(String.valueOf(builder).trim(), 2));

    }

    public static void numToIp(String numStr) {
        int num= Integer.parseInt(numStr);//字符转十进制
        String binaryString = Integer.toBinaryString(num);

        StringBuilder builder1 = new StringBuilder();
        if (binaryString.length() < 32) {
            for(int i = 0; i<32 - binaryString.length(); i++)  builder1.append("0");
            builder1.append(binaryString);
        }
//        System.out.println(builder1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            String s = builder1.substring(i, i + 8);
            System.out.println(s);
            int anInt = Integer.parseInt(s, 2);//二进制字符转十进制
            builder.append(anInt);
            builder.append(".");
        }
        System.out.println(builder.deleteCharAt(builder.length()-1));
    }

    private final int N = 4;

    public String convert(String str) {
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256  + Integer.parseInt(fields[i]);
            }
            return ""+result;
        }else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "."+result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }
}
