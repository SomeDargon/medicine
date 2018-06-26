package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.repository.attiendRecode.ImageRepository;
import com.medicine.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }
}
