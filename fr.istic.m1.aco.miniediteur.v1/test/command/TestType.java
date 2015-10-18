package command;

import invoker.IHM;
import invoker.IHMListener;
import invoker.IHMImpl;

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
	IHM ihm;
	
	@Before
	public void initialize() {
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Type(engine, ihm);
		engine.setCommand(null, null, null, null, null, command);
	}
	
	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", buffer.getText().equals(""));
		command.execute();
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", buffer.getText().equals(""));
	}
}
