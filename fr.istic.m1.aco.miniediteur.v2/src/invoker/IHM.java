package invoker;

/**
 * Interface IHM<br/>
 * The IG of application
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public interface IHM {
	
	/**
	 * createView() <br/>
	 * call methods to add the components of IG
	 * show IG
	 */
	public void createView();
	
	/**
	 * setFrameOptions() <br/>
	 * configure the IG 
	 * 		size of window
	 * 		application icon
	 * 		close operation
	 */
	public void setFrameOptions();
	
	/**
	 * setMenu() <br/>
	 * configure the menu
	 */
	public void setMenu();
	
	/**
	 * setToolbar() <br/>
	 * configure the toolbar
	 */
	public void setToolbar();
	
	/**
	 * setContent() <br/>
	 * configure the content
	 */
	public void setContent();
	
	/**
	 * getTextArea() <br/>
	 * @return TextArea the textarea
	 */
	public TextArea getTextArea();
	
	/**
	 * getListener() <br/>
	 * @return IHMListener the listener of this ihm
	 */
	public IHMListener getListener();
	
	/**
	 * setCommandText() <br/>
	 * set the content of JLabel (on bottom of the window)
	 * @param text the new JLabel content
	 */
	public void setCommandText(String text);
	
	/**
	 * close() <br/>
	 * Method to close the window
	 */
	public void close();
}
