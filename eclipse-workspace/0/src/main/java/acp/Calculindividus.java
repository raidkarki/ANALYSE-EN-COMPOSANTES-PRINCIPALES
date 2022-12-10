package acp;
import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class Calculindividus {

	
	
	
	
	public double[][] getindividu(double [][] m1){
		//MATRICE POUR TRANSPOSER
		double [][] mt=new double [3][15];
		//MATRICE DES INDIVIDUS
		double [][] mat=new double [15][3];
		//MATRICE CENTRE NORMEE
		double [][] mn=new Calculcentreenorme(m1).m1;
		//MATRICE DE CORRELATION
		double [][] mb=new double [3][3];
		//TRANSPOSER
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 15; k++) {
				mt[i][k] = mn[k][i];
			}
		}
		//MULTIPLER LES MATRICES  
for(int k = 0; k < 3; k++) {
			
			
			for(int l = 0; l < 3; l++) {
				
				
				mb[k][l] = 0;
				for(int i = 0; i < 15; i++) {
					mb[k][l] = mb[k][l] + mt[k][i] * mn[i][l];
				}
			}
		}
Matrix v=new Matrix(mb);
EigenvalueDecomposition n=v.eig();	

Matrix ma=n.getV();
Matrix maT=ma.inverse();
double[][] matriceT=maT.getArrayCopy();


//tries de vecteurs
for(int k=0;k<3;k++) {
	for(int i=0;i<3;i++)
	 {
	 double max = matriceT[k][i];
	 int rgmax = i;
	 for(int j=i+1;j<3;j++)
	  {
	  if(max<matriceT[k][j])
	    {
	    max=matriceT[k][j];
	    rgmax=j;
	    }
	  }
	 matriceT[k][rgmax]=matriceT[k][i];
	 matriceT[k][i]=max;
	  }
}
for(int i =0;i<3;i++) {
	
	
	
	System.out.printf("%f   %f    %f \n",matriceT[i][0],matriceT[i][1],matriceT[i][2]);


}
for(int k=0;k<15;k++) {
	int f=2;
	for(int i=0;i<3;i++) {
	
		for(int b=0;b<3;b++) {
			mat[k][i]=mat[k][i]+mn[k][b]*matriceT[f][b];
			}
		f--;
		
	}
	
}
for(int i =0;i<15;i++) {
	
	
		
		System.out.printf("%f   %f    %f \n",mat[i][0],mat[i][1],mat[i][2]);
	
	
}

return mat;
		
	}
	
	

	public double[][] getcoordones(double [][] m1){
		//MATRICE POUR TRANSPOSER
		double [][] mt=new double [3][15];
		//MATRICE DES INDIVIDUS
		double [][] mat=new double [15][3];
		double [][] lastmat=new double [3][3];
		//MATRICE CENTRE NORMEE
		double [][] mn=new Calculcentreenorme(m1).m1;
		//MATRICE DE CORRELATION
		double [][] mb=new double [3][3];
		//TRANSPOSER
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 15; k++) {
				mt[i][k] = mn[k][i];
			}
		}
		//MULTIPLER LES MATRICES  
for(int k = 0; k < 3; k++) {
			
			
			for(int l = 0; l < 3; l++) {
				
				
				mb[k][l] = 0;
				for(int i = 0; i < 15; i++) {
					mb[k][l] = mb[k][l] + mt[k][i] * mn[i][l];
				}
			}
		}
Matrix v=new Matrix(mb);
EigenvalueDecomposition n=v.eig();	



Matrix mi=n.getD();
double[][] v1=mi.getArrayCopy();


Matrix ma=n.getV();
Matrix maT=ma.inverse();
double[][] matriceT=maT.getArrayCopy();
double[][] matrice= ma.getArrayCopy();

//tries de vecteurs
for(int k=0;k<3;k++) {
	for(int i=0;i<3;i++)
	 {
	 double max = matriceT[k][i];
	 int rgmax = i;
	 for(int j=i+1;j<3;j++)
	  {
	  if(max<matriceT[k][j])
	    {
	    max=matriceT[k][j];
	    rgmax=j;
	    }
	  }
	 matriceT[k][rgmax]=matriceT[k][i];
	 matriceT[k][i]=max;
	  }
}
for(int k=0;k<15;k++) {
	int f=2;
	for(int i=0;i<3;i++) {
	
		for(int b=0;b<3;b++) {
			mat[k][i]=mat[k][i]+mn[k][b]*matriceT[f][b];
			}
		f--;
		
	}
	
}
//Calculer les variables
int j=2;
for(int i=0;i<3;i++) {
	
	for(int k=0;k<3;k++) {
		
		lastmat[k][i]=matrice[k][j]  *  Math.sqrt(v1[j][j]);
	}
	j--;
}
	return lastmat;	
	}
	
	
	
	
	
	
	
}
