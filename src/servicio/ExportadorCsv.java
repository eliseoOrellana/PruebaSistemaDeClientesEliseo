package servicio;

import java.util.ArrayList;

import modelo.Cliente;

public abstract class ExportadorCsv extends ExportadorTxt{
	String fileName;
	public abstract void Exportador(ArrayList<Cliente> listaClientes);
}
