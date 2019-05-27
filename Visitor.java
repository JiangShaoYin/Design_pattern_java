		public interface ComputerPart { // 计算机组件基类
		   public void accept(ComputerPartVisitor computerPartVisitor);
		}
		
		public class Keyboard  implements ComputerPart {  // 键盘子类，客体
		   public void accept(ComputerPartVisitor computerPartVisitor) {
		      computerPartVisitor.visit(this);
		   }
		}
		public class Monitor  implements ComputerPart {  // 显示器子类，this是Monitor对象，
		   public void accept(ComputerPartVisitor computerPartVisitor) { // 接收computerPartVisitor这种对象对其的访问
		      computerPartVisitor.visit(this);
		   }
		}
		  
		public interface ComputerPartVisitor { // 电脑部件访问者基类
		   public void visit(Computer computer);
		   public void visit(Keyboard keyboard);
		   public void visit(Monitor monitor);
		}
		public class ComputerPartDisplayVisitor implements ComputerPartVisitor { // 电脑部件访问者-子类ComputerPartDisplayVisitor
		   public void visit(Computer computer) {
		      System.out.println("Displaying Computer.");
		   }
		   public void visit(Keyboard keyboard) {
		      System.out.println("Displaying Keyboard.");
		   }
		   public void visit(Monitor monitor) {
		      System.out.println("Displaying Monitor.");
		   }
		}
		
		public class Computer implements ComputerPart { // 保存Keyboard, Monitor到part[]数组
		   ComputerPart[] parts;
		   public Computer(){
		      parts = new ComputerPart[] { new Keyboard(), new Monitor()};      
		   } 
		   public void accept(ComputerPartVisitor computerPartVisitor) {// 增加computerPartVisitor对part[]数组内各组件的访问权限。
		      for (int i = 0; i < parts.length; i++) {
		         	parts[i].accept(computerPartVisitor); // 
		      	}
		       computerPartVisitor.visit(this); // 访问Computer对象,
		   }
		
		public class VisitorPatternDemo {
		   public static void main(String[] args) {
		      ComputerPart computer = new Computer();
		      computer.accept(new ComputerPartDisplayVisitor());
		   }
		}
		
		// Displaying Keyboard.
		// Displaying Monitor.
		// Displaying Computer.