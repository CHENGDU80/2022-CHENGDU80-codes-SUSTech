package cn.edu.sustech.zxc.booking.controller;

import cn.edu.sustech.zxc.booking.controller.request.Type;
import cn.edu.sustech.zxc.booking.model.DataPreview;
import cn.edu.sustech.zxc.booking.model.Log;
import cn.edu.sustech.zxc.booking.repository.LogRepository;
import cn.edu.sustech.zxc.booking.service.LogService;
import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/log")
    public ResponseEntity<JSONObject> getCertainType(@RequestBody Type p) {
        System.out.println("out:"+p.getType());
        List<Log> data = logService.getLog(p.getType());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", data);
        return ResponseEntity.ok().body(jsonObject);
    }

    @GetMapping("/all")
    public ResponseEntity<JSONObject> getall() {
        List<Log> data = logService.getAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", data);
        return ResponseEntity.ok().body(jsonObject);
    }


}
