package acp;

public class Calculcentre {
	double [][] centre=new double [15][3];
	public Calculcentre(double [][] m1) {
		
		this.centre=Calculcentr(m1);
		
	}
	
 	public  double[][] Calculcentr(double [][] m1) {
		float s = 0, s1 = 0, s2 = 0;
		double[][] m2=new double[15][3];
		for(int i = 0; i < 15; i++) {
			s +=  m1[i][0];
			s1 += m1[i][1];
			s2 += m1[i][2];
		}
		float mo = s / 15;
		float mo1 = s1 / 15;
		float mo2 = s2 / 15;
		//Calcul matrice 2
		for(int i = 0; i < 15; i++) {
			int k = 0;
			m2[i][k] = m1[i][k] - mo;
			k++;
			m2[i][k] = m1[i][k] - mo1;
			k++;
			m2[i][k] = m1[i][k] - mo2;
		}
		
		return m2;
	}
 	
}
