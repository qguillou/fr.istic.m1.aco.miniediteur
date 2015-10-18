package command;

public interface Command {
	public void execute();

	public String getText();
	
	public void setText(String text);
	
	public int getSelectionStart();
	
	public int getSelectionEnd();
}
