#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    int C[42] = {};
    for (int i = 0; i < 10; i++) {
        cin >> num;
        C[num % 42]++;
    }
    int count = 0;
    for (int i = 0; i < 42; i++)
    {
        if (C[i] != 0)
            count++;
    }
    cout << count;
	return 0;
}