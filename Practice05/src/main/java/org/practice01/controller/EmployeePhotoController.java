package org.practice01.controller;

import org.practice01.entity.Photo;
import org.practice01.service.EmployeeService;
import org.practice01.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@Controller
public class EmployeePhotoController {

@Autowired
    PhotoService photoService;
@Autowired
    EmployeeService employeeService;




    @RequestMapping("/")
    public String showUploadForm2() {
        return "employee";
    }
    @PostMapping("/submitLibrary")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @RequestParam("eid")  Integer eid, @RequestParam("ename") String ename, @RequestParam("date") LocalDate date) throws IOException {

        try {
            employeeService.saveData(file,eid,ename,date);
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Error uploading the file!");
        }
        return "redirect:/";
    }



    @GetMapping("/fetchPhotos")
    public String fetchPhotos(
            @RequestParam("eid") Integer eid,
            @RequestParam("ename") String ename,
            @RequestParam("fromDate") LocalDate fromDate,
            @RequestParam("toDate") LocalDate toDate,
            @RequestParam(value = "showHistory", required = false, defaultValue = "false") boolean showHistory,
            Model model
    ) {
        if (!showHistory) {
            // Logic to handle when "Show History" checkbox is not checked
            return "redirect:/getData"; // Redirect to the form page or any other appropriate action
        }


        List<Photo> photos = photoService.getPhotosByEmployeeAndDateRange(eid, fromDate, toDate);
        model.addAttribute("photos", photos);
        model.addAttribute("showHistory", showHistory);
//        return "photoList"; // Create a new Thymeleaf template (photoList.html) to display the photos
          return "fetchPhotos";
    }

    @GetMapping("/fetchPhotos5")
    public String fetchPhotoss(
            @RequestParam("eid") Integer eid,
            @RequestParam("ename") String ename,
            @RequestParam("fromDate") LocalDate fromDate,
            @RequestParam("toDate") LocalDate toDate,
            @RequestParam(value = "showHistory", required = false, defaultValue = "false") boolean showHistory,
            Model model
    ) {
        if (!showHistory) {
            // Logic to handle when "Show History" checkbox is not checked
            return "redirect:/getData"; // Redirect to the form page or any other appropriate action
        }


        List<Photo> photos = photoService.getPhotosByEmployeeIdEmployeeNameAndDateRange(eid, ename,fromDate, toDate);
        model.addAttribute("photos", photos);
        model.addAttribute("showHistory", showHistory);
        System.out.println(photos);
        if(!photos.isEmpty())
//        return "photoList"; // Create a new Thymeleaf template (photoList.html) to display the photos
        return "fetchPhotos";
        else return "fetchPhotos5";
    }

    @GetMapping("/getData")
    public String getData(){
//        return "fetchPhotos3";
        return "fetchPhotos5";

    }

    @GetMapping("/fetch")
    @ResponseBody
    public String hello(@RequestParam("eid") Integer eid ,@RequestParam("name" ) String name,@RequestParam("date") LocalDate date){
        System.out.println(eid);;
        System.out.println();;
//        return "hello   :"+eid+"  "+name+" "+date;
        return  "hello "+eid+" "+name+" "+date;

    }




    @GetMapping("/showPhoto")
    public ResponseEntity<byte[]> showPhoto(@RequestParam("photoId") Integer photoId) {
        try {
            // Retrieve the photo by photoId from the database
            Photo photo = photoService.getPhotoById(photoId);

            // Check if the photo exists
            if (photo != null && photo.getPhoto() != null) {
                // Return the photo bytes and set the content type as image/jpeg
                return ResponseEntity.ok()
                        .contentType(org.springframework.http.MediaType.IMAGE_JPEG)
                        .body(photo.getPhoto());
            } else {
                // Photo not found, return a 404 Not Found response
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Handle exceptions, return a 500 Internal Server Error response
            return ResponseEntity.status(500).build();
        }
    }



    @GetMapping("/fetchData")

    public String fetchData(@RequestParam("dataId") String dataId) {
        // Simulate fetching data based on the provided data ID
        // Replace this with your actual data fetching logic
        String fetchedData = "Data fetched for ID: " + dataId;

        return "index";
    }

    @GetMapping("/currentPage")
    public String fetchCurrentPage(){
        return "currentPage";
    }


    @GetMapping("/fetchData3")
    public String fetchPhotos2(
            @RequestParam("eid") Integer eid,
            @RequestParam("ename") String ename,
            @RequestParam("fromDate") LocalDate fromDate,
            @RequestParam("toDate") LocalDate toDate,
            @RequestParam(value = "showHistory", required = false, defaultValue = "false") boolean showHistory,
            Model model
    ) {
        if (!showHistory) {
            // Logic to handle when "Show History" checkbox is not checked
            return "redirect:/getData"; // Redirect to the form page or any other appropriate action
        }


        List<Photo> photos = photoService.getPhotosByEmployeeAndDateRange(eid, fromDate, toDate);
        model.addAttribute("photos", photos);
        model.addAttribute("showHistory", showHistory);
//        return "photoList"; // Create a new Thymeleaf template (photoList.html) to display the photos
        return "fetchPhotos3";
    }

    @GetMapping("/fetchData2")
    public String fetchData(@RequestParam("dataId") String dataId, Model model) {
        // Simulate fetching data based on the provided data ID
        // Replace this with your actual data fetching logic
        String fetchedData = "Data fetched for ID: " + dataId;

        // Pass the fetched data to the view
        model.addAttribute("fetchedData", fetchedData);

        // Return the view name to render
        return "fetchData2";
    }



    @GetMapping("/currentPage2")
    public String fetchCurrentPage2(){
        return "currentPage2";
    }
}

