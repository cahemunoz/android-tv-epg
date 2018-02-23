package se.kmdev.epg.domain;

/**
 * Created by Kristoffer.
 */
public interface EPGEvent {

    long getStart();

    long getEnd();

    String getTitle();

    boolean isCurrent();

    boolean isSelected();

    void setSelected(boolean selected);
}
