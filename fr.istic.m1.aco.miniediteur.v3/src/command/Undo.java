package command;

import invoker.IHM;
import memento.MementoEngine;
import receiver.EditorEngine;
import caretaker.Recorder;

/**
 * Undo<br/>
 * implement Command<br/><br/>
 * Command to Undo action
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Undo implements Command {
	
	protected IHM ihm;
	protected EditorEngine engine;
	private Recorder recorder;
	
	/**
	 * Undo() <br/>
	 * Construct the Command Undo
	 * @param engine the engine which will receive the command
	 */
	public Undo(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Undo Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + Z");
		
		MementoEngine m = recorder.undo();
		try {
			engine.getBuffer().setText(m.getStateBuffer());
			engine.getSelection().setStart(m.getStateStart());
			engine.getSelection().setLength(m.getStateLength());
		}
		catch(NullPointerException npe){
			ihm.setCommandText("Ctrl + Z - Nothing to do");
			engine.getBuffer().setText("");
			engine.getSelection().setStart(0);
			engine.getSelection().setLength(0);
		}
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
