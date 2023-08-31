package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	private ProductoMenu Base;
	public ProductoAjustado(ProductoMenu base) {
		
	}
	public String getNombre() {
		return null;
		
	}
	public int getPrecio() {
		return 0;
		
	}
	public String generarTextoFactura() {
		return null;
		
	}
}
