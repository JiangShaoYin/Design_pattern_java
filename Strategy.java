	public interface Strategy {
	   public int doOperation(int num1, int num2);
	}
	
	
	public class OperationAdd implements Strategy{  // ���ӷ�
	   @Override
	   public int doOperation(int num1, int num2) {
	      return num1 + num2;
	   }
	}
	public class OperationSubstract implements Strategy{ // ������
	   @Override
	   public int doOperation(int num1, int num2) {
	      return num1 - num2;
	   }
	}
	
	
	public class Context {          // Context��1��ʹ����ĳ�ֲ��Ե���
	   private Strategy strategy;   // ���ݴ����args_strategy��ִ���ض��Ĳ���
	 
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
	      System.out.println("10 + 5 = " + context.executeStrategy(10, 5)); // ���10 + 5 = 15
	 
	      context = new Context(new OperationSubstract());      
	      System.out.println("10 - 5 = " + context.executeStrategy(10, 5)); // ���10 - 5 = 5
	   }
	}
	