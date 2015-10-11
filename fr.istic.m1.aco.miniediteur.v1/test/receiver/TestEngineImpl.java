package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEngineImpl {
	
	EditorEngine engine;
	Selection selection;
	ClipBoard clipboard;
	Buffer buffer;
	
	@Before
	public void initialize(){
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
	}
	
	@Test
	public void testCopy() {
		buffer.setText("value1");
		selection.setStart(0);
		selection.setLength(5);
		engine.copy();
		Assert.assertTrue("Copy() - Copy has updated Selection variables", selection.getLength() == 5 && selection.getStart() == 0);
		Assert.assertTrue("Copy() - Text doesn't been copied in ClipBoard", clipboard.getText().equals("value"));
	}

	@Test
	public void testPaste() {
		// Test without selected text
		buffer.setText("value");
		selection.setStart(5);
		selection.setLength(0);
		clipboard.setText("1");
		engine.paste();
		Assert.assertTrue("Copy() - Copy has updated Selection variables", selection.getLength() == 0 && selection.getStart() == 6);
		Assert.assertTrue("Copy() - Text doesn't been copied in ClipBoard", buffer.getText().equals("value1"));
		
		//Test with selected text
		buffer.setText("value");
		selection.setStart(0);
		selection.setLength(4);
		clipboard.setText("text");
		engine.paste();
		Assert.assertTrue("Copy() with selected text - Copy hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 4);
		Assert.assertTrue("Copy() with selected text - Text doesn't been copied in Buffer", buffer.getText().equals("texte"));
	}

	@Test
	public void testCut() {
		buffer.setText("value");
		selection.setStart(0);
		selection.setLength(4);
		engine.cut();
		Assert.assertTrue("Cut() - Cut hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 0);
		Assert.assertTrue("Cut() - Text doesn't been cut in Buffer", buffer.getText().equals("e"));
		Assert.assertTrue("Cut() - Text doesn't been put in ClipBoard", clipboard.getText().equals("valu"));
	}

	@Test
	public void testErase() {
		// Test without selected text
		buffer.setText("value");
		selection.setStart(5);
		selection.setLength(0);
		engine.erase();
		Assert.assertTrue("Erase() - Erase hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 4);
		Assert.assertTrue("Erase() - Text doesn't been updated in Buffer", buffer.getText().equals("valu"));
		
		//Test with selected text
		buffer.setText("value");
		selection.setStart(0);
		selection.setLength(4);
		engine.erase();
		Assert.assertTrue("Erase() with selected text - Erase hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 0);
		Assert.assertTrue("Erase() with selected text - Text doesn't been updated in Buffer", buffer.getText().equals("e"));
	}

	@Test
	public void testType() {
		// Test without selected text
		buffer.setText("value");
		selection.setStart(5);
		selection.setLength(0);
		engine.type();
		Assert.assertTrue("Type() - Type hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 6);
		Assert.assertTrue("Type() - Text doesn't been updated in Buffer", buffer.getText().equals("value"));
		
		//Test with selected text
		buffer.setText("value");
		selection.setStart(1);
		selection.setLength(4);
		engine.type();
		Assert.assertTrue("Type() with selected text - Type hasn't updated Selection variables", selection.getLength() == 0 && selection.getStart() == 2);
		Assert.assertTrue("Type() with selected text - Text doesn't been updated in Buffer", buffer.getText().equals("v"));
	}

}
