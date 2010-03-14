/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubenlaguna.en4j.sync;

import com.evernote.edam.type.Data;
import com.evernote.edam.type.Resource;
import java.util.Date;

/**
 *
 * @author Ruben Laguna <ruben.laguna@gmail.com>
 */
class ResourceAdapter implements com.rubenlaguna.en4j.noteinterface.Resource {

    private final com.evernote.edam.type.Resource resource;

    public ResourceAdapter(com.evernote.edam.type.Resource resource) {
        this.resource = resource;
    }

    public byte[] getData() {
        final Data data = resource.getData();
        if (data==null){
            return null;
        }
        return data.getBody();
    }

    public byte[] getAlternateData() {
        final Data alternateData = resource.getAlternateData();
        if (alternateData==null){
            return null;
        }
        return alternateData.getBody();
    }

    public double getAltitude() {
        return resource.getAttributes().getAltitude();
    }

    public double getLatitude() {
        return resource.getAttributes().getLatitude();
    }

    public double getLongitude() {
        return resource.getAttributes().getLongitude();
    }

    public boolean getPremiumAttachment() {
        return resource.getAttributes().isAttachment();
    }

    public String getCameraMake() {
        return resource.getAttributes().getCameraMake();
    }

    public String getCameraModel() {
        return resource.getAttributes().getCameraModel();
    }

    public String getFilename() {
        return resource.getAttributes().getFileName();
    }

    public String getGuid() {
        return resource.getGuid();
    }

    public String getMime() {
        return resource.getMime();
    }

    public String getNoteguid() {
        return resource.getNoteGuid();
    }

    public byte[] getRecognition() {
        final Data recognition = resource.getRecognition();
        if(null==recognition){
            return null;
        }
        return recognition.getBody();
    }

    public Date getTimestamp() {
        return new Date(resource.getAttributes().getTimestamp());
    }
}