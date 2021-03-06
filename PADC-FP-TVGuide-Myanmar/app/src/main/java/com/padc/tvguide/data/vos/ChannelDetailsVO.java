package com.padc.tvguide.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.padc.tvguide.TVGuideApp;
import com.padc.tvguide.data.persistence.TVGuideContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/10/2016.
 */
public class ChannelDetailsVO {

    private ChannelVO channel;
    private ArrayList<CategoryVO> categories;
    @SerializedName("programs")
    private ArrayList<ChannelProgramVO> channel_programs;

    public ChannelVO getChannel() {
        return channel;
    }

    public void setChannel(ChannelVO channel) {
        this.channel = channel;
    }

    public ArrayList<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryVO> categories) {
        this.categories = categories;
    }

    public ArrayList<ChannelProgramVO> getChannel_programs() {
        return channel_programs;
    }

    public void setChannel_programs(ArrayList<ChannelProgramVO> channel_programs) {
        this.channel_programs = channel_programs;
    }

    public ChannelDetailsVO(ChannelVO channelVO) {
        this.channel = channelVO;
        this.categories = new ArrayList<>();
        this.channel_programs = new ArrayList<>();
    }

    public ChannelDetailsVO(int channel_id, String channel_name, String channel_icon) {
        this.channel = new ChannelVO(channel_id, channel_name, channel_icon);
        this.categories = new ArrayList<>();
        this.channel_programs = new ArrayList<>();
    }

    public List<ChannelProgramVO> getChannelProgramsByAirDay(String air_day, Boolean fromNetworkLayer){
        List<ChannelProgramVO> channelProgramVOList = new ArrayList<>();
        if(channel_programs != null) {
            for (int index = 0, size = channel_programs.size(); index < size; index++) {
                if (channel_programs.get(index).getAir_day().equalsIgnoreCase(air_day))
                    channelProgramVOList.add(channel_programs.get(index));
            }
            Log.e(TVGuideApp.TAG, "ChannelDetailsVO.getChannelProgramsByAirDay.size : " + channelProgramVOList.size() + " : " + air_day);
        }
        if(fromNetworkLayer && air_day.equalsIgnoreCase("Sat")){
            Log.e(TVGuideApp.TAG, "ChannelDetailsVO.getChannelProgramsByAirDay().channelProgramVOList.size(): " + channelProgramVOList.size());
        }
        return channelProgramVOList;
    }

    public static void saveChannelDetails(ChannelDetailsVO channelDetailsVO) {
        ChannelVO.saveChannel(channelDetailsVO.getChannel());

        //Bulk insert into channel_programs.
        ChannelProgramVO.saveChannelPrograms(channelDetailsVO.getChannel_programs());
    }
}
