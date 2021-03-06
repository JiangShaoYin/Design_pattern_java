	  // 中介者模式2
		public abstract class Person { // 抽象的人，内部保存有自己的name，和自己联系的中介
	    protected String name;
	    protected Mediator mediator;
	    
	    Person(String name,Mediator mediator){
	        this.name = name;
	        this.mediator = mediator;
	    }
	}
	public class HouseOwner extends Person{ // 具体的人（房东），保存有与之联系的mediator
	    HouseOwner(String name, Mediator mediator) {
	        super(name, mediator);
	    }
	    public void contact(String message){
	        mediator. contact(message, this);
	    }
	    
	    public void getMessage(String message){
	        System.out.println("房主:" + name +",获得信息：" + message);
	    }
	}
	public class Tenant extends Person{ // 具体的人（租客），保存有与之联系的mediator
	    Tenant(String name, Mediator mediator) {
	        super(name, mediator);
	    }
	    public void  contact(String message){
	        mediator. contact(message, this);
	    }
	
	    public void getMessage(String message){
	        System.out.println("租房者:" + name +",获得信息：" + message);
	    }·
	}
	
	public abstract class Mediator { // Mediator基类
	    public abstract void  contact(String message,Person person);//声明接口
	}
	
		public class MediatorStructure extends Mediator{  // 子类MediatorStructure
	    private HouseOwner houseOwner;//首先中介结构必须知道所有房主和租房者的信息
	    private Tenant tenant;
	
	    public HouseOwner getHouseOwner() { // 查看MediatorStructure里面的HouseOwner
	        return houseOwner;
	    }
	    public void setHouseOwner(HouseOwner houseOwner) {
	        this.houseOwner = houseOwner;
	    }
	
	    public Tenant getTenant() {      // 查看MediatorStructure里面的Tenant
	        return tenant;
	    }
	    public void setTenant(Tenant tenant) {
	        this.tenant = tenant;
	    }
	
	    public void  contact(String message, Person person) {
	        if(person == houseOwner){          //如果是房东发的消息，则租房者去get这个message
	            tenant.getMessage(message);//
	        }
	        else{       //反之则是房主获得信息
	            houseOwner.getMessage(message);
	        }
	    }
	}
		
		public class Client {
	    public static void main(String[] args) {  
	        MediatorStructure mediator = new MediatorStructure(); //声明中介者
	              
	        HouseOwner houseOwner = new HouseOwner("张三", mediator); //房主和租房者只需要知道中介机构即可
	        Tenant tenant = new Tenant("李四", mediator);
	        
	        
	        mediator.setHouseOwner(houseOwner); //将房东、租客、向中介机构注册
	        mediator.setTenant(tenant);
	        
	        tenant. contact("听说你那里有三室的房主出租.....");
	        houseOwner. contact("是的!请问你需要租吗?");
	    }
	}
		
		
		