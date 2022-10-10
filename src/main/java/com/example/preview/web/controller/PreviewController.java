package com.example.preview.web.controller;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:02
*/

import com.example.preview.entity.CmfAfVoucherAttachment;
import com.example.preview.entity.Preview;
import com.example.preview.service.PreviewService;
import com.example.preview.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@Api(tags = "附件预览下载")
public class PreviewController {
    @Autowired
    private PreviewService previewService;

    @PostMapping("/postParams")
    @ApiOperation(value = "获取预览url")
    public Result postParams(@RequestBody Preview preview){
        Map<String,String> map =previewService.postParams(preview.getPath(),preview.getType(),preview.getName());
        if (map.get("msg")!=null){
            return Result.succeed(null,map.get("msg"),"false");
        }
        return Result.succeed(map.get("data"));
    }

    @PostMapping("/download")
    @ApiOperation(value = "单个文件下载")
    public Result download(@RequestBody Preview preview , HttpServletResponse response){
        response=previewService.download(preview.getPath(), preview.getName(),response);
        if (response==null){
            return Result.succeed("","下载失败","false");
        }
        return Result.succeed();
    }

    @PostMapping("/downloadZip")
    @ApiOperation(value = "批量文件下载")
    public Result downloadZip(@RequestBody List<Preview> previewList, HttpServletResponse response){
        response=previewService.downloadzip(previewList,response);
        if (response==null){
            return Result.succeed("","下载失败","false");
        }
        return Result.succeed();

    }
    @RequestMapping(value = "/public/checkApplNodeStatus", method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "测试接口是否成功")
    public Result checkApplNodeStatus(){
        return Result.succeed();
    }

    @RequestMapping(value = "/fileExists", method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "判断文件是否存在")
    public Result fileExists(@RequestBody List<CmfAfVoucherAttachment> cmfAfVoucherAttachmentList){
        Map<String, List<CmfAfVoucherAttachment>> resultMap=previewService.fileExists(cmfAfVoucherAttachmentList);
        if (resultMap.get("false")!=null){
            return Result.succeed(resultMap,"文件不存在","false");
        }
        return Result.succeed();
    }


    @PostMapping("/downloadZhuZhouFile")
    public Result downloadZhuZhouFile(HttpServletResponse response, @RequestBody Preview preview) {
        try {
            previewService.downloadStreamFile(response, preview.getPath(), preview.getName());
        } catch (Exception e) {
            return Result.succeed("",e.getMessage(),"false");
        }
        return Result.succeed();
    }
}

