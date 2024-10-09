#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int p;
    cin >> p;  // 테스트 케이스 개수

    // priority_queue <int> pq; => 기본은 내림차순,, 큰 수 부터
    priority_queue<int, vector<int>, greater<int>> pq;

    int a;
    for (int i = 0; i < p; i++) {
        cin >> a;
        if (a == 0) {
            if (pq.empty()) cout << "0" << "\n";
            else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
        else pq.push(a);
    }

    return 0;
}
