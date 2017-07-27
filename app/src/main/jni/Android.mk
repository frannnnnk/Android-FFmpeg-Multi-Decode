LOCAL_PATH := $(call my-dir)

#ffmpeg
include $(CLEAR_VARS)
LOCAL_MODULE := ffmpeg
LOCAL_SRC_FILES := ../jniLibs/$(TARGET_ARCH_ABI)/libffmpeg.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := codec
LOCAL_SRC_FILES := \
    codec/android/android_native_window.cpp \
    codec/jni/com_vonchenchen_android_video_demos_codec_CodecWrapper.cpp \
    codec/decoder.cpp \
    codec/yuv_2_rgb.cpp

LOCAL_C_INCLUDES += $(LOCAL_PATH)/codec/ffmpeg/
LOCAL_SHARED_LIBRARIES += ffmpeg
LOCAL_LDLIBS +=  -lm -llog  -ljnigraphics -landroid
LOCAL_CPPFLAGS += -std=c++11 -Wall -Wsign-compare -fpermissive -D_PLATFORM_ANDROID -Ofast
include $(BUILD_SHARED_LIBRARY)