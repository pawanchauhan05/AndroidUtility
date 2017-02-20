package com.android.utility;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.security.Permissions;

/**
 * Created by pawan on 8/2/17.
 */

public class RunTimePermission {
    public static final int ACCESS_CHECKIN_PROPERTIES = 1;
    public static final int ACCESS_COARSE_LOCATION = 2;
    public static final int ACCESS_FINE_LOCATION = 3;
    public static final int ACCESS_LOCATION_EXTRA_COMMANDS = 4;
    public static final int ACCESS_NETWORK_STATE = 5;
    public static final int ACCESS_NOTIFICATION_POLICY = 6;
    public static final int ACCESS_WIFI_STATE = 7;
    public static final int ACCOUNT_MANAGER = 8;
    public static final int ADD_VOICEMAIL = 9;
    public static final int BATTERY_STATS = 10;
    public static final int BIND_ACCESSIBILITY_SERVICE = 11;
    public static final int BIND_APPWIDGET = 12;
    public static final int BIND_CARRIER_MESSAGING_SERVICE = 13;
    public static final int BIND_CARRIER_SERVICES = 14;
    public static final int BIND_CHOOSER_TARGET_SERVICE = 15;
    public static final int BIND_CONDITION_PROVIDER_SERVICE = 16;
    public static final int BIND_DEVICE_ADMIN = 17;
    public static final int BIND_DREAM_SERVICE = 18;
    public static final int BIND_INCALL_SERVICE = 19;
    public static final int BIND_MIDI_DEVICE_SERVICE = 20;
    public static final int BIND_NFC_SERVICE = 21;
    public static final int BIND_NOTIFICATION_LISTENER_SERVICE = 22;
    public static final int BIND_PRINT_SERVICE = 23;
    public static final int BIND_QUICK_SETTINGS_TILE = 24;
    public static final int BIND_REMOTEVIEWS = 25;
    public static final int BIND_SCREENING_SERVICE = 26;
    public static final int BIND_TELECOM_CONNECTION_SERVICE = 27;
    public static final int BIND_TEXT_SERVICE = 28;
    public static final int BIND_TV_INPUT = 29;
    public static final int BIND_VOICE_INTERACTION = 30;
    public static final int BIND_VPN_SERVICE = 31;
    public static final int BIND_VR_LISTENER_SERVICE = 32;
    public static final int BIND_WALLPAPER = 33;
    public static final int BLUETOOTH = 34;
    public static final int BLUETOOTH_ADMIN = 35;
    public static final int BLUETOOTH_PRIVILEGED = 36;
    public static final int BODY_SENSORS = 37;
    public static final int BROADCAST_PACKAGE_REMOVED = 38;
    public static final int BROADCAST_SMS = 39;
    public static final int BROADCAST_STICKY = 40;
    public static final int BROADCAST_WAP_PUSH = 41;
    public static final int CALL_PHONE = 42;
    public static final int CALL_PRIVILEGED = 43;
    public static final int CAMERA = 44;
    public static final int CAPTURE_AUDIO_OUTPUT = 45;
    public static final int CAPTURE_SECURE_VIDEO_OUTPUT = 46;
    public static final int CAPTURE_VIDEO_OUTPUT = 47;
    public static final int CHANGE_COMPONENT_ENABLED_STATE = 48;
    public static final int CHANGE_CONFIGURATION = 49;
    public static final int CHANGE_NETWORK_STATE = 50;
    public static final int CHANGE_WIFI_MULTICAST_STATE = 51;
    public static final int CHANGE_WIFI_STATE = 52;
    public static final int CLEAR_APP_CACHE = 53;
    public static final int CONTROL_LOCATION_UPDATES = 54;
    public static final int DELETE_CACHE_FILES = 55;
    public static final int DELETE_PACKAGES = 56;
    public static final int DIAGNOSTIC = 57;
    public static final int DISABLE_KEYGUARD = 58;
    public static final int DUMP = 59;
    public static final int EXPAND_STATUS_BAR = 60;
    public static final int FACTORY_TEST = 61;
    public static final int GET_ACCOUNTS = 62;
    public static final int GET_ACCOUNTS_PRIVILEGED = 63;
    public static final int GET_PACKAGE_SIZE = 64;
    public static final int GET_TASKS = 65;
    public static final int GLOBAL_SEARCH = 66;
    public static final int INSTALL_LOCATION_PROVIDER = 67;
    public static final int INSTALL_PACKAGES = 68;
    public static final int INSTALL_SHORTCUT = 69;
    public static final int INTERNET = 70;
    public static final int KILL_BACKGROUND_PROCESSES = 71;
    public static final int LOCATION_HARDWARE = 72;
    public static final int MANAGE_DOCUMENTS = 73;
    public static final int MASTER_CLEAR = 74;
    public static final int MEDIA_CONTENT_CONTROL = 75;
    public static final int MODIFY_AUDIO_SETTINGS = 76;
    public static final int MODIFY_PHONE_STATE = 77;
    public static final int MOUNT_FORMAT_FILESYSTEMS = 78;
    public static final int MOUNT_UNMOUNT_FILESYSTEMS = 79;
    public static final int NFC = 80;
    public static final int PACKAGE_USAGE_STATS = 81;
    public static final int PERSISTENT_ACTIVITY = 82;
    public static final int PROCESS_OUTGOING_CALLS = 83;
    public static final int READ_CALENDAR = 84;
    public static final int READ_CALL_LOG = 85;
    public static final int READ_CONTACTS = 86;
    public static final int READ_EXTERNAL_STORAGE = 87;
    public static final int READ_FRAME_BUFFER = 88;
    public static final int READ_INPUT_STATE = 89;
    public static final int READ_LOGS = 90;
    public static final int READ_PHONE_STATE = 91;
    public static final int READ_SMS = 92;
    public static final int READ_SYNC_SETTINGS = 93;
    public static final int READ_SYNC_STATS = 94;
    public static final int READ_VOICEMAIL = 95;
    public static final int REBOOT = 96;
    public static final int RECEIVE_BOOT_COMPLETED = 97;
    public static final int RECEIVE_MMS = 98;
    public static final int RECEIVE_SMS = 99;
    public static final int RECEIVE_WAP_PUSH = 100;
    public static final int RECORD_AUDIO = 101;
    public static final int REORDER_TASKS = 102;
    public static final int REQUEST_IGNORE_BATTERY_OPTIMIZATIONS = 103;
    public static final int REQUEST_INSTALL_PACKAGES = 104;
    public static final int RESTART_PACKAGES = 105;
    public static final int SEND_RESPOND_VIA_MESSAGE = 106;
    public static final int SEND_SMS = 107;
    public static final int SET_ALARM = 108;
    public static final int SET_ALWAYS_FINISH = 109;
    public static final int SET_ANIMATION_SCALE = 110;
    public static final int SET_DEBUG_APP = 111;
    public static final int SET_PROCESS_LIMIT = 112;
    public static final int SET_TIME = 113;
    public static final int SET_TIME_ZONE = 114;
    public static final int SET_WALLPAPER = 115;
    public static final int SET_WALLPAPER_HINTS = 116;
    public static final int SIGNAL_PERSISTENT_PROCESSES = 117;
    public static final int STATUS_BAR = 118;
    public static final int SYSTEM_ALERT_WINDOW = 119;
    public static final int TRANSMIT_IR = 120;
    public static final int UNINSTALL_SHORTCUT = 121;
    public static final int UPDATE_DEVICE_STATS = 122;
    public static final int USE_FINGERPRINT = 123;
    public static final int USE_SIP = 124;
    public static final int VIBRATE = 125;
    public static final int WAKE_LOCK = 126;
    public static final int WRITE_APN_SETTINGS = 127;
    public static final int WRITE_CALENDAR = 128;
    public static final int WRITE_CALL_LOG = 129;
    public static final int WRITE_CONTACTS = 130;
    public static final int WRITE_EXTERNAL_STORAGE = 131;
    public static final int WRITE_GSERVICES = 132;
    public static final int WRITE_SECURE_SETTINGS = 133;
    public static final int WRITE_SETTINGS = 134;
    public static final int WRITE_SYNC_SETTINGS = 135;
    public static final int WRITE_VOICEMAIL = 136;
    public static final int[] PERMISSION_ARRAY_REQUEST = {
            ACCESS_CHECKIN_PROPERTIES,
            ACCESS_COARSE_LOCATION,
            ACCESS_FINE_LOCATION,
            ACCESS_LOCATION_EXTRA_COMMANDS,
            ACCESS_NETWORK_STATE,
            ACCESS_NOTIFICATION_POLICY,
            ACCESS_WIFI_STATE,
            ACCOUNT_MANAGER,
            ADD_VOICEMAIL,
            BATTERY_STATS,
            BIND_ACCESSIBILITY_SERVICE,
            BIND_APPWIDGET,
            BIND_CARRIER_MESSAGING_SERVICE,
            BIND_CARRIER_SERVICES,
            BIND_CHOOSER_TARGET_SERVICE,
            BIND_CONDITION_PROVIDER_SERVICE,
            BIND_DEVICE_ADMIN,
            BIND_DREAM_SERVICE,
            BIND_INCALL_SERVICE,
            BIND_MIDI_DEVICE_SERVICE,
            BIND_NFC_SERVICE,
            BIND_NOTIFICATION_LISTENER_SERVICE,
            BIND_PRINT_SERVICE,
            BIND_QUICK_SETTINGS_TILE,
            BIND_REMOTEVIEWS,
            BIND_SCREENING_SERVICE,
            BIND_TELECOM_CONNECTION_SERVICE,
            BIND_TEXT_SERVICE,
            BIND_TV_INPUT,
            BIND_VOICE_INTERACTION,
            BIND_VPN_SERVICE,
            BIND_VR_LISTENER_SERVICE,
            BIND_WALLPAPER,
            BLUETOOTH,
            BLUETOOTH_ADMIN,
            BLUETOOTH_PRIVILEGED,
            BODY_SENSORS,
            BROADCAST_PACKAGE_REMOVED,
            BROADCAST_SMS,
            BROADCAST_STICKY,
            BROADCAST_WAP_PUSH,
            CALL_PHONE,
            CALL_PRIVILEGED,
            CAMERA,
            CAPTURE_AUDIO_OUTPUT,
            CAPTURE_SECURE_VIDEO_OUTPUT,
            CAPTURE_VIDEO_OUTPUT,
            CHANGE_COMPONENT_ENABLED_STATE,
            CHANGE_CONFIGURATION,
            CHANGE_NETWORK_STATE,
            CHANGE_WIFI_MULTICAST_STATE,
            CHANGE_WIFI_STATE,
            CLEAR_APP_CACHE,
            CONTROL_LOCATION_UPDATES,
            DELETE_CACHE_FILES,
            DELETE_PACKAGES,
            DIAGNOSTIC,
            DISABLE_KEYGUARD,
            DUMP,
            EXPAND_STATUS_BAR,
            FACTORY_TEST,
            GET_ACCOUNTS,
            GET_ACCOUNTS_PRIVILEGED,
            GET_PACKAGE_SIZE,
            GET_TASKS,
            GLOBAL_SEARCH,
            INSTALL_LOCATION_PROVIDER,
            INSTALL_PACKAGES,
            INSTALL_SHORTCUT,
            INTERNET,
            KILL_BACKGROUND_PROCESSES,
            LOCATION_HARDWARE,
            MANAGE_DOCUMENTS,
            MASTER_CLEAR,
            MEDIA_CONTENT_CONTROL,
            MODIFY_AUDIO_SETTINGS,
            MODIFY_PHONE_STATE,
            MOUNT_FORMAT_FILESYSTEMS,
            MOUNT_UNMOUNT_FILESYSTEMS,
            NFC,
            PACKAGE_USAGE_STATS,
            PERSISTENT_ACTIVITY,
            PROCESS_OUTGOING_CALLS,
            READ_CALENDAR,
            READ_CALL_LOG,
            READ_CONTACTS,
            READ_EXTERNAL_STORAGE,
            READ_FRAME_BUFFER,
            READ_INPUT_STATE,
            READ_LOGS,
            READ_PHONE_STATE,
            READ_SMS,
            READ_SYNC_SETTINGS,
            READ_SYNC_STATS,
            READ_VOICEMAIL,
            REBOOT,
            RECEIVE_BOOT_COMPLETED,
            RECEIVE_MMS,
            RECEIVE_SMS,
            RECEIVE_WAP_PUSH,
            RECORD_AUDIO,
            REORDER_TASKS,
            REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            REQUEST_INSTALL_PACKAGES,
            RESTART_PACKAGES,
            SEND_RESPOND_VIA_MESSAGE,
            SEND_SMS,
            SET_ALARM,
            SET_ALWAYS_FINISH,
            SET_ANIMATION_SCALE,
            SET_DEBUG_APP,
            SET_PROCESS_LIMIT,
            SET_TIME,
            SET_TIME_ZONE,
            SET_WALLPAPER,
            SET_WALLPAPER_HINTS,
            SIGNAL_PERSISTENT_PROCESSES,
            STATUS_BAR,
            SYSTEM_ALERT_WINDOW,
            TRANSMIT_IR,
            UNINSTALL_SHORTCUT,
            UPDATE_DEVICE_STATS,
            USE_FINGERPRINT,
            USE_SIP,
            VIBRATE,
            WAKE_LOCK,
            WRITE_APN_SETTINGS,
            WRITE_CALENDAR,
            WRITE_CALL_LOG,
            WRITE_CONTACTS,
            WRITE_EXTERNAL_STORAGE,
            WRITE_GSERVICES,
            WRITE_SECURE_SETTINGS,
            WRITE_SETTINGS,
            WRITE_SYNC_SETTINGS,
            WRITE_VOICEMAIL
    };



