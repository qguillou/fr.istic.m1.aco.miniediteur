package command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestErase {
	
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
		command = new Erase(engine);
	}
	
	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", clipboard.getText().equals(""));
		command.execute();
		Assert.assertTrue("Execute() - Erase text but buffer is empty", clipboard.getText().equals(""));
		
		//Test erase with buffer not empty but cursor at index 0
		buffer.setText("value");
		command.execute();
		Assert.assertTrue("Execute() - Doesn't erase text into buffer", buffer.getText().equals("value"));
		
		//Test erase with buffer not empty but cursor at index 3
		buffer.setText("value");
		selection.setStart(3);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't erase text into buffer", buffer.getText().equals("vaue"));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 2);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
		
		//Test erase with buffer not empty but cursor at index 3
		buffer.setText("value");
		selection.setStart(3);
		selection.setLength(2);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't erase text into buffer", buffer.getText().equals("val"));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 3);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
	}

}
