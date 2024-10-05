#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;

    vector<string> str_vec,ans;
    ans.resize(t);
    str_vec.resize(t);

    for (int i = 0; i < t; i++) {
        cin >> str_vec[i];
    }

    for (int i = 0; i < t; i++) {
        int count = 0;
        for (char a : str_vec[i]) {
            if (a == '(') count++;
            else count--;
            if (count < 0) {
                ans[i] = "NO";
                break;
            }
            if (count == 0) ans[i] = "YES";
            else ans[i] = "NO";
        }
    }

    for (string b : ans)
        cout << b << "\n";

    return 0;
}