package com.nyd.VehicleSystem.Entity;

import com.nyd.VehicleSystem.Entity.Costumer.Costumer;
import com.nyd.VehicleSystem.Entity.Employee.Manager;
import com.nyd.VehicleSystem.Entity.Employee.Seller;
import com.nyd.VehicleSystem.Entity.Sale.Sale;
import com.nyd.VehicleSystem.Entity.Vehicle.DeficientVehicle;
import com.nyd.VehicleSystem.Entity.Vehicle.RegularVehicle;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TestSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeCar;
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat money = NumberFormat.getCurrencyInstance(localeBR);
        int auth;
        System.out.println("Digite: ");
        System.out.println("1 - Gerente");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Estagiário");

        int job = Integer.parseInt(scanner.next());

        if (job == 3) {
            Manager manager = new Manager();

            do {
                System.out.println("\nDigite a senha do gerente: ");
                String password = scanner.next();
                auth = manager.authorization(password);

                if (auth != 0) {

                    System.out.println("Venda não authorizada");
                }
            } while (auth != 0);

            sale(scanner, money);

        } else {


            sale(scanner, money);


        }
    }

        private static void sale(Scanner scanner, NumberFormat money) {
            String typeCar;
            System.out.println("\nTipo do carro");
            System.out.println("Digite 1 para compra um carro comum");
            System.out.println("Digite 2 para compra um carro para deficiente");

            int choice = Integer.parseInt(scanner.next());

            if (choice == 1) {
                RegularVehicle v1 = new RegularVehicle();
                typeCar = v1.getType();
            } else {
                DeficientVehicle v1 = new DeficientVehicle();
                typeCar = v1.getType();
            }

            Seller s1 = new Seller();

            System.out.println("\nDigite o id do vendedor");
            int idSeller = Integer.parseInt(scanner.next());

            System.out.println("Digite o id do cliente");
            int idCostumer = Integer.parseInt(scanner.next());
            Costumer c1 = new Costumer();


            System.out.println("Digite o valor da venda");
            double value = scanner.nextDouble();

            System.out.println("Forma de Pagamento");
            System.out.println("1 - à vista");
            System.out.println("2 - parcelado ");

            int choice2 = Integer.parseInt(scanner.next());

            Sale sale1 = new Sale();
            sale1.setSeller(idSeller);
            sale1.setCostumer(idCostumer);
            sale1.setValue(value);
            sale1.setVehicle(typeCar);


            if (choice2 == 1) {
                double total = sale1.cashPayment(typeCar, value);
                System.out.println("Valor da compra : " + money.format(total));
            } else {
                System.out.println("Digite em quantas parcelas deseja fazer: ");
                int parcel = Integer.parseInt(scanner.next());
                double parceledTotal = sale1.parceledOutPayment(typeCar, value, parcel);
                double total = parceledTotal * parcel;
                System.out.println("Valor da compra: " + money.format(total) + " Valor da parcela: " +
                        money.format(parceledTotal) + " em " + parcel + " vezes");
            }
        }
}
