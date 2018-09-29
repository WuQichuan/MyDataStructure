package stack;

import java.util.Stack;

/**
 * @author WuQiChuan
 * @Description:栈的应用经典试题：验证括号匹配问题
 * 比如：{[()]}为匹配，({)}为不匹配
 * 匹配返回ture，不匹配返回false
 * @Date: Created in:2018/9/29 20:01
 * @Version: 1.0
 */
public class TestValidParaentheses {
    public boolean isValid(String s){
        //使用java提供的栈
        Stack<Character> stack = new Stack<>();
        //使用自我封装的栈
        MyArrayStack<Character> myArryStack = new MyArrayStack<>();
        //遍历传入的字符串
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //如果检测到左括号则入栈
            if( c == '(' || c == '[' || c == '{'){
                myArryStack.push(c);
            }else{
                //循环未完成栈空了，说明多了右括号
                if(myArryStack.isEmpty()){
                    return false;
                }
                //出栈并获取出栈的栈顶元素
                char topChar = myArryStack.pop();
                //如果现在是有括号，但是栈顶不是左括号，则匹配失败
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        //如果栈为空，说明全部匹配成功。不为空说明有没匹配成的左括号，匹配失败。
        return myArryStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new TestValidParaentheses().isValid("(){}[]"));
        System.out.println(new TestValidParaentheses().isValid("({)}[]"));
    }
}
