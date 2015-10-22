package receiver;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEngineImpl {
	
	private EditorEngine engine;
	private Selection selection;
	private ClipBoard clipboard;
	private Buffer buffer;
	
	@Before
	public void initialize(){
		clipboard = new ClipBoard();
		selection = new Selection();
		buffer = new Buffer();
		
		engine = new EngineImpl(selection, clipboard, buffer);
	}
	
	@Test
	public void testNotifyObservers() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnregisterObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testEngineImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopy() {
		engine.copy();
		Assert.assertTrue("Copy() - Buffer isn't empty", buffer.getText().equals(""));
		Assert.assertTrue("Copy() - Clipboard isn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Copy() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		engine.copy();
		Assert.assertTrue("Copy() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Copy() - Clipboard isn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Copy() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(4);
		engine.copy();
		Assert.assertTrue("Copy() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Copy() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Copy() - Selection isn't (0, 4)", selection.getStart() == 0 && selection.getLength() == 4);
		
		selection.setLength(0);
		engine.copy();
		Assert.assertTrue("Copy() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Copy() - Clipboard is changed but copy when no text selected", clipboard.getText().equals("test"));
		Assert.assertTrue("Copy() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
	}

	@Test
	public void testPaste() {
		engine.paste();
		Assert.assertTrue("Paste() - Buffer isn't empty", buffer.getText().equals(""));
		Assert.assertTrue("Paste() - Clipboard isn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Paste() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		clipboard.setText("test");
		engine.paste();
		Assert.assertTrue("Paste() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Paste() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Paste() - Selection isn't (4, 0)", selection.getStart() == 4 && selection.getLength() == 0);
		
		selection.setStart(1);
		engine.paste();
		Assert.assertTrue("Paste() - Buffer content isn't the set text", buffer.getText().equals("ttestest"));
		Assert.assertTrue("Paste() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Paste() - Selection isn't (5, 0)", selection.getStart() == 5 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(8);
		engine.paste();
		Assert.assertTrue("Paste() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Paste() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Paste() - Selection isn't (4, 0)", selection.getStart() == 4 && selection.getLength() == 0);
	}

	@Test
	public void testCut() {
		engine.cut();
		Assert.assertTrue("Cut() - Buffer isn't empty", buffer.getText().equals(""));
		Assert.assertTrue("Cut() - Clipboard isn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Cut() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		engine.cut();
		Assert.assertTrue("Cut() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Cut() - Clipboard is empty", clipboard.getText().equals(""));
		Assert.assertTrue("Cut() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(4);
		engine.cut();
		Assert.assertTrue("Cut() - Buffer content isn't the set text", buffer.getText().equals(""));
		Assert.assertTrue("Cut() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Cut() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		engine.cut();
		Assert.assertTrue("Cut() - Buffer content isn't the set text", buffer.getText().equals(""));
		Assert.assertTrue("Cut() - Clipboard is empty", clipboard.getText().equals("test"));
		Assert.assertTrue("Cut() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
	}

	@Test
	public void testErase() {
		engine.erase();
		Assert.assertTrue("Erase() - Buffer isn't empty", buffer.getText().equals(""));
		Assert.assertTrue("Erase() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		engine.erase();
		Assert.assertTrue("Erase() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Erase() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(4);
		engine.erase();
		Assert.assertTrue("Erase() - Buffer content isn't the set text", buffer.getText().equals("tes"));
		Assert.assertTrue("Erase() - Selection isn't (3, 0)", selection.getStart() == 3 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(3);
		engine.erase();
		Assert.assertTrue("Erase() - Buffer content isn't the set text", buffer.getText().equals(""));
		Assert.assertTrue("Erase() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
	}
	
	@Test
	public void testDelete() {
		engine.delete();
		Assert.assertTrue("Delete() - Buffer isn't empty", buffer.getText().equals(""));
		Assert.assertTrue("Delete() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		engine.delete();
		Assert.assertTrue("Delete() - Buffer content isn't the set text", buffer.getText().equals("est"));
		Assert.assertTrue("Delete() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		buffer.setText("test");
		selection.setStart(4);
		engine.delete();
		Assert.assertTrue("Delete() - Buffer content isn't the set text", buffer.getText().equals("test"));
		Assert.assertTrue("Delete() - Selection isn't (4, 0)", selection.getStart() == 4 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(3);
		engine.delete();
		Assert.assertTrue("Delete() - Buffer content isn't the set text", buffer.getText().equals("t"));
		Assert.assertTrue("Delete() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		engine.delete();
		Assert.assertTrue("Delete() - Buffer content isn't the set text", buffer.getText().equals(""));
		Assert.assertTrue("Delete() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
	}

	@Test
	public void testType() {
		engine.type('c');
		Assert.assertTrue("Type() - Buffer isn't empty", buffer.getText().equals("c"));
		Assert.assertTrue("Type() - Selection isn't (0, 0)", selection.getStart() == 1 && selection.getLength() == 0);
		
		selection.setStart(0);
		selection.setLength(1);
		engine.type('a');
		Assert.assertTrue("Type() - Buffer content isn't the set text", buffer.getText().equals("a"));
		Assert.assertTrue("Type() - Selection isn't (0, 0)", selection.getStart() == 1 && selection.getLength() == 0);
	}

	@Test
	public void testSelect() {
		engine.select(0, 0);
		Assert.assertTrue("Type() - Selection isn't (0, 0)", selection.getStart() == 0 && selection.getLength() == 0);
		
		engine.select(1, 1);
		Assert.assertTrue("Type() - Selection isn't (1, 1)", selection.getStart() == 1 && selection.getLength() == 1);
	}

	@Test
	public void testGetText() {
		Assert.assertTrue("GetText() - Return text doesn't the buffer content", engine.getText().equals("")); 
		
		buffer.setText("test");
		Assert.assertTrue("GetText() - Return text doesn't the buffer content", engine.getText().equals("test")); 
	}

	@Test
	public void testGetSelectionStart() {
		Assert.assertTrue("GetSelectionStart() - Return start doesn't the selection start", engine.getSelectionStart() == 0);
		
		selection.setStart(1);
		Assert.assertTrue("GetSelectionStart() - Return start doesn't the selection start", engine.getSelectionStart() == 1);
	}

	@Test
	public void testGetSelectionLength() {
		Assert.assertTrue("GetSelectionLength() - Return start doesn't the selection start", engine.getSelectionLength() == 0);
		
		selection.setLength(1);
		Assert.assertTrue("GetSelectionLength() - Return start doesn't the selection start", engine.getSelectionLength() == 1);
	}
}
