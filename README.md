# Alerts-in-Android-Testing
Assignment 4 W11D3 - SDA - Software QA Bootcamp

# Table of contents
- [Question](#question)
- [Answer](#answer)
  - [Set up](#set-up)
- [Start Work](#start-work)
  - [STEP 1: Start Appium Server](#step-1-start-appium-server)
  - [STEP 2: Check your phone is connected](#step-2-check-your-phone-is-connected)
  - [STEP 3: Start Appuim Inspector session](#step-3-start-appuim-inspector-session)
  - [STEP 4: Create a Maven Project and Set Dependencies](#step-4-create-a-maven-project-and-set-dependencies)
  - [STEP 5: Create java class then set the DesiredCapabilities](#step-5-create-java-class-then-set-the-desiredcapabilities)
  - [STEP 6: Detect Elements](#step-6-detect-elements)
- [Output Screenshots](#output-screenshots)

---
# Question
Create a simple program to handle Alerts in Android Testing

---

# Answer
Before running the code, there are some steps that need to take considered:

---
## Set up
### First:
Download and install:
- [JDK](https://www.oracle.com/java/technologies/downloads/) (Lastest)
- [Eclipse](https://www.eclipse.org/) (Lastest)
- [Android Studio](https://developer.android.com/studio) (Lastest)
- [Appium Desktop](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4) (Lastest)
- [Appium Inspector](https://github.com/appium/appium-inspector/releases) (Lastest)
- [Node](https://nodejs.org/en/) (Lastest)



### Second:
Setup System Environment variables
- JAVA_HOME
- ANDROID_HOME
- platform tool
- Build tool
- tool
- node
- nmp

#### Check this [Reference](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux) to know how to use the Path

#### Your system path should have as shown below

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185808789-558650e2-2ce9-490b-823d-112a1868264e.png" width=40% height=40%>
  
</p>

#### Install and start the Appium Server via Node

To install appium v2 run this command, window users please open your terminal in admin mode
```md
npm install -g appium@next
```

#### Check setup via below commands
```md
appium -v
```

```md
node -v
```

```md
java -version
```

```md
echo %JAVA_HOME%
```

```md
echo %ANDROID_HOME%
```

```md
adb
```


<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185808882-36afbecf-8779-4d64-b59d-7c61adc9166b.png" width=60% height=60%>
  
</p>


### Third:
1. Set up the [Emulator](https://www.swtestacademy.com/how-to-run-arm-apk-on-x86-systems/) or [Hardware Device](https://developer.android.com/studio/run/device)

I used my hrdware device

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185809066-0ea7e920-0195-4641-a4c6-7e3b1287b142.png" width=40% height=40%>
  
</p>

2. Set up the Appuim Desktop configuration
<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185809147-da67f0e8-64de-4e6f-a6cd-41fbc1965dda.png" width=60% height=60%>
  
</p>

---
# Start Work
### STEP 1: Start Appium Server

<p align="center">

https://user-images.githubusercontent.com/48597284/185941666-d6b2765e-d939-488c-99e1-53499aee81e6.mp4
  
</p>

---

### STEP 2: Check your phone is connected
I used an actual device.
write in `CMD` the following:

```md
adb devices
```

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185943130-fc781526-23f3-4365-8cc2-8d92daddb97d.png" width=40% height=40%>
  
</p>

---

### STEP 3: Start Appuim Inspector session
Set the Desired Capabilities
- `appium:app`: C:\Users\lo0ol\Downloads\Collect-data-Application.apk
- `appium:automationName`: UiAutomator2
- `appium:deviceName`: 23b9cb400c1c7ece
- `appium:platformName`: Android
- `appium:platformVersion`: 10

Note: You need to set the `appium:appPackage` and `appium:appActivity` .

>  make sure the application opened on your real phone

3. Open `CMD` and write:

```md
adb shell dumpsys window | find "mCurrentFocus"
```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/185949257-a1041a85-d217-4ea5-8b86-06e748d35b5e.png" width=80% height=80%>
  
</p>

See [How to find App Package and App Activity of your Android App](https://support.testsigma.com/support/solutions/articles/32000019977-how-to-find-app-package-and-app-activity-of-your-android-app) for more information 

- `appium:appPackage`: com.example.mahhid_collect_data
- `appium:appActivity`: com.example.mahhid_collect_data.SplashScreen

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185974310-7529fe51-3b12-4dad-8779-f13f3357513a.png" width=80% height=80%>
  
</p>

Start Session
<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185975062-9a21123a-3108-40e4-af5f-93dc7ba6712f.png" width=80% height=80%>

</p>

---

### STEP 4: Create a Maven Project and Set Dependencies
- _Eclipse > Create project -> New maven project -> maven-archetype-quickstart (1.4)(this gives you a maven template to begin work with-> Group ID n Artifact ID is a must for maven projects  (so appium can uniquely identify your project). The group ID is like a package name and Artifact Id is like a project name_.
<p align="center">

https://user-images.githubusercontent.com/48597284/185809938-174b9e27-c1f6-406f-bdb0-912ebdbb80e0.mp4
  
</p>

Open pom.xml and add latest [Java Client](https://mvnrepository.com/artifact/io.appium/java-client) dependency.
remove junit and replace it with [TestNG](https://mvnrepository.com/artifact/org.testng/testng) dependency 

The Final dependencies looks like:
```md
  <dependencies>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.6.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>8.1.1</version>
</dependency>
  </dependencies>
```

<p align="center">
  <img src="https://user-images.githubusercontent.com/48597284/185945115-b011148d-9932-4994-8a8f-92c58028bcb6.png" width=50% height=50%>
</p>

---

### STEP 5: Create java class then set the DesiredCapabilities


1. After create a java class , create an object for Desired Capabilities
```md
DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
```

2. Set Capability as follow:

```md
desiredCapabilities.setCapability("appium:app","C:\\Users\\lo0ol\\eclipse-workspace\\AlertsinAndroidTesting\\Collect-data-Application.apk");
desiredCapabilities.setCapability("appium:deviceName", "23b9cb400c1c7ece");
desiredCapabilities.setCapability("appium:platformName", "Android");
desiredCapabilities.setCapability("appium:platformVersion", "10");
desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
desiredCapabilities.setCapability("appium:appPackage", "com.example.mahhid_collect_data");
desiredCapabilities.setCapability("appium:appActivity", "com.example.mahhid_collect_data.SplashScreen");
```

### STEP 6: Detect Elements
Go back to the Appium inspector and detect elements, then add them in the code
> After each action you did on your real device, you must refresh the Appium inspector to detect the screen and their elements

Allow location
```md
WebElement allowElement = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
 ```
<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/185959749-d29b48de-baa7-4fdb-8353-8f470b73216b.png" width=80% height=80%>
  
</p>


Alert more information
```md
WebElement moreDetail = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout"));
moreDetail.click(); 
```

<p align="center">

  <img src="https://user-images.githubusercontent.com/48597284/185980039-5106f22c-9a07-4c05-ac69-237b44d3708c.png" width=80% height=80%>
  
</p>

Get Alert Text
```md
String result = driver.findElement(AppiumBy.id("com.google.android.gms:id/message")).getText();
System.out.println("Alert text Is -> " + result);
```
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185980320-d81bab84-598e-4b96-a3c7-3f52df65e217.png" width=80% height=80%>

</p>

click on OK
```md
WebElement ok = driver.findElement(AppiumBy.id("android:id/button1"));
ok.click();
```
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185980510-f384ee7d-d876-4797-98cd-fb8e04898ab7.png" width=80% height=80%>

</p>


----

## Output Screenshots
<p align="center">

https://user-images.githubusercontent.com/48597284/185981858-b3fc0970-a15b-45a2-bee8-14be7247ce64.mp4

  
</p>
