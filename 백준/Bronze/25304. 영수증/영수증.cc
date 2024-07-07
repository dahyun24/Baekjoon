#include<iostream>
using namespace std;
int main(){
    int total, num;
    cin >> total;
    cin >> num;
    
    int sum = 0;
    for (int i=0;i<num;i++){
        int a,b;
        cin >> a >> b;
        sum = sum + a*b;
    }
    if (total == sum)
        cout << "Yes";
    else cout << "No";
    
    return 0;
}