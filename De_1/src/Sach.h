/*
 * Sach.h
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */

#ifndef SACH_H_
#define SACH_H_

#include<iostream>
#include<string>
#include<fstream>
using namespace std;

class Sach {
	friend class QLMS;
private:
	int id_sach, nam_xuat_ban, chuyen_nganh;
	string ten_sach, tac_gia;

public:
	Sach();
	virtual ~Sach();
	void nhap_Sach();
	void xuat_Sach();
	void write_Sach(fstream &w) {
		w.write(reinterpret_cast<const char*>(this), sizeof(Sach));
	}
	void read_Sach(fstream &r) {
		r.read(reinterpret_cast<char*>(this), sizeof(Sach));
	}
};

#endif /* SACH_H_ */
