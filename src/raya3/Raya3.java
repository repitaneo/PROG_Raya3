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
		
		boolean ganador = false;
		int fichasColocadas = 0;
		
		while((!ganador)&(fichasColocadas!=9)){

			int x = (int)(Math.random()*3);
			int y = (int)(Math.random()*3);
			while(tablero[x][y]!=0) {
				
				x = (int)(Math.random()*3);
				y = (int)(Math.random()*3);
			}
			
			// ya tengo tablero[x][y] donde no hay nada
			tablero[x][y] = turno;
			turno = (turno=='x')?'o':'x';
			fichasColocadas++;
			
			dibujarTablero();
			ganador = ganadorVertical(y)|ganadorHorizontal(x)|
					  ganadorDiagonal();
			

			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}
	
	
	
	private boolean ganadorVertical(int columna) {
		
		return (tablero[0][columna]!=0 &&
				tablero[0][columna]==tablero[1][columna]&
				tablero[1][columna]==tablero[2][columna]);
	}
	
	
	private boolean ganadorHorizontal(int fila) {
		
		return (tablero[fila][0]!=0 &&
				tablero[fila][0]==tablero[fila][1]&
				tablero[fila][1]==tablero[fila][2]);
	}
	
	private boolean ganadorDiagonal() {
		
		return tablero[1][1]!=0 &&
				((tablero[1][1]==tablero[0][0]&
				tablero[1][1]==tablero[2][2])|
				(tablero[1][1]==tablero[0][2]&
				tablero[1][1]==tablero[2][0]));
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
