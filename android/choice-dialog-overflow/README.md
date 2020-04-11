https://issuetracker.google.com/issues/153725160

Android Emulator: 30.0.5
Sysrem Image: Intel x86 Atom_64 System Image API 29 Revision 7

1. Create an emulator based on Q 29 x86_64 Android 10.0
   Important: no Google Play / Google APIs, those don't reproduce
2. Turn off Window Animations in Developer Options in Settings, or execute:
    ```shell script
    adb shell settings put global window_animation_scale 0
    ```
3. Launch app and press "Show Dialog"

```
    --------- beginning of crash
12060-12060/? A/libc: Fatal signal 6 (SIGABRT), code -1 (SI_QUEUE) in tid 12060 (surfaceflinger), pid 12060 (surfaceflinger)
13910-13910/? I/crash_dump64: obtaining output fd from tombstoned, type: kDebuggerdTombstone
1696-1696/? I//system/bin/tombstoned: received crash request for pid 12060
13910-13910/? I/crash_dump64: performing dump of process 12060 (target tid = 12060)
13910-13910/? A/DEBUG: *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***
13910-13910/? A/DEBUG: Build fingerprint: 'Android/sdk_phone_x86_64/generic_x86_64:10/QPP6.190730.005.B1/5775370:userdebug/test-keys'
13910-13910/? A/DEBUG: Revision: '0'
13910-13910/? A/DEBUG: ABI: 'x86_64'
13910-13910/? A/DEBUG: Timestamp: 2020-04-11 04:14:42+0100
13910-13910/? A/DEBUG: pid: 12060, tid: 12060, name: surfaceflinger  >>> /system/bin/surfaceflinger <<<
13910-13910/? A/DEBUG: uid: 1000
13910-13910/? A/DEBUG: signal 6 (SIGABRT), code -1 (SI_QUEUE), fault addr --------
13910-13910/? A/DEBUG: Abort message: 'ubsan: add-overflow'
13910-13910/? A/DEBUG:     rax 0000000000000000  rbx 0000000000002f1c  rcx 0000788347cdf3f8  rdx 0000000000000006
13910-13910/? A/DEBUG:     r8  0000000000000000  r9  0000000000000000  r10 00007ffdc4c9dd00  r11 0000000000000246
13910-13910/? A/DEBUG:     r12 0000000000000000  r13 0000788348cda000  r14 00007ffdc4c9dd88  r15 0000000000002f1c
13910-13910/? A/DEBUG:     rdi 0000000000002f1c  rsi 0000000000002f1c
13910-13910/? A/DEBUG:     rbp 00007ffdc4c9de70  rsp 00007ffdc4c9dcf8  rip 0000788347cdf3f8
13910-13910/? A/DEBUG: backtrace:
13910-13910/? A/DEBUG:       #00 pc 00000000000943f8  /apex/com.android.runtime/lib64/bionic/libc.so (syscall+24) (BuildId: a08a19770d6696739c847e29c3f5f650)
13910-13910/? A/DEBUG:       #01 pc 0000000000097146  /apex/com.android.runtime/lib64/bionic/libc.so (abort+182) (BuildId: a08a19770d6696739c847e29c3f5f650)
13910-13910/? A/DEBUG:       #02 pc 000000000002d5f4  /system/lib64/libui.so (abort_with_message(char const*)+20) (BuildId: af0c1feb4d841edd012546ced108abc8)
13910-13910/? A/DEBUG:       #03 pc 000000000002d618  /system/lib64/libui.so (__ubsan_handle_add_overflow_minimal_abort+24) (BuildId: af0c1feb4d841edd012546ced108abc8)
13910-13910/? A/DEBUG:       #04 pc 0000000000028efd  /system/lib64/libui.so (android::Rect::inset(int, int, int, int)+45) (BuildId: af0c1feb4d841edd012546ced108abc8)
13910-13910/? A/DEBUG:       #05 pc 00000000000cafdc  /system/lib64/libsurfaceflinger.so (android::Layer::fillInputInfo()+796) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #06 pc 000000000010da60  /system/lib64/libsurfaceflinger.so (_ZNSt3__110__function6__funcIZN7android14SurfaceFlinger21updateInputWindowInfoEvE4$_23NS_9allocatorIS4_EEFvPNS2_5LayerEEEclEOS8_$771005b0e4ffffb89432a671ac8168bf+64) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #07 pc 00000000000c855a  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+186) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #08 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #09 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #10 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #11 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #12 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #13 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #14 pc 00000000000c852f  /system/lib64/libsurfaceflinger.so (android::Layer::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&)+143) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #15 pc 00000000000d1e29  /system/lib64/libsurfaceflinger.so (android::LayerVector::traverseInReverseZOrder(android::LayerVector::StateSet, std::__1::function<void (android::Layer*)> const&) const+105) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #16 pc 00000000000f1ac8  /system/lib64/libsurfaceflinger.so (android::SurfaceFlinger::onMessageReceived(int)+11352) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #17 pc 00000000000187df  /system/lib64/libutils.so (android::Looper::pollInner(int)+367) (BuildId: 20c01acb58e07a2d146da9c81d857370)
13910-13910/? A/DEBUG:       #18 pc 00000000000185aa  /system/lib64/libutils.so (android::Looper::pollOnce(int, int*, int*, void**)+42) (BuildId: 20c01acb58e07a2d146da9c81d857370)
13910-13910/? A/DEBUG:       #19 pc 00000000000e188b  /system/lib64/libsurfaceflinger.so (android::impl::MessageQueue::waitMessage()+91) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #20 pc 00000000000ee3bb  /system/lib64/libsurfaceflinger.so (android::SurfaceFlinger::run()+27) (BuildId: 0d529f152643e29b129bf7f73e7882cb)
13910-13910/? A/DEBUG:       #21 pc 00000000000033b4  /system/bin/surfaceflinger (main+852) (BuildId: 4e6c2550f1649fd903970809a4ec8e3e)
13910-13910/? A/DEBUG:       #22 pc 000000000008a985  /apex/com.android.runtime/lib64/bionic/libc.so (__libc_init+117) (BuildId: a08a19770d6696739c847e29c3f5f650)
```
