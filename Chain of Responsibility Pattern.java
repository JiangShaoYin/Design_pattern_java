public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
  
    protected int level;
    protected AbstractLogger nextLogger;    //责任链中的下一个元素 
    public void setNextLogger(AbstractLogger nextLogger){
       this.nextLogger = nextLogger;
    } 
    public void logMessage(int level, String message){
       if(level >= this.level){  // input的级别高于当前this的级别，则写入log
          write(message);
       }
       else if(nextLogger !=null) { // 否则向下传递，由下一级的类做处理
            nextLogger.logMessage(level, message);
        }
    }
    abstract protected void write(String message);  
 }

 public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
       this.level = level;
    }
    @Override
    protected void write(String message) {    
       System.out.println("ConsoleLogger: " + message);
    }
 }
 public class FileLogger extends AbstractLogger { // debuglog
    public FileLogger(int level){
       this.level = level;
    }
    @Override
    protected void write(String message) {    
       System.out.println("Debuglog: " + message);
    }
 }

 public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){
       AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
       AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
       fileLogger.setNextLogger(consoleLogger);
       return fileLogger;  
    }
    public static void main(String[] args) {
       AbstractLogger loggerChain = getChainOfLoggers();
       //INFO级别的，先到Debug级别，判断等级太低，不输出，交给下一级处理.
       loggerChain.logMessage(AbstractLogger.INFO, "This is an information."); // 输出：ConsoleLogger:This is an information.
       //DEBUG级别的，先到Debug级别，输出，交给下一级处理.
       loggerChain.logMessage(AbstractLogger.DEBUG,"This is a debug information.");//输出：Debuglog: This is a debug information.
    }
 }