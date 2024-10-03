#include<iostream>
#include <vector>
using namespace std;

bool arr[2000000] = { };

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> vec;
    cin >> n;
    vec.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> vec[i];
    }

    int x, count = 0;
    cin >> x;
    /*
    투 포인터 방법 이중 for 문=> 시간 초과
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (vec[i] + vec[j] == x) {
                count++; break;
            }
        }
    }
    */
    for (int i = 0; i < n; i++) {
        int tmp = x - vec[i];
        if (tmp > 0 && arr[tmp])
            count++;
        // 방문 찍는 느낌으로
        arr[vec[i]] = true;
    }

    cout << count;

    return 0;
}