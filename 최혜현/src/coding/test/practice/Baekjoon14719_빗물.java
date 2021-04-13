package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon14719_ºø¹° {

	static int [] block;
	static int ans=0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		block = new int [width];

		st = new StringTokenizer(br.readLine()," ");

		for(int i=0; i<width; i++) {
			
			block[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int [] left = new int [width];
		int [] right = new int [width];
		
		left[0] = block[0];
		
		for(int i=1; i<width; i++) {
			
			left[i]= Math.max(left[i-1], block[i]);
			
		}
		
		right[width-1] = block[width-1];
		
		for(int i=width-2; i>=0; i--) {
			
			right[i]= Math.max(right[i+1], block[i]);
			
		}
		
		for(int i=1; i<width; i++) {
			int x = Math.min(left[i], right[i]);
			ans  = ans+ x-block[i];
		}
		System.out.println(ans);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
