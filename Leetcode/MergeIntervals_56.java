import java.util.*;
import java.lang.Math;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        // intervals 각 배열의 [0]을 기준으로 오름차순 정렬
        Arrays.sort(intervals, (o1, o2) -> { return o1[0] - o2[0]; });

        // 첫번째 배열의 1,2번을 start, end로 지정
        int start = intervals[0][0];
        int end = intervals[0][1];

        // 두번째 배열(i=1)부터 시작, 다음 배열의 [0]이 앞 배열의 [1]보다 작거나 같다면 overlapping
        // end를 다음배열의 [1]로 바꾸고, for문 끝나고 list.add 해준다.
        // for문은 [1] ~ intervals의 모든 배열을 돈다.
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]); // overlap이므로 기존 end와 다음 배열 중의 Max인 [1]로 end를 변경
            } else {
                // 다음 배열의 [0]이 앞 배열의 [1] 보다 크다면 overlap 되지 않은것이므로 해당 배열을 add
                list.add(new int[] {start, end});
                // start, end 갱신
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end}); // 변경된 end로 리스트에 넣기

        // 리턴할 배열 생성 [][2]
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
