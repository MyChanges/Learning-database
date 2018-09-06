//
// Created by haiwang on 2017/7/18.
//
#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_live_haiwang_livegiftsample_JNITest_getStringFromC
  (JNIEnv *env, jobject clz){
        return (*env)->NewStringUTF(env,"JNI hahahahahahahaha");
  }
void test(){


}