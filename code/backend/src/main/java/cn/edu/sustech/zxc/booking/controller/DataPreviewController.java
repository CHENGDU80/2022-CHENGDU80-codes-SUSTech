package cn.edu.sustech.zxc.booking.controller;

import cn.edu.sustech.zxc.booking.model.DataPreview;
import cn.edu.sustech.zxc.booking.service.DataPreviewService;
import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/datapreview")
public class DataPreviewController {
    @Autowired
    private DataPreviewService dataPreviewService;

    @GetMapping("/datapreview")
    public ResponseEntity<JSONObject> getAdmin() {
        List<DataPreview> data = dataPreviewService.getAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", data);
        return ResponseEntity.ok().body(jsonObject);
    }
}
