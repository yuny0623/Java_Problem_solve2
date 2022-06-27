package Leetcode;
import java.util.*; 
/**
 * Runtime: 31 ms, faster than 5.12% of Java online submissions for Lucky Numbers in a Matrix.
Memory Usage: 51.7 MB, less than 6.86% of Java online submissions for Lucky Numbers in a Matrix.
 * 
 * 코멘트: 
 * 쉬운 문제임. row에서 한번 min값을 찾아주고 col에서 한번 max 값을 찾아주면 됨. 
 * 근데 이거 코드 보면 지금 for문을 굳이 두번 돌려주고 있다. 물론 빅오에서는 지수가 늘어나느게
 * 아니라서 별 차이 없겠지만 그래도 for문 한번 돌리는걸로 선형 시간을 감축시킬 수 있지 않을까?
 * 
 * 이거 for문 한번 돌고 끝내는걸로 바꿔봅시다. 
 */
public class leetcode_1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // ~ 133 ~ 0140 
        // row 에서는 min 인데 
        // col 에서는 max 인 숫자는 luckyNumber 이다. 이걸 순서상관없이 리턴해라. 
        
        List<Integer> luckyNumber_row = new ArrayList<Integer>(); 
        for(int i = 0; i<matrix.length; i++){
            int min = 100001; 
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j]; 
                }
            }
            luckyNumber_row.add(min); 
        }
        for(int val: luckyNumber_row){
            System.out.printf("%d ", val);
        }
        List<Integer> luckyNumber = new ArrayList<>(); 
        for(int i = 0; i<matrix[0].length; i++){
            int max = 0;
            for(int j = 0; j<matrix.length; j++){
                if(matrix[j][i] > max){
                    max = matrix[j][i]; 
                }
            }
            if(luckyNumber_row.contains(max)){
                luckyNumber.add(max); 
            }
        }
        
        return luckyNumber;
    }
}
