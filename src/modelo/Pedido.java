package modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido=new ArrayList<Producto>();
	
	public Pedido (String nombreCliente ,String direccionCliente) {
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
		
	}
	
	public ArrayList<Producto> getitemsPedido(){
		return this.itemsPedido;
		
	}
	public int getIdPedido() {
		return this.idPedido;
		
	}
	public void agregarProducto(Producto nuevoItem) {
		this.itemsPedido.add(nuevoItem);
	}
	private int getPrecioNetoPedido() {
		int precioNeto=0;
		for (Producto items : itemsPedido) {
			precioNeto+=items.getPrecio();
		}
		return precioNeto;
	}
	private int getPrecioTotalPedido() {
		return getPrecioNetoPedido()+getPrecioIVAPedido();
		
	}
	private int getPrecioIVAPedido() {
		int IVA=19+(1/100);
		int precioIVA=getPrecioNetoPedido()*IVA;
		return precioIVA;
		
	}
	private String generarTextoFactura() {
		StringBuilder textoFactura =new StringBuilder("Factura numero: "+this.numeroPedidos);
		for (Producto items : itemsPedido) {
			textoFactura.append("/n"+items.generarTextoFactura());
		}
		textoFactura.append("/nPrecioNeto: "+getPrecioNetoPedido()+"/nPrecio con IVA: "+getPrecioIVAPedido()+"/nPrecioTotal: "+getPrecioTotalPedido());
		return textoFactura.toString();
	}
	public void setnumeroPedidos(int numeroPedidos) {
		this.numeroPedidos=numeroPedidos;
	}
	
	public void guardarFactura(File archivo) {

	}
		
}
