# 📚 Lib System Dto

Welcome to the Library Management System! This application provides basic functionalities to manage users and books, including creating, fetching, and deleting records, as well as borrowing and returning books.

## 🚀 Features

### 👤 User Management

1. **Create a New User**
   - **Endpoint:** `POST /user`
   - **Description:** Add a new user to the system.
   - **Sample Request:**
     ```json
     {
       "name": "John Doe",
       "address": "123 Main St",
       "phone": "123-456-7890"
     }
     ```

2. **Fetch All Users**
   - **Endpoint:** `GET /user`
   - **Description:** Retrieve a list of all users in the system.

### 📚 Book Management

3. **Add New Book**
   - **Endpoint:** `POST /book`
   - **Description:** Add a new book to the library.
   - **Sample Request:**
     ```json
     {
       "title": "The Great Gatsby",
       "author": "F. Scott Fitzgerald",
       "isbn": "9780743273565"
     }
     ```

4. **Fetch All Books**
   - **Endpoint:** `GET /book`
   - **Description:** Retrieve a list of all books in the library.

5. **Fetch Specific Book**
   - **Endpoint:** `GET /book/{bookId}`
   - **Description:** Retrieve details of a specific book by its ID.

6. **Delete a Book**
   - **Endpoint:** `DELETE /book/{bookId}`
   - **Description:** Delete a specific book from the library by its ID.

### 🔄 Borrow and Return Books

7. **Borrow a Book**
   - **Endpoint:** `POST /book/{userId}/borrow/{bookId}`
   - **Description:** Borrow a book for a specific user by updating the book's status.
   - **Note:** The book's status will be updated to indicate it is borrowed by the specified user.

8. **Return a Book**
   - **Endpoint:** `POST /book/{userId}/return/{bookId}`
   - **Description:** Return a borrowed book, updating its status to available.
   - **Note:** The book's status will be updated to indicate it is available.

## 🛠️ Technologies Used

- **Spring Boot:** Backend framework to build the application.
- **Spring Data JPA:** For data persistence.
- **H2 Database:** In-memory database for development and testing.
- **SLF4J & Logback:** For logging.

## 📦 Setup and Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
- Build and run the application:
    mvn clean install
    mvn spring-boot:run


Access the application:
- The application will be running at http://localhost:8080.


## 🤝 Contributing

- Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or features you'd like to see added to the project.

## 📝 License
---------------------------------------------------------
- This project is licensed under the MIT License.
---------------------------------------------------------

## 📬 Contact

- Feel free to customize this template according to your project's specific requirements and implementation details. Let me know if you need further assistance or have any questions!




