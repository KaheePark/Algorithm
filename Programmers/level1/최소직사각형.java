import java.lang.Math;
public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int h = 0;
        int w = 0;

        // (배열에서 가장 큰수) * (배열에서 가장 작은수 중에서 가장 큰수)
        for(int i=0; i<sizes.length; i++){
            h = Math.max(h, Math.max(sizes[i][0], sizes[i][1]));
            w = Math.max(w, Math.min(sizes[i][0], sizes[i][1]));
        }

        return w * h;
    }
}
