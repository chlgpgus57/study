package coding.test.practice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562_나이트의이동_BFS {

	
	static int [][] vi= new int [301][301];
	static int n;
	static int [] dx = {2,2,1,1,-2,-2,-1,-1};
	static int [] dy = {1,-1,2,-2,1,-1,2,-2};
	
	
	static int x,y;
	static int x2,y2;
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<t; i++) {	
			
			 st = new StringTokenizer(br.readLine());
	         n = Integer.parseInt(st.nextToken());

	         st = new StringTokenizer(br.readLine());
	         x = Integer.parseInt(st.nextToken());
	         y = Integer.parseInt(st.nextToken());

	         st = new StringTokenizer(br.readLine());
	         x2 = Integer.parseInt(st.nextToken());
	         y2 = Integer.parseInt(st.nextToken());

	         for(int a=0; a<=300; a++) {
	        	for(int b=0; b<=300; b++) {
	        		vi[a][b]=-1;
	        	}
	         }
			
			 bfs(x,y,x2,y2,n);
			 bw.write(vi[x2][y2]+"\n");
		}
			
			
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	
	public static void bfs(int a, int b, int c, int d,int n) {
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(a,b));
		vi[a][b]=0;
		
		while(!q.isEmpty()) {
			
			Point x = q.poll();
			
			if(vi[x.x][x.y]==vi[c][d]) {
				break;
			}
			
			for(int w =0; w<8; w++) {
				
				int nx = x.x+dx[w];
				int ny = x.y+dy[w];
				
				if(nx<0||nx>=n||ny<0||ny>=n) {
					continue;
				}
				
				if(vi[nx][ny]==-1||vi[x.x][x.y]+1<vi[nx][ny]) {
					vi[nx][ny] = vi[x.x][x.y]+1;
					q.add(new Point(nx,ny));
				}
				
				
				
			}
			
			
		}
		
		
		
	}

}
