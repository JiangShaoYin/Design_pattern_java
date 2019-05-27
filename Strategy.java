	public interface Strategy {
	   public int doOperation(int num1, int num2);
	}
	
	
	public class OperationAdd implements Strategy{  // 做加法
	   @Override
	   public int doOperation(int num1, int num2) {
	      return num1 + num2;
	   }
	}
	public class OperationSubstract implements Strategy{ // 做减法
	   @Override
	   public int doOperation(int num1, int num2) {
	      return num1 - num2;
	   }
	}
	
	
	public class Context {          // Context是1个使用了某种策略的类
	   private Strategy strategy;   // 根据传入的args_strategy，执行特定的操作
	 
	   public Context(Strategy args_strategy){
	      this.strategy = args_strategy;
	   }
	   public int executeStrategy(int num1, int num2){
	      return strategy.doOperation(num1, num2);
	   }
	}
	
	public class StrategyPatternDemo {
	   public static void main(String[] args) {
	      Context context = new Context(new OperationAdd());    
	      System.out.println("10 + 5 = " + context.executeStrategy(10, 5)); // 输出10 + 5 = 15
	 
	      context = new Context(new OperationSubstract());      
	      System.out.println("10 - 5 = " + context.executeStrategy(10, 5)); // 输出10 - 5 = 5
	   }
	}
	