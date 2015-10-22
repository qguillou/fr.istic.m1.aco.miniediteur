package receiver;

/**
 * ClipBoard
 * The clipboard
 * @author Yann Jegu & Quentin Guillou
 * @version 1
 */
public class ClipBoard {
	//the clipboard contains
	private String text;
	
	/**
	 * ClipBoard() - Constructor
	 * initialize the variables
	 */
	public ClipBoard(){
		this.text = "";
	}
	
	/**
	 * getText()
	 * @return text: the contain of clipboard
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * setText()
	 * update the content of clipboard
	 * @param text: new content of clipboard
	 */
	public void setText(String text) {
		this.text = text;
	}	
}
