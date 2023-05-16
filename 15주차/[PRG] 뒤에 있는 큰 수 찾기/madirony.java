import java.util.*;
class Solution {
    static class Node{
        int num, idx;
        Node(int n, int i){
            this.num = n;
            this.idx = i;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            if(stack.isEmpty()){
                stack.push(new Node(numbers[i], i));
            }
            else{
                if(stack.peek().num < numbers[i]){
                    while(!stack.isEmpty()){
                        if(stack.peek().num < numbers[i]){
                            Node tmp = stack.pop();
                            answer[tmp.idx] = numbers[i];
                        }
                        else{
                            break;
                        }
                    }
                    
                }
                stack.push(new Node(numbers[i], i));
            }
        }
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            answer[tmp.idx] = -1;
        }
        return answer;
    }
}