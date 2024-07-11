#include <iostream>
#include <string>
#include <algorithm> // reverse 함수를 위해서

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string a, b;
    cin >> a >> b;
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());
    if (a > b) cout << a;
    else cout << b;

	return 0;
}