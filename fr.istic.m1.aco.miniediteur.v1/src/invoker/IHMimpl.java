package invoker;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IHMimpl extends JFrame implements IHM {

	private static final long serialVersionUID = 1L;
	
	private JTextArea area;
	private JLabel action;

	public IHMimpl() {
		super();
		area =  new JTextArea();
		action = new JLabel();
	}
	
	public static void main(String[] args) {
		IHM ihm = new IHMimpl();
		ihm.createView();
	}

	@Override
	public void createView() {
		setFrameOptions();
	    
		setMenu();
		
		setContent();
	}
	
	@Override
	public void setFrameOptions() {
		setTitle("Editext");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("image/texte.png");
	    setIconImage(img);
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setMenu() {
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
	}

	@Override
	public void setContent() {
		area.setFont(new Font("Monospaced",Font.PLAIN,12));
		area.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll, BorderLayout.CENTER);
		
		getContentPane().add(action, BorderLayout.SOUTH);
	}

	@Override
	public void getText() {
		area.getText();
	}
	
	@Override
	public void setCommandText(String text) {
		action.setText(text);
	}
}
