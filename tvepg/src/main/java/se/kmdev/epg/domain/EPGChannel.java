package se.kmdev.epg.domain;

/**
 * Created by Kristoffer.
 */
public interface EPGChannel {

    String getChannelID() ;

    String getName();

    String getImageURL();

    boolean isSelected();

    void setSelected(boolean selected);
}
