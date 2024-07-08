package com.kcdams.demo.Controller;

import com.kcdams.demo.Models.Picture;
import com.kcdams.demo.Repository.ReceptionImageRepository;
import com.kcdams.demo.Utility.ImageUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/receptionImage")
public class ReceptionImageController {
    @Autowired
    private ReceptionImageRepository receptionImageRepository;
    private ImageUtility imageUtility;

    @PostMapping(value = "/create/{mat_code}", consumes = "multipart/form-data")
    @Transactional
    public ResponseEntity.BodyBuilder uploadImage(
            @RequestParam("imageFile") MultipartFile file,
            @PathVariable("mat_code") String mat_code) throws IOException {
        Picture picture = new Picture();
        picture.setImageName(file.getOriginalFilename());
        picture.setImageUrl(ImageUtility.compressBytes(file.getBytes()));
        picture.setMatCode(mat_code);
        receptionImageRepository.save(picture);
            return ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/allReceptionPictures")
    public List<Picture> getAllReceptionPictures() {
        List<Picture> h = receptionImageRepository.findAll();
        List<Picture> new_list = new ArrayList<>();
        if (h.size() > 0) {
            for (Picture picture : h) {
                Picture new_picture = new Picture();
                new_picture.setImgID(picture.getImgID());
                new_picture.setImageName(picture.getImageName());
                new_picture.setMatCode(picture.getMatCode());
                new_picture.setImageUrl(ImageUtility.decompressBytes(picture.getImageUrl()));
                new_list.add(new_picture);
            }
        } else {
            return new ArrayList<>();
        }
        return new_list;
    }

    @GetMapping("/by-id/{id}")
    public Picture getReceptionPictureById(@PathVariable("id") int id) {
        Optional<Picture> picture = receptionImageRepository.findById(id);
        Picture new_picture = new Picture();
        if (picture.isPresent()) {
            new_picture.setImgID(picture.get().getImgID());
            new_picture.setMatCode(new_picture.getMatCode());
            new_picture.setImageName(picture.get().getImageName());
            new_picture.setImageUrl(ImageUtility.decompressBytes(picture.get().getImageUrl()));
            return new_picture;
        } else {
            return new Picture();
        }
    }

    @GetMapping("/by-mat-code/{mat_code}")
    public Picture getReceptionPictureByMatCode(@PathVariable("mat_code") String mat_code) {
        Optional<Picture> picture = receptionImageRepository.getReceptionPictureByMatCode(mat_code);
        Picture new_picture = new Picture();
        if (picture.isPresent()) {
            new_picture.setImgID(picture.get().getImgID());
            new_picture.setMatCode(picture.get().getMatCode());
            new_picture.setImageName(picture.get().getImageName());
            new_picture.setImageUrl(ImageUtility.decompressBytes(picture.get().getImageUrl()));
            return new_picture;
        } else {
            return new Picture();
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReceptionPicture(@PathVariable int id){
        receptionImageRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
