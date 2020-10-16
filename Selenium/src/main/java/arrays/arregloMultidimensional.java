package arrays;

public class arregloMultidimensional {
	
	public static void main (String[] args) {
		//declarar e inicializar un array de 2 dimensiones
		int arr[][] = {{2,7,9},{3,6,1},{7,4,2}};
		System.out.println (arr[2][1]);
		System.out.println (arr[0][0]);
		
		
		for (int i = 0;  i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(arr[i][j] + " ");
			}
			System.out.println();
		
		
	
		}
	}

}
