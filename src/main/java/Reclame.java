public class Reclame extends Activities{
    String productName;

    Reclame (String productName, int price, String time){
        this.productName = productName;
        this.price = price;
        this.time = convertToSecond(time);
    }

    @Override
    public String toString() {
        return "Reclame{" +
                "productName='" + productName + '\'' +
                '}';
    }
}