    private Activity activity;
    private RuntimePermissionInterface runtimePermissionInterface;

    public RunTimePermission(Activity activity, RuntimePermissionInterface runtimePermissionInterface) {
        this.activity = activity;
        this.runtimePermissionInterface = runtimePermissionInterface;
    }

    private boolean checkPermission(String permission) {
        int result = -1;
        for (String PERMISSION : RuntimePermissions.PERMISSION_ARRAY) {
            if(permission.equals(PERMISSION)) {
                result = ContextCompat.checkSelfPermission(activity, PERMISSION);
                return result == PackageManager.PERMISSION_GRANTED ? true : false;
            }
        }
        return false;
    }

    private void requestPermission(String permission) {
        for (int i = 0; i < RuntimePermissions.PERMISSION_ARRAY.length; i++)
            if(permission.equals(RuntimePermissions.PERMISSION_ARRAY[i]))
                ActivityCompat.requestPermissions(activity,new String[]{permission},i);
    }

    /**
     * this function is used to check status permission is granted or not
     *
     * @param requestCode - request code
     * @param permissions - permission
     * @param grantResults - grantResults
     */
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        for (int code: PERMISSION_ARRAY_REQUEST) {
            if(code == requestCode) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    runtimePermissionInterface.doTaskAfterPermission();
                }
                return;
            }
        }
    }


    /**
     * this function is used to check runtime permission in marshmallow or above SDK
     *
     * @param permission - manifest permission
     */
    public void runtimePermission(String permission) {
        if(!checkPermission(permission))
            requestPermission(permission);
        else
            runtimePermissionInterface.doTaskAfterPermission();
    }

}
