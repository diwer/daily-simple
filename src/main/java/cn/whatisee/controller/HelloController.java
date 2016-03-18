package cn.whatisee.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppc on 2016/2/29.
 */
@Controller
public class HelloController {


    private class User {
        public User(String name, int sex) {
            this.name = name;
            this.sex = sex;
        }

        public void init() {
            child = new ArrayList<>();
            brother = new User("brother", 1);
            for (int i = 0; i < 5; i++) {
                User u = new User(String.format("{}{}", "c", i), 2);
                child.add(u);
            }
        }

        private User brother;
        private List<User> child;
        private String name;
        private int sex;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public User getBrother() {
            return brother;
        }

        public void setBrother(User brother) {
            this.brother = brother;
        }

        public List<User> getChild() {
            return child;
        }

        public void setChild(List<User> child) {
            this.child = child;
        }
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "helloWorld";
    }

    @RequestMapping(value = "/json", consumes = "application/json")
    @ResponseBody
    public String helloJson() {


        User obj = new User("ming", 1);

        //Object to JSON in file
        obj.init();
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //Object to JSON in String
        String jsonInString = null;
        try {
            jsonInString = writer.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
        return jsonInString;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/upload")
    public String provideUploadInfo() {
        return "uploadForm";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") Part file) throws IOException {
        if (!(file.getSize()>0)) {
            name =file.getName();
            InputStream inputstream=file.getInputStream();
            //byte[] bytes = file.getBytes();
            String rootPath = "d:/upload";
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();
            File serverFile = new File(dir.getAbsolutePath()
                            + File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            int i = 0;
            while(i != -1) {
                i = inputstream.read();
                stream.write(i);
            }
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }
}

