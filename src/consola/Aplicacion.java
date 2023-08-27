package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import modelo.Restaurante;


public class Aplicacion {
	static File archivoIngredientes=new File("./data/ingredientes.txt");
	static File archivoMenu=new File("./data/menu.txt");
	static File archivoCombos=new File("./data/combos.txt");

	public static void main(String[] args) throws IOException {
		Aplicacion opciones = new Aplicacion();
		opciones.ejecutarOpcion();
		Restaurante restaurante= new Restaurante();
		restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	}
	
	public void mostrarMenu() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar un archivo de atletas");
		System.out.println("2. Consultar los atletas de un año dado");
		System.out.println("3. Consultar las medallas de un atleta en un periodo");
		System.out.println("4. Consultar los atletas de un país dado");
		System.out.println("5. Salir de la aplicación\n");
	}
	public void ejecutarOpcion() {
		System.out.println("Estadísticas sobre los Juegos Olímpicos\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarAtletas();
				else if (opcion_seleccionada == 2 && calculadora != null)
					ejecutarAtletasPorAnio();
				else if (opcion_seleccionada == 3 && calculadora != null)
					ejecutarMedallasEnRango();
				else if (opcion_seleccionada == 4 && calculadora != null)
					
				else if (opcion_seleccionada == 5)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
