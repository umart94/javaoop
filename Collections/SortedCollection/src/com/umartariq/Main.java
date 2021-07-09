package com.umartariq;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	// write your code here
        StockItem temp = new StockItem("Bread",35.45,2);
        stockList.addStock(temp);

        temp = new StockItem("Milk",234.45,900);
        stockList.addStock(temp);

        temp = new StockItem("Cookie",20.55,800);
        stockList.addStock(temp);

        temp = new StockItem("Cookie",19.55,7);
        stockList.addStock(temp);

        temp = new StockItem("Lays",54.55,700);
        stockList.addStock(temp);

        temp = new StockItem("Maggi",46.554,600);
        stockList.addStock(temp);

        temp = new StockItem("Juice",34.44567,500);
        stockList.addStock(temp);

        temp = new StockItem("Popcorn",89.99,400);
        stockList.addStock(temp);

        temp = new StockItem("Rusk",59.876,300);
        stockList.addStock(temp);

        System.out.println(stockList);
        for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }
        System.out.println("=============TEST BASKET CODE========");
        Basket umarsBasket = new Basket("Umar");


        sellItem(umarsBasket,"Bread",1);
        System.out.println(umarsBasket);
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
        System.out.println(umarsBasket);
        System.out.println();
        System.out.println("=============TEST SELLING MULTIPLE ITEMS IN STOCK========");
        System.out.println(stockList);


        /*
        This will not run and run unsupportedoperationexception as we have used an unmodifiable map
         */
       //temp = new StockItem("pen",15);
       // stockList.Items().put(temp.getName(),temp);
        stockList.Items().get("Bread").adjustStock(2000);
        stockList.get("Bread").adjustStock(-1000);
        System.out.println(stockList);

        for(Map.Entry<String,Double> price : stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }


    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
