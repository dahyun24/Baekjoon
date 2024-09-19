#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1;
    // 1부터 n까지 배열 A 만들기
    vector<int> A(n);
    for (int i = 0; i < n; i++) {
        A[i] = i + 1;
    }

    int start = 0, end = 0; 
    int sum_val = 0;
    
    // 투 포인터 알고리즘
    while (end < n) {
        if (sum_val > n) {
            sum_val -= A[start];
            start++;
        } else if (sum_val < n) {
            sum_val += A[end];
            end++;
        } else {
            answer++;
            sum_val += A[end];
            end++;
        }
    }
    return answer;
}
