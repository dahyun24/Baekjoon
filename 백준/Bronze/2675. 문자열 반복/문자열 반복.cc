#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    string* arr = new string[t];

    int r;
    string S;
    for (int i=0;i<t;i++){
        cin >> r >> S;
        string result;
        for (char c : S) {
            result.append(r, c); //c를 r번 반복
        }
        arr[i] = result;
    }
    for (int i = 0; i < t; i++)
        cout << arr[i] << "\n";

	return 0;
}