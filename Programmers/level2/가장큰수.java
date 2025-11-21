import java.util.*;
public class 가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";
        String[] number_tmp = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        // numbers -> 문자열로 변경
        for(int i=0; i<numbers.length; i++){
            number_tmp[i] = String.valueOf(numbers[i]);
        }

        // 문자열끼리 이어붙여서 크기 비교 후 내림차순 정렬
        Arrays.sort(number_tmp, (a, b) -> (b+a).compareTo(a+b));

        // 배열 모두 붙이기
        for(int i=0; i<number_tmp.length; i++){
            sb.append(number_tmp[i]);
        }
        answer = sb.toString();

        // 배열이 모두 0인경우 "0" 반환
        if(answer.startsWith("0")){
            answer = "0";
        }

        return answer;
    }

}
