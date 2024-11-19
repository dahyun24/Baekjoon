#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static vector<vector<char>> vec_normal;
static vector<vector<char>> vec_odd;
static vector<vector<bool>> visited_normal;
static vector<vector<bool>> visited_odd;
void DFS(vector<vector<char>>& vec, vector<vector<bool>>& visited, int row, int col);

int dx[] = { 1,-1,0,0 }; // 상하좌우 탐색
int dy[] = { 0,0,1,-1 };

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vec_normal.resize(N, vector<char>(N));
    vec_odd.resize(N, vector<char>(N));
    visited_normal = vector<vector<bool>> (N, vector<bool>(N, false));
    visited_odd = vector<vector<bool>>(N, vector<bool>(N, false));

    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < N; j++) {
            char a = input[j];
            vec_normal[i][j] = a;
            vec_odd[i][j] = (a == 'R') ? 'G' : a; // odd는 G와 B로만 이루어짐
        }
    }

    int count_normal = 0;
    int count_odd = 0;

    // 모든 칸을 순회하며 DFS 탐색
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!visited_normal[i][j]) {
                DFS(vec_normal, visited_normal, i, j);
                count_normal++;
            }
            if (!visited_odd[i][j]) {
                DFS(vec_odd, visited_odd, i, j);
                count_odd++;
            }
        }
    }
    cout << count_normal << " " << count_odd << "\n";

    return 0;
}

void DFS(vector<vector<char>>& vec, vector<vector<bool>>& visited, int row, int col) {
    // DFS에서 DFS 호출했을 때를 위한 코드
    if (visited[row][col])
        return;

    visited[row][col] = true;

    for (int i = 0; i < 4;i++) { // 상하좌우
        int x = dx[i] + row;
        int y = dy[i] + col;

        if (x >= 0 && x < vec.size() && y >= 0 && y < vec[0].size() &&
            vec[row][col] == vec[x][y] && !visited[x][y]) {
            DFS(vec, visited, x, y);
        }
    }
    return;
}