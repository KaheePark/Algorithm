public class Merge_Sort_Study {
// O(N log N)
    private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort(int[] a){
        sorted = new int[a.length]; // 임시배열 파라미터 배열크기만큼 생성
        merge_sort(a, 0, a.length -1); // 재귀함수, 파라미터로 받은 배열이 길이가 1이 될때까지 계속 분할하기
        sorted = null; // 임시배열 초기화
    }

    // Top-Down 방식
    // 재귀함수로 호출할 메서드 오버라이딩
    private static void merge_sort(int[] a, int left, int right){

        // left == right 인 경우는 원소가 1개인 경우를 말한다. 즉 길이가 1이라 더이상 쪼갤수없으므로 return
        if(left == right) return;
        int mid = (left + right) / 2;   // 배열의 중간 위치

        // 배열 길이가 1이 될때까지 divide
        merge_sort(a, left, mid);   // 절반으로 나눠 왼쪽의 부분리스트 (가장 왼쪽 ~ 중간 까지)
        merge_sort(a, mid+1, right);  // 절반으로 나눠 오른쪽의 부분리스트 (중간+1 ~ 가장 오른쪽 까지)

        // 나눈 배열을 conquer
        merge(a, left, mid, right);
    }

    // BOTTOM-UP 방식
    /**
    private static void merge_sort(int[] a, int left, int right){

        for(int size=1; size <= right; size += size){
            for(int l = 0; l <= right - size; l += (2 * size)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (2 * size) - 1, right);
                merge(a, low, mid, high);		// 병합작업
            }
        }
    }
    **/



    // 나눠진 배열을 정렬하면서 병합하는 메소드
    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;   // 왼쪽 부분리스트의 시작점
        int r = mid + 1;  // 오른쪽 부분리스트의 시작점
        int idx = left; // 비교하면서 하나씩 늘려갈 인덱스 (채워넣을 배열의 인덱스)

        while (l <= mid && r <= right) {
            // 왼쪽 부분리스트의 시작 원소가 오른쪽 부분리스트의 시작 원소보다 작거나 같을때
            // 더 작은수인 왼쪽 부분리스트의 시작 원소를 새 배열에 넣고 새 배열의 인덱스 1 증가시키기
            // (거기로 그다음 정렬 원소를 넣어야 하니까)
            // 그 다음 left 1 증가시켜 다음 원소 비교로 이동
            if(a[l] <= a[r]){
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            // 오른쪽 부분리스트의 시작 원소가 왼쪽 부분리스트의 시작 원소보다 작거나 같을때
            // 더 작은수인 오른쪽 부분리스트의 시작 원소를 새 배열에 넣고 새 배열의 인덱스 1 증가시키기
            // (거기로 그다음 정렬 원소를 넣어야 하니까)
            // 그 다음 right 1 증가시켜 다음 원소 비교로 이동
            if(a[r] <= a[l]){
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }


        // 왼쪽 부분리스트가 먼저 새 배열에 채워졌을 경우 : l > mid
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        if(l > mid){
            while(r <= right){
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        // 오른쪽 부분리스트가 먼저 새 배열에 채워졌을 경우 : r > right
        // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        else {
            while(l <= mid){
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        // 정렬된 새 배열을 기존의 배열에 복사해서 옮긴다.
        for(int i=left; i<=right; i++){
            a[i] = sorted[i];
        }
    }
}
