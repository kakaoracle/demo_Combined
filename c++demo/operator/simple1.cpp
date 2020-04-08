#include <iostream>
using namespace std;
int main() {
	int a,b,c;
	cout << "please input two numbers: " << endl;
	cin >> a >> b;
	c = a + b;
	cout << "the sum is " << c << "!";
	return 0;
}
// endl:下一行换行
// <<与>>都是连接符,类似于java中的+,c++中没有()因此<<既可以表示(,也可以表示+
// using namespace std;指的是引用标准标识符库,比如<<