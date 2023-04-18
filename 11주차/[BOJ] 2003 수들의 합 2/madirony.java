import java.util.*;
import java.io.*;
public class Main {
	static int n, m, x = 0, y = 0, sum = 0, cnt = 0;
	static int[] arr;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
    	arr = new int[n];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < n; i++)
    		arr[i] = Integer.parseInt(st.nextToken());
		func();
    	System.out.println(cnt);
    }
    static void func() {
    	while(x < n) {
    		if(m < sum || y == n)
    			sum -= arr[x++];
    		else
    			sum += arr[y++];
    		if(m == sum)
    			cnt++;
    	}
    }
    
}