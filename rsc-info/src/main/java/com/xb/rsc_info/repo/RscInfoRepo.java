package com.xb.rsc_info.repo;

import com.xb.rsc_info.model.RscInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RscInfoRepo extends JpaRepository<RscInfo, Long> {

}
