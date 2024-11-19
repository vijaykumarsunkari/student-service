
package com.springboot.api.dao;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.api.entity.Students;


@Repository
public interface StudentsDao extends JpaRepository<Students, Long>{
	Page<Students> findAllByActive(int active,Pageable pageable);
}
