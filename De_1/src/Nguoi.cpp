/*
 * Nguoi.cpp
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */

#include "Nguoi.h"

Nguoi::Nguoi() {
	// TODO Auto-generated constructor stub
	hoten = "";
	dia_chi = "";
	sdt = "";
}

Nguoi::~Nguoi() {
	// TODO Auto-generated destructor stub
}

void Nguoi::nhap_Nguoi() {
	cin.ignore();
	cout << "\nHo ten: ";
	getline(cin, hoten);

	cout << "\nDia chi: ";
	getline(cin, dia_chi);

	cout << "\nSo dien thoai: ";
	getline(cin, sdt);
}

void Nguoi::xuat_Nguoi() {
	cout << "\nHo ten: " << hoten << "\nDia chi: " << dia_chi
			<< "\nSo dien thoai: " << sdt;
}
