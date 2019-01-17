package se.kmdev.epg.misc;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import se.kmdev.epg.EPGData;
import se.kmdev.epg.domain.EPGChannel;
import se.kmdev.epg.domain.EPGEvent;

/**
 * TODO: Add null check when fetching at position etc.
 * Created by Kristoffer on 15-05-23.
 */
public class EPGDataImpl implements EPGData {

    private List<EPGChannel> channels = Lists.newArrayList();
    private List<List<EPGEvent>> events = Lists.newArrayList();
    private EPGEvent highlightedEvent = null;


    public EPGDataImpl(Map<EPGChannel, List<EPGEvent>> data) {
        channels = Lists.newArrayList(data.keySet());
        events = Lists.newArrayList(data.values());
    }

    public EPGChannel getChannel(int position) {
        return channels.get(position);
    }

    public List<EPGEvent> getEvents(int channelPosition) {
        return events.get(channelPosition);
    }

    public EPGEvent getEvent(int channelPosition, int programPosition) {
        return events.get(channelPosition).get(programPosition);
    }

    public int getChannelCount() {
        return channels.size();
    }

    @Override
    public boolean hasData() {
        return !channels.isEmpty();
    }


    @Override
    public void cleanSelection() {
        for (EPGChannel channel: this.channels )
            if(channel.isSelected()) channel.setSelected(false);

        for (List<EPGEvent> channelEvents : this.events) {
            for (EPGEvent event : channelEvents) {
                if(event.isSelected()) event.setSelected(false);
            }
        }

    }

    @Override
    public void setSelection(int channelPosition, int programPosition) {
        getChannel(channelPosition).setSelected(true);
        highlightedEvent = getEvent(channelPosition, programPosition);
        highlightedEvent.setSelected(true);
    }

    @Override
    public EPGEvent getHighlightedEvent() {
        return highlightedEvent;
    }
}
