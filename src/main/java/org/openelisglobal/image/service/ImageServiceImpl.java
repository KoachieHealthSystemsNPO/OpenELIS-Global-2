package org.openelisglobal.image.service;

import org.openelisglobal.common.service.BaseObjectServiceImpl;
import org.openelisglobal.image.dao.ImageDAO;
import org.openelisglobal.image.valueholder.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends BaseObjectServiceImpl<Image, String> implements ImageService {
    @Autowired
    protected ImageDAO baseObjectDAO;

    ImageServiceImpl() {
        super(Image.class);
        disableLogging();
    }

    @Override
    protected ImageDAO getBaseObjectDAO() {
        return baseObjectDAO;
    }

}
