package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
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
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
			if(i > tamanoAct || i<0)
			{
				return null;
			}
			else
			{
				return elementos[i];
			}
			// TODO implementar
		}

		public String buscar(String dato) {
			// TODO implementar
			String rta = null;
			boolean encontrado = false;
			for(int i = 0 ; i< tamanoAct && !encontrado; i++)
			{
				if(elementos[i].compareTo(dato)==0)
				{
					rta = elementos[i];
				}
			}
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return rta;
		}

		public String eliminar(String dato) {
			// TODO implementar
			String rta = null;
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
					
				}
			}
			tamanoAct = tamanoAct-1;
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return rta;
		}

}
