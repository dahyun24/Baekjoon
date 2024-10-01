#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> q; // 내림차순 우선순위 큐 구현
    for (int i=0; i<scoville.size();i++){
        q.push(scoville[i]);
    }
    bool all_up = false;
    while(!all_up){
        if (q.size()==1 && q.top()<K) { answer = -1; break; }
        else{
            // 가장 작은 수가 K 이상이라면 전체 q는 K 이상인것
            if (q.top()>=K) all_up=true;
            else {
                int sum = 0;
                int a = q.top();
                q.pop();
                int b = q.top();
                q.pop();
                sum = a + 2*b;
                q.push(sum);
                answer++;
            } 
        }
    }
    return answer;
}