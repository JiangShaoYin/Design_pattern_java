	public interface State {  // ���࣬���ӿ�
	   public void doAction(Context context);
	}
	
	public class StartState implements State {
	   public void doAction(Context context) { 
	      System.out.println("Player is in start state");
	      context.setState(this); // ����ǰ��״̬�������뻷����state
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
	public class Context {  // ontext ��һ������ĳ��״̬����
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
	public class StatePatternDemo { // ��ʾContext��״̬�ı�ʱ����Ϊ�仯
	   public static void main(String[] args) {
	      Context context = new Context();
	 
	      StartState startState = new StartState();
	      	startState.doAction(context);// �����Player is in start state 
	      	System.out.println(context.getState().toString());// startState��״̬������context�У������Start State
	 
	      StopState stopState = new StopState();
	      	stopState.doAction(context);
	      	System.out.println(context.getState().toString()); // context��״̬�任��stopState��ͬ���Ĳ����������ɣ�Stop State
	   }
	}