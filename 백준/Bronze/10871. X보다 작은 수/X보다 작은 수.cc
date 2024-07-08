#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
	int N, x, num;
	cin >> N >> x;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num < x) cout << num << " ";
	}
	return 0;
}