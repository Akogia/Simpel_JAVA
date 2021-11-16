import { createConnection, createPool } from "mysql";
import express from "express";

const app = express();

//var connection = createConnection('jdbc:mysql://localhost:3306/mydatabase');

const connection = createPool({
    connectionLimit: 5,
    host: "localhost",
    user: "root1",
    password: "",
    database: "mydatabase"
});

// connect to the database
/*** 
 * This database has been created:
 * CREATE TABLE `mydatabase`.`logindata` (
 * `user_id` INT NOT NULL AUTO_INCREMENT,
 * `user_email` VARCHAR(45) NOT NULL,
 * `user_pass` VARCHAR(45) NOT NULL,
 * PRIMARY KEY (`user_id`));
 * **/
connection.getConnection();

console.log(connection);

//connection.end();