import java.util.*;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        // return 배열 commands[i].length 크기로 정의
        int[] returnList = new int[commands.length];

        // array copy
        int[] array_copy = {};

        // array copy에서 commands[i][0]부터 commands[i][1]까지 자르고 정렬 Arrays.sort()
        for(int i=0; i<commands.length; i++) {
            array_copy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(array_copy);

            // 정렬한 수에서 commands[i][j]의 3번에 해당하는 수 반환
            returnList[i] = array_copy[commands[i][2]-1];
        }
        return returnList;
    }

}
