package proyecto_junit;

import java.util.Scanner;

public class SistemaLealtad extends PizzaOrden{
	private boolean estatusTajeta;
	private int saldoPuntos;
	private boolean estatusCupon;


	public boolean getEstatusTarjeta() {
		return this.estatusTajeta;
	}
	
	public void setEstatusTarjeta(boolean estatusTarjeta) {
		this.estatusTajeta = estatusTarjeta;
	}
	
	public int getSaldoPuntos() {
	
		return saldoPuntos;
	}
	
	public void setSaldoPuntos(int saldoPuntos) {
		this.saldoPuntos = saldoPuntos;
	}
	
	public boolean getEstatusCupon() {
		return estatusCupon;
	}
	
	public void setEstatusCupon(boolean estatusCupon) {
		this.estatusCupon = estatusCupon;
	}
	
	public String mostrarProductosExtras() {
		String respuesta="";
		if (saldoPuntos >=50  && saldoPuntos<100){
			
			respuesta=("Espagueti");
			setEstatusCupon(false);
			
		}
		else if (saldoPuntos >=100  && saldoPuntos<150) {
			
			respuesta=("Espagueti,Queso Extra");
			setEstatusCupon(false);
		}
		else if (saldoPuntos >= 150) {
			respuesta=("Espagueti,Queso Extra,Cupon Pizza Gratis");
			setEstatusCupon(false);
			
		}
		else {
			respuesta= ("");
		}
		return respuesta;
	}
	
	public void usarCupon(String respuesta) {
		if (respuesta.equals("Y")) {
			setEstatusCupon(false);
			String extra= mostrarProductosExtras();
			if (saldoPuntos >=50  && saldoPuntos<100){
				
				saldoPuntos=saldoPuntos-50;
				
			}
			else if (saldoPuntos >=100  && saldoPuntos<150) {
				
				saldoPuntos=saldoPuntos-100;
			}
			else if (saldoPuntos >= 150) {
				saldoPuntos=saldoPuntos-150;
				
			}
			PedirOrden();
			System.out.println("su pedido incluye: "+extra+ ", en su tarjeta tiene: "+saldoPuntos+ " puntos.");
			
				
		}
		else if (respuesta.equals("N")) {
			setEstatusCupon(true);
			String extra= mostrarProductosExtras();
			PedirOrden();
			saldoPuntos=saldoPuntos+1;
			System.out.println("Usted tiene una promocion de: "+extra+ " en su tarjeta y tiene: "+saldoPuntos+ " puntos.");
		} 
		else 
		{
			
		}
	}
	
	public void preguntarTarjeta() {
		System.out.println("¿Cuenta con tarjeta de puntos (Y/N)?");
		Scanner input = new Scanner(System.in);
		String OpcionCuenta=(input.next());
		//System.out.println("OpcionCuenta: "+OpcionCuenta);
		
		
		if (OpcionCuenta.equals("Y")) {
			setEstatusTarjeta(true);
			//System.out.println("OpcionCuenta: "+OpcionCuenta+ " entra a la opcion if");
			guardarPuntos();
			
			//PedirOrden();
			//System.out.println("Extras: "+extra);
			preguntarcupon();			
			
			
		}
		else {
			System.out.println("OpcionCuenta: "+OpcionCuenta+ " entra a la opcion else");
			setEstatusTarjeta(false);
			PedirOrden();
		}
		
	}
	
	public void preguntarcupon() {
		System.out.println("¿Deseas ocupar tu cupon (Y/N)?");
		Scanner res = new Scanner(System.in);
		String respuesta = res.next();
		
		System.out.println(respuesta);
		
		usarCupon(respuesta);
	
}
	
	
	
	public void guardarPuntos() {
		System.out.println("numero de puntos");
		Scanner input = new Scanner(System.in);
		System.out.println("Saldo puntos: ");
		setSaldoPuntos(input.nextInt());
		
		
	}
	
	public void PedirOrden() {
		desplegarMensajeInicio();
		desplegarMensajeDefault();
		preguntarPizzaVegetariana();
		desplegarIngredientes();
		guardarIngredientes();
		desplegarResumenOrden();
	}
}