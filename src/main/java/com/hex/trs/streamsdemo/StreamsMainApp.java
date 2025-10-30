package com.hex.trs.streamsdemo;

import java.util.List;

public class StreamsMainApp {
    public static void main(String[] args) {
        StreamsService streamsService = new StreamsService();
        List<Product> list = streamsService.populateProducts();
        /* 1. Filter as per category MOBILE
        * S1: Give list to Stream  -- list.stream()
        * S2: Process(Filter) in Stream --> p->p.getCategory().equals(Category.MOBILE) -- if true the record stays otherwise its gone
        * S3: Convert it back to list
        * */
        List<Product> filteredList =  list
                                        .stream()
                                        .filter(p->p.getCategory().equals(Category.DESKTOP))
                                        .toList();
        streamsService.displayList(filteredList);

        // Sort products as per their price in Asc order
        List<Product> sortedList = list.stream()
                                    .sorted((p1,p2)->(int) (p2.getPrice() - p1.getPrice()))
                                    .toList();
        streamsService.displayList(sortedList);

        // Map => derive a specific field from the list object
        // Map => get me list of names of products

        List<String> productNames =  list.stream()
                                            .map((p)->p.getTitle())
                                            .toList();
        System.out.println(productNames);
    }
}
//5  7  : 5-7 = -ve   : [5,7]
//6  3  : 6-3 = +ve  : [3,6]
// n numbers:- 2=> n numbers  6 8