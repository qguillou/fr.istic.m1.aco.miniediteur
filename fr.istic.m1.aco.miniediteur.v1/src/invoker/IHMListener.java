package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.*;

import command.Command;

public class IHMListener implements MouseListener, KeyListener, ActionListener {
	
	private Command copy;
	private Command cut;
	private Command erase;
	private Command paste;
	private Command select;
	private Command type;
	
	private String text;
	private IHM ihm;
		
	public IHMListener(){
		text = "";
	}
	
	public void setIHM(IHM ihm){
		this.ihm = ihm;
	}
	
	
	public void caretUpdate(CaretEvent event) {
		
	}
	
	public void setCommand(Command copy, Command cut, Command erase, Command paste, Command select, Command type) {
		this.copy = copy;
		this.cut = cut;
		this.erase = erase;
		this.paste = paste;
		this.select = select;
		this.type = type;
	}

	public String getText() {
		String text_to_type = text;
		text = "";
		return text_to_type;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_C:
				copy.execute();
				break;
			case KeyEvent.VK_V:
				paste.execute();
				break;
			case KeyEvent.VK_X:
				cut.execute();
				break;
            }
        }
		else {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DELETE:
				break;
			case KeyEvent.VK_BACK_SPACE:
				erase.execute();
				break;
			default:
				char lettre = e.getKeyChar();
				if(lettre != KeyEvent.CHAR_UNDEFINED){
					text += lettre;
					type.execute();
				}				
			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cut":
			cut.execute();
			break;
		case "Copy":
			copy.execute();
			break;
		case "Paste":
			paste.execute();
			break;
		case "Erase":
			erase.execute();
			break;
		case "About":
			System.out.println("ok");
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
				    "ACO Project\nDeveloped by Yann JEGU & Quentin GUILLOU\nVersion 1.0 October, 2015",
				    "About Editext",
				    JOptionPane.PLAIN_MESSAGE);
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
		select.execute();
		ihm.getTextArea().getCaret().setVisible(true);
	}
}
