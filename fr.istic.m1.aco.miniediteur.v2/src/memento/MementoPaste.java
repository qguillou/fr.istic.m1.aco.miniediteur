package memento;

/**
 * MementoCopy<br/>
 * implement Memento<br/><br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class MementoPaste implements Memento {
	
	public static final String COMMAND = "Paste";
	private String text;
	
	
	public MementoPaste(String text) {
		this.text = text;
	}
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}	
}
