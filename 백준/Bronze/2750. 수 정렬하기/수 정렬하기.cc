#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // bubble sort
    int num;
    cin >> num;
    int *arr = new int[num];
    for (int i = 0; i < num; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < num-1; i++) {
        for (int j = 0; j < num-1-i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
    for (int i = 0; i < num; i++) {
        cout << arr[i] << "\n";
    }

    delete[] arr;
    return 0;
}
