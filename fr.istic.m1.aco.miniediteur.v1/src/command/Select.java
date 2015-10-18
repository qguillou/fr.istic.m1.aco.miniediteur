package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Select implements Command {
	
	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Select
	 * @param engine the engine which will receive the command
	 */
	public Select(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Select Command
	 */
	@Override
	public void execute() {
		engine.select();
	}
	
	@Override
	public String getText() {
		return null;
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
	
	public void setSelection(int start, int end){
		ihm.getTextArea().setSelectionStart(start);
		ihm.getTextArea().setSelectionEnd(end);
		ihm.getTextArea().getCaret().setVisible(true);
	}
}
