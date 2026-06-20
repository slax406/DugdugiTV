# Dugdugi TV — Android TV App

Android TV app with 4 sections. Each section plays a **live video stream** using ExoPlayer (Media3) — built for smooth IPTV/HLS playback on TV.

## Sections (edit in MainActivity.kt)
- Dugdugi Live → http://dugdugilive.com/
- Roar Zone → https://tv.roarzone.net/
- FTP Server 1 → http://10.100.100.10/
- FTP Server 2 → http://172.16.50.4/

⚠️ **Important:** ExoPlayer needs the *direct stream URL* (usually ending in `.m3u8`, `.ts`, or similar), not a webpage URL. If `http://dugdugilive.com/` is a homepage/portal rather than a direct stream link, playback will fail. Open that link in a browser, find the actual stream link (Network tab / "play" button source), and put that exact URL into `MainActivity.kt`.

---

## 🚀 Get an installable APK — NO Android Studio needed

This project includes a GitHub Actions workflow that builds the APK automatically in the cloud.

1. Create a free GitHub account (if you don't have one) → github.com
2. Create a new empty repository (e.g. `dugdugi-tv`)
3. Upload all files from this project into that repo (drag-and-drop on github.com works, or `git push`)
4. Go to the repo's **Actions** tab → you'll see "Build APK" workflow → click **Run workflow**
5. Wait ~3-5 minutes → click into the finished run → download the **DugdugiTV-debug-apk** artifact (zip) → unzip → you get `app-debug.apk`
6. Transfer that APK to your Android TV (USB drive, or an app like "Send Files to TV", or `adb install`) and install it (enable "install from unknown sources" in TV settings first)

This debug APK is install-ready — just sideload and open.

---

## Alternative: build with Android Studio (if you have a PC)
1. Install Android Studio
2. Open this `DugdugiTV` folder as a project, let Gradle sync
3. Build → Build Bundle(s)/APK(s) → Build APK(s)
4. Find APK in `app/build/outputs/apk/debug/`

---

## Notes
- **Add/edit sections**: edit the `sections` list in `MainActivity.kt`.
- **Local IPs (10.x / 172.x)**: only work when TV is on the same local network as that server.
- **Cleartext HTTP** is enabled in the manifest since your links are `http://`.
- **If a stream won't load**: error message shows on screen with the reason — usually means the URL isn't a direct stream link, or needs the TV to be on the right local network.

