package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Restaurante;
import modelo.Ingrediente;

public class Aplicacion {
	
	
	
	public void mostrarMenu() {

	}
	public void ejecutarOpcion() {
	}
	public static void main(String[] args) throws IOException {
		Restaurante restaurante=new Restaurante();
		System.out.println( restaurante.getIngredientes().get(0).getNombre());
	}
	
}
	