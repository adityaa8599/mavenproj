import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final int defaultSize;
    private final EmployeeRepository employeeRepository;

    public EmployeeResource(int defaultSize, EmployeeRepository employeeRepository) {
        this.defaultSize = defaultSize;
        this.employeeRepository = employeeRepository;
    }

    @GET
    public List<Employee> getEmployee(@QueryParam("size") Optional<Integer> size) {
        return employeeRepository.findAll(size.orElse(defaultSize));
    }

    @GET
    @Path("/{id}")
    public Employee getById(@PathParam("id") Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }
}