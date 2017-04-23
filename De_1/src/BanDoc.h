/*
 * BanDoc.h
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */

#ifndef BANDOC_H_
#define BANDOC_H_

#include "Nguoi.h"
#include<iostream>
#include<string>
#include<fstream>
using namespace std;

class BanDoc: public Nguoi {
	//friend class QLMS;
private:
	int ma_the_doc, loai_ban_doc;
public:
	BanDoc();
	virtual ~BanDoc();
	void nhap_BanDoc();
	void xuat_BanDoc();
	void write_BanDoc(fstream &w) {
		w.write(reinterpret_cast<const char*>(this), sizeof(BanDoc));
	}
	void read_BanDoc(fstream &r) {
		r.read(reinterpret_cast<char*>(this), sizeof(BanDoc));
	}
};

#endif /* BANDOC_H_ */
