package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1592_영식이와친구들 {

	static int [] map;
	static int n,m,l;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());//몇번 받았는지
		l = Integer.parseInt(st.nextToken());//몇번째로 던질지
		
		map = new int [n+1];
		int ans=0;
		
		map[1]=1;
		int index=1;
 		
		
		
		while(true) {
			
				
			if(map[index]==m) {
				break;
			}
				
			if(map[index]%2==1) {//홀수
					
				index = index +l;
				
			}else if(map[index]%2==0) {//짝수
					
				index = index -l;
			}
			
			if(index>n) {
				index %= n;
			}else if(index<1) {
				index+=n;
			}
				
			map[index]++;
			ans++;
				
		}
		
		System.out.println(ans);
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
