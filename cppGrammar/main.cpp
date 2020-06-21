#include <iostream>
using namespace std;

class Test{
public:
    ~Test(){
        cout << "123" << endl;
    }
};

int main() {
    for (;;) {
        Test* test = new Test;
        delete test;
    }
    return 0;
}
