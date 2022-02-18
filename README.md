# CodingChallenge
CodingChallenge is a simple SDK. Which can provide you information related to Start Wars APi.

How to Run the app:
- Download the project
- Import project in the android studio
- It should build now ideally.
- Run the Project. Done!

Implementation Details
- Marked internal (classes, interface etc) which are only used inside SDK.
- Exposed CodingChallenge, act as single entry point/usage to the SDK.
- Easy to integrate in apps as Init SDK in Application class and use wherever needed using same object.
- Seprate models for public usage and response api. Like FilmRes and Film.

Tech Used:
- Retrofit for networking calls
- Moshi for json parsing
- Builder Pattern to instantite
- Kotlin

Things Can be Improved (If given time)
- Eror handling of network calls
- Queue management of network calls if fails for some xyz reason
- Give more control to network calls to end-user. Like schedule, cancel, etc
- DI (Make use of Dependency Injection)
- Unit Testing
