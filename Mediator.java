  // �н���ģʽ2
	public abstract class Person { // ������ˣ��ڲ��������Լ���name�����Լ���ϵ���н�
    protected String name;
    protected Mediator mediator;
    
    Person(String name,Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }
}
public class HouseOwner extends Person{ // ������ˣ�����������������֮��ϵ��mediator
    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void contact(String message){
        mediator. contact(message, this);
    }
    
    public void getMessage(String message){
        System.out.println("����:" + name +",�����Ϣ��" + message);
    }
}
public class Tenant extends Person{ // ������ˣ���ͣ�����������֮��ϵ��mediator
    Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void  contact(String message){
        mediator. contact(message, this);
    }

    public void getMessage(String message){
        System.out.println("�ⷿ��:" + name +",�����Ϣ��" + message);
    }
}

public abstract class Mediator { // Mediator����
    public abstract void  contact(String message,Person person);//�����ӿ�
}
	public class MediatorStructure extends Mediator{  // ����MediatorStructure
    private HouseOwner houseOwner;//�����н�ṹ����֪�����з������ⷿ�ߵ���Ϣ
    private Tenant tenant;

    public HouseOwner getHouseOwner() { // �鿴MediatorStructure�����HouseOwner
        return houseOwner;
    }
    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {      // �鿴MediatorStructure�����Tenant
        return tenant;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void  contact(String message, Person person) {
        if(person == houseOwner){          //����Ƿ���������Ϣ�����ⷿ��ȥget���message
            tenant.getMessage(message);//
        }
        else{       //�������Ƿ��������Ϣ
            houseOwner.getMessage(message);
        }
    }
}
	
	public class Client {
    public static void main(String[] args) {  
        MediatorStructure mediator = new MediatorStructure(); //�����н���
              
        HouseOwner houseOwner = new HouseOwner("����", mediator); //�������ⷿ��ֻ��Ҫ֪���н��������
        Tenant tenant = new Tenant("����", mediator);
        
        
        mediator.setHouseOwner(houseOwner); //����������͡����н����ע��
        mediator.setTenant(tenant);
        
        tenant. contact("��˵�����������ҵķ�������.....");
        houseOwner. contact("�ǵ�!��������Ҫ����?");
    }
}
	
	
	
		import java.util.Date;
	 
	public class ChatRoom {  // ������
	   public static void showMessage(User user, String message){
	      System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
	   }
	}
	
	public class User {  // �û�
	   private String name;
	 
	   public User(String name){
	      this.name  = name;
	   }
	 	 public String getName() {
	      return name;
	   }
	   public void sendMessage(String message){ // �û���chatRoom��ͨ�� 
	      ChatRoom.showMessage(this,message);
	   }
	}
	
	
	public class MediatorPatternDemo {
	   public static void main(String[] args) {
	      User robert = new User("Robert");
	      User john = new User("John");
	 
	      robert.sendMessage("Hi! John!");    // [Robert] : Hi! John!
	      john.sendMessage("Hello! Robert!"); // [John] : Hello! Robert!
	   }
	}