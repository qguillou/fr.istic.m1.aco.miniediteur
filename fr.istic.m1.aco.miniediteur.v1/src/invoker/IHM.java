package invoker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class IHM extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea area;

	public IHM() {
		super();
        
		// Define dimension of text area of the editor
		area = new JTextArea(30, 120);
		
		// Define font size and style
        area.setFont(new Font("Monospaced",Font.PLAIN,12));
        
        // Pane which allows scrolling
		JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll, BorderLayout.CENTER);
		
		// Adding the menu bar to the editor
		JMenuBar JMB = new JMenuBar();
		setJMenuBar(JMB);
		
		// Adding item menu Edit to the editor
		JMenu edit = new JMenu("Edit");
		JMB.add(edit);
		
		// Adding items to the menu Edit
		edit.add("Undo");
		edit.add("Redo");
		edit.addSeparator();
		edit.add("Cut");
		edit.add("Copy");
		edit.add("Paste");
//		edit.getItem(0).setText("Undo");
//		edit.getItem(1).setText("Redo");
//		edit.getItem(3).setText("Cut");
//		edit.getItem(4).setText("Copy");
//		edit.getItem(5).setText("Paste");
		
		// Adding tool bar below the menu bar
		JToolBar tool = new JToolBar();
		add(tool,BorderLayout.NORTH);
		
		// Create buttons for the tool bar
		JButton cut = new JButton("Cut");
		JButton copy = new JButton("Copy");
		JButton paste = new JButton("Paste");
		JButton erase = new JButton("Erase");
		JButton undo = new JButton("Undo");
		JButton redo = new JButton("Redo");
		
		// Adding buttons to the tool bar
		tool.add(cut);
		tool.add(copy);
		tool.add(paste);
		tool.add(erase);
		tool.addSeparator(new Dimension(40, 0));
		tool.add(undo);
		tool.add(redo);
		
		// The editor will be ended by clicking on the cross
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Update new preferred size of the Components 
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IHM();
	}
}
