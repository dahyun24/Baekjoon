#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<vector<int>> vec1(10, vector<int>(10,0));

    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            cin >> vec1[i][j];
        }
    }
    int max = vec1[1][1];
    int a = 1, b = 1;
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            if (max < vec1[i][j]) {
                max = vec1[i][j];
                a = i; b = j;
            }
        }
    }
    cout << max << "\n" << a << " " << b;
    return 0;
}