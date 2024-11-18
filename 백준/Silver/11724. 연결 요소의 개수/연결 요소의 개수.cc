#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static vector<vector<int>> vec;
static vector<bool> visited;
void DFS(int i);


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    visited = vector<bool>(N+1, false);

    vec.resize(N+1);

    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        vec[u].push_back(v);
        vec[v].push_back(u);
    }

    int count = 0;

    for (int i = 1; i < N + 1; i++) {
        // 방문하지 않은 노드에 대해서 DFS 수행
        if (!visited[i]) {
            count++;
            DFS(i);
        }
    }
    cout << count;

    return 0;
}

void DFS(int i) {
    // DFS에서 DFS 호출했을 때를 위한 코드
    if (visited[i])
        return;

    visited[i] = true;

    for (int j : vec[i]) {
        if (visited[j] == false)
            DFS(j);
    }
}