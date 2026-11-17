package es.studium.Practica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListaDeLaCompra 
{
	public String nombreLista;
	public ArrayList<ArticuloAComprar> articulos;

	public ListaDeLaCompra() 
	{
		nombreLista = "";
		articulos = new ArrayList<>();
	}
	public ListaDeLaCompra(String nombreLista) {
		this.nombreLista = nombreLista;
		this.articulos = new ArrayList<>();
	}
	public String getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	public void AgregarProductoAComprar(ArticuloAComprar articulo)
	{
		articulos.add(articulo);
		guardarListaEnArchivo();
		System.out.println("Artículo añadido y guardado.");
	}
	public void guardarListaEnArchivo()
	{
		String nombreArchivo = nombreLista + ".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo)))
		{
			for (ArticuloAComprar articulo : articulos)
			{
				bw.write(articulo.getDescripcion() + "," + articulo.getCantidad() + "," + articulo.getUnidad());
				bw.newLine();
			}
			System.out.println("Lista guardada en " + nombreArchivo);
		}
		catch (IOException e)
		{
			System.out.println("Error al guardar la lista: " + e.getMessage());
		}
	}


	public void eliminarArticulo(String descripcionArticulo)
	{
		for (int i = articulos.size() - 1; i >= 0; i--)
		{
			if (articulos.get(i).getDescripcion().equals(descripcionArticulo))
			{
				articulos.remove(i);
			}
		}
		guardarListaEnArchivo(); 
	}

	public ArrayList<ArticuloAComprar> getArticulos() {
		return new ArrayList<>(this.articulos);
	}
}