package memento;

/**
 * MementoErase<br/>
 * implement Memento<br/><br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class MementoErase implements Memento {
	
	public static final String COMMAND = "erase";
	private String text;
	
	
	public MementoErase(String text) {
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
