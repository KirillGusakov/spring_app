# Spring MVC + Hibernate
#### The local library wants to switch to digital book registration. To you need to implement a web application for them. Librariansmust be able to register readers, issue thembooks and release books (after the reader returnsbook back to the library).
## Entity
#### **Person**: 
- full name (UNIQUE)
- year of birth
```postgresql
CREATE TABLE person (
	id SERIAL PRIMARY KEY,
	fio varchar(100) UNIQUE,
	birthday_date date
)
```
#### **Book**:
- title
- author
- year
```postgresql
create table book (
	id serial PRIMARY KEY,
	person_id int REFERENCES person(id),
	name varchar(50),
	author varchar(50),
	year date
)
```
#### Relationship between entities: One to Many. A person can have many books. The book may belong only one person. The database must have two tables - Person and Book. For all tablesset up automatic id generation.

**Required functionality:**
- Pages for adding, changing and deleting a person.
- Pages for adding, changing and deleting a book
- A page with a list of all people (people are clickable - when clicked, go to the person's page).
- A page with a list of all books (books are clickable - when clicked, go to the book page).
- A person's page, showing their field values ​​and a list of books they havetook it. If a person has not taken a single book, instead of the list there should be the text “Man I haven’t picked up a single book yet.”
- A book page that shows the values ​​of the fields of this book and the name of the person, who took this book. If this book was not taken by anyone, there should be the text "This
the book is free."
- On the book page, if the book was taken by a person, there should be a button next to his name
"Free the book." This button is pressed by the librarian when the reader returns this book back to the library. After clicking this button the book is again becomes free and disappears from a person’s list of books.
- On the book page, if the book is free, there should be a drop-down list (select) with all people and the "Assign book" button. This button is pressed by the librarian
when the reader wants to take this book home. After clicking this button, the book
must begin to belong to the selected person and must appear in his list books.
- All fields must be validated - using @Valid and Spring Validator if so required

# Maven Dependencies for project

```xml
  <dependencies>
    <!-- JUnit (Test scope) -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!-- Spring Web MVC -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>6.1.6</version>
    </dependency>

    <!-- Spring Web -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>6.1.6</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.32</version>
      <scope>provided</scope>
    </dependency>

    <!-- Thymeleaf Spring 6 -->
    <dependency>
      <groupId>org.thymeleaf</groupId>
      <artifactId>thymeleaf-spring6</artifactId>
      <version>3.1.2.RELEASE</version>
    </dependency>

    <!-- Hibernate Core -->
    <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>6.5.1.Final</version>
    </dependency>

    <!-- PostgreSQL JDBC Driver -->
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.2</version>
    </dependency>

    <!-- Spring ORM -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>6.1.6</version>
    </dependency>

    <!-- C3P0 Connection Pool -->
    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.5.5</version>
    </dependency>

    <!-- Jakarta Servlet API (Provided scope) -->
    <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
      <version>6.0.0</version>
      <scope>provided</scope>
    </dependency>

    <!-- Hibernate Validator -->
    <dependency>
      <groupId>org.hibernate.validator</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>8.0.1.Final</version>
    </dependency>
```
