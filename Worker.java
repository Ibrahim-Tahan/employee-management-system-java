public class Worker extends Person{
    private int Salary;
    private String Position;
    private String Role;

    public Worker(){
        super();
    }

    public Worker(int Salary, String Position, String Role){
        super();
        if (Salary>0)
        {
            this.Salary=Salary;
        }
        if (Position.equals("Employee") || Position.equals("Supervisor") || Position.equals("Manager") )
        {
            this.Position=Position;
        }
        this.Role = Role;
    }


    public Worker(String Name, String Gender, int Age, Address address, int Salary, String Position, String Role){
        super(Name, Gender, Age, address);
        if (Salary>0){
            this.Salary=Salary;
        }
        if (Position.equals("Employee") || Position.equals("Supervisor") || Position.equals("Manager") ){
            this.Position=Position;
        }
        this.Role = Role;
    }

    public int getSalary() {
        return Salary;
    }
    public void setSalary(int salary) {
        if (salary>0)
            this.Salary = salary;
        else
            System.out.println("Invalid Salary!!");
    }

    public String getPosition() {
        return this.Position;
    }
    public void setPosition(String position) {
        if (position.equals("Employee") || position.equals("Supervisor") || position.equals("Manager"))
            this.Position=position;
        else
            System.out.println("Invalid Position!!");
    }

    public String getRole() {
        return this.Role;
    }
    public void setRole(String role) {
        this.Role = role;
    }

    @Override
    public String toString() {
        return  super.getName() +
                ", " + super.getAge() +
                ", " + super.getGender() +
                ", "+ super.getAddress() +
                ", " + Salary +
                ", " + Position +
                ", " + Role ;
    }
}
