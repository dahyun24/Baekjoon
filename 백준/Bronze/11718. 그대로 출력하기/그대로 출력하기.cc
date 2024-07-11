// 입력을 다 받고 출력하는 것이 아니므로
#include <iostream>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	string s;

	while (true) {
		getline(cin, s);
		if (s == "") break;

		cout << s << '\n';
	}

    return 0;
}