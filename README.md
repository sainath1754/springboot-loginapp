# 🔐 Spring Boot Login System

A simple, secure login and registration web application built with **Spring Boot 3.5.13** and **MySQL**.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Spring Boot 3.5.13 |
| Security | Spring Security 6 |
| Database | MySQL 8 |
| ORM | Spring Data JPA + Hibernate 6 |
| Frontend | Thymeleaf |
| Build Tool | Maven |
| Language | Java 21 |

---

## 📁 Project Structure

```
loginapp/
├── src/main/java/com/example/loginapp/
│   ├── config/
│   │   ├── PasswordConfig.java       ← BCrypt password encoder bean
│   │   └── SecurityConfig.java       ← Spring Security rules
│   ├── controller/
│   │   └── AuthController.java       ← HTTP route handlers
│   ├── entity/
│   │   └── User.java                 ← Database entity
│   ├── repository/
│   │   └── UserRepository.java       ← Database queries
│   └── service/
│       ├── UserService.java          ← Service interface
│       └── UserServiceImpl.java      ← Business logic
├── src/main/resources/
│   ├── templates/
│   │   ├── login.html
│   │   ├── register.html
│   │   └── home.html
│   └── application.properties
└── pom.xml
```

---

## ✨ Features

- ✅ User Registration with duplicate username check
- ✅ Secure Login with Spring Security
- ✅ BCrypt password hashing (passwords never stored as plain text)
- ✅ Session-based authentication
- ✅ Login success redirect to Home page
- ✅ Logout functionality
- ✅ Form validation and error messages

---

## ⚙️ Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/loginapp.git
cd loginapp
```

### 2. Create the MySQL database
```sql
CREATE DATABASE logindb;
```

### 3. Update `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/logindb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run the app
```bash
mvn spring-boot:run
```

### 5. Open in browser
```
http://localhost:8080/register   ← Create an account
http://localhost:8080/login      ← Login
```

---

## 🔄 App Flow

```
/register  →  Fill form  →  Account created  →  /login
/login     →  Enter credentials  →  Success  →  /home
/home      →  Click Logout  →  /login
```

---

## 🔒 Security

- Passwords are hashed using **BCrypt** before storing in the database
- All routes except `/login` and `/register` require authentication
- Spring Security handles session management automatically
- Unauthorized access redirects to the login page

---

## 👤 Author

**Sainadh**  
📧 Sainadh1754@gmail.com
