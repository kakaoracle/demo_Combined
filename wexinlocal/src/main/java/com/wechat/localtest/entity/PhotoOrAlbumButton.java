package com.wechat.localtest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-28 22:21
 **/
@Data
public class PhotoOrAlbumButton extends AbstractButton {
    private String type="pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button = new ArrayList<>();
    public PhotoOrAlbumButton(String name,String key) {
        super(name);
        this.key=key;
    }
}
