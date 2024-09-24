#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;   
    queue<int> q;
    
    for(int i = 0;i < progresses.size();i++){
        int a = (100-progresses[i])/speeds[i];
        int b = (100-progresses[i])%speeds[i];
        if (b!=0) a += 1;
        q.push(a);
    }
    
    while(!q.empty()){
        int c = q.front();
        q.pop();
        int count = 1;
        
        while(!q.empty() && q.front() <= c){
                count++;
                q.pop();
        }
        answer.push_back(count); 
    }
    return answer;
}