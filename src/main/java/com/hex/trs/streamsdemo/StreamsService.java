package com.hex.trs.streamsdemo;

import java.util.ArrayList;
import java.util.List;

public class StreamsService {

    public List<Product> populateProducts(){
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor(101, "TechCorp", "Seattle"));
        vendors.add(new Vendor(102, "InnoSol", "Seoul"));
        vendors.add(new Vendor(103, "FutureLink", "Shenzhen"));
        vendors.add(new Vendor(104, "GlobalPC", "Taipei"));
        vendors.add(new Vendor(105, "MobileWorld", "San Jose"));
        vendors.add(new Vendor(106, "AlphaDevices", "Tokyo"));
        vendors.add(new Vendor(107, "ProGears", "Berlin"));
        vendors.add(new Vendor(108, "Zenith Systems", "Austin"));
        vendors.add(new Vendor(109, "ConnectAll", "London"));
        vendors.add(new Vendor(110, "PeakTech", "Mumbai"));


        List<Product> products = new ArrayList<>();

        // Products are associated with vendors based on their index for simplicity
        products.add(new Product(1, "AeroBook X1", 1299.99, Category.LAPTOP, vendors.get(0)));
        products.add(new Product(2, "Galaxy Z-Flip", 899.00, Category.MOBILE, vendors.get(1)));
        products.add(new Product(3, "Gaming Cube 5000", 1850.50, Category.DESKTOP, vendors.get(2)));
        products.add(new Product(4, "Ultra Slim Pro", 1599.99, Category.LAPTOP, vendors.get(3)));
        products.add(new Product(5, "MobiPro 14", 699.00, Category.MOBILE, vendors.get(4)));
        products.add(new Product(6, "Office Tower 3", 750.00, Category.DESKTOP, vendors.get(5)));
        products.add(new Product(7, "TravelMate Lite", 450.00, Category.LAPTOP, vendors.get(6)));
        products.add(new Product(8, "Nexus Phone 12", 1099.99, Category.MOBILE, vendors.get(7)));
        products.add(new Product(9, "Compact Mini PC", 550.00, Category.DESKTOP, vendors.get(8)));
        products.add(new Product(10, "The Dominator", 2499.00, Category.DESKTOP, vendors.get(9)));

        return products;
    }

     public void displayList(List<Product> list){
         list.forEach((p)->{
             System.out.print(p.getTitle() +"  ");
             System.out.print(p.getPrice()+"  ");
             System.out.print(p.getCategory()+"  ");
             System.out.println(p.getVendor().getName());
             System.out.println("-------------------------");
         });
    }
}
