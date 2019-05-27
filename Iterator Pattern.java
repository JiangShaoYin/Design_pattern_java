	public interface Iterator { // 基类，定义接口
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
	      int index;  // 初始值为 0
	      @Override
	      public boolean hasNext() { // 判断是否为链尾
	         if(index < names.length){
	            return true;
	         }
	         return false;
	      }
	      @Override
	      public Object next() {  // 返回当前的name，指针后移到下一个name
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
	 
	      for(Iterator iter = namesRepository.getIterator();   iter.hasNext()   ;){//iter初始为名字迭代器，如果链尾不空，则往下迭代
	         String name = (String)iter.next();    // 输出：
	         System.out.println("Name : " + name); // Name : Robert
																								 // Name : John
																								 // Name : Julie
                                                 // Name : Lora
	      }  
	   }
	}