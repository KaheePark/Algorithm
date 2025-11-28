import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // String 배열 정렬하기 Arrays.sort
        Arrays.sort(phone_book);

        // 인접한 두 문자열 중에 포함하는지 확인 
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}
