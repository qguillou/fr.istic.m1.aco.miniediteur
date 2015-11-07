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
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}	
}
