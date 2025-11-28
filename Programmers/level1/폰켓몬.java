import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        // foreach nums[] set에 put
        for(int i : nums){
            set.add(i);
        }

        // 많더라도 최댓값만 return -> if(set의 사이즈 <= 마리수) return size
        // if(set의 사이즈 > 마리수) return 마리수
        if(set.size() <= num){
            return set.size();
        }

        return num;
    }
}
