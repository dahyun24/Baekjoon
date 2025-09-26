class Solution {
    static int count;
    static int target;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        Solution.target = target;
        dfs(numbers, 0, 0);
        return count;
    }
    
    static void dfs(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(numbers, index+1, sum + numbers[index]);
        dfs(numbers, index+1, sum - numbers[index]);  

    }
}