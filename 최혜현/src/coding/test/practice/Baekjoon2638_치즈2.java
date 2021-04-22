package coding.test.practice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2638_ġ��2 {
	
	
	static int [][] map;
	static boolean [][] vi;
	static int cheese=0,hour=0;
	static int n,m;
	static ArrayList<Point> cheeseList= new ArrayList<Point>();
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	static void bfs() {//���� �����ϱ�
		
		Queue<Point> air = new LinkedList<Point>();
		
		map[0][0]=2; //�ܺΰ��⸦ 2�� �ٲ�
		vi[0][0]=true;
		air.add(new Point(0,0));
		
		while(!air.isEmpty()) {

			Point x = air.poll();
			
			for(int w=0; w<4; w++) {
				
				int nx = x.x+dx[w];
				int ny = x.y+dy[w];
				
				if(nx<0||nx>=n||ny<0||ny>=m) {
					continue;
				}
				
				if(map[nx][ny]!=1&& !vi[nx][ny]) { //�湮���� �ʾҰ�, ġ� �ƴϸ� =>����
					
					air.add(new Point(nx,ny));
					map[nx][ny]=2;
					vi[nx][ny]=true;
					
				}
			}
			
		}
		
		
	}
	
	static void melting() { //ġ�� ���̴� �Լ�
		
		for(int i=0; i<cheeseList.size();i++) {
			
			int x = cheeseList.get(i).x; //ġ���Ʈ ġ���� x��ǥ
			int y = cheeseList.get(i).y; 
			
			int cnt =0; //2���̻� ������ ��� ġ�� ī��Ʈ
			
			for(int w=0; w<4; w++) {//���� ��� �κ� �����¿츦 ������
				
				int nx = x+dx[w];
				int ny = y+dy[w];
				
				if(map[nx][ny]==2) {//�ܺΰ����
					cnt++;
				}
			}
			
			if(cnt>=2) {//�� �� �̻� �������� ġ��쿩
				
				cheese--;
				cheeseList.remove(i);
				map[x][y]=0;
				i--;
			}
			
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map = new int [n][m];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheese++;
					cheeseList.add(new Point(i,j));
				}
			}
		}
		
		while(cheese!=0) {
			hour++;
			vi= new boolean[n][m];
			bfs();
			melting();
		}
	
		System.out.println(hour);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
