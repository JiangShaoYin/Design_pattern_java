		public interface ComputerPart { // ������������
		   public void accept(ComputerPartVisitor computerPartVisitor);
		}
		
		public class Keyboard  implements ComputerPart {  // �������࣬����
		   public void accept(ComputerPartVisitor computerPartVisitor) {
		      computerPartVisitor.visit(this);
		   }
		}
		public class Monitor  implements ComputerPart {  // ��ʾ�����࣬this��Monitor����
		   public void accept(ComputerPartVisitor computerPartVisitor) { // ����computerPartVisitor���ֶ������ķ���
		      computerPartVisitor.visit(this);
		   }
		}
		  
		public interface ComputerPartVisitor { // ���Բ��������߻���
		   public void visit(Computer computer);
		   public void visit(Keyboard keyboard);
		   public void visit(Monitor monitor);
		}
		public class ComputerPartDisplayVisitor implements ComputerPartVisitor { // ���Բ���������-����ComputerPartDisplayVisitor
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
		
		public class Computer implements ComputerPart { // ����Keyboard, Monitor��part[]����
		   ComputerPart[] parts;
		   public Computer(){
		      parts = new ComputerPart[] { new Keyboard(), new Monitor()};      
		   } 
		   public void accept(ComputerPartVisitor computerPartVisitor) {// ����computerPartVisitor��part[]�����ڸ�����ķ���Ȩ�ޡ�
		      for (int i = 0; i < parts.length; i++) {
		         	parts[i].accept(computerPartVisitor); // 
		      	}
		       computerPartVisitor.visit(this); // ����Computer����,
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