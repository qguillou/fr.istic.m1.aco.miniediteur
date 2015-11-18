package memento;


public class MementoEngine {
	
	private String stateBuffer;
	private int stateStart;
	private int stateLength;
	
	public MementoEngine(String text, int start, int length) {
		stateBuffer = text;
		stateStart = start;
		stateLength	= length;
	}
	
	public String getStateBuffer() {
		return stateBuffer;
	}
	
	public int getStateStart() {
		return stateStart;
	}
	
	public int getStateLength() {
		return stateLength;
	}
}
