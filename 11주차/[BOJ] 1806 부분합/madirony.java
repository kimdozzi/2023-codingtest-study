import java.util.*;
import java.io.*;
public class Main {
	static int n, s, x = 0, y = 0, sum = 0, cnt = 0, min = Integer.MAX_VALUE;
	static int[] arr;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	n = Integer.parseInt(st.nextToken()); s = Integer.parseInt(st.nextToken());
    	arr = new int[n];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < n; i++)
    		arr[i] = Integer.parseInt(st.nextToken());
		func();
		if(min == Integer.MAX_VALUE)
			min = 0;
    	System.out.println(min);
    }
    static void func() {
    	while(x < n) {
    		if(s <= sum || y == n) {
    			if(y == n) {
    				if(sum == s) {
    					min = Math.min(min, y-x);
    				}
    				sum -= arr[x++];
    			}
    			else {
	    			min = Math.min(min, y-x);
	    			sum -= arr[x++];
    			}
    		}
    		else
    			sum += arr[y++];
    	}
    }
}