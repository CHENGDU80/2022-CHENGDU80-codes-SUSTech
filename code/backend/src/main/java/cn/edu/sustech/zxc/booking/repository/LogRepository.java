package cn.edu.sustech.zxc.booking.repository;

import cn.edu.sustech.zxc.booking.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findLogsByOperation(String operation);
}
