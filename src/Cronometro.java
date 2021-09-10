import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cronometro {
	
	private String resultado;
	private DateFormat formato = new SimpleDateFormat("HH:mm:ss");
	private Calendar calendario = Calendar.getInstance();
	private final byte contagem;
	
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	public Cronometro(int ano,int mes,int dia,int horas,int minutos,int segundos, byte tipoContagem){
		
		calendario.set(ano,mes,dia,horas,minutos,segundos);
		this.contagem = tipoContagem;
		
	}
		
	public String getTime(){
		calendario.add(Calendar.SECOND, contagem);
		return formato.format(calendario.getTime());
	}
}
