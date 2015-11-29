package memento;

public class MementoEngine {
	
	//Content of buffer
	private String stateBuffer;
	
	//Position of Selection (start and length)
	private int stateStart;
	private int stateLength;
	
	/**
	 * Constructor MementoEngine
	 * @param text the content of buffer
	 * @param start the start selection
	 * @param length the length selection
	 */
	public MementoEngine(String text, int start, int length) {
		stateBuffer = text;
		stateStart = start;
		stateLength	= length;
	}
	
	/**
	 * getStateBuffer()
	 * get the buffer content for this memento
	 * @return string the content buffer
	 */
	public String getStateBuffer() {
		return stateBuffer;
	}
	
	/**
	 * getStateStart()
	 * get the start selection for this memento
	 * @return int the start selection
	 */
	public int getStateStart() {
		return stateStart;
	}
	
	/**
	 * getStateLength()
	 * get the length selection for this memento
	 * @return int the length selection
	 */
	public int getStateLength() {
		return stateLength;
	}
}
