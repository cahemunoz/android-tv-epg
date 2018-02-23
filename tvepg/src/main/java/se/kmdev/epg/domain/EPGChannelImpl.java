package se.kmdev.epg.domain;

/**
 * Created by carlos on 23/02/18.
 */

public class EPGChannelImpl implements EPGChannel{
    private final String channelID;
    private final String name;
    private final String imageURL;

    public EPGChannelImpl(String imageURL, String name, String channelID) {
        this.imageURL = imageURL;
        this.name = name;
        this.channelID = channelID;
    }

    public String getChannelID() {
        return channelID;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
