/*
 * Sach.cpp
 *
 *  Created on: Mar 17, 2017
 *      Author: Nguyen Van Son
 */

#include "Sach.h"

Sach::Sach() {
	id_sach = 0;
	nam_xuat_ban = 0;
	chuyen_nganh = 0;
	ten_sach = "";
	tac_gia = "";
}

Sach::~Sach() {
	// TODO Auto-generated destructor stub
}

void Sach::nhap_Sach() {
	id_sach++;
	cin.ignore();
	cout << "\nTen sach: ";
	getline(cin, ten_sach);

	cout << "\nTac gia: ";
	getline(cin, tac_gia);

	cout << "\nNam XB: ";
	cin >> nam_xuat_ban;
	do {
		cout
				<< "\nChuyen nganh: \n1: Khoa hoc tu nhien, \n2: Van hoc - nghe thuat. \n3: Dien tu vien thong. \n4: Cong nghe thong tin. \n";
		cin >> chuyen_nganh;
	} while (chuyen_nganh < 0 || chuyen_nganh > 4);

	cout << endl;
	cin.ignore();
}
void Sach::xuat_Sach() {
	cout << "\nMa sach: " << id_sach << "\nTen sach: " << ten_sach
			<< "\nTac gia: " << tac_gia << "\nNam XB: " << nam_xuat_ban
			<< "\nChuyen nganh: ";

	switch (chuyen_nganh) {
	case 1:
		cout << "Khoa hoc tu nhien" << endl;
		break;
	case 2:
		cout << "Van hoc - Nghe thuat" << endl;
		break;
	case 3:
		cout << "Dien tu Vien thong" << endl;
		break;
	case 4:
		cout << "Cong nghe thong tin" << endl;
		break;
	default:
		break;
	}
}
