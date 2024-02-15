package org.practice01.service;

import org.practice01.entity.Photo;
import org.practice01.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class PhotoService {


    @Autowired
    PhotoRepository photoRepository;
    public List<Photo> findPhotosByEmployeeId(Integer dynamicId){
        List<Photo> photos = photoRepository.findPhotosByEmployeeId(dynamicId);
        return photos;
    }

    public List<Photo> getPhotosByEmployeeAndDateRange(Integer eid, LocalDate fromDate, LocalDate toDate) {
        List<Photo > photos = photoRepository.findByEmployee_EidAndDateBetween(eid, fromDate, toDate);


        for (Photo photo : photos) {
            String timeSinceAdded = calculateTimeSince(photo.getDate());
            photo.setTimeSinceAdded(timeSinceAdded);
        } return photos;
    }


    public List<Photo> getPhotosByEmployeeIdEmployeeNameAndDateRange(Integer eid,String ename,  LocalDate fromDate, LocalDate toDate) {
        List<Photo > photos = photoRepository.findByEmployeeIdAndEnameAndDateBetween(  eid,  ename,  fromDate,   toDate);


        for (Photo photo : photos) {
            String timeSinceAdded = calculateTimeSince(photo.getDate());
            photo.setTimeSinceAdded(timeSinceAdded);
        } return photos;
    }



    public Photo getPhotoById(Integer photoId) {

         List<Photo> photoList= photoRepository.findAll();
         List<Photo> photo = new ArrayList<>();
         for(Photo p :photoList){
             if(p.getPid().equals(photoId)){
                 photo.add(p);
             }
         }
         return photo.get(0);
    }
    public static String calculateTimeSince(LocalDate dateAdded) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateAdded, currentDate);

        if (period.getYears() == 0) {
            return "less than 1 year ago";
//        } else if (period.getYears() == 1) {
//            return "less than 2 years ago";
        } else {
            // You can add more conditions based on your requirements
            return "less than "+(period.getYears()+1) +" years ago";
        }
    }


}
