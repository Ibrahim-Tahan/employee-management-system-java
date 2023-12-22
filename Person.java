public class  Person {
    private String Name;
    private int Age;
    private String Gender;
    private Address address;

    public Person(){
        super();
    }

    public Person(String Name, String Gender, int Age, Address address) {
        this.Name = Name;
        if (Age > 0 && Age < 100) {
            this.Age = Age;
        }
        else {
            return;
        }
        if (Gender.equals("Male") || Gender.equals("Female")) {
            this.Gender = Gender;
        }
        this.address = address;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return this.Age;
    }
    public void setAge(int age) {
        if (age>0 && age<100)
            this.Age = age;
        else
            System.out.println("Invalid Age!!");
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        if (gender.equals("Male")) {
            Gender= "Male";
        }
        else if (gender.equals("Female")){
            Gender="Female";
        }
        else System.out.print("Invalid Gender!!");
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

 /*   @Override
    public String toString() {
        return "Person: " +
                "Name= " + Name +
                ", Age= " + Age +
                ", Gender= " + Gender +
                ", "+ getAddress();
    }*/
}
