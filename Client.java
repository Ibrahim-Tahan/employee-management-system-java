import java.util.Arrays;

public class Client extends Person{
    private int OrderID;
    private String [] Cart = new String[5];
    private Boolean loyalList;

    public Client (){
        super();
    }

    public Client(int orderID,String [] cart, Boolean loyalList){
        super();
        if (orderID>0){
            this.OrderID = orderID;
        }
        this.Cart = cart;
        this.loyalList = loyalList;
    }
    public Client(String Name, String Gender, int Age, Address address, int orderID, String [] cart, Boolean loyalList){
        super(Name, Gender, Age, address);
        if (orderID>0){
            this.OrderID = orderID;
        }
        this.Cart = cart;
        this.loyalList = loyalList;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        if (orderID>0){
            this.OrderID = orderID;
        }else{
            System.out.print("Invalid Order!!");
        }
    }

    public Boolean getLoyalList() {
        return this.loyalList;
    }
    public void setLoyalList(Boolean loyalList) {
        this.loyalList = loyalList;
    }

    public String[] getCart() {
        return this.Cart;
    }
    public void setCart(String[] cart) {
        this.Cart = cart;
    }

    @Override
    public String toString() {
        return   super.getName() +
                ", " + super.getAge() +
                ", " + super.getGender() +
                ", " + super.getAddress() +
                ", " + Arrays.toString(Cart) +
                ", " + loyalList +
                ", " + OrderID;
    }
}
