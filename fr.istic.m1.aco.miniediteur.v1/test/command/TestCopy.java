package command;


import invoker.IHM;
import invoker.IHMListener;
import invoker.IHMImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.*;

public class TestCopy {
	
	Command command;
	EditorEngine engine;
	ClipBoard clipboard;
	Buffer buffer;
	Selection selection;
	IHM ihm;
	
	@Before
	public void initialize(){
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Copy(engine, ihm);
	}

	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", clipboard.getText().equals(""));
		command.execute();
		Assert.assertTrue("Execute() - Copy text but buffer is empty", clipboard.getText().equals(""));
		
		buffer.setText("value");
		selection.setLength(5);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't copy text into clipboard", clipboard.getText().equals("value"));
	}

}
