package receiver;

/**
 * @(#) Buffer.java
 */

public class Buffer {
	private StringBuffer text;
		
	public Buffer(){
		this.text = new StringBuffer();
	}
			
	public String getText() {
		return text.toString();
	}
	
	public void setText(String text) {
		this.text = this.text.replace(0, this.text.length(), text);
	}
	
	public String cut(int start, int end){
		String select_text = this.text.substring(start, end);
		this.text = this.text.delete(start, end);
		return select_text;
	}
	
	public void paste(String text, int start, int end){
		this.text = this.text.delete(start, end);
		this.text = this.text.insert(start, text);
	}
	
	public String copy(int start, int end){
		return this.text.substring(start, end);
	}
	
	public void erase(int start, int end){
		this.text = this.text.delete(start, end);
	}
	
	public void type(String text, int start, int end){
		this.text = this.text.delete(start, end);
		this.text = this.text.insert(start, text);
	}
}
