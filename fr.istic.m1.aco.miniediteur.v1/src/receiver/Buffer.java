package receiver;


/**
 * Buffer
 * Information of text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Buffer {
	//Text
	private StringBuffer text;
	
	/**
	 * Buffer() - Constructor
	 * Initialize variables
	 */
	public Buffer(){
		this.text = new StringBuffer();
	}
	
	/**
	 * getText()
	 * @return text: the content of buffer
	 */
	public String getText() {
		return text.toString();
	}
	
	/**
	 * setText()
	 * @param text: the new text of buffer
	 */
	public void setText(String text) {
		this.text = this.text.replace(0, this.text.length(), text);
	}
	
	/**
	 * cut()
	 * cut text in buffer
	 * @param start: the start index of cut text
	 * @param end: the end index of cut text
	 * @return String: the text to cut
	 */
	public String cut(int start, int end){
		String select_text = this.text.substring(start, end);
		this.text = this.text.delete(start, end);
		return select_text;
	}
	
	/**
	 * paste()
	 * paste text in buffer
	 * @param text: the text to paste
	 * @param start: the start of selection
	 * @param end: the end of selection
	 */
	public void paste(String text, int start, int end){
		this.text = this.text.delete(start, end);
		this.text = this.text.insert(start, text);
	}
	
	/**
	 * copy()
	 * copy text from buffer
	 * @param start: the start index of copied text
	 * @param end: the end index of copied text
	 * @return String: the text to copy
	 */
	public String copy(int start, int end){
		return this.text.substring(start, end);
	}
	
	/**
	 * erase()
	 * erase text from buffer
	 * @param start: the start index of erased text
	 * @param end: the end index of end text
	 */
	public void erase(int start, int end){
		this.text = this.text.delete(start, end);
	}
	
	/**
	 * type()
	 * type text in buffer
	 * @param text: the text typed
	 * @param start: the start index of selection
	 * @param end: the end index of selection
	 */
	public void type(char c, int start, int end){
		this.text = this.text.delete(start, end);
		this.text = this.text.insert(start, c);
	}
}
