package Clases;

public class DatosDesordenados {
    private int[] valores; 
    private int limiteSuperior; 
    private int size; 

    public DatosDesordenados(int limite, int size) {
        this.valores = new int[size];
        this.limiteSuperior = limite;
        this.size = size;
    }
    
    public void agregarDato(int valor){
        valores[size]= valor;
        size++;
    }
    
    public int getDato(int posicion){
        return valores[posicion];
    }
    
    public void generarValores(){
        for (int i=0; i < valores.length; i++){
            double aleatorio = Math.random() * limiteSuperior;
            valores[i] = (int) aleatorio + 1;
        }
    }
    
    public int getSize(){
        return size; 
    }
    
    public int getCapacidad(){
        return valores.length;
    }
    
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    
    
    public int[] getValores(){
        return valores;
    } 
    
    public int[] getCopiaValores(){
        int [] copia = new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }
    
    
   
     public DatosOrdenados algoritmoSort(){
        
        // obtener una copia de los datos desordenados
        int [] arreglo = this.getCopiaValores();
        
        // agregar algoritmo de ordenación
        
        // devolver los datos ordenados
        return new DatosOrdenados(arreglo);
    }
     
    //Algoritmo BubbleSort para crecer
    public DatosOrdenados bubbleSort(){
        int [] arreglo = this.getCopiaValores();
       
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
       
        for (int i=0; i < n-1; i++){
            for (int j=0; j < n-i-1; j++){
                cont++;
                if (arreglo[j] > arreglo[j+1]){
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                }
            }
        }      
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-intercambios = " + ci );
        return new DatosOrdenados(arreglo);
    }
    
    //Algoritmo BubbleSort para decrecer
    public DatosOrdenados bubbleSort2(){
        int [] arreglo = this.getCopiaValores();
       
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
       
        for (int i=0; i < n-1; i++){
            for (int j=0; j < n-i-1; j++){
                cont++;
                if (arreglo[j] < arreglo[j+1]){
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                }
            }
        }      
        return new DatosOrdenados(arreglo);
    }
    
    //Algoritmo InsertSort para crecer
    public DatosOrdenados insertSort(){
         // obtener una copia de los datos desordenados
        int [] a = this.getCopiaValores();
        
	int i, j, aux; 
	int cont=0; 
	for ( i = 1; i < a.length; i++){
		j = i;
		aux = a[i];
		while (j >0 && aux < a[j-1]){
                   cont++;
                   a[j] = a[j-1];
                   j--; 
		}
		a[j] = aux; 
	}
        System.out.println("IS-comparaciones = " + cont);
	// devolver los datos ordenados
        return new DatosOrdenados(a);
    }
    
    //Algoritmo InsertSort para decrecer
    public DatosOrdenados insertSort2(){
         // obtener una copia de los datos desordenados
        int [] a = this.getCopiaValores();
        
	int i, j, aux; 
	int cont=0; 
	for ( i = 1; i < a.length; i++){
		j = i;
		aux = a[i];
		while(j >0 && a[j-1]<aux){
                   cont++;
                   a[j] = a[j-1];
                   j--; 
		}
		a[j] = aux; 
	}
       
        return new DatosOrdenados(a);
    }
    
