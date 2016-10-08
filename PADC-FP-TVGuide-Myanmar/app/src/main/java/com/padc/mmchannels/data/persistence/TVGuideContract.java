package com.padc.mmchannels.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.padc.mmchannels.MMChannelsApp;

/**
 * Created by user on 9/24/2016.
 */
public class TVGuideContract {
    public static final String CONTENT_AUTHORITY = MMChannelsApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_CHANNELS = "channels";
    public static final String PATH_PROGRAMS = "programs";
    public static final String PATH_CHANNEL_PROGRAMS = "channel_programs";
    public static final String PATH_MY_CHANNELS = "my_channels";
    public static final String PATH_MY_WATCHLIST = "my_watchlist";
    public static final String PATH_MY_REMINDERS = "my_reminders";

    public static final class ChannelEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CHANNELS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHANNELS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHANNELS;

        public static final String TABLE_NAME = "channels";

        public static final String COLUMN_CHANNEL_ID = "channel_id";
        public static final String COLUMN_CHANNEL_NAME = "channel_name";
        public static final String COLUMN_CHANNEL_DESC = "channel_desc";
        public static final String COLUMN_CHANNEL_ICON = "channel_icon";
        public static final String COLUMN_CHANNEL_BANNER = "channel_banner";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_SORT_ORDER = "sort_order";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildChannelUri(long id) {
            //content://com.padc.mmchannels/channels/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildChannelUriWithID(long channel_id) {
            //content://com.padc.mmchannels/channels?channel_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_CHANNEL_ID, String.valueOf(channel_id))
                    .build();
        }
    }

    public static final class ProgramEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROGRAMS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROGRAMS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROGRAMS;

        public static final String TABLE_NAME = "programs";

        public static final String COLUMN_PROGRAM_ID = "program_id";
        public static final String COLUMN_PARENT_ID = "parent_id";
        public static final String COLUMN_PROGRAM_TITLE = "program_title";
        public static final String COLUMN_PROGRAM_DESC = "program_desc";
        public static final String COLUMN_PROGRAM_IMAGE = "program_image";
        public static final String COLUMN_LANGUAGE = "language";
        public static final String COLUMN_PROGRAM_TYPE = "program_type";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildProgramUri(long id) {
            //content://com.padc.mmchannels/programs/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildProgramUriWithID(long program_id) {
            //content://com.padc.mmchannels/programs?program_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_PROGRAM_ID, String.valueOf(program_id))
                    .build();
        }

    }

    public static final class ChannelProgramEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CHANNEL_PROGRAMS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHANNEL_PROGRAMS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHANNEL_PROGRAMS;

        public static final String TABLE_NAME = "channel_programs";

        public static final String COLUMN_CHANNEL_PROGRAM_ID = "channel_program_id";
        public static final String COLUMN_AIR_DATE = "air_date";
        public static final String COLUMN_AIR_DAY = "air_day";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_CHANNEL_ID = "channel_id";
        public static final String COLUMN_PROGRAM_ID = "program_id";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildChannelProgramUri(long id) {
            //content://com.padc.mmchannels/channel_programs/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildChannelProgramUriWithID(long channel_program_id) {
            //content://com.padc.mmchannels/channel_programs?channel_program_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_CHANNEL_PROGRAM_ID, String.valueOf(channel_program_id))
                    .build();
        }

        public static Uri buildChannelProgramUriWithIDs(long channel_id, long program_id) {
            //content://com.padc.mmchannels/channel_programs?channel_id=0&program_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_CHANNEL_ID, String.valueOf(channel_id))
                    .appendQueryParameter(COLUMN_PROGRAM_ID, String.valueOf(program_id))
                    .build();
        }
    }

    public static final class MyChannelEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MY_CHANNELS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_CHANNELS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_CHANNELS;

        public static final String TABLE_NAME = "my_channels";

        public static final String COLUMN_MY_CHANNEL_ID = "my_channel_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_CHANNEL_ID = "channel_id";
        public static final String COLUMN_SORT_ORDER = "sort_order";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildMyChannelUri(long id) {
            //content://com.padc.mmchannels/my_channel/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMyChannelUriWithIDs(long user_id, long channel_id) {
            //content://com.padc.mmchannels/my_channel?user_id=0&channel_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_USER_ID, String.valueOf(user_id))
                    .appendQueryParameter(COLUMN_CHANNEL_ID, String.valueOf(channel_id))
                    .build();
        }
    }

    public static final class MyWatchListEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MY_WATCHLIST).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_WATCHLIST;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_WATCHLIST;

        public static final String TABLE_NAME = "my_watchlist";

        public static final String COLUMN_MY_WATCHLIST_ID = "my_watchlist_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_PROGRAM_ID = "program_id";
        public static final String COLUMN_WATCHED = "watched";
        public static final String COLUMN_SORT_ORDER = "sort_order";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildMyWatchlistUri(long id) {
            //content://com.padc.mmchannels/my_watchlist/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMyWatchlistUriWithIDs(long user_id, long program_id) {
            //content://com.padc.mmchannels/my_watchlist?user_id=0&program_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_USER_ID, String.valueOf(user_id))
                    .appendQueryParameter(COLUMN_PROGRAM_ID, String.valueOf(program_id))
                    .build();
        }
    }

    public static final class MyRemindersEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MY_REMINDERS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_REMINDERS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MY_REMINDERS;

        public static final String TABLE_NAME = "my_reminders";

        public static final String COLUMN_MY_REMINDER_ID = "my_reminder_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_CHANNEL_PROGRAM_ID = "channel_program_id";
        public static final String COLUMN_TIME_AHEAD = "time_ahead";
        public static final String COLUMN_SORT_ORDER = "sort_order";
        public static final String COLUMN_ROW_TIMESTAMP = "row_timestamp";
        public static final String COLUMN_RECORD_STATUS = "record_status";

        public static Uri buildMyRemindersUri(long id) {
            //content://com.padc.mmchannels/my_reminders/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMyRemindersUriWithIDs(long user_id, long channel_program_id) {
            //content://com.padc.mmchannels/my_reminders?user_id=0&program_id=101
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_USER_ID, String.valueOf(user_id))
                    .appendQueryParameter(COLUMN_CHANNEL_PROGRAM_ID, String.valueOf(channel_program_id))
                    .build();
        }
    }
}