#include<iostream>
#include <algorithm>
using namespace std;

int N;
int arr[100010];

void find_num(int c) {
    int low, mid, high;
    low = 0; high = N-1;
    while (low <= high) {
        mid = (low + high) / 2;
        if (c == arr[mid]) { cout << 1 << "\n"; return; }
        else if (c < arr[mid]) high = mid - 1;
        else low = mid + 1;
    }
    cout << 0 << "\n";
    return;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int b,c;
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    sort(arr, arr+N);

    cin >> b;
    for (int i = 0; i < b; i++) {
        cin >> c;
        find_num(c);
    }

    return 0;
}