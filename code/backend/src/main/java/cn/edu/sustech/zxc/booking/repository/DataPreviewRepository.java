package cn.edu.sustech.zxc.booking.repository;

import cn.edu.sustech.zxc.booking.model.DataPreview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataPreviewRepository extends JpaRepository<DataPreview, Long> {
    List<DataPreview> findDataPreviewByName(String name);
}
