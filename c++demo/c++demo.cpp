// c++demo.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "String.h"

int main()
{
    char a[] = "ABCDE";
    char b[] = "FGHIJ ";
    String str;
    str.Init(a);
    cout << str.GetBuffer() << endl;
    str.Append(b);
    cout << str.GetBuffer() << endl;
    String str1;
    str1.Init(str);
    cout << str1.GetBuffer() << endl;
    return 0;
}

