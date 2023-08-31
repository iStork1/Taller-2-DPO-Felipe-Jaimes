package consola;


import modelo.Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Combo;
import modelo.Pedido;
import modelo.ProductoMenu;

public class Aplicacion {
	static Restaurante restaurante;
	
	
	public static void mostrarMenu() {
		ArrayList<ProductoMenu>productos= restaurante.getMenu();
		ArrayList<Combo>combos= restaurante.getCombos();
		System.out.println("\nEstos Son Los Productos Basicos:\n");
		for(ProductoMenu producto:productos) {
			System.out.println(producto.getNombre()+": $"+producto.getPrecio());
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
			System.out.println(combo.getNombre()+": $"+combo.getPrecio()+" - "+itemsCombo);
		}
	}
	public static void mostrarOpciones() {
		System.out.println("Estas son las opciones:\n1. Mostrar el menú\n2. Iniciar un nuevo pedido\n3. Agregar un elemento a un pedido\n4. Cerrar un pedido y guardar la factura\n5. Consultar la información de un pedido dado su id");
		
	}
	public void ejecutarOpcion() {
		
	}
	public static void main(String[] args) {
		restaurante=new Restaurante();
		mostrarOpciones();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Digite la opción: ");
		String eleccion=scanner.nextLine();
		if (Integer.parseInt(eleccion)==1) {
			mostrarMenu();
		}
		if (Integer.parseInt(eleccion)==2) {
			System.out.print("Digite la su nombre: ");
			String nombre=scanner.nextLine();
			System.out.print("Digite la su direccion: ");
			String direccion=scanner.nextLine();
			restaurante.iniciarPedido(nombre, direccion);
			Pedido pedido=restaurante.getPedidoEnCurso();
			System.out.println(nombre);
		}
		if (Integer.parseInt(eleccion)==3) {
			mostrarMenu();
		}
		if (Integer.parseInt(eleccion)==4) {
			mostrarMenu();
		}
			
	}
	
}
	