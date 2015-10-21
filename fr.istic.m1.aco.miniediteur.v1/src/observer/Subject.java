package observer;

import java.util.Collection;

/**
 * Subject <br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public abstract class Subject {
	
	//Collection of observers (TextArea)
	protected Collection<Observer> observers;
	
	/**
	 * notifyObservers() <br/>
	 * Notify the observers of a content change
	 */
	public abstract void notifyObservers();
	
	/**
	 * registerObserver() <br/>
	 * add a observer in Collection
	 * @param o: new observer
	 */
	public abstract void registerObserver(Observer o);
	
	/**
	 * unregisterObserver() <br/>
	 * delete a observer in Collection
	 * @param o: new Observer
	 */
	public abstract void unregisterObserver(Observer o);
}