    //Algoritmo  para crecer
    public DatosOrdenados ShellSort(){
        int [] a = this.getCopiaValores();
       
        int intervalo,i,j,k ,aux;
        int n = a.length;
        int cont=0; 
       
        intervalo = n / 2;
        
        while (intervalo > 0){
            cont++;
            for (i = intervalo; i < n; i++){
                j = i - intervalo;
                while (j >= 0){
                    k = j + intervalo;
                    if (a[j] <= a[k]){
                        j = -1;
                    }else{
                        aux = a[j];
                        a[j] = a[k];
                        a[k] = aux;
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo/2;
        }
        System.out.println("IS-comparaciones = " + cont);
        return new DatosOrdenados(a);
    }
    
    //Algoritmo ShellSort para decrecer
    public DatosOrdenados ShellSort2(){
        int [] a = this.getCopiaValores();
       
        int intervalo,i,j,k ,aux;
        int n = a.length;
        int cont=0; 
       
        intervalo = n / 2;
        
        while (intervalo > 0){
            cont++;
            for (i = intervalo; i < n; i++){
                j = i - intervalo;
                while (j >= 0){
                    k = j + intervalo;
                    if (a[j] >= a[k]){
                        j = -1;
                    }else{
                        aux = a[j];
                        a[j] = a[k];
                        a[k] = aux;
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo/2;
        }
        return new DatosOrdenados(a);
    }
    
    //Algoritmo QuickSort
    public DatosOrdenados Quicksort(){
        int []a = this.getCopiaValores();
        int i = 0;
        int j = 0;
        
    //Se toma como pivote el primer valor
        int pivote = a[i];
        //Se definen los dos lados y un auxiliar 
        int aux;
        int n = a.length;
        int cont=0;
        while(i<j){
            cont++;
            while (a[i] <= pivote && i < j)i++;
            while (a[j] > pivote)j--;   
            if (i<j) {                                     
                aux = a[i];                  
                a[i]= a[j];
                a[j]=aux;
            }
        }
        a[i] = a[j]; 
        a[j] = pivote; 
        if(i < j-1)
            quicksort(a,i,j-1);          
        if(j+1 < j)
            quicksort(a,j+1,j); 
        System.out.println("IS-comparaciones = " + cont);
	// devolver los datos ordenados
        return new DatosOrdenados(a);
    }
    private void quicksort(int[] a, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    //Algoritmo Radix
    public DatosOrdenados Radix(){
        int [] a = this.getCopiaValores();
       
        int x,i,j;
        int cont=0; 
        
        for(x = Integer.SIZE-1; x>=0; x--){
            cont++;
            int aux[] = new int[a.length];
            j = 0;
            for(i = 0; i<a.length; i++){
                boolean mover = a[i]<< x >= 0;
                if(x==0 ? !mover:mover){
                    aux[j] = a[i];
                    j++;
                }else{
                    a[i-j] = a[i];
                }
            }
            for(i=j; i<aux.length; i++){
                aux[i] = a[i-j];
            }
            a = aux;
        }
        System.out.println("IS-comparaciones = " + cont);
	// devolver los datos ordenados
        return new DatosOrdenados(a);
    }
    
    public DatosOrdenados mergeSort(){
    int [] x = this.getCopiaValores();
	// Aquí va la llamada al método mergesort( arreglo, l, r)
	this.mergesort( x, 0, x.length - 1);
        System.out.println("MS-comparaciones = " + cm);
	return new DatosOrdenados(x);
    } // fin del método ordenacionMerge
    
   private void mergesort (int v[], int l, int r) {
		 int m = (r+l)/2; 
		 if (r > l) { 
                     cm++;
			 mergesort (v, l, m);
			 mergesort (v, m+1, r); 
			 merge (v, l, m, r); 
		 }
	}
    static int cm=0;
   private void merge (int v[], int l, int m, int r)
	{
	//Encuentra el tamaño de los sub-vectores para unirlos.
	  int n1 = m - l + 1;
	  int n2 = r - m;

	  //Vectores temporales.
	  int arrIzq[] = new int [n1];
	  int arrDer[] = new int [n2];

	  //Copia los datos a los arreglos temporales.
	  for (int i=0; i < n1; i++) {
              cm++;
		arrIzq[i] = v[l+i];
	  }
	  for (int j=0; j < n2; j++) {
              cm++;
		arrDer[j] = v[m + j + 1];
	  }
	  // Combinación (mezcla) de los dos arreglos:
	  int i = 0, j = 0;
	  int k = l;
	  while (i < n1 && j < n2) {//Ordenamiento.
                cm++;
		if (arrIzq[i] <= arrDer[j]) {
			v[k] = arrIzq[i];
			i++;
		} else {
			v[k] = arrDer[j];
			j++;
		}
		k++;
	  }//Fin del while.

	  /* Si quedan elementos por ordenar */
	  //Copiar los elementos restantes de arrIzq[].
	  while (i < n1) {
              cm++;
	    v[k] = arrIzq[i];
	    i++;
	    k++;
	  }
	  //Copiar los elementos restantes de arrDer[].
	  while (j < n2) {
              cm++;
	    v[k] = arrDer[j];
	    j++;
	    k++;
	  }
	}
    
    @Override
    public String toString(){
        String cad = "Datos DESORDENADOS: ";
        for (int x : valores){
            cad += x + ", ";
        }
        return cad;
    }
}
