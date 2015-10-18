package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBuffer {
	
	Buffer buffer;
	
	@Before
	public void initialize() {
		buffer = new Buffer();
	}
	
	@Test
	public void testBuffer() {
		Assert.assertTrue("Buffer() - Parameters aren't initialized", buffer.getText().equals(""));
	}
	
	@Test
	public void testGetText() {
		Assert.assertTrue("GetText() - Text no void at start", buffer.getText().equals(""));
		
		buffer.setText("value");
		Assert.assertTrue("GetText() - Text no set after call to set method", buffer.getText().equals("value"));
	}

	@Test
	public void testSetText() {
		buffer.setText("value");
		Assert.assertTrue("SetText() - Text no set after call to set method", buffer.getText().equals("value"));
	}
	
	@Test
	public void testCut() {
		buffer.setText("value");
		buffer.cut(0, 0);
		Assert.assertTrue("Cut() - Text doesn't be cut", buffer.getText().equals("value"));
		
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
		buffer.erase(5, 6);
		Assert.assertTrue("Erase() - Text doesn't be erased", buffer.getText().equals("value"));
	}
	
}
