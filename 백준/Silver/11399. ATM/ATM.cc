#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool arr[2000000] = { };

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> p1;
    p1.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> p1[i];
    }
    sort(p1.begin(), p1.end());

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += p1[i] * (n - i);
    }
    cout << sum;

    return 0;
}