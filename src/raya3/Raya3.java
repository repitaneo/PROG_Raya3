package raya3;

public class Raya3 {

	private char turno ;
	private char tablero[][];
	private final int FILAS_COLUMNAS = 3; 
	
	
	
	
	public Raya3() {
		
		turno = 'x';
		tablero =  new char[FILAS_COLUMNAS][FILAS_COLUMNAS];
	}
	
	
	
	
	public void play() {
		
		
		for(int i=0;i<FILAS_COLUMNAS*FILAS_COLUMNAS;i++) {

			int x = (int)(Math.random()*3);
			int y = (int)(Math.random()*3);
			while(tablero[x][y]!=0) {
				
				x = (int)(Math.random()*3);
				y = (int)(Math.random()*3);
			}
			
			// ya tengo tablero[x][y] donde no hay nada
			tablero[x][y] = turno;
			turno = (turno=='x')?'o':'x';
			
			dibujarTablero();
			
			

			try {
				Thread.sleep(4000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}
	
	
	
	
	
	/**
	 * Imprime el tablero
	 */
	private void dibujarTablero() {
		
		for(int i=0;i<FILAS_COLUMNAS;i++) {
			System.out.print("| ");
			for(int j=0;j<FILAS_COLUMNAS;j++) {
				
				System.out.print(tablero[i][j]+" ");
			}			
			System.out.println();
		}
		System.out.println("\n\n\n");
	}
	
}
