package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JOptionPane;

import command.Command;

public class IHMListener implements MouseListener, KeyListener, ActionListener {
		
	private char lastChar;
	
	//Map which contains all command
	private Map<String, Command> commands;
	
	private IHM ihm;
	
	public void setIHM(IHM ihm){
		this.ihm = ihm;
	}
	
	public void setCommand(Map<String, Command> commands) {
		this.commands = commands;
	}

	public char getLastChar() {
		return this.lastChar;
	}

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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

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
		case "About":
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				    "ACO Project\nDeveloped by Yann JEGU & Quentin GUILLOU\nVersion 1.0 October, 2015",
				    "About Editext",
				    JOptionPane.PLAIN_MESSAGE);
			break;
		case "Exit":
			ihm.close();
			break;
		case "Help":
			ihm.getTextArea().help();
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		commands.get("select").execute();
	}
}
