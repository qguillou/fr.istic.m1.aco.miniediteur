package caretaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import memento.Memento;

import originator.CommandRecordable;

public class RecorderImpl implements Recorder {
	
	private Collection<Pair> mementos;
	private Map<String, CommandRecordable> commands;
	private boolean recording;
	
	public RecorderImpl(Map<String, CommandRecordable> commands){
		mementos = new ArrayList<Pair>();
		this.commands = commands;
	}
	
	@Override
	public void record(CommandRecordable c) {
		if(recording) {
			mementos.add(new Pair(c.getName(), c.getMemento()));
		}
	}

	@Override
	public void replay() {
		Iterator<Pair> it = mementos.iterator();
		Pair value;
		
		while(it.hasNext()) {
			value = it.next();
			commands.get(value.name).setMemento(value.memento);
			commands.get(value.name).execute();
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
	
	
	private class Pair {
		
		private String name;
		private Memento memento;
		
		public Pair(String name, Memento memento){
			this.name = name;
			this.memento = memento;
		}
	}
}
