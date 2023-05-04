import java.util.Arrays;
class Solution {
    static int[] agree = {0, 3, 2, 1, 0, 1, 2, 3};
    //R T / C F / J M / A N
    static int[] score = {0, 0, 0, 0, 0, 0, 0, 0};
    public String solution(String[] survey, int[] choices) {
        for(int i = 0; i < survey.length; i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if(choices[i] < 4){
                count(first, agree[choices[i]]);
            }
            else if(4 < choices[i]){
                count(second, agree[choices[i]]);
            }
        } 
        String answer = "";
        answer = mbti(answer);
        return answer;
    }
    static String mbti(String ans){
        char[] arr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(int i = 0; i < score.length; i+=2){
            if(score[i] < score[i+1])
                ans += arr[i+1];
            else
                ans += arr[i];
        }
        return ans;
    }
    static void count(char c, int num){
        switch(c){
            case 'R':
                score[0] += num;
                break;
            case 'T':
                score[1] += num;
                break;
            case 'C':
                score[2] += num;
                break;
            case 'F':
                score[3] += num;
                break;
            case 'J':
                score[4] += num;
                break;
            case 'M':
                score[5] += num;
                break;
            case 'A':
                score[6] += num;
                break;
            case 'N':
                score[7] += num;
                break;
        }
    }
}