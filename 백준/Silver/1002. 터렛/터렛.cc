#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    vector<int> arr(T);
    
    for (int i = 0; i < T; i++) {
        int x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

        int dx = x2 - x1;
        int dy = y2 - y1;
        double d = sqrt(dx * dx + dy * dy);

        if (x1 == x2 && y1 == y2) {
            if (r1 == r2) arr[i] = -1;
            else arr[i] = 0;
        } else {
            if (d > r1 + r2) arr[i] = 0; 
            else if (d < abs(r1 - r2)) arr[i] = 0; 
            else if (d == r1 + r2 || d == abs(r1 - r2)) arr[i] = 1; 
            else arr[i] = 2; 
        }
    }
    
    for (int i = 0; i < T; i++) {
        cout << arr[i] << endl;
    }
    
    return 0;
}
