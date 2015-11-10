package memento;

/**
 * Interface Memento
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public interface Memento {
	
	/**
	 * getText()<br/>
	 * return the text saved
	 * @return String the saved text
	 */
	public String getText();
	
	/**
	 * getCommand()<br/>
	 * return the command saved
	 * @return String the saved command
	 */
	public String getCommand();
}
