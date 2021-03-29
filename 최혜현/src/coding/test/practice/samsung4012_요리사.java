package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class samsung4012_¿ä¸®»ç {

	static int N=0;
	static int[][] map;
	static boolean[] vi;
	static int ans = Double.MAX_EXPONENT;
	static int t=0;
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	
	public static void dfs(int p, int cnt) {
		
		int a=0;
		int b=0;
		
		if(cnt == N/2) {
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(vi[i]==false && vi[j]==false) {
						a = a+map[i][j];
					}else if(vi[i]==true && vi[j]==true) {
						b = b+map[i][j];
					}
				}
			}
			int num = Math.abs(a-b);
			
			ans = Math.min(ans, num);
			
			
			
			return;
		}
		
		for(int i=p; i<N; i++) {
			if(!vi[i]) {
				vi[i] = true;
				dfs(i,cnt+1);
				vi[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		
		
		for(int c=1; c<=t; c++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int [N][N];
			vi = new boolean [20000];
			ans = 987654321;
			
			for(int i=0; i<N; i++) {
				
				st = new StringTokenizer(br.readLine()," ");
				
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			bw.write("#"+c+" "+ans+"\n");

			
		}
		
		
				
		bw.flush();
		bw.close();
		br.close();
	}

}
