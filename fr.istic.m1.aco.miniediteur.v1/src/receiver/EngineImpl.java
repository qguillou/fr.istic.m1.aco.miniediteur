package receiver;

import command.Command;


/**
 * EngineImpl
 * Execute commands on buffer, clipboard and selection
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class EngineImpl implements EditorEngine {
	private Selection selection;	
	private ClipBoard clipboard;	
	private Buffer buffer;
	
	private Command copy;
	private Command cut;
	private Command erase;
	private Command paste;
	private Command select;
	private Command type;
	
	/**
	 * EngineImpl() - Constructor
	 * @param selection: the Selection object
	 * @param clipboard: the Clipboard of application
	 * @param buffer: the Buffer of application
	 */
	public EngineImpl(Selection selection, ClipBoard clipboard, Buffer buffer){
		this.selection = selection;
		this.clipboard = clipboard;
		this.buffer = buffer;
	}
	
	@Override
	/**
	 * copy()
	 * copy text into clipboard
	 */
	public String copy() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		String text = buffer.copy(start, end);
		clipboard.setText(text);
		
		return getText();
	}

	@Override
	/**
	 * paste()
	 * paste text into buffer
	 */
	public String paste() {
		String text = clipboard.getText();
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		buffer.paste(text, start, end);
		selection.setLength(0);
		selection.setStart(start + text.length());
		
		return getText();
	}

	@Override
	/**
	 * cut()
	 * cut text into buffer and put text into clipboard
	 */
	public String cut() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		String text = buffer.cut(start, end);
		selection.setLength(0);
		clipboard.setText(text);
		
		return getText();
	}

	@Override
	/**
	 * erase()
	 * erase text into buffer
	 */
	public String erase() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		if(start == end)
			start--;
		
		if(start >= 0){
			buffer.erase(start, end);
			selection.setLength(0);
			selection.setStart(start);
		}
		
		return getText();
	}

	@Override
	/**
	 * type()
	 * type text into buffer
	 */
	public String type() {
		String text = type.getText();
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		buffer.type(text, start, end);
		selection.setStart(start + text.length());
		selection.setLength(0);
		
		return getText();
	}
	
	@Override
	/**
	 * setSelection()
	 * set the selection start end length
	 * @param start: the start of new selection
	 * @param length: the length of new selection
	 */
	public String select() throws NumberFormatException {
		return getText();
	}

	@Override
	/**
	 * getText()
	 * get the text of buffer
	 * @return String text: the content of buffer
	 */
	public String getText() {
		return buffer.getText();
	}
	
	/**
	 * 
	 * @param copy
	 * @param cut
	 * @param erase
	 * @param paste
	 * @param select
	 * @param type
	 */
	public void setCommand(Command copy, Command cut, Command erase, Command paste, Command select, Command type) {
		this.copy = copy;
		this.cut = cut;
		this.erase = erase;
		this.paste = paste;
		this.select = select;
		this.type = type;
	}
}
