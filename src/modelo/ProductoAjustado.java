package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	private ProductoMenu Base;
	public ProductoAjustado(ProductoMenu base) {
		this.Base=base;
	}
	public String getNombre() {
		return Base.getNombre();
		
	}
	public int getPrecio() {
		int precioProductoAjustado=0;
		precioProductoAjustado+=Base.getPrecio();
		for (Ingrediente precioAdicional: agregados) {
			precioProductoAjustado+=precioAdicional.getCostoAdicional();
		}
		return precioProductoAjustado;
		
	}
	public ProductoMenu getBase(){
		return this.Base;
	}
	public String generarTextoFactura() {
		StringBuilder factura = new StringBuilder("Productos ajustado: " + getNombre() +" con un precio inicial de "+Base.getPrecio()+"tiene: \n");
	    factura.append("Ingredientes agregados: ");
	    for (Ingrediente ingrediente : agregados) {
	        factura.append(ingrediente.getNombre()+" - "+ingrediente.getCostoAdicional()).append(", ");
	    }
	    factura.delete(factura.length() - 2, factura.length()); // Eliminar la última coma
	    factura.append("\nIngredientes eliminados: ");
	    for (Ingrediente ingrediente : eliminados) {
	        factura.append("sin "+ingrediente.getNombre()).append(", ");
	    }
	    factura.delete(factura.length() - 2, factura.length()); // Eliminar la última coma
	    factura.append("\nPrecio total: ").append(getPrecio());
	    return factura.toString();
		
	}
	public void setagregados(ArrayList<Ingrediente> agregados){
		this.agregados=agregados;
	}
	public void seteliminados(ArrayList<Ingrediente> eliminados){
		this.eliminados=eliminados;
	}
	@Override
	public int getid() {
		return Base.getid();
	}
}
