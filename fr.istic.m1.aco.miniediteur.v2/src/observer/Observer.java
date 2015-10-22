package observer;

import receiver.EditorEngine;

/**
 * Interface Observer<br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public interface Observer {
	
	/**
	 * notifyObserver() <br/>
	 * methode call by the subject when we need to update text area content
	 */
	public void notifyObserver();
	
	/**
	 * registerSubject() <br/>
	 * set the subject
	 * @param engineImpl the engine
	 */
	public void registerSubject(EditorEngine engineImpl);
}
