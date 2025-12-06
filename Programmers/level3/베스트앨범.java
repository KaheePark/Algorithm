import java.util.*;
public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        // 1번 맵 -> {장르 : 총 재생횟수}, getOrDefault로 장르가 없다면 0, value 더하기
        Map<String, Integer> gmap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            gmap.put(genres[i], gmap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 1번 맵 list로 변환 후 plays 총합 내림차순 정렬
        List<Map.Entry<String, Integer>> glist = new ArrayList<>(gmap.entrySet());
        glist.sort((a, b) -> b.getValue() - a.getValue());

        // 2번 맵 -> {장르 : {고유번호 : 재생횟수}}
        Map<String, Map<Integer, Integer>> nmap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            nmap.putIfAbsent(genres[i], new HashMap<>()); // 없을때만 hashmap 새로생성
            nmap.get(genres[i]).put(i, plays[i]);   // {고유번호, 재생횟수} 넣기
        }

        // result 담을 리스트 생성
        List<Integer> result = new ArrayList<>();

        // 상위 2개 반환하기 위해 map을 정렬
        for (Map.Entry<String, Integer> genreEntry : glist) {
            String genre = genreEntry.getKey(); // 총 재생횟수 내림차순 정렬된 glist에서 key를 하나씩 꺼냄
            Map<Integer, Integer> song = nmap.get(genre); // key에 해당하는 고유번호, 재생횟수 map에 넣음 (장르 내림차순)

            // 리스트로 변환해서 {고유번호, 재생횟수}를 정렬
            List<Map.Entry<Integer, Integer>> songs = new ArrayList<>(song.entrySet());
            songs.sort((a, b) -> {
                int cnt = b.getValue() - a.getValue(); // 내림차순 정렬
                if (cnt != 0) {   // 재생횟수가 다르다면 그대로 반환
                    return cnt;
                }
                return a.getKey() - b.getKey(); // 재생횟수가 같다면 고유번호(key) 오름차순 정렬
            });

            // 상위 2개만 result에 출력
            result.add(songs.get(0).getKey());
            if (songs.size() >= 2) {
                result.add(songs.get(1).getKey());
            }
        }

        // list -> [] 변환
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
