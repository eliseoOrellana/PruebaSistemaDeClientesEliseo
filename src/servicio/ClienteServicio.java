package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	private List<Cliente> listaClientes;

	Scanner sc = new Scanner(System.in);

	public ClienteServicio() {
		super();
		this.listaClientes = new ArrayList<>();

	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void agregarCliente(Cliente cliente) { // BUENO

		listaClientes.add(cliente);
	}

	public void editarCliente() {

	}

	public void importarDatos() {

		String ruta = sc.next();

		/*
		 * System.out.println("---------Cargar Datos en Linux o Mac-----------");
		 * System.out.
		 * println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		 * 
		 * System.out.println("-----------------------------------------------\n");
		 * System.out.println("Datos cargados correctamente en la lista");
		 */

	}
}
