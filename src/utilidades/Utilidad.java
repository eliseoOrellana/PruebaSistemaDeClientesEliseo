package utilidades;

public class Utilidad {
	public void limpiar(int lineas)

	{
		for (int i=0; i < lineas; i++)
		{
		System.out.println("");
		}
}
	public static void tiempoEspera() {
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
