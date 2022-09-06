package patient;

import java.util.Scanner;

public class Patient {
    private int Id;
    private static int id = 0;
    private String pib;
    private String adress;
    private int phoneNumber;
    private int medicalCardNumber;
    private String diagnosis;
    private Scanner scan = new Scanner(System.in);

    public int getId() {
        return Id;
    }

    public String getPib() {
        return pib;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getAdress() {
        return adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public Patient() {
        id++;
        Id = id;
        System.out.print("\nХворий №" + Id + ":\n");

        System.out.print("Введіть ПІБ хворого: ");
        pib = scan.nextLine();

        System.out.print("\nВведіть адресу хворого: ");
        adress = scan.nextLine();

        System.out.print("\nВведіть діагноз хворого: ");
        diagnosis = scan.nextLine();

        System.out.print("\nВведіть номер телефону хворого: ");
        phoneNumber = scan.nextInt();

        System.out.print("\nВведіть номер медичної картки хворого: ");
        medicalCardNumber = scan.nextInt();

        System.out.print("\n\n");
    }
    @Override
    public String toString() {
        return
                "\n\nPatient id - " + Id +
                "\nАдреса - " + adress +
                "\nПІБ - " + pib +
                "\nНомер телефону - " + phoneNumber +
                "\nНомер медичної картки - " + medicalCardNumber +
                "\nДіагноз - " + diagnosis;
    }
}