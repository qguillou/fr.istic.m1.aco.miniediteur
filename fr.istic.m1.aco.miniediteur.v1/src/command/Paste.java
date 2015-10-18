package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Paste implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Paste
	 * @param engine the engine which will receive the command
	 */
	public Paste(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Paste Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + V");
		engine.paste();
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
