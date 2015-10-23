package memento;

public class MementoType implements Memento {
	
	private String text;
	private String commandType = "type";
	
	
	public MementoType(String text) {
		this.text = text;
	}

	@Override
	public String getMemento() {
		return text;
	}

	public String getCommandType() {
		return commandType;
	}
}
