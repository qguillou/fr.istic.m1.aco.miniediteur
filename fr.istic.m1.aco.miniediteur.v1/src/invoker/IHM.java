package invoker;

public interface IHM {
	
	public void createView();
	
	public void setFrameOptions();
	
	public void setMenu();
	
	public void setToolbar();
	
	public void setContent();
	
	public TextArea getTextArea();
	
	public IHMListener getListener();
	
	public void setCommandText(String text);
}
