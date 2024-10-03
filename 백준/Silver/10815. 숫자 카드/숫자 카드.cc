#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;

int binary_search(int a, vector<int>& vec) {
    int low = 0, high = vec.size() - 1;
    while (low <= high) {
        int mid = (high + low) / 2;
        if (a == vec[mid]) return 1;
        else if (a < vec[mid]) high = mid - 1;
        else low = mid + 1;
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    vector<int> vec, answer;
    cin >> n;
    vec.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> vec[i];
    }
    sort(vec.begin(), vec.end());

    cin >> m;
    answer.resize(m);
    for (int i = 0; i < m; i++) {
        int a;
        cin >> a;
        answer[i] = binary_search(a, vec);
    }

    for (int i = 0; i < m; i++) {
        cout << answer[i] << " ";
    }
    return 0;
}