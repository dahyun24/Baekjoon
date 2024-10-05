#include<iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    cin >> num;

    stack<int> st;
    vector <int> vec;

    for (int i = 0; i < num; i++) {
        string a;
        cin >> a;
        if (a == "push") {
            int b;
            cin >> b;
            st.push(b);
        }
        else if (a == "pop") {
            if (st.empty()) vec.push_back(-1);
            else {
                vec.push_back(st.top()); st.pop();
            }
        }
        else if (a == "top") {
            if (st.empty()) vec.push_back(-1);
            else {
                vec.push_back(st.top());
            }
        }
        else if (a == "size") {
            vec.push_back(st.size());

        }
        else if (a == "empty") {
            if (st.empty()) vec.push_back(1);
            else vec.push_back(0);
        }

    }
    for (int res : vec) {
        cout << res << "\n";
    }

    return 0;
}