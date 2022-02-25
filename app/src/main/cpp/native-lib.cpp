#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_secondStringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Test";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_add(
        JNIEnv *env,
        jobject /* this */,
        jint a, jint b) {
    return a + b;
}

extern "C" JNIEXPORT jint JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_sub(
        JNIEnv *env,
        jobject /* this */,
        jint a, jint b) {
    return a - b;
}

extern "C" JNIEXPORT jint JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_mult(
        JNIEnv *env,
        jobject /* this */,
        jint a, jint b) {
    return a * b;
}

extern "C" JNIEXPORT jint JNICALL
Java_uz_ilkhomkhuja_ndkexample_MainActivity_div(
        JNIEnv *env,
        jobject /* this */,
        jint a, jint b) {
    return a / b;
}