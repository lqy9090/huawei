import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordTestHj20 {

//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNext()) {
//                String pswd = scanner.nextLine();
//
//                //长度
//                boolean res = true;
//                if (pswd.length() < 8) {
//                    res = false;
//                }
//                //至少包含三种
//                String Upper = "[A-Z]"; String lower = "[a-z]";String num = "\\d";String character = "[\\W_]";
//                ArrayList<String> list = new ArrayList<>();
//                list.add(Upper);list.add(lower);list.add(num);list.add(character);
//                int type = 0;
//                for (String regex : list) {
//                    Pattern pattern = Pattern.compile(regex);
//                    Matcher matcher = pattern.matcher(pswd);
//                    boolean finder = matcher.find();
//                    if (finder) {
//                        type += 1;
//                    }
//                }
//                if (type < 3) {
//                    System.out.println("NG");
//                    continue;
//                }
//
//                //不包含重复子串
//                ArrayList<String> regexs = new ArrayList<>();
//                int j = 2;
//                for (int i = 0; i < pswd.length()-2; i ++) {
//                    System.out.println("i: "+i+" j: "+j);
//                    regexs.add(pswd.substring(i, j));
//                    j ++;
//                }
//
//                for (String regex : regexs) {
//                    int count  = 0;
//                    Pattern pattern = Pattern.compile(regex);
//                    Matcher matcher = pattern.matcher(pswd);
//                    while (matcher.find()) {
//                        count++;
//                        if (count >= 2) {
//                            res=false;
//                            break;
//                        }
//                    }
//                }
//
//                if (res) System.out.println("OK");
//                else System.out.println("NG");
//            }
//            scanner.close();
//        }

    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            if(str.length()<=8){
                System.out.println("NG");
                continue;
            }

            if(getMatch(str)){
                System.out.println("NG");
                continue;
            }

            if(getString(str,0,3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    private static boolean getString(String str,int l,int r) {
        if (r>=str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }

    private static boolean getMatch(String str){
        int count=0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count>=3){
            return false;
        }else{
            return true;
        }
    }
}
