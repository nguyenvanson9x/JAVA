/*
 * A.cpp
 *
 *  Created on: Mar 25, 2017
 *      Author: Nguyen Van Son
 */

#include "A.h"

void A::nhap() {
	cout << "Nhap a, b, c: ";
	cin >> a >> b >> c;
}

void xuat_A(A &a) {
	cout << "print in A.h\t" << a.a << "\t" << a.b << "\t" << a.c;
}
