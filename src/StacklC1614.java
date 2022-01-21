import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class  StacklC1614 {
    public final static List<Character> inChar=new ArrayList<Character>(){{add('(');add('[');add('{');}};
    public final static List<Character> outChar=new ArrayList<Character>(){{add(')');add(']');add('}');}};


    public int maxDepth(String s) {
        int n = s.length();
        int depth = 0;
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if (curChar == '('){
                ++depth;
                maxDepth = Math.max(depth, maxDepth);
            }else if (curChar == ')') {
                --depth;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        StacklC1614 solution = new StacklC1614();
//        String s = "(1+(2*3)+((8)/4))+1";
        String s = "8*((1*(5+6))*(8/6))";
        int depth = solution.maxDepth(s);
        System.out.println(depth);
    }
}
