package invoker;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class IHMimpl extends JFrame implements IHM {

	private static final long serialVersionUID = 1L;
	
	private JTextArea area = new JTextArea(30,120);

	public IHMimpl() {
		super();
        
        area.setFont(new Font("Monospaced",Font.PLAIN,12));
		JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll, BorderLayout.CENTER);
		
		JMenuBar JMB = new JMenuBar();
		setJMenuBar(JMB);

		JToolBar tool = new JToolBar();
		add(tool,BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IHMimpl();
	}

	@Override
	public void createView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getText() {
		// TODO Auto-generated method stub
		
	}
}
