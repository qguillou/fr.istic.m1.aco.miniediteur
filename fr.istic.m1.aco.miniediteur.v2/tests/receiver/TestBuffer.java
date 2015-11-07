package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBuffer {
	
	private Buffer buffer;
	
	@Before
	public void initialize(){
		buffer = new Buffer();
	}
	
	@Test
	public void testBuffer(){
		Assert.assertNotNull("Buffer() - The String Builder text doesn't initialize", buffer.getText());
		Assert.assertTrue("Buffer() - Content buffer isn't empty after initialized", buffer.getText().equals(""));
	}
	
	@Test
	public void testGetText() {
		Assert.assertTrue("GetText() - Content buffer isn't empty after initialized", buffer.getText().equals(""));
		buffer.setText("test");
		Assert.assertTrue("GetText() - Content doesn't the set text", buffer.getText().equals("test"));
	}

	@Test
	public void testSetText() {
		buffer.setText("test");
		Assert.assertTrue("SetText() - Content doesn't be set", buffer.getText().equals("test"));
	}

	@Test
	public void testCut() {
		buffer.setText("value");
		buffer.cut(0, 0);
		Assert.assertTrue("Cut() - Text has been cut", buffer.getText().equals("value"));
		
		buffer.setText("value1");
		buffer.cut(5, 6);
		Assert.assertTrue("Cut() - Text doesn't be cut", buffer.getText().equals("value"));
	}

	@Test
	public void testPaste() {
		buffer.setText("alue");
		buffer.paste("v", 0, 0);
		Assert.assertTrue("Paste() - Text doesn't be paste", buffer.getText().equals("value"));
	}
	
	@Test
	public void testCopy() {
		buffer.setText("value");
		buffer.copy(0, 4);
		Assert.assertTrue("Copy() - Copy has updated text", buffer.getText().equals("value"));
	}
	
	@Test
	public void testErase() {
		buffer.setText("value1");		
		buffer.erase(5, 5);
		Assert.assertTrue("Erase() - Text has been erased", buffer.getText().equals("value1"));
		
		buffer.erase(5, 6);
		Assert.assertTrue("Erase() - Text doesn't be erased", buffer.getText().equals("value"));
	}

	@Test
	public void testType() {
		buffer.type("c", 0, 0);
		Assert.assertTrue("Type() - Text hasn't been typed", buffer.getText().equals("c"));
		
		buffer.type("a", 0, 1);
		Assert.assertTrue("Type() - Text hasn't been typed", buffer.getText().equals("a"));
		
		buffer.type("p", 0, 0);
		Assert.assertTrue("Type() - Text hasn't been typed", buffer.getText().equals("pa"));
		
		buffer.type("n", 2, 2);
		Assert.assertTrue("Type() - Text hasn't been typed", buffer.getText().equals("pan"));
	}

}
