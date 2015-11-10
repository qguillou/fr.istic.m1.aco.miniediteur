package memento;

/**
 * MementoType<br/>
 * implement Memento<br/><br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class MementoType implements Memento {
	
	public static final String COMMAND = "type";
	private String text;
	
	
	public MementoType(String text) {
		this.text = text;
	}
	
	/**
	 * getText()<br/>
	 * return the text saved
	 * @return String the saved text
	 */
	@Override
	public String getText() {
		return text;
	}
	
	/**
	 * getCommand()<br/>
	 * return the command saved
	 * @return String the saved command
	 */
	@Override
	public String getCommand() {
		return COMMAND;
	}	
}
