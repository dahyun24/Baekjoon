#include<iostream>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int num;
    cin >> num;
    for (int i = 0; i < num ; i++){
        for (int j=0; j < num-1-i;j++)
            cout << " ";
        for (int k=0; k <= i;k++)
            cout << "*";
        cout << "\n";
    }
    return 0;
}