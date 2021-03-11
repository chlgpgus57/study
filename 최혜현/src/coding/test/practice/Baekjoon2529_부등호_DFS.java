package coding.test.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2529_∫ŒµÓ»£_DFS {

	
	public static boolean check(int a, int b, char c) {
		if(c=='<') {
			if(a>b) {
				return false;
			}else if(c=='>') {
				return false;
			}
		}
		return true;
		
	}
	
	public static void dfs(int cnt, String num) {
		
		if(cnt == n+1) {
			ar.add(num);
			return;
		}
		
		for(int i=0; i<=9; i++) {
			
			if(!vi[i]) {
				vi[i]=true;
				dfs(cnt+1, st);
				vi[i]=false;
			}
			
		}
		
		
		
	}
	
	
	private static char[] map;
	private static int n;
	private static boolean[] vi;
	private static ArrayList<String> ar = new ArrayList<String>();
	private static String st;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		map = new char[10];
		vi = new boolean[10];

		n = sc.nextInt();

		
		for(int i =0; i<n; i++) {
			map[i]=sc.next().charAt(0);
			vi[i] = false;
		}
		
	
		dfs(0, "");
		Collections.sort(ar);
		
		
		
		System.out.print(ar.get(ar.size()-1));
		System.out.println(ar.get(0));
		
		
	}

}
