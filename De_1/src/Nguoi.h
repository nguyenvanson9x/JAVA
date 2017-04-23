/*

 * Nguoi.h
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */
#ifndef NGUOI_H_
#define NGUOI_H_

#include<iostream>
#include<string>
using namespace std;

class Nguoi {
private:
	string hoten, dia_chi, sdt;
public:
	Nguoi();
	virtual ~Nguoi();
	void nhap_Nguoi();
	void xuat_Nguoi();
};

#endif /* NGUOI_H_ */
