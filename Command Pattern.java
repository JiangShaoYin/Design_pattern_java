	import java.util.ArrayList;
	import java.util.List;
	public interface Order {  // 基类，定义execute(),具体由子类实现
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
	   private List<Order> orderList = new ArrayList<Order>(); //内部维持有list，保存指向子类订单的指针
	   
	   public void takeOrder(Order order){
	      orderList.add(order);      
	   }
	   public void placeOrders(){
	      for (Order order : orderList) {//将list里面各个订单拿出来执行
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
	      broker.placeOrders();   // 输出：ABC, 10 bought
																//       ABC, 10 sold
	   }
	}