import java.util.ArrayList;
import java.util.List;

public class Originator { //行为主体，要保存的状态存在于Originator中
   private String state;
   public void setState(String state){
      this.state = state;
   } 
   public String getState(){
      return state;
   }
   public Memento saveStateToMemento(){
      return new Memento(state);
   }
   public void getStateFromMemento(Memento Memento){ // 传入备忘录Memento，将备忘录的状态传递给Originator
      state = Memento.getState();
   }
}
public class Memento {  // 备忘录
   private String state;
   public Memento(String state){
      this.state = state;
   }
   public String getState(){
      return state;
   }  
}
 
public class CareTaker {  //用来保存memento的list
   private List<Memento> mementoList = new ArrayList<Memento>();
   public void add(Memento state){
      mementoList.add(state);
   } 
   public Memento get(int index){ // 从list中拿1个memento出来
      return mementoList.get(index);
   }
}
public class MementoPatternDemo {
   public static void main(String[] args) {
      Originator originator = new Originator();
      CareTaker careTaker = new CareTaker();
      originator.setState("State #1");
      originator.setState("State #2");
      careTaker.add(originator.saveStateToMemento());//将当前状态#2保存至memento，将memento保存在careTaker对象的mementoList中
      originator.setState("State #3");
      careTaker.add(originator.saveStateToMemento());
      originator.setState("State #4");
 
      System.out.println("Current State: " + originator.getState());    // Current State: State #4
      originator.getStateFromMemento(careTaker.get(0));
      System.out.println("First saved State: " + originator.getState()); // First saved State: State #2
      originator.getStateFromMemento(careTaker.get(1));
      System.out.println("Second saved State: " + originator.getState()); // Second saved State: State #3
   }
}

