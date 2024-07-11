#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    vector<vector<int>> vec1(n, vector<int>(m,0));
    vector<vector<int>> vec2(n, vector<int>(m, 0));
    vector<vector<int>> vec3(n, vector<int>(m, 0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> vec1[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> vec2[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            vec3[i][j] = vec1[i][j] + vec2[i][j];
            cout << vec3[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}