package invoker;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import invoker.IHMImpl;
import invoker.IHMListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;
import command.Command;
import command.Copy;
import command.Cut;
import command.Erase;
import command.Paste;
import command.Select;
import command.Type;

public class TestIHM {
	
	static IHMListener listener;
	static Selection selection;
	static ClipBoard clipboard;
	static Buffer buffer;
	static IHMImpl ihm;
	static EditorEngine engine;
	
	@BeforeClass
	public static void initialize() {
		listener = new IHMListener();
		selection = new Selection();
		clipboard = new ClipBoard();
		buffer = new Buffer();
		
		engine = new EngineImpl(selection, clipboard, buffer);
		ihm = new IHMImpl(listener);
		ihm.createView();
		Command copy = new Copy(engine, ihm);
		Command cut = new Cut(engine, ihm);
		Command paste = new Paste(engine, ihm);
		Command erase = new Erase(engine, ihm);
		Command type = new Type(engine, ihm);
		Command select = new Select(engine, ihm);
		
		listener.setCommand(copy, cut, erase, paste, select, type);
		engine.setCommand(copy, cut, erase, paste, select, type);
	}
	
	@Before
	public void init(){
		buffer.setText("");
		selection.setLength(0);
		selection.setStart(0);
		clipboard.setText("");
		ihm.getTextArea().requestFocus();
	}
	
