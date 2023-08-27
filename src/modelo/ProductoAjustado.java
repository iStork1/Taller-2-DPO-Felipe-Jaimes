package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	public ArrayList<Ingrediente> agregados;
	public ArrayList<Ingrediente> eliminados;
	
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
