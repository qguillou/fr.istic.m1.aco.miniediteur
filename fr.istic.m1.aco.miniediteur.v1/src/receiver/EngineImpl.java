package receiver;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;

/**
 * EngineImpl
 * Execute commands on buffer, clipboard and selection
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class EngineImpl extends Subject implements EditorEngine  {
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
		
		this.observers = new ArrayList<Observer>();
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
		notifyObservers();
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
		
		notifyObservers();
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
		notifyObservers();
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
		
		notifyObservers();
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
		
		notifyObservers();
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
		
		notifyObservers();
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
	

	@Override
	public int getSelectionStart() {
		return selection.getStart();
	}

	@Override
	public int getSelectionLength() {
		return selection.getLength();
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
	         observer.notifyObserver();
	      }
	}

	@Override
	public void registerObserver(Observer o) {
		o.registerSubject(this);
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}
}
