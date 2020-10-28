#Human Benchmark
*Author: Annel Cota*

##Description
This is a game full of mini games that tests your reaction time, memory, 
and overall cognitive ability. Here is an overview of all the
games included.

###Aim Trainer
In this game, there are a total of 30 aim images that the user
has to click. The goal is to try to click through all of them as fast as possible.
Once all the images have been clicked, the average time taken is calculated.

###Chimp Test
In this game, there are squares created with numbers in ascending order that 
the user has to click on in that order. As each square is
clicked, it disapears. For the first round, all numbers are
visible to the user as each square is clicked. After the first
round and after the #1 square is clicked, all the squares turn black.
The number of squares increase after each round. If the user clicks
incorrectly, they get a strike. After strike 3, game over.

###Match Pairs
In this game, there are 12 different images used to create pairs of images. 
The goal is for the player to find all the pairs of images. The images are 
placed on a grid, without showing the image to the player until the user clicks 
on a certain image. Once clicked, it keeps showing the image until the player 
clicks on a new one. The user will keep clicking to try to find all the pairs in 
the fastest time they can.

###Number Memory
In this game, it shows a random number with a certain amount of 
digits to the user for only a certain amount of seconds. The 
player then has to re-type that number that was shown once it
disappears.

###Reaction Time
This game shows the user a red screen that turns green after
a random time. The user has to click a button once the screen 
turns green, and their reaction time is displayed. If the user 
clicks too early, before the screen turns green, they will be 
notified, and the game will be reset.

###Typing
This game gives the player a prompt which they have to copy by 
typing in the text area below the prompt given. Once they're 
done, their wpm will be calculated.

###Verbal Memory
This is a game where the user is shown a word and they have to 
tell whether it is a new word or a word they have already seen 
in the game. They have three lives and every time they get a 
word right, their score increases.

###Visual Memory
This game creates a grid of squares that has a certain amount 
of red squares. The red squares are shown to the player for 3 
seconds and then the grid is cleared(makes squares all black).
The player then has to click on the black squares that used to be 
red. The player can get it wrong 3 times but will lose a life 
after that. The player has 3 lives and then game over after that.

##Notes:
* I made the game as close to the website version as possible.
On the home screen, I added the same descriptions to the game
buttons that the website has.
* I was able to save the scores and get the high scores of
each game for the current game session, but if the application
is closed and restarted, the scores from the previous session
are not saved. Only the scores from the current session are stored
and shown in the Scores part of the home screen.

##Bugs & Things to Fix:
 * In the Chimp Test game, the squares sometimes overlap,
 but the game still works as it should.
 * In the Typing game, I was not able to highlight the single
 mistake, but while there is a mistake, the whole text turns
 red. The player is also notified on, the top right, that there
 is a mistake.
