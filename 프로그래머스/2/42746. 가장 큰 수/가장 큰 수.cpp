#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> numstr;
    for (int num : numbers){
        numstr.push_back(to_string(num));
    }
    
    sort(numstr.begin(), numstr.end(), [](const std::string& a, const std::string& b) {
        return a + b > b + a;
    });

    // 0 으로만 구성된 경우 처리
    if (numstr[0] == "0") return "0";

    
    for (const string& str : numstr){
        answer += str;
    }
    
    return answer;
}