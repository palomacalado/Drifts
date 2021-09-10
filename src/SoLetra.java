import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public final class SoLetra extends JTextField { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maximoLetras=-1;

	SoLetra() {
		super();
		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				jTextFieldKeyTyped(e);}});
		}
	public SoLetra(int maximo) { 
		super(); 
		setMaximoLetras(maximo);
		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) { 
				jTextFieldKeyTyped(e);}});
		}
	private void jTextFieldKeyTyped(KeyEvent e) {
		String caracteres="0987654321 ";
		
		if(caracteres.contains(e.getKeyChar()+"")){ 
			e.consume();
		}
		if((getText().length()>=getMaximoLetras())&&(getMaximoLetras()!=-1)){
			e.consume();
			setText(getText().substring(0,getMaximoLetras()));
		}
				
	}
	
	public int getMaximoLetras() {
		return maximoLetras;
	}
	public void setMaximoLetras(int maximoLetras) {
		this.maximoLetras = maximoLetras;
	}
	


	}

