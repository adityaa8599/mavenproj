public class Employee {
    private final Long id;
    private final String name;
    private final int age;
    private final Long salary;

    public Employee(Long id, String name, int age, Long salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
    }



    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Long getSalary(){
        return salary;
    }
}
