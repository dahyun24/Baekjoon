#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;
    string reversed_str;
    for (int i = str.length() - 1; i >= 0; i--) {
        reversed_str += str[i];
    }
    if (str == reversed_str) cout << 1;
    else cout << 0;
    return 0;
}