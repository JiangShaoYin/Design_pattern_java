	public interface Iterator { // ���࣬����ӿ�
	   public boolean hasNext();
	   public Object next();
	}
	public interface Container {
	   public Iterator getIterator();
	}
	
	public class NameRepository implements Container {
	   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};
	   @Override
	   public Iterator getIterator() {
	      return new NameIterator();
	   }
	 
	   private class NameIterator implements Iterator {
	      int index;  // ��ʼֵΪ 0
	      @Override
	      public boolean hasNext() { // �ж��Ƿ�Ϊ��β
	         if(index < names.length){
	            return true;
	         }
	         return false;
	      }
	      @Override
	      public Object next() {  // ���ص�ǰ��name��ָ����Ƶ���һ��name
	         if(this.hasNext()){
	            return names[index++];
	         }
	         return null;
	      }     
	   }
	}
	public class IteratorPatternDemo {
	   public static void main(String[] args) {
	      NameRepository namesRepository = new NameRepository();
	 
	      for(Iterator iter = namesRepository.getIterator();   iter.hasNext()   ;){//iter��ʼΪ���ֵ������������β���գ������µ���
	         String name = (String)iter.next();    // �����
	         System.out.println("Name : " + name); // Name : Robert
																								 // Name : John
																								 // Name : Julie
                                                 // Name : Lora
	      }  
	   }
	}