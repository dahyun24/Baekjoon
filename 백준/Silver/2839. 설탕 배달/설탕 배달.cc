#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    const int INF = 987654321;
    vector<int> dp(N + 1, INF);
    dp[0] = 0; 

    for (int i = 3; i <= N; i++) {
        if (i >= 3) dp[i] = min(dp[i], dp[i - 3] + 1);
        if (i >= 5) dp[i] = min(dp[i], dp[i - 5] + 1);
    }

    cout << (dp[N] == INF ? -1 : dp[N]);

    return 0;
}