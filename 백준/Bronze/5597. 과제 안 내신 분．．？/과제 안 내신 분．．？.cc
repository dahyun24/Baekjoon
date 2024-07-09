#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a;
    int arr[30] = {};
    for (int i = 0; i < 28; i++) {
        cin >> a;
        arr[a - 1] = 1;
    }
    for (int i = 0; i < 30; i++) {
        if (arr[i] == 0)
            cout << i + 1 << "\n";
    }

	return 0;
}