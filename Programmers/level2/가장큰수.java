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

        // 문자열 붙여서 비교 후 내림차순 정렬
        Arrays.sort(number_tmp, (a, b) -> (b+a).compareTo(a+b));

        // 붙힌 후 숫자로 변환
        for(int i=0; i<number_tmp.length; i++){
            sb.append(number_tmp[i]);
        }
        answer = sb.toString();

        if(answer.startsWith("0")){
            answer = "0";
        }

        return answer;
    }

}
