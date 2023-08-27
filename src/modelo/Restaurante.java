package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Restaurante {
	public Restaurante() {
		 menuBase= new HashMap<>();
		 combos=new HashMap<>();
		 ingredientes=new HashMap<>();
		
	}
	public Map<String,Pedido> pedidos;
	public Pedido pedidoEnCurso;
	public Map<String,Combo> combos;
	public Map<String,ProductoMenu> menuBase;
	public Map<String,Ingrediente> ingredientes;
	public void iniciarPedido(String nombreCliente,String direccionCliente) {
		
	}
	public void cerrarYGuardarPedido() {
		
	}
	public Pedido getPedidoEnCurso() {
		return null;
		
	}
	public ArrayList<Producto> getMenuBase(){
		return null;
		
	}
	public ArrayList<Ingrediente>getIngredientes(){
		return null;
		
	}
	public void cargarInformacionRestaurante(File archivoIngredientes,File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarCombos(archivoCombos);
		cargarMenu(archivoMenu);
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException{
		Map<String, Ingrediente> ingredientes = new HashMap<>();
	
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(",");
			String nombre = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			
			Ingrediente elIngrediente = ingredientes.get(nombre);
			if (elIngrediente == null)
			{
				elIngrediente = new Ingrediente(nombre,costoAdicional);
				ingredientes.put(nombre, elIngrediente);
			}
			

		br.close();
		}
	}
	
	private void cargarMenu(File archivoMenu) {
		
	}
	private void cargarCombos(File archivoCombos) {
		
	}
}
