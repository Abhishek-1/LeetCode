import java.util.Stack;
import org.junit.Assert;

/**
 * Problem - 20
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Input: s = "()[]{}"
 * Output: true
 */
public class Q20_Valid_Parenthesis {

  public static boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();

    for(int i=0; i<s.length(); i++){
      switch(s.charAt(i)){
        case '(':
          stack.push(')');
          break;
        case '{':
          stack.push('}');
          break;
        case '[':
          stack.push(']');
          break;
        default:
          if(stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
      }
    }

    return stack.isEmpty();

  }

  public static void main(String[] args){
    Assert.assertEquals(isValid("()"), true);
  }



}
