#include<iostream>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    bool signal = true;
    while(signal){
        int a,b;
        cin >> a >> b;
        if (a==0 && b==0){signal = false; break;}
        cout << a+b << "\n";
    }
    return 0;
}