package modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private int id;
	private ArrayList<ProductoMenu> itemsCombo=new ArrayList<ProductoMenu>();
	
	public Combo(int id,String nombre, double descuento) {
		this.descuento=descuento;
		this.nombreCombo=nombre;
		this.id=id;
	}
	public void agregarItemACombo(ProductoMenu itemCombo) {
		this.itemsCombo.add(itemCombo);
	}
	public ArrayList<ProductoMenu> getitemsCombo(){
		return this.itemsCombo;
	}
	public int getid() {
		return this.id;
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
		StringBuilder factura = new StringBuilder("El "+this.nombreCombo+" tiene los siguientes productos: ");
		for (ProductoMenu items : itemsCombo) {
			factura.append('\n'+items.getNombre()+" $"+items.getPrecio());
		}
		factura.append("\nCon un descuento total de: "+this.descuento+"%");
		factura.append("\nPrecio total combo: "+getPrecio());
		return factura.toString();
	}
	public String getNombre() {
		return nombreCombo;
	}
	public ProductoMenu getBase() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
