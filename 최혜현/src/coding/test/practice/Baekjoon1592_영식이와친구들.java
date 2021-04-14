package coding.test.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1592_�����̿�ģ���� {

	static int [] map;
	static int n;
	static int m;
	static int l;
	static int ans=0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());//��� �޾Ҵ���
		l = Integer.parseInt(st.nextToken());//���°�� ������
		
		map = new int [n+1];
		int index=0;
 		
		while(true) {
			
			   map[index]++;
				
				if(map[index]==m) {
					break;
				}
				
				if(map[index]%2==1) {//Ȧ��
					
					if(index-l<0) {
						index = n-l+index;
					}else {
						index = index-l;
					}
					
				}else if(map[index]%2==0) {//¦��
					
					if(index+l>=m) {
						index = l-n+index;
					}else {
						index = index +l;
					}
				}
				
				ans++;
				
		}
		
		System.out.println(ans);
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
