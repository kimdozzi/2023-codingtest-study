import java.util.*;

class Solution {
    static Stack<Integer> stk = new Stack<>();

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stk.isEmpty()) {
                if (stk.peek() > numbers[i]) {
                    answer[i] = stk.peek();
                    break;
                } else
                    stk.pop();
            }

            if (stk.isEmpty())
                answer[i] = -1;

            stk.push(numbers[i]);
        }
        return answer;

    }
}