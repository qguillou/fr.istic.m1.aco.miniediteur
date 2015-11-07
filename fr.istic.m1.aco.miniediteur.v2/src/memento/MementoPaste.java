package memento;

/**
 * MementoCopy<br/>
 * implement Memento<br/><br/>
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class MementoPaste implements Memento {
	
	private String text;
	
	
	public MementoPaste(String text) {
		this.text = text;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}	
}
