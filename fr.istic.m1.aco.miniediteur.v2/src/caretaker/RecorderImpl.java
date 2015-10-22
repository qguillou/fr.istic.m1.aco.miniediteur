package caretaker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import memento.Memento;

import originator.CommandRecordable;

public class RecorderImpl implements Recorder {
	
	private Map<String, Memento> mementos;
	private boolean recording;
	
	public RecorderImpl(){
		mementos = new HashMap<String, Memento>();
	}
	
	@Override
	public void record(CommandRecordable c) {
		if(recording) {
			mementos.put(c.getName(), c.getMemento());
		}
	}

	@Override
	public void replay() {
		Iterator<Memento> it = mementos.iterator();
		
		while(it.hasNext()) {
			
		}
	}

	@Override
	public void startRecording() {
		recording = true;
	}

	@Override
	public void stopRecording() {
		recording = false;
	}

}
