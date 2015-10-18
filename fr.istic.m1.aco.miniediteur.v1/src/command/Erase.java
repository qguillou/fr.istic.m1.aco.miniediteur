package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Erase implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Erase
	 * @param engine the engine which will receive the command
	 */
	public Erase(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Erase Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("BACK SPACE");
		engine.erase();
	}
	
	@Override
	public String getText() {
		return "";
	}
	
	@Override
	public void setText(String text) {
		ihm.getTextArea().setText(text);
	}
	
	@Override
	public int getSelectionStart(){
		return ihm.getTextArea().getSelectionStart();
	}

	@Override
	public int getSelectionEnd() {
		return ihm.getTextArea().getSelectionEnd();
	}
}
