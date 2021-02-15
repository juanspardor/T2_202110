package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 * @param <T>
 *
 */

public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
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
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	@SuppressWarnings("unchecked")
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}



	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[ ] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 

		}
		elementos[tamanoAct++] = dato;
		tamanoAct++;

	}	



	/**
	 * Retorna el elemento recibido por parametro
	 * @param el elemento a buscar
	 * @return el elemento buscado, null de lo contrario
	 */
	public T buscar(T dato) {

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

	/**
	 * Elimina el elemento recibido por parametro y reorganiza el arreglo
	 * @param dato a eliminar
	 * @return elemento eliminado, null de lo contrario
	 */
	public T eliminar(T dato) {

		// TODO implementar
		T rta = null;
		int pos = 0;
		for(int i = 0;i<tamanoAct;i++)
		{
			if(elementos[i].compareTo(dato)==0)
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
			tamanoAct = tamanoAct-1;

		}
		return rta;

	}



	/**
	 * Da la capacidad
	 */
	public int darCapacidad()
	{
		return tamanoMax;
	}

	/**
	 * Da el tamano actual
	 */
	public int size() 
	{
		return tamanoAct;
	}
	
	/** 
	 * Da el elemento en la posicion recibida por parametro
	 * @param posicion
	 * @return elemento en la posicion recibida por parametro. Null si la posicion es mayor a al tamanho actual, o s es menor a 0
	 */
	public T getElement(int i)
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


	/**
	 * Invierte los elementos del arreglo
	 */
	public void invertir()
	{
		T[] copia = elementos; 
		T[] nuevo = (T[]) new Object[tamanoMax]; 
		for(int i = 0; i<tamanoAct;i++) 
		{
			int i_final = tamanoAct - 1 - i; 
			nuevo[i] = elementos[i_final]; 
		}
		elementos = nuevo; 
	}



	@Override
	public void addFirst(T elemento) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addLast(T elemento) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void insertElement(T elemento, int posicion) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public T deleteElement(int posicion) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public T firstElement() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public T lastElement() {
		// TODO Auto-generated method stub
		return null;
	}




	



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int isPresent(T element) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void exchange(int pos1, int pos2) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void changeInfo(int pos, T elemento) {
		// TODO Auto-generated method stub
		
	}





}
