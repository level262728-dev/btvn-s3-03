
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> salaryList = new ArrayList<>();

        int count = 0;
        double totalSalary = 0;
        double maxSalary = 0;
        double minSalary = 0;

        while (true) {
            System.out.println("\n========== MENU NHAP LUONG ==========");
            System.out.println("1. Nhap luong nhan vien");
            System.out.println("2. Hien thi thong ke");
            System.out.println("3. Tinh tong tien thuong nhan vien");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    while (true) {
                        System.out.print(
                                "Nhap luong (-1 de ket thuc): "
                        );
                        double salary = sc.nextDouble();

                        if (salary == -1) {
                            break;
                        }

                        if (salary < 0 || salary > 500000000) {
                            System.out.println(
                                    "Luong khong hop le, vui long nhap lai!"
                            );
                            continue;
                        }

                        salaryList.add(salary);
                        totalSalary += salary;
                        count++;

                        if (count == 1) {
                            maxSalary = salary;
                            minSalary = salary;
                        } else {
                            if (salary > maxSalary) {
                                maxSalary = salary;
                            }

                            if (salary < minSalary) {
                                minSalary = salary;
                            }
                        }

                        if (salary < 5000000) {
                            System.out.println(
                                    "Phan loai: Thu nhap thap"
                            );
                        } else if (salary < 15000000) {
                            System.out.println(
                                    "Phan loai: Thu nhap trung binh"
                            );
                        } else if (salary <= 50000000) {
                            System.out.println(
                                    "Phan loai: Thu nhap kha"
                            );
                        } else {
                            System.out.println(
                                    "Phan loai: Thu nhap cao"
                            );
                        }

                        System.out.println(
                                "Da luu luong nhan vien!"
                        );
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("Chua co du lieu!");
                    } else {
                        double averageSalary =
                                totalSalary / count;

                        System.out.println("\n===== THONG KE =====");
                        System.out.println(
                                "So nhan vien: " + count
                        );

                        System.out.printf(
                                "Tong luong: %,.0f VND%n",
                                totalSalary
                        );

                        System.out.printf(
                                "Luong trung binh: %,.0f VND%n",
                                averageSalary
                        );

                        System.out.printf(
                                "Luong cao nhat: %,.0f VND%n",
                                maxSalary
                        );

                        System.out.printf(
                                "Luong thap nhat: %,.0f VND%n",
                                minSalary
                        );
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Chua co du lieu!");
                    } else {
                        double totalBonus = 0;

                        for (int i = 0;
                             i < salaryList.size(); i++) {

                            double salary = salaryList.get(i);
                            double rate;

                            if (salary < 5000000) {
                                rate = 0.05;
                            } else if (salary < 15000000) {
                                rate = 0.10;
                            } else if (salary < 50000000) {
                                rate = 0.15;
                            } else if (salary <= 100000000) {
                                rate = 0.20;
                            } else {
                                rate = 0.25;
                            }

                            double bonus = salary * rate;
                            totalBonus += bonus;
                        }

                        System.out.println(
                                "\n===== TINH TIEN THUONG ====="
                        );

                        System.out.printf(
                                "Tong tien thuong nhan vien: %,.0f VND%n",
                                totalBonus
                        );
                    }
                    break;

                case 4:
                    System.out.println(
                            "Ket thuc chuong trinh."
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                            "Lua chon khong hop le!"
                    );
            }
        }
    }
}
