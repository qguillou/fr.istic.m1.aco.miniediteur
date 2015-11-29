package caretaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import memento.Memento;
import memento.MementoEngine;
import originator.CommandRecordable;

/**
 * RecorderImpl implements Recorder
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class RecorderImpl implements Recorder {
	
	private Map<String, CommandRecordable> commands;
	private Collection<Memento> mementos;
	private boolean recording;
	
	private Stack<MementoEngine> sUndo;
	private Stack<MementoEngine> sRedo;
	
	/**
	 * RecorderImpl() <br/>
	 * Construct the Recorder
	 */
	public RecorderImpl() {
		mementos = new ArrayList<Memento>();
		recording = false;
		
		sUndo = new Stack<MementoEngine>();
		sRedo = new Stack<MementoEngine>();
	}
	
	/**
	 * record()<br/>
	 * Record a command
	 * @param c the command to record
	 */
	@Override
	public void record(CommandRecordable c) {
		Memento m = c.save();
		mementos.add(m);
	}

	/**
	 * replay()<br/>
	 * Replay the command which have been record
	 */
	@Override
	public void replay() {
		Iterator<Memento> it = mementos.iterator();
		Memento m;
		
		while(it.hasNext()) {			
			m = it.next();			
			commands.get(m.getCommand()).replay(m);
		}
	}
	
	/**
	 * setRecording()<br/>
	 * change status of recording
	 */
	@Override
	public void setRecording() {
		recording = !recording;
		if(recording)
			mementos = new ArrayList<Memento>();
	}
	
	/**
	 * getRecording()<br/>
	 * get the recording status
	 * @return boolean: the recording status
	 */
	public boolean getRecording() {
		return recording;
	}
	
	/**
	 * setCommand() <br/>
	 * Set the commands 
	 * @param commands: a map which contains all commands, the key is the name of command
	 */
	@Override
	public void setCommand(Map<String, CommandRecordable> commands) {
		this.commands = commands;
	}
	
	/**
	 * save() <br/>
	 * Save the memento
	 * @param m the memento to save
	 */
	public void save(MementoEngine m) {
		sUndo.push(m);
		sRedo.clear();
	}
	
	/**
	 * undo() <br/>
	 * Undo an action
	 * @return the before state of engine
	 */
	public MementoEngine undo() {
		try {
			sRedo.push(sUndo.pop());
		} catch(EmptyStackException ese){}
		
		if(sUndo.isEmpty())
			return null;
		
		return sUndo.peek();
	}
	
	public MementoEngine redo() {
		if(sRedo.isEmpty())
			return null;
		
		sUndo.push(sRedo.peek());
		return sRedo.pop();
	}
}