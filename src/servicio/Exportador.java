package servicio;

import java.util.ArrayList;
import modelo.Cliente;

public abstract class Exportador {
	String fileName;
	public abstract void Exportador(ArrayList<Cliente> listaClientes);
}
