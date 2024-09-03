import java.util.ArrayList;
import java.util.Scanner;

public class NumberExercise {

    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap sp phan tu cua mang: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("nhap so thu " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    public static void DisplayData(ArrayList<Integer> numbers) {
        System.out.println("cac phan tu trong mang la: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int findMax2(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("mang phai co it nhat 2 phan tu");
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }
        return max2;
    }
    
    public static void deleteOddNumber(ArrayList<Integer> numbers) {
        numbers.removeIf(num -> num % 2 != 0);
        System.out.println("mang sau khi xoa cac phan tu le: " + numbers);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Menu:");
            System.out.println("1. nhap mang so nguyen");
            System.out.println("2. xuat mang");
            System.out.println("3. tim gia tri phan tu lon thu 2");
            System.out.println("4. xoa cac phan tu le");
            System.out.println("5. thoat");
            System.out.print("chon tuy chon: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    EnterData(numbers);
                    break;
                case 2:
                    DisplayData(numbers);
                    break;
                case 3:
                    try {
                        int max2 = findMax2(numbers);
                        System.out.println("gia tri lon thu 2 trong mang la: " + max2);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    deleteOddNumber(numbers);
                    break;
                case 5:
                    System.out.println("ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);
    }
}
