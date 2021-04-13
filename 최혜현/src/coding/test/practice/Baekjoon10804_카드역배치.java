package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon10804_카드역배치 {


	static ArrayList<Integer> ar2 = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=1; i<=20; i++) {
			ar2.add(i);
		}
		
		
		for(int i=0; i<10; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for(int j =b-1; j>=a-1; j--) {
				temp.add(ar2.get(j));
			}
			
			int cnt = 0;
			for(int j =a-1; j<=b-1; j++) {
				ar2.set(j, temp.get(cnt));
				cnt++;
			}
		}
		
		for(int i=0; i<20; i++) {
			System.out.print(ar2.get(i)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
