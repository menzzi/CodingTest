import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		String grade[][] = new String[20][3];
		double sumGrade=0,sumScore=0;
		
		
		Scanner scan = new Scanner(System.in);
		
		
		
		for(int i=0;i<20;i++) {
			StringTokenizer st = new StringTokenizer(scan.nextLine()," ");
			
			grade[i][0] = st.nextToken();
			grade[i][1] = st.nextToken();
			grade[i][2] = st.nextToken();
			
			if(!grade[i][2].equals("P")) {
				sumGrade += Double.parseDouble(grade[i][1]);
				sumScore += calGrade(Double.parseDouble(grade[i][1]),grade[i][2]);
				
			}
		}
		if(sumScore!=0) {
			System.out.printf("%.6f\n",sumScore/sumGrade);
		}else {
			System.out.println(0.000000);
		}
	}
	private static double calGrade(double score, String grade) {
		double sum = 0;
		String g = grade;
		
		switch(g) {
		case "A+":
			sum = score * 4.5;
			break;
		case "A0":
			sum = score * 4.0;
			break;
		case "B+":
			sum = score * 3.5;
			break;
		case "B0":
			sum = score * 3.0;
			break;
		case "C+":
			sum = score * 2.5;
			break;
		case "C0":
			sum = score * 2.0;
			break;
		case "D+":
			sum = score * 1.5;
			break;
		case "D0":
			sum = score * 1.0;
			break;
		case "F":
			sum = score * 0.0;
			break;
		}
		return sum;
	}
}