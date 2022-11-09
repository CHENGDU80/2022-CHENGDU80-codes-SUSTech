package cn.edu.sustech.zxc.booking.service;

import cn.edu.sustech.zxc.booking.model.DataPreview;
import cn.edu.sustech.zxc.booking.model.Log;
import cn.edu.sustech.zxc.booking.repository.DataPreviewRepository;
import cn.edu.sustech.zxc.booking.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;
    public List<Log> getLog(String type){
        return logRepository.findLogsByOperation(type);
    }
    public List<Log> getAll(){
        return logRepository.findAll();
    }
}
