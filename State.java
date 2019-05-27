	public interface State {  // 基类，做接口
	   public void doAction(Context context);
	}
	
	public class StartState implements State {
	   public void doAction(Context context) { 
	      System.out.println("Player is in start state");
	      context.setState(this); // 将当前的状态赋给传入环境的state
	   }
	   public String toString(){
	      return "Start State";
	   }
	}
	public class StopState implements State {
	   public void doAction(Context context) {
	      System.out.println("Player is in stop state");
	      context.setState(this); 
	   }
	   public String toString(){
	      return "Stop State";
	   }
	}
	public class Context {  // ontext 是一个带有某个状态的类
	   private State state;
	   public Context(){
	      state = null;
	   }
	   public void setState(State state){
	      this.state = state;     
	   }
	   public State getState(){
	      return state;
	   }
	}
	public class StatePatternDemo { // 演示Context在状态改变时的行为变化
	   public static void main(String[] args) {
	      Context context = new Context();
	 
	      StartState startState = new StartState();
	      	startState.doAction(context);// 输出：Player is in start state 
	      	System.out.println(context.getState().toString());// startState的状态保存在context中，输出：Start State
	 
	      StopState stopState = new StopState();
	      	stopState.doAction(context);
	      	System.out.println(context.getState().toString()); // context的状态变换成stopState，同样的操作，输出变成：Stop State
	   }
	}