//============================================================================
// Name        : demoCPP.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "A.h"
#include "B.h"

int main() {
	A a;
	B b;
	a.nhap();
	xuat_A(a);
	b.call(a);
	return 0;
}
