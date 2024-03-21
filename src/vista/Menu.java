package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;
import utilidades.Utilidad;

public class Menu {

	static Menu menu = new Menu();
	static ClienteServicio clienteServicio = new ClienteServicio();// ??????
	// ArchivoServicio archivoServicio = new ArchivoServicio();
	// ExportadorCsv exportadorCsv = new ExportadorCsv();
	// ExportarTxt exportarTxt = new ExportarTxt();
	private String fileName = "Clientes"; // exportar el archivo
	private String fileName1 = "DBClientes.csv"; // importar el archivo
	Scanner sc = new Scanner(System.in);

	public void listarCliente() {

		if (clienteServicio.getListaClientes() != null) {

			System.out.println("-------------Datos del Cliente-------------");
			for (Cliente iteracion : clienteServicio.getListaClientes()) {
				System.out.println("RUN del Cliente: " + iteracion.getRunCliente());
				System.out.println("Nombre del Cliente: " + iteracion.getNombreCliente());
				System.out.println("Apellido del Cliente: " + iteracion.getApellidoCliente()); // BUENO
				System.out.println("Años como Cliente: " + iteracion.getAniosCliente());
				System.out.println("Categoria del Cliente: " + iteracion.getNombreCategoria());
				System.out.println("-------------------------------------------");
			}
		} else {
			System.out.println("Primero debe agregar clientes");
		}
	}

	public static void agregarCliente() { // BUENO

		Scanner sc = new Scanner(System.in);
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente:");
		String run = sc.next();
		System.out.println("Ingresa Nombre del Cliente:");
		String nombreCliente = sc.next();
		System.out.println("Ingresa Apellido del Cliente:");
		String apellido = sc.next();
		System.out.println("Ingresa años como Cliente:");
		String anios = sc.next();
		System.out.println("---------------------------------------");

		Cliente cliente = new Cliente(run, nombreCliente, apellido, anios);

		clienteServicio.agregarCliente(cliente);
		menu.iniciarMenu();
	}

	public void editarCliente() {

		System.out.println("-------------Editar Cliente-------------\n" + "Seleccione qué desea hacer:\n");
		System.out.println("1.-Cambiar el estado del Cliente\n" + "2.-Editar los datos ingresados del Cliente\n" + "\n"
				+ "Ingrese opcion:\n" + "----------------------------------------\n");
		String opcion = sc.nextLine();
		System.out.println("Ingrese RUN del Cliente a editar:");
		String run = sc.nextLine(); // revisar manejor errores
		if (opcion.equals("1")) { // duda?
			System.out.println("-----Actualizando estado del Cliente----");
			for (Cliente iteracion : clienteServicio.getListaClientes()) {// ubicacion lista
				if (run.equals(iteracion.getRunCliente())) {
					System.out.println("El estado actual es: " + iteracion.getNombreCategoria());
					System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo\r\n"
							+ "2.-Si desea mantener el estado del cliente Activo\r\n" + "Ingrese opcion:\r\n"
							+ "----------------------------------------");
					String opcionEstado = sc.nextLine();
					if (opcionEstado.equals("1")) {
						iteracion.setNombreCategoria(CategoriaEnum.Inactivo);
						System.out.println("Se realizo el cambio a inactivo");
						// menu.iniciarMenu();
					} else {
						if (opcionEstado.equals("2")) {
							iteracion.setNombreCategoria(CategoriaEnum.Activo); // yo
							System.out.println("Se realizo el cambio a activo");
							// menu.iniciarMenu(); // ver si se puede poner afuera
						} else {
							System.out.println("Ingrese una opcion correcta");
						}
					}
				}
			}
		} else {
			if (opcion.equals("2")) {
				System.out.println("-----Actualizando estado del Cliente----\n");// yo todo este ciclo revisar
				for (Cliente iteracion : clienteServicio.getListaClientes()) {
					if (run.equals(iteracion.getRunCliente())) {
						System.out.println("1.-El RUN del Cliente es: " + iteracion.getRunCliente());
						System.out.println("2.-El Nombre del Cliente es: " + iteracion.getNombreCliente());
						System.out.println("3.-El Apellido del Cliente es: " + iteracion.getApellidoCliente());
						System.out.println("4.-Los años como Cliente son: " + iteracion.getAniosCliente());
					}
					System.out.println("Ingrese opcion a editar de los datos del cliente:");
					System.out.println("----------------------------------------\n");
					opcion = sc.nextLine();
					if (opcion.equals("1")) {
						System.out.println("1.-Ingrese nuevo RUN del Cliente:");
						String runCliente = sc.nextLine();
						iteracion.setRunCliente(runCliente);
						System.out.println("----------------------------------------");
						System.out.println("Datos cambiados con éxito");
					} else {
						if (opcion.equals("2")) {
							System.out.println("2.-Ingrese nuevo Nombre del Cliente:");
							String nombreCliente = sc.nextLine();
							iteracion.setNombreCliente(nombreCliente);
							System.out.println("----------------------------------------");
							System.out.println("Datos cambiados con éxito");
						} else {
							if (opcion.equals(3)) {
								System.out.println("3.-Ingrese nuevo Apellido del Cliente:");
								String apellidoCliente = sc.nextLine();
								iteracion.setApellidoCliente(apellidoCliente);

							} else {
								if (opcion.equals(4)) {
									System.out.println("4.-Ingrese nuevo año como Cliente:");
									String aniosCliente = sc.nextLine();
									iteracion.setAniosCliente(aniosCliente);
									System.out.println("----------------------------------------");
									System.out.println("Datos cambiados con éxito");

								} else {
									System.out.println("Ingrese una opcion valida");
								}
							}
						}
					}
				}

			} else {
				System.out.println("Ingrese una opcion valida\n" + "----------------------------------------"); // yo
				// llamar menu o metodo editarCliente
			}
		}
		System.out.println();
		menu.iniciarMenu();
	}

	public final void iniciarMenu() { // revisar final

		System.out.println("1. Listar Cliente\n" + "2. Agregar Cliente\n" + "3. Editar Cliente\n"
				+ "4. Importar Datos\n" + "5. Exportar Datos\n" + "6. Salir\n" + "Ingrese una opcion");
		String opcion = sc.nextLine();
		switch (opcion) {
		case "1":
			listarCliente(); // BUENO
			break;
		case "2":
			agregarCliente(); // BUENO

			break;
		case "3":
			editarCliente(); //BUENO pero revisar completo

			break;
		case "4":
			clienteServicio.importarDatos();
			break;
		case "5":
			// exportarDatos();
			break;
		case "6":

			System.out.println("Abandonando el sistema de productos...");
			Utilidad.tiempoEspera();
			System.out.println("Acaba de salir del sistema");
			break;
		default:
			System.out.println("Elija una opcion valida.");
			break;
		}
	}
}
