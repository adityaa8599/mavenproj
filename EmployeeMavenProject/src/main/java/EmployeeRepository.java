import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private final List<Employee> employee;

    public EmployeeRepository(List<Employee> employee){
        this.employee=ImmutableList.copyOf(employee);
    }

    public List<Employee> findAll(int size){
        return employee.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public Optional<Employee> findById(Long id) {
        return employee.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }
}
