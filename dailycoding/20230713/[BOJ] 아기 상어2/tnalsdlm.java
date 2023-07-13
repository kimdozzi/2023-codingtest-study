import java.io.*;
import java.util.*;


public class Main {
	static class Point{
		int r;
		int c;
		int dist;
		
		public Point(int r, int c, int dist) {
			this.r = r;
			this.c =c;
			this.dist = dist;
		}
	}

	static int[][] map;
	static boolean[][] v;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					map[i][j] = -1;
				}
			}
		}
		
		que = new LinkedList<>();
		for(int r=0;r<N;r++) {
			for(int c =0; c<M;c++) {
				if(map[r][c] == -1) {
					v = new boolean[N][M];
					v[r][c] = true;
					que.offer(new Point(r,c,0));
					bfs();
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		System.out.println(max);
	}
	static Queue<Point> que;

    static int[] dr = {-1,1,0,0,1,1,-1,-1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	private static void bfs() {
		while(!que.isEmpty()) {
			Point cur = que.poll();
			
			for(int d=0;d<8;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(!check(nr,nc)) continue;
				
				if(!v[nr][nc]&&map[nr][nc]!=-1) {
					if(map[nr][nc]==0) {
						map[nr][nc] = cur.dist+1;						
					}else {
						map[nr][nc] = Math.min(cur.dist+1,map[nr][nc]);
					}
					v[nr][nc] = true;
					que.offer(new Point(nr,nc,map[nr][nc]));
                    
				}
			}
		}
		
	}
	
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
}
