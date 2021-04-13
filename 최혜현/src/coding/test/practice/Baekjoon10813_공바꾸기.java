package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon10813_���ٲٱ� {

	static int n;
	static int m;
	static int [] ar;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());//�ٱ��� ����
		m=Integer.parseInt(st.nextToken());//�ٲٴ� Ƚ��
		
		ar = new int [n];
		for(int i=0; i<n; i++) {
			ar[i] = i+1;
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int temp =0;
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			temp = ar[a-1];
			ar[a-1] = ar[b-1];
			ar[b-1] = temp;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(ar[i]+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
