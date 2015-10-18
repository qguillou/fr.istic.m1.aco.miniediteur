package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Copy implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Copy
	 * @param engine the engine which will receive the command
	 */
	public Copy(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Copy Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + C");
		String text = engine.copy();
		setText(text);
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
