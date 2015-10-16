package invoker;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class IHM extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea area = new JTextArea(30,120);

	public IHM() {
		super();
        
        area.setFont(new Font("Monospaced",Font.PLAIN,12));
		JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll, BorderLayout.CENTER);
		
		JMenuBar JMB = new JMenuBar();
		setJMenuBar(JMB);
//		JMenu file = new JMenu("File");
//		JMenu edit = new JMenu("Edit");
//		JMB.add(file); JMB.add(edit);
		
//		file.add("New");
//		file.add("Open");
//		file.add("Save");
//		file.add("Quit");
//		file.add("Save As");
//		file.addSeparator();
//		
//		for(int i=0; i<4; i++)
//			file.getItem(i).setIcon(null);
//		
//		edit.add("Cut");
//		edit.add("Copy");
//		edit.add("Paste");
//
//		edit.getItem(0).setText("Cut");
//		edit.getItem(1).setText("Copy");
//		edit.getItem(2).setText("Paste");
		
		JToolBar tool = new JToolBar();
		add(tool,BorderLayout.NORTH);
//		tool.add("New");
//		tool.add("Open");
//		tool.add("Save");
//		tool.addSeparator();
//		
//		JButton cut = tool.add("Cut"), cop = tool.add("Copy"), pas = tool.add("Paste");
		
//		cut.setText(null);
//		cut.setIcon(new ImageIcon("cut.gif"));
//		cop.setText(null);
//		cop.setIcon(new ImageIcon("copy.gif"));
//		pas.setText(null);
//		pas.setIcon(new ImageIcon("paste.gif"));
		
//		Save.setEnabled(false);
//		SaveAs.setEnabled(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		IHM ihm = new IHM();
	}
}
