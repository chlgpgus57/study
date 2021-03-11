package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon14889_스타트와링크 {

	
	static int n;
	static int [][] map;
	static int ans=(int) Double.MAX_VALUE;
	static boolean [] vi;
	
	
	public static void dfs(int p, int cnt) {
		
		//false = start, true = link
		
		int start=0;
		int link=0;
		
		if(cnt == n/2) {
		
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
						
					if(vi[i]==false && vi[j]==false) {
						start = start + map[i][j];
					}else if(vi[i]==true && vi[j]==true) {
						link = link + map[i][j];
					}
				}
			}
			int cha = Math.abs(start-link);
			
			ans = Math.min(cha, ans);
			return;
		}
		
		for(int i=p; i<n; i++) {
				
			if(!vi[i]) {
				vi[i] =true;
				dfs(i,cnt+1);
				vi[i] =false;
			}
				
		}
			
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		vi = new boolean [n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<n; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		dfs(0,0);
		bw.write(ans+"\n");
		
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
