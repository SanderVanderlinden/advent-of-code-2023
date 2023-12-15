# Advent of Code 2023 Solutions

This repository contains my solutions for the [Advent of Code 2023](https://adventofcode.com/2023) challenges. Advent of Code is an annual event with daily coding puzzles from December 1st to December 25th. Each puzzle provides an opportunity to improve programming skills and problem-solving abilities.

## About Advent of Code

Advent of Code is created by Eric Wastl. It's designed to offer fun, interesting problems that can be solved in any programming language. The event is open to coders at all skill levels.

## Repository Structure

Each day's challenge is stored in a separate directory named `DayXX` where `XX` is the day of the challenge. For example, `Day01`, `Day02`, etc. Each directory will typically include:

- A `README.md` file explaining the day's challenge.
- Solution files in my chosen programming language.
- Any input data provided by Advent of Code for the challenge.

## How to Use This Repository

You can use this repository as a reference for your own Advent of Code solutions or to see different approaches to problem-solving. Feel free to explore the code and provide feedback or ask questions through issues and pull requests.

## Contributing

While the main purpose of this repository is personal skill development, I'm open to contributions in the form of:

- Optimizations or alternative solutions to problems.
- Fixes for any bugs or issues found in the solutions.
- Improvements to documentation or explanations.

Please feel free to fork the repository and submit pull requests.

## License

This project is open-source and available under the [MIT License](https://en.wikipedia.org/wiki/MIT_License).

## Acknowledgments

- Thanks to Eric Wastl for creating and maintaining Advent of Code.
- Thanks to all who contribute to this repository.

Happy coding!

Sander

---


## Setting Up SonarQube with Docker for AdventOfCode2023

To set up SonarQube for the AdventOfCode2023 project, follow these steps:

### Prerequisites
- Docker and Docker Compose installed on your machine.
- Access to a terminal or command-line interface.

### Step 1: Create a .env File
1. In the root directory of your project, create a `.env` file.
2. Add the following line to the file, replacing `xxxx` with your desired port number:

   ```
   DOCKER_PORT=xxxx
   ```

### Step 2: Start SonarQube with Docker Compose
Run the following command in your terminal:

```
docker-compose up
```

This command starts SonarQube and binds it to the port specified in the `.env` file.

### Step 3: Create a SonarQube Account
1. Open your web browser and go to `http://localhost:xxxx`, where `xxxx` is the port number you set in the `.env` file.
2. Follow the instructions to create a SonarQube account.
3. Once logged in, set up a new project for local analysis and name it `AdventOfCode2023`.
4. Generate a token for project analysis.

### Step 4: Set Environment Variables
Set the SonarQube URL and token as environment variables on your machine. These variables will be used by the Gradle build script.

For Windows:
```cmd
set SONARQUBE_URL=http://localhost:xxxx
set SONARQUBE_TOKEN=your_generated_token
```

For macOS/Linux:
```bash
export SONARQUBE_URL=http://localhost:xxxx
export SONARQUBE_TOKEN=your_generated_token
```

### Step 5: Execute Tests and Generate Reports
Run the following Gradle commands to execute tests and generate test coverage reports:

```
./gradlew test jacocoTestReport
```

### Step 6: Run SonarQube Analysis
Finally, execute the SonarQube analysis with the following command:

```
./gradlew sonarqube
```

After this step, SonarQube will process the code analysis and coverage reports. You can view the results on your SonarQube dashboard.


---

[Go to Day 1 →](app/src/main/resources/day01/README.md)
