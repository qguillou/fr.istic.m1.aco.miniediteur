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

public class TestCut {
	
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
		command = new Cut(engine, ihm);
	}
	
	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", clipboard.getText().equals(""));
		command.execute();
		Assert.assertTrue("Execute() - Cut text but buffer is empty", clipboard.getText().equals(""));
		
		buffer.setText("value");
		selection.setLength(5);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't put text into clipboard", clipboard.getText().equals("value"));
		Assert.assertTrue("Execute() - Doesn't cut text into buffer", buffer.getText().equals(""));
	}

}
