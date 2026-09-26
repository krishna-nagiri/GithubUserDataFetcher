# GitHub User Data Fetcher

A Java-based application that fetches GitHub user information using the GitHub REST API and processes the JSON response using Jackson.

## 📌 Overview

**GitHub User Data Fetcher** is a Java application built to demonstrate how to consume a REST API, receive JSON data, parse the response, and extract meaningful user information.

The application sends an HTTP request to the GitHub API for a given GitHub username and processes the returned JSON response using the Jackson JSON processing library.

## 🚀 Features

* Fetch GitHub user information using the GitHub REST API
* Send HTTP GET requests from Java
* Handle HTTP responses and status codes
* Parse JSON responses using Jackson
* Extract specific user details from the JSON response
* Display the fetched information in a readable format
* Demonstrates basic API integration in Core Java

## 🛠️ Technologies Used

* **Java**
* **GitHub REST API**
* **Jackson Databind**
* **HTTP Client**
* **JSON**
* **Git & GitHub**

## 📂 Project Structure

```text
GithubUserDataFetcher/
│
├── GitHubUserDataFetcher/
│   └── src/
│
└── README.md
```

The project is organized into separate components for making the API request, processing the response, and running the application.

## 🔄 Application Flow

```text
User Input
    ↓
GitHub Username
    ↓
GitHub REST API
    ↓
HTTP GET Request
    ↓
JSON Response
    ↓
Jackson ObjectMapper
    ↓
Extract User Information
    ↓
Display Result
```

## 🔗 API

The application uses the GitHub REST API to retrieve public user information.

Example API endpoint:

```text
https://api.github.com/users/{username}
```

For example:

```text
https://api.github.com/users/krishna-nagiri
```

## 📦 Jackson Dependency

The project uses Jackson Databind for JSON parsing.

If you are using Maven, add the following dependency:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.19.2</version>
</dependency>
```

> Use the Jackson version configured in your project if it differs from the example above.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/krishna-nagiri/GithubUserDataFetcher.git
```

### 2. Open the project

Open the project in your preferred Java IDE, such as:

* Eclipse
* IntelliJ IDEA
* VS Code

### 3. Configure dependencies

Make sure the required Jackson libraries are available in the project classpath.

If using Maven:

```bash
mvn clean install
```

### 4. Run the application

Run the main Java class.

Provide the GitHub username when prompted, or use the username configured in the application.

## 📊 Example Output

```text
=========== Initiating Connection ============

Status Code : 200

=========== User Information ================

Name       : Krishna Nagiri
Username   : krishna-nagiri
Profile    : https://github.com/krishna-nagiri
Followers  : ...
Following  : ...
Public Repos: ...
Location   : ...
```

The exact output depends on the information returned by the GitHub API for the requested user.

## 🧠 Concepts Practiced

This project was created to practice and understand:

* REST API consumption
* HTTP communication in Java
* JSON parsing
* Jackson `ObjectMapper`
* `JsonNode`
* Exception handling
* HTTP status code handling
* Working with external APIs
* Java project structure
* Maven dependency management
* Git and GitHub

## 🔮 Future Improvements

Possible improvements for the project include:

* Add support for fetching repository information
* Display the user's public repositories
* Fetch follower and following details
* Add better exception handling
* Handle invalid GitHub usernames
* Add API rate-limit handling
* Convert the application into a Spring Boot REST application
* Store fetched user information in a database
* Add unit tests using JUnit

## 👨‍💻 Author

**Murali Krishna Nagiri**

GitHub:
https://github.com/krishna-nagiri

## 📄 License

This project is created for learning and development purposes.
