# Task Manager API

A RESTful API built with Java and Spring Boot for task management.

## About the Project

This project was created to practice and strengthen backend development concepts, evolving from core Java and OOP fundamentals to building REST APIs with database persistence.

The application allows users to:

* create tasks
* list all tasks
* search tasks by ID
* search tasks by title
* update tasks
* delete tasks

## Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Postman

## Project Architecture

The project follows a layered architecture:

* **Controller** → handles HTTP requests
* **Service** → contains business logic
* **Repository** → communicates with the database
* **Model** → represents the Task entity

## Task Structure

Each task contains:

* `id`
* `title`
* `description`
* `completed`

## API Endpoints

### Create Task

**POST** `/tasks`

Example request body:

```json
{
  "title": "Study Spring",
  "description": "Learn JPA and H2",
  "completed": false
}
```

---

### List All Tasks

**GET** `/tasks`

---

### Get Task by ID

**GET** `/tasks/{id}`

---

### Get Task by Title

**GET** `/tasks/title/{title}`

---

### Update Task

**PUT** `/tasks/{id}`

Example request body:

```json
{
  "title": "Study more Spring",
  "description": "Update knowledge",
  "completed": true
}
```

---

### Delete Task

**DELETE** `/tasks/{id}`

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/Eduardo509/taskManager.git
```

2. Navigate to the project folder:

```bash
cd taskManager
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

Or run it directly from your IDE.

## H2 Database Console

Access:

```text
http://localhost:8080/h2-console
```

Configuration:

* JDBC URL: `jdbc:h2:mem:taskdb`
* User: `sa`
* Password: (leave blank)

