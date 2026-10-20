# Music School Management System

A Java desktop application for registering and managing the musicians and instructors of a music school ("Harmony Music Center"). Built as a programming project.

## Features

- Register musicians (guitarists or pianists) with name, age, experience year and monthly fee, together with their instructor (name, specialization, phone)
- Display all registered records
- Separate search screen for finding musicians
- Search by name or ID, delete a musician by ID
- Calculate total monthly revenue and track which instruments are taught

## Technologies

- Java
- Swing (`javax.swing`) for the graphical interface
- Developed in the Eclipse IDE

## Project structure

| File | Purpose |
|---|---|
| `Main.java` | Program entry point |
| `MainFrame.java` | Main registration window (Swing) |
| `SearchFrame.java` | Search window |
| `MusicCenterSystem.java` | Stores the musicians and implements add, delete, search and revenue calculation |
| `Musician.java` | Base class for all musicians |
| `Guitarist.java`, `Pianist.java` | Musician subclasses |
| `Instructor.java` | Instructor class |
| `Playable.java` | Interface for playable instruments |

## How to run

1. Clone the repository: `git clone https://github.com/dfnguclu/music-school-management-system.git`
2. Open the folder in Eclipse (or any Java IDE)
3. Run `Main.java`

## Notes

Data is stored in memory only, so records are not saved when the program is closed.

## Author

Defne Güçlü, Computer Technology and Information Systems student at Bilkent University
