package modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo=new ArrayList<ProductoMenu>();
	
	public Combo(String nombre, double descuento,ArrayList<ProductoMenu> itemsCombo) {
		this.descuento=descuento;
		this.nombreCombo=nombre;
		this.itemsCombo=itemsCombo;
	}
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	public int getPrecio() {
		return 0;
		
	}
	public String generarTextoFactura() {
		return null;
	}
	public String getNombre() {
		return null;
	}
	
}
