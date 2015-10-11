package receiver;

/**
 * @(#) ClipBoard.java
 */

public class ClipBoard {
	private String text;
		
	public ClipBoard(){
		this.text = "";
	}
		
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}	
}
