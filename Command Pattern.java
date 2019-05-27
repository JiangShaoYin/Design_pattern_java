	import java.util.ArrayList;
	import java.util.List;
	public interface Order {  // ���࣬����execute(),����������ʵ��
	   void execute();
	}
	public class Stock {
	   private String name = "ABC";
	   private int quantity = 10;
	   
	   public void buy(){
	      System.out.println(name, Quantity+ "bought");
	   }
	   public void sell(){
	      System.out.println(name, Quantity + "sold");
	   }
	}
	public class BuyStock implements Order {
	   private Stock abcStock;
	   public BuyStock(Stock args_Stock){
	      this.abcStock = args_Stock;
	   }
	   public void execute() {
	      abcStock.buy();
	   }
	}
	
	public class SellStock implements Order {
	   private Stock abcStock;
	   public SellStock(Stock args_Stock){
	      this.abcStock = args_Stock;
	   } 
	   public void execute() {
	      abcStock.sell();
	   }
	}
	
	public class Broker {
	   private List<Order> orderList = new ArrayList<Order>(); //�ڲ�ά����list������ָ�����ඩ����ָ��
	   
	   public void takeOrder(Order order){
	      orderList.add(order);      
	   }
	   public void placeOrders(){
	      for (Order order : orderList) {//��list������������ó���ִ��
	         order.execute();
	      }
	      orderList.clear();
	   }
	}
	public class CommandPatternDemo {
	   public static void main(String[] args) {
	      Stock abcStock = new Stock();
	      	BuyStock buyStockOrder = new BuyStock(abcStock);
	      	SellStock sellStockOrder = new SellStock(abcStock);
	      Broker broker = new Broker();
	      	broker.takeOrder(buyStockOrder);
	      	broker.takeOrder(sellStockOrder);
	      broker.placeOrders();   // �����ABC, 10 bought
																//       ABC, 10 sold
	   }
	}