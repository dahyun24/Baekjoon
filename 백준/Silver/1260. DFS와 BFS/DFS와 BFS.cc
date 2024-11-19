#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static vector<vector<int>> vec;
static vector<bool> visited_dfs;
static vector<bool> visited_bfs;
vector<int> result_bfs;
vector<int> result_dfs;

void DFS(int i) {
    visited_dfs[i] = true;
    result_dfs.push_back(i);

    for (int j = 0; j < vec[i].size(); j++) {
        if (!visited_dfs[vec[i][j]]) { //방문하지 않은 곳만 탐색
            DFS(vec[i][j]);
        }
    }
}

void BFS(int temp) {
    queue<int> q;
    q.push(temp);
    visited_bfs[temp] = true;

    while (!q.empty()) {
        int x = q.front();
        q.pop();
        result_bfs.push_back(x);

        for (int i = 0; i < vec[x].size(); i++) {
            if (!visited_bfs[vec[x][i]]) { //방문하지 않은 곳만 탐색
                q.push(vec[x][i]);
                visited_bfs[vec[x][i]] = true;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, V;
    cin >> N >> M >> V;

    visited_dfs = vector<bool>(N + 1, false);
    visited_bfs = vector<bool>(N + 1, false);
    vec.resize(N + 1);

    for (int i = 0; i < M; i++) {
        int a,b;
        cin >> a >> b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }

    for (int i = 1; i <= N; i++) {
        sort(vec[i].begin(), vec[i].end()); // 낮은 숫자부터 탐색.
    }

    DFS(V);
    BFS(V);

    for (int i= 0; i < result_dfs.size(); i++) {
        cout << result_dfs[i] << " ";
    }
    cout << '\n';
    for (int i = 0; i < result_bfs.size() ; i++) {
        cout << result_bfs[i] << " ";
    }

    return 0;
}