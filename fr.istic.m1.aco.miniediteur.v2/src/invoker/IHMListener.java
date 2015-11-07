package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import caretaker.Recorder;
import command.Command;

/**
 * IHMListener <br/>
 * Implements MouseListener, KeyListener, ActionListener
 * The listener of IHM
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class IHMListener implements MouseListener, KeyListener, ActionListener {
		
	private char lastChar;
	
	//Map which contains all command
	private Map<String, Command> commands;
	
	private Recorder recorder;
	
	private IHM ihm;
	
	
	public void setRecorder(Recorder r) {
		recorder = r;
	}
	
	/**
	 * setIHM() <br/>
	 * Set the ihm which is listening
	 * @param ihm: the ihm
	 */
	public void setIHM(IHM ihm){
		this.ihm = ihm;
	}
	
	/**
	 * setCommand() <br/>
	 * Set the commands 
	 * @param commands: a map which contains all commands, the key is the name of command
	 */
	public void setCommand(Map<String, Command> commands) {
		this.commands = commands;
	}
	
	/**
	 * getLastChar() <br/>
	 * get the last char
	 * @return char the last char typed
	 */
	public char getLastChar() {
		return this.lastChar;
	}
	
	/**
	 * KeyPressed() <br/>
	 * Listener on key pressed, call when key is pressed
	 * @param e: the keyEvent
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getModifiers() & KeyEvent.CTRL_MASK) == 0) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DELETE:
				commands.get("delete").execute();
				break;
			case KeyEvent.VK_BACK_SPACE:
				commands.get("erase").execute();
				break;
			
			default:
				if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED){
					lastChar = e.getKeyChar();
					commands.get("type").execute();
				}				
			}
		}	
	}
	
	/**
	 * KeyReleased() <br/>
	 * Listener on key released, call when key is released
	 * @param e: the keyEvent
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_C:
				commands.get("copy").execute();
				break;
			case KeyEvent.VK_V:
				commands.get("paste").execute();
				break;
			case KeyEvent.VK_X:
				commands.get("cut").execute();
				break;
			case KeyEvent.VK_R:
				commands.get("replay").execute();
				break;
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_END:
			case KeyEvent.VK_HOME:
				commands.get("select").execute();
				break;
            }
        }
		else {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_END:
			case KeyEvent.VK_HOME:
				commands.get("select").execute();
				break;
			}
		}
	}
	
	/**
	 * KeyTyped() <br/>
	 * Listener on key typed, call when key is typed
	 * @param e: the keyEvent
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * actionPerformed() <br/>
	 * Listener on click on button or menu item 
	 * @param e: the actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cut":
			commands.get("cut").execute();
			break;
		case "Copy":
			commands.get("copy").execute();
			break;
		case "Paste":
			commands.get("paste").execute();
			break;
		case "Erase":
			commands.get("erase").execute();
			break;
		case "Record":
			((JMenuItem) e.getSource()).setName("Stop record");
			((JMenuItem) e.getSource()).setText("Stop record");
			recorder.setRecording();
			ihm.getTextArea().requestFocus();
			ihm.getTextArea().getCaret().setVisible(true);
			break;
		case "Stop record":
			((JMenuItem) e.getSource()).setName("Record");
			((JMenuItem) e.getSource()).setText("Record");
			recorder.setRecording();
			ihm.getTextArea().requestFocus();
			ihm.getTextArea().getCaret().setVisible(true);
			break;
		case "About":
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				    "ACO Project\nDeveloped by Yann JEGU & Quentin GUILLOU\nVersion 2.0 October, 2015",
				    "About Editext",
				    JOptionPane.PLAIN_MESSAGE);
			break;
		case "Exit":
			ihm.close();
			break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent m) {
	}
	
	@Override
	public void mouseEntered(MouseEvent m) {
	}

	@Override
	public void mouseExited(MouseEvent m) {
	}

	@Override
	public void mousePressed(MouseEvent m) {
	}
	
	/**
	 * mouseReleased() <br/>
	 * Listener on mouse relased, call when mouse is released
	 * @param m: the mouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent m) {
		commands.get("select").execute();
	}
}
