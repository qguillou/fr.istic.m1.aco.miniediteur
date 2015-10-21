package invoker;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import observer.Observer;
import receiver.EditorEngine;

@SuppressWarnings("serial")
/**
 * TextArea <br/>
 * implements Observer
 * extends JTextArea
 * The text area
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class TextArea extends JTextArea implements Observer {
	
	protected EditorEngine subject;
	
	/**
	 * create() <br/>
	 * create the textarea, and configure it
	 */
	public void create(){
		setEditable(false);
		getCaret().setVisible(true);
		setFont(new Font("Monospaced",Font.PLAIN,12));
		setMargin(new Insets(10,10,10,10));
		setLineWrap(true);
	}
	
	/**
	 * getScrollArea()
	 * get the scroll area of this (when we have so much text a scrollbar appear
	 * @return JScrollPane
	 */
	public JScrollPane getScrollArea(){
		JScrollPane scroll = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return scroll;
	}
	
	/**
	 * update() <br/>
	 * Update the text and cursor position of the text area
	 * @param text: the new text
	 * @param start: the new start position of cursor
	 * @param end: the new end position of cursor
	 */
	public void update(String text, int start, int end){
		setText(text);
		setSelectionStart(start);
		setSelectionEnd(end);
		getCaret().setVisible(true);
		requestFocusInWindow();
	}

	/**
	 * notifyObserver() <br/>
	 * methode call by the subject when we need to update text area content
	 */
	@Override
	public void notifyObserver() {
		update(subject.getText(), subject.getSelectionStart(), subject.getSelectionLength() + subject.getSelectionStart());
	}
	
	/**
	 * registerSubject() <br/>
	 * set the subject
	 * @param engineImpl the engine
	 */
	@Override
	public void registerSubject(EditorEngine engineImpl) {
		subject = engineImpl;
	}
}
