package command;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestErase {
	
	private Command command;
	private EditorEngine engine;
	private ClipBoard clipboard;
	private Buffer buffer;
	private Selection selection;
	private IHM ihm;
	
	@Before
	public void initialize() {
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		command = new Erase(engine, ihm);
	}
	
	@Test
	public void testExecute() {
		command.execute();
		Assert.assertTrue("Execute() - clipboard content error", clipboard.getText().equals(""));
		Assert.assertTrue("Execute() - buffer content error", buffer.getText().equals(""));
		Assert.assertTrue("Execute() - selection variables error", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		selection.setStart(0);
		selection.setLength(4);
		command.execute();
		Assert.assertTrue("Execute() - clipboard content error", clipboard.getText().equals(""));
		Assert.assertTrue("Execute() - buffer content error", buffer.getText().equals(""));
		Assert.assertTrue("Execute() - selection variables error", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		selection.setStart(4);
		command.execute();
		Assert.assertTrue("Execute() - clipboard content error", clipboard.getText().equals(""));
		Assert.assertTrue("Execute() - buffer content error", buffer.getText().equals("tes"));
		Assert.assertTrue("Execute() - selection variables error", selection.getStart() == 3 && selection.getLength() == 0);
	}

}
