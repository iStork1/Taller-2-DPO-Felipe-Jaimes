package modelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	private int id;
	public ProductoMenu(int id,String nombre,int precioBase) {
		this.nombre=nombre;
		this.precioBase=precioBase;
		this.id=id;
	}
	public String getNombre() {
		return nombre;
		
	}
	public int getid() {
		return this.id;
	}
	public int getPrecio() {
		return precioBase;
		
	}
	public String generarTextoFactura() {
		return  getNombre() + " - Precio: " + getPrecio();
		
	}
	public ProductoMenu getBase() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
