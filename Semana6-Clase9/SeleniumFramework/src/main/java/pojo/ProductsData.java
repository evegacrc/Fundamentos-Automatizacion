package pojo;

public class ProductsData {
    private String product;
    private String usdPrice;
    private String poundPrice;
    private String eurPrice;

    public ProductsData(String product, String usdPrice, String poundPrice, String eurPrice){
        this.setProduct(product);
        this.setUsdPrice(usdPrice);
        this.setPoundPrice(poundPrice);
        this.setEurPrice(eurPrice);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUsdPrice() { return usdPrice; }

    public void setUsdPrice(String usdPrice) {
        this.usdPrice = usdPrice;
    }

    public String getPoundPrice() {
        return poundPrice;
    }

    public void setPoundPrice(String poundPrice) {
        this.poundPrice = poundPrice;
    }

    public String getEurPrice() {
        return eurPrice;
    }

    public void setEurPrice(String eurPrice) {
        this.eurPrice = eurPrice;
    }
}
