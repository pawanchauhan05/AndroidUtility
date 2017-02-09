package com.android.utility;

import android.Manifest;

/**
 * Created by pawan on 9/2/17.
 */

public interface RuntimePermissions {
    public static final String ACCESS_CHECKIN_PROPERTIES = Manifest.permission.ACCESS_CHECKIN_PROPERTIES;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_LOCATION_EXTRA_COMMANDS = Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS;
    public static final String ACCESS_NETWORK_STATE = Manifest.permission.ACCESS_NETWORK_STATE;
    public static final String ACCESS_NOTIFICATION_POLICY = Manifest.permission.ACCESS_NOTIFICATION_POLICY;
    public static final String ACCESS_WIFI_STATE = Manifest.permission.ACCESS_WIFI_STATE;
    public static final String ACCOUNT_MANAGER = Manifest.permission.ACCOUNT_MANAGER;
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public static final String BATTERY_STATS = Manifest.permission.BATTERY_STATS;
    public static final String BIND_ACCESSIBILITY_SERVICE = Manifest.permission.BIND_ACCESSIBILITY_SERVICE;
    public static final String BIND_APPWIDGET = Manifest.permission.BIND_APPWIDGET;
    public static final String BIND_CARRIER_MESSAGING_SERVICE = Manifest.permission.BIND_CARRIER_MESSAGING_SERVICE;
    public static final String BIND_CARRIER_SERVICES = Manifest.permission.BIND_CARRIER_SERVICES;
    public static final String BIND_CHOOSER_TARGET_SERVICE = Manifest.permission.BIND_CHOOSER_TARGET_SERVICE;
    public static final String BIND_CONDITION_PROVIDER_SERVICE = Manifest.permission.BIND_CONDITION_PROVIDER_SERVICE;
    public static final String BIND_DEVICE_ADMIN = Manifest.permission.BIND_DEVICE_ADMIN;
    public static final String BIND_DREAM_SERVICE = Manifest.permission.BIND_DREAM_SERVICE;
    public static final String BIND_INCALL_SERVICE = Manifest.permission.BIND_INCALL_SERVICE;
    public static final String BIND_MIDI_DEVICE_SERVICE = Manifest.permission.BIND_MIDI_DEVICE_SERVICE;
    public static final String BIND_NFC_SERVICE = Manifest.permission.BIND_NFC_SERVICE;
    public static final String BIND_NOTIFICATION_LISTENER_SERVICE = Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE;
    public static final String BIND_PRINT_SERVICE = Manifest.permission.BIND_PRINT_SERVICE;
    public static final String BIND_QUICK_SETTINGS_TILE = Manifest.permission.BIND_QUICK_SETTINGS_TILE;
    public static final String BIND_REMOTEVIEWS = Manifest.permission.BIND_REMOTEVIEWS;
    public static final String BIND_SCREENING_SERVICE = Manifest.permission.BIND_SCREENING_SERVICE;
    public static final String BIND_TELECOM_CONNECTION_SERVICE = Manifest.permission.BIND_TELECOM_CONNECTION_SERVICE;
    public static final String BIND_TEXT_SERVICE = Manifest.permission.BIND_TEXT_SERVICE;
    public static final String BIND_TV_INPUT = Manifest.permission.BIND_TV_INPUT;
    public static final String BIND_VOICE_INTERACTION = Manifest.permission.BIND_VOICE_INTERACTION;
    public static final String BIND_VPN_SERVICE = Manifest.permission.BIND_VPN_SERVICE;
    public static final String BIND_VR_LISTENER_SERVICE = Manifest.permission.BIND_VR_LISTENER_SERVICE;
    public static final String BIND_WALLPAPER = Manifest.permission.BIND_WALLPAPER;
    public static final String BLUETOOTH = Manifest.permission.BLUETOOTH;
    public static final String BLUETOOTH_ADMIN = Manifest.permission.BLUETOOTH_ADMIN;
    public static final String BLUETOOTH_PRIVILEGED = Manifest.permission.BLUETOOTH_PRIVILEGED;
    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public static final String BROADCAST_PACKAGE_REMOVED = Manifest.permission.BROADCAST_PACKAGE_REMOVED;
    public static final String BROADCAST_SMS = Manifest.permission.BROADCAST_SMS;
    public static final String BROADCAST_STICKY = Manifest.permission.BROADCAST_STICKY;
    public static final String BROADCAST_WAP_PUSH = Manifest.permission.BROADCAST_WAP_PUSH;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String CALL_PRIVILEGED = Manifest.permission.CALL_PRIVILEGED;
    public static final String CAMERA = Manifest.permission.CAMERA;
    public static final String CAPTURE_AUDIO_OUTPUT = Manifest.permission.CAPTURE_AUDIO_OUTPUT;
    public static final String CAPTURE_SECURE_VIDEO_OUTPUT = Manifest.permission.CAPTURE_SECURE_VIDEO_OUTPUT;
    public static final String CAPTURE_VIDEO_OUTPUT = Manifest.permission.CAPTURE_VIDEO_OUTPUT;
    public static final String CHANGE_COMPONENT_ENABLED_STATE = Manifest.permission.CHANGE_COMPONENT_ENABLED_STATE;
    public static final String CHANGE_CONFIGURATION = Manifest.permission.CHANGE_CONFIGURATION;
    public static final String CHANGE_NETWORK_STATE = Manifest.permission.CHANGE_NETWORK_STATE;
    public static final String CHANGE_WIFI_MULTICAST_STATE = Manifest.permission.CHANGE_WIFI_MULTICAST_STATE;
    public static final String CHANGE_WIFI_STATE = Manifest.permission.CHANGE_WIFI_STATE;
    public static final String CLEAR_APP_CACHE = Manifest.permission.CLEAR_APP_CACHE;
    public static final String CONTROL_LOCATION_UPDATES = Manifest.permission.CONTROL_LOCATION_UPDATES;
    public static final String DELETE_CACHE_FILES = Manifest.permission.DELETE_CACHE_FILES;
    public static final String DELETE_PACKAGES = Manifest.permission.DELETE_PACKAGES;
    public static final String DIAGNOSTIC = Manifest.permission.DIAGNOSTIC;
    public static final String DISABLE_KEYGUARD = Manifest.permission.DISABLE_KEYGUARD;
    public static final String DUMP = Manifest.permission.DUMP;
    public static final String EXPAND_STATUS_BAR = Manifest.permission.EXPAND_STATUS_BAR;
    public static final String FACTORY_TEST = Manifest.permission.FACTORY_TEST;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String GET_ACCOUNTS_PRIVILEGED = Manifest.permission.GET_ACCOUNTS_PRIVILEGED;
    public static final String GET_PACKAGE_SIZE = Manifest.permission.GET_PACKAGE_SIZE;
    public static final String GET_TASKS = Manifest.permission.GET_TASKS;
    public static final String GLOBAL_SEARCH = Manifest.permission.GLOBAL_SEARCH;
    public static final String INSTALL_LOCATION_PROVIDER = Manifest.permission.INSTALL_LOCATION_PROVIDER;
    public static final String INSTALL_PACKAGES = Manifest.permission.INSTALL_PACKAGES;
    public static final String INSTALL_SHORTCUT = Manifest.permission.INSTALL_SHORTCUT;
    public static final String INTERNET = Manifest.permission.INTERNET;
    public static final String KILL_BACKGROUND_PROCESSES = Manifest.permission.KILL_BACKGROUND_PROCESSES;
    public static final String LOCATION_HARDWARE = Manifest.permission.LOCATION_HARDWARE;
    public static final String MANAGE_DOCUMENTS = Manifest.permission.MANAGE_DOCUMENTS;
    public static final String MASTER_CLEAR = Manifest.permission.MASTER_CLEAR;
    public static final String MEDIA_CONTENT_CONTROL = Manifest.permission.MEDIA_CONTENT_CONTROL;
    public static final String MODIFY_AUDIO_SETTINGS = Manifest.permission.MODIFY_AUDIO_SETTINGS;
    public static final String MODIFY_PHONE_STATE = Manifest.permission.MODIFY_PHONE_STATE;
    public static final String MOUNT_FORMAT_FILESYSTEMS = Manifest.permission.MOUNT_FORMAT_FILESYSTEMS;
    public static final String MOUNT_UNMOUNT_FILESYSTEMS = Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS;
    public static final String NFC = Manifest.permission.NFC;
    public static final String PACKAGE_USAGE_STATS = Manifest.permission.PACKAGE_USAGE_STATS;
    public static final String PERSISTENT_ACTIVITY = Manifest.permission.PERSISTENT_ACTIVITY;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String READ_FRAME_BUFFER = Manifest.permission.READ_FRAME_BUFFER;
    public static final String READ_INPUT_STATE = Manifest.permission.READ_INPUT_STATE;
    public static final String READ_LOGS = Manifest.permission.READ_LOGS;
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String READ_SYNC_SETTINGS = Manifest.permission.READ_SYNC_SETTINGS;
    public static final String READ_SYNC_STATS = Manifest.permission.READ_SYNC_STATS;
    public static final String READ_VOICEMAIL = Manifest.permission.READ_VOICEMAIL;
    public static final String REBOOT = Manifest.permission.REBOOT;
    public static final String RECEIVE_BOOT_COMPLETED = Manifest.permission.RECEIVE_BOOT_COMPLETED;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String REORDER_TASKS = Manifest.permission.REORDER_TASKS;
    public static final String REQUEST_IGNORE_BATTERY_OPTIMIZATIONS = Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS;
    public static final String REQUEST_INSTALL_PACKAGES = Manifest.permission.REQUEST_INSTALL_PACKAGES;
    public static final String RESTART_PACKAGES = Manifest.permission.RESTART_PACKAGES;
    public static final String SEND_RESPOND_VIA_MESSAGE = Manifest.permission.SEND_RESPOND_VIA_MESSAGE;
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String SET_ALARM = Manifest.permission.SET_ALARM;
    public static final String SET_ALWAYS_FINISH = Manifest.permission.SET_ALWAYS_FINISH;
    public static final String SET_ANIMATION_SCALE = Manifest.permission.SET_ANIMATION_SCALE;
    public static final String SET_DEBUG_APP = Manifest.permission.SET_DEBUG_APP;
    public static final String SET_PROCESS_LIMIT = Manifest.permission.SET_PROCESS_LIMIT;
    public static final String SET_TIME = Manifest.permission.SET_TIME;
    public static final String SET_TIME_ZONE = Manifest.permission.SET_TIME_ZONE;
    public static final String SET_WALLPAPER = Manifest.permission.SET_WALLPAPER;
    public static final String SET_WALLPAPER_HINTS = Manifest.permission.SET_WALLPAPER_HINTS;
    public static final String SIGNAL_PERSISTENT_PROCESSES = Manifest.permission.SIGNAL_PERSISTENT_PROCESSES;
    public static final String STATUS_BAR = Manifest.permission.STATUS_BAR;
    public static final String SYSTEM_ALERT_WINDOW = Manifest.permission.SYSTEM_ALERT_WINDOW;
    public static final String TRANSMIT_IR = Manifest.permission.TRANSMIT_IR;
    public static final String UNINSTALL_SHORTCUT = Manifest.permission.UNINSTALL_SHORTCUT;
    public static final String UPDATE_DEVICE_STATS = Manifest.permission.UPDATE_DEVICE_STATS;
    public static final String USE_FINGERPRINT = Manifest.permission.USE_FINGERPRINT;
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String VIBRATE = Manifest.permission.VIBRATE;
    public static final String WAKE_LOCK = Manifest.permission.WAKE_LOCK;
    public static final String WRITE_APN_SETTINGS = Manifest.permission.WRITE_APN_SETTINGS;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String WRITE_GSERVICES = Manifest.permission.WRITE_GSERVICES;
    public static final String WRITE_SECURE_SETTINGS = Manifest.permission.WRITE_SECURE_SETTINGS;
    public static final String WRITE_SETTINGS = Manifest.permission.WRITE_SETTINGS;
    public static final String WRITE_SYNC_SETTINGS = Manifest.permission.WRITE_SYNC_SETTINGS;
    public static final String WRITE_VOICEMAIL = Manifest.permission.WRITE_VOICEMAIL;
    public static final String[] PERMISSION_ARRAY = {
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

}
