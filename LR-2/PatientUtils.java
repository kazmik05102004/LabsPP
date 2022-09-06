package patient;

import java.util.Objects;
import java.util.Scanner;

public class PatientUtils
{
    public static void printTablesInfo()
    {
        System.out.format("| № |           ПІБ           |     Адреса     |    Діагноз    | Номер телефону | Номер медичної карточки |%n");
    }

    public static void createTable(Patient patient)
    {
        System.out.format("| %d | %-23s | %-14s | %-13s | %14d | %23d |%n", patient.getId(), patient.getPib(), patient.getAdress(), patient.getDiagnosis(),patient.getPhoneNumber(), patient.getMedicalCardNumber());
    }

    public static void firstTable(Patient [] patients)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть діагноз, за яким хочете отримати таблицю: ");
        String diagnosis = scan.nextLine();

        int kst = 0;
        for(int i = 0; i < patients.length; i++)
            if (Objects.equals(diagnosis, patients[i].getDiagnosis()))
            {
                if(kst == 0)
                {
                    System.out.print("\n\nТаблиця хворих із діагнозом\' " + diagnosis + "\': \n");
                    printTablesInfo();
                }
                createTable(patients[i]);
                kst++;
            }

        if(kst == 0)
            System.out.print("Хворих із даним діагнозом не знайдено!\n\n");
    }

    public static void  secondTable(Patient [] patients)
    {
        int kst = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\nВведіть цифру з якої буде починатись номер хворих у таблиці: ");
        String number = scan.nextLine();
        String str = new String();
        for(int i = 0; i < patients.length; i++)
        {
            str = Objects.toString(patients[i].getPhoneNumber());
            if (Objects.equals(number.charAt(0), str.charAt(0)))
            {
                if (kst == 0) {
                    System.out.print("\n\nТаблиця хворих із першою цифрою в номері " + number + ":\n");
                    printTablesInfo();
                }
                createTable(patients[i]);
                kst++;
            }
        }
        if(kst == 0)
            System.out.print("Хворих у яких номер починається на" + number + " не знайдено!\n\n");
    }

    public static void  thirdTable(Patient [] patients)
    {
        int kst = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\nВведіть діапазон номеру медичних карток, власників яких ви хочете бачити у таблиці:\n");
        System.out.print("Від - ");
        int x = scan.nextInt();
        System.out.print("До - ");
        int y = scan.nextInt();

        for(int i = 0; i < patients.length; i++)
        {
            if (patients[i].getMedicalCardNumber() >= x && patients[i].getMedicalCardNumber() <= y) {
                if (kst == 0) {
                    System.out.print("\n\nТаблиця хворих з номером медичної картки від " + x + " до " + y + ": \n");
                    printTablesInfo();
                }
                createTable(patients[i]);
                kst++;
            }
        }
        if(kst == 0)
            System.out.print("Хворих із такими номеромами медичних карток не знайдено!\n\n");
    }
}
