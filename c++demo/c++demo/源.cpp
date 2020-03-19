#include "String.h"
void String::Init(char* pStr) {
	m_str = pStr;
}

void String::Init(String str) {
	m_str = (char*)str.GetBuffer;
}

const char* String::GetBuffer() {
	return m_str.c_str();
}

void String::Append(char* pBuf) {
	m_str.append(pBuf);

}


