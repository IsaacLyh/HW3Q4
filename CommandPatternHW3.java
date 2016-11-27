import java.util.ArrayList;

/**
 *
 * @author gkesd_000
 */
public class CommandPatternHW3 {
    
    public interface Command {
        public void execute();
    }
    
    public static class Printer {
        // This is the Receiver
        public void print (String docName) {
            // Prints a document (Don't write this code)
        }
        
        public void reset () {
            // Power cycles (Don't write this code)
        }
        
        public void powerOff() {
            // Turns printer off (Don't write this code)
        }
    }
    
    public static class PrinterControlPanel {
        // This is the Invoker. Write it. 
        // It should have a constructor that accepts, as a parameter, a reference to the associted Printer
        // It should have "setCommand" and "pressButton" methods
        // "setCommand" should set the next Command to execute
        // "pressButton" should execute the command
    	private ArrayList<Command> Commands;
    	private Printer printerInstance;
    	public PrinterControlPanel(Printer input){
    		Commands = new ArrayList<Command>();
    	}
    	public void setCommand(Command input){
    		Commands.add(input);
    	}
    	public void pressButton(){
    		Commands.get(0).execute();
    		Commands.remove(0);
    	}
    }
    
    // You should create PrintCommand, ResetCommand, and PowerOffCommand classes here
    
    public static class PrintCommand implements Command{
    	private Printer PrinterReceiver;
    	private String docName;
    	
    	public PrintCommand(Printer input,String docName){
    		this.PrinterReceiver = input;
    		this.docName = docName;
    	}
    	
		public void execute() {
			System.out.println("Printing "+this.docName);
			PrinterReceiver.print(this.docName);
		}    	
    }
    
    public static class ResetCommand implements Command{
    	private Printer PrinterReceiver;
    	public ResetCommand(Printer input){
    		this.PrinterReceiver = input;
    	}
    	public void execute(){
    		PrinterReceiver.reset();
    		System.out.println("Reseting Printer");
    	}
    }
    
    public static class PowerOffCommand implements Command{
    	private Printer PrinterReceiver;
    	
    	public PowerOffCommand(Printer input){
    		this.PrinterReceiver = input;
    	}
    	
		public void execute(){
			System.out.println("Powering off");
			PrinterReceiver.powerOff();
		}
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This should instantiate a new Printer
        // Then instantiate a new PrinterControlPanel for it
        // Then it should then instantiate new instances of the three Command classes
        // Then it shuld use the PrinterControlPanel and each of the three Command classes
        // to print "Assignment.doc", then to reset the printer, then to power off the pringter.
    	Printer a = new Printer();
    	PrinterControlPanel pannel = new PrinterControlPanel(a);
    	PrintCommand print = new PrintCommand(a,"Assignment.doc");
    	PowerOffCommand poweroff = new PowerOffCommand(a);
    	ResetCommand reset = new ResetCommand(a);
    	pannel.setCommand(print);
    	pannel.setCommand(reset);
    	pannel.setCommand(poweroff);
    	pannel.pressButton();
    	pannel.pressButton();
    	pannel.pressButton();
    }
    
}
