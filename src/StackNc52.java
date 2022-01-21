import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StackNc52 {
    public final static List<Character> inChar=new ArrayList<>(){{add('(');add('[');add('{');}};
    public final static List<Character> outChar=new ArrayList<>(){{add(')');add(']');add('}');}};

    public boolean isValid (String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap map = generateMap();

        for (int i = 0; i < chars.length; i++) {
            if (inChar.contains(chars[i])) {
                if (i == chars.length-1) return false;
                stack.add(chars[i]);
            }
            if (outChar.contains(chars[i])){
                if (stack.isEmpty()) return false;
                Character popCh = stack.pop();
                if (!popCh.equals(map.get(chars[i]))) return false;
                if (i == chars.length -1 && !stack.isEmpty()) return false;
            }
        }
        return true;
    }


    public static HashMap generateMap() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        return map;
    }

    public static void main(String[] args) {
        StackNc52 solution = new StackNc52();
        boolean valid = solution.isValid("[]");
        System.out.println(valid);
    }


    public boolean isValidFei (String s) {
        if (s.length() <= 1) return false;
        if (s.length() % 2 !=0) return false;
        HashMap map = generateMap();
        char[] chars = s.toCharArray();
        boolean flag = true;
        Character lastCh = chars[0];
        for (int i = 1; i < chars.length; i++) {
            Character character = chars[i];
            if (map.get(character) != null) {
                if (!map.get(character).equals(lastCh)) {
                    flag = false;
                }
            }else{
                if (lastCh.equals(character)) flag = false;
                lastCh = character;
            }
        }

        return flag;
    }

    public boolean isValidBR (String s) {
        // write code here
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            // 碰到左括号，就把相应的右括号入栈
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
                // 如果是右括号判断是否和栈顶元素匹配
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        // 最后判断栈中元素是否匹配
        return stack.isEmpty();
    }
}
