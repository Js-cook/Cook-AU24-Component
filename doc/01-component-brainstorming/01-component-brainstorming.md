# Portfolio Part 1: Component Brainstorming

- **Name**: Jacob Cook
- **Dot Number**: cook.2112
- **Due Date**: 9/13 @ 4:10 PM EST

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

1. (3 points) Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. (3 points) Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. (4 points) Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

<!-- TODO: briefly talk about your interests then delete this comment.
Also, protip: you can preview what your response looks like by hitting
the magnifying glass icon in the upper-right corner or pressing CTRL+K and
then V. This kind of button combination is called a chord, for whatever
reason -->

In terms of career goals I'm a bit uncertain at the moment. I find topics like embedded systems development and networking particularly interesting but I also have experience in web and mobile development in my personal coding projects so I'm not particularly attached to one particular field. With regard to my hobbies, I'm a really active person so I like to run and row (I actually row competitively for OSU). Additionally, I love listening to and discussing music as well as doing independent software projects.

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component

To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
        - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
        - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: Music-Stats
  - **Description**:
    - The purpose of this component is to store and retrieve stats related to albums, tracks, or music artists. These stats can be added and retrieved by the client and this component could be used to store/process data received from API requests.
  - **Kernel Methods**:
    - `void setAlbumData(String title, String artist, String genre, int monthlyListeners)`: creates and stores a new album with the given data
    - `void setArtistData(String name, String genre, String nationality, int monthlyListeners)`: creates and stores a new artist with the given data
    - `void setTrackData(String name, String genre, String artist, double duration)`: creates and stores a new track with the given data
  - **Secondary Methods**:
    - `String getAlbumData(String name)`: fetches data for a given album and returns it in string form
    - `String getTrackData(String name)`: fetches data for a given track and returns it in string form
    - `String getArtistData(String name)`: fetches data for a given artist and returns it in string form
    - `void removeAlbum(String name)`: removes an album of the given name if present
    - `void removeTrack(String name)`: removes a track of the given name if present
    - `void removeArtist(String name)`: removes an artist of the given name if present
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - The component likely would be mutable as it needs to store information like the input albums, tracks, and artists as well as retrieve them.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Internal classes for data/response representation might be helpful for the client but I'm unsure about any specifics at the moment.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Field variables such as data structures might be helpful for storing and organizing the user inputs.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - I'm currently not super certain about all the methods that would need to belong to the kernel and secondary and some could be reorganized elsewhere.

- Component Design #2: Stat-calc
  - **Description**:
    - This component aims to take in coordinate points in 2D or 3D and provide functionality to perform basic calculations on the provided data. Such operations could be calculating measures of central tendency, distance between points, or even basic regression.
  - **Kernel Methods**:
    - `void setDimensions(int dimension)`: sets the dimensions of the data (establishes what dimensions all the coordinates should be)
    - `void addPoint(int... coords)`: takes given points and groups them into a pair
    - `void removePoint(int... coords)`: removes a given coordinate if present
  - **Secondary Methods**:
    - `double calcMean()`: calculates the mean given the existing coordinates
    - `String linearRegression()`: performs basic linear regression and returns the slope-intercept form of the best fit line as a string
    - `int[] findOutliers()`: finds and returns an array of all outliers
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - This component would be mutable to add/remove new coordinate pairs. The secondary methods would then perform operations on these existing pairs.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - An internal class could be created to represent the coordinate pairs, however, this could also be accomplished with nested data structures.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - A field variable could be used to hold all the coordinates similar to how `rep` was used in project 2 to hold the value of the NN.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - I'm still not quite sure what all the kernel methods will be but some kernel methods may be dedicated to finding/retrieving coordinates in which case those would be used prior to any calculation being done in the secondary methods.

- Component Design #3: Watchlist
  - **Description**:
    - This component aims to organize and track movies, TV shows, or tracks/albums that someone wishes to watch/listen to at some point. The user can add and remove items as well as return information about items currently in the watchlist.
  - **Kernel Methods**:
    - `void addItem(String name)`: adds item to the watchlist
    - `String removeItem(String name)`: removes existing item from the watchlist and returns it
    - `String removeAnyItem()`: removes an arbitrary item from the watchlist and returns it
  - **Secondary Methods**:
    - `String randomSelection()`: selects a random item from the watchlist
    - `String[] displayWatchlist()`: returns the contents of the watchlist in the form of an array
    - `void addBulkItems(String... items)`: adds multiple items to the watchlist at once
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - This component would be mutable as items would have to be added and removed from the watchlist based on the client's inputs. The kernel methods would primarily be concerned with mutating the contents of the watchlist
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - I'm currently unsure if internal classes would be useful for this.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - The component would need a field variable to represent the watchlist itself. This could likely be accomplished through a queue, sequence, or list.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - All secondary methods related to searching or retrieving items from the watchlist will be implemented with the `removeItem()` method. Additionally, any methods related to adding to the watchlist will be implemented with the `addItem()` method.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.

### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
