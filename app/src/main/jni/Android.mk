LOCAL_PATH := $(call my-dir)

#opencv libopencv_java3
include $(CLEAR_VARS)
LOCAL_MODULE := opencv_java3
LOCAL_SRC_FILES := ../jniLibs/$(TARGET_ARCH_ABI)/libopencv_java3.so
include $(PREBUILT_SHARED_LIBRARY)

#ffmpeg
include $(CLEAR_VARS)
LOCAL_MODULE := ffmpeg
LOCAL_SRC_FILES := ../jniLibs/$(TARGET_ARCH_ABI)/libffmpeg.so
include $(PREBUILT_SHARED_LIBRARY)

#cd /Users/lidechen/AndroidStudioProjects/working/live_sdk/Android_Video_Demos/MyApplication2/app/src/main/java/
#javah com.vonchenchen.android_video_demos.codec.CodecWrapper
include $(CLEAR_VARS)

OpenCV_INSTALL_MODULES := on
OpenCV_CAMERA_MODULES := off
OPENCV_LIB_TYPE := SHARED
ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
include ../../../../native/jni/OpenCV.mk
else
include $(OPENCV_MK_PATH)
endif

LOCAL_MODULE := codec
LOCAL_SRC_FILES := $(wildcard $(LOCAL_PATH)/codec/*.cpp) $(wildcard $(LOCAL_PATH)/codec/jni/*.cpp) log.h
LOCAL_C_INCLUDES += $(LOCAL_PATH)/codec/ffmpeg/
LOCAL_SHARED_LIBRARIES += ffmpeg
LOCAL_LDLIBS +=  -lm -llog  -ljnigraphics -landroid
LOCAL_CPPFLAGS += -std=c++11 -Wall -Wsign-compare -fpermissive -D_PLATFORM_ANDROID -Ofast
include $(BUILD_SHARED_LIBRARY)