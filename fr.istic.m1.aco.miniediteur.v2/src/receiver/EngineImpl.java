package receiver;

import java.util.ArrayList;

/**
 * EngineImpl
 * Execute commands on buffer, clipboard and selection
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class EngineImpl implements EditorEngine  {
	private Selection selection;	
	private ClipBoard clipboard;	
	private Buffer buffer;
	
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
	public void copy() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		if(start != end){
			String text = buffer.copy(start, end);
			clipboard.setText(text);
		}
	}

	@Override
	/**
	 * paste()
	 * paste text into buffer
	 */
	public void paste() {
		String text = clipboard.getText();
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		buffer.paste(text, start, end);
		selection.setLength(0);
		selection.setStart(start + text.length());
		
	}

	@Override
	/**
	 * cut()
	 * cut text into buffer and put text into clipboard
	 */
	public void cut() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		if(start != end){
			String text = buffer.cut(start, end);
			selection.setLength(0);
			clipboard.setText(text);
		}
	}

	@Override
	/**
	 * erase()
	 * erase text into buffer
	 */
	public void erase() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		if(start == end)
			start--;
		
		if(start >= 0){
			buffer.erase(start, end);
			selection.setLength(0);
			selection.setStart(start);
		}
	}
	
	@Override
	/**
	 * delete()
	 * delete text into buffer
	 */
	public void delete() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		if(start == end)
			end++;
		
		if(end <= getText().length()){
			buffer.erase(start, end);
			selection.setLength(0);
			selection.setStart(start);
		}
	}

	@Override
	/**
	 * type()
	 * type text into buffer
	 * @param c: the last char typed
	 */
	public void type(char c) {
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		buffer.type(c, start, end);
		selection.setStart(start + 1);
		selection.setLength(0);
	}
	
	@Override
	/**
	 * select()
	 * set the selection start end length
	 * @param start: the start of new selection
	 * @param length: the length of new selection
	 */
	public void select(int start, int length) throws NumberFormatException {
		selection.setStart(start);
		selection.setLength(length);
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
	 * getSelectionStart() <br/>
	 * get the selection start
	 * @return int the start of cursor position
	 */
	@Override
	public int getSelectionStart() {
		return selection.getStart();
	}
	
	/**
	 * getSelectionEnd() <br/>
	 * get the selection end
	 * @return int the end of cursor position
	 */
	@Override
	public int getSelectionLength() {
		return selection.getLength();
	}

	@Override
	public ClipBoard getClipboard() {
		return clipboard;
	}

	@Override
	public void setClipboard(String text) {
		// TODO Auto-generated method stub
		
	}
}
