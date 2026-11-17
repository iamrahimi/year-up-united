package com.iamsrahimi.assetsManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AssetsManager {
    public static void main(String[] args) {
        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(new House(
                "my house", "2020-06-15", new BigDecimal("450000.00"),
                "123 Cedar Street, Seattle, WA", 2, 1800, 6000));
        myAssets.add(new House(
                "vacation home", "2022-08-03", new BigDecimal("325000.00"),
                "45 Lake View Road, Leavenworth, WA", 3, 1400, 8500));
        myAssets.add(new Vehicle(
                "my car", "2022-03-10", new BigDecimal("38000.00"),
                "Honda CR-V", 2022, 108000));
        myAssets.add(new Vehicle(
                "Tom's truck", "2018-11-20", new BigDecimal("42000.00"),
                "Ford F-150", 2015, 145000));

        System.out.println("ASSETS MANAGER");
        System.out.println("==============");

        for (Asset asset : myAssets) {
            String specificDetails = "";

            if (asset instanceof House) {
                House house = (House) asset;
                specificDetails = "House at " + house.getAddress();
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                specificDetails = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            }

            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date acquired: " + asset.getDateAcquired());
            System.out.println("Original cost: $" + money(asset.getOriginalCost()));
            System.out.println("Current value: $" + money(asset.getValue()));
            System.out.println(specificDetails);
            System.out.println();
        }
    }

    private static String money(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
