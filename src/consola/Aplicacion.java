package consola;


import modelo.Restaurante;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.Producto;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;

public class Aplicacion {
	static Restaurante restaurante;

	
	public static void mostrarMenu() {
		ArrayList<ProductoMenu>productos= restaurante.getMenu();
		ArrayList<Combo>combos= restaurante.getCombos();
		System.out.println("\nEstos Son Los Productos Basicos:\n");
		int contador=0;
		for(ProductoMenu producto:productos) {
			System.out.println(contador+". "+producto.getNombre()+": $"+producto.getPrecio());
			contador+=1;
		}
		System.out.println("\nEstos Son Los Combos:\n");
		for(Combo combo:combos) {
			String itemsCombo="";
			for (int i=0;i<combo.getitemsCombo().size();i++) {
				ProductoMenu producto=combo.getitemsCombo().get(i);
				if(i==combo.getitemsCombo().size()-1) {
					itemsCombo+=producto.getNombre();
				}
				else {
					itemsCombo+=producto.getNombre()+", ";
				}
				
			}
			System.out.println(contador+". "+combo.getNombre()+": $"+combo.getPrecio()+" - "+itemsCombo);
			contador+=1;
		}
	}
	public static void mostrarOpciones() {
		System.out.println("Estas son las opciones:\n1. Mostrar el menú\n2. Iniciar un nuevo pedido\n3. Agregar un elemento a un pedido\n4. Cerrar un pedido y guardar la factura\n5. Consultar la información de un pedido dado su id\n6. Salir");
		
	}
	public static void ejecutarOpcion() {
		Pedido pedido=new Pedido("asd","asd");
		int numeroPedidos=0;
		boolean continuar = true;
		while (continuar)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.print("Digite la opción: ");
			String eleccion=scanner.nextLine();
			if (Integer.parseInt(eleccion)==1) {
				mostrarMenu();
			}
			else if (Integer.parseInt(eleccion)==2) {
				System.out.print("Iniciando pedido.....\n");
				System.out.print("Digite su nombre: ");
				String nombrecliente=scanner.nextLine();
				System.out.print("Digite su direccion: ");
				String direccion=scanner.nextLine();
				restaurante.iniciarPedido(nombrecliente, direccion);
				pedido=restaurante.getPedidoEnCurso();
				
			}
			else if (Integer.parseInt(eleccion)==3) {
				Map<String,String> listaProductos= new HashMap<String,String>();
				Map<String,String> listaIngredientes= new HashMap<String,String>();
				int contadoringredientes=0;
				for (Ingrediente ingrediente:restaurante.getIngredientes()) {
					listaIngredientes.put(Integer.toString(contadoringredientes),ingrediente.getNombre());
					contadoringredientes+=1;
				}
				int contador=0;
				for (ProductoMenu productos: restaurante.getMenu()) {
					listaProductos.put(Integer.toString(contador),productos.getNombre());
					contador+=1;
				}
				
				Map<String,String> listaCombos= new HashMap<String,String>();
				for (Combo combo: restaurante.getCombos()) {
					listaCombos.put(Integer.toString(contador),combo.getNombre());
					contador+=1;
				}

				ArrayList<String> listaIdentificadores=new ArrayList<String>();
				
				boolean opcion = true;
				System.out.print("Inserte el identificador del producto/combo que desea, digite -1 para detener el pedido\n");
				while (opcion) {
					String lector=scanner.nextLine();
					if (!lector.equals("-1")){
						listaIdentificadores.add(lector);
						System.out.println("Desea algo mas?");
					}
					else {
						opcion=false;
					}
				}
				for (String identificador:listaIdentificadores) {
					String nombreproducto=listaProductos.get(identificador);
					for (ProductoMenu producto:restaurante.getMenu()) {
						if (producto.getNombre().equals(nombreproducto)) {
							pedido.agregarProducto(producto);
						}
					}
				}
				for (String identificador2:listaIdentificadores) {
					String nombrecombo=listaCombos.get(identificador2);
					for (Combo combo:restaurante.getCombos()) {
						if (combo.getNombre().equals(nombrecombo)) {
							pedido.agregarProducto(combo);
						}
					}
				
				}
				System.out.println("Desea agregar productos modificados al pedido?\n1.Si\n2.No");
				String lector=scanner.nextLine();
				if (lector.equals("2")) {
					System.out.println("Proceda con la opción 4");
				}
				else if(lector.equals("1")) {
					System.out.println("Estos son los productos basicos que tiene en su pedido :");
					for (Producto producto: pedido.getitemsPedido()) {
						if (0<=producto.getid() && producto.getid()<=21) {
							System.out.println(producto.getid()+". "+producto.getNombre());
						}
					}
				System.out.println("Inserte los identificadores de los productos que desea modificar separados por coma y sin espacio");
				lector=scanner.nextLine();
				String[] listaids=lector.split(",");
				System.out.println("\nEstos Son Los Ingredientes:\n");
				int contadorprintingredientes=0;
				for(Ingrediente ingrediente:restaurante.getIngredientes()) {
					System.out.println(contadorprintingredientes+". "+ingrediente.getNombre()+": $"+ingrediente.getCostoAdicional());
					contadorprintingredientes+=1;
				}
				for (String ids: listaids) {
					ProductoAjustado productomodificado=new ProductoAjustado(restaurante.getMenu().get(0));
					String nombreProducto=listaProductos.get(ids);
					System.out.println("Escoja que ingredientes quiere adicionar a ("+nombreProducto+") separados por coma y sin espacios,-1 si no quiere agregar ningun ingrediente");
					lector=scanner.nextLine();
					boolean agrego=false;
					if (!lector.equals("-1")) {
						agrego=true;
						String[] listaingredientesadicionales=lector.split(",");
						ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
						for (String idingredientes: listaingredientesadicionales){
							String nombreingrediente=listaIngredientes.get(idingredientes);
							for(Ingrediente ingrediente:restaurante.getIngredientes()){
								if (ingrediente.getNombre().equals(nombreingrediente)) {
									agregados.add(ingrediente);
								}
							}
						}
						
						for (ProductoMenu productos: restaurante.getMenu()) {
							if (productos.getNombre().equals(nombreProducto)) {
								productomodificado=new ProductoAjustado(productos);
								productomodificado.setagregados(agregados);
							}
						}
					}
					System.out.println("Escoja que ingredientes quiere eliminar a ("+nombreProducto+") separados por coma y sin espacios, -1 si no quiere eliminar ningun ingrediente");
					lector=scanner.nextLine();
					boolean elimino=false;
					if (!lector.equals("-1")) {
						elimino=true;
						String[] listaingredienteseliminados=lector.split(",");
						ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
						for (String idingredientes: listaingredienteseliminados){
							String nombreingrediente=listaIngredientes.get(idingredientes);
							for(Ingrediente ingrediente:restaurante.getIngredientes()){
								if (ingrediente.getNombre().equals(nombreingrediente)) {
									eliminados.add(ingrediente);
									System.out.println(ingrediente.getNombre());
								}
							}
						}	
						if (agrego==false) {
							for (ProductoMenu productos: restaurante.getMenu()) {
								if (productos.getNombre().equals(nombreProducto)) {
									productomodificado=new ProductoAjustado(productos);
									productomodificado.seteliminados(eliminados);
								}
							}
						
						}
					}
					ArrayList<Producto> copiaItemsPedido=new ArrayList<Producto>();
					copiaItemsPedido=pedido.getitemsPedido();

					int idProductoBase=productomodificado.getBase().getid();
					for (Producto producto:copiaItemsPedido) {
						if(idProductoBase==producto.getid()) {
							pedido.getitemsPedido().add(productomodificado);
						}						
						
					}			
				}
				}
			}
			
			else if (Integer.parseInt(eleccion)==4) {
				numeroPedidos+=1;
				restaurante.getPedidoEnCurso().setnumeroPedidos(numeroPedidos);
				restaurante.cerrarYGuardarPedido();
			}
			else if (Integer.parseInt(eleccion)==5) {
				mostrarMenu();
			}
			else if (Integer.parseInt(eleccion)==6) {
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;	
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		restaurante=new Restaurante();
		mostrarOpciones();
		ejecutarOpcion();
	}
	
}
	