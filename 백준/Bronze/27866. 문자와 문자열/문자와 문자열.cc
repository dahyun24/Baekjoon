#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string A;
    cin >> A;
    int B;
    cin >> B;
    cout << A[B-1];
	return 0;
}