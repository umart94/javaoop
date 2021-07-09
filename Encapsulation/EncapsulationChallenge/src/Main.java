public class Main {

    public static void main(String[] args) {

        Printer HpPrinter = new Printer(50,false);
        System.out.println("Initial Page Count = "+HpPrinter.getPagesPrinted());
        int pagesPrinted = HpPrinter.printPages(43);
        System.out.println("pages printed was"+pagesPrinted+"new Total print count for printer"+HpPrinter.getPagesPrinted());
    }
}
