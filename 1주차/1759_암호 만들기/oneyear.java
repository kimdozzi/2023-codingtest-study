import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기 {

    static int L,C;
    static String [] str, result;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());  // R
        C = Integer.parseInt(st.nextToken());  // N

        str = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) str[i] = st.nextToken();

        Arrays.sort(str);
        visited = new boolean[C];
        result = new String[C];
        combination(0,0);

    }

    public static void combination(int idx, int cnt) {
        if(cnt==L) {
            String tmp="";
            int mo=0, ja=0;

            for(int i=0; i<L; i++) {
                if(result[i].equals("a") || result[i].equals("o") || result[i].equals("u")
                        || result[i].equals("i") || result[i].equals("e")) mo++;
                else ja++;

                tmp+=result[i];
            }
            if(mo>=1 && ja>=2) System.out.println(tmp);
        }

        for(int i=idx; i<C; i++) {
            if(visited[i]) continue;
            result[cnt]=str[i];
            visited[i]=true;
            combination(i+1,cnt+1);
            visited[i]=false;
        }
    }
}




/*
                다른 방법 2
 */

class Main {

    static int L,C;
    static String [] str, result, moeum={"a","e","o","u","i"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());  // R
        C = Integer.parseInt(st.nextToken());  // N

        str = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) str[i] = st.nextToken();

        Arrays.sort(str);
        result = new String[C];
        combination(0,0);

    }

    public static void combination(int idx, int cnt) {
        if(cnt==L) {
            String tmp="";
            boolean is=false;
            int mo=0, ja=0;

            for(int i=0; i<L; i++) {
                is = Arrays.stream(moeum).anyMatch(result[i]::equals);
                if(is) mo++; else ja++;
                tmp+=result[i];
            }


            if(mo>=1 && ja>=2) System.out.println(tmp);
        }

        for(int i=idx; i<C; i++) {
            result[cnt]=str[i];
            combination(i+1,cnt+1);
        }
    }
}
