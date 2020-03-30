#pragma once
#ifndef STRING_H_INCLUDED
#define STRING_H_INCLUDED

#include <iostream>
using namespace std;
class String {
public:
	String() {}
	~String() {}
	void Init(char* pStr);
	void Init(String str);
	const char* GetBuffer();
	void Append(char* pBuf);
private:
	string m_str;

};
#endif
