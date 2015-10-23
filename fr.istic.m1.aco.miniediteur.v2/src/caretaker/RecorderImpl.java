package caretaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import memento.Memento;

import originator.CommandRecordable;

public class RecorderImpl implements Recorder {
	
	private Collection<Memento> mementos;
	private Map<String, CommandRecordable> commands;
	private boolean recording;
	
	public RecorderImpl(Map<String, CommandRecordable> commands){
		mementos = new ArrayList<Memento>();
		this.commands = commands;
	}
	
	@Override
	public void record(CommandRecordable c) {
		if(recording) {
			mementos.add(new Memento(c.getName(), c.getMemento()));
		}
	}

	@Override
	public void replay() {
		Iterator<Pair> it = mementos.iterator();
		Pair value;
		
		while(it.hasNext()) {
			value = it.next();
			commands.get(value.name).setMemento(value.memento);
			commands.get(value.name).replay();
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