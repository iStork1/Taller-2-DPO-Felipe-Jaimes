package modelo;

public interface Producto {
	public ProductoMenu getBase();
	public int getPrecio();
	public String getNombre();
	public String generarTextoFactura();
	public int getid();
}
