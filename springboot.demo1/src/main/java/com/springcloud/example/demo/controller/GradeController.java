package com.springcloud.example.demo.controller;

import com.springcloud.example.demo.model.MoGrade;
import com.springcloud.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Configuration
@Controller
@RequestMapping("/grade")
public class GradeController {

    @Value("${spring.datasource.url}")
    private String testUrl;

    @Autowired
    private GradeService gradeService;

    @GetMapping("getGrade/{id}")
    @ResponseBody
    public MoGrade getGrade(@PathVariable("id") int id) {

        return gradeService.getGradeById(id);
    }

    @PostMapping("addGrade")
    public int getGrade(MoGrade moGrade) {

        return gradeService.addGrade(moGrade);
    }

    @RequestMapping("grades")
    public List<MoGrade> grades(MoGrade moGrade) {
        return gradeService.getAllGrades(moGrade);
    }

    @GetMapping("/upload")
    public String uploadIndex(Model model) {

        System.out.println(testUrl);

        List<MoGrade> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            MoGrade moGrade = new MoGrade();

            moGrade.setGradename("班级"+i);
            moGrade.setId(i);
            list.add(moGrade);
        }

        model.addAttribute("grades",list);

        return "upload";
    }

    @GetMapping("/uploadresult")
    public String uploadresult() {
        return "uploadresult";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam List<MultipartFile> files, RedirectAttributes redirectAttributes) throws Exception {

        System.out.println("上传文件数量：" + files.size());
        StringBuilder stringBuilder = new StringBuilder();

        throw new Exception("324");

//        for (MultipartFile file :
//                files) {
//            if (file.isEmpty()) {
//                continue;
//            }
//
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get("D:\\D\\TTest", String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')));
//                Files.write(path, bytes);
//                stringBuilder.append("文件名称：" + file.getOriginalFilename()).append("文件服务器路径：" + path);
//
//            } catch (Exception ex) {
//            }
//        }
//
//        redirectAttributes.addFlashAttribute("message", stringBuilder);
//
//        return "redirect:uploadresult";
    }

}
