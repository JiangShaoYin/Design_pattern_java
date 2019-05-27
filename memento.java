import java.util.ArrayList;
import java.util.List;

public class Originator { //��Ϊ���壬Ҫ�����״̬������Originator��
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
   public void getStateFromMemento(Memento Memento){ // ���뱸��¼Memento��������¼��״̬���ݸ�Originator
      state = Memento.getState();
   }
}
public class Memento {  // ����¼
   private String state;
   public Memento(String state){
      this.state = state;
   }
   public String getState(){
      return state;
   }  
}
 
public class CareTaker {  //��������memento��list
   private List<Memento> mementoList = new ArrayList<Memento>();
   public void add(Memento state){
      mementoList.add(state);
   } 
   public Memento get(int index){ // ��list����1��memento����
      return mementoList.get(index);
   }
}
public class MementoPatternDemo {
   public static void main(String[] args) {
      Originator originator = new Originator();
      CareTaker careTaker = new CareTaker();
      originator.setState("State #1");
      originator.setState("State #2");
      careTaker.add(originator.saveStateToMemento());//����ǰ״̬#2������memento����memento������careTaker�����mementoList��
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

