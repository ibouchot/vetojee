/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ivan
 */
@ManagedBean
public class image {
    
    private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 0; i <= 5; i++) {
            images.add("img" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

}
