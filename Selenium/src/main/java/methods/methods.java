package methods;

public class methods {
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		int resultado = suma(3,4);
		System.out.println(resultado);
		
		String marca = carro(1);
		System.out.println(marca);
		
	}
	
	public static int suma (int a, int b) {
		int c = a + b;
		return c;
		
	}
	
	public static String carro(int a) {
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		return cars[a];
			
	}
	

}
