package command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestType {
	
	Command command;
	EditorEngine engine;
	ClipBoard clipboard;
	Buffer buffer;
	Selection selection;
	
	@Before
	public void initialize() {
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Type(engine);
	}
	
	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", buffer.getText().equals(""));
		//TO DO
		//After IHM implementation
	}
}
