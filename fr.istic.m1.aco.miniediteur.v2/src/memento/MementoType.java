package memento;

public class MementoType implements Memento{
	
	private String state;
	
	@Override
	public void setMemento(String state) {
		this.state = state;
	}

	@Override
	public String getMemento() {
		return state;
	}
}
