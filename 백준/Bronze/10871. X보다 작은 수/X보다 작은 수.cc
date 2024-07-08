#include <iostream>
using namespace std;

int main() {
	int N, x, num;
	cin >> N >> x;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num < x) cout << num << " ";
	}
	return 0;
}