# Typing-Tester

Typing-Tester is a command-line application implemented in Java that allows users to test their typing speed and accuracy. It provides a variety of typing tests, including tests with time limits and tests based on typing sentences or paragraphs.

## Features

- Different types of typing tests: single words, sentences, and paragraphs.
- Time-limited tests: Test your typing speed under pressure with a set time limit.
- Accuracy calculation: The application calculates the percentage of words typed correctly.
- Speed calculation: The application calculates your typing speed in words per minute.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 11 or later
- Maven

### Installation

1. Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/Olliewakeford/Typing-Tester.git
```

2. Change into the project directory:

```bash
cd Typing-Tester/TestTypingSpeed
```

3. Build the project using Maven:

```bash
mvn compile
```

4. Run the application:

```bash
mvn exec:java -Dexec.mainClass="CommandLineTypingTest.Main"
```

## Usage
After starting the application, follow the prompts in the command line to start a typing test. The application will provide the text to type and calculate your speed and accuracy once you've completed the test.

## Development
This was developed for my course Programming in Java as the semester project.