package org.utarid.server.repository.contant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConstantRepository extends JpaRepository<ConstantEntity, Integer> {

    @Query("SELECT b FROM ConstantEntity b WHERE b.key = :pConstantKey")
    ConstantEntity getConstant(@Param("pConstantKey") String pConstantKey);
}
