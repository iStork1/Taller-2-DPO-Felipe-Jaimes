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
	
	private static File archivoMenu=new File("./data/menu.txt");
	private static File archivoCombos=new File("./data/combos.txt");
	private static ArrayList<Ingrediente> ingredientes=new ArrayList<Ingrediente>();
	public Restaurante() {
		 try {
			 File archivoIngredientes=new File("./data/ingredientes.txt");
			 cargarIngredientes(archivoIngredientes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Pedido pedidoEnCurso;
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
	
		return this.ingredientes;
		
	}
	public void cargarInformacionRestaurante(File archivoIngredientes,File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarCombos(archivoCombos);
		cargarMenu(archivoMenu);
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException{
		try {
			FileReader fr=new FileReader(archivoIngredientes);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] lista=linea.split(";");
				Ingrediente ingrediente=new Ingrediente(lista[0],Integer.parseInt(lista[1]));
				ingredientes.add(ingrediente);
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	private void cargarMenu(File archivoMenu) {
		
	}
	private void cargarCombos(File archivoCombos) {
		try {
			FileReader fr=new FileReader(archivoCombos);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] lista=linea.split(";");
				Combo combo=new Combo(lista[0],Integer.parseInt(lista[1]),);
				ingredientes.add(ingrediente);
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
