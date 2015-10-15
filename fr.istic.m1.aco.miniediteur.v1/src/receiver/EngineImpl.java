package receiver;

import java.security.InvalidParameterException;

/**
 * 
 * @author Yann Jegu & Quentin Guillou
 */
public class EngineImpl implements EditorEngine {
	private Selection selection;	
	private ClipBoard clipboard;	
	private Buffer buffer;
	
	public EngineImpl(Selection selection, ClipBoard clipboard, Buffer buffer){
		this.selection = selection;
		this.clipboard = clipboard;
		this.buffer = buffer;
	}
	
	/**
	 * checkParametersSelection()
	 * if start bigger than end throw InvalidParameterException
	 * @param start: the start index of selection
	 * @param end: the end index of selection
	 * @throws InvalidParameterException
	 */
	private void checkParametersSelection(int start, int end) throws InvalidParameterException{
		if(start > end)
			throw new InvalidParameterException("Error occur - Start index of selection is bigger than end index");
	}
	
	@Override
	public void copy() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		this.checkParametersSelection(start, end);
		
		String text = buffer.copy(start, end);
		clipboard.setText(text);
	}

	@Override
	public void paste() {
		String text = clipboard.getText();
		int start = selection.getStart();
		int end = start + selection.getLength();
		this.checkParametersSelection(start, end);
		
		buffer.paste(text, start, end);
		selection.setLength(0);
		selection.setStart(start + text.length());
	}

	@Override
	public void cut() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		this.checkParametersSelection(start, end);
		
		String text = buffer.cut(start, end);
		selection.setLength(0);
		clipboard.setText(text);
	}

	@Override
	public void erase() {
		int start = selection.getStart();
		int end = start + selection.getLength();
		this.checkParametersSelection(start, end);
		
		if(start == end)
			start--;
		
		buffer.erase(start, end);
		selection.setLength(0);
		selection.setStart(start);
	}

	@Override
	public void type() {
		//TO DO.....................................................................
		String text = ""; //Récupération de la saisie clavier du texte
		int start = selection.getStart();
		int end = start + selection.getLength();
		this.checkParametersSelection(start, end);
		
		buffer.type(text, start, end);
		selection.setStart(start + text.length());
		selection.setLength(0);
	}	
}
