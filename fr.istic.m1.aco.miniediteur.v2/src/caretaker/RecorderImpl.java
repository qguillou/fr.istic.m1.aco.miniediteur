package caretaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import memento.Memento;
import originator.CommandRecordable;

public class RecorderImpl implements Recorder {
	
	private Map<String, CommandRecordable> commands;
	private Collection<Memento> mementos;
	private boolean recording;
	
	public RecorderImpl() {
		mementos = new ArrayList<Memento>();
		recording = false;
	}
	
	@Override
	public void record(CommandRecordable c) {
		Memento m = c.save();
		mementos.add(m);
	}

	@Override
	public void replay() {
		Iterator<Memento> it = mementos.iterator();
		Memento m;
		
		while(it.hasNext()) {			
			m = it.next();			
			commands.get(m.getCommand()).restore(m);
			commands.get(m.getCommand()).execute();
		}
	}

	@Override
	public void setRecording() {
		recording = !recording;
		if(recording)
			mementos = new ArrayList<Memento>();
	}
	
	public boolean getRecording() {
		return recording;
	}

	@Override
	public void setCommand(Map<String, CommandRecordable> commands) {
		this.commands = commands;
	}
}