#include <iostream>
#include <algorithm> // 추가하기
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    int* arr = new int[N+1]; // 첫번째 arr[0]은 0으로 그냥 두고 1부터 N까지 사용
    for (int i = 1; i <= N; i++) {
        arr[i] = i;
    }
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        reverse(arr+a,arr+b+1); // arr 배열의 a+1번째부터 b+1번째까지 뒤집어라 , arr[0] = 0 이므로 1번째 부터 시작
    }

    for (int i = 1; i <= N; i++)
        cout << arr[i] << " ";

	return 0;
}
