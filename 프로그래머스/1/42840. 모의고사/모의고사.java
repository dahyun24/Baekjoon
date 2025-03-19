import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        int[][] arr = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        int[] scores = new int[3];

        for (int i=0;i<3;i++){
            for (int j=0;j<answers.length;j++){
                if (answers[j] == arr[i][j%arr[i].length]){
                    scores[i]++;
                }
            }
        }
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<3;i++){
            if (scores[i] == maxScore){
                list.add(i+1);
            }
        }        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
}