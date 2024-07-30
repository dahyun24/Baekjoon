#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    cin >> num;

    queue<int> Q;

    for (int i = 1; i <= num; i++) {
        Q.push(i);
    }

    while (Q.size() > 1) {
        Q.pop();
        int a = Q.front();
        Q.pop();
        Q.push(a);
    }
    cout << Q.front();
     return 0;
}
