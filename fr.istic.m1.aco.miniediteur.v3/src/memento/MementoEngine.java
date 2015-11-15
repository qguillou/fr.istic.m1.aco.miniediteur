package memento;

import receiver.EditorEngine;

public class MementoEngine {
	
	private EditorEngine engine;
	
	public MementoEngine(EditorEngine e) {
		engine = e;
	}
	
	public EditorEngine getState() {
		return engine;
	}
}
