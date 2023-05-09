import java.util.*;
class Solution {
    static ArrayList<Car> list = new ArrayList<>();
    static class Car implements Comparable<Car>{
        String time;
        String carNumber;
        boolean check;
        int min = 0;
        int sum = 0;
        Car(String time, String carNumber, boolean check){
            this.time = time;
            this.carNumber = carNumber;
            this.check = check;
        }
        public int compareTo(Car o){
            return(this.carNumber.compareTo(o.carNumber));
        }
    }
    public int[] solution(int[] fees, String[] records) {
        for(int i = 0; i < records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i], " ");
            String t = st.nextToken(); String n = st.nextToken();
            String c = st.nextToken();
            if(c.equals("IN")){
                boolean flag = false;
                for(Car tmp : list){
                    if(n.equals(tmp.carNumber) && !tmp.check){
                        tmp.time = t;
                        tmp.check = flag = true;
                        break;
                    }
                }
                if(!flag)
                    list.add(new Car(t, n, true));
            }
            else if(c.equals("OUT")){
                for(Car tmp : list){
                    if(n.equals(tmp.carNumber)){
                        StringTokenizer st2 = new StringTokenizer(t, ":");
                        int outTime = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
                        st2 = new StringTokenizer(tmp.time, ":");
                        int inTime = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
                        tmp.min += outTime-inTime;
                        tmp.check = false;
                        break;
                    }
                }
            }
        }
        //23:59에 출차하지 않은 차량 시간 정산
        plus();
        sum(fees);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).sum;
        }
        return answer;
    }
    //요금 계산
    static void sum(int[] fees){
        for(Car tmp : list){
            if(tmp.min <= fees[0]){
                tmp.sum = fees[1];
            }
            else{
                tmp.sum = fees[1] + (int)Math.ceil((tmp.min - fees[0])/(double)fees[2]) * fees[3];
            }
        }
    }
    //마감 시간 정산
    static void plus(){
        for(Car tmp : list){
            if(tmp.check){
                StringTokenizer st2 = new StringTokenizer(tmp.time, ":");
                int inTime = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
                tmp.min += 1439 - inTime;
            }
        }
    }
}