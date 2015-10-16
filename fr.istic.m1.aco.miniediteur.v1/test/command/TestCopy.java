package command;


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
	
	@Before
	public void initialize(){
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Copy(engine);
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
