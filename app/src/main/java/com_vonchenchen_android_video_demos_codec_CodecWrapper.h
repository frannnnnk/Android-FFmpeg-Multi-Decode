/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_vonchenchen_android_video_demos_codec_CodecWrapper */

#ifndef _Included_com_vonchenchen_android_video_demos_codec_CodecWrapper
#define _Included_com_vonchenchen_android_video_demos_codec_CodecWrapper
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_vonchenchen_android_video_demos_codec_CodecWrapper
 * Method:    get_codec
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_vonchenchen_android_1video_1demos_codec_CodecWrapper_get_1codec
  (JNIEnv *, jobject);

/*
 * Class:     com_vonchenchen_android_video_demos_codec_CodecWrapper
 * Method:    decode_stream
 * Signature: ([BIILcom/vonchenchen/android_video_demos/codec/CodecWrapper;)V
 */
JNIEXPORT void JNICALL Java_com_vonchenchen_android_1video_1demos_codec_CodecWrapper_decode_1stream
  (JNIEnv *, jobject, jbyteArray, jint, jint, jobject);

/*
 * Class:     com_vonchenchen_android_video_demos_codec_CodecWrapper
 * Method:    release_codec
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_vonchenchen_android_1video_1demos_codec_CodecWrapper_release_1codec
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
