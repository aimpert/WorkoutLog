# WorkoutLog

Weightlifting Log app for Android. The concept is to have something I can use that is basic and has the tools and a clean UI for logging my workouts. This project
will help me develop skills for app development through Java and Android Studio, as well as UI design, and possible use of a database system such as SQL. 
Fundamentally, a workout log app is something that can be contionously expanded upon after creating the core features. Initially the app is meant to be a 5/3/1
weightlifting app as it is the current routine I am running. Therefore modularity is something to work on, as allowing the user to customize their workout plan 
beyond 5/3/1 will add a ton of flexibility and depth to the application.

**August Priority List:**

~~1. Create a functioning training max (TM) and one rep max (1RM) calculator.~~

~~2. Store this data somewhere so that it can be accessed between activities.~~ - **08/19**
      
      Current lifts are stored in an object, which are then saved in SharedPreferences and
      can not only be accessed through activities but upon closing the application as well.

~~3. First launch window.~~ - **08/31**

      Used SharedPreferences to check whether the app is on its first launch, same version,
      or an upgraded version.
      
**September Priority List:**

1. Create a flexible home page.

      * ~~Window with current 1RMs~~
      * ~~Edit 1RMs button~~ - **08/31**
      * ~~List of current week's days~~ - **09/02**
      * Toolbar to access TM calculator, 1RM calculator
      * UI Improvements/Usability

2. Choose a system for archiving old data (previous 1RMs, TMs).

3. Develop a log for these old numbers.

4. Clean and optimize application.

      * Error handling
      * Test cases
      * Usability
