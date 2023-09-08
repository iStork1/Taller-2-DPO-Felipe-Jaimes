package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		int IVA=19*(1/100);
		int precioIVA=getPrecioNetoPedido()*IVA;
		return precioIVA;
		
	}
	private String generarTextoFactura() {
		StringBuilder textoFactura =new StringBuilder("Factura numero: "+this.numeroPedidos);
		textoFactura.append("\nNombreCliente: "+this.nombreCliente);
		textoFactura.append("\nDirecciónCliente: "+this.direccionCliente);
		for (Producto items : itemsPedido) {
			textoFactura.append("\n"+items.generarTextoFactura());
		}
		textoFactura.append("\n"+"\n"+"PrecioNeto: "+getPrecioNetoPedido()+"\n"+"Precio con IVA: "+getPrecioIVAPedido()+"\n"+"PrecioTotal: "+getPrecioTotalPedido());
		return textoFactura.toString();
	}
	public void setnumeroPedidos(int numeroPedidos) {
		this.numeroPedidos=numeroPedidos;
	}
	public int getnumeroPedidos() {
		return this.numeroPedidos;
	}
	
	public void guardarFactura(File archivo) throws IOException {
		String textofactura=generarTextoFactura();
		FileWriter fileWriter = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(textofactura);
		bufferedWriter.close();
	}
		
}
