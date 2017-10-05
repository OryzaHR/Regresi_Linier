import java.io.*;
public class regresi_linier{
	public static void main (String[]args){
		double x1[] = new double[10];
		double x2[] = new double[10];
		double y1[] = new double[10];
		double y2[] = new double[10];
		double y3[] = new double[10];
		double xy[] = new double[10];
		double err[] = new double[10];
		double hasil, ex1 = 0, ey1 = 0, ex2 = 0, ey2 = 0, exy = 0, ee = 0, ey3=0;
		int i, j, n;
		double m = 0, c = 0;
		
		System.out.println("Tugas Mata Kuliah Metode Numerik : Regresi Linier");
		try{
			System.out.print("Masukkan jumlah iterasi : ");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(input.readLine());
			for(i = 1; i <= n; i++){
				System.out.print("Masukkan nilai x"+i+" :");
				BufferedReader inputx1 = new BufferedReader(new InputStreamReader(System.in));
				x1[i] = Double.parseDouble(inputx1.readLine());
				
				System.out.print("Masukkan nilai y"+i+" :");
				BufferedReader inputy1 = new BufferedReader(new InputStreamReader(System.in));
				y1[i] = Double.parseDouble(inputy1.readLine());
			}
			
			System.out.print("|no|  x  |  y1  |  x1^2  |  y1^2  |  xy  |  err  |  y1^1  |\n");
			for (j = 1; j <= n; j++){
				// isi nilai var iterasi
				x2[j]		=x1[j]*x1[j];
				y2[j]		=y1[j]*y1[j];
				xy[j]		=x1[j]*y1[j];
				// isi jumlah keseluruhan
				ex1= ex1+x1[j];
				ey3= ey3+y1[j];
				exy= exy+xy[j];
				ex2= ex2+x2[j];
				ey2= ey2+y2[j];
				//hitungan m dan c
				m= ((n*exy)-(ex1*ey3))/((n*ex2)-(ex1*ex1));
				c= ((ey3*ex2)-(ex1*exy))/((n*ex2)-(ex1*ex1));
				
				y3[j]= m*x1[j]+c;
				err[j]= y3[j]-y3[j];	
				ee= ee+err[j];
				ey3= ey3+y3[j];
				//cek agar absolut
				if(c<=0){
					c=c*(-1);
				}
				if(y3[j]<0){
					y3[j]=y3[j]*(-1);
				}
				if(err[j]<0){
					err[j]=err[j]*(-1);
				}
				//cetak Nilai
				System.out.print("  "+j);
				System.out.print("  "+x1[j]);
				System.out.print("  "+y3[j]);
				System.out.print("  "+x2[j]);
				System.out.print("  "+y2[j]);
				System.out.print("  "+xy[j]);
				System.out.print("  "+err[j]);
				System.out.print("  \n"+y3[j]);
			}
			System.out.print("\nJumlah x1 = "+ex1+"\t");
			System.out.print("y1 = \t"+ey1);
			System.out.print("x1 ^ 2 = \t"+ex2);
			System.out.print("y1 ^ 2 = \t"+ey2);
			System.out.print("xy = \t"+exy);
			System.out.print("Error = \t"+ee);
			System.out.print("y1 ^ 2 = \t"+ey3);
			System.out.print("\n\nFungsinya\n F(x) = "+m+"(x) + "+c+"");
			System.out.print("\nMaka F("+n+") = "+m+"("+n+") + "+c+"");
			hasil = (m * n) + c;
			System.out.print("\nHasil : +-"+hasil);
		}catch(IOException io){
			System.out.print("err : " +io.getMessage());
		}
	}
}