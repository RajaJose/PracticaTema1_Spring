package es.studium.Practica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ListaDeLaCompra lista = null;
		Scanner teclado = new Scanner(System.in);
		try {
		System.out.println("Si quieres crear una nueva lista escribe 1, si quieres salir escribe 2 ");
		int num1 = teclado.nextInt();
		teclado.nextLine();
		
		if(num1 == 1)
		{
			System.out.println("Escribe el nombre de la lista:");
			String nombreLista = teclado.nextLine();
			lista = new ListaDeLaCompra(nombreLista);

		} else if(num1 == 2)
		{
			System.out.println("Saliendo de la aplicación...");
			System.exit(0);
		} else {
			System.err.println("Opción no válida.");
			System.exit(0);
		}
		
		
		}catch(InputMismatchException Ime) {
			System.err.println("Debes escribir un número...");
			System.exit(0);
		}
		try
		{
		while (true) {
			System.out.println("\nSi quieres agregar un artículo a la Lista escribe 1, si quieres eliminar un artículo pulsa 2 y si quieres salir pulsa 3.");
			int num2 = teclado.nextInt();
			teclado.nextLine();

			if (num2 == 1)
			{
				System.out.print("Introduce la descripcion del artículo: ");
				String descripcion = teclado.nextLine();

				System.out.print("Introduce la cantidad: ");
				int cantidad = teclado.nextInt();
				teclado.nextLine();

				System.out.print("Introduce la unidad: ");
				String unidad = teclado.nextLine();

				ArticuloAComprar articulo = new ArticuloAComprar(descripcion, cantidad, unidad);
				lista.AgregarProductoAComprar(articulo);
				System.out.println("Artículos en la lista:");
				for (ArticuloAComprar articulo_ : lista.getArticulos())
				{
					System.out.println("- " + articulo.getDescripcion() + ": " + articulo.getCantidad() + " " + articulo.getUnidad());
			}
			}
			else if (num2 == 2)
			{
				System.out.print("Introduce la descripcion del artículo a eliminar: ");
				String descripcion = teclado.nextLine();
				lista.eliminarArticulo(descripcion);
				System.out.println("Artículo eliminado");
				System.out.println("Artículos en la lista:");
				for (ArticuloAComprar articulo : lista.getArticulos())
				{
					System.out.println("- " + articulo.getDescripcion() + ": " + articulo.getCantidad() + " " + articulo.getUnidad());
				}
			}
			else if (num2 == 3)
			{
				System.out.println("Saliendo...");
				System.exit(0);
			}
			else
			{
				System.out.println("Opción no válida.");
				System.exit(0);
			}
		}
		}catch (InputMismatchException Ime){
			System.err.println("Debes escribir un número...");
			System.exit(0);
		}

		}

		
	}

