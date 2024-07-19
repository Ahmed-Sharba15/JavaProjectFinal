package superMarketWeb;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query(value = "select * from customers where id=?1",nativeQuery = true)
    public List<Customer> search(@Param("keyword") long id);

}

