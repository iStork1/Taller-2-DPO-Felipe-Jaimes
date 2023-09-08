package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import modelo.ProductoMenu;


public class Restaurante {
	

	private static ArrayList<Ingrediente> ingredientes=new ArrayList<Ingrediente>();
	private static ArrayList<Combo> combos=new ArrayList<Combo>();
	private static ArrayList<ProductoMenu> menuBase=new ArrayList<ProductoMenu>();
	private ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
	private Pedido pedidoEnCurso;
	private int contadorid=0;
	public Restaurante() {
			 File archivoIngredientes=new File("./data/ingredientes.txt");
			 File archivoMenu=new File("./data/menu.txt");
			 File archivoCombos=new File("./data/combos.txt");
			 cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombos);
			 
		
	}

	public void iniciarPedido(String nombreCliente,String direccionCliente) {
		this.pedidoEnCurso=new Pedido(nombreCliente,direccionCliente);
	}
	public void cerrarYGuardarPedido() {
		System.out.println("Cerrando y guardando pedido.....");
		pedidos.add(pedidoEnCurso);
		String carpeta="./Facturas/";
		String nombreArchivo = carpeta + "pedido"+getPedidoEnCurso().getnumeroPedidos()+".txt";
		File factura=new File(nombreArchivo);
		try {
			pedidoEnCurso.guardarFactura(factura);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Pedido getPedidoEnCurso() {
		return this.pedidoEnCurso;
		
	}
	public ArrayList<Producto> getMenuBase(){
		return null;
		
	}
	public ArrayList<Ingrediente>getIngredientes(){
	
		return this.ingredientes;
		
	}
	public ArrayList<Combo>getCombos(){
		
		return this.combos;
	}
public ArrayList<ProductoMenu>getMenu(){
		
		return this.menuBase;
	}
	public void cargarInformacionRestaurante(File archivoIngredientes,File archivoMenu, File archivoCombos) {
		try {
			cargarIngredientes(archivoIngredientes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cargarMenu(archivoMenu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cargarCombos(archivoCombos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException{

			FileReader fr=new FileReader(archivoIngredientes);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] lista=linea.split(";");
				Ingrediente ingrediente=new Ingrediente(lista[0],Integer.parseInt(lista[1]));
				ingredientes.add(ingrediente);
			}
			br.close();
	}
	
	
	private void cargarMenu(File archivoMenu) throws IOException {
			FileReader fr=new FileReader(archivoMenu);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] lista=linea.split(";");
				ProductoMenu productomenu=new ProductoMenu(contadorid,lista[0],Integer.parseInt(lista[1]));
				menuBase.add(productomenu);
				this.contadorid+=1;
			}
			br.close();
	}
	
	private void cargarCombos(File archivoCombos) throws IOException {
			FileReader fr=new FileReader(archivoCombos);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine())!=null) {
				String[] lista=linea.split(";");
				String porcentaje=lista[1].replace("%","");
				double descuento=Integer.parseInt(porcentaje);
				
				Combo combo=new Combo(contadorid,lista[0],descuento);
				contadorid+=1;
				for (int i =2;i<=4;i++) {
					String producto=lista[i];
					for (ProductoMenu objetoProducto :menuBase) {
						if (objetoProducto.getNombre().equals(producto)){
							combo.agregarItemACombo(objetoProducto);
						}
						
					}
						
				}

				combos.add(combo);
			}
			br.close();
		}
	}

