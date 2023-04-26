import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static long m = -1, money = 0;
    static long[] aArr, bArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 마지막 유효성 check arr
        aArr = new long[n]; bArr = new long[n];

        //input받을 때도 한번씩 check
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
            aArr[i] = a; bArr[i] = b;
            //입금
            if(0 < a) {
                //기존 금액 + 입금액 = b -> 유효 로그
                if(money + a != b)
                    exit();
                money += a;
            }
            //출금
            else if(a < 0){
                if(money < (a*-1)){
                    //tmp : 일단,
                    long tmp = (a * -1) + b;
                    tmp -= money; // 기존 잔고를 빼면 -> m의 배수 나옴
                    if(m == -1)
                        m = tmp;
                    else
                        m = GCD(m, tmp);
                    //m 값이 1인 경우, 기존 잔고와 현재 잔고가 같은지 check
                    if(m == 1){
                        // 다르면, exit
                        if(money != b)
                            exit();
                    }
                    money = b;
                }
                else {
                    //출금 후, 잔고도 check
                    if(money + a != b)
                        exit();
                    money += a;
                }
            }
        }
        //m 유효성 check
        mCheck();
        //충전이 없었을 때는, 임의의 양수 아무거나
        if(m == -1)
            m = 1;
        System.out.println(m);
    }
    public static void mCheck(){
        //입금 유효성 check : 입력 받을 때 검사해서 안해도 됨
        //출금 : 기존 값에서 m을 더한 값이 b보다 커야 유효함
        long tmpMoney = 0;
        for(int i = 0; i < n; i++){
            if(0 < aArr[i])
                tmpMoney = bArr[i];
            else{
                if(tmpMoney < aArr[i] * -1){
                    if(m == 1){
                        if(tmpMoney != bArr[i])
                            exit();
                    }
                    else{
                        long tmp2 = aArr[i] * -1 - tmpMoney;
                        if(m <= tmp2) {
                            if(tmp2 % m == 0 && bArr[i] != 0){
                                exit();
                            }
                            else if (tmp2 % m != 0 && bArr[i] != m - tmp2 % m) {
                                exit();
                            }
                        }
                        else {
                            if (bArr[i] != m - tmp2)
                                exit();
                        }
                    }
                    tmpMoney = bArr[i];
                }
                else{
                    if(tmpMoney + aArr[i] != bArr[i])
                        exit();
                    tmpMoney = bArr[i];
                }
            }
        }
    }
    //종료
    public static void exit(){
        System.out.println("-1");
        System.exit(0);
    }

    //m 구하기 (최대 공약수)
    public static long GCD(long a, long b){
        long min = Long.min(a, b);
        long max = Long.max(a, b);
        while(0 < min){
            long tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }
}