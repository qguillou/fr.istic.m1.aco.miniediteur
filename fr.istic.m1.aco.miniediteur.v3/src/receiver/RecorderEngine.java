package receiver;

import java.util.EmptyStackException;
import java.util.Stack;

import memento.MementoEngine;

/**
 * RecorderEngine<br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 3.0
 */
public class RecorderEngine {
	
	private Stack<MementoEngine> sUndo;
	private Stack<MementoEngine> sRedo;
	
	
	public RecorderEngine(){
		sUndo = new Stack<MementoEngine>();
		sRedo = new Stack<MementoEngine>();
	}
	
	public void save(MementoEngine m) {
		sUndo.push(m);
		sRedo.clear();
	}
	
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
