package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1592_�����̿�ģ���� {

	static int [] map;
	static int n,m,l;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());//��� �޾Ҵ���
		l = Integer.parseInt(st.nextToken());//���°�� ������
		
		map = new int [n+1];
		int ans=0;
		
		map[1]=1;
		int index=1;
 		
		
		
		while(true) {
			
				
			if(map[index]==m) {
				break;
			}
				
			if(map[index]%2==1) {//Ȧ��
					
				index = index +l;
				
			}else if(map[index]%2==0) {//¦��
					
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
