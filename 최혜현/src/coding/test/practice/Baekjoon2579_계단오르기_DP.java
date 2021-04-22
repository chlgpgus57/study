package coding.test.practice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2579_계단오르기_DP {

	static int n;//계단수
	static int [] DP;
	static int [] map;
	
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		n = Integer.parseInt(br.readLine());
		
		map = new int [n+2];
		DP = new int [n+2];
		
		for(int i=0; i<n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			map [i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		DP[1] = map[1];
		DP[2] = Math.max(map[1]+map[2], map[2]);
		
		for(int i=3; i<=n; i++) {
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	

}
