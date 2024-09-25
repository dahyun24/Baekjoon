#include<iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    priority_queue <int> que; // 기본적인 내림차순 우선순위 큐 사용
    // 오름차순 우선순위 큐 : priority_queue<int, vector<int>, greater<int>> pq_greater;

    queue<int> result;

    int total;
    cin >> total;
    for (int i = 0; i < total; i++) {
        int a;
        cin >> a;
        if (a == 0) { // 0이면 현재 큐에서 가장 높은 가치 출력 혹은 큐가 비어있으면 -1 출력
            if (!que.empty()) { // if not empty -> top
                result.push(que.top());
                que.pop();
            }
            else result.push(-1);
        }
        else {
            int b;
            for (int i = 0; i < a; i++) {
                cin >> b;
                que.push(b);
            }
        }
    }

    while (!result.empty()) {
        cout << result.front() << endl;
        result.pop();
    }

    return 0;
}