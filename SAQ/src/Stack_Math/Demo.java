package Stack_Math;
import java.util.Stack;
public class Demo {

  private boolean matching = true;  

  
  private Stack s = new Stack();  // 
  
  public boolean isMatching() {  
    return matching && s.isEmpty();
  }

 

  public void add(char c) {  
    Character m = leftMatch(c);   // or use leftMatch2
    if (m == null)                // c is not a parenthesis
      ;                              // do nothing (i.e., ignore it)
    else if (m.charValue() == c)  // c is some kind of left parenthesis
      s.push(m);                     // push a Character version, m
    else {                        // c is some kind of right paren
      if (s.isEmpty() || !s.pop().equals(m))  
	matching = false;            // couldn't pop a matching left paren, m
    }
  }


  public void add(String s) {   
    for (int i=0; i < s.length(); i++)
      add(s.charAt(i));   
  }

  protected static Character leftMatch(char c) {
    switch (c) {
    case '(': 
    case ')':
      return new Character('(');   
    case '[':
    case ']':
      return new Character('[');
    case '{':
    case '}':
      return new Character('{');
    default:
      return null;
    }
  }


  protected static Character leftMatch2(char c) {
    Character d = null;
    if (d==null) d = leftMatchMaybe(c,'(',')');
    if (d==null) d = leftMatchMaybe(c,'[',']');
    if (d==null) d = leftMatchMaybe(c,'{','}');
    return d;
  }


  private static Character leftMatchMaybe(char c, char cl, char cr) {
    return (c==cl || c==cr) ? new Character(cl) : null;
  }

  public static void test(String s) {
    Demo mp = new Demo();
    mp.add(s);
    System.out.print(mp.isMatching() ? "Good: " : "Bad:  ");
    System.out.println(s);
  }

  public static void main(String args[]) {
    test("(3+(4*5)/6*7");
    test("(3+(4*5)/6)*7");
    test("(3+(4*5)/6))*7");
    test("(3+[4*5]/6)*7");
    test("(3+[4*5)/6]*7");
  }
}
