package modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo=new ArrayList<ProductoMenu>();
	
	public Combo(String nombre, double descuento) {
		this.descuento=descuento;
		this.nombreCombo=nombre;
	}
	public void agregarItemACombo(ProductoMenu itemCombo) {
		this.itemsCombo.add(itemCombo);
	}
	public ArrayList<ProductoMenu> getitemsCombo(){
		return this.itemsCombo;
	}
	public int getPrecio() {
		double preciototal=0;
		double Porcentajedescuento=descuento*(1/100);
		for (ProductoMenu productos:itemsCombo) {
			preciototal+=productos.getPrecio();
		}
		double aDescontar=preciototal*Porcentajedescuento;
		double precioConDescuento=preciototal-aDescontar;
		return (int) precioConDescuento;
		
	}
	public String generarTextoFactura() {
		return null;
	}
	public String getNombre() {
		return nombreCombo;
	}
	
}
