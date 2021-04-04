package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon15784_질투진서 {

	static int n;
	static int [][] map;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken()); //진서의 위치
		int b = Integer.parseInt(st.nextToken());
		
		map = new int [n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int jinseo = map[a][b];
		
		for(int i=0; i<=n; i++) {
			if(map[i][b]>map[a][b]) {
				jinseo = map[i][b];
			}
			
		}
		
		for(int i=0; i<=n; i++) {
			if(map[a][i]>map[a][b]) {
				jinseo = map[a][i];
			}
		}
		
		if(jinseo == map[a][b]) {
			bw.write("HAPPY"+"\n");
		}else {
			bw.write("ANGRY"+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
