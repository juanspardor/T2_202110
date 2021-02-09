package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 * @param <T>
 *
 */
@SuppressWarnings("rawtypes")
public class ArregloDinamico<T> implements IArregloDinamico <T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T [] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */

	public ArregloDinamico( int max )
	{
		elementos = (T[] ) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}



	public void agregar ( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  
			// caso de arreglo lleno (aumentar tamaNo)

			tamanoMax = 2 * tamanoMax;
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
		}

		elementos[tamanoAct] = dato;
		tamanoAct++;
	}


	
	public T buscar (T dato) 
	{
		// TODO implementar
		T rta = null;
		boolean encontrado = false;
		for(int i = 0 ; i< tamanoAct && !encontrado; i++)
		{
			if(elementos[i].equals(dato))
			{
				rta = elementos[i];
			}
		}
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return rta;
	}

	public T eliminar (T dato) {
		// TODO implementar
		T rta = null;
		//Si el dato no existe, retorno nulll
		if(buscar(dato)==null)
		{
			return null;
		}
		else
		{
			//Como no se sabe la posicion del dato, hago un for buscandolo
			int pos = 0;
			for(int i = 0;i<tamanoAct;i++)
			{
				if(elementos[i].equals(dato))
				{
					pos = i;
					rta = elementos[i];
					elementos[i]=null;
				}
			}
			//Una vez se encuentra la posicion, se desfaza todo el arreglo a partir del eliminado
			for(int j = pos; j<tamanoAct;j++)
			{
				if(j==tamanoAct-1)
				{
					elementos[j]=null;
				}
				else
				{
					elementos[j]=elementos[j+1];
				}

			}
		}
		tamanoAct = tamanoAct-1;
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return rta;
	}


	

	public int darCapacidad()
	{
		return tamanoMax;
	}

	public int darTamano() 
	{
		return tamanoAct;
	}

	public T darElemento(int i)
	{
		// TODO implementar
		
		if(i > tamanoAct || i<0)
		{
			return null;
		}
		else
		{
			return elementos[i];
		}
		
	}


	

}
