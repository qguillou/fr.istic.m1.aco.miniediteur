package command;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestSelect {
	
	private Command command;
	private EditorEngine engine;
	private ClipBoard clipboard;
	private Buffer buffer;
	private Selection selection;
	private IHM ihm;
	private IHMListener listener;
	
	@Before
	public void initialize() {
		listener = new IHMListener();
		ihm = new IHMImpl(listener);
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Select(engine, ihm);
	}
	
	@Test
	public void testExecute() {
		//Echec du texte car la JTextArea n'est pas créée
		command.execute();
	}

}
