package observer;

import java.util.Collection;

public abstract class Subject {
	
	protected Collection<Observer> observers;
	
	public abstract void notifyObservers();
	
	public abstract void registerObserver(Observer o);
	
	public abstract void unregisterObserver(Observer o);
}
