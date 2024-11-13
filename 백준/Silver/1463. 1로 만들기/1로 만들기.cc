#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int input, result;
    cin >> input;

    vector<int> make_1;
    make_1.resize(input+1);

    make_1[0] = 0; 
    make_1[1] = 0;
    for (int i = 2; i <= input; i++) {
        make_1[i] = make_1[i - 1] + 1;
        if (i % 2 == 0) {
            make_1[i] = min(make_1[i], make_1[i / 2] + 1);
        }
        if (i % 3 == 0) {
            make_1[i] = min(make_1[i], make_1[i / 3] + 1);
        }
    }

    result = make_1[input];
    cout << result;

    return 0;
}