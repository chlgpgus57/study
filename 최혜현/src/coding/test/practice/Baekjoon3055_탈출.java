package coding.test.practice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3055_≈ª√‚ {

	
	static int R;
	static int C;
	static boolean [][] vi;
	static char [][] map;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] st = br.readLine().split(" ");
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		
		vi = new boolean [R][C];
		map = new char [R][C];
		
		Queue<Point> water = new LinkedList<Point>();
		Queue<Point> gosum = new LinkedList<Point>();
		
		for(int i=0; i<R; i++) {
			
			String s = br.readLine();
			
			for(int j=0; j<C; j++) {
			
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == '*') {
					water.add(new Point(i,j));
				}else if(map[i][j] == 'S') {
					gosum.add(new Point(i,j));
				}
				
			}
		}
		
		
		int cnt =0;
		
		int [] dx = {1,-1,0,0};
		int [] dy = {0,0,1,-1};
		
		
		while(!water.isEmpty()) {
			
			Point x = water.poll();
			
			
			
			for(int w =0; w<4; w++) {
				
				int nx = x.x + dx[w];
				int ny = x.y + dy[w];
				
				if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]=='.') {
					map[nx][ny]='*';
					water.add(new Point(nx, ny));
				}
				
			}
		}
		
		
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
