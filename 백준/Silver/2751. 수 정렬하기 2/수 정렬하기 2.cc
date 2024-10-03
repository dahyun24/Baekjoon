#include<iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int num;
    cin >> num;

    priority_queue<int, vector<int>, greater<int>> q;

    for (int i = 0; i < num; i++) {
        int a;
        cin >> a;
        q.push(a);
    }

    /*while (!q.empty()) {
        cout << q.top() << endl;
        q.pop();
    }*/

    for (int i = 0; i < num; i++) {
        cout << q.top() << "\n";
        q.pop();
    }

    return 0;
}