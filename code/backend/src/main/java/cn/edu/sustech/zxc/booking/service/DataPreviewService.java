package cn.edu.sustech.zxc.booking.service;

import cn.edu.sustech.zxc.booking.model.DataPreview;
import cn.edu.sustech.zxc.booking.repository.DataPreviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPreviewService {
    @Autowired
    private DataPreviewRepository dataPreviewRepository;
    public List<DataPreview> getAll(){
        return dataPreviewRepository.findAll();
    }
}
