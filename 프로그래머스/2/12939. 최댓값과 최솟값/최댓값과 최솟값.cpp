#include <string>
#include <vector>
#include <sstream>
using namespace std;

string solution(string s) {
    vector<int> vec;
    string answer = "";
    stringstream ss1(s);
    
    int num;
    while (ss1 >> num){
        vec.push_back(num);
    }
    
    int min = vec[0];
    int max = vec[0];
    
    for (int j = 1; j < vec.size(); j++){
        if (vec[j] < min) {
            min = vec[j];
        }
        if (vec[j] > max){
            max = vec[j];
        }
    }
    
    string str1 = to_string(min);
    string str2 = to_string(max);
    
    answer = str1 + " " + str2;
    
    return answer;
}