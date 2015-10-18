package invoker;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextArea extends JTextArea{
	
	public TextArea(){
		
	}
	
	public void create(){
		setEditable(false);
		getCaret().setVisible(true);
		setFont(new Font("Monospaced",Font.PLAIN,12));
		setMargin(new Insets(10,10,10,10));
		setLineWrap(true);
	}
	
	public JScrollPane getScrollArea(){
		JScrollPane scroll = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return scroll;
	}
}
