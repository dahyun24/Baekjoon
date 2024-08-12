#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // bubble sort
    int N;
    cin >> N;
    //pair는 두 개의 값을 담을 수 있으며, 이 값들은 first와 second라는 멤버로 접근할 수 있다.
    vector <pair<int, int>>A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i].first;
        A[i].second = i;
    }
    //first 값을 기준으로 벡터가 오름차순으로 정렬
    sort(A.begin(), A.end());
    int Max = 0;

    // 각 요소가 원래 인덱스에서 얼마나 이동했는지를 알아낼 수 있다.
    for (int i = 0; i < N; i++) {
        if (Max < A[i].second - i) {
            Max = A[i].second - i;
        }
    }

    cout << Max + 1;

    return 0;
}
