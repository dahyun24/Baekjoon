#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int arr[1000001];
int res[1000001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;  // 테스트 케이스 개수

    vector<int> vs;
    vs.resize(n);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        vs[i] = arr[i];
    }

    // unique 함수는 벡터 내에 중복되는 값을 뒤로 모아줌
    // erase를 통해 쓰레기값 지워주기
    sort(vs.begin(), vs.end());
    vs.erase(unique(vs.begin(), vs.end()), vs.end());

    for (int i = 0; i < n; i++) {
        res[i] = lower_bound(vs.begin(), vs.end(), arr[i]) - vs.begin();
    }

    for (int i = 0; i < n; i++) {
        cout << res[i] << " ";
    }

    return 0;
}
