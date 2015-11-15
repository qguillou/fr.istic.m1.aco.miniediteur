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
/**
 * IHM <br/>
 * The IG of application
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class IHMImpl extends JFrame implements IHM {
	//the text area
	private TextArea area;
	private JLabel action;
	
	//the listener of this IHM
	private IHMListener listener;
	
	/**
	 * IHMImpl() <br/>
	 * Constructor of IHM
	 * Initialize attributs
	 * @param listener
	 */
	public IHMImpl(IHMListener listener) {
		super();
		area =  new TextArea();
		area.create();
		
		this.listener = listener;		
		area.addMouseListener(listener);
		area.addKeyListener(listener);
		listener.setIHM(this);
		
		action = new JLabel(" ");
	}
	
	/**
	 * createView() <br/>
	 * call methods to add the components of IG
	 * show IG
	 */
	@Override
	public void createView() {
		setFrameOptions();
	    
		setMenu();
		
		setToolbar();
		
		setContent();
		
		setVisible(true);
		
		area.requestFocus();
	}
	
	/**
	 * setFrameOptions() <br/>
	 * configure the IG 
	 * 		size of window
	 * 		application icon
	 * 		close operation
	 */
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
	
	/**
	 * setMenu() <br/>
	 * configure the menu
	 */
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
		item.addActionListener(listener);
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
		menu_edit.addSeparator();
		item = new JMenuItem("Record");
		//ctrlXKeyStroke = KeyStroke.getKeyStroke("");
	    //item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/record.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		item = new JMenuItem("Replay");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control R");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/play.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		menu_edit.addSeparator();
		item = new JMenuItem("Undo");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control Z");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/undo.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		item = new JMenuItem("Redo");
		ctrlXKeyStroke = KeyStroke.getKeyStroke("control Y");
	    item.setAccelerator(ctrlXKeyStroke);
		item.setBackground(Color.WHITE);
		item.setIcon(new ImageIcon("image/redo.png"));
		item.addActionListener(listener);
		menu_edit.add(item);
		menu_edit.setBackground(Color.WHITE);
		menu.add(menu_edit);
		
		JMenu menu_about = new JMenu("About");
		item = new JMenuItem("About");
		item.addActionListener(listener);
		item.setBackground(Color.WHITE);
		menu_about.add(item);
		item = new JMenuItem("Help");
		item.addActionListener(listener);
		item.setBackground(Color.WHITE);
		menu_about.add(item);
		menu.add(menu_about);
	}
	
	/**
	 * setToolbar() <br/>
	 * configure the toolbar
	 */
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
		JButton record = new JButton("Record");
		JButton replay = new JButton("Replay");
		JButton undo = new JButton("Undo");
		JButton redo = new JButton("Redo");
		
		// Adding buttons to the tool bar
		tool.addSeparator(new Dimension(20, 0));
		tool.add(cut);
		tool.add(copy);
		tool.add(paste);		
		tool.addSeparator(new Dimension(40, 0));
		tool.add(erase);
		tool.addSeparator(new Dimension(40, 0));
		tool.add(record);
		tool.add(replay);
		tool.addSeparator(new Dimension(40, 0));
		tool.add(undo);
		tool.add(redo);
		
		//Custom toolbar
		tool.setFloatable(false);
		cut.setIcon(new ImageIcon("image/cut48.png"));
		copy.setIcon(new ImageIcon("image/copy48.png"));
		paste.setIcon(new ImageIcon("image/paste48.png"));
		erase.setIcon(new ImageIcon("image/erase48.png"));
		record.setIcon(new ImageIcon("image/record48.png"));
		replay.setIcon(new ImageIcon("image/play48.png"));
		undo.setIcon(new ImageIcon("image/undo48.png"));
		redo.setIcon(new ImageIcon("image/redo48.png"));
		
		cut.setBackground(Color.WHITE);
		copy.setBackground(Color.WHITE);
		paste.setBackground(Color.WHITE);
		erase.setBackground(Color.WHITE);
		record.setBackground(Color.WHITE);
		replay.setBackground(Color.WHITE);
		undo.setBackground(Color.WHITE);
		redo.setBackground(Color.WHITE);
		
		cut.setVerticalTextPosition(SwingConstants.BOTTOM);
	    cut.setHorizontalTextPosition(SwingConstants.CENTER);
	    copy.setVerticalTextPosition(SwingConstants.BOTTOM);
	    copy.setHorizontalTextPosition(SwingConstants.CENTER);
	    paste.setVerticalTextPosition(SwingConstants.BOTTOM);
	    paste.setHorizontalTextPosition(SwingConstants.CENTER);
	    erase.setVerticalTextPosition(SwingConstants.BOTTOM);
	    erase.setHorizontalTextPosition(SwingConstants.CENTER);
	    record.setVerticalTextPosition(SwingConstants.BOTTOM);
	    record.setHorizontalTextPosition(SwingConstants.CENTER);
	    replay.setVerticalTextPosition(SwingConstants.BOTTOM);
	    replay.setHorizontalTextPosition(SwingConstants.CENTER);
	    undo.setVerticalTextPosition(SwingConstants.BOTTOM);
	    undo.setHorizontalTextPosition(SwingConstants.CENTER);
	    redo.setVerticalTextPosition(SwingConstants.BOTTOM);
	    redo.setHorizontalTextPosition(SwingConstants.CENTER);
	    
	    cut.addActionListener(listener);
	    copy.addActionListener(listener);
	    paste.addActionListener(listener);
	    erase.addActionListener(listener);
	    record.addActionListener(listener);
	    replay.addActionListener(listener);
	    undo.addActionListener(listener);
	    redo.addActionListener(listener);
	}
	
	/**
	 * setContent() <br/>
	 * configure the content
	 */
	@Override
	public void setContent() {
		add(area.getScrollArea(), BorderLayout.CENTER);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		action.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder));
		getContentPane().add(action, BorderLayout.SOUTH);
	}
	
	/**
	 * getTextArea() <br/>
	 * @return TextArea the textarea
	 */
	@Override
	public TextArea getTextArea() {
		return area;
	}
	
	/**
	 * getListener() <br/>
	 * @return IHMListener the listener of this ihm
	 */
	@Override
	public IHMListener getListener() {
		return listener;
	}
	
	/**
	 * setCommandText() <br/>
	 * set the content of JLabel (on bottom of the window)
	 * @param text the new JLabel content
	 */
	@Override
	public void setCommandText(String text) {
		action.setText(text);
	}
	
	/**
	 * close() <br/>
	 * Method to close the window
	 */
	@Override
	public void close() {
		dispose();
	}
}
