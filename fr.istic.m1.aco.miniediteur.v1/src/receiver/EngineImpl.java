package receiver;


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
	
	/**
	 * EngineImpl() - Constructor
	 * @param selection: the Selection object
	 * @param clipboard: the Clipoard of application
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
		
		String text = buffer.copy(start, end);
		clipboard.setText(text);
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
		
		String text = buffer.cut(start, end);
		selection.setLength(0);
		clipboard.setText(text);
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
		
		buffer.erase(start, end);
		selection.setLength(0);
		selection.setStart(start);
	}

	@Override
	/**
	 * type()
	 * type text into buffer
	 */
	public void type() {
		//TO DO.....................................................................
		String text = ""; //Récupération de la saisie clavier du texte
		int start = selection.getStart();
		int end = start + selection.getLength();
		
		buffer.type(text, start, end);
		selection.setStart(start + text.length());
		selection.setLength(0);
	}	
}
