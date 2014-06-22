intaractiveViewPager
====================

This is an Android project which goal is to show how to make an app with an interactive View Pager, like Facebook app.


Description
====================
When you want to develop an app with a View Pager, you just don't know how to make it interactive.<b>How do I make it to go to another screen, but without losing the tabs?</b> If you see the Skype app, they just go to another screen withou tabs to avoid the confusion of the interaction. What Facebook app does looks more intuitive. Lets make some scenarios about it:

<h5>Your app has 2 Tabs: A and B. It has also two fragments: 1 and 2. The fragment 1 has a button which goes to the fragment 2. The initial Tab is the Tab A. Fragment 1 is the initial fragment for both Tabs.</h5>

Scenario 1
====================
<i>Tab A (Initial), fragment 1 -> Fragment 2. Options:</i>
<ul>
<li>on Back Pressed: Goes to Fragment 1.</li>
<li>on A tab Pressed: Goes to Fragment 1.</li>
<li>on B tab Pressed: goes do Tab B (fragment 1) and destroy the views on A tab (it means that now the A tab just has the fragment 1)</li>
</ul>

Scenario 2
====================
<i>Tab A (Initial), fragment 1 -> Tab B, fragment 1. Options:</i>
<ul>
<li>on Back Pressed: Goes to Tab A (initial page).</li>
<li>on A tab Pressed: Goes to Tab A.</li>
<li>on B tab Pressed: It's already in the initial screen of the tab pressed. It doesn't do anything.</li>
</ul>

Scenario 3
====================
<i>Tab A (Initial), fragment 1 -> Tab B, fragment 1 -> fragment 2. Options:</i>
<ul>
<li>on Back Pressed: Goes to Tab B, fragment 1.</li>
<li>on A tab Pressed: Goes to Tab A and destroy the views on B tab (it means that now the B tab just hast the fragment 1, the initial view).</li>
<li>on B tab Pressed: Go to the home screen of the tab (fragment 1).</li>
</ul>

Conclusion
====================
The basic difference between the traditional viewpager is because you force the user to pass through the initial tab before exit. Besides, ViewPagerAdapters are difficult to deal with the back pressed. So this code is to help people who are trying to make something similar.

Content
====================

The project content is the MainActivity, which is responsable to initialize the viewPager, the Fragment One and Two of the scenarios example above. The ViewPagerAdapter is inside the Activity. I'm using the appCompat support library in this project.

