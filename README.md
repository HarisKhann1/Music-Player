```markdown
# Music Player

This repository contains a Java program for a simple music player.

## Description

The `Musicplayer` class provides functionality for managing a playlist of music tracks. It allows users to perform the following actions:

- Add music tracks to the playlist.
- Play tracks forward and backward.
- Display the playlist.
- Search for specific tracks.
- Delete tracks from the playlist.

The program uses a circular doubly linked list to store the playlist, allowing for efficient traversal and manipulation of the playlist.

## Usage

To use the music player, follow these steps:

1. Clone the repository to your local machine.
2. Compile the `Musicplayer.java` file using a Java compiler.
3. Run the compiled program.

The program will display a menu with options to perform various actions. Follow the prompts to interact with the music player.

## Example

```java
// Create a new Musicplayer object
Musicplayer mp3 = new Musicplayer();

// Add music tracks to the playlist
mp3.insert_at_begining();

// Play a track forward
mp3.playForward();

// Play a track backward
mp3.playBackward();

// Display the playlist
mp3.display();

// Search for a track
mp3.SearchMusic();

// Delete a track from the playlist
mp3.DeleteMusic();
```

## Requirements

- Java Development Kit (JDK)
