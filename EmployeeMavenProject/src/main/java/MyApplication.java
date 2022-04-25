import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application<BasicConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run("server", "local-config.yaml");
    }

    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) {
        int defaultSize = basicConfiguration.getDefaultSize();
        EmployeeRepository employeeRepository = new EmployeeRepository(initEmployees());
        EmployeeResource employeeResource = new EmployeeResource(defaultSize, employeeRepository);

        environment
                .jersey()
                .register(employeeResource);
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }

    public List<Employee> initEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(30L,"ruchi",19,50L));
        employees.add(new Employee(31L,"nikita",19,51L));
        employees.add(new Employee(32L,"ananya",20,54L));

        return employees;
    }

}