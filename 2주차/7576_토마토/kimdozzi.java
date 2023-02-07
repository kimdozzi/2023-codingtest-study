package samsungCodingTest.Week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int x; // 가로
    int y; // 세로

    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ7576 {

    static int M, N; // 가로, 세로
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static ArrayList<Integer>[] matrix; // 토마토 상자
    static boolean[][] visit; // 방문 체크

    static Queue<tomato> que; // 익은 토마토 좌표 넣기

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M]; // 세로 N, 가로 M만큼의 방문 체크 배열 초기화
        matrix = new ArrayList[N]; // 행의 개수만큼 생성
        for (int i = 0; i < N; i++) {
            matrix[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void bfs() {
        while (!que.isEmpty()) {
            tomato t = que.remove();
            int x = t.x;
            int y = t.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (visit[nx][ny])
                    continue;
                if (matrix[nx].get(ny) != 0)
                    continue;
                que.add(new tomato(nx, ny));
                visit[nx][ny] = true;
                matrix[nx].set(ny, matrix[x].get(y) + 1);
            }
        }
    }

    static void process() {
        /* TODO */
        // 익은 토마토 위치 찾기
        que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i].get(j) == 1) {
                    que.add(new tomato(i, j));
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        int mx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i].get(j) == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                mx = Math.max(matrix[i].get(j), mx);
            }
        }
        System.out.println(mx - 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