	@Test
	public void testType() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(100);
		Assert.assertTrue("Type() - Text typed doesn't put in buffer", engine.getText().equals("a"));
		robot.keyPress(KeyEvent.VK_B);
		Thread.sleep(100);
		Assert.assertTrue("Type() - Text typed doesn't put in buffer", engine.getText().equals("ab"));
	}
	
	@Test
	public void testSelect(){
		
	}
	
	@Test
	public void testCutKeyboard() throws InterruptedException, AWTException {
		Assert.assertTrue("Cut() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Cut() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Cut() - Selection.start not equals 0", selection.getStart() == 0);
		buffer.setText("ab");
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Cut() - Text cut but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Cut() - No text cut but text selected or the text cut doesn't the select text", clipboard.getText().equals("b"));
		Assert.assertTrue("Cut() - Select text put into clipboard but doesn't cut into buffer", buffer.getText().equals("a"));
		Assert.assertTrue("Cut() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
	
	@Test
	public void testCopyKeyboard() throws InterruptedException, AWTException{
		Assert.assertTrue("Copy() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Copy() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Copy() - Selection.start not equals 0", selection.getStart() == 0);
		buffer.setText("ab");
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Copy() - Text copy but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Copy() - No text copied but text selected or the text copied doesn't the select text", clipboard.getText().equals("b"));
		Assert.assertTrue("Copy() - Select text put into clipboard but doesn't copied into buffer", buffer.getText().equals("ab"));
		Assert.assertTrue("Copy() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 1);
	}
	
	@Test
	public void testPasteKeyboard() throws InterruptedException, AWTException{
		Assert.assertTrue("Paste() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Paste() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Paste() - Selection.start not equals 0", selection.getStart() == 0);
		buffer.setText("ab");
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("ab"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		clipboard.setText("d");
		selection.setStart(2);
		selection.setLength(0);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abd"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
		
		clipboard.setText("c");
		selection.setStart(2);
		selection.setLength(1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abc"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
	}
	
	@Test
	public void testEraseKeyboard() throws InterruptedException, AWTException{
		Assert.assertTrue("Erase() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Erase() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Erase() - Selection.start not equals 0", selection.getStart() == 0);
		
		buffer.setText("ab");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("ab"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(2);
		selection.setLength(0);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text don't erase", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	
		buffer.setText("abc");
		selection.setStart(1);
		selection.setLength(2);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
	
	@Test
	public void testCopyButton() throws AWTException, InterruptedException {
		Assert.assertTrue("Copy() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Copy() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Copy() - Selection.start not equals 0", selection.getStart() == 0);
		Robot robot = new Robot();
		buffer.setText("abc");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+125, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Copy() - Text copy but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(2);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+125, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Copy() - No text copied but text selected or the text copied doesn't the select text", clipboard.getText().equals("bc"));
		Assert.assertTrue("Copy() - Select text put into clipboard but doesn't copied into buffer", buffer.getText().equals("abc"));
		Assert.assertTrue("Copy() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 2);
	}
	
	@Test
	public void testCutButton() throws AWTException, InterruptedException {
		Assert.assertTrue("Cut() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Cut() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Cut() - Selection.start not equals 0", selection.getStart() == 0);
		Robot robot = new Robot();
		buffer.setText("ab");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Cut() - Text cut but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(1);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Cut() - No text cut but text selected or the text cut doesn't the select text", clipboard.getText().equals("b"));
		Assert.assertTrue("Cut() - Select text put into clipboard but doesn't cut into buffer", buffer.getText().equals("a"));
		Assert.assertTrue("Cut() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
	
	@Test
	public void testPasteButton() throws InterruptedException, AWTException {
		Assert.assertTrue("Paste() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Paste() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Paste() - Selection.start not equals 0", selection.getStart() == 0);
		buffer.setText("ab");
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.mouseMove(ihm.getX()+170, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("ab"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		clipboard.setText("d");
		selection.setStart(2);
		selection.setLength(0);
		robot.mouseMove(ihm.getX()+170, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abd"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
		
		clipboard.setText("c");
		selection.setStart(2);
		selection.setLength(1);
		robot.mouseMove(ihm.getX()+170, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abc"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
	}
	
	@Test
	public void testEraseButton() throws InterruptedException, AWTException {
		Assert.assertTrue("Erase() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Erase() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Erase() - Selection.start not equals 0", selection.getStart() == 0);
		
		buffer.setText("ab");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.mouseMove(ihm.getX()+260, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("ab"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(2);
		selection.setLength(0);
		Thread.sleep(100);
		robot.mouseMove(ihm.getX()+260, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text don't erase", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	
		buffer.setText("abc");
		selection.setStart(1);
		selection.setLength(2);
		Thread.sleep(100);
		robot.mouseMove(ihm.getX()+260, ihm.getY()+80);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
	
	@Test
	public void testCopyMenu() throws AWTException, InterruptedException {
		Assert.assertTrue("Copy() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Copy() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Copy() - Selection.start not equals 0", selection.getStart() == 0);
		Robot robot = new Robot();
		buffer.setText("abc");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+90);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Copy() - Text copy but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(2);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+90);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Copy() - No text copied but text selected or the text copied doesn't the select text", clipboard.getText().equals("bc"));
		Assert.assertTrue("Copy() - Select text put into clipboard but doesn't copied into buffer", buffer.getText().equals("abc"));
		Assert.assertTrue("Copy() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 2);
	}
	
	@Test
	public void testCutMenu() throws AWTException, InterruptedException {
		Assert.assertTrue("Cut() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Cut() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Cut() - Selection.start not equals 0", selection.getStart() == 0);
		Robot robot = new Robot();
		buffer.setText("ab");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+70);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Cut() - Text cut but no text selected", clipboard.getText().equals(""));
		
		selection.setStart(1);
		selection.setLength(1);
		Thread.sleep(100);		
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+70);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Cut() - No text cut but text selected or the text cut doesn't the select text", clipboard.getText().equals("b"));
		Assert.assertTrue("Cut() - Select text put into clipboard but doesn't cut into buffer", buffer.getText().equals("a"));
		Assert.assertTrue("Cut() - Parameters of selection doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
	
	@Test
	public void testPasteMenu() throws AWTException, InterruptedException {
		Assert.assertTrue("Paste() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Paste() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Paste() - Selection.start not equals 0", selection.getStart() == 0);
		buffer.setText("ab");
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+115);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("ab"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		clipboard.setText("d");
		selection.setStart(2);
		selection.setLength(0);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+115);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abd"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
		
		clipboard.setText("c");
		selection.setStart(2);
		selection.setLength(1);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+115);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Paste() - Text paste but no text in clipboard", buffer.getText().equals("abc"));
		Assert.assertTrue("Paste() - Selection parameters doesn't updated", selection.getStart() == 3 && selection.getLength() == 0);
	}
	
	@Test
	public void testEraseMenu() throws AWTException, InterruptedException{
		Assert.assertTrue("Erase() - Clipbord doesn't empty", clipboard.getText().equals(""));
		Assert.assertTrue("Erase() - Selection.length not equals 0", selection.getLength() == 0);
		Assert.assertTrue("Erase() - Selection.start not equals 0", selection.getStart() == 0);
		
		buffer.setText("ab");
		selection.setStart(0);
		selection.setLength(0);
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+150);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("ab"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 0 && selection.getLength() == 0);
		
		selection.setStart(2);
		selection.setLength(0);
		Thread.sleep(100);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+150);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text don't erase", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	
		buffer.setText("abc");
		selection.setStart(1);
		selection.setLength(2);
		Thread.sleep(100);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+34);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(ihm.getX()+60, ihm.getY()+150);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(100);
		Assert.assertTrue("Erase() - Text erase but no text to erase before curosr position", buffer.getText().equals("a"));
		Assert.assertTrue("Erase() - Selection parameters doesn't updated", selection.getStart() == 1 && selection.getLength() == 0);
	}
}
