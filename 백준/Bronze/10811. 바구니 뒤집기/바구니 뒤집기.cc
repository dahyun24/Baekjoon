#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    int* arr = new int[N+1];
    for (int i = 1; i <= N; i++) {
        arr[i] = i;
    }
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        reverse(arr+a,arr+b+1);
    }

    for (int i = 1; i <= N; i++)
        cout << arr[i] << " ";

	return 0;
}