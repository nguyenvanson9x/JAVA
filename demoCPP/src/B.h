/*
 * B.h
 *
 *  Created on: Mar 25, 2017
 *      Author: Nguyen Van Son
 */

#ifndef B_H_
#define B_H_
#include "A.h"
class B {
public:
	B();
	virtual ~B();
	void call(A&);
};

#endif /* B_H_ */
