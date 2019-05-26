public interface Expression {
    public boolean interpret(String context);
 }

 public class TerminalExpression implements Expression {
    private String name; 
    public TerminalExpression(String name){  // 将name保存在类的私有成员上，如果interpret测试的name和对象内保存的name一样，则返回true
       this.name = name; 
    }
    @Override
    public boolean interpret(String context) {  // 是的
       if(context.contains(name)){
          return true;
       }
       return false;
    }
 }

 public class OrExpression implements Expression {  // 如果Or运算的传入的2个Expression，任意其中有1个含有context，则返回true
    private Expression expr1 = null;
    private Expression expr2 = null; 
    public OrExpression(Expression expr_arg1, Expression expr_arg2) { 
       this.expr1 = expr_arg1;
       this.expr2 = expr_arg2;
    } 
    @Override
    public boolean interpret(String context) {      
       return expr1.interpret(context) || expr2.interpret(context);
    }
 }

 public class AndExpression implements Expression {  // 如果And运算的传入的2个Expression，都含有context，则返回true
    private Expression expr1 = null;
    private Expression expr2 = null;
    public AndExpression(Expression expr_arg1, Expression expr_arg2) { 
       this.expr1 = expr_arg1;
       this.expr2 = expr_arg2;
    }
    @Override
    public boolean interpret(String context) {      
       return expr1.interpret(context) && expr2.interpret(context);
    }
 }
 public class InterpreterPatternDemo {
    //规则：Robert 和 John 是男性
    public static Expression getMaleExpression(){
       Expression robert = new TerminalExpression("Robert");
       Expression john = new TerminalExpression("John");
       return new OrExpression(robert, john);    
    }
    //规则：Julie 是一个已婚的女性
    public static Expression getMarriedWomanExpression(){
       Expression julie = new TerminalExpression("Julie");
       Expression married = new TerminalExpression("Married");
       return new AndExpression(julie, married);    
    }
    public static void main(String[] args) {
       Expression isMale = getMaleExpression();
       Expression isMarriedWoman = getMarriedWomanExpression();
       System.out.println("John is male? " + isMale.interpret("John"));// isMale是1个“OrExpression(robert, john)”对象， isMale.interpret("John")返回true
       // isMarriedWoman是AndExpression(julie, married)，内含有 Married和Julie元素，interpret返回true
       System.out.println("Julie is a married women? "  + isMarriedWoman.interpret("Married Julie"));
    }
 }