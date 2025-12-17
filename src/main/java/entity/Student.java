#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Activity {
    string name;
    int start;
    int finish;
};

// Sort activities by finish time
bool cmp(Activity a, Activity b) {
    return a.finish < b.finish;
}

int main() {
    int n;
    cin >> n;

    vector<Activity> act(n);

    for (int i = 0; i < n; i++) {
        cin >> act[i].name;
        cin >> act[i].start;
        cin >> act[i].finish;
    }

    // Sort by finish time
    sort(act.begin(), act.end(), cmp);

    cout << "Selected Activities are:" << endl;

    // Select first activity
    int lastFinish = act[0].finish;
    cout << act[0].name << " ";

    // Select remaining activities
    for (int i = 1; i < n; i++) {
        if (act[i].start >= lastFinish) {
            cout << act[i].name << " ";
            lastFinish = act[i].finish;
        }
    }

    return 0;
}