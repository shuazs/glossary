Glossary Console Application

A console-based glossary program built for CS 2420 (Data Structures & Algorithms).
The program loads a glossary file and allows users to interactively view, add, edit, and remove word definitions through a menu-driven interface.

This project focuses on efficient data structures, clean abstraction, and practical algorithmic performance on large datasets.

Features

Load glossary data from a formatted input file

Look up words and view multiple definitions

Add, edit, and delete definitions

Handle multiple parts of speech per word

Menu-driven console interface

Designed for scalability with large glossaries

How It Works

The glossary file path is provided as a command-line argument

The program parses the file and stores entries in memory

Users interact with the glossary via numbered menu options

Operations are optimized using appropriate data structures covered in CS 2420

Example Usage
java Main glossary.txt


Sample interaction:

Select an option:
1) Search for a word
2) Add a definition
3) Edit a definition
4) Delete a definition
5) Exit

Data Structures Used

Map ADT for fast word lookup

Tree / List structures for storing multiple definitions per word

Comparator-based ordering where applicable

These choices balance runtime efficiency, clarity, and ease of implementation.

Running Time Overview (High-Level)
Operation	Expected Runtime
Word lookup	O(log n) or O(1)
Add definition	O(log n)
Delete definition	O(log n)
Display definitions	O(k)

(Where n is number of words and k is definitions per word.)

Project Context

Course: CS 2420 – Data Structures & Algorithms

Focus: ADTs, performance analysis, clean design
