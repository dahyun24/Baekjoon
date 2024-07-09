#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    string arr[10];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < N; i++) {
        string a;
        a = arr[i];
        cout << a[0] << a[a.length() - 1] << endl; //C++은 마지막 글자 출력시 'a[a.length() - 1]' 사용 
    }

	return 0;
}