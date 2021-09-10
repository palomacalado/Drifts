import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class BolhaVerde {
	
	private Image bolhaVerde;
	private int x ,y;
	Random gerador = new Random();
	private int altura,largura;
	private int quantidade=0;
	private boolean tocada;
	private boolean trocou = false;
	
	
	public boolean isTrocou() {
		return trocou;
	}


	public void setTrocou(boolean trocou) {
		this.trocou = trocou;
	}


	public boolean isTocada() {
		return tocada;
	}


	public void setTocada(boolean tocada) {
		this.tocada = tocada;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getQuantidade() {
		return quantidade;
		
	}
	private boolean isVisivel=true;
	private boolean colidiu = false;
	
	
	private double rx =Math.random()*0.4; 
	private double ry = Math.random()*0.4;
	private double vx =Math.random()*0.4;
	private double vy =Math.random()*0.4;
	
	
	
	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public BolhaVerde(int x,int y){
		
		this.x=x;
		this.y=y;
	
		ImageIcon refBolaVerde = new ImageIcon(getClass().getResource("Imagens/verde.png"));
		bolhaVerde  = refBolaVerde.getImage();
		
		largura = bolhaVerde.getWidth(null);
		altura = bolhaVerde.getHeight(null);
		isVisivel = true;
		
	}
	
		
	public void mexer(int x,int y ){
		
		if(colidiu){
			return;	
		}
		if(!colidiu&&tocada){
			return;
		}
		else{
			this.x=x;
			 this.y=y;
			 
			 this.y=(this.y+(int) ry)%600;
			 this.x=(this.x+(int) rx)%1000;
			 
			//atualiza o valor de rx e ry
			 rx= rx +vx ;
			 ry= ry + vy;
			
		}
		
		
	}	
	
	
	public boolean isColidiu() {
		return colidiu;
	}


	public void setColidiu(boolean colidiu) {
		this.colidiu = colidiu;
	}


	public int getLargura() {
		return largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	public boolean isVisivel() {
		return isVisivel;
	}
	public Image getBolaVerde() {
		return bolhaVerde;
	}	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
}
