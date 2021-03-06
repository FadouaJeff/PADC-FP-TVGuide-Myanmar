package com.padc.tvguide.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.padc.tvguide.TVGuideApp;
import com.padc.tvguide.data.persistence.TVGuideContract.ChannelProgramEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/17/2016.
 */
public class ChannelProgramVO {

    private int channel_program_id;
    private String air_date;
    private String air_day;
    private String start_time;
    private int duration;
    private int channel_id;
    private int program_id;
    private String channel_name;
    private long row_timestamp;
    private int record_status;
    private ProgramVO program;
/*    private int parent_id;
    private String program_title;
    private String parent_title;
    private String program_desc;
    private String program_image;
    private ArrayList<TagVO> tags;*/

    public int getChannel_program_id() {
        return channel_program_id;
    }

    public void setChannel_program_id(int channel_program_id) {
        this.channel_program_id = channel_program_id;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getAir_day() {
        return air_day;
    }

    public void setAir_day(String air_day) {
        this.air_day = air_day;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public long getRow_timestamp() {
        return row_timestamp;
    }

    public void setRow_timestamp(long row_timestamp) {
        this.row_timestamp = row_timestamp;
    }

    public int getRecord_status() {
        return record_status;
    }

    public void setRecord_status(int record_status) {
        this.record_status = record_status;
    }

    public ProgramVO getProgram() {
        return program;
    }

    public void setProgram(ProgramVO program) {
        this.program = program;
    }

    public static void saveChannelPrograms(List<ChannelProgramVO> channelProgramVOList) {
        Context context = TVGuideApp.getContext();
        ContentValues[] channelProgramCVs = new ContentValues[channelProgramVOList.size()];
        for (int index = 0; index < channelProgramVOList.size(); index++) {
            ChannelProgramVO channelProgram = channelProgramVOList.get(index);
            channelProgramCVs[index] = channelProgram.parseToContentValues();

            ProgramVO.saveProgram(channelProgram.getProgram());
        }

        //Bulk insert into channels.
        int insertedCount = context.getContentResolver().bulkInsert(ChannelProgramEntry.CONTENT_URI, channelProgramCVs);

        Log.d(TVGuideApp.TAG, "Bulk inserted into channel table : " + insertedCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(ChannelProgramEntry.COLUMN_CHANNEL_PROGRAM_ID, channel_program_id);
        cv.put(ChannelProgramEntry.COLUMN_AIR_DATE, air_date);
        cv.put(ChannelProgramEntry.COLUMN_AIR_DAY, air_day);
        cv.put(ChannelProgramEntry.COLUMN_START_TIME, start_time);
        cv.put(ChannelProgramEntry.COLUMN_DURATION, duration);
        cv.put(ChannelProgramEntry.COLUMN_CHANNEL_ID, channel_id);
        cv.put(ChannelProgramEntry.COLUMN_PROGRAM_ID, program_id);
        cv.put(ChannelProgramEntry.COLUMN_ROW_TIMESTAMP, row_timestamp);
        cv.put(ChannelProgramEntry.COLUMN_RECORD_STATUS, record_status);
        return cv;
    }

    public static ChannelProgramVO parseFromCursor(Cursor data) {
        ChannelProgramVO channelProgram = new ChannelProgramVO();
        channelProgram.channel_program_id = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_CHANNEL_PROGRAM_ID));
        channelProgram.air_date = data.getString(data.getColumnIndex(ChannelProgramEntry.COLUMN_AIR_DATE));
        channelProgram.air_day = data.getString(data.getColumnIndex(ChannelProgramEntry.COLUMN_AIR_DAY));
        channelProgram.start_time = data.getString(data.getColumnIndex(ChannelProgramEntry.COLUMN_START_TIME));
        channelProgram.duration = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_DURATION));
        channelProgram.channel_id = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_CHANNEL_ID));
        channelProgram.program_id = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_PROGRAM_ID));
        channelProgram.row_timestamp = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_ROW_TIMESTAMP));
        channelProgram.record_status = data.getInt(data.getColumnIndex(ChannelProgramEntry.COLUMN_RECORD_STATUS));
        return channelProgram;
    }
}
