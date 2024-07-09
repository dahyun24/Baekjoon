#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;

    cin >> N >> M;
    int* arr = new int[N];
    
    for (int i = 1; i <= N; i++) {
        arr[i] = i;
    }

    int i, j;
    for (int k = 1; k <= M; k++) {
        cin >> i >> j;
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    for (int i = 1; i <= N; i++) {
        cout << arr[i] << " ";
    }

	return 0;
}