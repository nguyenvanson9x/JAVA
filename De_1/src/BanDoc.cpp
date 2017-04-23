/*
 * BanDoc.cpp
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */

#include "BanDoc.h"

BanDoc::BanDoc() {
	ma_the_doc = 0;
	loai_ban_doc = 0;
}

BanDoc::~BanDoc() {
}

void BanDoc::nhap_BanDoc() {
	ma_the_doc++;
	nhap_Nguoi();
	do {
		cout
				<< "\nLoai ban doc: \n1: Sinh vien. \n2: Hoc vien cao hoc. \n3: Giao vien. \n";
		cin >> loai_ban_doc;
	} while (loai_ban_doc < 1 || loai_ban_doc > 3);

	cout << endl;
}

void BanDoc::xuat_BanDoc() {
	cout << "\nMa The doc: " << ma_the_doc;
	xuat_Nguoi();
	cout << "\nLoai ban doc: ";
	switch (loai_ban_doc) {
	case 1:
		cout << "Sinh vien";
		break;
	case 2:
		cout << "Hoc vien cao hoc";
		break;
	case 3:
		cout << "Giao vien";
		break;
	default:
		break;
	}
	cout << endl;
}

