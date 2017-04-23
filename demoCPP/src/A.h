/*
 * A.h
 *
 *  Created on: Mar 25, 2017
 *      Author: Nguyen Van Son
 */

#ifndef A_H_
#define A_H_

#include <iostream>
using namespace std;

class A {
	friend void xuat_A(A&);
	friend class B;
public:
	void nhap();
private:
	int a, b, c;
};

void xuat_A(A&);

#endif /* A_H_ */
