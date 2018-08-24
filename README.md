# BuildItBigger

#### BuildItBigger is an Android app developed during the Udacity's Android Nanodegree which tells a joke using a Google Cloud Endpoints development server. The final goal for this app was to understand and customize the behavior of the Gradle build tool as well as the steps involved in the creation of product flavors, build types, Java libraries, Android libraries, keystores, keys and signing configs including automatic signing.

#### The app has free and paid versions. The only difference between them is the presence of advertisements in the free version.

</br>

<img src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2F1.png?alt=media&token=f789cdff-8126-43d2-95f1-c950756c0360" width="420" height="692" style="margin:4px"> <img/><img src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2F2.png?alt=media&token=1612d58a-19c9-4d28-ae79-433b4f8d6a0a" width="420" height="692" style="margin:4px">
<img src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2F3.png?alt=media&token=cf3c0ec4-eac5-482a-9c3f-b171e35f1cc7" width="420" height="692" style="margin:4px"> <img/><img
src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2F4.png?alt=media&token=f3ae25c8-bf5b-4be6-a316-ea28cb4605f0" width="420" height="692" style="margin:4px">

## Getting Started

#### These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

#### BuildItBigger was developed using Android Studio IDE so you must install it in your computer before proceeding:

###### https://developer.android.com/studio/

## Next Steps

#### You can proceed to start Android Studio and import the project, but before installing the application on your Android device there are some setup steps you need to do. They are explained in the next paragraphs.

#### In the ***strings.xml*** file of your app module you need to change the value of ***local_ip_address*** so it can match the IP of your local machine. You can verify your IP by typing ***ipconfig*** in a command prompt window. Check this link for assistance:

###### https://www.softwareok.com/?seite=faq-Windows-Console&faq=2

#### BuildItBigger requires that the server code is running before the **TELL JOKE** button is pressed. Otherwise, a connection error will occur. The Google Cloud Endpoints development server is controlled by using two gradle tasks called ***appengineStart*** to start the server and ***appengineStop*** to stop it. You can check if the server is running by opening your web browser and typing ***localhost:8080***. Check the images below for clarification:

</br>
<img src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2Fdevappserver-endpoints.png?alt=media&token=70c58970-00e0-49fb-bd6e-549d2bc4269b" style="margin:4px">

<img src="https://firebasestorage.googleapis.com/v0/b/inventoryapp-c8633.appspot.com/o/BuildItBigger%2FGCE-server-gradle-tasks.png?alt=media&token=9735ed5c-6743-4dc0-8dea-ac1142b7a1ac" style="margin:4px">

#### As mentioned before, BuildItBigger has two product flavors. Therefore you need to select which version to install (free or paid). Also, make sure your Android device and your local machine are connected to the same network. A network mismatch will result in a connection error. 

#### Once all the previous steps are finished and reviewed, you can proceed to install the application on your Android device.

## Compatibility

#### Minimum Android SDK: BuildItBigger requires a minimum API level of 15.
#### Compile Android SDK: BuildItBigger requires you to compile against API 27 or later.

## Getting Help

#### To report a specific problem or feature request, open a new issue on Github. For questions, suggestions, or anything else, email to: arturo_lpc@hotmail.com.

## Author

#### Daniel Bedoya - @engspa12 on GitHub

## License

#### See the LICENSE file for details.
