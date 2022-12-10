package acp;

public class Calculcentreenorme {
	double [][] m1=new double [15][3];
	double [][] mr=new double [15][3];
	public Calculcentreenorme(double [][] m1) {
		
		double[][] mc=new Calculcentre(m1).centre;
		this.m1=Calculcentreenorm(mc);
		this.mr=Calculreduite(mc);
		
	}
	
	
	public double[][] Calculcentreenorm(double [][] m1) {
		double q = 0, q1 = 0, q2 = 0;
		double[][] m3 = new double[15][3];
		double[][] m4 = new double[15][3];
		for(int k = 0; k < 15; k++) {
			q = q + m1[k][0] * m1[k][0];
		}
		for(int k = 0; k < 15; k++) {
			q1 += m1[k][1] * m1[k][1];
		}
		for(int k = 0; k < 15; k++) {
			q2 += m1[k][2] * m1[k][2];
		}
		
		q = q / 15;
		q = Math.sqrt(q);
		q1 = q1 / 15;
		q1 = Math.sqrt(q1);
		q2 = q2 / 15;
		q2 = Math.sqrt(q2);

		//Calcul MATRICE centree reduite

		for(int i = 0; i < 15; i++) {
			int k = 0;
			m3[i][k] = m1[i][k] / q;
			k++;
			m3[i][k] = m1[i][k] / q1;
			k++;
			m3[i][k] = m1[i][k] / q2;
		}
		for(int i = 0; i < 15; i++) {
			
			m4[i][0] = m3[i][0] / Math.sqrt(15);
			
			m4[i][1] = m3[i][1] / Math.sqrt(15);
			
			m4[i][2] = m3[i][2] / Math.sqrt(15);
		}
		return m4;
	}
	public double[][] Calculreduite(double [][] m1) {
		double q = 0, q1 = 0, q2 = 0;
		double[][] m3 = new double[15][3];
		double[][] m4 = new double[15][3];
		for(int k = 0; k < 15; k++) {
			q = q + m1[k][0] * m1[k][0];
		}
		for(int k = 0; k < 15; k++) {
			q1 += m1[k][1] * m1[k][1];
		}
		for(int k = 0; k < 15; k++) {
			q2 += m1[k][2] * m1[k][2];
		}
		
		q = q / 15;
		q = Math.sqrt(q);
		q1 = q1 / 15;
		q1 = Math.sqrt(q1);
		q2 = q2 / 15;
		q2 = Math.sqrt(q2);

		//Calcul MATRICE centree reduite

		for(int i = 0; i < 15; i++) {
			int k = 0;
			m3[i][k] = m1[i][k] / q;
			k++;
			m3[i][k] = m1[i][k] / q1;
			k++;
			m3[i][k] = m1[i][k] / q2;
		}
		for(int i = 0; i < 15; i++) {
			
			m4[i][0] = m3[i][0] / Math.sqrt(15);
			
			m4[i][1] = m3[i][1] / Math.sqrt(15);
			
			m4[i][2] = m3[i][2] / Math.sqrt(15);
		}
		return m3;
	}
}
