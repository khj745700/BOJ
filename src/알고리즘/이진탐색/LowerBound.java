package 알고리즘.이진탐색;

public class LowerBound {
    /*
    정답 조건 중 가장 작은 값
     */
    public static void solution(int[] args, int target) {
        int[] arr = args;
        int end = arr.length - 1;
        int start = 0;


        while ( end > start ) {
            int mid =(end + start) / 2;

            if( target  <= arr[mid]) { // 여기가 정답 조건. 즉, 타겟보다 크거나 같으면
                end= mid;
            }else {
                start = mid + 1;
            }
        }

        System.out.println("Lower Bound start index : " + start + ", end Index : " + end + ", value : " + arr[start]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 6};
        //           0  1  2  3  4  5  6  7
        System.out.println("target : 3");
        LowerBound.solution(arr, 3);
        UpperBound.solution(arr, 3);
        BinarySearch.solution(arr, 3);

        System.out.println("target : 4");
        LowerBound.solution(arr, 4);
        UpperBound.solution(arr, 4);
        BinarySearch.solution(arr, 4);

        System.out.println("target : 5");
        LowerBound.solution(arr, 5);
        UpperBound.solution(arr, 5);
        BinarySearch.solution(arr, 5);

        System.out.println("target : 6");
        LowerBound.solution(arr, 6);
        UpperBound.solution(arr, 6);
        BinarySearch.solution(arr, 6);

        System.out.println("target : 7");
        LowerBound.solution(arr, 7);
        UpperBound.solution(arr, 7);
        BinarySearch.solution(arr, 7);
    }
}

class UpperBound {
    /*
        정답 조건 중 가장 큰 값
     */
    public static void solution(int[] args, int target) {
        int[] arr = args;
        int end = arr.length;
        int start = 0;

        while ( end - start > 1) {
            int mid = (start + end) / 2 ;

        if(arr[mid] <= target) { //정답 조건, 타겟보다 작거나 같으면, 즉 같은값이 제일 큰 값
                start = mid + 1;
            }else {
                end = mid;
            }

        }

        System.out.println("Upper Bound start index : " + start + ", end Index : " + end + ", value : " + arr[start]);
    }
}


class BinarySearch {
    public static void solution(int[] args, int target) {
        int[] arr = args;
        int end = arr.length -1 ;
        int start = 0;

        while ( start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target) {
                System.out.println("BinarySearch start index : " + start + ", end Index : " + end + ", value : " + arr[mid]);
                return;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("BinarySearch start index : " + start + ", end Index : " + end + ", value : " + arr[start]);
    }
}
