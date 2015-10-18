package invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class IHMImpl extends JFrame implements IHM {
	
	private TextArea area;
	private JLabel action;
	
	private IHMListener listener;

	public IHMImpl(IHMListener listener) {
		super();
		area =  new TextArea();
		area.create();
		
		this.listener = listener;
		area.addCaretListener(listener);
		area.addKeyListener(listener);
		
		action = new JLabel(" ");
	}

	@Override
	public void createView() {
		setFrameOptions();
	    
		setMenu();
		
		setToolbar();
		
		setContent();
		
		setVisible(true);
		
		area.requestFocus();
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
				
		JMenu menu_file = new JMenu("File");
		JMenuItem item = new JMenuItem("Exit");
		KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("alt F4");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/exit.png"));
		menu_file.add(item);
		menu_file.setBackground(Color.WHITE);
		menu.add(menu_file);
		
		JMenu menu_edit = new JMenu("Edit");
		item = new JMenuItem("Cut");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control X");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/cut.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		item = new JMenuItem("Copy");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control C");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/copy.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		item = new JMenuItem("Paste");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control V");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/paste.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		menu_edit.addSeparator();
		item = new JMenuItem("Erase");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("BACK_SPACE");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/erase.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		menu_edit.setBackground(Color.WHITE);
		menu.add(menu_edit);
		
		JMenu menu_about = new JMenu("About");
		item = new JMenuItem("About");
		item.addActionListener(listener);
		item.setBackground(Color.WHITE);
		menu_about.add(item);
		menu.add(menu_about);
	}
	
	@Override
	public void setToolbar() {
		// Adding tool bar below the menu bar
		JToolBar tool = new JToolBar();
		add(tool,BorderLayout.NORTH);
		
		// Create buttons for the tool bar
		JButton cut = new JButton("Cut");
		JButton copy = new JButton("Copy");
		JButton paste = new JButton("Paste");
		JButton erase = new JButton("Erase");
		
		// Adding buttons to the tool bar
		tool.addSeparator(new Dimension(20, 0));
		tool.add(cut);
		tool.add(copy);
		tool.add(paste);		
		tool.addSeparator(new Dimension(40, 0));
		tool.add(erase);
		
		//Custom toolbar
		tool.setFloatable(false);
		cut.setIcon(new ImageIcon("image/cut48.png"));
		copy.setIcon(new ImageIcon("image/copy48.png"));
		paste.setIcon(new ImageIcon("image/paste48.png"));
		erase.setIcon(new ImageIcon("image/erase48.png"));
		
		cut.setBackground(Color.WHITE);
		copy.setBackground(Color.WHITE);
		paste.setBackground(Color.WHITE);
		erase.setBackground(Color.WHITE);
		
		cut.setVerticalTextPosition(SwingConstants.BOTTOM);
	    cut.setHorizontalTextPosition(SwingConstants.CENTER);
	    copy.setVerticalTextPosition(SwingConstants.BOTTOM);
	    copy.setHorizontalTextPosition(SwingConstants.CENTER);
	    paste.setVerticalTextPosition(SwingConstants.BOTTOM);
	    paste.setHorizontalTextPosition(SwingConstants.CENTER);
	    erase.setVerticalTextPosition(SwingConstants.BOTTOM);
	    erase.setHorizontalTextPosition(SwingConstants.CENTER);
	    
	    cut.addActionListener(listener);
	    copy.addActionListener(listener);
	    paste.addActionListener(listener);
	    erase.addActionListener(listener);
	}

	@Override
	public void setContent() {
		add(area.getScrollArea(), BorderLayout.CENTER);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		action.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder));
		getContentPane().add(action, BorderLayout.SOUTH);
	}

	@Override
	public TextArea getTextArea() {
		return area;
	}
	
	@Override
	public IHMListener getListener() {
		return listener;
	}
	
	@Override
	public void setCommandText(String text) {
		action.setText(text);
	}
}
