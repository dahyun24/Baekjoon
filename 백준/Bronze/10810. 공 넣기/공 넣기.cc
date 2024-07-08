#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    int arr[101] = {};

    cin >> N >> M;
    
    int i, j, k;
    for (int q = 0; q < M; q++) {
        cin >> i >> j >> k;
        for (i; i <= j; i++) {
            arr[i - 1] = k;
        }
    }
    for (int p = 0; p < N; p++) {
        cout << arr[p] << " ";
    }
	return 0;
}