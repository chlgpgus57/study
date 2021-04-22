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

public class Baekjoon2638_치즈2 {
	
	
	static int [][] map;
	static boolean [][] vi;
	static int cheese=0,hour=0;
	static int n,m;
	static ArrayList<Point> cheeseList= new ArrayList<Point>();
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	static void bfs() {//공기 검토하기
		
		Queue<Point> air = new LinkedList<Point>();
		
		map[0][0]=2; //외부공기를 2로 바꿈
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
				
				if(map[nx][ny]!=1&& !vi[nx][ny]) { //방문하지 않았고, 치즈가 아니면 =>공기
					
					air.add(new Point(nx,ny));
					map[nx][ny]=2;
					vi[nx][ny]=true;
					
				}
			}
			
		}
		
		
	}
	
	static void melting() { //치즈 녹이는 함수
		
		for(int i=0; i<cheeseList.size();i++) {
			
			int x = cheeseList.get(i).x; //치즈리스트 치즈의 x좌표
			int y = cheeseList.get(i).y; 
			
			int cnt =0; //2번이상 만나면 녹는 치즈 카운트
			
			for(int w=0; w<4; w++) {//공기 닿는 부분 상하좌우를 볼거임
				
				int nx = x+dx[w];
				int ny = y+dy[w];
				
				if(map[nx][ny]==2) {//외부공기면
					cnt++;
				}
			}
			
			if(cnt>=2) {//두 면 이상 만낫을때 치즈녹여
				
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
