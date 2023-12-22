public class Address  {
    private String country;
    private String city;
    private int streetNum;

    public Address(){
        super();
    }

    public Address(String Country, String City, int StreetNum){
        country = Country;
        city = City;
        if (StreetNum<500 && StreetNum>0){
            streetNum = StreetNum;
        }
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getStreetNum() {
        return streetNum;
    }
    public void setStreetNum(int streetNum) {
        if (streetNum < 500 && streetNum > 0)
            this.streetNum = streetNum;
        else {
            System.out.println("Error!! Invalid Street Number");
            this.streetNum = Integer.parseInt("null");
        }
    }
    @Override
    public String toString() {
        return  getCountry() + ", " + getCity() + ", " + getStreetNum();
    }
}
