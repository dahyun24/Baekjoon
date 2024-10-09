#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int p;
    cin >> p;  // 테스트 케이스 개수

    stack<int> st;

    for (int i = 0; i < p; i++) {
        int a;
        cin >> a;
        if (a == 0) {
            st.pop();
        }
        else st.push(a);
    }
    int sum = 0;
    while (!st.empty()) {
        sum += st.top();
        st.pop();
    }
    cout << sum;
    return 0;
}
