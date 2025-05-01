

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<book> books = new ArrayList<>();
        ArrayList<borrower> borrowers = new ArrayList<>();
        ArrayList<borrowingProcess> borrowings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1. إضافة كتاب");
            System.out.println("2. عرض الكتب");
            System.out.println("3. إضافة مستعير");
            System.out.println("4. عرض المستعيرين");
            System.out.println("5. إعارة كتاب");
            System.out.println("6. استرجاع كتاب");
            System.out.println("7. عرض عمليات الإعارة");
            System.out.println("0. خروج");
            System.out.print("اختر: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("العنوان: ");
                String title = input.nextLine();
                System.out.print("المؤلف: ");
                String author = input.nextLine();
                System.out.print("ISBN: ");
                String isbn = input.nextLine();
                System.out.print("النوع (ورقي/إلكتروني): ");
                String type = input.nextLine();

                book book;
                if (type.equalsIgnoreCase("ورقي")) {
                    book = new paperbook(title, author, isbn);
                } else {
                    book = new ebook(title, author, isbn);
                }

                books.add(book);
                System.out.println(" تم إضافة الكتاب.");
            }

            if (choice == 2) {
                for (book b : books) {
                    b.displayInfo();
                }
            }

            if (choice == 3) {
                System.out.print("الاسم: ");
                String name = input.nextLine();
                System.out.print("الرقم الجامعي: ");
                String id = input.nextLine();
                borrowers.add(new borrower(name, id));
                System.out.println("تم إضافة المستعير.");
            }

            if (choice == 4) {
                for (borrower br :borrowers) {
                    br.displayInfo();
                }
            }

            if (choice == 5) {
                System.out.print("اسم المستعير: ");
                String name = input.nextLine();
                System.out.print("عنوان الكتاب: ");
                String title = input.nextLine();

                borrower foundborrower = null;
                for (borrower br : borrowers) {
                    if (br.getName().equals(name)) {
                        foundborrower = br;
                        break;
                    }
                }

                book foundbook = null;
                for (book b : books) {
                    if (b.getTitle().equals(title) && b.isAvailable()) {
                        foundbook = b;
                        break;
                    }
                }

                if (foundborrower != null && foundbook != null) {
                    foundborrower.borrowbook(foundbook);
                    foundbook.borrow();
                    borrowingProcess process = new borrowingProcess(foundbook, foundborrower);
                    borrowings.add(process);
                    System.out.println("تمت الإعارة.");
                } else {
                    System.out.println(" المستعير أو الكتاب غير موجود.");
                }
            }

            if (choice == 6) {
                System.out.print("اسم المستعير: ");
                String name = input.nextLine();
                System.out.print("عنوان الكتاب: ");
                String title = input.nextLine();

                borrowingProcess foundProcess = null;
                for (borrowingProcess bp : borrowings) {
                    if (bp.book.getTitle().equals(title) && bp.borrower.getName().equals(name)) {
                        foundProcess = bp;
                        break;
                    }
                }

                if (foundProcess != null) {
                    foundProcess.returnbook();
                    System.out.println(" تم الاسترجاع.");
                } else {
                    System.out.println(" لم يتم العثور على عملية الإعارة.");
                }
            }

            if (choice == 7) {
                for (borrowingProcess bp : borrowings) {
                    bp.displayInfo();
                    System.out.println();
                }
            }

        } while (choice != 0);

        input.close();
    }
}
