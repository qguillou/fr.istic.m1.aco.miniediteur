package receiver;

/**
 * Selection
 * Information about selected text and cursor position
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Selection {
	//Index of selection position
	private int start;
	//Length of selection
	private int length;
	
	/**
	 * Selection() - Constructor
	 * Initialize variables
	 */
	public Selection(){
		this.start = 0;
		this.length = 0;
	}
	
	/**
	 * getStart() 
	 * @return start: index of selection position
	 */
	public int getStart() {
		return start;
	}
	
	/**
	 * setStart()
	 * Update the index of selection position
	 * @param start: new index of selection position
	 */
	public void setStart(int start) {
		this.start = start;
	}
	
	/**
	 * getLength()
	 * @return length: the length of selection
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * Update the length of selection
	 * @param length: new length of selection
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
