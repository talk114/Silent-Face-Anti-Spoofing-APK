cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_BUILD_TYPE "release")
#set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../../../distribution/${ANDROID_ABI})

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include/)


add_library(ncnn STATIC IMPORTED)
set_target_properties(ncnn PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libncnn.a)


file(GLOB jni_srcs
        "face_detector.cpp"
        "face_detector_jni.cpp"
        "live_jni.cpp"
        "img_process.cpp"
        "live.cpp"
)
add_library(engine SHARED ${jni_srcs})

set(OpenCV_DIR  ${CMAKE_CURRENT_SOURCE_DIR}/opencv-mobile-4.10.0-android/sdk/native/jni)
find_package(OpenCV REQUIRED core imgproc)
#set(ncnn_DIR  ${CMAKE_CURRENT_SOURCE_DIR}/ncnn-20240410-android/${ANDROID_ABI}/lib/cmake/ncnn/)
#find_package(ncnn REQUIRED)


target_link_libraries(engine log jnigraphics ncnn  ${OpenCV_LIBS}  android)