package com.umartariq;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	// write your code here

        StockItem temp = new StockItem("Bread",35.45,2);
        stockList.addStock(temp);

        temp = new StockItem("Milk",234.45,80);
        stockList.addStock(temp);

        temp = new StockItem("Cookie",20.55,70);
        stockList.addStock(temp);

        temp = new StockItem("Cookie",19.55,60);
        stockList.addStock(temp);

        temp = new StockItem("Lays",54.55,50);
        stockList.addStock(temp);

        temp = new StockItem("Maggi",46.554,40);
        stockList.addStock(temp);

        temp = new StockItem("Juice",34.44567,30);
        stockList.addStock(temp);

        temp = new StockItem("Popcorn",89.99,20);
        stockList.addStock(temp);

        temp = new StockItem("Rusk",59.876,10);
        stockList.addStock(temp);

  //      System.out.println(stockList);
       /* for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }
*/


/*
        sellItem(umarsBasket,"Bread",1);
        System.out.println(umarsBasket);
        sellItem(umarsBasket,"Bread",1);
        sellItem(umarsBasket,"oreoshake",1);
        System.out.println(umarsBasket);
        if( sellItem(umarsBasket,"Bread",1) != 1 ){
            System.out.println("There is no more Bread Left In The Stock");
        }
        System.out.println(umarsBasket);
        //will get stuck at 1 item... as we don't want 0 bread items in our stock
        System.out.println("=============TEST BASKET CODE========");


        System.out.println("=============TEST ITEM NOT IN STOCK========");
        sellItem(umarsBasket,"DanishButterCookies",3456);
        //System.out.println(umarsBasket);
        System.out.println("=============TEST ITEM NOT IN STOCK========");


        System.out.println("=============TEST SELLING MULTIPLE ITEMS IN STOCK========");
        sellItem(umarsBasket,"Cookie",20);
        sellItem(umarsBasket,"Lays",30);
        sellItem(umarsBasket,"Rusk",40);
        //System.out.println(umarsBasket);
        System.out.println();
        System.out.println("=============TEST SELLING MULTIPLE ITEMS IN STOCK========");
        //System.out.println(stockList);


        /*
        This will not run and run unsupportedoperationexception as we have used an unmodifiable map
         */
       //temp = new StockItem("pen",15);
       // stockList.Items().put(temp.getName(),temp);




        System.out.println("****************************** SORTED--COLLECTION--CHALLENGE *********************************");

        Basket customerBasket = new Basket("Mr. Customer");
        sellItem(customerBasket,"Maggi",30);
        sellItem(customerBasket,"Juice",20);
        sellItem(customerBasket,"Popcorn",10);
        sellItem(customerBasket,"Rusk",5);
        System.out.println(customerBasket);
        checkOut(customerBasket);
        System.out.println(customerBasket);
        System.out.println(stockList);

        Basket umarsBasket = new Basket("Umar");
        sellItem(umarsBasket,"Bread",2);
        sellItem(umarsBasket,"Maggi",10);
        sellItem(umarsBasket,"Juice",10);
        sellItem(umarsBasket,"Popcorn",10);
        sellItem(umarsBasket,"Rusk",5);
        System.out.println(umarsBasket);
        checkOut(umarsBasket);
        System.out.println(umarsBasket);
        System.out.println(stockList);

/*
        stockList.Items().get("Bread").adjustStock(2000);
        stockList.get("Bread").adjustStock(-1000);
        System.out.println(stockList);

        for(Map.Entry<String,Double> price : stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

*/

        StockItem bread = stockList.Items().get("Bread");
        if(bread != null){
            bread.adjustStock(1234);
        }
        if(bread != null){
            stockList.get("Bread").adjustStock(-234);
        }
        System.out.println("===============");
        System.out.println(stockList);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            //basket.addToBasket(stockItem, quantity);
            //return quantity;
            return basket.addToBasket(stockItem,quantity);
            //returning quantity here is a bug
            //we should return result of addToBasket
        }
        return 0;
    }


    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);//ok
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item,quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem,Integer> item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }



}
