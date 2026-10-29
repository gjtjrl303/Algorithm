import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {

            // 현재 값보다 작거나 같은 값은
            // 앞으로 최댓값 후보가 될 수 없으므로 제거
            while (!dq.isEmpty()
                    && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }

            // 현재 인덱스를 최댓값 후보에 추가
            dq.addLast(i);

            // 현재 길이 k 구간을 벗어난 인덱스 제거
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 길이 k인 구간이 완성되면
            // 현재 구간의 최댓값으로 정답 갱신
            if (i >= k - 1) {
                answer = Math.min(
                    answer,
                    stones[dq.peekFirst()]
                );
            }
        }

        return answer;
    }
}