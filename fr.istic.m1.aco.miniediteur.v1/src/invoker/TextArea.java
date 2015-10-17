package invoker;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextArea extends JTextArea{
	
	public TextArea(){
		
	}
	
	public void create(){
		setFont(new Font("Monospaced",Font.PLAIN,12));
		setLineWrap(true);
	}
	
	public JScrollPane getScrollArea(){
		JScrollPane scroll = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return scroll;
	}
}
