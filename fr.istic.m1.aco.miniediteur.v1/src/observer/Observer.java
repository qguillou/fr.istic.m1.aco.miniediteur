package observer;

import receiver.EditorEngine;

public interface Observer {
	
	public void notifyObserver();

	public void registerSubject(EditorEngine engineImpl);
}
