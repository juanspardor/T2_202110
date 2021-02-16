package model.data_structures;

public class NodoListaEncadenada < T extends Comparable <T>> 
{
	private T info;
	private NodoListaEncadenada<T> next;
	
	public NodoListaEncadenada(T informacion)
	{
		info=informacion;
		next=null;
	}
	
	public T getInfo()
	{
		return this.info;
	}
	
	
	public NodoListaEncadenada<T> getNext()
	{
		return this.next;
	}
	
	
	public void setNext(NodoListaEncadenada<T> elSiguiente)
	{
		NodoListaEncadenada<T> siguiente=this.next.next;
		this.next= elSiguiente;
		elSiguiente=siguiente;
	}
	
	
	**public void disconnectNext(NodoListaEncadenada<T> desconectar)
	{
		NodoListaEncadenada<T> siguiente=this.next.next;
		desconectar.next=desconectar.next.next;
	}

}
