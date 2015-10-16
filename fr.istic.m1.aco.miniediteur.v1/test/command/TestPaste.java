package command;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestPaste {
	
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
		command = new Paste(engine);
	}
	
	@Test
	public void testExecute() {
		Assert.assertTrue("Execute() - Variable aren't initialize at default value", clipboard.getText().equals(""));
		command.execute();
		Assert.assertTrue("Execute() - Paste text but clipboard is empty", buffer.getText().equals(""));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 0);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
		
		//Test paste with buffer empty but clipboard not empty
		buffer.setText("");
		clipboard.setText("value");
		command.execute();
		Assert.assertTrue("Execute() - Doesn't paste text into buffer", buffer.getText().equals("value"));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 5);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
		
		//Test paste with buffer not empty and clipboard not empty and don't selection
		buffer.setText("value");
		clipboard.setText("value");
		selection.setStart(4);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't paste text into buffer", buffer.getText().equals("valuvaluee"));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 9);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
		
		//Test paste with buffer not empty and clipboard not empty and have a selection
		buffer.setText("value");
		clipboard.setText("value");
		selection.setStart(4);
		selection.setLength(1);
		command.execute();
		Assert.assertTrue("Execute() - Doesn't paste text into buffer", buffer.getText().equals("valuvalue"));
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getStart() == 9);
		Assert.assertTrue("Execute() - Doesn't update Selection parameters", selection.getLength() == 0);
	}

}
