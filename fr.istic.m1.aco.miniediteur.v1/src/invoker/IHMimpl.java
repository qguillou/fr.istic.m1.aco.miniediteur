package invoker;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;


@SuppressWarnings("serial")
public class IHMimpl extends JFrame implements IHM {
	
	private TextArea area;
	private JLabel action;
	
	private IHMListener listener;

	public IHMimpl() {
		super();
		area =  new TextArea();
		area.create();
		
		action = new JLabel();
	}

	@Override
	public void createView() {
		setFrameOptions();
	    
		setMenu();
		
		setContent();
		
		setVisible(true);
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
	}

	@Override
	public void setMenu() {
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
	}

	@Override
	public void setContent() {
		add(area.getScrollArea(), BorderLayout.CENTER);
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

	@Override
	public IHMListener createListener() {
		listener = new IHMListener();
		return listener;
	}
}
